
public class mainTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value1 = "Java";
		String value2 = "Python";
		String value3 = "JavaScript";
		
		LLNode firstNode = new LLNode(value1);
		firstNode.setPointerNext();
		LLNode secondNode = new LLNode(value2);
		secondNode.setPointerNext();
		LLNode thirdNode = new LLNode(value3);
		thirdNode.setTail();
		
		System.out.println("Second node is head: " + secondNode.isHead() + "\tSecond node is tail: " + secondNode.isTail());
		System.out.println("First node is head: " + firstNode.isHead() + "\tFirst node is tail: " + firstNode.isTail());
		System.out.println("Third node is head: " + thirdNode.isHead() + "\tThird node is tail: " + thirdNode.isTail());
		System.out.println();
		System.out.println(firstNode.toString());
		System.out.println();
		LinkedList LL = new LinkedList();
		
		LL.addNode(firstNode);
		
		System.out.println(LL);
		System.out.println();
		
		LL.addNode(secondNode);
		LL.addNode(thirdNode);
		
		System.out.println(LL);
		System.out.println();
	}

}
