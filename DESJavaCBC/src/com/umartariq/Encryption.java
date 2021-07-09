package com.umartariq;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileOutputStream;

/**
 * Encryption.java created by umartariq on 15/09/2020
 * 10:07 AM inside the package - com.umartariq
 * in the java project DESJavaCBC using IDE IntelliJ IDEA
 */


//DESede means encrypt decrypt encrypt, we don't have to manually encrypt / decrypt three times, this class does that
// automatically for us
    //this is the Triple DES Algorithm
    //The Algorithm Mode is CBC, CBC is more secure than ECB, ECB is insecure.

public class Encryption {

    public void encryptionOfPlaintext(String keyInaString,String plaintextInAString,String nameOfEncryptedFileToBeGenerated){
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

// Create an initialization vector (necessary for CBC mode)

            IvParameterSpec IvParameters = new IvParameterSpec(
                    new byte[] { 12, 34, 56, 78, 90, 87, 65, 43 });

// Initialize the cipher and put it into encrypt mode
            cipher.init(Cipher.ENCRYPT_MODE, theKey, IvParameters);

            byte[] plaintext =
                    plaintextInAString.getBytes();

// Encrypt the data
            byte[] encrypted = cipher.doFinal(plaintext);

// Write the data out to a file
            FileOutputStream out = new FileOutputStream(nameOfEncryptedFileToBeGenerated+".dat");
            out.write(encrypted);
            out.close();
            System.out.println("Encrypted File Generated. ");
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
}
