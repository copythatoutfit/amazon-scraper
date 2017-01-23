package io.github.celebes.amazonscraper;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.kevinsawicki.http.HttpRequest;

public class App {
	
	public static final String IMG_FOLDER_MAIN = "F:\\amazon_imgs\\";
	
	private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) {
		new App();
	}

	public App() {
		
		for(Category c : Category.WOMEN_CLOTHING_DRESSES_ARRAY) {
			System.out.println(getCurrentTime() + c + "...");
			long before = System.nanoTime();
			
			downloadAllImagesFromCategory(c);
			
			long after = System.nanoTime();
			System.out.println(getCurrentTime() + (after-before)/1000000000 + " [s]\n");
		}
	}

	public void downloadAllImagesFromCategory(Category category) {
		String firstPageUrl = URLS.getWomenClothingDressesUrl(Category.WOMEN_CLOTHING_DRESSES_CASUAL, 1);
		String firstPageBody = HttpRequest.get(firstPageUrl).header("User-agent", "Mozilla/5.0").body();
		Document firstPage = Jsoup.parse(firstPageBody);
		int totalPages = Integer.valueOf(firstPage.getElementsByClass("pagnDisabled").text());
		//System.out.println("totalPages = " + totalPages);

		List<ShopItem> shopItemsJSON = new ArrayList<>();

		for (int i = 1; i <= totalPages; i++) {
			System.out.println(getCurrentTime() + "Strona [" + i + " z " + totalPages + "] (" + String.format("%.2f", (i*1.0/totalPages*1.0)*100.0) + "%)");
			String url = URLS.getWomenClothingDressesUrl(Category.WOMEN_CLOTHING_DRESSES_CASUAL, i);

			String resultId = "resultsCol"; // z tego wez wszystkie <img>

			String body = HttpRequest.get(url).header("User-agent", "Mozilla/5.0").body();
			Document page = Jsoup.parse(body);

			Element resultList = page.getElementById(resultId);

			Elements shopItems = resultList.getElementsByClass("s-result-item");
			// System.out.println(shopItems.get(0).toString());
			for (Element shopItem : shopItems) {
				String asin = shopItem.attr("data-asin");
				//System.out.println("asin = " + asin);

				List<String> imgUrls = new ArrayList<>();
				imgUrls.add(shopItem.getElementsByTag("img").get(0).attr("src"));
				Elements additionalImgs = shopItem.getElementsByAttribute("data-search-image-load");
				for (Element element : additionalImgs) {
					String imgUrl = element.attr("data-search-image-source");
					if (!imgUrl.trim().isEmpty())
						imgUrls.add(imgUrl);
				}

				//imgUrls.forEach(System.out::println);
				for (int kek = 0; kek < imgUrls.size(); kek++) {
					downloadImg(imgUrls.get(kek), asin, kek, category);
				}

				shopItemsJSON.add(new ShopItem(asin, imgUrls));
				//System.out.println();
			}

			//if (i == 2) break;
		}
	}
	
	private String getCurrentTime() {
		return "[" + dateFormat.format(new Date()) + "] ";
	}

	private void downloadImg(String url, String asin, int number, Category category) {
		HttpRequest request = HttpRequest.get(url);
		File file = null;
		if (request.ok()) {
			File dir = new File(IMG_FOLDER_MAIN + category + "\\");
			if(!dir.exists()) dir.mkdirs();
			file = new File(IMG_FOLDER_MAIN + category + "\\" + asin + "_" + number + ".jpg");
			request.receive(file);
		}
	}
}
