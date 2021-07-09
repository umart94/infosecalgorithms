package com.umartariq;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.FileInputStream;

/**
 * Decryption.java created by umartariq on 15/09/2020
 * 10:08 AM inside the package - com.umartariq
 * in the java project DESJavaCBC using IDE IntelliJ IDEA
 */

//DESede means encrypt decrypt encrypt, we don't have to manually encrypt / decrypt three times, this class does that
// automatically for us
//this is the Triple DES Algorithm
//The Algorithm Mode is CBC, CBC is more secure than ECB, ECB is insecure.

public class Decryption {
    public void decryptionOfPlaintext(String keyInaString,
                                    String nameOfEncryptedFileToDecrypt){
        String plaintextInAString;
        try
        {
// Create an array to hold the key
            byte[] encryptKey = keyInaString.getBytes();

// Create a DESede key spec from the key
            DESedeKeySpec spec = new DESedeKeySpec(encryptKey);

// Get the secret key factor for generating DESede keys
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(
                    "DESede");

// Generate a DESede SecretKey object
            SecretKey theKey = keyFactory.generateSecret(spec);

// Create a DESede Cipher
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

// Create the initialization vector required for CBC mode
            IvParameterSpec ivParameters = new IvParameterSpec(
                    new byte[] { 12, 34, 56, 78, 90, 87, 65, 43 } );

// Initialize the cipher and put it in decrypt mode
            cipher.init(Cipher.DECRYPT_MODE, theKey, ivParameters);

            File encryptedFile = new File(nameOfEncryptedFileToDecrypt+".dat");

// Create a byte block to hold the entire encrypted file
            byte[] encryptedText = new byte[(int) encryptedFile.length()];

            FileInputStream fileIn = new FileInputStream(encryptedFile);

// Read the entire encrypted file
            fileIn.read(encryptedText);

            fileIn.close();

// Decrypt the data
            byte[] plaintext = cipher.doFinal(encryptedText);

            plaintextInAString = new String(plaintext);

            System.out.println("The plaintext is:");
            System.out.println(plaintextInAString);

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
}
