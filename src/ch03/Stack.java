package ch03;

public class Stack {
	private StackElem[] st;
	private int top;
	public Stack(int maxSize){
		top = -1;
		st = new StackElem[maxSize];
	}
	//测试栈是否为空
	public boolean isEmpty(){
		return top == -1;
	}
	//读取栈顶元素
	public StackElem getTop() throws Exception{
		if (!isEmpty())
			return st[top];
		else
			throw new Exception("当前栈为空");
	}
	//修改栈顶元素：将栈顶元素的值改为（m，n）
	public void setTop(int m,int n) throws Exception{
		if(!isEmpty()){
			st[top].mval = m;
			st[top].nval = n;
		}
		else
			throw new Exception("当前栈为空");
	}
	//入栈
	public void push(StackElem o ) throws Exception{
		if(top == st.length)
			throw new Exception("栈已满");
		else
			st[++top] = o;
	}
	//出栈，移除栈顶元素，并返回栈顶元素值
	public StackElem pop() throws Exception{
		if(top == -1)
			throw new Exception("当前栈为空");
		else{
			return st[top--];
		}
	}
	//求栈中的元素个数，并由函数返回其值
	public int length(){
		return top + 1;
	}

}
