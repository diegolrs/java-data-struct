import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	private static Random rand = new Random();
	
	public static void quickSort(String[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private static void quickSort(String[] a, int start, int end) {
		int left = start;
		int right = end;
		int pivot = rand.nextInt(right - left) + left;
		
		// Get next item greater than pivot
		while(a[left].compareToIgnoreCase(a[pivot]) < 0)
			left++;
		
		// Get next item lower than pivot
		while(a[right].compareToIgnoreCase(a[pivot]) > 0)
			right--;
		
		// If item next to pivot is greater than item previous
		if(left <= right) 
		{
			swap(a, left, right);
			left++;
			right--;
		}
		
		if(left < end)
			quickSort(a, left, end);
		
		if(right > start)
			quickSort(a, start, right);		
	}
	
	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static String toString(String a[]) {
		String text = "";
		
		for(int i = 0; i < a.length; i++)
			text += a[i] + " ";
			
		return text;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfInputs = Integer.parseInt(in.nextLine()); // ignore /n
		
		String s[] = new String[numberOfInputs];
		
		for(int i = 0; i < numberOfInputs; i++)
			s[i] = in.nextLine();

		QuickSort.quickSort(s);
		
		System.out.println(toString(s));
		
		in.close();
	}
	
}
