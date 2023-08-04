package nl.sogyo.javaopdrachten;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public void print() {
        System.out.print(this.toString());
    }

    public static Direction getDirectionForString(String directionString) {
        switch(directionString) {
            case "North":
                return NORTH;

            case "East":
                return EAST;
            
            case "South":
                return SOUTH;
            
            case "West":
                return WEST;
            
            default:
                return NORTH;
        }
    }

    public static Direction turnLeft(Direction currentDirection) {
        switch(currentDirection){
            case NORTH:
                return WEST;

            case EAST:
                return NORTH;

            case SOUTH:
                return EAST;

            case WEST:
                return SOUTH;

            default:
                return NORTH;
        }
    }

    public static Direction turnRight(Direction currentDirection) {
        switch(currentDirection){
            case NORTH:
                return EAST;

            case EAST:
                return SOUTH;

            case SOUTH:
                return WEST;

            case WEST:
                return NORTH;
                
            default:
                return NORTH;
        }
    }
}
