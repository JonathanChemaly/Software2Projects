import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Counts the number of times a word is in a input file and outputs them an
 * alphabetical table in an HTML file.
 *
 * @author Jonathan Chemaly
 */
public final class WordCounter {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private WordCounter() {
    }

    /**
     * Goes through the input file and counts the words while also creating a
     * list of all the words.
     *
     * @param in
     *            the input text file
     * @param wordCounts
     *            map with each word and the total number of occurrences
     * @updates wordCounts
     * @return queue of all the words
     */
    private static Queue<String> readInput(Map<String, Integer> wordCounts,
            SimpleReader in) {

        int placeHolder = 0;
        Queue<String> allWords = new Queue1L<>();

        Set<Character> specialChars = new Set1L<>();
        specialChars.add(' ');
        specialChars.add('.');
        specialChars.add(',');
        specialChars.add('-');

        while (!in.atEOS()) {

            String line = in.nextLine();
            placeHolder = 0;

            while (placeHolder < line.length()) {
                String tempWord = nextWordOrSeparator(line, placeHolder,
                        specialChars);

                if (!specialChars.contains(tempWord.charAt(0))) {

                    if (wordCounts.hasKey(tempWord)) {
                        int count = wordCounts.value(tempWord);
                        count++;
                        wordCounts.replaceValue(tempWord, count);

                    } else {
                        allWords.enqueue(tempWord);
                        wordCounts.add(tempWord, 1);

                    }
                }
                placeHolder += tempWord.length();

            }

        }
        return allWords;
    }

    /**
     * A comparator method that returns the comparison between two string
     * alphabetically.
     */
    private static class StringLT implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
    }

    /**
     * Creates a HTML file that displays each word and the number of occurrences
     * in an organized table.
     *
     * @param wordCounts
     *            map with each word and the total number of occurrences
     * @param words
     *            queue of each word in alphabetical order
     * @param in
     *            SimpleReader for the name of the file
     * @param htmlOut
     *            SimpleWriter that is printed on
     * @clears wordCounts, words
     *
     */
    public static void makeHTMLFile(Map<String, Integer> wordCounts,
            Queue<String> words, SimpleReader in, SimpleWriter htmlOut) {
        htmlOut.println("<html><head>");
        htmlOut.println("<title>Words Counted in " + in.name() + "</title>");
        htmlOut.println("<body>");

        htmlOut.println("<h2>Words Counted in " + in.name() + "</h2>");
        htmlOut.println("<hr><table border=\"1\"><tr>");
        htmlOut.println("<th>Words</th><th>Counts</th></tr>");

        int totalWords = words.length();

        for (int i = 0; i < totalWords; i++) {
            Map.Pair<String, Integer> temp = wordCounts.remove(words.dequeue());
            htmlOut.println("<tr><td>" + temp.key() + "</td>");
            htmlOut.println("<td>" + temp.value() + "</td></tr>");

        }
        htmlOut.println("</table></body></html>");

    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        int count = 0;
        char resultPiece = 'a';
        String result = "";

        if (separators.contains(text.charAt(position))) {

            while (count < text.substring(position, text.length()).length()) {
                resultPiece = text.charAt(position + count);

                if (separators.contains(text.charAt(position + count))) {
                    result = result + resultPiece;
                    count++;

                } else {
                    count = text.substring(position, text.length()).length();

                }
            }
            count = 0;

        } else {

            while (count < text.substring(position, text.length()).length()) {
                resultPiece = text.charAt(position + count);

                if (!separators.contains(text.charAt(position + count))) {
                    result = result + resultPiece;
                    count++;

                } else {
                    count = text.substring(position, text.length()).length();

                }
            }
            count = 0;
        }
        return result;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader userIn = new SimpleReader1L();
        SimpleWriter userOut = new SimpleWriter1L();

        userOut.print("Enter an input file: ");
        String input = userIn.nextLine();
        userOut.print("Enter an output file: ");
        String output = userIn.nextLine();

        SimpleReader in = new SimpleReader1L(input);
        SimpleWriter htmlOut = new SimpleWriter1L(output);
        Map<String, Integer> wordCounts = new Map1L<>();
        Queue<String> words = new Queue1L<>();

        words.append(readInput(wordCounts, in));

        Comparator<String> alphabetize = new StringLT();
        words.sort(alphabetize);

        makeHTMLFile(wordCounts, words, in, htmlOut);

        userIn.close();
        userOut.close();
        in.close();
        htmlOut.close();

    }
}
