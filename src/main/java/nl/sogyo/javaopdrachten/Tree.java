package nl.sogyo.javaopdrachten;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tree {
    private Node startNode;

    public Tree(String filename) {
           try {
            File inputFile = new File(filename);
            Scanner inputFileScanner = new Scanner(inputFile);
            buildTree(inputFileScanner);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void buildTree(Scanner treeScanner) {
        //TODO
    }
}
