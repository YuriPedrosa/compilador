package compilador;

import java.util.HashMap;

public class Delimitador extends ER{
	
	public Delimitador() {
		super(new HashMap<>());
		regex.put("PONTOVIRG",";");
		regex.put("PONTOFIM", "\\.");
		regex.put("VIR", ",");
		regex.put("HASH", "#");
		regex.put("ARR", "@");
		regex.put("ABRECH", "\\{");
		regex.put("FECHACH", "\\}");
		regex.put("FECHAPAR", "\\)");
		regex.put("ABREPAR", "\\(");
		regex.put("DOISPONT", ":");
	}
}
