package com.company;

import java.util.Scanner;

public class PalindromeTester {
    public static void main(String[] args){
        // get the value for the string
        Scanner scan = new Scanner(System.in);
        String g = "YES";

        // use a do while loop in order to ensure the program is executed at least once.
        do {
            // request for a palindrome from the user
            System.out.println("Please enter a Palindrome: ");
            String x= scan.nextLine();
            String reverse = "";
            // use the string reverse to switch the words in order to prove that it is a palindrome
            x = x.replaceAll("", "");0
            x=
                    x.replaceAll("\\p{Punct}", "");

            int t = x.length() - 1;
            // use the for statement to switch the words from the back to the front to produce the new word
            for (int i = t; i>= 0; i--){
                reverse= reverse + x.charAt(i);
            }

            // use an if else satement to show if it is true or false
            if
            (x.equalsIgnoreCase(reverse)){
                System.out.print("Is a Palindrome ");
            }
                else
                    System.out.print("Is not a palindrome ");
                System.out.print( " ENTER EITHER YES OR NO: ");

                g=scan.nextLine();
        }
        while (g.equals("YES") && g != "NO");
    }
}
