import java.util.Scanner;

public class MergeSort {	
	private static String[] num, temp;
	
	public static void mergeSort(String[] a) {
		num = a;
		temp = new String[a.length];
		mergeSort(0, a.length - 1);
	}
	
	private static void mergeSort(int low, int high) {	
		if(low >= high)
			return;
		
		int middle = (low + high) / 2;
		
		mergeSort(low, middle);
		mergeSort(middle + 1, high);
		merge(low, middle, high);
	}

	private static void merge(int low, int median, int high) {	
		
		// Copy num to temp
		for(int i = low; i <= high; i++) {
			temp[i] = num[i];
		}
		
		int left = low;
		int right = median + 1;
		int currentPosition = low;
		
		while(left <= median && right <= high) {
			if(temp[left].compareToIgnoreCase(temp[right]) < 0) {
				num[currentPosition] = temp[left];
				left++;
			}else {
				num[currentPosition] = temp[right];
				right++;
			}
			
			currentPosition++;
		}
		
		while(left <= median) 
		{
			num[currentPosition] = temp[left];
			currentPosition++;
			left++;
		}
			
		while(right <= high) 
		{
			num[currentPosition] = temp[right];
			currentPosition++;
			right++;
		}
					
	}

	private static String toString(String[] a){
		String text = "";
		
		for(int i = 0; i < a.length; i++) {
			text += a[i] + " ";
		}
		
		return text;	
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfInputs = Integer.parseInt(in.nextLine()); // ignore /n
		
		String s[] = new String[numberOfInputs];
		
		for(int i = 0; i < numberOfInputs; i++) {
			s[i] = in.nextLine();
		}
		
		MergeSort.mergeSort(s);		
		System.out.println(toString(s));
		
		in.close();
	}
	
}
