package ds_999_misc;

public class WordPermutation {

	public static void main(String[] args) {
		char[] choices = { 'a','b','c' };
		char[] selection = new char[5];
		
		makePermutation(choices, selection);
	}

	private static void makePermutation(char[] choices, char[] selection) {
		makePermutation(choices, selection, 0);
	}
	
	private static void makePermutation(char[] choices, char[] selection, int index) {
		if(index == selection.length) {
			printArray(selection);
		} else {
			for(int i = 0; i < choices.length; i++) {
				selection[index] = choices[i];
				makePermutation(choices, selection, index+1);
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
