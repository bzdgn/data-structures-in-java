package ds_008_recursion;

/*
 * O(2^N)
 */
public class TowerOfHanoiPegStackDemo {
	
	private static int recursiveCount = 0;
	
	public static void main(String[] args) {
		final int N = 5;
		
		final PegStack[] pegs = initPegs(N);
		printPegs(pegs);
		
		solve(pegs);
		
		printPegs(pegs);
	}
	
	private static void solve(PegStack[] pegs) {
		int srcPeg = 0;
		int dstPeg = 2;
		int numberOfDisks = pegs[0].bottomValue();
		move(pegs, srcPeg, dstPeg, numberOfDisks);
	}
	
	private static void move(PegStack[] pegs, int srcPeg, int dstPeg, int numOfDisks) {
		if(numOfDisks == 0) {
			return;
		}
		
		// which peg will be used temporary peg?
		int tmpPeg = getTemporaryPeg(srcPeg, dstPeg);
		
		// move upper part from src to temp
		move(pegs, srcPeg, tmpPeg, numOfDisks-1);
		
		// move biggest disk to dst
		moveOneDisk(pegs, srcPeg, dstPeg);
		
		// for debug
//		showState(pegs);
		
		// move from temp to dst
		move(pegs, tmpPeg, dstPeg, numOfDisks-1);
		
	}
	
	private static void moveOneDisk(PegStack[] pegs, int srcPeg, int dstPeg) {
		Integer moved = pegs[srcPeg].pop();
		pegs[dstPeg].push(moved);
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
	
	private static final PegStack[] initPegs(int N) {
		final PegStack[] pegs = new PegStack[3];
		
		for(int i = 0; i < 3; i++) {
			pegs[i] = new PegStack();
		}
		
		for(int i = N; i >= 1; i--) {
			pegs[0].push(i);
		}
		
		return pegs;
	}
	
	private static void printPegs(final PegStack[] pegs) {
		for(int i = 0; i < pegs.length; i++) {
			pegs[i].printPeg();
		}
		System.out.print("\n");
	}
	
	private static void showState(PegStack[] pegs) {
		recursiveCount++;
		System.out.println("Count: " + recursiveCount);
		printPegs(pegs);
	}

}
