package app;

public enum Delimitador {
	PONTOVIRG(";"){
		@Override
		public String toString() {
			return "Delimitador Ponto e Virgula";
		}
	},
	PONTOFIM("."){
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
	ABRECHA("{"){
		@Override
		public String toString() {
			return "Delimitador Abre Chave";
		}
	},
	FECHCHA("}"){
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

	public String getRegex() {
		return regex;
	}
	
}
