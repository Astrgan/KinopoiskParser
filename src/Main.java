import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Document doc = null;
        try {

            doc = Jsoup.connect("https://www.kinopoisk.ru/film/otryad-samoubiyts-2016-468522/").get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();
        System.out.println("Title : " + title);


        Element table = doc.select("table").first();

        Elements rows = table.select("tr");

        for (int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i); //по номеру индекса получает строку
            Elements cols = row.select("td");// разбиваем полученную строку по тегу  на столбы
            System.out.print(cols.get(0).text() + ": ");// первый столбец
            System.out.print(cols.get(1).text());

            System.out.println();
        }
    }
}
