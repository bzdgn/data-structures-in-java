package ds_999_misc;

public class WordCombination {

	public static void main(String[] args) {
		char[] choices = { 'a','b','c' };
		char[] selection = new char[5];
		
		makeCombination(choices, selection);
	}

	private static void makeCombination(char[] choices, char[] selection) {
		makeCombination(choices, selection, 0);
	}
	
	private static void makeCombination(char[] choices, char[] selection, int index) {
		if(index == selection.length) {
			printArray(selection);
		} else {
			int start = 0;
			if(index > 0) {
				start = selection[index-1]-'a';	// start = previous selected
			}
			for(int i = start; i < choices.length; i++) {
				selection[index] = choices[i];
				makeCombination(choices, selection, index+1);
			}
		}
	}

	private static void printArray(char[] selection) {
		for(int i = 0; i < selection.length; i++) {
			System.out.printf("%c", selection[i]);
		}
		System.out.print("\n");
	}

}
