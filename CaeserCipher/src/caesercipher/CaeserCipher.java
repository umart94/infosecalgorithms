package caesercipher;

import java.util.Scanner;

public class CaeserCipher {

    public static void main(String[] args) {
        // TODO code application logic here
        
        while(true)
        {
        Scanner input = new Scanner(System.in);
        String plainTextString = input.nextLine();
        
        System.out.println("Encrypted String Is == " +CaeserCipher.encryptionFunction( plainTextString, 4 ));
        System.out.println( "Decrypted String Is == "+CaeserCipher.decryptionFunction( CaeserCipher.encryptionFunction( plainTextString, 4), 4 ));
        }
    
    }
    public static String decryptionFunction(String enc, int offset) {
        return encryptionFunction(enc, 26-offset);
    }
    public static String encryptionFunction(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
}



    
    
    
    
    
    
    
    
    