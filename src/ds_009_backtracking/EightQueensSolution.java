package ds_009_backtracking;

public class EightQueensSolution {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		boolean[] occupied = new boolean[64];
		
		boolean result = findSolution(occupied, 0);
		
		if(result) {
			printChessBoard(occupied);
		}
		
		System.out.println(count + " nodes visited");
		
	}
	
	private static boolean findSolution(boolean[] occupied, int queensCount) {
		if(!checkBoard(occupied)) {
			return false;
		}
		if(queensCount == 8) {
			return true;
		}
		for(int i = 0; i < 64; i++) {
			// should use null instead of false?
			if(!occupied[i]) {
				count++;
				occupied[i] = true;
				if(findSolution(occupied, queensCount+1)) {
					return true;
				}
				occupied[i] = false;
			}
		}
		return false;
	}
	
	private static boolean checkBoard(boolean[] occupied) {
		for(int i = 0; i < occupied.length; i++) {
			if(occupied[i]) {
				if(!checkOccupied(i, occupied)) {
					return false;
				}
			}
		}
		
		return true;
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
