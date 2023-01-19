package cmsc23;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class ValidatorInt {

	ValidatorInt(String s) {
		
		if(s.length() >= 0) {
			
			if(s.length() == 0) {
				System.out.println("Invalid Input");
				return;
			}
			//validating an email;
			if(s.length() >= 0) {
				
				for(int i = 0; i <= s.length()-1; ++i) {
					if(s.charAt(i) == '@') {
						System.out.println("Your email is " + validateEmail(s)+".");
						return;
					}
				}
			}
			
			//validating a date;
			if(s.length() == 10) {
				validateJavaDate(s);
			}
			
			//validating a phone number;
			if(s.length() == 11) {
				
			
				
				if(isValid(s)) {
					System.out.println("Phone number is valid.");
				}
				else {
					System.out.println("Phone number is invalid.");
				}
			}
			else {
				System.out.println("Input is invalid.");
			}

			
			
		}	
	}
	
//validator for email;	
	public static String validateEmail(String s) {
		if (s == null || s.isEmpty())	{
			return "Invalid";
		}
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
				"[a-zA-Z0-9_+&*-]+)*@"	+
				"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		
		Pattern pattern = Pattern.compile(emailRegex);
		if (pattern.matcher(s).matches())	{
			return "Valid";
		} else {
			return "Invalid";
		}
	}
	
//validator for date;
	public static boolean validateJavaDate(String s) {
		   
		if (s.trim().equals("")) {
			return true;
		}
		else {
			    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
			    sdfrmt.setLenient(false);

			    try{
			        Date javaDate = sdfrmt.parse(s); 
			        System.out.println(s+" is a valid Date format.");
			    }
			    catch (ParseException e){
			        System.out.println(s+" is an invalid Date format.");
			        return false;
			    }
			    return true;
			}
		
	}

//validator for phone number;
		public static boolean isValid(String s) {
			if(!s.matches("^\\d{11}$")) {
				return false;
			}
			return true;
		}
		
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Notice: Date format is mm/dd/yyyy");
		System.out.println("Notice: Number must be in 11-digits (09XXXXXXXXX)\n");
		System.out.println("Please enter data: ");
		
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();

		
		new ValidatorInt(s);
		return;
	}
}
