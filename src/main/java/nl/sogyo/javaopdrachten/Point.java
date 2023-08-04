package nl.sogyo.javaopdrachten;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.printf("(%d, %d)", x, y);
    }

    public void moveDistanceInDirection(int distance, Direction direction) {
        distance = limitDistance(distance);
        switch(direction) {
            case NORTH:
                moveNorth(distance);
                break;
            case EAST:
                moveEast(distance);
                break;
            case SOUTH:
                moveSouth(distance);
                break;
            case WEST:
                moveWest(distance);
                break;
        }
    }

    public void moveDistanceInDirection(Direction direction) {
        int defaultMoveDistance = 1;
        moveDistanceInDirection(defaultMoveDistance, direction);
    }

    private int limitDistance(int distance) {
        if(distance > 3) {
            distance = 3;
        } else if (distance < 1) {
            distance = 1;
        }
        return distance;
    }

    public void moveEast(int distance) {
        moveOnX(distance);
    }

    public void moveWest(int distance) {
        moveOnX(-distance);
    }

    public void moveNorth(int distance) {
        moveOnY(distance);
    }

    public void moveSouth(int distance) {
        moveOnY(-distance);
    }

    private void moveOnX(int deltaX) {
        x += deltaX;
    }

    private void moveOnY(int deltaY) {
        y += deltaY;
    }
}
