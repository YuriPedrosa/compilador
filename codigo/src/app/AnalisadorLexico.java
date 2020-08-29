package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {
	private BufferedReader arquivo;
	private String arquivoNome;
	private String linha;
	private List<Token> tokens;
	private String ch; 
	private String lexema;
	private int numeroLinha;
	private boolean coment;
	

	public List<Token> getTokens() {
		return tokens;
	}

	public AnalisadorLexico(String nomeArquivo) throws IOException {
		this.arquivo = new BufferedReader(new FileReader(nomeArquivo));
		this.arquivoNome = nomeArquivo;
		this.linha = "";
		this.numeroLinha = 0;
		this.coment = false;
		this.lexema = "";
		this.tokens = new ArrayList<Token>();
		
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

	public void analise() {
		while(true) {
			getNewLine();
			if(linha == null)
				break;
			
			int tam = linha.length();
			ch = "";
			
			for(int i = 0; i < tam; i++) {
				ch = linha.substring(i, i+1);
				if(Delimitador.isDelimitador(ch) || ch.equals(" ")) {

					if(!coment && lexema.length() >= 2 && lexema.startsWith("//")) {
						lexema = "";
						if(Delimitador.isDelimitador(ch)) {
							addToken(ch, numeroLinha);	
						}
						break;
					}
					
					if(!coment && lexema.length() >= 2 && lexema.startsWith("/*")) {
						lexema = "";
						coment = true;
					}
					
					if(!coment && lexema.length() >= 2 && lexema.startsWith("*/")) {
						lexema = "";
						coment = false;
					}
					
					if(!coment && (!lexema.isEmpty() && !lexema.contains("/*"))) 
						addToken(lexema, numeroLinha);
					
					if(Delimitador.isDelimitador(ch)) {
						addToken(ch, numeroLinha);	
					}
					
					lexema = "";
				} else lexema = lexema + ch;
			}
		}

	}
	
	private void addToken(String str,int linha) {
		
		if(Delimitador.isDelimitador(str)) {
			Delimitador d = Delimitador.getDelimitadorType(str);
			tokens.add(new Token(d.name(), str, d.toString(), linha));
			return;
		}
		
		if(Classes.isNumber(str)) {
			tokens.add(new Token(Classes.NUMBER.name(), str, Classes.NUMBER.toString(), linha));
			return;
		}
		
		if(Classes.isLiteral(str)) {
			tokens.add(new Token(Classes.LITERAL.name(), str, Classes.LITERAL.toString(), linha));
			return;
		}

		if(Operador.isOperador(str)) {
			Operador o = Operador.getOperadorType(str);
			tokens.add(new Token(o.name(), str, o.toString(), linha));
			return;
		}
		
		if(Tipo.isTipo(str)) {
			Tipo t = Tipo.getTipoType(str);
			tokens.add(new Token(t.name(), str, t.toString(), linha));
			return;
		}
		
		if(Reservado.isReservado(str)) {
			Reservado r = Reservado.getReservadoType(str);
			tokens.add(new Token(r.name(), str, r.toString(), linha));
			return;
		}else if(Classes.isID(str)){
			tokens.add(new Token(Classes.ID.name(), str, Classes.ID.toString(), linha));
			return;
		}
		
		tokens.add(new Token("UKNOWN", str, "Desconhecido", linha));
    }
    

}



