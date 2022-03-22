package LISP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Interprete {

	static Lector lector = new Lector();
	
	
	public static void prompt() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print(">>> ");
		
		String lisp_exp = in.nextLine();
			
		Operador.asignar_op(Lector.leer(lisp_exp));
		
		prompt();
		
	}
	
	
	public static void main(String args[]) {
		System.out.println(" ");
		System.out.println("------------ INTERPRETE LISP GRUPO 7 ------------");
		System.out.println(" ");
		
		Funciones.listado_funciones.clear();   // limpiando variables y funciones definidas
		Funciones.listado_variables.clear();
		
		
		prompt();
		
		
		
	}
	
	
	
}
