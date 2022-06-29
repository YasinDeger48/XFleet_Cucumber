package com.xfleet.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ConfigurationReader {


    private static Properties prop = new Properties();

    static {
        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            prop.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("ConfigurationReader problem check it!");
        }
    }

    public static String getProperty(String keyword){
        return prop.getProperty(keyword);
    }

}
