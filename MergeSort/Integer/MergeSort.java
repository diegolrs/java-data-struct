public class MergeSort {
	
	private static int[] num, temp;
	
	public static void mergeSort(int[] a) {
		num = a;
		temp = new int[a.length];
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
			if(temp[left] <= temp[right]) {
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

	private static String toString(int[] a){
		String text = "";
		
		for(int i = 0; i < a.length; i++) {
			text += a[i] + " ";
		}
		
		return text;	
	}
	
	public static void main(String[] args) {
		int[] v = {7, 1, 2, 3, 4};
		
		MergeSort.mergeSort(v);
		
		System.out.println(toString(v));
	}
	
}
