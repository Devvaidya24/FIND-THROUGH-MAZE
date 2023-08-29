// Maze.java file
package maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Dev
 */
public class Maze {

    public static Panel panel;
    public static Node[] mazeNodes;
    public static JTextArea pathTextArea;

    public static void main(String[] args) {

        // creating main jframe
        JFrame frame = new JFrame("Maze Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the maze panel
        panel = new Panel(null);
        frame.add(panel, BorderLayout.CENTER);

        // Create the button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // create button for maze 1 and 2 for the files selection
        JButton maze1 = new JButton("Maze 1");
        JButton maze2 = new JButton("Maze 2");

        // creating button panel
        buttonPanel.add(maze1);
        buttonPanel.add(maze2);

        frame.add(buttonPanel, BorderLayout.NORTH);

        // Create the path text area
        pathTextArea = new JTextArea();
        pathTextArea.setEditable(false);

        // creating scroll pane for path text area
        JScrollPane scrollPane = new JScrollPane(pathTextArea);
        frame.add(scrollPane, BorderLayout.SOUTH);

        panel.setMazeNodes(null);

        // Action listener for maze 1 button
        maze1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                pathTextArea.setText("");
                panel.repaint();

                // Load Maze1.txt and populate the maze nodes
                FileManager fileManager = new FileManager("Maze1.txt");
                mazeNodes = fileManager.readFile();

                panel.setMazeNodes(mazeNodes);
                panel.repaint();
            }
        });

        // ActionListener for maze 2 button
        maze2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                pathTextArea.setText("");
                panel.repaint();

                // Load Maze2.txt and populate the maze nodes
                FileManager fileManager = new FileManager("Maze2.txt");
                mazeNodes = fileManager.readFile();

                panel.setMazeNodes(mazeNodes);
                panel.repaint();
            }
        });

        // Create the exit button
        JButton exitButton = new JButton("Exit");
        // Action listener for exit button
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create a panel for the exit button and center it at the bottom
        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        exitPanel.add(exitButton);
        frame.add(exitPanel, BorderLayout.SOUTH);

        // setting frame size 
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
