import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Build the graph
 * @author L02-13
 *
 */
public class Buildgraph {
	
	/**
	 * Generate the graph
	 * @param gameMap hashmap for games
	 * @param playerMap hashmap for player
	 * @param games array list for games
	 * @param players array list of players
	 * @return player-game graph
	 * @throws Exception
	 */
	//graph
	public static Graph GameGraph(HashMap<String, Integer> gameMap, HashMap<String, Integer> playerMap, ArrayList<Game> games, ArrayList<Player> players) throws Exception {

		Graph g = new Graph(games.size()+ players.size());

		BufferedWriter bw = new BufferedWriter(new FileWriter("data/error.txt", true));
		BufferedReader br = new BufferedReader(new FileReader("data/output.csv"));
		String line;
		
		while ((line = br.readLine()) != null) {
			ArrayList<String> elements = Read.getElements(line);
			//System.out.println("Game is " + elements.get(1));
			
			String temp = elements.get(1).replaceAll("[^A-Za-z0-9]", "");
			temp = temp.toUpperCase();
			int game = 0;
			int player = 0;
			
			try {
				game = gameMap.get(temp);
				//System.out.println(from);
			}catch(Exception e){
				//System.out.println("Exception at game");
				//e.printStackTrace(System.err);
				bw.write("Exception at game" + elements.get(1));
				bw.newLine();
			}
			
			//System.out.println("player is " + elements.get(0));
			try {
				player = playerMap.get(elements.get(0));
				//System.out.println(to);
			}catch(Exception e){
				//System.out.println("Exception at player");
				//e.printStackTrace(System.err);
				bw.write("Exception at player" + elements.get(0) + " while creating graph");
				bw.newLine();
			}
			g.addEdge(new Edge(game, player, Double.parseDouble(elements.get(5))));
		}
		br.close();
		
		bw.close();
		return g;
	}
	
	/**
	 * add a player into the graph
	 * @param g existing graph
	 * @param user Player
	 * @param gameMap hashmap for games
	 * @throws IOException
	 */
	public static void addPlayer(Graph g, Player user, HashMap<String, Integer> gameMap) throws IOException {
		ArrayList<String> games = user.getPurchased();
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/error.txt", true));
		for(int i = 0; i <games.size(); i++) {
			String temp = games.get(i).replaceAll("[^A-Za-z0-9]", "");
			temp = temp.toUpperCase();
			int player = g.getV() - 1;
			int game = 0;
			
			try {
				game = gameMap.get(temp);
				g.addEdge(new Edge(game, player, 3+i));
				//System.out.println(from);
			}catch(Exception e){
				//System.out.println("Exception at game");
				//e.printStackTrace(System.err);
				bw.write("Exception at game" + games.get(i) + " while adding user");
				bw.newLine();
			}
		}
		bw.close();
	}

}
