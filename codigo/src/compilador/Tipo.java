package compilador;

import java.util.HashMap;

public class Tipo extends ER{

	public Tipo() {
		super(new HashMap<>(), new HashMap<>());
		regex.put("INT", "int");
		description.put("INT", "Tipo int");
		regex.put("FLOAT", "float");
		description.put("FLOAT", "Tipo float");
		regex.put("VOID", "void");
		description.put("void", "Tipo void");
		regex.put("STRING", "string");
		description.put("STRING", "Tipo string");
	}
}
