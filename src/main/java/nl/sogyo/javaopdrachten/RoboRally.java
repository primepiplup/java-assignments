package nl.sogyo.javaopdrachten;

public class RoboRally {
    public static void main(String[] args) {
        Robot robotOne = new Robot();
        robotOne.printState();
        robotOne.forward();
        robotOne.turnLeft();
        robotOne.execute();
        robotOne.printState();
        robotOne.forward();
        robotOne.execute();
        robotOne.printState();
        robotOne.backward();
        robotOne.execute();
        robotOne.printState();
        robotOne.forward(8);
        robotOne.execute();
        robotOne.printState();
        robotOne.turnRight();
        robotOne.turnRight();
        robotOne.turnRight();
        robotOne.turnLeft();
        robotOne.execute();
        robotOne.printState();
    }
}