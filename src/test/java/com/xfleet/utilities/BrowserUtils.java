package com.xfleet.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
     * Static sleep method accept second and wait during time
     *
     * @param seconds
     */

    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("static sleep issue");
        }
    }


    /**
     * These methods using for the get usernames
     *
     * @return
     */


    public static List<String> truckDriversUserName() {

        String path = "credentials.xlsx";

        List<String> truckDrivers = new ArrayList<>();


        try {
            FileInputStream file = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rowNumber; i++) {

                truckDrivers.add(sheet.getRow(i).getCell(0).toString());
            }


        } catch (Exception e) {

            e.printStackTrace();
        }

        return truckDrivers;
    }

    public static List<String> storeManagersUserName() {

        String path = "credentials.xlsx";


        List<String> storeManagers = new ArrayList<>();


        try {
            FileInputStream file = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rowNumber; i++) {

                storeManagers.add(sheet.getRow(i).getCell(1).toString());
            }


        } catch (Exception e) {

            e.printStackTrace();
        }
        return storeManagers;
    }

    public static List<String> salesManagersUserName() {

        String path = "credentials.xlsx";


        List<String> salesManagers = new ArrayList<>();


        try {
            FileInputStream file = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = sheet.getPhysicalNumberOfRows();


            for (int i = 1; i < rowNumber; i++) {

                salesManagers.add(sheet.getRow(i).getCell(2).toString());
            }


        } catch (Exception e) {

            e.printStackTrace();
        }

        return salesManagers;
    }

    public static String password() {
        String path = "credentials.xlsx";
        String password = "";


        try {
            FileInputStream file = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("data");

            password = sheet.getRow(1).getCell(3).toString();

        } catch (Exception e) {

        }
        return password;

    }

}
