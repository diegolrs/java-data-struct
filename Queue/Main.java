import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws EmptyException {
		Queue<String> queue = new Queue<String>();
		
		Scanner in = new Scanner(System.in);
		
		String allWords = new String();		
		String currentLine  = in.nextLine();
		String nextLine;
		
		while(true) {
			 nextLine = in.nextLine();
	
			 allWords += currentLine + " " + nextLine;
			 
			 String newCurrent = in.nextLine();
			 currentLine = newCurrent;
			 
			 // Break loop after three enters
			 if(nextLine.equals("") && newCurrent.equals(""))
				 break;	 
		}
		
		String[] words = allWords.split(" ");
		
		for(String word : words){					
			if(word.equals("-"))
				System.out.print(queue.dequeue() + " ");
			else
				queue.enqueue(word);
		}
		
		/* while(!queue.isEmpty())
			System.out.print(queue.dequeue() + " "); */
		
		
		in.close();
		
	}

}
