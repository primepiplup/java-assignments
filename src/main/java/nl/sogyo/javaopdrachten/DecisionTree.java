package nl.sogyo.javaopdrachten;

public class DecisionTree {
    public static void main(String[] args) {
        Tree tree = new Tree("/home/daan/Projects/java-opdrachten-daan/src/main/java/nl/sogyo/javaopdrachten/decision-tree-data.txt");
        tree.traverse();
    }
}
