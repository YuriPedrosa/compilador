package compilador;

import java.util.HashMap;

public class Operador extends ER{
	
	public Operador() {
		super(new HashMap<>(), new HashMap<>());
		regex.put("OPLOG", "&&|\\|\\||!");
		description.put("OPLOG", "Operador L�gico");
		regex.put("OPREL", "<|>|<=|>=|!=|==");
		description.put("OPREL", "Operador Relacional");
		regex.put("OPARIT", "\\+|-|\\*|/|%");
		description.put("OPARIT", "Operador Aritm�tico");
		regex.put("OPATRI", "=");
		description.put("OPATRI", "Operador Atribui��o");
	}
}
