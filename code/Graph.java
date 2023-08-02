import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Graph {

	/*
	 * useDistCost
	 * returnAddress
	 * Hashmap<Vertex, Set<Edge>>
	 * graph (filename)
	 * -create all vertices and edges
	 * 
	 * look at HashMap
	 */
	private File f;
	public HashMap<Vertex, Set<Edge>> hm = new HashMap<>();
	public HashMap<Character, Vertex> vCheck = new HashMap<>();
	
	public Graph(String name) {
		f = new File(name);
		try {
			Scanner gps = new Scanner(f);
			gps.next();
			gps.next();
			gps.next();
			while (gps.hasNextLine()) {
				String check = gps.next();
				if (!check.equals("</Nodes>")) {
					String check2 = gps.nextLine();
					check2 = check2.substring(1);
					this.addVertex(check.charAt(0), check2);
				} else {
					break;
				}
			}
			gps.next();
			gps.next();
			gps.nextLine();
			while (gps.hasNextLine()) {
				String check = gps.next();
				if (!check.equals("</Edges>")) {
					char x = check.charAt(0);
					char c = gps.next().charAt(0);
					addEdge(getVertex(x), getVertex(c), gps.nextInt(), gps.nextInt(), gps.nextInt());
				} else {
					break;
				}
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			
		}
	}
	
	public void addVertex(Character symbol, String address) {
		Vertex v = new Vertex(symbol, address);
		hm.put(v, new TreeSet());
		vCheck.put(symbol, v);
	}
	
	public void addEdge(Vertex a, Vertex b, int c, int d, int cops) {
		if (!hm.containsKey(a)) {
			addVertex(a.getSymbol(), a.getAddress());
		}
		
		Edge e = new Edge(b, c, d, cops);
		
		hm.get(a).add(e);
		// if a doesnt exist add it to hashmap
		// add b and c to set<edge> at vertex a in hash map
	}
	
	
	
	public Vertex getVertex(Character symbol) {
		return vCheck.get(symbol); 
	}
}
