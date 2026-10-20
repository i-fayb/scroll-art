import java.util.Random;

public class ScrollArtV1 {
    static final int WIDTH = getTerminalWidth() - 1;
    static final int ICE_CREAM_WIDTH = 10;
    static final int ICE_CREAM_HEIGHT = 9;
    static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int iterations = 0;
        char[][] nextRows = new char[ICE_CREAM_HEIGHT][WIDTH]; // store upcoming rows
        for (int i = 0; i < nextRows.length; i++) {
            nextRows[i] = emptyRow();
        }

        for (int y = 0; y < ICE_CREAM_HEIGHT; y++) {
            for (int x = 0; x < ICE_CREAM_WIDTH; x++) {
                System.out.print(getIceCream()[y][x]);
                
            }
            System.out.println();
        }

        // while (true) {
        //     // At each column on the top row, 1% chance to add a new image
        //     // for (int x = 0; x < WIDTH - ICE_CREAM_WIDTH; x++) {
        //         if (rand.nextDouble() < 0.01) {
        //             loadNextRowsWithImage(nextRows, 0);
        //         }
        //     // }
        //     // Print and remove the top row
        //     System.out.println(new String(nextRows[0]));
        //     // Shift all rows up
        //     shiftRowsUp(nextRows);
        //     Thread.sleep(40); // Delay in ms
        //     long time = System.currentTimeMillis() - startTime;
        //     iterations++;
        //     //System.err.println("average time per frame: " + (time / iterations) + " ms");
        // }
    }

    private static void loadNextRowsWithImage(char[][] nextRows, int x) {
        char[][] img;
        if (rand.nextBoolean()) {
            img = getIceCream();
        } else {
            img = getCarrot();
        }
        for (int iy = 0; iy < ICE_CREAM_HEIGHT; iy++) {
            for (int ix = 0; ix < ICE_CREAM_WIDTH; ix++) {
                nextRows[iy][x + ix] = img[iy][ix];
            }
        }
    }

    static void shiftRowsUp(char[][] nextRows) {
        for (int i = 1; i < nextRows.length; i++) {
            nextRows[i - 1] = nextRows[i];
        }
        nextRows[nextRows.length - 1] = emptyRow();
    }

    static char[] emptyRow() {
        char[] row = new char[WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            row[i] = ' ';
        }
        return row;
    }

    // rename your function here
    static char[][] getIceCream() {
        char[][] img = new char[ICE_CREAM_HEIGHT][ICE_CREAM_WIDTH];
        // fill with empty space
        for (int y = 0; y < ICE_CREAM_HEIGHT; y++) {
            for (int x = 0; x < ICE_CREAM_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters for ICE CREAM
        img[0][0] = ' ';
        img[0][1] = ' ';
        img[0][2] = ' ';
        img[0][3] = ' ';
        img[0][4] = '~';
        img[0][5] = '~';
        img[0][6] = ' ';
        img[0][7] = ' ';
        img[0][8] = ' ';
        img[0][9] = ' ';

        img[1][0] = ' ';
        img[1][1] = ' ';
        img[1][2] = ' ';
        img[1][3] = '(';
        img[1][4] = '(';
        img[1][5] = ')';
        img[1][6] = ')';
        img[1][7] = ' ';
        img[1][8] = ' ';
        img[1][9] = ' ';

        img[2][0] = ' ';
        img[2][1] = ' ';
        img[2][2] = '(';
        img[2][3] = '(';
        img[2][4] = '(';
        img[2][5] = ')';
        img[2][6] = ')';
        img[2][7] = ')';
        img[2][8] = ' ';
        img[2][9] = ' ';

        img[3][0] = ' ';
        img[3][1] = '(';
        img[3][2] = '(';
        img[3][3] = '(';
        img[3][4] = '(';
        img[3][5] = ')';
        img[3][6] = ')';
        img[3][7] = ')';
        img[3][8] = ')';
        img[3][9] = ' ';

        img[4][0] = '(';
        img[4][1] = '(';
        img[4][2] = '(';
        img[4][3] = '(';
        img[4][4] = '(';
        img[4][5] = ')';
        img[4][6] = ')';
        img[4][7] = ')';
        img[4][8] = ')';
        img[4][9] = ')';

        img[5][0] = ' ';
        img[5][1] = '\\';
        img[5][2] = '|';
        img[5][3] = '|';
        img[5][4] = '|';
        img[5][5] = '|';
        img[5][6] = '|';
        img[5][7] = '|';
        img[5][8] = '/';
        img[5][9] = ' ';

        img[6][0] = ' ';
        img[6][1] = ' ';
        img[6][2] = '\\';
        img[6][3] = '|';
        img[6][4] = '|';
        img[6][5] = '|';
        img[6][6] = '|';
        img[6][7] = '/';
        img[6][8] = ' ';
        img[6][9] = ' ';

        img[7][0] = ' ';
        img[7][1] = ' ';
        img[7][2] = ' ';
        img[7][3] = '\\';
        img[7][4] = '|';
        img[7][5] = '|';
        img[7][6] = '/';
        img[7][7] = ' ';
        img[7][8] = ' ';
        img[7][9] = ' ';

        img[8][0] = ' ';
        img[8][1] = ' ';
        img[8][2] = ' ';
        img[8][3] = ' ';
        img[8][4] = '\\';
        img[8][5] = '/';
        img[8][6] = ' ';
        img[8][7] = ' ';
        img[8][8] = ' ';
        img[8][9] = ' ';

        return img;
    }

    static char[][] getCarrot() {
        char[][] img = new char[ICE_CREAM_HEIGHT][ICE_CREAM_WIDTH];
        // fill with empty space
        for (int y = 0; y < ICE_CREAM_HEIGHT; y++) {
            for (int x = 0; x < ICE_CREAM_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][5] = '\\';
        img[0][6] = ')';
        img[0][7] = '/';
        img[1][4] = '-';
        img[1][5] = '-';
        img[1][6] = 'v';

        img[2][3] = '/';
        img[2][4] = 'r';
        img[2][6] = ')';

        img[3][2] = '>';
        img[3][3] = 'r';
        img[3][4] = '.';
        img[3][5] = '/';

        img[4][1] = '/';
        img[4][3] = '\'';

        img[5][0] = 'c';
        img[5][1] = '_';
        img[5][2] = '/';

        return img;
    }

    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80; // fallback for unknown OS
        }
    }

    private static int getUnixTerminalWidth() {
        try {
            // Try to get terminal size from environment variables first
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            // Fallback to stty command
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]); // columns
            }
        } catch (Exception ignored) {
            // Silently ignore errors and fall back to default
        }
        return 80; // fallback
    }

}
