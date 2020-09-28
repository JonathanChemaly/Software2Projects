import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Implements method to smooth a {@code Sequence<Integer>}.
 *
 * @author Jonathan Chemaly
 *
 */
public final class SequenceSmooth2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private SequenceSmooth2() {
    }

    /**
     * Smooths a given {@code Sequence<Integer>}.
     *
     * @param s1
     *            the sequence to smooth
     * @returns result smoothed sequence
     * @requires |s1| >= 1
     * @ensures <pre>
     * |result| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        result = c * <(i+j)/2> * d))
     * </pre>
     */
    public static Sequence<Integer> smooth(Sequence<Integer> s1) {
        assert s1 != null : "Violation of: s1 is not null";
        assert s1.length() >= 1 : "Violation of: |s1| >= 1";

        Sequence<Integer> result = new Sequence1L<>();

        int temp = 0;

        for (int i = 0; i < s1.length() - 1; i++) {
            long one = s1.entry(i);
            long two = s1.entry(i + 1);
            temp = (int) ((one + two) / 2);
            result.add(i, temp);
        }
        return result;
    }

    /**
     * Smooths a given {@code Sequence<Integer>}.
     *
     * @param s1
     *            the sequence to smooth
     * @returns result smoothed sequence
     * @requires |s1| >= 1
     * @ensures <pre>
     * |result| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        result = c * <(i+j)/2> * d))
     * </pre>
     */
    public static Sequence<Integer> smoothRecursive(Sequence<Integer> s1) {
        assert s1 != null : "Violation of: s1 is not null";
        assert s1.length() >= 1 : "Violation of: |s1| >= 1";

        Sequence<Integer> result = new Sequence1L<>();
        int temp = 0;

        if (s1.length() > 1) {
            long one = s1.remove(0);
            long two = s1.remove(0);
            s1.add(0, (int) two);
            result.transferFrom(smooth(s1));
            smooth(s1);
            temp = (int) ((one + two) / 2);
            result.add(0, temp);
            s1.add(0, (int) one);

        }

        return result;
    }

}
