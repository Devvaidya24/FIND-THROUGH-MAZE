// Node.java file
package maze;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dev
 */
// Public node class
public class Node {

    // Initializing node, x and y cooridinates
    private String name;
    private int x, y;
    // Initializing List of nodes
    private List<Node> nextNodes = new ArrayList<>();

    // Default constructor for node object with all cooridinates
    public Node(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    // Get method to return name
    public String getName() {
        return name;
    }

    // Get method to return X
    public int getX() {
        return x;
    }

    // Get method to return y
    public int getY() {
        return y;
    }

    // Retrieves list of nodes
    public List<Node> getNextNodes() {
        return nextNodes;
    }

    // add node to list of next nodes
    public void addNextNode(Node node) {
        nextNodes.add(node);
    }
}
