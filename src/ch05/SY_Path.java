package ch05;

import java.util.Scanner;

import ch03.LinkStack;

public class SY_Path {
	public static LinkStack getPath(BiTreeNode root,BiTreeNode p){
		BiTreeNode t=root;
		LinkStack s=new LinkStack();
		if(t!=null){
			s.push(t);
			boolean flag;
			BiTreeNode q=null;
			while(!s.isEmpty()){
				while(s.peek()!=null){
					s.push(((BiTreeNode)s.peek()).lchild);
				}
				s.pop();
				while(!s.isEmpty()){
					t=(BiTreeNode) s.peek();
					if(t.rchild==null||t.rchild==q){
						if(t.equals(p)){
							LinkStack s2=new LinkStack();
							while(!s.isEmpty()){
								s2.push(s.pop());
							}
							return s2;
						}
						s.pop();
						q=t;
						flag=true;
					}else{
						s.push(t.rchild);
						flag=false;
					}
					if(!flag){
						break;
					}
				}
			}
		}
		return null;
	}
	public static BiTreeNode searchNode(BiTreeNode T,Object x){
		if(T!=null){
			if(T.data.equals(x)){
				return T;
			}else{
				BiTreeNode lresult=searchNode(T.lchild, x);
				return lresult!=null?lresult:searchNode(T.rchild, x);
			}
		}
		return null;
	}
	public static void displayPath(LinkStack stack){
		String str="";
		while(!stack.isEmpty()){
			BiTreeNode node=(BiTreeNode) stack.pop();
			String str1=node.data+"-";
			str = str.concat(str1);
			
		}
		System.out.println(str.substring(0, str.length()-1));
	}

	public static void main(String[] args) {
		String preOrder = "ABDEGCFH";
		String inOrder  = "DBGEAFHC";
		BiTree T=new BiTree(preOrder, inOrder, 0, 0, preOrder.length());
		System.out.println("请输入指定的结点p(可选项为：A,B,C,D,E,F,G,H 区分大小写)");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		char c=str.charAt(0);
	/*	BiTreeNode b=new BiTreeNode();
		b.data=c;*/
		BiTreeNode p=searchNode(T.getRoot(), c);
		System.out.println("从二叉树根结点到结点p的路径为：");
		displayPath(getPath(T.getRoot(), p));
//		displayPath(getPath(T.getRoot(), b));
		
	}
	
}
