public class Main {
	public static void main(String[] args) {
		BST<Letter> bst = new BST<Letter>();

		for (char c = 'A'; c < 'H'; c++) {
			System.out.println("Adding '" + String.valueOf(c) + "'");
			bst.add(new Letter(String.valueOf(c)));
		}

		BST<Letter>.MyIterator<Letter> itr = bst.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}