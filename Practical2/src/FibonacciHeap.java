

/**
 * FibonacciHeap
 *
 * An implementation of fibonacci heap over non-negative integers.
 */
public class FibonacciHeap
{
	private HeapNode min; //the minimum of the heap
	private int size; 
	private int nodesMarked; 
	private static int totalLinks; 
	private static int totalCuts; 
	
	//FibonacciHeap Constructor
	public FibonacciHeap(){
		this.min = null;
		this.size = 0;
<<<<<<< HEAD
		this.totalLinks = 0;
		this.totalCuts = 0;
		this.nodesMarked = 0;
	}

=======
		this.nodesMarked = 0;
		totalLinks = 0;
		totalCuts = 0;
		
}
>>>>>>> refs/remotes/origin/master
	//Getters & Setters for the elements of the heap
   public HeapNode getMin() {
		return min;
	}

	public void setMin(HeapNode min) {
		this.min = min;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalLinks() {
		return totalLinks;
	}

	public void setTotalLinks(int totalLinks) {
		FibonacciHeap.totalLinks = totalLinks;
	}

	public int getTotalCuts() {
		return totalCuts;
	}

	public int getNodesMarked() {
		return nodesMarked;
	}
	public void setNodesMarked(int nodesMarked) {
		this.nodesMarked = nodesMarked;
	}
	public void setTotalCuts(int totalCuts) {
		FibonacciHeap.totalCuts = totalCuts;
	}
	public int getNodesMarked(){
		return nodesMarked;
	}
	public void setNodesMarked(int nodesMarked){
		this.nodesMarked = nodesMarked;
	}

/**
    * public boolean empty()
    *
    * precondition: none
    * 
    * The method returns true if and only if the heap
    * is empty.
    *   
    */
    public boolean empty()
    {
    	return 0==this.getSize(); // should be replaced by student code
    }
		
   /**
    * public HeapNode insert(int key)
    *
    * Creates a node (of type HeapNode) which contains the given key, and inserts it into the heap. 
    */
    public HeapNode insert(int key)
    {    
    	
<<<<<<< HEAD
    	HeapNode insertNode = new HeapNode(key,null,null,this.getMin(),this.getMin().getRight());
    	this.getMin().getRight().setLeft(insertNode);
    	this.getMin().setRight(insertNode);
    	    	
    	if (key<this.getMin().getKey()){
    		this.setMin(min);
=======
    	HeapNode insertNode = new HeapNode(key);
    	
    	if(getMin()==null){
    		setMin(insertNode);
    		insertNode.setRight(insertNode);
    		insertNode.setLeft(insertNode);
>>>>>>> refs/remotes/origin/master
    	}
    	
    	else{
    		insertNode.setRight(getMin().right);
    		insertNode.setLeft(getMin().left);
        	getMin().right.left = insertNode;
        	getMin().right = insertNode;
        	    	    	
        	if (key<getMin().key){
        		setMin(insertNode);
        	}
    	}

    	size++;
		return insertNode;
		
    }
    
    public void insertHeapNode(HeapNode insertNode)
    {    
<<<<<<< HEAD
    	this.getMin().getRight().setLeft(node);
    	this.getMin().setRight(node);
    	    	
    	if (node.getKey()<this.getMin().getKey()){
    		this.setMin(min);
=======
    	
    	if(getMin()==null){
    		setMin(insertNode);
    		insertNode.setRight(insertNode);
    		insertNode.setLeft(insertNode);
>>>>>>> refs/remotes/origin/master
    	}
    	
<<<<<<< HEAD
    	this.setSize(this.getSize()+1);
    	
    	return; // should be replaced by student code
=======
    	else{
    		insertNode.setRight(getMin().right);
    		insertNode.setLeft(getMin().left);
        	getMin().right.left = insertNode;
        	getMin().right = insertNode;
        	    	    	
        	if (insertNode.getKey()<getMin().key){
        		setMin(insertNode);
        	}
    	}

    	size++;
		return;
		
>>>>>>> refs/remotes/origin/master
    }

   /**
    * public void deleteMin()
    *
    * Delete the node containing the minimum key.
    *
    */
    public void deleteMin()
    {
    	
    	HeapNode minNode = this.getMin();
    	if (minNode == null) { //?
    		return;
    	}
<<<<<<< HEAD
=======
    	
    	
    	
    	
    	
>>>>>>> refs/remotes/origin/master
     	return; // should be replaced by student code
     	
    }

   /**
    * public HeapNode findMin()
    *
    * Return the node of the heap whose key is minimal. 
    *
    */
    public HeapNode findMin()
    {
    	if (!this.empty()) {
    		return this.getMin();
    	}
    	return null;
    } 
    
   /**
    * public void meld (FibonacciHeap heap2)
    *
    * Meld the heap with heap2
    *
    */
    public void meld (FibonacciHeap heap2)
    {
    	//if the other heap is empty, we have nothing to merge
    	if(heap2 == null || heap2.getSize()==0){
    		return;
    	}
<<<<<<< HEAD
    	// if the current heap is empty
    	if(this == null || this.getSize() == 0){
    		this.setMin(heap2.getMin());
    		this.setSize(heap2.getSize());
    		this.setNodesMarked(heap2.getNodesMarked());
    		return; //?
=======
    	
    	// if the current heap is empty
    	if(this == null || this.getSize() == 0){
    		this.setMin(heap2.getMin());
    		this.setSize(heap2.getSize());
    		this.setNodesMarked(heap2.getNodesMarked());
    		return;
>>>>>>> refs/remotes/origin/master
    	}
    	
    	HeapNode heap2Min = heap2.getMin();
<<<<<<< HEAD
    	this.setSize(getSize() + heap2.getSize());
    	this.getMin().getRight().setLeft(heap2Min.getLeft());
    	heap2Min.getLeft().setRight(this.getMin().getRight());
    	this.getMin().setRight(heap2Min);
    	heap2Min.setLeft(this.getMin());
=======
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
=======
    	this.setSize(getSize() + heap2.getSize());
    	this.getMin().getRight().setLeft(heap2Min.getLeft());
    	heap2Min.getLeft().setRight(this.getMin().getRight());
    	this.getMin().setRight(heap2Min);
    	heap2Min.setLeft(this.getMin());
    	

>>>>>>> refs/remotes/origin/master
    	if (heap2Min.getKey() < getMin().getKey()){
    		this.setMin(heap2Min);	
    	}


    	  return;   		
    }

   /**
    * public int size()
    *
    * Return the number of elements in the heap
    *   
    */
    public int size()
    {
    	return this.getSize();
    }
    	
    /**
    * public int[] countersRep()
    *
    * Return a counters array, where the value of the i-th entry is the number of trees of order i in the heap. 
    * 
    */
    public int[] countersRep()
    {
    	//no need to calculate the running time 
    	int[] arr = new int[42];
    	HeapNode current = this.getMin();
<<<<<<< HEAD
=======
    	arr[current.getRank()]++;
    	current = current.getRight();
>>>>>>> refs/remotes/origin/master
    	while (current.getRight() == this.getMin()){
    		arr[current.getRank()]++;
    		current = current.getRight();
    	}
        return arr; 
    }

   /**
    * public void arrayToHeap()
    *
    * Insert the array to the heap. Delete previous elements in the heap.
    * 
    */
    public void arrayToHeap(int[] array)
    {
    	//Delteing previous elements
    	this.setMin(null);
    	this.setSize(0);
    	this.setTotalCuts(0);
    	this.setTotalLinks(0);
<<<<<<< HEAD
    	this.setNodesMarked(0);
    	// should we need to null nodesMarked, totalLinks and totalCuts to??? 
=======
    	this.setNodesMarked(0);    	
    	
>>>>>>> refs/remotes/origin/master
    	for (int i = 0; i < array.length; i++){
<<<<<<< HEAD
    	    this.insert(array[i]);
    	}
=======
    		this.insert(array[i]);
    		}
>>>>>>> refs/remotes/origin/master
        return;
    }
	
   /**
    * public void delete(HeapNode x)
    *
    * Deletes the node x from the heap. 
    *
    */
    public void delete(HeapNode x) 
    {    
<<<<<<< HEAD
    	if(this.getMin() == x){
    		this.deleteMin();
    	}
    	else{
    		this.cut(x);
    		
    	}
    	return; // should be replaced by student code
=======
    	
    	decreaseKey(x, Integer.MIN_VALUE);
    	deleteMin();
    	
    	return;
>>>>>>> refs/remotes/origin/master
    }

   /**
    * public void decreaseKey(HeapNode x, int delta)
    *
    * The function decreases the key of the node x by delta. The structure of the heap should be updated
    * to reflect this change (for example, the cascading cuts procedure should be applied if needed).
    */
    public void decreaseKey(HeapNode x, int delta)
    {    
    	if(x == null){
    		return;
    	}
    	
    	int newKey = x.getKey()-delta;
<<<<<<< HEAD
    	x.setKey(x.getKey()-delta);
=======
    	x.setKey(newKey);
    	HeapNode xParent = x.getParent();
>>>>>>> refs/remotes/origin/master
    	if (x.isRoot() && newKey<this.getMin().getKey()){
    		setMin(x);
    		return;
    	}
<<<<<<< HEAD
    	else if(!x.isRoot() & newKey >= x.getParent().getKey()){ //??
    		
    	}
    	else {
=======
    	else if(!x.isRoot() & xParent!=null && newKey < xParent.getKey()){
>>>>>>> refs/remotes/origin/master
    		cascadingCut(x);
    	}
    	return;
    }
    
    public int numOfRoots() {
    	if(getMin() == null){
    		return 0;
    	}
    	int num = 1;
    	
    	HeapNode currNode = getMin().getRight();
    	
    	while(getMin() != currNode){
    		num++;
    		currNode = currNode.getRight();
    	}
    	
    	return num;
    }

   /**
    * public int potential() 
    *
    * This function returns the current potential of the heap, which is:
    * Potential = #trees + 2*#marked
    * The potential equals to the number of trees in the heap plus twice the number of marked nodes in the heap. 
    */
    public int potential() 
    {    
    	return numOfRoots() + 2*nodesMarked;
    }
    
    public void Link(HeapNode firstNode,HeapNode secondNode) {
    	if(firstNode.getRank()!=secondNode.getRank()){
    		return;
    	}
    	if(firstNode.getKey() > secondNode.getKey()){
    		HeapNode tempNode = secondNode;
    		secondNode = firstNode;
    		firstNode = tempNode;
    	}
    	if(firstNode.getChild() == null){
    		secondNode.setRight(secondNode);
    	}
    	else{
    		secondNode.setRight(firstNode.getChild().getRight());
    		firstNode.getChild().setRight(secondNode);
    	}
    	firstNode.setChild(secondNode);
    	secondNode.setMark(false);
    	totalLinks++;
    }
    
    public void successiveLinking() {
    	
    	int[] arr = new int[42];
    	arrayToHeap(arr);
    	
    	
    }
    
    public void cut(HeapNode cutNode) 
<<<<<<< HEAD
    {   
    	//all the roots are non-marked
    	cutNode.setMark(false);
    	
    	if (cutNode.getParent() == null)
    		return;
    	totalCuts++;
    	HeapNode cutNodeParent = cutNode.getParent();
=======
    {    
    	//all the roots are non-marked
    	cutNode.setMark(false);
    	totalCuts++;
>>>>>>> refs/remotes/origin/master
    	nodesMarked--;


    	if (cutNode.getParent() == null)
    		return;
    	
    	HeapNode cutNodeParent = cutNode.getParent();
    	cutNodeParent.setRank(cutNodeParent.getRank()-1);
    	
    	if(cutNode.getRight() == cutNode){
    		cutNodeParent.setChild(null);
<<<<<<< HEAD
    	} else {
    		cutNodeParent.setChild(cutNode.getRight());
    		cutNode.getLeft().setRight(cutNode.getRight());
    		cutNode.getRight().setLeft(cutNode.getLeft());
    		
=======
    	}
    	else {
    		cutNodeParent.setChild(cutNode.getRight());
    		cutNode.getLeft().setRight(cutNode.getRight());
    		cutNode.getRight().setLeft(cutNode.getLeft());
>>>>>>> refs/remotes/origin/master
    	}
    	
    	cutNode.setParent(null);
    	insertHeapNode(cutNode);
    	
    	return;
    }

    public void cascadingCut(HeapNode cutNode) 
    {    
    	HeapNode cutNodeParent = cutNode.getParent();
    	cut(cutNode);
    	
    	if (cutNodeParent != null){ //check if we got to the first level
    		if(!cutNodeParent.isMark()){
    			cutNodeParent.setMark(true);
    			nodesMarked++;
    		} else{
    			cascadingCut(cutNodeParent);
    		}
    	}
    	
    	return;
    }
   /**
    * public static int totalLinks() 
    *
    * This static function returns the total number of link operations made during the run-time of the program.
    * A link operation is the operation which gets as input two trees of the same rank, and generates a tree of 
    * rank bigger by one, by hanging the tree which has larger value in its root on the tree which has smaller value 
    * in its root.
    */
    public static int totalLinks()
    {    
    	return totalLinks; 
    }

   /**
    * public static int totalCuts() 
    *
    * This static function returns the total number of cut operations made during the run-time of the program.
    * A cut operation is the operation which diconnects a subtree from its parent (during decreaseKey/delete methods). 
    */
    public static int totalCuts()
    {    
    	return totalCuts;
    }
    
    
    
   /**
    * public class HeapNode
    * 
    * If you wish to implement classes other than FibonacciHeap
    * (for example HeapNode), do it in this file, not in 
    * another file 
    *  
    */
    public class HeapNode {
    	
		private HeapNode left; // The left child
		private HeapNode right; // The right child
		private HeapNode parent; // The parent
		private HeapNode child; // One of the node child
		private boolean mark; // If true then the node lost a child, false otherwise 
		private int key; // The key of the node 
		private String info; // the info of the node
		private int rank; // The rank of the node
		
		//HeapNode Constructor
		public HeapNode(int key) {
			this.parent = null;
			this.left = null;
			this.right = null;
			this.child = null;
			this.key = key;
			this.info = null;
			this.rank=0;
			this.mark = false;
		}

		//Getters & Setters for the elements of the node
		public HeapNode getLeft() {
			return left;
		}


		public void setLeft(HeapNode left) {
			this.left = left;
		}


		public HeapNode getRight() {
			return right;
		}


		public void setRight(HeapNode right) {
			this.right = right;
		}


		public HeapNode getParent() {
			return parent;
		}


		public void setParent(HeapNode parent) {
			this.parent = parent;
		}


		public HeapNode getChild() {
			return child;
		}


		public void setChild(HeapNode child) {
			this.child = child;
		}


		public boolean isMark() {
			return mark;
		}


		public void setMark(boolean mark) {
			this.mark = mark;
		}


		public int getKey() {
			return key;
		}


		public void setKey(int key) {
			this.key = key;
		}


		public String getInfo() {
			return info;
		}


		public void setInfo(String info) {
			this.info = info;
		}


		public int getRank() {
			return rank;
		}


		public void setRank(int rank) {
			this.rank = rank;
		}
		
		public boolean isRoot()
	    {
	    	return (getParent() == null);
	    } 
		
		private void print(int level) {
			HeapNode curr = this;
			do {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < level; i++) {
					sb.append("  ");
				}
				sb.append(curr.getKey());
				System.out.println(sb.toString());
				if (curr.getChild() != null) {
					curr.getChild().print(level + 1);
				}
				curr = curr.getRight();
			} while (curr != this);
		}
		
    }
    
    public static void main(String[] args){
    	
    }
    
}
