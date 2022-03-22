package LISP;
import java.util.ArrayList;
import java.util.Arrays;

public class Operador {

	
	private static ArrayList<String> lista_ops = new ArrayList<>();
	private static ArrayList<Double> lista_nums = new ArrayList<>();
	
	private static ArrayList<String> lista_ops_temp = new ArrayList<>();
	private static ArrayList<String> lista_ops_fijo = new ArrayList<>();
	
	
	// (defun sumar ( a b ) ( + a b))
	// ( + (sumar( 2 3)) (sumar( 1 9)))
	
	public static void Evaluador(ArrayList<String> expresion) {  // espera ( + 2 sumar ( 2 (sumar (3 2))))
		
		ArrayList<Integer> indices_ops_temp = new ArrayList<>(); // indices de las funciones a evaluar
		
		ArrayList<String> listado_funciones_temp = new ArrayList<>();
		
		lista_ops_temp.addAll(expresion);
		lista_ops_fijo.addAll(expresion);
		sustituir_vars(lista_ops_temp);
		
		
		for (int i = (lista_ops_temp.size()-1); i>= 0; i--) {
			
			if (Funciones.listado_funciones.get(lista_ops_temp.get(i)) != null) {
				
				indices_ops_temp.add(i);
				
				
			}
			
		}
		
		
		for (int i : indices_ops_temp) {
			
			ArrayList<String> funcion = new ArrayList<>(Arrays.asList("("));
			
			for ( int j = i; !lista_ops_temp.get(j).equals(")"); j ++ ) {
				
				funcion.add(lista_ops_temp.get(j));
			}
			
			funcion.add(")");
			funcion.add(")");
			
			String funcion_evaluada = Double.toString(Funciones.function_exec(funcion));
			
			lista_ops_temp.set(i, funcion_evaluada);
			
			int quitar_a_partir_de = i + 1 + Funciones.listado_funciones.get(lista_ops_fijo.get(i)).get(0).size() + 1;
			
			for (int k = quitar_a_partir_de; k > i; k --) {
				
				lista_ops_temp.remove(i+1);
				
				
				
			}
			
			
			
			if (lista_ops_temp.get(i+1).equals(")")) {
				
				lista_ops_temp.remove(i+1);
				
			}
			
			if (lista_ops_temp.get(i-1).equals("(")) {
				
				lista_ops_temp.remove(i-1);
				
			}
			
		}
		
		
		System.out.println(calcular(lista_ops_temp));
		
		lista_ops_temp.clear();
		lista_ops_fijo.clear();
		
	}
	
	
	public static void asignar_op(ArrayList<String> expresion_base) {
		
		if (expresion_base.get(1).equals("setq")) {
			
			boolean isNum;
			
			
			
			try {
                Double.parseDouble(expresion_base.get(2));
                isNum = true;
            } catch (Exception e) {
                isNum = false;
            }
			
			
			
			if (expresion_base.size() != 5) {
				
				System.out.println("Se ha excedido la cantidad permisible de arumentos");
				Interprete.prompt();
				
			} else if (isNum) {
				
				
				System.out.println("No se pueden reasignar numeros");
				Interprete.prompt();
				
				
			} else {
				
				String nombre_var = expresion_base.get(2);
				String val_txt = expresion_base.get(expresion_base.size()-2); 
				
				Funciones.SETQ(nombre_var, val_txt);
				
			}
			
			
			
		} else if (expresion_base.get(1).equals("defun")){
			
			
			Funciones.FUNPREP_SET(expresion_base);
			
			
			
		} else {
			
			 
			try {
				
				lista_ops_temp.clear();
				
				Evaluador(expresion_base);
				
				
			} catch (Exception E) {
				
				E.printStackTrace();
				//System.out.println(" ha ocurrido un error al evaluar la expresion");
				
			}
			
			
		}
		
		
	}
	
	
	
	public static ArrayList<String> sustituir_vars(ArrayList<String> lista) {
		
		for (int i = 0; i < lista.size(); i++ ) {
			
			if (Funciones.listado_variables.get(lista.get(i)) != null){
				
				lista.set(i, Funciones.listado_variables.get(lista.get(i)));
				
			} else {
				
				// no cambiar
				
			}
			
			
			
		}
		
		return lista;
	}
	
	
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
			
		} else if (Funciones.listado_funciones.get(op) != null){
			
			// (+ (Celsius(100)) 2) 
			
		} else {
	
	     System.out.println("Operacion invalida");
	     Interprete.prompt();
		}
		
		return resultado;
	}
	
	
	
	
	public static Double calcular(ArrayList<String> lista) {
		
		lista_nums.clear();
		lista_ops.clear();
		
		if (lista.size() <= 3) {
			
			try {
			lista_nums.add(Double.parseDouble(lista.get(1)));
			
			} catch (Exception E) {
				System.out.println("Operacion no valida");
			}
			
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
		
		
		
		
		}
		
		return lista_nums.get(0);
		
}	
}	

