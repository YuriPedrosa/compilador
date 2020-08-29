package app;

import java.util.Arrays;
import java.util.List;

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
	
	public static List<Tipo> getAsList(){
		return Arrays.asList(INT, FLOAT, VOID, STRING);
	}
	
	public static boolean isTipo(String str) {
		for (Tipo it : getAsList()) {
			if(str.matches(it.regex)) return true;
		}
		return false;
	}
	
	public static Tipo getTipoType(String str) {
		for (Tipo it : getAsList()) {
			if(str.matches(it.regex)) return it;
		}
		return null;	
	}
	
}
