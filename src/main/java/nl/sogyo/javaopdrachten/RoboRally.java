package nl.sogyo.javaopdrachten;

public class RoboRally {
    public static void main(String[] args) {
        Robot robotOne = new Robot();
        robotOne.printState();
        robotOne.forward();
        robotOne.turnLeft();
        robotOne.printState();
        robotOne.forward();
        robotOne.printState();
        robotOne.backward();
        robotOne.printState();
    }
}