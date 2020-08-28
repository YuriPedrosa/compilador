package app;

public class Token {
	private String token;
	private String lexema;
	private String descricao;
	private int linha;
	
	public Token(String token, String lexema, String descricao, int linha) {
		super();
		this.token = token;
		this.lexema = lexema;
		this.descricao = descricao;
		this.linha = linha;
	}

	@Override
	public String toString() {
		return "Token [token=" + token + ", lexema=" + lexema + ", descricao=" + descricao + ", linha=" + linha + "]";
	}
}
