import java.util.Scanner;

public class InsertionSort {
	
	// With strings
	public static void sort(String a[]) {
		int max = a.length;
		
		for(int i = 0; i < max; i++) {
			String key = a[i];
			int j = i -1;
			
			// Moves to one position ahead values greater than key 
			while(j >= 0 && a[j].compareToIgnoreCase(key) > 0)
				a[j + 1] = a[j--];
			
			a[++j] = key;		
		}	
	}	
	
	// With integers
	public static void sort(Integer a[]) {
		int max = a.length;
		
		for(int i = 0; i < max; i++) {
			int key = a[i];
			int j = i - 1;
			
			// Moves to one position ahead values greater than key 
			while(j > 0 && a[j] > key) 
				a[j + 1] = a[j--];
				
			a[++j] = key;	
		}
	}
	
	public static String print(Object[] a) {
		String array = "";
		
		for(int i = 0; i < a.length; i++) {
			array += a[i];
			array += " ";
		}
		
		return array;		
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfInputs = Integer.parseInt(in.nextLine()); // ignore /n
		
		String s[] = new String[numberOfInputs];
		
		for(int i = 0; i < numberOfInputs; i++) {
			s[i] = in.nextLine();
		}
		
		InsertionSort.sort(s);
		InsertionSort.sort(s);
		
		System.out.print(print(s));
		in.close();
	}
	
}
