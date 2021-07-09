package com.umartariq;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Main.java created by umartariq on 15/09/2020
 * 10:36 AM inside the package - com.umartariq
 * in the java project SecureRandom using IDE IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {
        try {
            // Initialize a secure random number generator
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

            // Method 1 - Calling nextBytes method to generate Random Bytes
            byte[] bytes = new byte[512];
            secureRandom.nextBytes(bytes);

            // Printing the SecureRandom number by calling secureRandom.nextDouble()
            System.out.println(" Secure Random # generated by calling nextBytes() is " + secureRandom.nextDouble());

            // Method 2 - Using setSeed(byte[]) to reseed a Random object
            int seedByteCount = 10;
            byte[] seed = secureRandom.generateSeed(seedByteCount);

            //to be read
            // TBR System.out.println(" Seed value is " + new BASE64Encoder().encode(seed));

            secureRandom.setSeed(seed);

            System.out.println(" Secure Random # generated using setSeed(byte[]) is  " + secureRandom.nextDouble());

        } catch (NoSuchAlgorithmException noSuchAlgo)
        {
            System.out.println(" No Such Algorithm exists " + noSuchAlgo);
        }
    }
}
