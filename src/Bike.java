public class Bike {
    private int x;
    private int y;
    private Direction facing;
    private boolean isPlaced;

    public Bike() {
        this.isPlaced = false;
    }

 /**
     * Attempts to place the bike on the grid.
     * @param x The X-coordinate for placement.
     * @param y The Y-coordinate for placement.
     * @param facing The direction the bike will face.
     * @param grid The grid object to validate position against.
     * @return true if placement was successful, false otherwise.
     */   
 public boolean place(int x, int y, Direction facing, Grid grid) 
 {
 if (grid.isValidPosition(x, y)) {
            this.x = x;
            this.y = y;
            this.facing = facing;
            this.isPlaced = true;
            return true;
        }
        return false;
}

public void forward(Grid grid) {
        if (!isPlaced) {
            return;
        }
 int newX = x;
        int newY = y;

        switch (facing) {
            case NORTH: newY++; break;
            case EAST: newX++; break;
            case SOUTH: newY--; break;
            case WEST: newX--; break;
        }

        if (grid.isValidPosition(newX, newY)) {
            this.x = newX;
            this.y = newY;
        }
    }

public void turnLeft() {
        if (!isPlaced) {
            return;
        }
        this.facing = this.facing.turnLeft();
    }

   public void turnRight() {
        if (!isPlaced) {
            return;
        }
        this.facing = this.facing.turnRight();
    }

    public String gpsReport() {
  if (isPlaced) {
            return String.format("(%d,%d), %s", x, y, facing.name());
        }
        return "Bike not placed."; // Or throw an exception, or return null/empty string
    }
public boolean isPlaced() {
        return isPlaced;
    }

}
