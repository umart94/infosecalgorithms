package com.umartariq;

import com.google.common.io.BaseEncoding;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {


    private static final String DEFAULT_ENCODING = "ASCII";
    private static final String HMAC_SHA512 = "HmacSHA512";

    //TEXT = MUHAMMADUMARTARIQ
    //KEY = lkjgduy3654ws945432
    //Computed HMAC a63161bb2b3d4a7490cb9a4102d12d7b9ba658054d83e26ff0d459b600a33394ef93662bcaaa974c7a287c4338e793eba549a5dd102ff6a11d251d5af3c4b54f


    public static byte[] hmacSha512(String value, String key){
        try {
            SecretKeySpec keySpec = new SecretKeySpec(
                    key.getBytes(DEFAULT_ENCODING),
                    HMAC_SHA512);

            Mac mac = Mac.getInstance(HMAC_SHA512);
            mac.init(keySpec);
            return mac.doFinal(value.getBytes(DEFAULT_ENCODING));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String asHex(byte[] bytes){
        return BaseEncoding.base16().lowerCase().encode(bytes);
    }

    public static void main(String[] args) {
	// write your code here
        //compare results from some online calculator
        //https://www.freeformatter.com/hmac-generator.html#ad-output
        String theirHMAC512 = "a63161bb2b3d4a7490cb9a4102d12d7b9ba658054d83e26ff0d459b600a33394ef93662bcaaa974c7a287c4338e793eba549a5dd102ff6a11d251d5af3c4b54f";

        System.out.println("Our Code Returned : "+asHex(hmacSha512("MUHAMMADUMARTARIQ","lkjgduy3654ws945432")));
        System.out.println("Their Code returned : "+theirHMAC512);
        String ourHMAC512 = new String(asHex(hmacSha512("MUHAMMADUMARTARIQ","lkjgduy3654ws945432")));
        if(theirHMAC512.equals(ourHMAC512)){
            System.out.println("Your Code returns the correct HMAC512, based on supplied key. ");
        }

        //now changing my end of the value
        //TEXT = hi how are you
        //KEY = lkjgduy3654ws945432
        //Computed HMAC a63161bb2b3d4a7490cb9a4102d12d7b9ba658054d83e26ff0d459b600a33394ef93662bcaaa974c7a287c4338e793eba549a5dd102ff6a11d251d5af3c4b54f

        // changing text to something else.

        System.out.println("Our Code Returned : "+asHex(hmacSha512("hi how are you","lkjgduy3654ws945432")));
        System.out.println("Their Code returned : "+theirHMAC512);
        String secondourHMAC512 = new String(asHex(hmacSha512("hi how are you","lkjgduy3654ws945432")));
        if(theirHMAC512.equalsIgnoreCase(secondourHMAC512)){
            System.out.println("Your Code returns the correct HMAC512, based on supplied key. ");
        }
        //just for testing this should run else block
        else{
            System.out.println("Unauthorized.");
        }

    }
}
