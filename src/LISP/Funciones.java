package LISP;

import java.util.ArrayList;
import java.util.HashMap;

public class Funciones {

	static HashMap<String, ArrayList<ArrayList<String>>> listado_funciones = new HashMap<>();
	
	static HashMap<String, String> listado_variables = new HashMap<>();
	
	static ArrayList<ArrayList<String>> args_ops = new ArrayList<ArrayList<String>>();
	
	public static void SETQ(String nombre, String valor) {
		
		listado_variables.put(nombre, valor);
		
	}
	
	public static void DEFUN(String nombre, ArrayList<String> args, ArrayList<String> ops) {  
		
		args_ops.add(args);
		args_ops.add(ops);
		
		listado_funciones.put(nombre, new ArrayList<ArrayList<String>>(args_ops));
		
		args_ops.clear();
		
	}
	
	public static void FUNPREP_SET(ArrayList<String> lista_base) {
		
		// formato (defun <name> (list of arguments) (function body))
		
		String nombre = lista_base.get(2);
		ArrayList<String> args = new ArrayList<String>();
		ArrayList<String> ops = new ArrayList<String>();
		
		
		int counter = 0;
		
		for (int i = 4; !lista_base.get(i).equals(")"); i ++) {
			
			args.add(lista_base.get(i));
			
			counter = i+1;
			
			
			
		}
		
		
		for (int i = counter; i < lista_base.size()-2; i ++) {
			
			ops.add(lista_base.get(i+1));
			
		}
		
		DEFUN(nombre, args, ops);
		
		
	}
	
	
	public static Double function_exec(ArrayList<String> lista_base) {
		
		// asi llega [(, funcion, (, sumar,(,8,9,),2, 3, 4, ), )]
		
		double resultado = 0;
		
		ArrayList<String> vals = new ArrayList<>();
		ArrayList<String> args = new ArrayList<>(listado_funciones.get(lista_base.get(1)).get(0));
		ArrayList<String> ops = new ArrayList<>(listado_funciones.get(lista_base.get(1)).get(1));
		HashMap<String, String> vals_temp = new HashMap<>();
		
		
		
		for (int i = 3; i < lista_base.size()-2; i++ ) {
			
			vals.add(lista_base.get(i));
			
			
		}
		
		if (vals.size() == args.size()) {  // verificando que la cantidad de argumentos corresponda a los vals ingresados
			
			
			for (int i = 0; i < vals.size();  i ++) {
				
				vals_temp.put(args.get(i), vals.get(i));
				
			}
			
			for (int i = 0; i < ops.size(); i++ ) {
				
				if (vals_temp.get(ops.get(i)) != null){
					
					ops.set(i, vals_temp.get(ops.get(i)));
					
				} else {
					
					// no cambiar
					
				}
			
			}
			
			resultado = Operador.calcular(Operador.sustituir_vars(ops));
			
				
			
		} else {
			
			System.out.println("El numero de argumentos excede los esperados");
			
			
		}
		
		return resultado;
		
	}
	
	
	
	
	
}
