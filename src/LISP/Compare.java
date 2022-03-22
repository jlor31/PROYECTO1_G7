package LISP;

public class Compare {
	
	public static String lessthan(String num1, String num2) {
		
		String result;
		
		double n1 = 0;
		double n2 = 0;
		
		try {
			
		n1 = Double.parseDouble(num1);
		n2= Double.parseDouble(num2);
		
		} catch(Exception E) {
			
			System.out.println("Algo no funciono al evaluar la expresion booleana");
			
		}
		
		if (n1 < n2) {
			
			result = "#t";
			
		} else {
			
			result = "#f";
			
		}
		
		return result;
		
	}
	
	
	public static String greaterthan(String num1, String num2) {
		
		String result;
		double n1 = 0;
		double n2 = 0;
		
		try {
			
		n1 = Double.parseDouble(num1);
		n2= Double.parseDouble(num2);
		
		} catch(Exception E) {
			
			System.out.println("Algo no funciono al evaluar la expresion booleana");
			
		}
		
		if (n1 > n2) {
			
			result = "#t";
			
		} else {
			
			result = "#f";
			
		}
		
		return result;
		
	}
	
	public static String isequal(String num1, String num2) {
		
		String result;
		
		double n1 = 0;
		double n2 = 0;
		
		try {
			
		n1 = Double.parseDouble(num1);
		n2= Double.parseDouble(num2);
		
		} catch(Exception E) {
			
			System.out.println("Algo no funciono al evaluar la expresion booleana");
			
		}
		
		if (n1 == n2) {
			
			result = "#t";
			
		} else {
			
			result = "#f";
			
		}
		
		return result;
		
	}
	
	public static boolean to_bool(String tf) {
		
		boolean value = false;
		
		if (tf.equals("#t")) {
			
			value = true;
			
		} else if (tf.equals("#f")) {
			
			value = false;
			
		} else {
			
			System.out.println("Algo no funciono al convertir la expresion booleana");
			
		}
		
		return value;
	}
	

}
