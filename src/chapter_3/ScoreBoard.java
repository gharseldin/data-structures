package chapter_3;

public class ScoreBoard {
	private int numEntries = 0;
	private GameEntry[] board;
	
	public ScoreBoard(int capacity){
		board = new GameEntry[capacity];
	}
	
	public void add(GameEntry e){
		int newScore = e.getScore();
		
		if(numEntries < board.length || newScore > board[numEntries-1].getScore()){
			if(numEntries<board.length)
				numEntries++;
			int j = numEntries - 1;
			while(j>0 && board[j-1].getScore() < newScore){
				board[j] = board[j-1];
				j--;
			}
			board[j] = e;
		}
	}
	
	public GameEntry remove(int i) throws IndexOutOfBoundsException{
		if (i< 0 || i >= numEntries)
			throw new IndexOutOfBoundsException("Invalid index: "+i);
		GameEntry temp = board[i];
		for (int j=i; j< numEntries-1; j++)
			board[j] = board[j+1];
		board[numEntries-1] = null;
		numEntries--;
		return temp;
	}
	
	// Question 19
//	public void addWithoutSorting(GameEntry entry){
//		if(numEntries < board.length) {
//			board[numEntries] = entry;
//			numEntries++;
//		}
//		// else undefined case! 
//	}
//	// not clear in the requirements!
//	public GameEntry removeWithoutSorting(int i){
//		
//	}

	public String toString(){
		String output = "";
		for(GameEntry entry : board){
			output += entry + ", ";
		}
		return output.substring(0, output.length()-2);
	}
	
	public static void main(String[] args){
		ScoreBoard scoreboard = new ScoreBoard(10);
		scoreboard.add(new GameEntry("AMG", 100));
		scoreboard.add(new GameEntry("XYZ", 101));
		scoreboard.add(new GameEntry("EFG", 200));
		scoreboard.add(new GameEntry("III", 321));
		scoreboard.add(new GameEntry("LLL", 8));
		System.out.println(scoreboard);
		scoreboard.remove(3);
		System.out.println(scoreboard);
	}
}
