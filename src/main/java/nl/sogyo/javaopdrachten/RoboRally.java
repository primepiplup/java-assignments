package nl.sogyo.javaopdrachten;

public class RoboRally {
    public static void main(String[] args) {
        Robot robotOne = new Robot();
        robotOne.printState();
        robotOne.turnLeft();
        robotOne.printState();
    }
}