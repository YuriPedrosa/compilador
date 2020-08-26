package app;

public enum Reservado {
	IF("if"),
	ELSE("else"),
	MAIN("main");
	
	private String regex;

	private Reservado(String regex) {
		this.regex = regex;
	}
	
	public boolean match(String str) {
		return str.matches(this.regex);
	}
	
	public String getRegex() {
		return regex;
	}
}
