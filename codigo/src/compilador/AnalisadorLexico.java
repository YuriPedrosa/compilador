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
	private HashMap<String, ER> map;

	public List<Token> getTokens() {
		return tokens;
	}

	public AnalisadorLexico(String nomeArquivo) throws IOException {
		this.arquivo = new BufferedReader(new FileReader(nomeArquivo));
		this.linha = "";
		this.numeroLinha = 0;
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
			linha = linha.trim();
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
						if(linha.indexOf("*/")+1 == linha.length()-1) break;
						else i = linha.indexOf("*/")+2;
					}
				}
				
				ch = linha.substring(i, i+1);
				if(map.get("Operador").is(ch)) {
					String withNext = ch+getNextChar(i);
					addToken(lexema, numeroLinha);
					if(map.get("Operador").is(withNext)) {
						addToken(withNext, numeroLinha);
						i++;
					} else addToken(ch, numeroLinha);
					lexema = "";
				} else if(map.get("Delimitador").is(ch) || ch.equals(" ")) {
					if(ch.equals(".") || ch.equals("#")) lexema += ch;
					else {
						addToken(lexema, numeroLinha);	
						addToken(ch, numeroLinha);
						lexema = "";
					}
				} else lexema += ch;
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
		
		if(str.isEmpty() || str.equals(" ")) return;

		for (Map.Entry<String, ER> it: map.entrySet()) {
			if(it.getValue().is(str)) {
				String type = it.getValue().getType(str);
				String description = it.getValue().getDescription(type);
				tokens.add(new Token(type, str, description, linha));
				return;
			}
		}
		
		tokens.add(new Token("ERRO", str, "Desconhecido", linha));
    }
    

}



