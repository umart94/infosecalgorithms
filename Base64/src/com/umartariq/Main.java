package com.umartariq;

import org.w3c.dom.ls.LSOutput;

//import java.util.Base64;//ERROR, you cannot instantiate this class, and you also cannot use previous code, so comment that.
import org.apache.commons.codec.binary.Base64;
import java.util.UUID;

/**
 * Main.java created by umartariq on 14/07/2020
 * 6:39 AM inside the package - com.umartariq
 */
public class Main {



    /*
    2.1. Java 8 Basic Base64
The basic encoder keeps things simple and encodes the input as is – without any line separation.

The output is mapped to a set of characters in A-Za-z0-9+/ character set and the decoder rejects any character outside of this set.

Let's first encode a simple String:

String originalInput = "test input";
String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
Note how we retrieve the full Encoder API via the simple getEncoder() utility method.

Let's now decode that String back to the original form:

byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
String decodedString = new String(decodedBytes);

     */

    private static StringBuilder getMimeBuffer() {
        StringBuilder buffer = new StringBuilder();
        for (int count = 0; count < 10; ++count) {
            buffer.append(UUID.randomUUID().toString());
        }
        return buffer;
    }
    public static void main(String[] args) {
      /*
        String originalInput = "MUHAMMADUMARTARIQ";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        //TVVIQU1NQURVTUFSVEFSSVE=

        String preencodedBase64 = "TVVIQU1NQURVTUFSVEFSSVE=";


        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);




        if(preencodedBase64.equals(encodedString)){
            System.out.println("both strings match... ");
            System.out.println("here is your base64 encoded value");
            System.out.println(encodedString);
            System.out.println(decodedString);
        }
*/

        /*
        2.2. Java 8 Base64 Encoding Without Padding
In Base64 encoding, the length of output encoded String must be a multiple of 3. If it's not, the output will be padded with additional pad characters (`=`).

On decoding, these extra padding characters will be discarded. To dig deeper into padding in Base64, check out this detailed answer over on StackOverflow.

If you need to skip the padding of the output – perhaps, because the resulting String will never be decoded back – you can simply chose to encode without padding:

String encodedString =
  Base64.getEncoder().withoutPadding().encodeToString(originalInput.getBytes());




         */


       /* String encodedStringwithoutPadding =
                Base64.getEncoder().withoutPadding().encodeToString(originalInput.getBytes());
        System.out.println(encodedStringwithoutPadding);
*/

        /*
        2.3. Java 8 URL Encoding
URL encoding is very similar to the basic encoder we looked at above. It uses the URL and Filename safe Base64 alphabet and does not add any line separation:

String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
String encodedUrl = Base64.getUrlEncoder().encodeToString(originalURL.getBytes());
Decoding happens in much the same way – the getUrlDecoder() utility method returns a java.util.Base64.Decoder that is then used to decode the URL:

byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedUrl);
String decodedUrl = new String(decodedBytes);

         */




     /*   String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
        String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
        //Decoding happens in much the same way – the getUrlDecoder() utility method returns a java.util.Base64.Decoder that is then used to decode the URL:

        byte[] decodedBytes2 = Base64.getUrlDecoder().decode(encodedUrl);
        String decodedUrl = new String(decodedBytes2);
        System.out.println(encodedUrl);
        System.out.println(decodedUrl);
*/




        /*
        2.4. Java 8 MIME Encoding
Let's start with by generating some basic MIME input to encode:

private static StringBuilder getMimeBuffer() {
    StringBuilder buffer = new StringBuilder();
    for (int count = 0; count < 10; ++count) {
        buffer.append(UUID.randomUUID().toString());
    }
    return buffer;
}
         */





        /*
        The MIME encoder generates a Base64 encoded output using the basic alphabet but in a MIME friendly format: each line of the output is no longer than 76 characters and ends with a carriage return followed by a linefeed (\r\n):

StringBuilder buffer = getMimeBuffer();
byte[] encodedAsBytes = buffer.toString().getBytes();
String encodedMime = Base64.getMimeEncoder().encodeToString(encodedAsBytes);
The getMimeDecoder() utility method returns a java.util.Base64.Decoder that is then used in the decoding process:

byte[] decodedBytes = Base64.getMimeDecoder().decode(encodedMime);
String decodedMime = new String(decodedBytes);

         */




        /*
        StringBuilder buffer = getMimeBuffer();
        byte[] encodedAsBytes = buffer.toString().getBytes();
        String encodedMime = Base64.getMimeEncoder().encodeToString(encodedAsBytes);
        byte[] decodedBytes3 = Base64.getMimeDecoder().decode(encodedMime);
        String decodedMime = new String(decodedBytes3);
        System.out.println(encodedMime);
        System.out.println(decodedMime);
*/



    /*
    3. Encoding/Decoding Using Apache Commons Code
First, we need to define the commons-codec dependency in the pom.xml:

<dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
    <version>1.10</version>
</dependency>
Note that you can check is newer versions of the library have been released over on Maven central.

The main API is the org.apache.commons.codec.binary.Base64 class – which can be parameterized with various constructors:

Base64(boolean urlSafe) – creates the Base64 API by controlling the URL-safe mode – on or off
Base64(int lineLength) – creates the Base64 API in an URL unsafe mode and controlling the length of the line (default is 76)
Base64(int lineLength, byte[] lineSeparator) – creates the Base64 API by accepting an extra line separator, which, by default is CRLF (“\r\n”)
On the Base64 API is created, both encoding and decoding are quite simple:

String originalInput = "test input";
Base64 base64 = new Base64();
String encodedString = new String(base64.encode(originalInput.getBytes()));
The decode() method of Base64 class returns the decoded string:

String decodedString = new String(base64.decode(encodedString.getBytes()));
Another simple option is using the static API of Base64 instead of creating an instance:

String originalInput = "test input";
String encodedString = new String(Base64.encodeBase64(originalInput.getBytes()));
String decodedString = new String(Base64.decodeBase64(encodedString.getBytes()));


     */


    //Apache Commons
        String originalInputForApacheCommons = "test input";
        Base64 base64 = new Base64();
        String encodedString = new String(base64.encode(originalInputForApacheCommons.getBytes()));
        String decodedString = new String(base64.decode(encodedString.getBytes()));//pass encoded string here.
        System.out.println(encodedString);
        System.out.println(decodedString);

     //https://www.baeldung.com/java-base64-encode-and-decode


    }




}
