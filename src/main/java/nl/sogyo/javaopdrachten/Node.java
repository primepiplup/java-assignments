package nl.sogyo.javaopdrachten;

import java.util.ArrayList;
import java.util.Scanner;

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
        if(!isEndNode()) {
            System.out.println("Name: " + name + " | Question: " + question);
        } else {
            System.out.println("Name: " + name + " | Result: " + question);
        }
        for(int i = 0; i < edgeListFromHere.size(); i++) {
            edgeListFromHere.get(i).printAndPropegateDown();
        }
    }

    public void traverse(Scanner userInput) {
        if(edgeListFromHere.size() > 0) {
            String response = getResponse(userInput);
            findEdgeAndMoveDown(response, userInput);
        } else {
            System.out.println(question);
        }
    }

    private String getResponse(Scanner userInput) {

        String response = new String();
        do {
            prompt();
            response = userInput.nextLine().strip();
        } while (!isInAnEdge(response));
        return response;
    }

    private Boolean isInAnEdge(String response) {
        if(response.length() < 1) { return false; }
        for(int i = 0; i < edgeListFromHere.size(); i++) {
            if(edgeListFromHere.get(i).getAnswer().equalsIgnoreCase(response)) {
                return true;
            }
        }
        return false;
    }

    private void prompt() {
        System.out.println(question);
        System.out.println("Opties: " + formattedEdgeOptions());
    }

    private void findEdgeAndMoveDown(String response, Scanner userInput) {
        for(int i = 0; i < edgeListFromHere.size(); i++) {
            if(edgeListFromHere.get(i).getAnswer().equalsIgnoreCase(response)) {
                edgeListFromHere.get(i).traverse(userInput);
            }
        }
    }

    private String formattedEdgeOptions() {
        StringBuilder accumulator = new StringBuilder();
        int i = 0;
        do {
            accumulator.append(edgeListFromHere.get(i).getAnswer());
            i++;
        } while (i < edgeListFromHere.size() - 1); {
            accumulator.append(" of ");
            accumulator.append(edgeListFromHere.get(i).getAnswer());
        }
        return accumulator.toString();
    }
}
