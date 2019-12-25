import java.util.Random;

public class Utility {
	
	public static void func1() {
		LinkedListArray<Integer> list = new LinkedListArray<>();
		list.insert(5); //0
		list.insert(7); //1
		list.insert(56); //2
		list.insert(6); //3
		list.insert(39); //4
		list.insert(24); //5
		System.out.println("List:");
		printList(list);
		list.sort();
		System.out.println("Sorted Order:"); //5 6 7 24 39 56
		printList(list);
	}
	
	public static void func2() {
		LinkedListArray<Integer> list = new LinkedListArray<>();
		Random rand = new Random();
		for(int i = 0; i < 10;i++) {
			list.insert(rand.nextInt(200));
		}	
		printList(list);
		try {	
			for(int i = 0; i < 11;i++) {
				list.remove(1);
			}
			printList(list);
			list.get(1);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught ArrayIndexOutOfBoundsException at position 1.");
			printList(list);
			list.removeLast();
			System.out.println("List is empty? "+list.isEmpty());
		}
	}
	
	public static void func3() {
		LinkedListArray<Integer> list = new LinkedListArray<>();
		list.insert(5); //0
		list.insert(7); //1
		list.insert(56); //2
		list.insert(6); //3
		list.insert(39); //4
		list.insert(24); //5
		list.removeFirst();
		list.removeLast();
		System.out.println("First and Last Removed:"); //6 7 24 39
		printList(list);
		System.out.println(list.remove(2));
		System.out.println(list.remove(list.nodeAt(2)));
		System.out.println("2nd and 3rd Removed:");
		printList(list);
		list.addAfter(60, list.nodeAt(1));
		System.out.println("Added 60 after index 1:");
		printList(list);
		list.addBefore(77, list.nodeAt(1));
		System.out.println("Added 77 before index 1:"); 
		printList(list);
		list.removeFirst();
		list.removeFirst();
		list.removeFirst();
		list.addBefore(69, list.nodeAt(0));
		list.removeLast();
		list.addAfter(69, list.nodeAt(0));
		list.addBefore(68, list.nodeAt(0));
		list.removeLast();
		list.addAfter(69, list.nodeAt(0));
		printList(list);
	}
	
	public static void func4() {
		LinkedListArray<Integer> list = new LinkedListArray<>();
		list.insert(5); //0
		list.insert(7); //1
		list.insert(56); //2
		list.insert(6); //3
		list.insert(39); //4
		list.insert(24); //5
		list.removeFirst();
		list.removeLast();
		System.out.println(list.remove(2));
		System.out.println(list.remove(list.nodeAt(2)));
		System.out.println("2nd and 3rd Removed:");
		printList(list);
		list.addAfter(60, list.nodeAt(1));
		System.out.println("Added 60 after index 1:");
		printList(list);
		list.addBefore(77, list.nodeAt(1));
		System.out.println("Added 77 before index 1:"); 
		printList(list);
	}
	
    public static void func5() {
    	LinkedListArray<Integer> list = new LinkedListArray<>();
    	list.insert(5); //0
		list.insert(7); //1
		list.insert(56); //2
		list.insert(6); //3
		list.insert(39); //4
		list.insert(24); //5
    	list.removeFirst();
		list.removeFirst();
		list.removeFirst();
		list.addBefore(69, list.nodeAt(0));
		list.removeLast();
		list.addAfter(69, list.nodeAt(0));
		list.addBefore(68, list.nodeAt(0));
		list.removeLast();
		list.addAfter(69, list.nodeAt(0));
		printList(list);
	}
    
    private static void printList(LinkedListArray<Integer> list) {
    	for(int i=0;i<list.size();i++) {
			System.out.print("("+i+")"+list.get(i)+" ");		}
		System.out.println("");
    }

}
