

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
		totalLinks = 0;
		totalCuts = 0;
		nodesMarked = 0;
}
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

	public void setTotalCuts(int totalCuts) {
		FibonacciHeap.totalCuts = totalCuts;
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
    	
    	HeapNode insertNode = new HeapNode(key,null,null,null,getMin(),getMin().getRight());
    	getMin().right.left = insertNode;
    	getMin().right = insertNode;
    	    	    	
    	if (getMin()==null || key<getMin().key){
    		setMin(insertNode);
    	}
    	
    	size++;
    	
    	return insertNode; // should be replaced by student code
    }
    
    public void insertHeapNode(HeapNode node)
    {    
    	
    	getMin().right.left = node;
    	getMin().right = node;
    	    	
    	if (getMin()==null || node.getKey()<getMin().key){
    		setMin(node);
    	}
    	
    	size++;
    	
    	return; // should be replaced by student code
    }

   /**
    * public void deleteMin()
    *
    * Delete the node containing the minimum key.
    *
    */
    public void deleteMin()
    {
    	
    	HeapNode minNode = getMin();
    	if (minNode == null) {
    		return;
    	}
    	
    	
    	
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
    	return this.getMin();// should be replaced by student code
    } 
    
   /**
    * public void meld (FibonacciHeap heap2)
    *
    * Meld the heap with heap2
    *
    */
    public void meld (FibonacciHeap heap2)
    {
    	
    	if(heap2 == null || heap2.getSize()==0){
    		return;
    	}
    	
    	if(this == null || this.getSize()==0){
    		setMin(heap2.getMin());
    		setSize(heap2.getSize());
    		return;
    	}
    	
    	HeapNode heap2Min = heap2.getMin();
    	setSize(getSize() + heap2.getSize());
    	
    	getMin().right.left = heap2Min.left;
    	heap2Min.left.right = getMin().right;
    	getMin().right = heap2Min;
    	heap2Min.left = getMin();

    	if (heap2Min.key < getMin().key){
    		setMin(heap2Min);	
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
    	return this.getSize(); // should be replaced by student code
    }
    	
    /**
    * public int[] countersRep()
    *
    * Return a counters array, where the value of the i-th entry is the number of trees of order i in the heap. 
    * 
    */
    public int[] countersRep()
    {
    	int[] arr = new int[42];
    	HeapNode current = getMin();
    	for (int i = 0; i < numOfRoots(); i++){
    		arr[current.getRank()]++;
    	}
        return arr; 
    }

   /**
    * public void arrayToHeap()
    *
    * Insert the array to the heap. Delete previous elemnts in the heap.
    * 
    */
    public void arrayToHeap(int[] array)
    {
    	setMin(null);
    	setSize(0);
    	// should we need to null nodesMarked, totalLinks and totalCuts to??? 
    	for (int i = 0; i < array.length; i++){
    	    insert(array[i]);
    	}
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
    	
    	decreaseKey(x, Integer.MIN_VALUE);
    	deleteMin();
    	
//    	if(getMin() == x){
//    		deleteMin();
//    	}
//    	else{
//    		cut(x);
//    		
//    	}
    	
    	return; // should be replaced by student code
    }

   /**
    * public void decreaseKey(HeapNode x, int delta)
    *
    * The function decreases the key of the node x by delta. The structure of the heap should be updated
    * to reflect this chage (for example, the cascading cuts procedure should be applied if needed).
    */
    public void decreaseKey(HeapNode x, int delta)
    {    
    	if(x == null){
    		return;
    	}
    	
    	int newKey = x.getKey()-delta;
    	x.setKey(x.getKey()-delta);
    	HeapNode xParent = x.getParent();
    	if (x.isRoot() && newKey<getMin().key){
    		setMin(x);
    		return;
    	}
    	else if(!x.isRoot() & xParent!=null && newKey < xParent.getKey()){
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
    	if(firstNode.rank!=secondNode.rank){
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
    	
    	return;
    	
    }
    
    public void cut(HeapNode cutNode) 
    {    
    	totalCuts++;
    	HeapNode cutNodeParent = cutNode.getParent();
    	cutNode.setMark(false);
    	nodesMarked--;
    	cutNodeParent.setRank(cutNodeParent.getRank()-1);
    	
    	if(cutNode.getRight()==cutNode){
    		cutNodeParent.child = null;
    	}
    	else {
    		cutNodeParent.child = cutNode.right;
    		cutNode.left.right = cutNode.right;
    		cutNode.right.left = cutNode.left;
    	}
    	
    	cutNode.setParent(null);
    	insertHeapNode(cutNode);
    	
    	return;
    }

    public void cascadingCut(HeapNode cutNode) 
    {    
    	HeapNode cutNodeParent = cutNode.getParent();
    	cut(cutNode);
    	
    	if(cutNodeParent != null){
    		if(!cutNodeParent.isMark()){
    			cutNodeParent.setMark(true);
    			nodesMarked++;
    		}
    		else{
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
    	return totalLinks; // should be replaced by student code
    }

   /**
    * public static int totalCuts() 
    *
    * This static function returns the total number of cut operations made during the run-time of the program.
    * A cut operation is the operation which diconnects a subtree from its parent (during decreaseKey/delete methods). 
    */
    public static int totalCuts()
    {    
    	return totalCuts; // should be replaced by student code
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
		public HeapNode(int key,String info, HeapNode parent, HeapNode left, HeapNode child, HeapNode right) {
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.child = child;
			this.key = key;
			this.info = info;
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
	    	return getParent() == null;// should be replaced by student code
	    } 
    }
    
    public static void main(String[] args){
    	
    }
    
}
