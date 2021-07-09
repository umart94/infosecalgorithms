package com.umartariq;

/**
 * Main.java created by umartariq on 14/07/2020
 * 5:56 AM inside the package - com.umartariq
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Main {
    /*
    MUHAMMADUMARTARIQ

84eaec494fb3567a483f31a2ab7445f1
     */
    public static void main(String[] args) {
        System.out.println("For null " + md5(""));
        System.out.println("For simple text "+ md5("MUHAMMADUMARTARIQ"));
        System.out.println("For simple numbers " + md5("12345"));

        String md5 = md5("MUHAMMADUMARTARIQ");
        String theirmd5 = "84eaec494fb3567a483f31a2ab7445f1";
        //https://emn178.github.io/online-tools/md5.html

        if(md5.equals(theirmd5)){
            System.out.println("MD5 MATCHED !! -- For simple text "+ md5("MUHAMMADUMARTARIQ"));
            System.out.println("you generated the correct md5.");
        }


    }
    public static String md5(String input) {
        String md5 = null;
        if(null == input) return null;
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());
            //Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}
