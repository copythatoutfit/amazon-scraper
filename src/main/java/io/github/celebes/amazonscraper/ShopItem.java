package io.github.celebes.amazonscraper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopItem implements Serializable {
	
	private static final long serialVersionUID = -2477660601831482614L;
	
	private String asin;
	private List<String> imgUrls;
	
	public ShopItem() {
		
	}
	
	public ShopItem(String asin, List<String> imgUrls) {
		this.asin = asin;
		this.imgUrls = imgUrls;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public List<String> getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}

	@Override
	public String toString() {
		return "ShopItem [asin=" + asin + ", imgUrls=" + imgUrls.toArray() + "]";
	}
	
	

}
