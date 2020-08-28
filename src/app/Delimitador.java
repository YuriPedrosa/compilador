package app;

import java.util.Arrays;
import java.util.List;

public enum Delimitador {
	PONTOVIRG(";"){
		@Override
		public String toString() {
			return "Delimitador Ponto e Virgula";
		}
	},
	VIRG(","),
	ESPACO(" "),
	PONTOFIM("\\."){
		@Override
		public String toString() {
			return "Delimitador Ponto Final";
		}
	},
	DOISPONT(":"){
		@Override
		public String toString() {
			return "Delimitador Dois Pontos";
		}
	},
	ABREPAR("\\("){
		@Override
		public String toString() {
			return "Delimitador Abre Parenteses";
		}
	},
	FECHPAR("\\)"){
		@Override
		public String toString() {
			return "Delimitador Fecha Parenteses";
		}
	},
	HASH("#"){
		@Override
		public String toString() {
			return "Delimitador Hashtag";
		}
	},
	ARR("@"){
		@Override
		public String toString() {
			return "Delimitador Arrouba";
		}
	},
	ABRECHA("\\{"){
		@Override
		public String toString() {
			return "Delimitador Abre Chave";
		}
	},
	FECHCHA("\\}"){
		@Override
		public String toString() {
			return "Delimitador Fecha Chaves";
		}
	};
	
	private String regex;
	
	private Delimitador(String regex) {
		this.regex = regex;
	}
	
	public boolean match(String str) {
		return str.matches(this.regex);
	}
	
	public static List<Delimitador> getAsList(){
		return Arrays.asList(PONTOFIM, PONTOVIRG, DOISPONT, ABRECHA, ABREPAR, FECHCHA, FECHPAR, HASH, ARR, ESPACO, VIRG);
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
}
