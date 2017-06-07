package ds_008_recursion;

/*
 * O(2^N)
 */
public class TowerOfHanoiDemo {

	public static void main(String[] args) {
		final int N = 3;
		
		final Integer[][] pegs = initPegs(N);
		printPegs(pegs);
		System.out.println();
		solve(pegs);
		
		printPegs(pegs);
	}
	
	private static void solve(Integer[][] pegs) {
		int srcPeg = 0;
		int dstPeg = 2;
		int numberOfDisks = pegs[0][0];
		move(pegs, srcPeg, dstPeg, numberOfDisks);
	}
	
	private static void move(Integer[][] pegs, int srcPeg, int dstPeg, int numOfDisks) {
		if(numOfDisks == 0) {
			return;
		}
		
		// which peg will be used temporary peg?
		int tmpPeg = getTemporaryPeg(srcPeg, dstPeg);
		
		// move upper part from src to temp
		move(pegs, srcPeg, tmpPeg, numOfDisks-1);
		
		// move biggest disk to dst
		moveOneDisk(pegs, srcPeg, dstPeg);
//		printPegs(pegs);
		
		// move from temp to dst
		move(pegs, tmpPeg, dstPeg, numOfDisks-1);
		
	}
	
	private static void moveOneDisk(Integer[][] pegs, int srcPeg, int dstPeg) {
		int moveIndex = getTopDiskIndex(pegs, srcPeg);
		int emptyIndex = getNextEmptyIndex(pegs, dstPeg);
		
		Integer moved = pegs[srcPeg][moveIndex];	// store the disk
		pegs[srcPeg][moveIndex] = null;		// disk left the src peg
		pegs[dstPeg][emptyIndex] = moved;
	}
	
	private static int getNextEmptyIndex(Integer[][]pegs, int peg) {
		for(int j = 0; j < pegs[peg].length; j++) {
			if(pegs[peg][j] == null) {
				return j;
			}
		}
		
		return -1;
	}
	
	private static int getTopDiskIndex(Integer[][]pegs, int peg) {
		for(int j = pegs[peg].length-1; j >= 0; j--) {
			if(pegs[peg][j] != null) {
				return j;
			}
		}
		
		return -1;
	}
	
	private static int getTemporaryPeg(int srcPeg, int dstPeg) {
		int newPeg;
		if(srcPeg == 0) {
			if(dstPeg == 1) {
				newPeg = 2;
			} else {
				// dstPeg == 2
				newPeg = 1;
			}
		} else if(srcPeg == 1) {
			if(dstPeg == 0) {
				newPeg = 2;
			} else {
				// dstPeg == 2
				newPeg = 0;
			}
		} else {
			// srcPeg == 2
			if(dstPeg == 1) {
				newPeg = 0;
			} else {
				// dstPeg == 0
				newPeg = 1;
			}
		}
		
		return newPeg;
	}
	
	private static final Integer[][] initPegs(final int N) {
		final Integer[][] pegs = new Integer[3][N];
		
		for(int width = N, index = 0; width > 0; width--, index++) {
			pegs[0][index] = width;
		}
		
		return pegs;
	}
	
	private static void printPegs(final Integer[][] pegs) {
		for(int i = 0; i < pegs.length; i++) {
			System.out.print("|: ");
			for(int j = 0; j < pegs[i].length ; j++) {
				if(pegs[i][j] != null) {
					System.out.printf("%d ", pegs[i][j]);
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	private static void printPegsVerbose(final Integer[][] pegs) {
		for(int i = 0; i < pegs.length; i++) {
			System.out.print("|: ");
			for(int j = 0; j < pegs[i].length ; j++) {
				System.out.printf("%d ", pegs[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

}
