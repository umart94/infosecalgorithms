package com.umartariq;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Main.java created by umartariq on 14/07/2020
 * 6:02 AM inside the package - com.umartariq
 */

//Usage of api documented as since @java 1.6

    //fix the project language level, like from 1.6 to 1.8 etc.
    /*
    File -> Project Structure -> Project Settings -> Modules -> "Your Module Name" -> Sources -> Language Level
     */
public class Main{
public static String getSecurePassword(String password, byte[] salt) {

        String generatedPassword = null;
        try {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        }
        return generatedPassword;
        }

private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
        }

public static void main(String[] args) throws NoSuchAlgorithmException {

        // same salt should be passed
        byte[] salt = getSalt();
        String password1 = getSecurePassword("MUHAMMADUMARTARIQ", salt);
        String password2 = getSecurePassword("MUHAMMADUMARTARIQ", salt);
        System.out.println(" Password 1 -> " + password1);
        System.out.println(" Password 2 -> " + password2);
        if (password1.equals(password2)) {
        System.out.println("passwords are equal");
        }
        }

}