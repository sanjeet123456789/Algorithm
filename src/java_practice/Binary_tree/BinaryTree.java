package java_practice.Binary_tree;
class Node{
	int data;
	Node left;
	Node right;
	
}
class BST{
	public Node createNewNode(int k) {
		Node a=new Node();
		a.data=k;
		a.left=null;
		a.right=null;
		return a;
	}
	public Node insert(Node node,int val) {
		if(node==null) {
			return createNewNode(val);
		}if(val<node.data) {
			node.left=insert(node.left,val);
		}else if(val>node.data) {
			node.right=insert(node.right,val);
		}
		return node;
	}
	public Node delete(Node node,int val) {
		if(node==null) {
			return null;
		}
		if(val<node.data) {
			node.left=delete(node.left,val);
		}else if(val>node.data) {
			node.right=delete(node.right,val);
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
		if(node==null) {
			return null;
		}
		Node temp=node.right;
		return temp;
	}
}
public class BinaryTree {
	public static void main(String[] args) {
		BST ax=new BST();
		Node root=null;
		//8,3,6,10,4,71,14,13
		
		root=ax.insert(root,8);
		root=ax.insert(root,3);
		root=ax.insert(root,6);
		root=ax.insert(root,10);
		root=ax.insert(root,4);
		root=ax.insert(root,7);
		root=ax.insert(root,1);
		root=ax.insert(root,14);
		root=ax.insert(root,13);
		
		root=ax.delete(root,1);
		
	}

}
