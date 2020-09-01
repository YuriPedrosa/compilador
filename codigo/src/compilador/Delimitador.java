package compilador;

import java.util.HashMap;

public class Delimitador extends ER{
	
	public Delimitador() {
		super(new HashMap<>(), new HashMap<>());
		regex.put("PONTOVIRG",";");
		description.put("PONTOVIRG", "Delimitador ponto e virgula");	
		regex.put("PONTOFIM", "\\.");
		description.put("PONTOFIM", "Delimitador ponto final");
		regex.put("VIR", ",");
		description.put("VIR", "Delimitador virgula");
		regex.put("HASH", "#");
		description.put("HASH", "Delimitador hash");
		regex.put("ARR", "@");
		description.put("ARR", "Delimitador arrouba");
		regex.put("ABRECH", "\\{");
		description.put("ABRECH", "Delimitador abre chaves");
		regex.put("FECHACH", "\\}");
		description.put("FECHACH", "Delimitador fecha chaves");
		regex.put("FECHAPAR", "\\)");
		description.put("FECHAPAR", "Delimitador fecha parenteses");
		regex.put("ABREPAR", "\\(");
		description.put("ABREPAR", "Delimitador abre parenteses");
		regex.put("DOISPONT", ":");
		description.put("DOISPONT", "Delimitador dois pontos");
	}
}
