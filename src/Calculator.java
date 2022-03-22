import java.util.HashMap;
import java.util.Vector;

public class Calculator {

    private String num;
    private String operator;
    private HashMap<String, String> variables;
    private Vector<Double> vector;
    private double resultado;

    public Calculator(String operator) throws Exception {
        this.vector = new Vector<Double>(10,5);
        this.resultado = 0;
    }

    public void add(Double item) {
        vector.add(item);
    }

    public Double remove() {
        Double num = vector.remove(size()-1);
        return num;
    }

    public Double peek() {
        return vector.get(size()-1);
    }

    public boolean empty() {
        boolean emptiness = false;
        if(size() == 0)
        {
            emptiness = true;
        }
        return emptiness;
    }

    public int size() {
        return vector.size();
    }

    public Double calculate(String operation) throws Exception {
        for (int i = 0; i < operation.length(); i++) {
            if(isOperator(operation.substring(i, i+1))) {
                operate(operation.substring(i, i+1));
            } else if (isNumber(operation.substring(i,i+1))) {
                add(Double.parseDouble(operation.substring(i, i+1))); // agrega el elemento como un numero usando stack
            }
        }
        resultado = remove();//ya que el resultado se guardó en el vector, debería ser su único item y por lo tanto lo elimina y devuelve como resultado final
        return resultado;
    }

    protected boolean isOperator(String c){
        return (c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/"));
    }

    protected boolean isNumber(String c) {
        return ("1".equals(c)||"2".equals(c)||"3".equals(c)||"4".equals(c)||"5".equals(c)||"6".equals(c)||"7".equals(c)||"8".equals(c)||"9".equals(c)||"0".equals(c));
    }

    protected void operate(String operator) {
        Double resultante = 0.0;
        Double b = remove();
        Double a = remove();
        switch(operator) {
            case "+":
                resultante = a + b;
                break;
            case "-":
                resultante = a-b;
                break;
            case "*":
                resultante = a*b;
                break;
            case "/":
                if(b!=0){//lidiar con divisiones por 0
                    resultante = a/b;
                }else{
                    resultante = 0.0;
                }
                break;
            default:
                System.out.println("Ocurrió un error y no se realizó la operación");
                break;
        }
        add(resultante); // agrega el resultado al stack de Vector
    }



}

