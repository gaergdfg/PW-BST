import java.util.Iterator;
import java.util.NoSuchElementException;


public class BST<T extends Comparable<T>> {
	protected T value;

	protected BST<T> left;
	protected BST<T> right;

	protected BST<T> father;


	BST() {}


	BST(T element, BST<T> father) {
		value = element;
		this.father = father;
	}


	public void add(T element) {
		if (value == null) {
			value = element;
			return;
		}

		int diff = value.compareTo(element);

		if (diff > 0) {
			if (left == null) {
				left = new BST<T>(element, this);
			} else {
				left.add(element);
			}
		} else if (diff < 0) {
			if (right == null) {
				right = new BST<T>(element, this);
			} else {
				right.add(element);
			}
		}
	}


	public boolean find(T element) {
		if (value == null) {
			return false;
		}

		int diff = value.compareTo(element);

		if (diff == 0) {
			return true;
		} else if (diff > 0) {
			if (left == null) {
				return false;
			}
			return left.find(element);
		} else {
			if (right == null) {
				return false;
			}
			return right.find(element);
		}
	}


	/* ==================== MyIterator ==================== */
	public MyIterator<T> iterator() {
		return new MyIterator<T>(this);
	}


	public class MyIterator<J> implements Iterator<T> {
		private BST<T> curr;


		MyIterator(BST<T> tree) {
			curr = tree;
			if (curr == null) {
				return;
			}

			while (curr.left != null) {
				curr = curr.left;
			}
		}


		public boolean hasNext() {
			return curr != null;
		}


		// zakladamy, ze przy pierwszym wywolaniu jestesmy w wierzcholku z najmniejszym elementem
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			T next = curr.value;

			if (curr.right != null) {
				curr = curr.right;

				while (curr.left != null) {
					curr = curr.left;
				}
			} else {
				do {
					curr = curr.father;
				} while (curr != null && curr.value.compareTo(next) < 0);
			}

			return next;
		}
	}
}
