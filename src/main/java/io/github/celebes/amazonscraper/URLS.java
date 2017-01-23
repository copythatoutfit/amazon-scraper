package io.github.celebes.amazonscraper;

public class URLS {

	public static String getWomenClothingDressesUrl(Category category, int page) {
		switch(category) {
		case WOMEN_CLOTHING_DRESSES_CASUAL:
			return "https://www.amazon.com/gp/search/ref=sr_pg_" + page + "?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024%2Cn%3A2346727011%2Cp_72%3A2661618011&page=" + page + "&bbn=1045024&ie=UTF8&qid=1485088718";
		case WOMEN_CLOTHING_DRESSES_WORK:
			return "https://www.amazon.com/s/ref=sr_pg_" + page + "?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024%2Cn%3A2346728011%2Cp_72%3A2661618011&page=" + page + "&bbn=1045024&ie=UTF8&qid=1485089374";
		case WOMEN_CLOTHING_DRESSES_COCKTAIL:
			return "https://www.amazon.com/gp/search/ref=sr_pg_" + page + "?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024%2Cn%3A11006703011%2Cp_72%3A2661618011&page=" + page + "&bbn=1045024&ie=UTF8&qid=1485089393";
		case WOMEN_CLOTHING_DRESSES_FORMAL:
			return "https://www.amazon.com/s/ref=sr_pg_" + page + "?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024%2Cn%3A11006704011%2Cp_72%3A2661618011&page=" + page + "&bbn=1045024&ie=UTF8&qid=1485089484";
		case WOMEN_CLOTHING_DRESSES_WEDDING:
			return "https://www.amazon.com/gp/search/ref=sr_pg_" + page + "?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024%2Cn%3A2969486011%2Cp_72%3A2661618011&page=" + page + "&bbn=1045024&ie=UTF8&qid=1485089501";
		case WOMEN_CLOTHING_DRESSES_PROM:
			return "https://www.amazon.com/s/ref=sr_pg_" + page + "?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024%2Cn%3A11006705011%2Cp_72%3A2661618011&page=" + page + "&bbn=1045024&ie=UTF8&qid=1485089520";
		case WOMEN_CLOTHING_DRESSES_CLUB:
			return "https://www.amazon.com/gp/search/ref=sr_pg_" + page + "?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A1040660%2Cn%3A1045024%2Cn%3A11006702011%2Cp_72%3A2661618011&page=" + page + "&bbn=1045024&ie=UTF8&qid=1485089535";
		}
		// nigdy sie nie powinno zdarzyc xD
		return null;
	}
	
}
