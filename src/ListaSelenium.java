import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

public class ListaSelenium {

	// File dirDoc = new File("C:/Users/leo14/Documents/Projeto/esus/selenium");
	File dirSele = new File("C:/Users/leo14/Desktop/TCC/Exemplos");
	File[] listaSele;

	public ListaSelenium() {
		this.listaSele = this.listDir(this.dirSele);
	}

	public File[] listDir(File dir) {
		Vector enc = new Vector();
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				// Adiciona no Vector os arquivos encontrados dentro de 'files[i]':
				File[] recFiles = this.listDir(files[i]);
				for (int j = 0; j < recFiles.length; j++) {
					enc.addElement(recFiles[j]);
				}
			} else {
				// Adiciona no Vector o arquivo encontrado dentro de 'dir':
				enc.addElement(files[i]);
			}
		}
		// Transforma um Vector em um File[]:
		File[] encontrados = new File[enc.size()];
		for (int i = 0; i < enc.size(); i++) {
			encontrados[i] = (File) enc.elementAt(i);
		}

		ArrayList<File> list = new ArrayList();
		for (int i = 0; i < encontrados.length; i++) {
			if (encontrados[i].getName().startsWith("CDT")) {
				list.add(encontrados[i]);
			}
		}
		File[] lista = new File[list.size()];

		for (int i = 0; i < list.size(); i++) {
			lista[i] = list.get(i);
		}
		return lista;
	}

}