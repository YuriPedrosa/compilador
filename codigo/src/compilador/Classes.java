package compilador;

import java.util.HashMap;

public class Classes extends ER{
	
	public Classes() {
		super(new HashMap<>());
		String letra = "[A-Za-z]";
		String digito = "[0-9]";
		String generic = "(" + letra + "|" + digito + ")*";
		regex.put("INTEIRO", "(" + digito + ")+");
		regex.put("FLOAT", regex.get("INTEIRO") + "\\." + regex.get("INTEIRO"));
		regex.put("CHAR", "\'" + generic  +"\'");
		regex.put("STRING", "\"(" + generic  +")*\"");
		regex.put("ID", letra + generic);
		regex.put("CONST", "#define");
	}
}
