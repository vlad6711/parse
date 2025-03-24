package stpk.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test1 {
    public static void main(String[] args) {
        String url = "https://www.krylatskoye.ru/content/ratings/2021/09/0928.html"; // Замените на URL вашего сайта

        try {
            // Подключаемся к веб-странице и получаем HTML-документ
            Document document = Jsoup.connect(url).get();

            // Находим таблицу на странице
            Element table = document.select("table").first(); // Измените селектор, если таблица не первая на странице

            // Получаем все строки таблицы
            Elements rows = table.select("tr");

            // Проходим по каждой строке, начиная со второй (если первая строка - заголовок)
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");

                // Получаем название города из второго столбца
                if (cols.size() > 1) {
                    String cityName = cols.get(1).text();
                    System.out.println(cityName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
