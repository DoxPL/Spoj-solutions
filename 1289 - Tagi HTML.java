package com.doxpl;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        System.out.println("Podaj nazwe pliku: ");
        filename = bufferedReader.readLine();
        File htmlFile = new File(filename);
        if(!htmlFile.exists())
            System.out.println("Podany plik nie istnieje.");
        else
        {
            BufferedReader fileReader = new BufferedReader(new FileReader(filename));
            Matcher matcher, matcher2;
            String actualLine;
            PrintWriter writer = new PrintWriter("out.txt");
            while ((actualLine = fileReader.readLine()) != null)
            {
                matcher = Pattern.compile("<(.*)>.*</(.*)>").matcher(actualLine);
                matcher2 = Pattern.compile("<(.*)>").matcher(actualLine);
                if(matcher.find())
                    actualLine = actualLine.replaceAll(matcher.group(1), matcher.group(1).toUpperCase());
                else if(matcher2.find())
                    actualLine = actualLine.replaceAll(matcher2.group(1), matcher2.group(1).toUpperCase());
                System.out.println(actualLine);
                writer.println(actualLine);
            }
            writer.close();
        }
    }
}
