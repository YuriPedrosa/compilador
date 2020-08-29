package app;

import java.util.Arrays;
import java.util.List;

public enum Operador {
	OPLOG("&&|\\|\\||!"){
		@Override
		public String toString() {
			return "Operador Lógico";
		}
	},
	OPREL("<|>|<=|>=|!=|=="){
		@Override
		public String toString() {
			return "Operador Relacional";
		}
	},
	OPARIT("\\+|-|\\*|/|%"){
		@Override
		public String toString() {
			return "Operador Aritmético";
		}
	},
	OPATRI("="){
		@Override
		public String toString() {
			return "Operador Atribuição";
		}
	};
	
	private String regex;

	private Operador(String regex) {
		this.regex = regex;
	}
	
	public boolean match(String str) {
		return str.matches(this.regex);
	}
	
	public String getRegex() {
		return regex;
	}
	
	public static List<Operador> getAsList(){
		return Arrays.asList(OPLOG, OPREL, OPARIT, OPATRI);
	}
	
	public static boolean isOperador(String str) {
		for (Operador it : getAsList()) {
			if(str.matches(it.regex)) return true;
		}
		return false;
	}
	
	public static Operador getOperadorType(String str) {
		for (Operador it : getAsList()) {
			if(str.matches(it.regex)) return it;
		}
		return null;	
	}
}
