package com.umartariq;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Main.java created by umartariq on 16/09/2020
 * 2:14 PM inside the package - com.umartariq
 * in the java project RSA using IDE IntelliJ IDEA
 */
public class Main {
    private final static BigInteger one      = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    // generate an N-bit (roughly) public and private key
    Main(int N) {
        BigInteger p = BigInteger.probablePrime(N/2, random);
        BigInteger q = BigInteger.probablePrime(N/2, random);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

        modulus    = p.multiply(q);
        publicKey  = new BigInteger("65537");     // common value in practice = 2^16 + 1
        privateKey = publicKey.modInverse(phi);
    }


    BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, modulus);
    }

    public String toString() {
        String s = "";
        s += "public  = " + publicKey  + "\n";
        s += "private = " + privateKey + "\n";
        s += "modulus = " + modulus;
        return s;
    }

    public static void main(String[] args) {
        //int N = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(String.valueOf(scanner.nextInt()));
        Main key = new Main(N);
        System.out.println(key);

        // create random message, encrypt and decrypt
        //BigInteger message = new BigInteger(N-1, random);

        //// create message by converting string to integer
         String s = "Encrypting this message through RSA encryption, how are you person 2 ?";
         byte[] bytes = s.getBytes();
         BigInteger message = new BigInteger(bytes);

        BigInteger encrypt = key.encrypt(message);
        BigInteger decrypt = key.decrypt(encrypt);
        System.out.println("message   = " + message);
        System.out.println("encrypted = " + encrypt);
        System.out.println("decrypted = " + decrypt);
    }
}
