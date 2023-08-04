package nl.sogyo.javaopdrachten;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private Point position;
    private Direction direction;
    private int defaultMoveDistance = 1;
    private List<RobotAction> actionList;

    public Robot() {
        position = new Point(0, 0);
        direction = Direction.NORTH;
        actionList = new ArrayList<>();
    }

    public Robot(int x, int y, String directionString) {
        position = new Point(x, y);
        direction = Direction.getDirectionForString(directionString);
    }

    public void printState() {
        System.out.print("Robot is facing: ");
        direction.print();
        System.out.print(" and is located at: ");
        position.print();
        System.out.println();
    }

    public void execute() {
        actionList.forEach(RobotAction::execute);
        actionList.clear();
    }

    public void turnLeft() {
        actionList.add(() -> this.executeTurnLeft());
    }

    public void turnRight() {
        actionList.add(() -> this.executeTurnRight());
    }

    public void forward(int distance) {
        actionList.add(() -> this.executeForward(distance));
    }

    public void forward() {
        actionList.add(() -> this.executeForward(defaultMoveDistance));
    }

    public void backward(int distance) {
        actionList.add(() -> this.executeBackward(distance));
    }

    public void backward() {
        actionList.add(() -> this.executeBackward(defaultMoveDistance));
    }

    public void executeTurnLeft() {
        direction = Direction.turnLeft(direction);
    }

    public void executeTurnRight() {
        direction = Direction.turnRight(direction);
    }

    public void executeForward(int distance) {
        position.moveDistanceInDirection(distance, direction);
    }

    public void executeBackward(int distance) {
        position.moveDistanceInDirection(distance, direction.inverse());
    }
}
