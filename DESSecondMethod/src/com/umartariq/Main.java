package com.umartariq;

import javax.crypto.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

/**
 * Main.java created by umartariq on 15/09/2020
 * 10:53 AM inside the package - com.umartariq
 * in the java project DESSecondMethod using IDE IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {

        String strDataToEncrypt = new String();
        String strCipherText = new String();
        String strDecryptedText = new String();

        try{
            /**
             *  Step 1. Generate a DES key using KeyGenerator
             *
             */
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGen.generateKey();

            /**
             *  Step2. Create a Cipher by specifying the following parameters
             *          a. Algorithm name - here it is DES
             *          b. Mode - here it is CBC
             *          c. Padding - PKCS5Padding
             */

            Cipher desCipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); /* Must specify the mode explicitly as most JCE providers default to ECB mode!! */

            /**
             *  Step 3. Initialize the Cipher for Encryption
             */

            desCipher.init(Cipher.ENCRYPT_MODE,secretKey);

            /**
             *  Step 4. Encrypt the Data
             *          1. Declare / Initialize the Data. Here the data is of type String
             *          2. Convert the Input Text to Bytes
             *          3. Encrypt the bytes using doFinal method
             */
            strDataToEncrypt = "DES method using DES with CBC mode and PKCS5 Padding , i am sending message to person" +
                    " 2 now ";
            byte[] byteDataToEncrypt = strDataToEncrypt.getBytes();
            byte[] byteCipherText = desCipher.doFinal(byteDataToEncrypt);

            Base64 base64 = new Base64();
            //strCipherText = new BASE64Encoder().encode(byteCipherText);
            //replace with below line - using apache commons.
            strCipherText = new String(base64.encode(byteCipherText));

            System.out.println("Cipher Text generated using DES with CBC mode and PKCS5 Padding is " +strCipherText);

            /**
             *  Step 5. Decrypt the Data
             *          1. Initialize the Cipher for Decryption
             *          2. Decrypt the cipher bytes using doFinal method
             */
            desCipher.init(Cipher.DECRYPT_MODE,secretKey,desCipher.getParameters());
            //desCipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] byteDecryptedText = desCipher.doFinal(byteCipherText);
            strDecryptedText = new String(byteDecryptedText);
            System.out.println(" Decrypted Text message is " +strDecryptedText);
        }

        catch (NoSuchAlgorithmException noSuchAlgo)
        {
            System.out.println(" No Such Algorithm exists " + noSuchAlgo);
        }

        catch (NoSuchPaddingException noSuchPad)
        {
            System.out.println(" No Such Padding exists " + noSuchPad);
        }

        catch (InvalidKeyException invalidKey)
        {
            System.out.println(" Invalid Key " + invalidKey);
        }

        catch (BadPaddingException badPadding)
        {
            System.out.println(" Bad Padding " + badPadding);
        }

        catch (IllegalBlockSizeException illegalBlockSize)
        {
            System.out.println(" Illegal Block Size " + illegalBlockSize);
        }

        catch (InvalidAlgorithmParameterException invalidParam)
        {
            System.out.println(" Invalid Parameter " + invalidParam);
        }
    }
}
