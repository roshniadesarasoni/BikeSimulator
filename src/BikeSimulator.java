import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BikeSimulator {
    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);
        Bike bike = new Bike();

        // Simulate placing the bike
        bike.place(1, 2, Direction.NORTH, grid);
        System.out.println(bike.gpsReport());

        // Simulate moving the bike forward
        bike.forward(grid);
        System.out.println(bike.gpsReport());

        // Simulate turning the bike
        bike.turnLeft();
        bike.forward(grid);
        System.out.println(bike.gpsReport());

       
    }

    private static void processCommand(String command, Bike bike, Grid grid) {
        switch (command.toUpperCase()) {
            case "FORWARD":
                bike.forward(grid);
                break;
            case "LEFT":
                bike.turnLeft();
                break;
            case "RIGHT":
                bike.turnRight();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
