import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BikeSimulator {
    public static void main(String[] args) {
           // Create a 7x7 grid
        Grid grid = new Grid(7, 7); // 7x7 grid
        // Create a new Bike instance
        Bike bike = new Bike();

        BufferedReader reader = null;

        try {
            if (args.length > 0) {
                // If a filename is provided as an argument, read commands from the file
                reader = new BufferedReader(new FileReader(args[0]));
            } else {
                // Otherwise, read commands from standard input
                System.out.println("Enter commands (one per line). Type 'END' or press Ctrl+D to finish.");
                reader = new BufferedReader(new InputStreamReader(System.in));
            }

            String line;
            // Read and process each line/command
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("END")) {
                    break; // For STDIN input termination
                }
                processCommand(line.trim(), bike, grid);
            }
        } catch (IOException e) {
            // Handle input/output errors
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                }
            }
        }

       
    }

    private static void processCommand(String commandLine, Bike bike, Grid grid) {
              String[] parts = commandLine.split(" ");
        String command = parts[0].toUpperCase();

        if (command.equals("PLACE")) {
            if (parts.length == 2) {
                try {
                    // Parse PLACE command arguments: x,y,FACING
                    String[] args = parts[1].split(",");
                    if (args.length == 3) {
                        int x = Integer.parseInt(args[0]);
                        int y = Integer.parseInt(args[1]);
                        Direction facing = Direction.valueOf(args[2].toUpperCase());
                        bike.place(x, y, facing, grid); // bike.place handles validation
                    }
                } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                    // Invalid PLACE command format or direction, ignore
                    // System.err.println("Invalid PLACE command: " + commandLine); // For debugging
                }
            }
        } else if (bike.isPlaced()) { // Only process other commands if the bike has been placed
            switch (command) {
                case "FORWARD":
                    bike.forward(grid);
                    break;
                case "TURN_LEFT":
                    bike.turnLeft();
                    break;
                case "TURN_RIGHT":
                    bike.turnRight();
                    break;
                case "GPS_REPORT":
                    System.out.println(bike.gpsReport());
                    break;
                default:
                    // Ignore unknown commands
                    // System.err.println("Unknown command: " + commandLine); // For debugging
                    break;
            }
        }
    }
}
