import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Comparador {

	public Comparador() {

	}

	public void compararArquivos(File antigo, ArrayList<ObjTrack> novo) throws IOException {

		ArrayList<ObjTrack> velho = this.montaArray(antigo);

		for (int i = 0; i < novo.size(); i++) {
			for (int j = 0; j < velho.size(); j++) {
				if (novo.get(i).getTag().equals(velho.get(j).getTag())) {
					if (!novo.get(i).getHash().equals(velho.get(j).getHash())) {
						System.out.println("Rever Caso de Teste " + novo.get(i).getClasse() + " pois a regra " + novo.get(i).getTag() + " mudou!");
					} else {
						System.out.println("Regra " + novo.get(i).getTag() + " conserva-se inalterada!");
					}
				}
			}
		}

	}

	public ArrayList<ObjTrack> montaArray(File f) throws IOException {
		ArrayList<ObjTrack> velho = new ArrayList<ObjTrack>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));

		String line;
		String tag = "";
		String hash = "";
		String classe = "";
		int fimTag = 0;

		while ((line = br.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '{') {
					tag = line.substring(0, i);
					fimTag = i;
				}
				if (line.charAt(i) == '}') {
					hash = line.substring(fimTag + 1, i);
					classe = line.substring(i, line.length());
				}
			}
			ObjTrack obj = new ObjTrack(tag, hash, classe);
			velho.add(obj);
		}
		br.close();

		return velho;
	}
}
