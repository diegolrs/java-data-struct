import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	private static Random rand = new Random();
	
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private static void quickSort(int[] a, int start, int end) {		
		int left = start;
		int right = end;
		
		int pivot = a[rand.nextInt(right - left) + left];
		
		while(a[left] < pivot)
			left++;
		
		while(a[right] > pivot)
			right--;
		
		if(left <= right) {
			swap(a, left, right);
			left++;
			right--;
		}
	
		if(right > start)
			quickSort(a, start, right);
		
		if(left < end)
			quickSort(a, left, end);	
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static String toString(int a[]) {
		String text = "";
		
		for(int i = 0; i < a.length; i++) {
			text += a[i] + " ";
		}
			
		return text;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a[] = {0, 1, 3, 2, 4, 8, 6, 7, 9};
		
		QuickSort.quickSort(a);
		
		System.out.println(toString(a));
		
		in.close();
	}
	
}
