import java.util.ArrayList;

public class Agregador {

	public Agregador() {

	}

	public ArrayList<ObjTrack> agregar(ArrayList<String> doc, ArrayList<String> selenium) {

		ArrayList<ObjTrack> arquivo = new ArrayList<ObjTrack>();

		for (int i = 0; i < doc.size(); i++) {
			for (int j = 0; j < doc.get(i).length(); j++) {
				if (doc.get(i).charAt(j) == '{') {
					String temp = doc.get(i).substring(0, j);
					String tagDoc = this.limpaString(temp);
					String hash = doc.get(i).substring(j + 1, doc.get(i).length() - 1);

					ObjTrack novo = new ObjTrack(tagDoc, hash, null);
					arquivo.add(novo);
				}
			}
		}

		for (int i = 0; i < selenium.size(); i++) {
			for (int j = 0; j < selenium.get(i).length(); j++) {
				if (selenium.get(i).charAt(j) == ',') {
					String tagSelen = selenium.get(i).substring(0, j);
					String classe = selenium.get(i).substring(j + 1, selenium.get(i).length());

					for (int h = 0; h < arquivo.size(); h++) {
						if (arquivo.get(h).getTag().equals(tagSelen)) {
							arquivo.get(h).setClasse(classe);
						}
					}

				}
			}
		}
		return arquivo;
	}

	public String limpaString(String line) {
		line = line.trim();
		line = line.replace(" ", "");
		line = line.replace("<", "");
		line = line.replace(">", "");
		line = line.replace("-", "");
		line = line.replace("!", "");

		return line;
	}
}
