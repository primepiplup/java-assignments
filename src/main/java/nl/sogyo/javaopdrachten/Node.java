package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class Node {
    private String name = new String();
    private String question = new String();
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();

    public Node(String name, String question) {
        this.name = name;
        this.question = question;
    }

    public int pathsFrom() {
        return edgeList.size();
    }

    public void addPath(Edge newEdge) {
        edgeList.add(newEdge);
    }
}
