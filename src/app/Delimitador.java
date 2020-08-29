package app;

import java.util.Arrays;
import java.util.List;

public enum Delimitador {
	PONTOVIRG(";"),
	VIRG(","),
	PONTOFIM("\\."),
	DOISPONT(":"),
	ABREPAR("\\("),
	FECHPAR("\\)"),
	HASH("#"),
	ARR("@"),
	ABRECHA("\\{"),
	FECHCHA("\\}");
	
	private String regex;
	
	private Delimitador(String regex) {
		this.regex = regex;
	}
	
	public boolean match(String str) {
		return str.matches(this.regex);
	}
	
	public static List<Delimitador> getAsList(){
		return Arrays.asList(PONTOFIM, PONTOVIRG, DOISPONT, ABRECHA, ABREPAR, FECHCHA, FECHPAR, HASH, ARR, VIRG);
	}

	public String getRegex() {
		return regex;
	}
	
	public static boolean isDelimitador(String str) {
		for (Delimitador it : getAsList()) {
			if(str.matches(it.regex)) return true;
		}
		return false;
	}
	
	public static Delimitador getDelimitadorType(String str) {
		for (Delimitador it : getAsList()) {
			if(str.matches(it.regex)) return it;
		}
		return null;	
	}
	
	@Override
	public String toString() {
		return "Delimitador";
	}
}
