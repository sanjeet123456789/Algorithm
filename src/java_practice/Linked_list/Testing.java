package java_practice.Linked_list;

import java_practice.Linked_list.Node;

class Node{
	int data;
	Node left;
	Node right;
	
	
}

class BST{
	public Node createNode(Node node,int d) {
		Node new_node=new Node();
		new_node.data=d;
		new_node.left=null;
		new_node.right=null;
		return new_node;
	}
	
	public Node insertNode(Node node,int val) {
		if(node==null) {
			
			return createNode(node,val);
		}if(val>node.data) {
			node.right=createNode(node.right,val);
		}else if(val<node.data) {
			node.left=createNode(node.left,val);
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
		if(node==null) {
			return null;
		}else {
			return node.right;
		}
		
	}
	public boolean findnode(Node node,int val) {
		boolean flag=false;
		if(node==null) {
			return false;
		}
		while(node!=null) {
			if(val>node.data){
				node=node.right;
			}else if(val<node.data) {
				node=node.left;
			}else {
				flag=true;
				return flag;
			}
		}
		
		
		return flag;
	}
	
}



public class Testing{
	public static void main(String[] args) {
		BST ax=new BST();
		Node root=null;
		root=ax.insertNode(root,8);
		root=ax.insertNode(root,3);
		root=ax.insertNode(root,6);
		root=ax.insertNode(root,10);
		
		root=ax.insertNode(root,4);
		root=ax.insertNode(root,7);
		root=ax.insertNode(root,1);
		root=ax.insertNode(root,14);
		root=ax.insertNode(root,13);
		System.out.println(ax.findnode(root,1));
		
	}
}