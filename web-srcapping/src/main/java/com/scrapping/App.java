package com.scrapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }


    public static void generateCsvFile() {
  
    // first create file object for file placed at location
    // specified by filepath
    File file = new File("./scrapping.csv");

    try {
        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter(file);
  
        // create CSVWriter object filewriter object as parameter
        CSVWriter writer = new CSVWriter(outputfile);
  
        // create a List which contains String array
        List<String[]> data = new ArrayList<String[]>();
        data.add(new String[] { "Name", "Class", "Marks" });
        data.add(new String[] { "Aman", "10", "620" });
        data.add(new String[] { "Suraj", "10", "630" });
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
        // final Document document = Jsoup.connect("https://www.tokopedia.com/p/handphone-tablet/handphone").get();

        // System.out.println(document.outerHtml());
        generateCsvFile();
    }
}
