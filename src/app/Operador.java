package app;

public enum Operador {
	OPLOG("&&|\\|\\||!"){
		@Override
		public String toString() {
			return "Operador L�gico";
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
			return "Operador Aritm�tico";
		}
	},
	OPATRI("="){
		@Override
		public String toString() {
			return "Operador Atribui��o";
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
