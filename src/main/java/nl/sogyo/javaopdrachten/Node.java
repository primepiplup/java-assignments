package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class Node {
    private String name = new String();
    private String question = new String();
    private ArrayList<Edge> edgeListFromHere = new ArrayList<Edge>();
    private ArrayList<Edge> edgeListToHere = new ArrayList<Edge>();

    public Node(String name, String question) {
        this.name = name;
        this.question = question;
    }

    public Boolean isEndNode() {
        return (numberOfPathsFrom() <= 0);
    }

    public Boolean isStartNode() {
        return (numberOfPathsTo() <= 0);
    }

    public String getName() {
        return name;
    }

    private int numberOfPathsFrom() {
        return edgeListFromHere.size();
    }

    private int numberOfPathsTo() {
        return edgeListToHere.size();
    }

    public void addPathFromHere(Edge newEdge) {
        edgeListFromHere.add(newEdge);
    }

    public void addPathToHere(Edge newEdge) {
        edgeListToHere.add(newEdge);
    }

    public void printAndPropegateDown() {
        System.out.println("Name: " + name + " | Question: " + question);
        for(int i = 0; i < edgeListFromHere.size(); i++) {
            edgeListFromHere.get(i).printAndPropegateDown();
        }
    }
}
