import java.security.MessageDigest;

public class CalculaHash {

	public CalculaHash() {

	}
	/*
	 * posso tirar os <!-- --> e dividir com ",". Fica pra depois.
	 */

	public String getTag(String t) {
		int inicio = 0;
		int flag = -1;
		String tag = "";

		for (int i = 0; i > flag; i++) {
			if (t.charAt(i) == '-' && t.charAt(i + 1) == '-' && t.charAt(i + 2) == '>') {
				flag = i + 10;
				inicio = i + 3;
			}

		}

		tag = t.substring(0, inicio);

		return tag;
	}

	public String getTexto(String t) {
		String texto = "";
		int comeco = 0;
		int fim = 0;
		int flag = -1;

		for (int i = 0; i > flag; i++) {
			if (t.charAt(i) == '-' && t.charAt(i + 1) == '-' && t.charAt(i + 2) == '>') {
				flag = i + 10;
				comeco = i + 3;

			}
		}

		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == 'F' && t.charAt(i + 1) == 'I' && t.charAt(i + 2) == 'M') {
				fim = i - 4;
			}
		}

		texto = t.substring(comeco, fim);

		return texto;
	}

	public String stringComTagHash(String t) {
		String stringTagHash = "";
		String tag = this.getTag(t);
		String texto = this.getTexto(t);

		String hash = this.generateHash(texto);

		stringTagHash = tag + "{" + hash + "}";

		return stringTagHash;
	}

	public String generateHash(String texto) {

		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(texto.getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			String textoHex = hexString.toString();
			return textoHex;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		}
	}
}
