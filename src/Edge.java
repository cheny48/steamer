/**
 * ADT for edge
 * @author L02-13
 *
 */
public class Edge {
	private final int game;
	private final int player;
	private final double relativePlay;
	
	/**
	 * 
	 * @param game index for the games
	 * @param player index for player
	 * @param weight game-player relative play time
	 */
	public Edge(int game, int player, double weight) {
		this.game = game;
		this.player = player;
		this.relativePlay = weight;
	}
	
	/**
	 * 
	 * @return return game index
	 */
	public int getGame() {
		return this.game;
	}
	
	/**
	 * 
	 * @return return player index
	 */
	public int getPlayer() {
		return this.player;
	}
	
	/**
	 * 
	 * @return return relative play time
	 */
	public double getRelative() {
		return this.relativePlay;
	}
}