package nl.sogyo.javaopdrachten;

public class Edge {
    private Node origin;
    private Node destination;
    private String originName;
    private String destinationName;
    private String answer = new String();

    public Edge(String originName, String destinationName, String answer) {
        this.originName = originName;
        this.destinationName = destinationName;
        this.answer = answer;
    }

    public String getOriginName() {
        return originName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void attachOrigin(Node origin) {
        this.origin = origin;
    }

    public void attachDestination(Node destination) {
        this.destination = destination;
    }

    public void printAndPropegateDown() {
        System.out.println("answer " + answer + " moves to " + destinationName);
        destination.printAndPropegateDown();
    }
}
