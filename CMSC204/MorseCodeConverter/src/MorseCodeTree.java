import java.util.ArrayList;
/**
 * MoreCodeTree class the implements LinkedConverterTreeInterface
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	// fields
	private TreeNode<String> root;
	/*
	 * default Constructor using buildTree Method
	 */
	public MorseCodeTree() {
		root = new TreeNode<>("");
		buildTree();
	}
	/**
	 * getRoot method
	 * @return root returns the root
	 */
	@Override
	public TreeNode<String> getRoot(){
		return root;
	}
	/**
	 * setRoot method that sets root
	 * @param root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}
	/**
	 * buildTree method that works with constructor to create the tree
	 */
	@Override
	public void buildTree() {
		// level 1
		insert(".", "e");
		insert("-", "t");
		// level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		// level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		// level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	/**
	 * addNode method which adds elemnts recursiveley
	 * (.) means traverse left, (-) means traverse right. 
	 * @param root the root of the tree for this recursive instance
	 * @param code the code for this recursive isntance
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// base case
		if(code.length()==1) {
			// traverse left if its a (.)
			if(code.equals(".")) {
				root.setLeft(new TreeNode<>(letter));
			}
			// traverse right if its a (-)
			if(code.equals("-")) {
				root.setRight(new TreeNode<>(letter));
			}
		return;
		}
		// if the length isnt 1, try to recursive
		// recursive functioons
		if(code.charAt(0)== '.') {
			if(root.getLeft()==null) {
				root.setLeft(new TreeNode<>(""));	
			}
			// recurse
			addNode(root.getLeft(), code.substring(1), letter);
		} else if(code.charAt(0) == '-') {
			if(root.getRight() == null) {
				root.setRight(new TreeNode<>(""));
			}
			addNode(root.getRight(), code.substring(1), letter);
		}
	}
	/**
	 * insert method that calls addNode
	 * @param code the code for this instance
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void insert(String code, String letter) {
		addNode(root, code, letter);
	}
	/**
	 * fetch method that calls fetchNode which checks the tree recursively
	 * @param code the code for this instance
	 * @return the data of the TreeNode that is found
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	/**
	 * fetchNode method that checks the tree recursively
	 * (.) means traverse left, (-) means traverse right. 
	 * @param node the node for this recursive instance
	 * @param code the code for this recursive isntance
	 * @return the data of the TreeNode that is found
	 */
	@Override
	public String fetchNode(TreeNode<String> node, String code) {
		// null check
		if(node == null) {
			return null;
		}
		// base case
		if(code.length() == 0) {
			return node.getData();
		}
		// recursive functions
		if(code.charAt(0) == '.') {
			return fetchNode(node.getLeft(), code.substring(1));
		} else if(code.charAt(0) == '-') {
			return fetchNode(node.getRight(), code.substring(1));
		}
		return null;
	}
	/**
	 * toArrayList method that uses LNR to create an ArrayList of the tree
	 * @return the ArrayList of the tree
	 */
	@Override
	public ArrayList<String> toArrayList(){
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}
	/**
	 * LNRoutputTraversal method that traverses the tree in LNR order recursively
	 * @param root the root for this recursive instance
	 * @param list the ArrayList that is being created
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// check for null on branch
		if(root == null) {
			return;
		}
		// visit left subtree first
		LNRoutputTraversal(root.getLeft(), list);
		// visit root next
		String data = root.getData();
		if(data != null) {
			// include empty string only for root
			if(!data.isEmpty() || root == this.root) {
				list.add(data);
			}
		}
		// visit right subtree last
		LNRoutputTraversal(root.getRight(), list);
	}
	// Unsupported Operations
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Delete operation is not supported.");
	}
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Update operation is not supported.");
	}
}

