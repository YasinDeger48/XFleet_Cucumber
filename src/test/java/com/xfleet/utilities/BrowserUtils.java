package com.xfleet.utilities;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.HomePage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrowserUtils {

    static BasePage page = new BasePage();
    static HomePage homePage = new HomePage();

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
     * These methods using for get usernames
     * we get our data from excel sheet via apache POI
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


            file.close();
            workbook.close();


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

            file.close();
            workbook.close();
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
            file.close();
            workbook.close();

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

            file.close();
            workbook.close();

        } catch (Exception e) {

        }
        return password;

    }

    public static boolean attributeCheck(WebElement element, String attribute){
        boolean result = false;

        try{
            String att = element.getAttribute(attribute);
            if(att != null){
                result=true;
            }


        }catch (Exception e){

        }
        return result;
    }


    /**
     * Accept text and click it.
     * @param linkText
     */

    public static void clickLink(String linkText){

        Driver.getDriver().findElement(By.xpath("//*[.='"+linkText+"']")).click();

    }

    public static String getText(String text){

        return Driver.getDriver().findElement(By.xpath("//*[.='"+text+"']")).getText();

    }


    /**
     * this 2 methods getting username and passwords over oracle table
     * @return
     */


    public static String getPasswordWithOracle() {

        Random random = new Random();

        List<String> passwords = new ArrayList<>();


        String dbURL = ConfigurationReader.getProperty("dbURL");
        String dbUserName = ConfigurationReader.getProperty("dbUserName");
        String dbPassword = ConfigurationReader.getProperty("dbPassword");


        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM XFLEET");



            while (resultSet.next()){
                passwords.add(resultSet.getString("PASS_WORD"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return passwords.get(random.nextInt(passwords.size()));

    }

    public static String getUserNameWithOracle(){

        Random random = new Random();

        List<String> usernames = new ArrayList<>();


        String dbURL = ConfigurationReader.getProperty("dbURL");
        String dbUserName = ConfigurationReader.getProperty("dbUserName");
        String dbPassword = ConfigurationReader.getProperty("dbPassword");


        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM XFLEET");



            while (resultSet.next()){
                usernames.add(resultSet.getString("USER_NAME"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return usernames.get(random.nextInt(usernames.size()));
    }




}
