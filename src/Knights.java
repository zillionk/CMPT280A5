import javax.xml.bind.annotation.W3CDomHandler;

import lib280.base.Pair280;
import lib280.graph.Edge280;
import lib280.graph.GraphAdjListRep280;
import lib280.graph.Vertex280;
import lib280.list.LinkedIterator280;




public class Knights<V extends Vertex280, E extends Edge280<V>> extends GraphAdjListRep280<V,E>{
		
	protected Pair280<Boolean, Integer> theCheckerboard[];
	
	@SuppressWarnings("unchecked")
	public Knights(int cap, boolean d) {
		super(cap, d);
		for (int i = 0; i < cap; i++) {
			addVertex(i+1);
		}

		theCheckerboard = new Pair280[cap+1];
		for (int i = 1; i < cap+1; i++) {
			theCheckerboard[i] = new Pair280<Boolean, Integer>(false, 0); 
		}
		addAllEdge();
		
	}
	
	/**
	 * add all the path which can touched by the knight for every checked board.
	 */
	private void addAllEdge() {
		int k = (int) Math.sqrt((double)(capacity()/4));
		
		for (int i = 1; i < vertexArray.length+1; i++) {
			int position = i%(2*k);// calculation
			if (position == 1) {//if the position is at left edge of the chess,
				if ((i-2*k+2)>0 && (i-2*k+2)<capacity()) {
					addEdge((i-2*k+2), i);
				}
				if ((i+2*k+2)>0 && (i+2*k+2)<capacity()) {
					addEdge((i+2*k+2), i);
				}
				if ((i-4*k+1)>0 && (i-4*k+1)<capacity()) {
					addEdge((i-4*k+1), i);
				}
				if ((i+4*k+1)>0 && (i+4*k+1)<capacity()) {
					addEdge((i+4*k+1), i);
				}
			}else if (position == 2) {//if the position is beside the left edge of the chess,
				if ((i-2*k+2)>0 && (i-2*k+2)<capacity()) {
					addEdge((i-2*k+2), i);
				}
				if ((i+2*k+2)>0 && (i+2*k+2)<capacity()) {
					addEdge((i+2*k+2), i);
				}
				if ((i-4*k+1)>0 && (i-4*k+1)<capacity()) {
					addEdge((i-4*k+1), i);
				}
				if ((i-4*k-1)>0 && (i-4*k-1)<capacity()) {
					addEdge((i-4*k-1), i);
				}
				if ((i+4*k+1)>0 && (i+4*k+1)<capacity()) {
					addEdge((i+4*k+1), i);
				}
				if ((i+4*k-1)>0 && (i+4*k-1)<capacity()) {
					addEdge((i+4*k-1), i);
				}
			}else if (position == (2*k-1)) {//if the position is beside the right edge of the chess,
				if ((i-2*k-2)>0 && (i-2*k-2)<capacity()) {
					addEdge((i-2*k-2), i);
				}
				if ((i+2*k-2)>0 && (i+2*k-2)<capacity()) {
					addEdge((i+2*k-2), i);
				}
				if ((i-4*k+1)>0 && (i-4*k+1)<capacity()) {
					addEdge((i-4*k+1), i);
				}
				if ((i-4*k-1)>0 && (i-4*k-1)<capacity()) {
					addEdge((i-4*k-1), i);
				}
				if ((i+4*k+1)>0 && (i+4*k+1)<capacity()) {
					addEdge((i+4*k+1), i);
				}
				if ((i+4*k-1)>0 && (i+4*k-1)<capacity()) {
					addEdge((i+4*k-1), i);
				}
			}else if (position == 0) {//if the position is at right edge of the chess,
				if ((i-2*k-2)>0 && (i-2*k-2)<capacity()) {
					addEdge((i-2*k-2), i);
				}
				if ((i+2*k-2)>0 && (i+2*k-2)<capacity()) {
					addEdge((i+2*k-2), i);
				}
				if ((i-4*k-1)>0 && (i-4*k-1)<capacity()) {
					addEdge((i-4*k-1), i);
				}
				if ((i+4*k-1)>0 && (i+4*k-1)<capacity()) {
					addEdge((i+4*k-1), i);
				}
			}else {
				if ((i-2*k+2)>0 && (i-2*k+2)<capacity()) {
					addEdge((i-2*k+2), i);
				}
				if ((i-2*k-2)>0 && (i-2*k-2)<capacity()) {
					addEdge((i-2*k-2), i);
				}
				if ((i+2*k+2)>0 && (i+2*k+2)<capacity()) {
					addEdge((i+2*k+2), i);
				}
				if ((i+2*k-2)>0 && (i+2*k-2)<capacity()) {
					addEdge((i+2*k-2), i);
				}
				if ((i-4*k+1)>0 && (i-4*k+1)<capacity()) {
					addEdge((i-4*k+1), i);
				}
				if ((i-4*k-1)>0 && (i-4*k-1)<capacity()) {
					addEdge((i-4*k-1), i);
				}
				if ((i+4*k+1)>0 && (i+4*k+1)<capacity()) {
					addEdge((i+4*k+1), i);
				}
				if ((i+4*k-1)>0 && (i+4*k-1)<capacity()) {
					addEdge((i+4*k-1), i);
				}	
			}
			

		}
		
	}


	public static int howMany(int k){
	
		int MaxNumber=0;
		for (int i = 1; i < k+1; i++) {
			int thisNumber = largestFromthisPoint(k, i, true);
			System.out.println("new chess!last one have: "+thisNumber+" Knights!");
			if (thisNumber>MaxNumber) {
				MaxNumber = thisNumber;
			}
		}
		return MaxNumber;
		
	}
	/**
	 *  which put knight into chess and let only 2 other knight
	 * can attack it.
	 * @param k the chess size is 2k * 2k
	 * @param i calculate from the iTH element from the left top corner.  
	 * @param b	if put knight in the start cell
	 * @return the largest possibility number which can put knight into the chess.
	 */
	private static int largestFromthisPoint(int k, int i, boolean b) {
	Knights<Vertex280, Edge280<Vertex280>> K = new Knights<>(4*k*k, false);
	K.theCheckerboard[i].setFirstItem(b);	
	int maxNumber = 0;
	for (int j = 1; j < K.capacity()+1; j++) {
		if (thisPointCanPutKnightOn(K, j)) {
			K.theCheckerboard[i].setFirstItem(true);
		}
		maxNumber =maxNumber + checkNeighbour(K,j);
	}
	return maxNumber;
}
	private static int checkThisPoint(Knights<Vertex280, Edge280<Vertex280>> k, int i) {
		if (thisPointCanPutKnightOn(k,i)) {
			k.theCheckerboard[i].setFirstItem(true);
			LinkedIterator280<Edge280<Vertex280>> anIterator = new LinkedIterator280<>(k.adjLists[i]);
			anIterator.goFirst();
			while (anIterator.itemExists()) {
				int code = anIterator.item().secondItem().index();
				int j= k.theCheckerboard[code].secondItem();
				k.theCheckerboard[code].setSecondItem(j+1);
				anIterator.goForth();
				
			}
			//TODO
			//test code
			System.out.println("put a knight on: "+i+" square.");
			
			return 1+checkNeighbour(k,i);
		} else {
			return 0;
		}
	}

	private static boolean thisPointCanPutKnightOn(
			Knights<Vertex280, Edge280<Vertex280>> k, int i) {
		boolean noKnightOnIt = !k.theCheckerboard[i].firstItem();
		boolean lessThanTwoKnightCanAttack = true;
		boolean knightNeighbourFeelOK = true;
		if (k.theCheckerboard[i].secondItem() > 1) {
			lessThanTwoKnightCanAttack = false;
		}
		LinkedIterator280<Edge280<Vertex280>> anIterator = new LinkedIterator280<>(k.adjLists[i]);
		anIterator.goFirst();
		while (anIterator.itemExists()) {
			
			int code = anIterator.item().secondItem().index();
			if (k.theCheckerboard[code].secondItem() > 1 ) {
				knightNeighbourFeelOK = false;
				break;
			}
			anIterator.goForth();
		}
		
		
		return noKnightOnIt && lessThanTwoKnightCanAttack && knightNeighbourFeelOK;
	}

	private static int checkNeighbour(Knights<Vertex280, Edge280<Vertex280>> k, int i) {
		int MaxNumber=0;
		int thisNumber=0;

		
		LinkedIterator280<Edge280<Vertex280>> anIterator = new LinkedIterator280<>(k.adjLists[i]);
		anIterator.goFirst();
		while (anIterator.itemExists()) {
			
			Knights<Vertex280, Edge280<Vertex280>> W = (Knights<Vertex280, Edge280<Vertex280>>) k.clone();
			for (int j = 1; j < k.capacity()+1; j++) {
				W.theCheckerboard[j] = W.theCheckerboard[j].clone();
			}
			int code = anIterator.item().secondItem().index();
//			System.out.println("check #"+code+" square.");
			thisNumber +=checkThisPoint(W, code);
			
			if (thisNumber>MaxNumber) {
				MaxNumber = thisNumber;
			}
			
			anIterator.goForth();
//			System.out.println(W.theCheckerboard.toString());
		}
		return MaxNumber;
	}

	public static void main(String[] args) {
		Knights<Vertex280, Edge280<Vertex280>> K = new Knights<>(64, false);
		
		System.out.println(K);
		System.out.println("\n the final answer is: " + Knights.howMany(4));
	}
}
