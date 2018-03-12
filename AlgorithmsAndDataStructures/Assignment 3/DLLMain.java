import org.junit.Test;

public class DLLMain {

	public static void main(String[] args) {
		Node n1 = new Node(3, null, null);
		Node n2 = new Node(2, null, null);
		Node n3 = new Node(1, null, null);

		DLList dllist = new DLList();
		
		System.out.println(n1.toString() + "\n" + n2.toString() + "\n" + n3.toString());
		
		dllist.addFirst(n1);
		System.out.println(dllist);
		
		dllist.addFirst(n2);
		System.out.println(dllist);
		
		dllist.addFirst(n3);
		System.out.println(dllist);
	}

}
