import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeitorSelenium {

	public LeitorSelenium() {

	}

	ListaSelenium lista = new ListaSelenium();

	public ArrayList<String> leitor() throws IOException {
		ArrayList<String> lista = new ArrayList<String>();

		for (int i = 0; i < this.lista.listaSele.length; i++) {
			File seleFile = this.lista.listaSele[i];

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(seleFile), "UTF-8"));

			String line;
			String tag = "";
			String concat = "";
			String classe = "";

			while ((line = br.readLine()) != null) {

				if (line.contains("@track")) {
					tag = this.getTag(line);
					classe = seleFile.getName();
					concat = tag + "," + classe;
					lista.add(concat);
				}
			}
			br.close();
		}
		return lista;
	}

	public String getTag(String line) {
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '@' && line.charAt(i + 1) == 't' && line.charAt(i + 2) == 'r' && line.charAt(i + 3) == 'a' && line.charAt(i + 4) == 'c'
					&& line.charAt(i + 5) == 'k') {
				line = line.substring(i + 6);
				line = line.replace(" ", "");
				line = line.trim();
				return line;
			}
		}

		return null;
	}

}
