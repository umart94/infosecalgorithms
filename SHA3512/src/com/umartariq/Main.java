package com.umartariq;

/**
 * Main.java created by umartariq on 14/07/2020
 * 6:10 AM inside the package - com.umartariq
 */
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;


public class Main {
    //http://www.bouncycastle.org/
    //http://www.bouncycastle.org/latest_releases.html

    /*
    we go to duckduckgo
    we query for sha3 "MUHAMMADUMARTARIQ"

    a911b9ad24b97b5b273d43020df0e5c3c341a0cd8ce26d13b842ddb70fe9c54e21697a5003114074d9256a389e8fb6b05337b9b3393aa4c9307aeefc8e4d5dcd
SHA3-512 hex hash: MUHAMMADUMARTARIQ
     */

    public static String testSha3()  {
        String input = "MUHAMMADUMARTARIQ";
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        byte[] digest = digestSHA3.digest(input.getBytes());

       // System.out.println("SHA3-512 = " + Hex.toHexString(digest));

        String string = new String(Hex.toHexString(digest).toString());
        return string;
    }

    public static void main(String[] args) {
        String duckduckGosha3 = "a911b9ad24b97b5b273d43020df0e5c3c341a0cd8ce26d13b842ddb70fe9c54e21697a5003114074d9256a389e8fb6b05337b9b3393aa4c9307aeefc8e4d5dcd";
        String bouncyCastleCodeTest = testSha3();
        System.out.println(bouncyCastleCodeTest);

        if(bouncyCastleCodeTest.equals(duckduckGosha3)){
            System.out.println("Valid.");
            System.out.println(bouncyCastleCodeTest);
        }else{
            System.out.println("Invalid.");
        }
    }
}
