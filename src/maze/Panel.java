// Panel.java file
package maze;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Dev
 */
// Public panel class which represents panel in maze program that displays maze nodes and the connection
public class Panel extends JPanel {

    // Size of each cell
    private int cells = 50;
    // Array of maze nodes
    private Node[] mazeNodes;

    // COnstructor for panel with maze nodes
    public Panel(Node[] mazeNodes) {
        this.mazeNodes = mazeNodes;
    }

    // Sets the nodes to display in panel
    public void setMazeNodes(Node[] mazeNodes) {
        this.mazeNodes = mazeNodes;
    }

    // paint component method
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (mazeNodes == null) {
            return;
        }

        // Set the color for nodes
        g.setColor(Color.GREEN);
        // sett the font size for node labels
        g.setFont(g.getFont().deriveFont(12.0f));

        for (Node node : mazeNodes) {
            // Draw the current node
            drawNode(g, node);
            // Draw from current node to neighbor node
            drawLines(g, node);
        }
    }

    // Draw node method to draw node on panel
    private void drawNode(Graphics g, Node node) {
        // Calculate x of node center
        int x = node.getX() * cells + cells / 2;
        // Calculate y of node center
        int y = node.getY() * cells + cells / 2;

        // Draw filled circle to rep node
        g.fillOval(x - 5, y - 5, 10, 10);
        // Draw the label of node
        g.drawString(node.getName(), x - 10, y - 10);
    }

    // Draws lines connection to node
    private void drawLines(Graphics g, Node node) {
        // Calculate the x of the starting point of the line
        int x1 = node.getX() * cells + cells / 2;
        // Calculate the y of starting point of line
        int y1 = node.getY() * cells + cells / 2;

        // Setting the color for drawing black
        g.setColor(Color.BLACK);

        for (Node nextNode : node.getNextNodes()) {
            // Calculate the x of ending point of line
            int x2 = nextNode.getX() * cells + cells / 2;
            // Calculate the x of ending point of line
            int y2 = nextNode.getY() * cells + cells / 2;
            // Draw a line connection the current node to its neighbor node
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
