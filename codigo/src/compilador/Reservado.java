package compilador;

import java.util.HashMap;

public class Reservado extends ER{

	public Reservado() {
		super(new HashMap<>());
		regex.put("IF", "if");
		regex.put("ELSE", "else");
		regex.put("MAIN", "main");
		regex.put("RETURN", "return");
	}

}
