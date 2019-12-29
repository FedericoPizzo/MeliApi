package traductor;

import javax.ws.rs.core.MediaType;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/traductor")
public class TraductorMorseTexto {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{input}")

	public String entrada(@PathParam("input") String input) {

		if (input.contains(".") || input.contains("-")) {

			return (decodeBits2Morse(input));
			
		} else {

			return (translateHuman2Morse(input));
			
		}

	}

	// Texto a Morse
	public static String translateHuman2Morse(String input) {

		HashMap<String, String> dictionary = new HashMap<>();
		dictionary.put(" ", " ");
		dictionary.put("A", ".-");
		dictionary.put("B", "-...");
		dictionary.put("C", "-.-.");
		dictionary.put("D", "-..");
		dictionary.put("E", ".");
		dictionary.put("F", "..-.");
		dictionary.put("G", "--.");
		dictionary.put("H", "....");
		dictionary.put("I", "..");
		dictionary.put("J", ".---");
		dictionary.put("K", "-.-");
		dictionary.put("L", ".-..");
		dictionary.put("M", "--");
		dictionary.put("N", "-.");
		dictionary.put("O", "---");
		dictionary.put("P", ".--.");
		dictionary.put("Q", "--.-");
		dictionary.put("R", ".-.");
		dictionary.put("S", "...");
		dictionary.put("T", "-");
		dictionary.put("U", "..-");
		dictionary.put("V", "...-");
		dictionary.put("W", ".--");
		dictionary.put("X", "-..-");
		dictionary.put("Y", "-.--");
		dictionary.put("Z", "--..");

		dictionary.put("1", ".----");
		dictionary.put("2", "..---");
		dictionary.put("3", "...--");
		dictionary.put("4", "....-");
		dictionary.put("5", ".....");
		dictionary.put("6", "-....");
		dictionary.put("7", "--...");
		dictionary.put("8", "---..");
		dictionary.put("9", "----.");
		dictionary.put("0", "-----");

		String morse = "";

		for (char c : input.toCharArray()) {

			morse += dictionary.get((c + "").toUpperCase()) + " ";
		}

		return morse;
		
	}

	public static String decodeBits2Morse(String input) {

		HashMap<String, String> dictionary = new HashMap<>();
		dictionary.put(" ", " ");
		dictionary.put(".-", "A");
		dictionary.put("-...", "B");
		dictionary.put("-.-.", "C");
		dictionary.put("-..", "D");
		dictionary.put(".", "E");
		dictionary.put("..-.", "F");
		dictionary.put("--.", "G");
		dictionary.put("....", "H");
		dictionary.put("..", "I");
		dictionary.put(".---", "J");
		dictionary.put("-.-", "K");
		dictionary.put(".-..", "L");
		dictionary.put("--", "M");
		dictionary.put("-.", "N");
		dictionary.put("---", "O");
		dictionary.put(".--.", "P");
		dictionary.put("--.-", "Q");
		dictionary.put(".-.", "R");
		dictionary.put("...", "S");
		dictionary.put("-", "T");
		dictionary.put("..-", "U");
		dictionary.put("...-", "V");
		dictionary.put(".--", "W");
		dictionary.put("-..-", "X");
		dictionary.put("-.--", "Y");
		dictionary.put("--..", "Z");
		dictionary.put(".----", "1");
		dictionary.put("..---", "2");
		dictionary.put("...--", "3");
		dictionary.put("....-", "4");
		dictionary.put(".....", "5");
		dictionary.put("-....", "6");
		dictionary.put("--...", "7");
		dictionary.put("---..", "8");
		dictionary.put("----.", "9");
		dictionary.put("-----", "0");

		StringBuilder builderFrase = new StringBuilder();

		String[] palabras = input.split("  ");
		int j = 0;

		for (int i = 0; i <= palabras.length - 1; i++) {

			StringBuilder builderPalabras = new StringBuilder();
			String[] parts = palabras[j].split(" ");

			for (String c : parts) {
				if (c.equals("")) {
					builderPalabras.append("");
				} else {
					builderPalabras.append(dictionary.get((c).toUpperCase()));

				}
			}

			builderFrase.append(builderPalabras);
			builderFrase.append(" ");

			j++;
		}

		return builderFrase.toString();

	}

}
