package neustadt.mco364.tictactoe;

import java.util.List;
import java.util.Random;

public class BestMoveFinder {

	private static final Random RAND = new Random();
	/*
	 * return the best move for the active player as a number btw. 0-8
	 */

	// level 1: can i win. enumerate through possible boards for win
	// level 2: can the other player win.
	// level 3: where should i go.

	public int getBestMove(Board parent) {
		Board.Piece activePlayer = parent.getActivePlayer();
		List<Integer> moves = parent.getMoves();
		for (int move : moves) {
			Board child = new Board(parent);
			child.set(move, activePlayer);
			if (child.getWinner() == activePlayer) {
				return move;
			}
		}
		return moves.get(RAND.nextInt(moves.size()));
	}
	
	public int getBestMoveRecursive(Board parent){
		Board.Piece activePlayer = parent.getActivePlayer();
		List<Integer> moves = parent.getMoves();
		
		
		
		for (int move : moves) {
			Board child = new Board(parent);
			computeMove(child, child.getActivePlayer(), move);
			getBestMoveRecursive(child);
		}	
		return -1;
		}		
	
	private int computeMove(Board board, Board.Piece activePlayer, int move){
		board.set(move, activePlayer);
		if (board.getWinner() == activePlayer) {
			return Integer.MAX_VALUE;
		}
		else if (board.getWinner() == activePlayer) {
			return Integer.MIN_VALUE;
		}
		return -1;
		}
	
	public static void main(String[] args) {
	}
}