package ds_009_backtracking;

public class CustomEightQueens {

	public static void main(String[] args) {
		boolean[] occupied;
				
		int start = 0;
		int queens = 0;
		
		do{
			occupied = new boolean[64];
			
			queens = getEightQueens(start++, occupied);
			
			if(queens == 8) {
				System.out.println("\t\tFOUND SOLUTION");
				break;
			}
			
		} while(queens < 7 && start < (64-8));
		
		printChessBoard(occupied);
		System.out.println("Queens: " + queens);
	}
	
	private static int getEightQueens(int start, boolean[] occupied) {
		int queenCount = 0;
		
		int q = start-1;
		do{
			q = getNextOccupied(q+1, occupied);
			if(q != -1) {
				queenCount++;
			}
		} while(q != -1);
		
		return queenCount;
	}
	
	private static int getNextOccupied(int startIndex, boolean[] occupied) {
		for(int i = startIndex; i < 64; i++) {
			if(checkOccupied(i, occupied)) {
				occupied[i] = true;
				
				return i;
			}
		}
		
		return -1;
	}
	
	private static boolean checkOccupied(int q, boolean[] occupied) {
		return checkHorizontal(q, occupied) && checkVertical(q, occupied)
				&& checkLeftCross(q, occupied) && checkRightCross(q, occupied);
	}
	
	private static boolean checkHorizontal(int q, boolean[] occupied) {
		// get line number
		int lineNumber	= q/8;
		int startOfLine	= lineNumber*8;
		int endOfLine	= (lineNumber+1)*8 -1;
		
		// check left
		for(int i = startOfLine; i <= endOfLine; i++) {
			if(i == q) {
				continue;
			}
			
			if(occupied[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean checkVertical(int q, boolean[] occupied) {
		int startCol = q%8;
		int endCol = startCol + 8*(8-1);
		
		for(int i = startCol; i <= endCol; i+= 8) {
			if(i == q) {
				continue;
			}
			
			if(occupied[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 *    \
	 *     \
	 *      \
	 */
	private static boolean checkLeftCross(int q, boolean[] occupied) {
		int i = q;
		// Upper Cross
		while(i%8 != 0) {
			i -= 9;
			
			if(i < 0 || i > 63) {
				break;
			}
			
			if(occupied[i]) {
				return false;
			}
		}
		
		i = q;
		// Lower Cross
		while(i%8 != 7) {
			i += 9;
			
			if(i < 0 || i > 63) {
				break;
			}
			
			if(occupied[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 *      /
	 *     /
	 *    /
	 */
	private static boolean checkRightCross(int q, boolean[] occupied) {
		int i = q;
		// Upper Cross
		while(i%8 != 7 && i >= 0) {
			i -= 7;
			
			if(i < 0 || i > 63) {
				break;
			}
			
			if(occupied[i]) {
				return false;
			}
		}
		
		i = q;
		// Lower Cross
		while(i%8 != 0 && i < 64) {
			i += 7;
			
			if(i < 0 || i > 63) {
				break;
			}
			
			if(occupied[i]) {
				return false;
			}
		}
		
		return true;
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
	
}
