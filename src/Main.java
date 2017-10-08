import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String arg[]) throws IOException {

		LeitorDoc leitorDoc = new LeitorDoc();
		ArrayList<String> arrayDoc = leitorDoc.leitor();

		LeitorSelenium leitorSelen = new LeitorSelenium();
		ArrayList<String> arraySelen = leitorSelen.leitor();

		Agregador junta = new Agregador();

		ArrayList<ObjTrack> arquivo = junta.agregar(arrayDoc, arraySelen);

		Persistir p = new Persistir();

		Comparador c = new Comparador();

		File bd = new File("C:/Users/leo14/Desktop/TCC/Exemplos/BD_Regras.txt");
		if (bd.exists()) {
			c.compararArquivos(bd, arquivo);
			bd.delete();
		}
		p.escreveArquivo(arquivo);

	}

	// problemas?
	// codigo tá uma massaroca mas funfa.
	// se não tiver uma classe relacionada a regra vai ficar null
	// ...
}
