package sword_offer;
//page 68 两个栈实现队列
import java.util.Stack;

//队列类，包含两个栈、两个操作队列的方法
class Queue <T>{
	Stack<T> stack1 = new Stack<>();
	Stack<T> stack2 = new Stack<>();
	//插入节点
	public void appendTail(T element) {
		stack1.push(element);
	}
	//删除节点
	public T deleteHead(){
		if (stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				T data = stack1.pop();
				stack2.push(data);
			}
		}
		//为空时，输出异常
		if (stack2.isEmpty())
			throw new IllegalArgumentException("queue is empty");
		return stack2.pop();
		
	}
}
public class Solution09 {
	//测试函数
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.appendTail(1);
		queue.appendTail(2);
		queue.appendTail(3);
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
		queue.appendTail(4);
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
	}
}
