package LISP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lector {


	
	// ArrayList<String>
	
	public static String cleaner(String exp) {  // limpiando y eliminando espacios excesivos etc...
		
		exp = exp.replaceAll("\\(", " ( ");
		
		exp = exp.replaceAll("\\)", " ) ");
		
		exp = exp.replaceAll("\s+"," ");
		
		exp = exp.replaceAll(" ", ",");
		
		exp = exp.toLowerCase();
		
		return exp;
	}
	
	
	
	public static ArrayList<String> leer(String exp) { 
	
		String exp_clean = cleaner(exp);  // limpianod expresion input usuario
		
		String[] base = exp_clean.split(",");  // separando el string basandose en comas
		
		List<String> lista_base = new ArrayList<String>();  
		
		lista_base = Arrays.asList(base);
		
		ArrayList<String> lista = new ArrayList<String>();  // conversion definitiva a arraylist
        
        lista.addAll(lista_base);
		
		if (lista.get(0).equals("")) {
			
			lista.remove(0);
			
		}
		
		if (lista.get(lista.size()-1).equals("")) {
			
			lista.remove(lista.size()-1);
			
		}
		
		
		ArrayList<String> lista_temp = new ArrayList<>(); // asegurando que no queden espacios inecesarios
		
		for (String i : lista) {
			
			lista_temp.add(i.replaceAll(" ", ""));
			
		}
		
		lista.clear();
		
		lista.addAll(lista_temp);
		
		lista_temp.clear(); // vaciando al lista temporal
		
		if (!lista.get(0).equals("(")) {  // verificando que vaya entre parentesis
			
			System.out.println("Expresion invalida, la operacion debe ir entre parentesis");
			
			
		}
			
		
		int abiertos = 0;
		int cerrados = 0;
		
		for (String i : lista ) { // verificando que no falten parentesis
			
			if (i.equals("(")) {
				
				abiertos = abiertos + 1;
				
			}
			else if (i.equals(")")) {
				
				cerrados = cerrados +1;
			}
			else {
				
			}
		}
		
		if (abiertos != cerrados) {
				
				System.out.println("ERROR... " + exp + "  Parentesis incompletos");
				
				
			
		}
		
		// el array esta listo para ser calculado
		
		
		
		return lista;
		
		
	}
	
	
	

	
}
