package compilador;

public class App {
	public static void main(String [] args) {
		
		
        try
        {
    		AnalisadorLexico analisador = new AnalisadorLexico("teste.txt");
            analisador.analisar();
            for (Token token : analisador.getTokens()) {
				System.out.println(token);
			}
        } catch(Exception e){
            e.printStackTrace();
        }
        
       
	}
}
