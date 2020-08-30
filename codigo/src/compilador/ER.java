package compilador;

import java.util.HashMap;

public class ER {
	public HashMap<String, String> regex;

	public ER(HashMap<String, String> regex) {
		super();
		this.regex = regex;
	}
	
	public boolean is(String str) {
		final boolean[] type = {false};
		regex.forEach((key, value) -> {
			if(str.matches(value))
				type[0] = true;
		});
		return type[0];
	}

	public String getType(String str) {
		final String[] type = {""};
		regex.forEach((key, value) -> {
			if(str.matches(value))
				type[0] = key;
		});
		return type[0];
	}
}
