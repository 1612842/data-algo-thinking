package com.cong.predictiveText;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class DataReader {

    public static void read(String pathToFolder) throws FileNotFoundException {
        File folder = new File(pathToFolder);
        if(!folder.exists() || !folder.isDirectory()){
            throw new FileNotFoundException();
        }
        File[] fileNames = folder.listFiles();

        //Set<String> listWord = new HashSet<String>();
        BufferedReader reader;

        for (File file : fileNames) {
            try {
                reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder document = new StringBuilder();

                while ((line = reader.readLine()) != null) {

                    document.append(line).append("\n");
                }

                DataNormalizer.addDataIntoApp(DataNormalizer.getListWord(document.toString()));
                //listWord.addAll(DataNormalizer.getListWord(document.toString()));
                document.setLength(0);

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return listWord;
    }

    public static void readXML(String pathToFolder) throws IOException, SAXException {
        File folder = new File(pathToFolder);
        File[] fileNames = folder.listFiles();

        for(File file : fileNames){
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = null;
            try {
                documentBuilder = documentBuilderFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            Document document = documentBuilder.parse(file);

            String post = document.getElementsByTagName("post").item(0).getTextContent();
        }
    }

}

