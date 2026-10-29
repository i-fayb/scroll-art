import java.util.Random;

public class ScrollArtWithClasses {
    static final int WIDTH = getTerminalWidth() - 1;
    static final int ALL_WIDTH = 11;
    static final int ALL_HEIGHT = 10;
    static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int iterations = 0;
        char[][] nextRows = new char[34][WIDTH]; // store upcoming rows
        for (int i = 0; i < nextRows.length; i++) {
            nextRows[i] = emptyRow();
        }

        char[] prevRow = nextRows[0];
        while (true) {
            // At each column on the top row, 1% chance to add a new image
            for (int x = 0; x < WIDTH - 34; x += 34) {
                if (isBlank(prevRow, x) && rand.nextDouble() < 0.08) {
                    loadNextRowsWithImage(nextRows, x);
                }
            }
            // Print and remove the top row
            System.out.println(new String(nextRows[0]));
            prevRow = nextRows[0];
            // Shift all rows up
            shiftRowsUp(nextRows);
            Thread.sleep(100); // Delay in ms
            long time = System.currentTimeMillis() - startTime;
            iterations++;
            // System.err.println("average time per frame: " + (time / iterations) + " ms");
        }
    }

    private static boolean isBlank(char[] prevRow, int x) {
        for (int i = x; i < x + 34; i++) {
            if (prevRow[i] != ' ') {
                return false;
            }
        }
        return true;
    }

    private static void loadNextRowsWithImage(char[][] nextRows, int x) {
        // char[][][] images;

       
        String llama = """
                /^---^\\
                | . . |
                \\  `  /   MS
                /=====\\________
                /               \\[]
                \\               /
                ---------------
                | || |   | || |
                [|][|]   [|][|]
                """;
        AsciiArt l = new AsciiArt(llama);
        AsciiArt[] images = { new AsciiArt(getFish()), new AsciiArt(getTurtle()), new AsciiArt(getIceCream()), new AsciiArt(getPumpkin()), l };

        AsciiArt art = images[rand.nextInt(images.length)];
        AsciiArt widestArt = AsciiArt.getWidestArt(images);
        art.resize(widestArt.width);

        for (int iy = 0; iy < art.height; iy++) { // height
            for (int ix = 0; ix < art.width; ix++) { // width
                nextRows[iy][x + ix] = art.img[iy][ix];
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
    static char[][] getFish() {
        char[][] img = new char[ALL_HEIGHT][ALL_WIDTH];
        // fill with empty space
        for (int y = 0; y < ALL_HEIGHT; y++) {
            for (int x = 0; x < ALL_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][2] = 'O';
        img[1][3] = 'O';
        img[2][2] = '/';
        img[2][3] = '\\';
        img[2][4] = '/';
        img[2][5] = '\\';
        img[3][1] = '/';
        img[3][3] = '@';
        img[3][6] = '\\';
        img[4][1] = '\\';
        img[4][6] = '/';
        img[5][2] = '\\';
        img[5][5] = '/';
        img[6][5] = '\\';
        img[6][2] = '/';
        img[7][1] = '/';
        img[7][6] = '\\';
        img[8][1] = '-';
        img[8][2] = '-';
        img[8][3] = '-';
        img[8][4] = '-';
        img[8][5] = '-';
        img[8][6] = '-';

        return img;
    }
      
     static char[][] getTurtle() {
        char[][] img = new char[ALL_HEIGHT][ALL_WIDTH];
        // fill with empty space
        for (int y = 0; y < ALL_HEIGHT; y++) {
            for (int x = 0; x < ALL_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][4] = '_';
        img[0][5] = '_';
        img[0][6] = '_';
        img[1][3] = '/';
        img[1][4] = '@';
        img[1][6] = '@';
        img[1][7] = '\\';

        img[2][3] = '\\';
        img[2][7] = '/';
        img[3][1] = '_';
        img[3][2] = '_';
        img[3][3] = '/';
        img[3][4] = '/';
        img[3][5] = '|';
        img[3][6] = '\\';
        img[3][7] = '\\';
        img[3][8] = '_';

        img[4][0] = '/';
        img[4][2] = '/';
        img[4][3] = '\\';
        img[4][4] = '\\';
        img[4][5] = '|';
        img[4][6] = '/';
        img[4][7] = '/';
        img[4][8] = '\\';
        img[4][10] = '\\';

        img[5][0] = '\\';
        img[5][1] = '/';
        img[5][2] = '\\';
        img[5][3] = '/';
        img[5][4] = '/';
        img[5][5] = '|';
        img[5][6] = '\\';
        img[5][7] = '\\';
        img[5][8] = '/';
        img[5][9] = '\\';
        img[5][10] = '/';

        img[6][3] = '\\';
        img[6][4] = '\\';
        img[6][5] = '|';
        img[6][6] = '/';
        img[6][7] = '/';

        img[7][4] = '/';
        img[7][5] = '/';
        img[7][6] = '\\';
        img[7][7] = '\\';
        img[8][4] = '-';
        img[8][7] = '-';



        return img;
    }

 static char[][] getIceCream() {
        char[][] img = new char[ALL_HEIGHT][ALL_WIDTH];
        // fill with empty space
        for (int y = 0; y < ALL_HEIGHT; y++) {
            for (int x = 0; x < ALL_WIDTH; x++) {
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
        img[8][7] = 'I';
        img[8][8] = 'F';
        img[8][9] = ' ';

        return img;
    }

    static char[][] getPumpkin() {
        char[][] img = new char[ALL_HEIGHT][ALL_WIDTH];
        // fill with empty space
        for (int y = 0; y < ALL_HEIGHT; y++) {
            for (int x = 0; x < ALL_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters for PUMPKIN
        img[0][1] = ' ';
        img[0][2] = ' ';
        img[0][3] = ' ';
        img[0][4] = ' ';
        img[0][5] = '/';
        img[0][6] = '\\';
        img[0][7] = ' ';
        img[0][8] = ' ';
        img[0][9] = ' ';
        img[0][10] = ' ';

        img[1][0] = ' ';
        img[1][1] = ' ';
        img[1][2] = ' ';
        img[1][3] = ' ';
        img[1][4] = ' ';
        img[1][5] = '|';
        img[1][6] = '|';
        img[1][7] = ' ';
        img[1][8] = ' ';
        img[1][9] = ' ';
        img[1][10] = ' ';

        img[2][0] = ' ';
        img[2][1] = ' ';
        img[2][2] = ' ';
        img[2][3] = '*';
        img[2][4] = '*';
        img[2][5] = '*';
        img[2][6] = '*';
        img[2][7] = '*';
        img[2][8] = ' ';
        img[2][9] = ' ';
        img[2][10] = ' ';

        img[3][0] = ' ';
        img[3][1] = ' ';
        img[3][2] = '*';
        img[3][3] = ' ';
        img[3][4] = ' ';
        img[3][5] = ' ';
        img[3][6] = ' ';
        img[3][7] = ' ';
        img[3][8] = '*';
        img[3][9] = ' ';
        img[3][10] = ' ';

        img[4][0] = ' ';
        img[4][1] = '*';
        img[4][2] = '(';
        img[4][3] = '#';
        img[4][4] = ')';
        img[4][5] = ' ';
        img[4][6] = '(';
        img[4][7] = '#';
        img[4][8] = ')';
        img[4][9] = '*';
        img[4][10] = ' ';

        img[5][0] = '*';
        img[5][1] = ' ';
        img[5][2] = ' ';
        img[5][3] = ' ';
        img[5][4] = ' ';
        img[5][5] = ' ';
        img[5][6] = ' ';
        img[5][7] = ' ';
        img[5][8] = ' ';
        img[5][9] = ' ';
        img[5][10] = '*';

        img[6][0] = '*';
        img[6][1] = ' ';
        img[6][2] = ' ';
        img[6][3] = ' ';
        img[6][4] = ' ';
        img[6][5] = 'L';
        img[6][6] = ' ';
        img[6][7] = ' ';
        img[6][8] = ' ';
        img[6][9] = ' ';
        img[6][10] = '*';

        img[7][0] = ' ';
        img[7][1] = '*';
        img[7][2] = ' ';
        img[7][3] = '/';
        img[7][4] = '-';
        img[7][5] = '-';
        img[7][6] = '-';
        img[7][7] = '\\';
        img[7][8] = ' ';
        img[7][9] = '*';
        img[7][10] = ' ';

        img[8][0] = ' ';
        img[8][1] = ' ';
        img[8][2] = '*';
        img[8][3] = ' ';
        img[8][4] = '\\';
        img[8][5] = '-';
        img[8][6] = '/';
        img[8][7] = ' ';
        img[8][8] = '*';
        img[8][9] = ' ';
        img[8][10] = ' ';

        img[9][0] = ' ';
        img[9][1] = ' ';
        img[9][2] = ' ';
        img[9][3] = '*';
        img[9][4] = '*';
        img[9][5] = '*';
        img[9][6] = '*';
        img[9][7] = '*';
        img[9][8] = ' ';
        img[9][9] = 'I';
        img[9][10] = 'F';


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