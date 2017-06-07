package ds_009_backtracking;

public class EightQueensMod2Solution {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		boolean[] occupied		= new boolean[64];
		int[] numberOfAttacks	= new int[64];
		
		boolean result = findSolution(occupied, numberOfAttacks, 0);
		
		if(result) {
			printChessBoard(occupied);
			printChessBoard(numberOfAttacks);
		}
		
		
		
		System.out.println(count + " nodes visited");
		
	}
	
	/*
	 * On each row, there could only be one Queen
	 * So we will visit 8 rows
	 */
	private static boolean findSolution(boolean[] occupied, int[] numberOfAttacks, int row) {	
		if(row == 8) {
			return true;
		}
		
		for(int col = 0; col < 8; col++) {
			int i = col + row*8;
			if(!occupied[i] && numberOfAttacks[i] == 0) {
				count++;
				occupied[i] = true;
				countAttacks(i, occupied, numberOfAttacks, +1);
				if(findSolution(occupied, numberOfAttacks, row+1)) {
					return true;
				}
				countAttacks(i, occupied, numberOfAttacks, -1);
				occupied[i] = false;
			}
		}
		
		return false;
	}
	
	private static void countAttacks(int q, boolean[] occupied, int[] numberOfAttack, int amount) {
		countHorizontal(q, occupied, numberOfAttack, amount);
		countVertical(q, occupied, numberOfAttack, amount);
		countLeftCross(q, occupied, numberOfAttack, amount);
		countRightCross(q, occupied, numberOfAttack, amount);
	}
	
	private static void countHorizontal(int q, boolean[] occupied, int[] numberOfAttack, int amount) {
		// get line number
		int lineNumber	= q/8;
		int startOfLine	= lineNumber*8;
		int endOfLine	= (lineNumber+1)*8 -1;
		
		// check left
		for(int i = startOfLine; i <= endOfLine; i++) {
			if(i == q) {
				continue;
			}
			
			numberOfAttack[i]+=amount;
		}
	}
	
	private static void countVertical(int q, boolean[] occupied, int[] numberOfAttack, int amount) {
		int startCol = q%8;
		int endCol = startCol + 8*(8-1);
		
		for(int i = startCol; i <= endCol; i+= 8) {
			if(i == q) {
				continue;
			}
			
			numberOfAttack[i]+=amount;
		}
	}
	
	/*
	 *    \
	 *     \
	 *      \
	 */
	private static void countLeftCross(int q, boolean[] occupied, int[] numberOfAttack, int amount) {
		int i = q;
		// Upper Cross
		while(i%8 != 0) {
			i -= 9;
			
			if(i < 0 || i > 63) {
				break;
			}
			
			numberOfAttack[i]+=amount;
		}
		
		i = q;
		// Lower Cross
		while(i%8 != 7) {
			i += 9;
			
			if(i < 0 || i > 63) {
				break;
			}
			
			numberOfAttack[i]+=amount;
		}
	}
	
	/*
	 *      /
	 *     /
	 *    /
	 */
	private static void countRightCross(int q, boolean[] occupied, int[] numberOfAttack, int amount) {
		int i = q;
		// Upper Cross
		while(i%8 != 7 && i >= 0) {
			i -= 7;
			
			if(i < 0 || i > 63) {
				break;
			}
			
			numberOfAttack[i]+=amount;
		}
		
		i = q;
		// Lower Cross
		while(i%8 != 0 && i < 64) {
			i += 7;
			
			if(i < 0 || i > 63) {
				break;
			}
			
			numberOfAttack[i]+=amount;
		}
	}
	
	private static void printChessBoard(boolean[] occupied) {
		for(int i = 0; i < occupied.length; i++) {
			if(occupied[i]) {
				System.out.print("Q ");
			} else {
				System.out.print(". ");
			}
			
			if(i%8 == 7) {
				System.out.print("\n");
			}
		}
	}
	
	private static void printChessBoard(int[] numberOfAttacks) {
		for(int i = 0; i < numberOfAttacks.length; i++) {
			System.out.printf("%d ", numberOfAttacks[i]);
			
			if(i%8 == 7) {
				System.out.print("\n");
			}
		}
	}
	
}
