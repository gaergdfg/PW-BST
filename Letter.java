public class Letter implements Comparable<Letter> {
	private String content;


	Letter(String content) {
		this.content = content;
	}


	public String getContent() {
		return content;
	}


	public int compareTo(Letter other) {
		return ((String)content).compareTo(other.getContent());
	}


	public String toString() {
		return getContent();
	}
}
