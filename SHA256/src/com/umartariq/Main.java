package com.umartariq;

/**
 * Main.java created by umartariq on 14/07/2020
 * 6:24 AM inside the package - com.umartariq
 */
import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.util.encoders.Hex;
import org.w3c.dom.ls.LSOutput;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // write your code here
        //27964a2cfb03f76898c944c9c8dbc74a8782eb3c0129dfa0555730e2e0970095
        String originalString = "MUHAMMADUMARTARIQ";
        String precalculatedsha256 = "27964a2cfb03f76898c944c9c8dbc74a8782eb3c0129dfa0555730e2e0970095";

        //Java
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                originalString.getBytes(StandardCharsets.UTF_8));
        System.out.println(bytesToHex(encodedhash));
        String result = bytesToHex(encodedhash).equals(precalculatedsha256) ? "VALID" : "invalid";
        if(result.equals("VALID")){
            System.out.println(bytesToHex(encodedhash));
        }
        //Google Guava
        String sha256hexgoogleguava = Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();

        System.out.println(sha256hexgoogleguava);
            //Apache Commons Codec
        String sha256hexapachecommonscodec = DigestUtils.sha256Hex(originalString);
        System.out.println(sha256hexapachecommonscodec);

        //BouncyCastle.
        //The Bouncy Castle API provides a utility class for converting hex data to bytes and back again.

        //However, it is required to populate a digest using the built-in Java API first:

        MessageDigest digest2 = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest2.digest(
                originalString.getBytes(StandardCharsets.UTF_8));
        String sha256hexBouncyCastle = new String(Hex.encode(hash));
        System.out.println(sha256hexBouncyCastle);


    }
}
