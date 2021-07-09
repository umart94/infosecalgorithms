package gcdandinverse;

import java.util.Scanner;

public class GcdAndInverse {

    public static void gcd(long a, long b,long sfinal,long tfinal,long inverseOfB){
          long r1=a;
       long r2=b;
       long s1=1;
       long s2=0;
       long t1=0;
       long t2=1;
       long q=0;
       long r=0;
       long s=0;
       long t=0;
       while(r2>0)
       {
       q = r1/r2;
       r = r1 - q * r2;
       r1 = r2;
       r2 = r;
       s = s1-q*s2;
       s1 = s2;
       s2 = s;
       t=t1-q*t2;
       t1 = t2;
       t2 = t;
       }
       s1=s;
       t=t1;
       
       //System.out.println("s== "+s+"     t== "+t);
       long gcd=r1;
       long m=0;//this is n in Zn
       long x = t;//we now have b as input , and we want to find inverse of b which is X
       
       if(gcd==1)
       {
        System.out.println("GCD is == "+gcd+"Multiplicative inverse of B exists");
        System.out.println("enter n i.e m for calculating multiplicative inverse");
        Scanner input2 = new Scanner(System.in);
        m = input2.nextLong();
        x = (x % m + m) % m;
        inverseOfB = x;
        System.out.println("Multiplicative Inverse Of B in Z"+m+" is  "+ inverseOfB);
       }
       else if(gcd!=1)
       {
       System.out.println("GCD is == "+gcd);
       System.out.println("multiplicative inverse of "+b+"does not exist");
       }
       
        
}
    
    
    public static void main(String[] args) {
       
       Scanner input = new Scanner(System.in);
       long a;
       long b;
       System.out.println("Enter First Number A");
       a = input.nextLong();
        System.out.println("Enter Second Number B");
        b = input.nextLong();
       long s=0;
       long t=0;
       long inverseOfB=0;
       gcd(a,b,s,t,inverseOfB);
       
    }
    
}
