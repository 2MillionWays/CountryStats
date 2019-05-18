package ua.com.codespace;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Document doc = null;
        try {
            doc = Jsoup.connect("http://gtmarket.ru/ratings/quality-of-life-index/info").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(doc);
        //Element table = doc.select("tbody").get(2);
        Element element = doc.select("table[class=table-data]").first();
        Elements table = element.select("tr:gt(0)");
        for (Element ss : table){
            System.out.println(ss.select("td").eq(1).text());

        }

        /*DataExtraction extraction = new DataExtractionImpl();
        Elements elements = extraction.getLifeQualityIndex();
        for (Element element : elements){
            System.out.println(element);
            break;
        }*/
    }
}
