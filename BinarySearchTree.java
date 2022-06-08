public class BinarySearchTree {
	private Node root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public void setRoot(Node root)
	{
		this.root = root;
	}
		
	public void insertNode(Node z)
	{ 
		Node x = getRoot();
		Node y = null;
		while (x != null) {
			y = x;
			if (z.getKey() < x.getKey()) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
		z.setParent(y);
		if (y == null) setRoot(z);
		else if (z.getKey() < y.getKey()) {
			y.setLeft(z);
		}
		else {
			y.setRight(z);
		} 
	}
	
	public Node getNode(Node x, int key)
	{
		if (x == null || key == x.getKey()) return x;
		if (key < x.getKey()) return getNode(x.getLeft(), key);
		else return getNode(x.getRight(), key);
	}
}

class Node {
	private final int key;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(int key)
	{
		this.key = key;
		parent = null;
		left = null;
		right = null;
	}
	
	public int getKey()
	{
		return key;
	}
	
	public Node getParent()
	{
		return parent;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public void setLeft(Node n)
	{
		left = n;
	}
	
	public void setRight(Node n)
	{
		right = n;
	}

	public void setParent(Node n)
	{
		parent = n;
	}
}