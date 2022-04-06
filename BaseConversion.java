// ******************************************************************
//   BaseConversion.java
//
//   Recursively converts an integer from base 10 to another base
// ******************************************************************

import java.util.Scanner;

public class BaseConversion
{

    public static void main (String[] args)
    {
	int base10Num;
	int base;

	Scanner scan = new Scanner (System.in);

	// Ask for the integer in base 10 and the base we are converting it to

	System.out.println ();
	System.out.println ("Base Conversion Program");
	System.out.print ("Enter an integer: ");
	base10Num = scan.nextInt();
	System.out.print ("Enter the base: ");
	base = scan.nextInt();

	// Call convert and print the answer
		String t = convert(base10Num,base);
		System.out.println(t);

    }


    // --------------------------------------------------
    //   Converts a base 10 number to another base.
    // -------------------------------------------------- 
    public static String convert (int num, int b)
    {
    	String remnant; // to store the the result of the remnant

	int quotient;  // the quotient when num is divided by base b
	int remainder; // the remainder when num is divided by base b

		quotient = num/b;
		remainder = num%b;

		// check if the quotient is 0 or a negative number

		if (quotient <= 0)
		{
			remnant = Integer.toString(remainder);
			return remnant; // if number is 0 or a negative number only return the remaining digits
		}
		else
		{
			remnant = Integer.toString(remainder);
			return convert(quotient,b) + remnant; // if number is greater than 0, continues till quotient is 0
	}
    }
}
