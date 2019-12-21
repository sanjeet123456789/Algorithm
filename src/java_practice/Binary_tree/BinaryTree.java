package java_practice.Binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import java_practice.Binary_tree.BST;
import java_practice.Binary_tree.Node;

class Node{
	int data;
	Node left;
	Node right;
	
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
		ax.reverseOrderTraversalusingQueue(root);
		
	}


	 
 }
