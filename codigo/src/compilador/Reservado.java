package compilador;

import java.util.HashMap;

public class Reservado extends ER{

	public Reservado() {
		super(new HashMap<>(), new HashMap<>());
		regex.put("IF", "if");
		description.put("IF", "Palavra Reservada");
		regex.put("ELSE", "else");
		description.put("ELSE", "Palavra Reservada");
		regex.put("MAIN", "main");
		description.put("MAIN", "Palavra Reservada");
		regex.put("RETURN", "return");
		description.put("RETURN", "Palavra Reservada");
		regex.put("FOR", "for");
		description.put("FOR", "Palavra Reservada");
		regex.put("WHILE", "while");
		description.put("WHILE", "Palavra Reservada");
	}

}
