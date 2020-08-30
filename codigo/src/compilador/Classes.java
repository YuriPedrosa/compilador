package compilador;

import java.util.HashMap;

public class Classes extends ER{
	
	public Classes() {
		super(new HashMap<>());
		regex.put("LETRA", "[A-Za-z]");
		regex.put("DIGITO", "[0-9]");
		regex.put("INTEIRO", "(" + regex.get("DIGITO") + ")*");
		regex.put("LITERAL", "^\".*\"$");
		String generic = "(" + regex.get("LETRA") + "|" + regex.get("DIGITO") + ")*";
		regex.put("ID", regex.get("LETRA") + generic);
	}
}
