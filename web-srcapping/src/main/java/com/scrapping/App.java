package com.scrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {       
        final Document document = Jsoup.connect("https://www.tokopedia.com/p/handphone-tablet/handphone").get();

        System.out.println(document.outerHtml());
    }
}
