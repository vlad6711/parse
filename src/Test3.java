import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test3 {

    public static void main(String[] args) {
        String url = "https://dominodomoy.ru/";

        try {
            Document document = Jsoup.connect(url).get();
            Elements items = document.select("div.menu");

            System.out.printf("%-50s %-20s %-15s", "Название", "Цена", "Ссылка на картинку");
            System.out.println();
            for (Element item : items) {
                String title = item.select("a.ddish__link").text();
                String price = item.select("div.ddish__sum").text();
                String link = item.select("img.src").text();

                System.out.printf("%-50s %-20s %-15s", title, price, link);

                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
