import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test2 {

    public static void main(String[] args) {
        String url = "https://www.avito.ru/moskva?cd=1&q=%D0%B3%D0%B8%D1%82%D0%B0%D1%80%D0%B0";

        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                    .referrer("https://www.google.com")
                    .get();
            Elements items = document.select("div.iva-item-body-GQomw");

            System.out.printf("%-50s %-20s %-15s %-20s%n", "Название", "Город", "Цена", "Продавец");
            for (Element item : items) {
                String title = item.select("h3.styles-module-root-s3nJ7").text();
                String city = item.select("p.styles-module-root-s4tZ2 span").text();
//                String price = item.select("strong.styles-module-root-LEIrw span").text();
//                String seller = item.select("div.styles-module-size_s-kPWOk").text();

                System.out.printf("%-50s %-20s %-15s %-20s%n", title, city);//, price, seller);

                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
