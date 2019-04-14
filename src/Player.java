import java.util.ArrayList;
/**
 * 
 * @author L02-13
 * ADT for player
 */
public class Player {
	
	private final String id;
	private ArrayList<String> purchased;
	
	/**
	 * Constructor for Player
	 * @param id line from csv file
	 */
	public Player(String id) {
		this.id = id;
		purchased = new ArrayList<String>();
	}
	
	/**
	 * get the id from player
	 * @return Sting for player id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 
	 * @param purchased String for the game purchased
	 */
	public void addPurchase(String purchased){
		this.purchased.add(purchased);
	}
	
	/**
	 * 
	 * @return return the purchased arraylist
	 */
	public ArrayList<String> getPurchased(){
		ArrayList<String> temp = new ArrayList<String>();
		for (int i=0; i<purchased.size(); i++) {
			temp.add(purchased.get(i));
		}
		return temp;
	}
	
	/**
	 * print the purchased information
	 */
	public void printPurchase(){
		for(int i = 0; i < purchased.size(); i++ ) {
			System.out.print(purchased.get(i) + " ");
			System.out.println();
		}
	}
	
}
