package app;

public enum Tipo {
	INT("int"),
	FLOAT("float"),
	VOID("void"),
	STRING("string");
	
	private String regex;

	private Tipo(String regex) {
		this.regex = regex;
	}
	
	public boolean match(String str) {
		return str.matches(this.regex);
	}

	public String getRegex() {
		return regex;
	}
	
}
