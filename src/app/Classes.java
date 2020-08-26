package app;

public enum Classes {
	LETRA("[A-Za-z]"),
	DIGITO("[0-9]"),
	GENERIC("(" + LETRA.regex + "|" + DIGITO.regex + ")*"),
	GENERICTYPE(Tipo.INT.getRegex() + "|" + Tipo.FLOAT.getRegex() + "|" + Tipo.VOID.getRegex() + "|" + Tipo.STRING.getRegex()),
	
	ID(LETRA.regex + GENERIC.regex),
	CONST(Delimitador.HASH.getRegex() + "define " + ID.regex + " " + GENERIC.regex),
	VAR("(" + GENERICTYPE.regex + ")" + " " + ID.regex + "( )*" + Delimitador.PONTOVIRG.getRegex()),
	
	TERMO("(" + ID.regex + "|" + DIGITO.regex + ")"),
	
	EXPR(TERMO.regex + "( )*("+ Operador.OPREL.getRegex()+")( )*" + TERMO.regex + "|" + TERMO.regex),
	IF(Reservado.IF.getRegex() + Delimitador.ABREPAR.getRegex() + "(" + EXPR.regex + ")" + Delimitador.FECHPAR.getRegex())
	
	
	;
	
	
	
	private String regex;

	private Classes(String regex) {
		this.regex = regex;
	}
			
	public boolean match(String str) {
		System.out.println(this.regex);
		return str.matches(this.regex);
	}
}
