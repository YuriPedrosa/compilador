package app;

public enum Classes {
	LETRA("[A-Za-z]"),
	DIGITO("[0-9]"),
	NUMBER("(" + DIGITO.regex + ")*"),
	GENERIC("(" + LETRA.regex + "|" + DIGITO.regex + ")*"),
	GENERICTYPE(Tipo.INT.getRegex() + "|" + Tipo.FLOAT.getRegex() + "|" + Tipo.VOID.getRegex() + "|" + Tipo.STRING.getRegex()),
	
	ID(LETRA.regex + GENERIC.regex),
	LITERAL("^\".*\"$"),
	CONST(Delimitador.HASH.getRegex() + "define " + ID.regex + " " + GENERIC.regex),
	VAR("(" + GENERICTYPE.regex + ")" + " " + ID.regex + "( )*" + Delimitador.PONTOVIRG.getRegex()),
	
	TERMO("(" + ID.regex + "|" + DIGITO.regex + ")"),
	
	EXPR(TERMO.regex + "( )*("+ Operador.OPREL.getRegex()+")( )*" + TERMO.regex + "|" + TERMO.regex),
	IF(Reservado.IF.getRegex() + Delimitador.ABREPAR.getRegex() + "(" + EXPR.regex + ")" + Delimitador.FECHPAR.getRegex()),
	ELSE(Reservado.ELSE.getRegex() + "(" + IF.regex + ")?");
	
	
	
	private String regex;

	private Classes(String regex) {
		this.regex = regex;
	}
			
	public boolean match(String str) {
		System.out.println(this.regex);
		return str.matches(this.regex);
	}
	
	
	public static boolean isLetra(String str) {
		return str.matches(LETRA.regex);
	}
	
	public static boolean isNumber(String str) {
		return str.matches(NUMBER.regex);
	}
	
	public static boolean isLiteral(String str) {
		return str.matches(LITERAL.regex);
	}
	
	public static boolean isID(String str) {
		return str.matches(ID.regex);
	}
}
