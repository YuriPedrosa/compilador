package compilador;

import java.util.HashMap;

public class Tipo extends ER{

	public Tipo() {
		super(new HashMap<>());
		regex.put("INT", "int");
		regex.put("FLOAT", "float");
		regex.put("VOID", "void");
		regex.put("STRING", "string");
	}
}
