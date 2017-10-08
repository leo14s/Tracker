import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeitorDoc {

	public LeitorDoc() {

	}

	ListaDoc lista = new ListaDoc();

	public ArrayList<String> leitor() throws IOException {
		ArrayList<String> lista = new ArrayList<String>();

		for (int i = 0; i < this.lista.listaDoc.length; i++) {
			File docFile = this.lista.listaDoc[i];

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(docFile), "UTF-8"));

			String line;
			String tag = null;
			String concat = "";

			while ((line = br.readLine()) != null) {

				if (line.contains("<!--RRCDT_")) {

					if (tag == null) {
						tag = line; // this.getTag(line);
					}
				} else if (tag != null) {
					concat = concat + line;
				}

				if (line.contains("<!--FIM")) {
					tag = tag + concat;

					CalculaHash calc = new CalculaHash();
					String stringzao = calc.stringComTagHash(tag);

					lista.add(stringzao);
					concat = "";
					tag = null;
				}
			}
			br.close();
		}
		return lista;
	}
	/*
	 * public String getTag(String line) {
	 * line = line.trim();
	 * line = line.replace(" ", "");
	 * line = line.replace("<", "");
	 * line = line.replace(">", "");
	 * line = line.replace("-", "");
	 * line = line.replace("!", "");
	 *
	 * return line;
	 * }
	 */

}
