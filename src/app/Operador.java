package app;

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
}
