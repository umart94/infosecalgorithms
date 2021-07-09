package com.umartariq;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;

/**
 * Main.java created by umartariq on 15/09/2020
 * 10:39 AM inside the package - com.umartariq
 * in the java project AESCBC using IDE IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        String strDataToEncrypt = new String();
        String strCipherText = new String();
        String strDecryptedText = new String();

        try {
            /**
             * Step 1. Generate an AES key using KeyGenerator Initialize the
             * keysize to 128 bits (16 bytes)
             *
             */
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            /**
             * Step 2. Generate an Initialization Vector (IV)
             *      a. Use SecureRandom to generate random bits
             *         The size of the IV matches the blocksize of the cipher (128 bits for AES)
             *      b. Construct the appropriate IvParameterSpec object for the data to pass to Cipher's init() method
             */

            final int AES_KEYLENGTH = 128;  // change this as desired for the security level you want
            byte[] iv = new byte[AES_KEYLENGTH / 8];    // Save the IV bytes or send it in plaintext with the encrypted data so you can decrypt the data later
            SecureRandom prng = new SecureRandom();
            prng.nextBytes(iv);

            /**
             * Step 3. Create a Cipher by specifying the following parameters
             *      a. Algorithm name - here it is AES
             *      b. Mode - here it is CBC mode
             *      c. Padding - e.g. PKCS7 or PKCS5
             */

            /*
            You don't want to specify PKCS#7 padding for block cipher use. You want to specify PKCS#5 padding. PKCS#5 is specified for use with block ciphers while PKCS#7 is not (it's use for different places like in S/MIME). I will point out that PKCS#5 and PKCS#7 actually specify exactly the same type of padding (they are the same!), but it's called #5 when used in this context. :)

So, instead of "AES/ECB/PKCS7PADDING", you want "AES/ECB/PKCS5PADDING". This is a cipher implementation that every implementation of the Java platform is required to support. See the documentation of the Cipher class for more details.

             replace pkcs7 padding with pkcs5 padding.
             */
            Cipher aesCipherForEncryption = Cipher.getInstance("AES/CBC/PKCS5PADDING"); // Must specify the mode
            // explicitly as most JCE providers default to ECB mode!!

            /**
             * Step 4. Initialize the Cipher for Encryption
             */

            aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKey,
                    new IvParameterSpec(iv));

            /**
             * Step 5. Encrypt the Data
             *      a. Declare / Initialize the Data. Here the data is of type String
             *      b. Convert the Input Text to Bytes
             *      c. Encrypt the bytes using doFinal method
             */
            strDataToEncrypt = "Hello Person 2, How Are You? sending encrypted text using AES/CBC/PKCS5PADDING " +
                    "encyrption method ";
            byte[] byteDataToEncrypt = strDataToEncrypt.getBytes();
            byte[] byteCipherText = aesCipherForEncryption
                    .doFinal(byteDataToEncrypt);
            // b64 is done differently on Android
            //import org.apache.commons.codec.binary.Base64;
            //import commons codec apache library
           /* String originalInputForApacheCommons = "test input";
            Base64 base64 = new Base64();
            String encodedString = new String(base64.encode(originalInputForApacheCommons.getBytes()));
            String decodedString = new String(base64.decode(encodedString.getBytes()));//pass encoded string here.
            System.out.println(encodedString);
            System.out.println(decodedString);*/
            Base64 base64 = new Base64();

            //strCipherText = new BASE64Encoder().encode(byteCipherText);
            strCipherText = new String(base64.encode(byteCipherText));//if it was in string , then we could use
            // getBytes method here.

            System.out.println("Cipher Text generated using AES is "
                    + strCipherText);

            /**
             * Step 6. Decrypt the Data
             *      a. Initialize a new instance of Cipher for Decryption (normally don't reuse the same object)
             *         Be sure to obtain the same IV bytes for CBC mode.
             *      b. Decrypt the cipher bytes using doFinal method
             */

            Cipher aesCipherForDecryption = Cipher.getInstance("AES/CBC/PKCS5PADDING"); // Must specify the mode
            // explicitly as most JCE providers default to ECB mode!!

            aesCipherForDecryption.init(Cipher.DECRYPT_MODE, secretKey,
                    new IvParameterSpec(iv));
            byte[] byteDecryptedText = aesCipherForDecryption
                    .doFinal(byteCipherText);
            strDecryptedText = new String(byteDecryptedText);
            System.out
                    .println(" Decrypted Text message is " + strDecryptedText);
        }

        catch (NoSuchAlgorithmException noSuchAlgo) {
            System.out.println(" No Such Algorithm exists " + noSuchAlgo);
        }

        catch (NoSuchPaddingException noSuchPad) {
            System.out.println(" No Such Padding exists " + noSuchPad);
        }

        catch (InvalidKeyException invalidKey) {
            System.out.println(" Invalid Key " + invalidKey);
        }

        catch (BadPaddingException badPadding) {
            System.out.println(" Bad Padding " + badPadding);
        }

        catch (IllegalBlockSizeException illegalBlockSize) {
            System.out.println(" Illegal Block Size " + illegalBlockSize);
        }

        catch (InvalidAlgorithmParameterException invalidParam) {
            System.out.println(" Invalid Parameter " + invalidParam);
        }
    }
    }

