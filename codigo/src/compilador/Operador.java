package compilador;

import java.util.HashMap;

public class Operador extends ER{
	
	public Operador() {
		super(new HashMap<>(), new HashMap<>());
		regex.put("OPLOG", "&&|\\|\\||!");
		description.put("OPLOG", "Operador Lógico");
		regex.put("OPREL", "<|>|<=|>=|!=|==");
		description.put("OPREL", "Operador Relacional");
		regex.put("OPARIT", "\\+|-|\\*|/|%");
		description.put("OPARIT", "Operador Aritmético");
		regex.put("OPATRI", "=");
		description.put("OPATRI", "Operador Atribuição");
	}
}
