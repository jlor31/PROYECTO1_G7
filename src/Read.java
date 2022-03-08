import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

    Scanner scan = new Scanner(System.in);

    public ArrayList<String> readDoc(String url) throws IOException {
        ArrayList<String> code = new ArrayList<>();
        try {

            FileReader reader = new FileReader(url);
            BufferedReader entry = new BufferedReader(reader);
            String a;

            while((a = entry.readLine()) != null) {
                code.add(a);
            }

        }
        catch(java.io.FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e);}
        return code;
    }

    public String print(@NotNull String code) {
        StringBuilder line = new StringBuilder();
        int i = 0;
        for(char a: code.toCharArray()) {
            if(i == 1) line.append(a);
            if(a == '\"') {
                if(i == 0) i = 1;
                else{
                    line = new StringBuilder(line.substring(0, line.length() - 1).trim());
                    i = 0;
                }
            }
        }
        return line.toString();
    }

    public Read() {}

    public String[] readEntry(String line) {
        line = line.replace("(", "").replace(")", "");
        String vrName, vrValue;

        String[] list = line.trim().split(" ");
        vrName = list[0];

        if(list[1].equals("read")) vrValue = scan.nextLine();
        else vrValue = list[1];

        return new String[] {vrName, vrValue};

    }
}
