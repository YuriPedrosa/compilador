package compilador;

import java.util.HashMap;

public class Operador extends ER{
	
	public Operador() {
		super(new HashMap<>());
		regex.put("OPLOG", "&&|\\|\\||!");
		regex.put("OPREL", "<|>|<=|>=|!=|==");
		regex.put("OPARIT", "\\+|-|\\*|/|%");
		regex.put("OPATRI", "=");
	}
}
