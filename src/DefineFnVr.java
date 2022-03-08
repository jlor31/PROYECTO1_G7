import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DefineFnVr {

    private HashMap<String, ArrayList<String>> functions;
    private HashMap<String, String> variables;

    public void createFn(String name, ArrayList<String> code){
        functions.put(name, code);

    }
    public ArrayList<String> excecuteFn(String name){
        ArrayList<String> result;
        result = null;
        for(Map.Entry<String, ArrayList<String>> indivFn:functions.entrySet()){
            if(indivFn.getKey().equals(name)){
                result = indivFn.getValue();
            }
        }
        return result;
    }
    public void createVr (String name, String value){
        variables.put(name, value);
    }
    public String showVr(String name){
        String value= "";
        for (Map.Entry<String, String> indivVr: variables.entrySet()){
            if(indivVr.getKey().equals(name)) value = indivVr.getValue();
        }
        if(value.equals("")) return null;
        else return value;
    }
    public HashMap<String, String> getVr (){
        return variables;
    }
    public HashMap<String, ArrayList<String>> getFN (){
        return functions;
    }
    public ArrayList<String> getBody(String name){
        return functions.get(name);
    }
    public String getName(String name){
        return variables.get(name);
    }
    public DefineFnVr() {
        functions = new HashMap<String, ArrayList<String>>();
        variables = new HashMap<String, String>();
    }
}
