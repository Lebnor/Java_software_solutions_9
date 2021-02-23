package com.company.chapter_12;

/**
 * solves the non-attacking queens problem, put 8 queens on a chess board with no queen threatening another,
 * using recursion.
 * 5 denotes queen
 * 0 denotes available square
 * 1 denotes threatened square
 */
public class PP12_5 {


    private final static int SIZE = 8;
    private final static int[][] maze = new int[SIZE][SIZE];
    private final static int QUEEN = 5;
    private final static int AVAILABLE = 0;
    private final static int THREAT = 1;

    private static int solutionCount = 0;
    private static String[] solutions;


    public static void main(String[] args) {
        solutions = new String[100]; // there are 92 max solutions to this problem

        if ( !putAllQueens() ) {
            System.out.println("Couldn't find a solution");
        }

        System.out.println("Found " + solutionCount + " solutions");

        // print all solutions
        for (int i = 0; i < solutionCount; i++) {
            System.out.println("Solution " + (i + 1) + ":");
            String solution = solutions[i];
            System.out.println(solution);

        }

    }

    public static boolean putAllQueens() {
        return putAllQueens(0);
    }

    /*
     * solves the queen problem
     * - go through each column
     * - attempt to put queen on the first row of that column
     * - recursively try the same on the next column
     * - if recursion failed, backtrack and put queen on the next row of it's column.
     * - if we are at the same column as the size of the board, we put all available queens so return true
     */
    private static boolean putAllQueens(int col) {
        if (col >= SIZE) { // no more queens to place
            solutions[solutionCount++] = mazeToString(); // save the solution as string
            return true;
        }

        for (int i = 0; i < SIZE; i++) { // go through each column
            // go from [i,col] to [i, SIZE - 1]
            if (maze[i][col] == AVAILABLE) { // the first row in the column is available

                putQueen(i, col); // attempt to put queen there

                // recursively try the same steps in next column.
                // if failed we backtrack.
                if ( !putAllQueens(col + 1) ) {
                    removeQueen(i, col);
                }
                removeQueen(i, col); // remove queen so we can put it in the next row on next iteration
            }
        }
        // if we got here then there are no more rows in the column to place queens,
        // so we didn't find a solution
        return false;

    }

    // save the current representation of the maze as a string
    private static String mazeToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                builder.append(maze[i][j]);
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }



    // mark any square that is under attack as threatened
    private static void recalculate() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (maze[i][j] == QUEEN) {
                    markAllDirections(i, j, THREAT);
                }
            }
        }
    }

    // output matrix representation of the maze. unused
    private static void printMaze() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // returns true if [x][y] is a valid maze coordinate and false otherwise
    private static boolean inBound(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    // removes a queen from coordinate [x][y]
    // frees up any square that is no longer threatened by the removed queen
    private static void removeQueen(int x, int y) {
        if (inBound(x, y) && maze[x][y] == QUEEN) {
            markAllDirections(x, y, AVAILABLE);
            maze[x][y] = AVAILABLE;
        }
        recalculate();
    }

    // places a queen on coordinate [x][y].
    // marks all squares that the queen is threatening
    private static void putQueen(int x, int y) {
        markAllDirections(x, y, THREAT);
        maze[x][y] = QUEEN;
    }

    // helper method to recursively visit all squares horizontal, vertical and diagonal from [x][y]
    private static void mark(int x, int y, char direction, int mark) {
        if (!inBound(x, y)) {
            return;
        }
        if (maze[x][y] != QUEEN) {
            maze[x][y] = mark;
        }
        switch (direction) {
            case 'u': //up
                mark(x - 1, y, 'u', mark);
                break;
            case 'l': //left
                mark(x, y - 1, 'l', mark);
                break;
            case 'd': //down
                mark(x + 1, y, 'd', mark);
                break;
            case 'r': //right
                mark(x, y + 1, 'r', mark);
                break;
            case 'q': //top-left
                mark(x - 1, y - 1, 'q', mark);
                break;
            case 'e': //top-right
                mark(x - 1, y + 1, 'e', mark);
                break;
            case 'z': //bottom-left
                mark(x + 1, y - 1, 'z', mark);
                break;
            case 'c': //bottom-right
                mark(x + 1, y + 1, 'c', mark);
                break;
        }
    }

    // mark all horizontal, vertical and diagonal squares from [x][y]
    private static void markAllDirections(int x, int y, int mark) {
        if (inBound(x, y)) {
            mark(x - 1, y, 'u', mark);
            mark(x, y - 1, 'l', mark);
            mark(x + 1, y, 'd', mark);
            mark(x, y + 1, 'r', mark);
            mark(x - 1, y - 1, 'q', mark);
            mark(x - 1, y + 1, 'e', mark);
            mark(x + 1, y - 1, 'z', mark);
            mark(x + 1, y + 1, 'c', mark);

        }
    }
}
