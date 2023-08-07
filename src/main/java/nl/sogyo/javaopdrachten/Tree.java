package nl.sogyo.javaopdrachten;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tree {
    private Node startNode;
    private ArrayList<Node> nodeList = new ArrayList<Node>();
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();

    public Tree(String filename) {
           try {
            File inputFile = new File(filename);
            Scanner inputFileScanner = new Scanner(inputFile);
            buildTree(inputFileScanner);
            inputFileScanner.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void buildTree(Scanner treeScanner) {
        buildTreeDescription(treeScanner);
        buildTreeFromDescription();
    }

    public void printTree() {
        startNode.printAndPropegateDown();
    }

    public void traverse() {
        Scanner userInput = new Scanner(System.in);
        startNode.traverse(userInput);
        userInput.close();
    }

    private void buildTreeFromDescription() {
        assignNodesToEdges();
        findStartNode();
    }

    private void assignNodesToEdges() {
        for(int i = 0; i < edgeList.size(); i++) {
            for(int j = 0; j < nodeList.size(); j++) {
                attachNodeIfOnEdge(nodeList.get(j), edgeList.get(i));
            }
        }
    }

    private void attachNodeIfOnEdge(Node node, Edge edge) {
        if(node.getName().equals(edge.getOriginName())) {
            edge.attachOrigin(node);
            node.addPathFromHere(edge);
        } else if (node.getName().equals(edge.getDestinationName())) {
            edge.attachDestination(node);
            node.addPathToHere(edge);
        }
    }

    private void findStartNode() {
        for(int i = 0; i < nodeList.size(); i++) {
            if(nodeList.get(i).isStartNode()) {
                this.startNode = nodeList.get(i);
            }
        }
    }

    private void buildTreeDescription(Scanner treeScanner) {
        while(treeScanner.hasNextLine()) {
            parseLine(treeScanner.nextLine());
        }
    }

    private void parseLine(String line) {
        String[] splitLine = line.split(",");
        splitLine = removeSurroundingWhitespace(splitLine);
        if(splitLine.length == 2) {
            createNode(splitLine);
        } else if(splitLine.length == 3) {
            createEdge(splitLine);
        } else {
            //Maybe write an exception for this like "Wrong file format"
        }
    }

    private String[] removeSurroundingWhitespace(String[] splitLine) {
        String[] strippedSplitLine = new String[splitLine.length];
        for(int i = 0; i < splitLine.length; i++) {
            strippedSplitLine[i] = splitLine[i].strip();
        }
        return strippedSplitLine;
    }

    private void createNode(String[] splitLine) {
        Node newNode = new Node(splitLine[0], splitLine[1]);
        nodeList.add(newNode);
    }

    private void createEdge(String[] splitLine) {
        Edge newEdge = new Edge(splitLine[0], splitLine[1], splitLine[2]);
        edgeList.add(newEdge);
    }
}
