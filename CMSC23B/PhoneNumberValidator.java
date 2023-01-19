package cmsc23;

import java.util.Scanner;

class PhoneNumberValidator {
    private String phoneNumber;

    public PhoneNumberValidator(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValid() {
        // check if phone number is in correct format
        if (!phoneNumber.matches("^\\d{11}$")) {
            return false;
        }
        return true;
    }

	public static void main(String[] args) {
		
		String phoneNumber;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your phone number: ");
		phoneNumber = scan.nextLine();
		PhoneNumberValidator validator = new PhoneNumberValidator(phoneNumber);
		
		
        if (validator.isValid()) {
            System.out.println("Phone number is valid");
        } else {
            System.out.println("Phone number is not valid");
        }
	}

}
