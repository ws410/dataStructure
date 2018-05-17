package ch05;



import ch03.SqStack;

public class exChang {
	public  static void exChang1(BiTreeNode t) throws Exception {
		SqStack s = new SqStack(100);
		if (t!=null){
			s.push(t);
			do{
				t = (BiTreeNode)s.pop();
				if (t.lchild!=null||t.rchild!=null) {
					BiTreeNode p =(BiTreeNode)t.lchild;
					t.lchild=t.rchild;
					t.rchild=p;
					
				}
				if(t.lchild!=null)
					s.push(t.lchild);
				if(t.rchild!=null)
					s.push(t.rchild);
			}while(!s.isEmpty());
		}
		
	}
	public static void exChang2(BiTreeNode T) {
		if(T!=null){
			if(T.lchild!=null||T.rchild!=null){
				BiTreeNode p = (BiTreeNode)T.lchild;
				T.lchild=T.rchild;
				T.rchild = p;
			}
			exChang2(T.lchild);
			exChang2(T.rchild);
		}
	}
	

}
