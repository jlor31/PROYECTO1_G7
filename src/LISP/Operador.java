package LISP;
import java.util.ArrayList;

public class Operador {

	
	private static ArrayList<String> lista_ops = new ArrayList<>();
	private static ArrayList<Double> lista_nums = new ArrayList<>();
	
	
	public static double op_Binaria(String op, double num1, double num2) {
		
		double resultado = 0;
		
		if (op.equals("+")) {
			
			resultado = num1 + num2;
			
			
			
		} else if (op.equals("-")) {
			
			resultado = num1 - num2;
			
			
			
			
		} else if (op.equals("*")) {
			
			resultado = num1 * num2;
			
			
			
			
		} else if (op.equals("/")) {
			
			resultado = num1 / num2;
			
		} else {
	
	     System.out.println("Operacion invalida");
	     
		}
		
		return resultado;
	}
	
	
	
	
	public static void calcular(ArrayList<String> lista) {
		
		if (lista.size() <= 1) {
			
			System.out.println(lista.get(0));
			
		} else {
		
		for (int i = 0; i < lista.size(); i++) {
			
			
			boolean isNum;
			
			
			try {
                Double.parseDouble(lista.get(i));
                isNum = true;
            } catch (Exception e) {
                isNum = false;
            }
			
			if (isNum) {
				
				lista_nums.add(Double.parseDouble(lista.get(i)));
				
			} else {
				
				lista_ops.add(lista.get(i));
				
			}
			
			
			
			if (lista_ops.get(lista_ops.size()-1).equals(")")) {
				
				
				
				String operacion = lista_ops.get(lista_ops.size()-2);
				double num1 = lista_nums.get(lista_nums.size()-2);
				double num2 = lista_nums.get(lista_nums.size()-1);
				
				
				
				
				double resultado = op_Binaria(operacion, num1, num2);
				
				lista_ops.remove(lista_ops.size()-1);
				lista_ops.remove(lista_ops.size()-1);
				lista_ops.remove(lista_ops.size()-1);
				
				lista_nums.remove(lista_nums.size()-1);
				lista_nums.remove(lista_nums.size()-1);
				
				lista_nums.add(resultado);
				
				
	
			}
			
			
	}
		
		System.out.println(lista_nums.get(0));
		lista_nums.clear();
		lista_ops.clear();
		
		}
}	
}	

