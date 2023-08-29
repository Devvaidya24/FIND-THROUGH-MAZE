// FileManager.java file
package maze;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dev
 */
// Class that handles reading file and constructing maze nodes
public class FileManager {

    // Setting file name
    private String fileName;

    // Constructor to set object with specified file name.
    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    // Reads the maze file and constructs an array of maze nodes
    public Node[] readFile() {

        List<Node> maze = new ArrayList<>();
        // List to store maze nodes
        List<String[]> links = new ArrayList<>();
        // List to store node connections

        try ( Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] point = line.split(",");
                // Extract node details from the line

                if (point.length == 5) {
                    // If name is W set it as EXIT
                    String name = point[0].equals("W") ? "EXIT" : point[0];

                    int x = Integer.parseInt(point[1]);
                    int y = Integer.parseInt(point[2]);

                    String next1 = point[3].equals("A") ? null : point[3].equals("W") ? "EXIT" : point[3];
                    String next2 = point[4].equals("A") ? null : point[4].equals("W") ? "EXIT" : point[4];

                    // New object node
                    Node node = new Node(name, x, y);
                    // add node to maze list
                    maze.add(node);
                    // add node connections to links listts
                    links.add(new String[]{name, next1, next2});
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Createing connections betwenn nodes
        for (String[] link : links) {

            // find the current node in maze list
            Node currentNode = findNode(maze, link[0]);
            // find the next node in maze list
            Node next1Node = findNode(maze, link[1]);
            // find the next node in maze list
            Node next2Node = findNode(maze, link[2]);

            // if current node is not equal to null
            if (currentNode != null) {

                // if next node is not equal to null
                if (next1Node != null) {
                    currentNode.addNextNode(next1Node);
                }

                // if next node is not equal to null
                if (next2Node != null) {
                    currentNode.addNextNode(next2Node);
                }
            }
        }
        // Convert the maze list to list array and return
        return maze.toArray(new Node[0]);
    }

    // private find node method to find node of specified in list
    private Node findNode(List<Node> nodeList, String name) {

        for (Node node : nodeList) {

            if (node.getName().equals(name)) {
                // found and return node
                return node;
            }
        }

        // Otherwise return null
        return null;
    }

//    public void writeFile(String fileName, String c)
//    {
//        File f;
//        
//        if(fileName == null)
//            f = new File(this.name);
//        else
//            f = new File(fileName);
//        try
//        {
//            f.createNewFile();
//            FileWriter writer = new FileWriter(f); 
//            writer.write(c);
//            writer.flush();
//            writer.close();
//        }
//        catch(IOException e)
//        {
//            System.out.println("Cannot write to the file"+e.getMessage());
//        }
//    }
}
