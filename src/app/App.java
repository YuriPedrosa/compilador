package app;

import java.util.Arrays;
import java.util.List;

public class App {
			
	public static void main(String [] args) {
        try
        {
    		AnalisadorLexico analisador = new AnalisadorLexico("teste.txt");
            analisador.analise();
            for (Token token : analisador.getTokens()) {
				System.out.println(token);
			}
        } catch(Exception e){
            e.printStackTrace();
        }

	}
	
}
