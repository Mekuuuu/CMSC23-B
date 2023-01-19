package Projects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidator {
	
	public static void main (String [] args)	{
		Scanner scanner = new Scanner(System.in);
		
		String email;
		
		System.out.println("Please enter your email: ");
		email = scanner.nextLine();
		
		System.out.println("Your email is " + validateEmail(email));
	}
	public static String validateEmail(String email) {
		if (email == null || email.isEmpty())	{
			return "Invalid";
		}
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
				"[a-zA-Z0-9_+&*-]+)*@"	+
				"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		
		Pattern pattern = Pattern.compile(emailRegex);
		if (pattern.matcher(email).matches())	{
			return "Valid";
		} else {
			return "Invalid";
		}
	}
}
