public enum Direction {
    NORTH, EAST, SOUTH, WEST;
    
// Method to get the direction after turning left
    public Direction turnLeft() {
        switch (this) {
            case NORTH: return WEST;
            case EAST: return NORTH;
            case SOUTH: return EAST;
            case WEST: return SOUTH;
            default: return null; // Should not happen in a well-defined enum
        }
    }

// Method to get the direction after turning right
    public Direction turnRight() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return null; // Should not happen in a well-defined enum
        }
    }

}
