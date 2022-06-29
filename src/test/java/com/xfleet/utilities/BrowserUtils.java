package com.xfleet.utilities;

public class BrowserUtils {

    /**
     * Static sleep method accept second and wait during time
     * @param seconds
     */

    public static void sleep(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            System.out.println("static sleep issue");
        }
    }



}
