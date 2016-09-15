package com.austindorff.numbers;

import javax.swing.JOptionPane;

public class BaseConverter {
	static String		enterNumberMessage			= "";
	static String		enterMaximumNumberMessage	= "";
	static String		errorMessage;
	static final String	BOOTMESSAGE					= "Base Converter Program.";
	static int			base;
	static int			userInputMin;
	static int			userInputMax;
	static int			base10Num;
	static double		maxNumber;
						
	public static void baseConverter() {
		int base;
		int base10Num;
		
		int place0;
		int place1;
		int place2;
		int place3;
		
		String baseBNum;
		
		System.out.println("Base Conversion Program");
		String response = JOptionPane.showInputDialog("Please enter a base (2-9):");
		base = Integer.parseInt(response);
		String response10 = JOptionPane.showInputDialog("Type a response:");
		base10Num = Integer.parseInt(response10);
		
		place0 = base10Num % base;
		base10Num = base10Num / base;
		place1 = base10Num % base;
		base10Num = base10Num / base;
		place2 = base10Num % base;
		base10Num = base10Num / base;
		place3 = base10Num % base;
		baseBNum = "The answer is: " + place3 + place2 + place1 + place0;
		
		System.out.println(baseBNum);
	}
}
