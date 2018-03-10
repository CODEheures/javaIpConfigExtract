import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TestScanner {

	public static void main(String[] args) throws IOException {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			System.out.print("Give me a number: ");
			String d1 = null;
			double myDouble = 0;
			
			while (true) {
				try {
					d1 = scanner.next("\\d+[,\\.]?\\d*");
					Pattern replaceVirgule = Pattern.compile("[,]");
					myDouble = Double.parseDouble(replaceVirgule.matcher(d1).replaceAll("."));
					System.out.println(myDouble);
					break;
				} catch (InputMismatchException e) {
					System.out.print("Not a number, retry: ");
					
					// Cette ligne permet de boucler et demander de relire au clavier avec la même contrainte
					scanner.next();
				}
			}
			
			System.out.println("Bye bye");
		}
		
	}

}
