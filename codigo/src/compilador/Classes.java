package compilador;

import java.util.HashMap;

public class Classes extends ER{
	
	public Classes() {
		super(new HashMap<>(), new HashMap<>());
		String letra = "[A-Za-z]";
		String digito = "[0-9]";
		String generic = "(" + letra + "|" + digito + ")*";
		regex.put("INTEIRO", "(" + digito + ")+");
		description.put("INTEIRO", "Número Inteiro");
		regex.put("FLOAT", regex.get("INTEIRO") + "\\." + regex.get("INTEIRO"));
		description.put("FLOAT", "Número float");
		regex.put("CHAR", "\'" + generic  +"\'");
		description.put("CHAR", "Caractere");
		regex.put("STRING", "\"(" + generic  +")*\"");
		description.put("STRING", "Texto");
		regex.put("ID", letra + generic);
		description.put("ID", "Identificador");
		regex.put("CONST", "#define");
		description.put("CONST", "Declaração de constante");
	}
}
