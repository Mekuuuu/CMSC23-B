package com.validate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class DateValidator {
	
   public static boolean validateJavaDate(String strDate)
   {
	if (strDate.trim().equals(""))
	{
	    return true;
	}
	else
	{

	    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
	    sdfrmt.setLenient(false);

	    try
	    {
	        Date javaDate = sdfrmt.parse(strDate); 
	        System.out.println(strDate+" is a Valid Date format");
	    }
	    
	    catch (ParseException e)
	    {
	        System.out.println(strDate+" is an Invalid Date format");
	        return false;
	    }

	    return true;
	}
   }
   public static void main(String args[]){ 
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter date in mm/dd/yyyy format:");
	String s = scan.next();
	
	validateJavaDate(s);
   }
}