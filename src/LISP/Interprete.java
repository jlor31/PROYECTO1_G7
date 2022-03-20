package LISP;
import java.util.Scanner;

public class Interprete {

	static Lector lector = new Lector();
	
	public static void prompt() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print(">>> ");
		
		String lisp_exp = in.nextLine();
			
		Operador.calcular(Lector.leer(lisp_exp));
		
		prompt();
		
	}
	
	
	public static void main(String args[]) {
		
		System.out.println("------------ INTERPRETE LISP GRUPO 7 ------------");
		System.out.println(" ");
		
		
		prompt();
		
		
		
	}
	
	
	
}
