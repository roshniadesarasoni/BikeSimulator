// Represents a 2D grid for the bike simulator
public class Grid {
    // Width of the grid
    private final int width;
    // Height of the grid
    private final int height;

    // Constructor to initialize grid dimensions
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Checks if the given (x, y) position is within the grid boundaries
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
