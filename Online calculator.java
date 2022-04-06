import java.util.Scanner;

public class Calculator
{
	public static void main(String[] args) {
		double num1;
		double num2;
		double result;
		char operation;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your first number?\n");
		num1 = scan.nextDouble();
		
		System.out.println("What is your second number?\n");
		num2 = scan.nextDouble();
		
		System.out.println("What is your desired operator?\n");
		char = scan.next.charAt(0);
		
		switch(operation){
		     case '+': result = num1 + num2;
            break;
            case '-': result = num1 - num2;
            break;
            case '*': result = num1 * num2;
            break;
            case '/': result = num1 / num2;
            break;
        
        default: System.out.printf("Error! Enter correct operator");
         return;
		}
		
		System.out.println("The result of the operation is: \n");
		
		System.out.println(num1 + " " + operation + " " + num2 + "=" + result)
	}
}
