import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> myList = new MyArrayList<String>();
		
		myList.add("a");
		myList.add("b");
		myList.add("c");
		myList.add(0, "@");
		
		for(int i=0; i<myList.size(); ++i) {
			System.out.println(myList.get(i));
		}
		
	}

}
