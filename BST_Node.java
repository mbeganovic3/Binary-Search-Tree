package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  /* compareTo()
   * positive number: >
   * negative number: <
   * zero: =
   */
  public boolean containsNode(String s){ 
	  if(this.data == s) { 
		  return true;
	  }else if(this.data.compareTo(s) > 0) { //item has to be in the left subtree 
		  if(this.getLeft() == null) {
			  return false;
		  }
		  return this.getLeft().containsNode(s);
	  }else if(this.data.compareTo(s) < 0) { //item has to be in the right subtree
		  if(this.getRight() == null) {
			  return false;
		  }
		  return this.getRight().containsNode(s);
	  }
	return false; //if nothing contains s
  }
  
  public boolean insertNode(String s){ 
	  if(this.data == s) { // already has it so cannot insert 
		  return false;
	  }else if(this.data.compareTo(s) > 0) { // item has to be in the left subtree
		  if(this.getLeft() == null) {
			  this.left = new BST_Node(s);
			  return true;
		  }else {
			  return this.left.insertNode(s); //recursion
		  }
	  }else if(this.data.compareTo(s) < 0) { // item has to be in the right subtree
		  if(this.getRight() == null) {
			  this.right = new BST_Node(s);
			  return true;
		  }else {
			  return this.right.insertNode(s); //recursion
		  }
	  }
	return false;
  }
  
  public boolean removeNode(String s, BST_Node parent) { // added another parameter
	  if(s.compareTo(this.data) < 0) {
		  if(this.getLeft() != null) {
			  return this.getLeft().removeNode(s, this);
		  }
		  return false;
	  }else if(s.compareTo(this.data) > 0) {
		  if(this.getRight() != null) {
			  return this.getRight().removeNode(s, this);
		  }
		  return false; 
	  }else {
		  if(this.getLeft() != null && this.getRight() != null) {
			  this.data = this.getRight().findMin().getData();
			  right.removeNode(this.data, this);
		  }else if(parent.getLeft() == this) {
			  if(this.getLeft() != null) {
				  parent.left = left;
			  }else {
				  parent.left = this.getRight();
			  }
		  }else if(parent.getRight() == this) {
			  if(this.getLeft() != null) {
				  parent.right = this.getLeft();
			  }else {
				  parent.right = this.getRight();
			  }
		  }
		  return true;
	  }
  }
  
  //follow left links until hit null
  public BST_Node findMin(){ 
	  if(this.left != null) { 
		  return this.left.findMin();
	  }
	return this;
  }
  
  //follow right links until hit null
  public BST_Node findMax(){ 
	  if(this.right != null) { 
		  return this.right.findMax();
	  }
	return this; 
  }
  
  public int getHeight(){
	  if(this.getLeft() == null && this.getRight() == null) {
		  return 0;
	  }else if(this.getLeft() != null && this.getRight() == null) { //left child, no right
		  return this.getLeft().getHeight() + 1;
	  }else if(this.getLeft() == null && this.getRight() != null) { //right child, no left
		  return this.getRight().getHeight() + 1;
	  }
	  if(this.getLeft().getHeight() >= this.getRight().getHeight()) {
		  return this.getLeft().getHeight() + 1;
	  }else {
		  return this.getRight().getHeight() + 1;
	  }
  }
 

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}
