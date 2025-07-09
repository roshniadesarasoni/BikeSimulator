# Bike Simulator

A simple Java console application that simulates a bike moving on a 7x7 grid. The bike can be placed, moved forward, turned left or right, and report its current position and direction.

## Features
- Place the bike at a specific location and direction on the grid
- Move the bike forward
- Turn the bike left or right
- Report the bike's current position and direction
- Read commands from a file or standard input

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Compilation

Navigate to the `src` directory and compile the Java files:

```sh
javac *.java
```

### Running the Simulator

#### 1. Interactive Mode (Standard Input)
Run the simulator without arguments to enter commands manually:

```sh
java BikeSimulator
```

You will be prompted to enter commands. Type `END` to finish input.

#### 2. File Input Mode
Prepare a text file (e.g., `commands.txt`) with one command per line. Then run:

```sh
java BikeSimulator commands.txt
```

## Supported Commands
- `PLACE X,Y,FACING` — Place the bike at position (X, Y) facing NORTH, SOUTH, EAST, or WEST
- `FORWARD` — Move the bike one unit forward in the direction it is currently facing
- `TURN_LEFT` — Turn the bike 90 degrees to the left
- `TURN_RIGHT` — Turn the bike 90 degrees to the right
- `GPS_REPORT` — Output the bike's current position and direction
- `END` — (Only in interactive mode) End input

### Example Command Sequence
```
PLACE 0,0,NORTH
FORWARD
TURN_RIGHT
FORWARD
GPS_REPORT
```

## Project Structure
- `src/` — Java source files
- `bin/` — Compiled class files
- `lib/` — (Optional) External libraries

## Notes
- The bike must be placed on the grid before other commands are accepted.
- Invalid commands or moves that would take the bike off the grid are ignored.

## License
This project is for educational purposes.
