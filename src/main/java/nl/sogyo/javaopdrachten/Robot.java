package nl.sogyo.javaopdrachten;

public class Robot {
    private Point position;
    private Direction direction;

    public Robot() {
        position = new Point(0, 0);
        direction = Direction.NORTH;
    }

    public Robot(int x, int y, String directionString) {
        position = new Point(x, y);
        direction = Direction.getDirectionForString(directionString);
    }

    public void turnLeft() {
        direction = Direction.turnLeft(direction);
    }

    public void turnRight() {
        direction = Direction.turnRight(direction);
    }

    public void printState() {
        System.out.print("Robot is facing: ");
        direction.print();
        System.out.print(" and is located at: ");
        position.print();
        System.out.println();
    }
}
