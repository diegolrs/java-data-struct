import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws EmptyException {
		Scanner in = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
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
				System.out.print(stack.pop() + " ");
			else
				stack.push(word);
		}
		
		/*while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");*/
		
		in.close();
	}

}
