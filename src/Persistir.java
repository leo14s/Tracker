import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Persistir {

	public Persistir() {

	}

	public void escreveArquivo(ArrayList<ObjTrack> array) throws IOException {
		FileWriter arq = new FileWriter("C:/Users/leo14/Desktop/TCC/Exemplos/BD_Regras.txt");
		PrintWriter gravarArq = new PrintWriter(arq);

		for (int i = 0; i < array.size(); i++) {
			gravarArq.printf(array.get(i).toString() + "%n");
		}

		arq.close();
	}
}
