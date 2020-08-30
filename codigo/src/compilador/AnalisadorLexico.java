package compilador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalisadorLexico {
	private BufferedReader arquivo;
	private String linha;
	private List<Token> tokens;
	private String ch; 
	private String lexema;
	private int numeroLinha;
	private boolean coment;
	private HashMap<String, ER> map;

	public List<Token> getTokens() {
		return tokens;
	}

	public AnalisadorLexico(String nomeArquivo) throws IOException {
		this.arquivo = new BufferedReader(new FileReader(nomeArquivo));
		this.linha = "";
		this.numeroLinha = 0;
		this.coment = false;
		this.lexema = "";
		this.tokens = new ArrayList<Token>();
		this.map = new HashMap<String, ER>();
		map.put("Delimitador", new Delimitador());
		map.put("Operador", new Operador());
		map.put("Reservado", new Reservado());
		map.put("Tipo", new Tipo());
		map.put("Classes", new Classes());
		
	}

	public void fechaArquivo() throws IOException {
		this.arquivo.close();
		this.linha = "";
	}

	private void getNewLine() {
		try {
			linha = arquivo.readLine();
			if (linha != null)
				linha.concat("\n");
			numeroLinha++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void analisar() {
		getNewLine();
		while(linha != null) {
			for(int i = 0 ; i < linha.length(); i++) {
				ch = linha.substring(i, i+1);		
				
				if(ch.equals("/")) {
					String next = getNextChar(i);
					if(next.equals("/")) break;
					if(next.equals("*")) {
						while(!linha.contains("*/")) {
							getNewLine();
							if(linha == null) break;
						}
						linha.indexOf("*/");
					}
				}
				
			}
			
			getNewLine();
		}
	}
	
	public String getNextChar(int i) {
		if(i < linha.length()-1) 
			return linha.substring(i+1, i+2);
		return "";		
	}
		
	private void addToken(String str, int linha) {
		
		for (Map.Entry<String, ER> it: map.entrySet()) {
			if(it.getValue().is(str)) {
				tokens.add(new Token(it.getValue().getType(str), str, it.getValue().getType(str), linha));
				return;
			}
		}
		
		tokens.add(new Token("UKNOWN", str, "Desconhecido", linha));
    }
    

}


