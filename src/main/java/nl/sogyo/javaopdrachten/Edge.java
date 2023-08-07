package nl.sogyo.javaopdrachten;

public class Edge {
    private Node origin;
    private Node destination;
    private String answer = new String();

    public Edge(Node origin, Node destination, String answer) {
        this.origin = origin;
        this.destination = destination;
        this.answer = answer;
    }
}
