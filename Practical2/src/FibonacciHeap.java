

/**
 * FibonacciHeap
 *
 * An implementation of fibonacci heap over non-negative integers.
 *
 * Maya Cahana, 205973225 username: mayacahana
 * Ron Tabibian, 308472596 username: rontabibian
 *
 *
 */
public class FibonacciHeap
{
	private HeapNode min; //the minimum of the heap
	private int size; 
	private int nodesMarked; 
	static int totalLinks =0; 
	static int totalCuts =0; 
	
	//FibonacciHeap Constructor
	public FibonacciHeap(){
		this.min = null;
		this.size = 0;
		this.nodesMarked = 0;
		
		
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

	public int getNodesMarked() {
		return nodesMarked;
	}
	public void setNodesMarked(int nodesMarked) {
		this.nodesMarked = nodesMarked;
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
    	return 0==this.getSize();
    }
		
   /**
    * public HeapNode insert(int key)
    *
    * Creates a node (of type HeapNode) which contains the given key, and inserts it into the heap. 
    * 
    */
    public HeapNode insert(int key)
    {    
    	//create the new node
    	HeapNode insertNode = new HeapNode(key);
    	
    	//check if the tree is empty
    	if(getMin()==null){
    		setMin(insertNode);
    		insertNode.setRight(insertNode);
    		insertNode.setLeft(insertNode);
    	}
    	// if the tree is not empty, we add the new node to the roots list
    	else{
    		HeapNode temp = this.getMin().getRight();
    		this.getMin().setRight(insertNode);
    		this.getMin().getRight().setLeft(this.getMin());
    		insertNode.setRight(temp);
    		insertNode.getRight().setLeft(insertNode);
        	//update the minimum    	    	
        	if (key<getMin().key){
        		setMin(insertNode);
        	}
    	}
    	//update the size
    	size++;
		return insertNode;
		
    }
    /**
     * insertHeapNode
     * @param insertNode
     * get a HeapNode and insert it to the heap
     * 
     */
    public void insertHeapNode(HeapNode insertNode)
    {    
    	//checking if the tree is empty
    	if(getMin()==null){
    		setMin(insertNode);
    		insertNode.setRight(insertNode);
    		insertNode.setLeft(insertNode);
    	}
    	// add the new node to the roots list
    	else{
    		HeapNode temp = this.getMin().getRight();
    		this.getMin().setRight(insertNode);
    		this.getMin().getRight().setLeft(this.getMin());
    		insertNode.setRight(temp);
    		insertNode.getRight().setLeft(insertNode);

        	//update the minimum    	    	
        	if (insertNode.getKey()<getMin().key){
        		setMin(insertNode);
        	}
    	}
    	//update the parent
    	insertNode.setParent(null);
    	//update the size of the heap
    	size++;
		return;
		
    }

   /**
    * public void deleteMin()
    *
    * Delete the node containing the minimum key.
    * The heap must remain valid (keep its invariants)
    * 
    */
    public void deleteMin()
    {
    	HeapNode minNode = getMin();
    	HeapNode minNodeChild;
    	
    	if (minNode == null) {
    		return;
    	}
    	
    	int minNodeRank = minNode.getRank();
    	minNodeChild = minNode.getChild();
    	
    	this.setSize(this.getSize()-1);
    	//if the minimum is the only node in the roots list
    	if (minNode.getRight()==minNode){
    		//if the minimum does not have any children
    		if (minNodeChild==null){
    			this.setMin(null);
    			this.setSize(0);
    			return;
    		}
    		//if the node do have children, we add them to the roots list
    		else {
    			this.setMin(minNodeChild);
    			this.getMin().setParent(null);
    			
    			HeapNode min = getMin();
    			HeapNode currNode = getMin().getRight();
    	    	//add the children to the roots list
    	    	while(currNode != min){
    	    		currNode.setParent(null);
    	    		if (currNode.getKey()<this.getMin().getKey()){
    	    			this.setMin(currNode);
    	    		}
    	    		currNode = currNode.getRight();
    	    	}
    			
    		}
    	}
    	// if the minimum is not the only node in roots list
    	else{
    		//minimum have no children
    		if (minNodeChild==null){
    			minNode.getLeft().setRight(minNode.getRight());
    			minNode.getRight().setLeft(minNode.getLeft());
    		}
    		//minimun have children
    		else{
    			// add the minimum's children to the root list
            	minNode.getLeft().setRight(minNodeChild);
            	minNode.getRight().setLeft(minNodeChild.getLeft());
            	HeapNode tempMinNodeChildLeft = minNodeChild.getLeft();
            	minNodeChild.setLeft(minNode.getLeft());
            	tempMinNodeChildLeft.setRight(minNode.getRight());	
    		}
    		
			this.setMin(minNode.getRight());

    	HeapNode current = minNodeChild;
    	HeapNode newMin = this.getMin();
    	for (int i = 0; i < minNodeRank ; i++){
    		current.setParent(null);
    		current = current.getRight();
    		if (current.getKey()<newMin.getKey()){
    			newMin = current;
    		}
    		}
    	this.setMin(newMin);
    	
    	this.successiveLinking();
    	
     	return;
    	}
    }

   /**
    * public HeapNode findMin()
    *
    * Return the node of the heap whose key is minimal. 
    *
    */
    public HeapNode findMin()
    {
    	// we hold a pointer to the root with the 
    	// minimum key so we just return its value. 
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
    	
    	// if the current heap is empty
    	if(this == null || this.getSize() == 0){
    		this.setMin(heap2.getMin());
    		this.setSize(heap2.getSize());
    		this.setNodesMarked(heap2.getNodesMarked());
    		return;
    	}
    	
    	HeapNode heap2Min = heap2.getMin();
    	// updating the size and merging the list of roots
    	this.setSize(getSize() + heap2.getSize());
    	this.getMin().getRight().setLeft(heap2Min.getLeft());
    	heap2Min.getLeft().setRight(this.getMin().getRight());
    	this.getMin().setRight(heap2Min);
    	heap2Min.setLeft(this.getMin());
    	
    	//update the minimum if needed
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
    	arr[current.getRank()]++;
    	current = current.getRight();
    	while (current.getRight() != this.getMin()){
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
    	//Deleting previous elements
    	this.setMin(null);
    	this.setSize(0);
    	this.setTotalCuts(0);
    	this.setTotalLinks(0);
    	this.setNodesMarked(0);    	
    	
    	for (int i = 0; i < array.length; i++){
    		this.insert(array[i]);
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
    	
    	decreaseKey(x, Integer.MAX_VALUE);
    	deleteMin();
    	
    	return;
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
    	//updating the node's new key
    	int newKey = x.getKey()-delta;
    	x.setKey(newKey);
    	HeapNode xParent = x.getParent();
		//updating the minimum node if needed
    	if (x.isRoot() && (newKey<this.getMin().getKey())){
    		setMin(x);
    		return;
    	}
    	//
    	else if(!(x.isRoot()) && newKey < xParent.getKey()){
    		cascadingCut(x);
    	}
    	return;
    }
    /**
     * return the number of roots in the heap
     * @return
     */
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
    /*
     * linking two roots together 
     * assuming x.key<=y.key
     * assuming the 2 trees are of the same rank
     * 
     */
    public HeapNode Link(HeapNode firstNode,HeapNode secondNode) {
    	//checking if the nodes have the same rank
    	if(firstNode.getRank() != secondNode.getRank()){
    		return null;
    	}
    	
    	if(firstNode.getKey() > secondNode.getKey()){
    		HeapNode tempNode = secondNode;
    		secondNode = firstNode;
    		firstNode = tempNode;
    	}
    	//rank 0
    	if(firstNode.getChild() == null){
    		secondNode.setRight(secondNode);
    		secondNode.setLeft(secondNode);
    	} else {
    		secondNode.setRight(firstNode.getChild());
    		secondNode.setLeft(firstNode.getChild().getLeft());
    		firstNode.getChild().getLeft().setRight(secondNode);
    		firstNode.getChild().setLeft(secondNode);

    	}
    	
    	firstNode.setChild(secondNode);
    	
    	secondNode.setMark(false);
    	secondNode.setParent(firstNode);
    	
    	firstNode.setRank(firstNode.getRank()+1);
    	totalLinks++;
    	return firstNode;
    	
    }
    /**
     * the consolidate/successive linking
     * consolidate the root list by linking the roots with equal
     * degree until at most one remains of each degree.
     * assuming the maximum rank of a root in fibonacci heap
     * is log_goldenratio(size) = 4.78log10(size) < 5*log10(size)
     */
    
    public void successiveLinking() {
    	//check if the heap is empty
    	if (this.size == 0)
    		return;
    	//initialize an array with the size of the max degree in the heap
    	HeapNode[] arr = new HeapNode[(int)(5*Math.log10(size+1))];
    	HeapNode current = this.getMin();
    	current.getLeft().setRight(null);
    	HeapNode temp;
    	//filling the buckets
    	while (current != null){
    		temp = current;
    		current = current.getRight();
    		while (arr[temp.getRank()] != null){
    			temp.setRight(temp);
    			temp.setLeft(temp);
    			//linking two trees with the same rank
    			temp = Link(temp,arr[temp.getRank()]);
    			arr[temp.getRank()-1] = null;

    		}
    		//add the tree to the buckets array
    		arr[temp.getRank()] = temp;
    	}
    	//from buckets
    	//clear the list of roots and insert them to the heap
    	current = null;
    	for (int i=0; i< arr.length; i++){
    		if (arr[i] != null){
    			if (current == null){
    				current = arr[i];
    				this.setMin(null);
    				this.setSize(this.getSize()-1);
    				this.setNodesMarked(0);
    				this.insertHeapNode(arr[i]);
    			} else {
    				this.setSize(this.getSize()-1);
    				this.insertHeapNode(arr[i]);
    			}
    		}
    	}
    }
    /**
     * 
     * @param cutNode
     */
    public void cut(HeapNode cutNode) 
    {    
    	//all the roots are non-marked
    	cutNode.setMark(false);
    	//if we cut a marked node
    	if (cutNode.isMark() == true)
    		nodesMarked--;
    	
    	if (cutNode.getParent() == null)
    		return;
    	
    	HeapNode cutNodeParent = cutNode.getParent();
    	cutNodeParent.setRank(cutNodeParent.getRank()-1);
    	// insert node to the lost of roots and update its parent to null
    	if(cutNode.getRight() == cutNode){
    		cutNodeParent.setChild(null);
    	}
    	else {
    		cutNodeParent.setChild(cutNode.getRight());
    		cutNode.getLeft().setRight(cutNode.getRight());
    		cutNode.getRight().setLeft(cutNode.getLeft());
    	}
    	
    	cutNode.setParent(null);
    	insertHeapNode(cutNode);
    	totalCuts++;
    	
    	return;
    }
    /**
     * CascadingCut
     * gets a node that was cut from the heap
     * if the parent wasn't marked - mark it
     * if the parent was already marked then cut it from the tree
     * recursively continue until we get to a root or unmarked node
     * @param cutNode
     */
    public void cascadingCut(HeapNode cutNode) 
    {    
    	HeapNode cutNodeParent = cutNode.getParent();
    	cut(cutNode);
    	if (cutNodeParent != null){ //check if we got to the first level
    		if(!cutNodeParent.isMark()){ //if the node was not marked
    			cutNodeParent.setMark(true);
    			nodesMarked++;
    		}
    		else{
    			//the node was already marked. cut it recursively
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
	    	return (this.getParent() == null);
	    } 
		
		public void print(int level) {
			
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
