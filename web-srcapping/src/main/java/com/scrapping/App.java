package com.scrapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }


    public static void generateCsvFile(List<String[]> data) {
  
    // first create file object for file placed at location
    // specified by filepath
    File file = new File("./scrapping.csv");

    try {
        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter(file);
  
        // create CSVWriter object filewriter object as parameter
        CSVWriter writer = new CSVWriter(outputfile);
  
        writer.writeAll(data);
  
        // closing writer connection
        writer.close();
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {       
        List<String[]> data = new ArrayList<String[]>();
        data.add(new String[] { "NameOfProduct", "Description", "ImageLink", "Price", "Rating", "NameOfStore" });

        for (int i = 1; i <= 15; i++) {

            final Document document = Jsoup.connect("https://www.tokopedia.com/p/handphone-tablet/handphone?page="+i).get();


            for (Element e : document.select("div.css-13l3l78.e1nlzfl10 div")) {
                String nameOfProduct, desc, imageLink, price, rating, nameOfStore;
                
                if (!e.select("span.css-1kr22w3").isEmpty() && 
                    !e.select("span.css-o5uqvq").text().isEmpty() && 
                    !e.select("span.css-1bjwylw").text().isEmpty() &&
                    !e.select("div.css-1c0vu8l img").attr("abs:src").isEmpty()) {
                        
                    nameOfStore = e.select("span.css-1kr22w3").get(1).text();
                    price = e.select("span.css-o5uqvq").text();
                    nameOfProduct = e.select("span.css-1bjwylw").text();
                    imageLink = e.select("div.css-1c0vu8l img").attr("abs:src"); //.select("img").attr("abs:src");

                    desc = "";
                    rating = "";

                    if (!data.stream().anyMatch(x -> x[0].equals(nameOfProduct))) data.add(new String[] {nameOfProduct, desc, imageLink, price, rating, nameOfStore});
                } else {
                    continue;
                }  
            }
        }
        generateCsvFile(data);
    }
}
