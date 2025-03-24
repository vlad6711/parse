package stpk.parse;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
    public static void main( String[] args ) throws IOException{
        Document doc = Jsoup.connect("https://stepik.org/lesson/700398/step/2?unit=700342").get();
        String title = doc.title();
        System.out.println("Title : " + title);
    }
}
