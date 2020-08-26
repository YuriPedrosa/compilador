package app;

import java.util.Arrays;
import java.util.List;

public class App {
			
	public static void main(String [] args) {
		String str = "int main(){}";
		List<String> strs = Arrays.asList(str.split(""));
		
		System.out.println(Classes.IF.match("if(1>2)"));

	}
	
}
