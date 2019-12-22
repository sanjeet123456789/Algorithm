package java_practice.Binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import java_practice.Binary_tree.BST;
import java_practice.Binary_tree.Node;

class Node{
	int data;
	Node left;
	Node right;
	int height;
	
}
 class BST{
	public Node createNode(Node node,int val) {
		Node a=new Node();
		a.data=val;
		a.left=null;
		a.right=null;
		return a;
	}
	public Node insert(Node node,int val) {
		if(node==null) {
			return createNode(node,val);
		}if(val>node.data) {
			node.right=insert(node.right,val);
			
		}else if(val<node.data){
			node.left=insert(node.left,val);
		}
		return node;
	}
	
	public Node delete(Node node,int val) {
		if(node==null) {
			return null;
		}if(val>node.data) {
			node.right=delete(node.right,val);
		}else if(val<node.data) {
			node.left=delete(node.left,val);
		}else {
			if(node.left==null || node.right==null) {
				Node temp=null;
				temp=node.left==null?node.right:node.left;
				if(temp==null) {
					return null;
				}else {
					return node;
				}
			}else {
				Node successor=getSuccessor(node);
				node.data=successor.data;
				node.right=delete(node.right,4);
				return node;
			}
		}
		return node;
	}
	public Node getSuccessor(Node node) {
		if(node==null) {return null;}Node temp=node.right;
		while(temp.left!=null) {
			temp=temp.left;
		}
		return temp;
	}
	public void inorder(Node node) {
		if(node==null) {
			return;
		}
		inorder(node.left);
		System.out.println(node.data+" ");
		inorder(node.right);
	}
	
	public void preorder(Node node) {
		if(node==null) {
			return;
			
		}
		System.out.println(node.data+" ");
		preorder(node.left);
		preorder(node.right);
	}
	public void postorder(Node node) {
		if(node==null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data+" ");
		
	}
	public boolean ifNodePresent(Node node,int val) {
		if(node==null) {
			return false;
		}
		boolean isPresent=false;
		while(node!=null) {
			if(val<node.data) {
				node=node.left;
			}else if(val>node.data) {
				node=node.right;
			}else {
				isPresent=true;
				break;
			}
		}
		return isPresent;
	}
	
	
	public Node getParentNode(Node node,int val) {
		
		if(node ==null||node.data==val) {
			return null;
		}
		Node getParent=null;
		while(node!=null) {
			if(val<node.data) {
				getParent=node;
				node=node.left;
			}else if(val>node.data){
				getParent=node;
				node=node.right;
			}else {
				break;
			}
		}
		return getParent!=null?getParent:null;
	}
	
	public Node getSiblingNode(Node node,int val) {
		if(node==null || node.data==val) {
			return null;
		}
		Node parentNode=null;
		while(node!=null) {
			if(val>node.data) {
				parentNode=node;
				node=node.right;
			}else if(val<node.data) {
				parentNode=node;
				node=node.left;
			}else {
				break;
			}
		}
		if(parentNode.left!=null && val == parentNode.left.data) {
			return parentNode.right;
		} 
		if(parentNode.right!=null && val == parentNode.right.data) {
		
			return parentNode.left;
		}
		return null;
		
		
		
	}
	
	public Node getInOrderParent(Node node,int val) {
		if(node==null) {
			return null;
		}
		Node inorderParentNode=null;
		while(node!=null) {
			if(val>node.data) {
				node=node.right;
			}else if(val<node.data) {
				inorderParentNode=node;
				node=node.left;
			}else {
				break;
			}
		}
		
		return node!=null?inorderParentNode:null;
	}
	
	public Node getInOrderSuccessor(Node node,int val) {
		if(node==null) {
			return null;
		}
		Node inorderSuccessor=null;
		while(node!=null) {
			if(val>node.data) {
				System.out.println(node.data);
				node=node.right;
			}
			else if(val<node.data) {
				System.out.println(node.data);
				inorderSuccessor=node;
				node=node.left;
			}else {
				if(node.right!=null) {
					inorderSuccessor=getSuccessor(node);
				}
				break;
			}
		}
		return node!=null?inorderSuccessor:null;
	}
	public int getdifferenceEvenandOdd(Node node) {
		// TODO Auto-generated method stub
		if(node==null) {
			return 0;
		}
		System.out.println(node.data);
		return  node.data-getdifferenceEvenandOdd(node.left)-getdifferenceEvenandOdd(node.right);
		

	}
	public int getMax(Node root) {
		// TODO Auto-generated method stub
		if(root==null) {
			System.out.println("tree is empty");
			return -1;
		}
		while(root.right!=null) {
			root=root.right;
		}
		return root.data;
	}
	public int  getMin(Node node) {
		if(node==null) {
			System.out.println("tree is empty..");
			return -1;
		}
		
		while(node.left!=null) {
			node=node.left;
		}
		return node.data;
	}
	
	public int getSumOfNode(Node node) {
		if(node==null) {
			return 0;
		}
		return node.data+getSumOfNode(node.left)+getSumOfNode(node.right);
		
		
	}
	public int getNumberOfNodes(Node node) {
		if(node==null) {
			return 0;
		}
		return 1+getNumberOfNodes(node.left)+getNumberOfNodes(node.right);
	}
	public int getNumberOfLeafNode(Node node) {
		if(node==null) {
			return 0;
		}if(node.left==null && node.right==null) {
			return 1;
		}
		return getNumberOfLeafNode(node.left)+getNumberOfLeafNode(node.right);
	}
	
	public int getHeightOfTree(Node node) {
		if(node==null) {
			return 0;
		}
//		System.out.println(node.data);
		return max(getHeightOfTree(node.left),getHeightOfTree(node.right))+1;
	}
	private int max(int heightOfTree, int heightOfTree2) {
		
		return heightOfTree>heightOfTree2?heightOfTree:heightOfTree2;
	}
	
	public void printAtGivenLevel(Node node,int level) {
		if(node==null) {
			return;
		}
		if(level==1) {
			System.out.print(node.data+" ");
			return;
		}
		printAtGivenLevel(node.left,level-1);
		printAtGivenLevel(node.right,level-1);
	}
	public void levelOrderTraversalUsingRecursion(Node node) {
		if(node==null) {
			return;
		}
		int height=getHeightOfTree(node);
		for(int i=0;i<=height;i++) {
			printAtGivenLevel(node, i);
			System.out.println();
		}
		
	}
	public void levelOrderUsingQueue(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		
		while(q.size()>0) {
			Node top=q.remove();
			System.out.println(top.data);
			if(top.left!=null) {
				q.add(top.left);
			}
			if(top.right!=null) {
				q.add(top.right);
			}
		}
		
		
	}
	
	public void reverseLevelOrderTraversalUsingRecursion(Node node) {
		if(node==null) {
			return;
		}
		int height=getHeightOfTree(node);
		for(int i=height;i>=0;i--) {
			printAtGivenLevel(node, i+1);
			System.out.println();
		}
	}
	
	
	public void reverseOrderTraversalusingQueue(Node node) {
		if(node==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		Stack<Node> s=new Stack<Node>();
		
		while(q.size()>0) {
			Node t=q.remove();
			if(t.right!=null) {
				q.add(t.right);
			}
			if(t.left!=null) {
				q.add(t.left);
			}
			s.push(t);
		}
		while(s.size()>0) {
			Node x=s.pop();
			System.out.println(x.data+" ");
		}
		
	}
	
	public void levelOrderTraversalLineWise(Node node) {
		if(node==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		while(true) {
			int count=q.size();
			if(count==0) {
				break;
			}
			
			while(count>0) {
				Node top=q.remove();
				System.out.println(top.data+" ");
				if(top.left!=null) {
					q.add(top.left);
				}
				if(top.right!=null) {
					q.add(top.right);
				}
				count--;
			}
			System.out.println();
			
		}
	}
	int maxLevel;
	public void leftViewOfTree(Node node,int level) {
		if(node==null) {
			return;
		}
		
		if(level>=maxLevel) {
			System.out.println(node.data+" ");
			maxLevel++;
		}
		
		leftViewOfTree(node.left, level+1);
		leftViewOfTree(node.right, level+1);
	}
	
	int maxlevel;
	public void rightViewOfTree(Node root,int level) {
		if(root==null) {
			return;
		}
		
		if(level>=maxlevel) {
			System.out.println(root.data+" ");
			maxlevel++;
		}
		
		rightViewOfTree(root.right,level+1);
		rightViewOfTree(root.left,level+1);
	}
	
	public void inorderUsingStack(Node root) {
		if(root==null) {
			return;
		}
		Stack<Node> s=new Stack<Node>();
		while(root!=null) {
			s.push(root);
			root=root.left;
		}
		
		while(s.size()>0) {
			Node x=s.pop();
			System.out.println(x.data);
			if(x.right!=null) {
				Node temp=x.right;
				while(temp!=null) {
					s.push(temp);
					temp=temp.left;
				}
			}
		}
	}
	public void preorderwitoutRecursion(Node root) {
		if(root==null) {
			return;
		}
		
		Stack<Node> s=new Stack<Node>();
		s.push(root);
		while(s.size()>0) {
			Node t=s.pop();
			System.out.println(t.data);
			if(t.right!=null) {
				s.push(t.right);
			}
			if(t.left!=null) {
				s.push(t.left);
			}
		}
		
	}
	
	public void postorderwithoutRecursion(Node root) {
		if(root==null) {
			return;
		}
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		
		
		s1.push(root);
		
		
		while(s1.size()>0) {
			Node t=s1.pop();
			
			if(t.left!=null) {
				s1.push(t.left);
			}
			if(t.right!=null) {
				s1.push(t.right);
			}
			s2.push(t);
		}
		
		while(s2.size()>0) {
			Node x=s2.pop();
			System.out.println(x.data);
		}
	}
	public Node mirrorTree(Node root) {
		if(root==null) {
			return null;
		}
		Node t=root.left;
		root.left=root.right;
		root.right=t;
		
		mirrorTree(root.left);
		mirrorTree(root.right);
		return root;
		
		
	}
	public Node deleteTree(Node root) {
		if(root==null) {
			return null;
		}
		
		root.left=deleteTree(root.left);
		root.right=deleteTree(root.right);
		
		System.out.println("deleting node"+root.data);
		root=null;
		return root;
		
		
	}
	public boolean checkIfIdentical(Node root,Node rooty) {
		if(root==null && rooty==null) {
			return true;
		}
		if(root==null || rooty==null) {
			return false;
		}
		
		return root.data==rooty.data
				&& checkIfIdentical(root.left, rooty.left)
				&& checkIfIdentical(root.right, rooty.right);
	}
	
	
	public int getLevelOfNode(Node node,int val,int level) {
		if(node==null) {
			return 0;
		}
		
		int l;
		if(node.data==val) {
			return level;
		}
		System.out.println(node.data);
		l=getLevelOfNode(node.left,val,level+1);
		
		if(l!=0) {
			return l;
		}
		
		l=getLevelOfNode(node.right,val,level+1);
		return l;
		
		
	}
	public void topView(Node root) {
		if(root==null) {
			return;
		}
		
		TreeMap<Integer,Integer> m=new TreeMap<Integer,Integer>();
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp=q.remove();
			int hd=temp.height;
			
			if(m.get(hd)==null) {
				m.put(hd, temp.data);
			}
			if(temp.left!=null) {
				temp.left.height=hd-1;
				q.add(temp.left);
			}
			
			if(temp.right!=null) {
				temp.right.height=hd+1;
				q.add(temp.right);
			}
			
		}
		System.out.println(m.values());
		
		
		
	}
	
	public void bottomView(Node root) {
		if(root==null) {
			return;
		}
		
		TreeMap<Integer,Integer> m=new TreeMap<Integer,Integer>();
		Queue<Node> q=new LinkedList<Node>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp=q.remove();
			int hd=temp.height;
			m.put(hd, temp.data);
			if(temp.left!=null) {
				temp.left.height=hd-1;
				q.add(temp.left);
			}if(temp.right!=null) {
				temp.right.height=hd+1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
		
	}
	
	public void printlnBoundary(Node node) {
		printBoundaryLeft(node.left);
		printLeaves(node.left);
		printLeaves(node.right);
		printBoundaryLeft(node.right);
	}
	public void printBoundaryLeft(Node root) {
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			System.out.println(root.data);
			printBoundaryLeft(root.left);
		} else if(root.right!=null) {
			System.out.println(root.data);
			printBoundaryLeft(root.right);
		}
		
	}
	
	public void printLeaves(Node node) {
		if(node==null) {
			return;
		}
		
		printLeaves(node.left);
		if(node.left==null && node.right==null) {
			System.out.println(node.data);
		}
		printLeaves(node.right);
	}
	 public void printBoundaryRight(Node node) {
		 if(node==null) {
			 return;
		 }
		 if(node.right!=null) {
			 printBoundaryRight(node.right);
			 System.out.println(node.data);
		 }else if(node.left!=null) {
			 printBoundaryRight(node.left);
			 System.out.println(node.data);
		 }
	 }
	public void printVerticleOrder(Node root) {
		if(root==null) {
			return;
		}
		int hd=0;
		TreeMap<Integer,ArrayList<Integer>> m=new TreeMap<Integer,ArrayList<Integer>>();
		
		getVerticleOrder(root,hd,m);
		
		for(Entry<Integer, ArrayList<Integer>> cm:m.entrySet()) {
			System.out.println(cm.getValue());
		}
		
	}
	private void getVerticleOrder(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
		if(root==null) {
			return;
		}
		if(m.get(hd)==null) {
			ArrayList<Integer> l=new ArrayList<Integer>();
			l.add(root.data);
			m.put(hd, l);
		}else {
			ArrayList<Integer> l=m.get(hd);
			l.add(root.data);
			m.put(hd, l);
		}
		getVerticleOrder(root.left, hd-1, m);
		getVerticleOrder(root.right, hd+1, m);
	}
	public void printVerticleSum(Node root) {
		if(root==null) {
			return;
		}
		
		Map<Integer,Integer> m=new TreeMap<Integer,Integer>();
		verticleSum(root,0,m);
		if(m!=null) {
			System.out.println(m.values());
		}
		
		
	}
	private void verticleSum(Node root, int i, java.util.Map<Integer, Integer> m) {
		if(root==null) {
			return;
		}
		verticleSum(root.left, i-1, m);
		int s=(m.get(i)==null)?0:m.get(i);
		m.put(i, s + root.data);
		
		verticleSum(root.right, i+1, m);
		
	}
	
	public void printsumLevelWise(Node node) {
		if(node==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		
		while(true) {
			int size=q.size();
			if(size==0) {
				break;
			}
			
			int sum=0;
			while(size>0) {
				Node t= q.remove();
				sum=sum+t.data;
				
				if(t.left!=null) {
					q.add(t.left);
				}
				if(t.right!=null) {
					q.add(t.right);
				}
				size--;
			}
			System.out.println(sum);
		}
		return;
	}
	public  boolean recursiveSearch(Node node,int key) {
		if(node==null) {
			return true;
		}
		if(node.data==key) {
			return true;
		}
		return recursiveSearch(node.left, key) || recursiveSearch(node.right, key);
		
	}
	
	public boolean iterativeSearch(Node node,int key) {
		if(node==null) {
			return false;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty()) {
			
			Node x=q.remove();
			
			if(x.data==key) {
				return true;
			}
			if(x.left!=null) {
				q.add(node.left);
			}
			if(x.right!=null) {
				q.add(node.right);
			}
			return false;
		}
		return false;
	}
	
	
	
	public void printSpiralForm(Node node) {
		if(node==null) {
			return;
		}
		
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		
		s1.push(node);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Node t=s1.pop();
				
				System.out.print(t.data);
				if(t.left!=null) {
					s2.push(t.left);
				}
				if(t.right!=null) {
					s2.push(t.right);
				}
				
			}
			System.out.println();
			
			while(!s2.isEmpty()) {
				Node t2=s2.pop();
				
				System.out.print(t2.data);
				
				if(t2.left!=null) {
					s1.push(t2.left);
				}
				
				if(t2.right!=null) {
					s1.push(t2.right);
				}
				
			}
			System.out.println();
		}
		
	}
	
	public void printBetweenTwoLevel(Node node,int min,int max) {
		if(node==null) {
			return;
		}
		
		
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		
		int l=1;
		while(true) {
			int size=q.size();
			if(size==0) {
				break;
			}
			while(size>0) {
				Node t=q.remove();
				
				if(l>=min && l<=max) {
					System.out.print(t.data+" ");
				}
				if(t.left!=null) {
					q.add(t.left);
				}
				if(t.right!=null) {
					q.add(t.right);
				}
				size--;
			}
			l++;
			
			
			
		}
	}
	
	public boolean ifMirrorStructureTree(Node node1,Node node2) {
		
		
		if(node1==null && node2==null) {
			return true;
		}
		if(node1==null||node2==null) {
			return false;
		}
		return ifMirrorStructureTree(node1.left, node2.right)&& ifMirrorStructureTree(node1.right, node2.left);
	}
	public boolean ifFoldable(Node node) {
		if(node==null) {
			return true;
		}
		return ifMirrorStructureTree(node.left, node.right);
	}
	
	public void getMaxWidth(Node root) {
		if(root==null) {return;}
		
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int maxwidth=1;
		while(true) {
			int size=q.size();
			if(size==0) {
				break;
			}
			
			if(size>maxwidth) {
				maxwidth=size;
			}
			
			while(size>0) {
				Node t=q.remove();
				if(t.left!=null) {
					q.add(t.left);
				}
				if(t.right!=null) {
					q.add(t.right);
				}
				size--;
			}
		}
		System.out.println(maxwidth);
		
		
		
		
		
	}
	
	public boolean ifSamesStructure(Node node1,Node node2) {
		if(node1==null && node2==null) {
			return true;
		}
		if(node1==null||node2==null) {
			return false;
		}
		return ifSamesStructure(node1.left, node2.left)&&ifSamesStructure(node1.right, node2.right);
	}
	
	public boolean ifIsomorphics(Node node1,Node node2) {
		if(node1==null && node2==null) {
			return true;
		}
		if(node1==null||node2==null) {
			return false;
		}
		return (ifIsomorphics(node1.left, node2.left)&&ifIsomorphics(node1.right, node2.right))||
				(ifIsomorphics(node1.left, node2.right)&&ifIsomorphics(node1.right, node2.left));
	}
	public int getWidthOfLevel(Node node,int Level) {
		if(node==null) {
			return 0;
		}
		if(Level==1) {
			return 1;
		}
		System.out.println(node.data);
		return getWidthOfLevel(node.left,Level-1)+getWidthOfLevel(node.right, Level-1);
	}
	public void doubleTree(Node node) {
		if(node==null) {
			return;
		}
		doubleTree(node.left);
		doubleTree(node.right);
		
		Node new_node=createNode(node, node.data);
		new_node.left=node.left;
		node.left=new_node;
	}
	
	public Node buildTreeFromInOrderPreOrder(int preorderArray[],int inorderArray[],int start,int end) {
		int preIndex = 0;
		if(start>end) {return null;}
		
		Node node=createNewNode(preorderArray[preIndex++]);
		if(start==end) {
			return node;
		}
		int inorderIndex=getInorderIndex(node.data,inorderArray,start,end);
		
		node.left=buildTreeFromInOrderPreOrder(preorderArray, inorderArray, start, inorderIndex-1);
		node.right=buildTreeFromInOrderPreOrder(preorderArray, inorderArray, inorderIndex+1, end);
	
	return node;
	}
	
	private int getInorderIndex(int val,int in[],int start,int end) {
		int result=-1;
		
		for(int i=0;i<in.length;i++) {
			if(in[i]==val) {
				return i;
			}
		}
		
		return result;
	}
	
	public Node createNewNode(int val) {
		Node new_node=new Node();
		new_node.data=val;
		new_node.left=null;
		new_node.right=null;
		return new_node;
	}
	
	
	public int heightIteratively(Node node) {
		if(node==null) {
			return 0;
		}
		
		Queue<Node> q=new LinkedList<Node>();
		
		q.add(node);
		int height=0;
		while(true) {
			int size=q.size();
			if(size==0) {
				break;
			}
			height=height++;
			while(size>0) {
				
				Node t=q.remove();
				if(t.left!=null) {
					q.add(node.left);
				}
				if(t.right!=null) {
					q.add(node.right);
				}
				size--;
			}
		}
		return height;
	}
	
	int diameter;
	public int getDiameter(Node node) {
		if(node==null) {
			return 0;
		}
		
		if(node.left==null&& node.right==null) {
			return 1;
		}
		int lH=getDiameter(node.left);
		int rH=getDiameter(node.right);
		
		diameter=Math.max(diameter, lH+rH+1);
		
		return Math.max(lH, rH)+1;
	}
	
	public int ifHeightBalancedTree(Node node) {
		if(node==null) {
			return 0;
		}
		if(node.left==null && node.right==null) {
			return 1;
		}
		int lH=ifHeightBalancedTree(node.left);
//		if(lH==-1) {
//			return -1;
//		}
		int rH=ifHeightBalancedTree(node.right);
//		if(rH==-1) {
//			return -1;
//		}
//		if(Math.abs(lH-rH)>1) {
//			return -1;
//		}
		
		
		if(lH==-1||rH==-1||Math.abs(lH-rH)>1) {
			return -1;
		}
//		
		return Math.max(lH,rH)+1;
	}
	
	public void printRootToLeaf(Node node) {
		if(node==null) {
			return;
		}
		int arr[]=new int[10];
		printRootToLeafImpl(node,arr,0);
	}
	
	private void printRootToLeafImpl(Node node,int[] arr,int index) {
		if(node==null) {
			return;
		}
		arr[index] =node.data;
		if(node.left==null && node.right==null) {
			printArray(arr,index);
		}
		
		printRootToLeafImpl(node.left, arr, index+1);
		printRootToLeafImpl(node.right, arr, index+1);
	}
	
	private void printArray(int[] arr,int index) {
		for(int i=0;i<=index;i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	
	int maxSum;
	public void maxSumFromRootToLeaf(Node node,int sum) {
		if(node==null) {
			return;
		}
		if(node.left==null && node.right==null && sum+node.data>maxSum) {
			maxSum=sum+node.data;
			return;
		}
		maxSumFromRootToLeaf(node.left, sum+node.data);
		maxSumFromRootToLeaf(node.right, sum+node.data);
	}
	int sumRootToLeaf;
	public void sumRootToLeaf(Node node,int i)
	{
		if(node==null) {
			return;
		}
		
		if(node.left==null&& node.right==null) {
			sumRootToLeaf=sumRootToLeaf+(i*10+node.data);
		}
		
		sumRootToLeaf(node.left, i*10+node.data);
		sumRootToLeaf(node.right, i*10+node.data);
		
	}
}
 
 public class BinaryTree{
	 public static void main(String[] args) {
		BST ax=new BST();
		Node root=null;
		root=ax.insert(root,8);
		root=ax.insert(root,3);
		root=ax.insert(root,6);
		root=ax.insert(root,10);
		
		root=ax.insert(root,4);
		root=ax.insert(root,7);
		root=ax.insert(root,1);	
		root=ax.insert(root,14);
		root=ax.insert(root,13);
		
		BST ay=new BST();
		Node rooty=null;
		rooty=ay.insert(root,8);
		rooty=ay.insert(root,3);
		rooty=ay.insert(root,6);
		rooty=ay.insert(root,10);
		
		rooty=ay.insert(root,4);
		rooty=ay.insert(root,7);
		rooty=ay.insert(root,1);	
		rooty=ay.insert(root,14);
		rooty=ay.insert(root,13);
		
//		root=ax.delete(root,1);
//		ax.inorder(root);
//		ax.preorder(root);
//		ax.postorder(root);
//		System.out.println(ax.ifNodePresent(root,15));
//		Node parentNode=ax.getParentNode(root,10);
		//if condition check if parentnode contain some object
//		System.out.println(parentNode.data);
		
		///getting a sibling node
		/*
		Node siblingNode=ax.getSiblingNode(root,8);
		if(siblingNode!=null) {
			System.out.println(siblingNode.data);
		}else {
			System.out.println("Sibling doesnot exit");
		}*/
		
		
		// getting inorder parent node
		
		/* Node inorderParentNode=ax.getInOrderParent(root,1);
		if(inorderParentNode!=null) {
			System.out.println(inorderParentNode.data);
		}else {
			System.out.println("inorder parent doesnot exist");
		}*/
		
		
		
		//inorder successor
		
		/* Node inorderSuccessor=ax.getInOrderSuccessor(root,3);
		
		if(inorderSuccessor!=null) {
			System.out.println(inorderSuccessor.data);
			
		}else {
			System.out.println("inorderSuccessor doesn't exist..");
		}*/ 
		
		
		//  get a difference of even and odd
		
//		System.out.println(ax.getdifferenceEvenandOdd(root));
//		System.out.print(ax.getMax(root));
//		System.out.println(ax.getMin(root));
//		System.out.println(ax.getSumOfNode(root));
//		System.out.println(ax.getNumberOfNodes(root));
//		System.out.println(ax.getNumberOfLeafNode(root));
//		System.out.println(ax.getHeightOfTree(root));
//		System.out.println(ax.getHeightOfTree(root.left));
//		System.out.println(ax.getHeightOfTree(root.right));
//		ax.printAtGivenLevel(root,4);
//		System.out.println();
		
		/// print in level order using recurssion
		
//		ax.levelOrderTraversalUsingRecursion(root);
//		ax.levelOrderUsingQueue(root);
//		ax.reverseOrderTraversalusingQueue(root);
//		ax.levelOrderTraversalLineWise(root);
		
		//print left view of tree
		
//		ax.leftViewOfTree(root,0);
//		ax.rightViewOfTree(root,0);
//		ax.inorderUsingStack(root);
//		ax.preorderwitoutRecursion(root);
//		ax.postorderwithoutRecursion(root);
		
		
		//convert binary tree into mirror tree
		
		/*
		Node mirror=ax.mirrorTree(root);
		ax.inorder(mirror);
		*/
		
//		ax.deleteTree(root);
//		System.out.println(ax.checkIfIdentical(root,rooty));
		
		
//		System.out.println(ax.getLevelOfNode(root, 7, 1));
//		ax.topView(root);
//		ax.bottomView(root);
//		ax.printlnBoundary(root);
//		ax.printVerticleOrder(root);
//		ax.printVerticleSum(root);
//		ax.printsumLevelWise(root);
//		ax.printSpiralForm(root);
//		ax.printBetweenTwoLevel(root, 2, 4);
//		ax.getMaxWidth(root);
//		System.out.println(ax.ifFoldable(root));
//		System.out.println(ax.getWidthOfLevel(root, 3));
//		ax.doubleTree(root);
//		ax.topView(root);
		
		/// create a tree using preorder and inorder
		
		Node rootpre=null;
		int[] preorderArray= {2,4,7,3,8};
		int[] inorderArray= {7,4,3,2,8};
		
//		root=ax.buildTreeFromInOrderPreOrder(preorderArray,inorderArray,0,inorderArray.length-1);
		System.out.println(ax.getDiameter(root));
		
		System.out.println(ax.ifHeightBalancedTree(root)!=-1);
		
		//print root to leaf every path in binary tree
		ax.printRootToLeaf(root);
		
		////get max sum from root to leaf
		
		ax.maxSumFromRootToLeaf(root,0);
		System.out.println(ax.maxSum);
		
		
		//sum of all number from root to leaf
		ax.sumRootToLeaf(root, 0);
		
		
		
		
		
	}


	 
 }
