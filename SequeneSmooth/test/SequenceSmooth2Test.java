import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Sample JUnit test fixture for SequenceSmooth2.
 *
 * @author Jonathan Chemaly
 *
 */
public final class SequenceSmooth2Test {

    /**
     * Constructs and returns a sequence of the integers provided as arguments.
     *
     * @param args
     *            0 or more integer arguments
     * @return the sequence of the given arguments
     * @ensures createFromArgs= [the sequence of integers in args]
     */
    private Sequence<Integer> createFromArgs(Integer... args) {
        Sequence<Integer> s = new Sequence1L<Integer>();
        for (Integer x : args) {
            s.add(s.length(), x);
        }
        return s;
    }

    /**
     * Test smooth with s1 = <2, 4, 6> and s2 = <-5, 12>.
     */
    @Test
    public void test1() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(2, 4, 6);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(2, 4, 6);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(3, 5);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <7> and s2 = <13, 17, 11>.
     */
    @Test
    public void test2() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(7);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(7);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <1, 5> and s2 = <>.
     */
    @Test
    public void test2Empty() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(1, 5);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(1, 5);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(3);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <> and s2 = <>.
     */
    @Test
    public void testNegativeToPositive() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(-3, 7);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(-3, 7);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(2);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <> and s2 = <>.
     */
    @Test
    public void testDoubleNegativetoNegative() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(-2, -4);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(-2, -4);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(-3);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
        ;
    }

    /**
     * Test smooth with s1 = <> and s2 = <>.
     */
    @Test
    public void testOdd() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(3, 2);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(3, 2);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(2);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <> and s2 = <>.
     */
    @Test
    public void testBig() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(48002346, 73001122);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(48002346,
                73001122);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(60501734);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <> and s2 = <>.
     */
    @Test
    public void testMultiple() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(1, 4, 12, 6, 82, 19, 150,
                12, 44, 34);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(1, 4, 12, 6, 82,
                19, 150, 12, 44, 34);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(2, 8, 9, 44, 50,
                84, 81, 28, 39);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <1, 5> and s2 = <>.
     */
    @Test
    public void testVeryBig() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(1073741825, 1073741825);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(1073741825,
                1073741825);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(1073741825);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <1, 5> and s2 = <>.
     */
    @Test
    public void testZeroAverage1() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(1073741825, -1073741825);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(1073741825,
                -1073741825);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(0);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

    /**
     * Test smooth with s1 = <1, 5> and s2 = <>.
     */
    @Test
    public void testZeroAverage2() {
        /*
         * Set up variables and call method under test
         */
        Sequence<Integer> seq1 = this.createFromArgs(-1073741823, 1073741824);
        Sequence<Integer> expectedSeq1 = this.createFromArgs(-1073741823,
                1073741824);
        Sequence<Integer> result = SequenceSmooth2.smooth(seq1);
        Sequence<Integer> expectedResult = this.createFromArgs(0);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedResult, result);
    }

}
