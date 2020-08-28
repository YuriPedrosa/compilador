package app;

import java.util.Arrays;
import java.util.List;

public enum Reservado {
	IF("if"),
	ELSE("else"),
	MAIN("main"),
	RETURN("return");
	
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
	
	public static List<Reservado> getAsList(){
		return Arrays.asList(IF, ELSE, MAIN, RETURN);
	}
	
	public static boolean isReservado(String str) {
		for (Reservado it : getAsList()) {
			if(str.matches(it.regex)) return true;
		}
		return false;
	}
	
	public static Reservado getReservadoType(String str) {
		for (Reservado it : getAsList()) {
			if(str.matches(it.regex)) return it;
		}
		return null;	
	}
}
