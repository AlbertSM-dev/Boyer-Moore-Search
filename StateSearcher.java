public class StateSearcher {
    // The size of the character set (e.g., 256 for ASCII)
    private static final int NUM_CHARS = 256;

    //Preprocesses the pattern to create the "bad character" table
    private static void badCharHeuristic(char[] pattern, int size, int[] badChar) {
        // 1. Initialize all character occurrences as -1
        for (int i = 0; i < NUM_CHARS; i++) {
            badChar[i] = -1;
        }

        // 2. Fill the array with the last index of each character in the pattern
        for (int i = 0; i < size; i++) {
            badChar[(int) pattern[i]] = i;
        }
    }

    // It is case sensitive
    public static void search(String pattern, String TEXT) {
        int m = pattern.length();
        int n = TEXT.length();

        if (m == 0) {
            System.out.println("Search pattern cannot be empty.");
            return;
        }
        if (m > n) {
            System.out.println("Pattern is longer than the text. No match possible.");
            return;
        }

        int[] badChar = new int[NUM_CHARS];
        char[] patternChars = pattern.toCharArray();
        char[] textChars = TEXT.toCharArray();

        badCharHeuristic(patternChars, m, badChar);

        int s = 0; 
        boolean found = false;

        while (s <= (n - m)) {
            int j = m - 1;

            // Compare the pattern with the text from right to left
            while (j >= 0 && patternChars[j] == textChars[s + j]) {
                j--;
            }

            // If j < 0, the pattern was found
            if (j < 0) {
                System.out.println("Pattern found at index: " + s);
                found = true;

                // Shift the pattern to find the next possible occurrence
                int nextShift = (s + m < n) ? m - badChar[textChars[s + m]] : 1;
                s += nextShift;

            } else {
                // Calculate the new shift using the bad character rule.
                int shift = Math.max(1, j - badChar[textChars[s + j]]);
                s += shift;
            }
        }
        
        if (!found) {
            System.out.println("Pattern not found.");
        }
    }
}
