package com.umartariq;

/**
 * Main.java created by umartariq on 15/09/2020
 * 10:07 AM inside the package - com.umartariq
 * in the java project DESJavaCBC using IDE IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {
        Encryption encryptionObject = new Encryption();
        Decryption decryptionObject = new Decryption();

        String superSecretKey = "xdvjklwh812395y89024gfeaw%$&RVCV";
        String plaintextInAString = "Java Cryptographic Extensions (JCE) is a set of Java API’s which provides " +
                "cryptographic services such as encryption";
        String nameOfEncryptedFileToBeGenerated = "encryptedFile"; // just the name of file without extension.
        String nameOfEncryptedFileToDecrypt = "encryptedFile"; // just the name of file without extension.

        encryptionObject.encryptionOfPlaintext(superSecretKey,plaintextInAString,nameOfEncryptedFileToBeGenerated);
        decryptionObject.decryptionOfPlaintext(superSecretKey,nameOfEncryptedFileToDecrypt);


        System.out.println("Exiting....");

    }
}
