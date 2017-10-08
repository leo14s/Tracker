
public class ObjTrack {

	String tag;
	String hash;
	String classe;

	public ObjTrack(String t, String h, String c) {
		this.tag = t;
		this.hash = h;
		this.classe = c;
	}

	@Override
	public String toString() {
		String tudo = this.tag + "{" + this.hash + "}" + this.classe;
		return tudo;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getClasse() {
		return this.classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

}
