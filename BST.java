package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
	if(this.root == null) { //if no root exists, then one is created
		this.root = new BST_Node(s);
		size++;
		return true;
	}else if(this.root.insertNode(s) == true) {
		size++;
		return true;
	}else if(this.contains(s) == true) {
		return false; // insert is unsuccessful because it already contains the s
	}
	return false;
}

@Override
public boolean remove(String s) {
	if(size == 0) { // cannot remove if there is nothing there
		return false;
	}
	if(this.root.data.equals(s)) { // to see if this is what needs to be removed 
		BST_Node test = new BST_Node("null");
		test.left = root;
		boolean successRemoval = test.removeNode(s, test);
		this.root = test.getLeft();
		size--;
		return successRemoval;
	}
	size--;
	return this.root.removeNode(s, null);
}

@Override
public String findMin() { 
	if(size == 0) { //is tree size is 0, return null
		return null;
	}
	return this.root.findMin().getData();
}

@Override
public String findMax() {
	if(size == 0) { //is tree size is 0, return null
		return null;
	}
	return this.root.findMax().getData();
}

@Override
public boolean empty() {
	if(size == 0) { // true if the tree has no elements in it, true if size is 0
		return true;
	}
	return false;
}

@Override
public boolean contains(String s) {
	if(size != 0 && this.root.containsNode(s)) { //return false if tree size is 0
		return true;
	}
	return false;
}

@Override
public int size() {
	return size;
}

@Override
public int height() {
	if(size == 0 || this.root == null) { //return -1 is tree is empty (size is 0, root is null)
		return -1;
	}
	return this.root.getHeight();
}
}
