import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Sample JUnit test fixture for SequenceSmooth.
 *
 * @author Jonathan Chemaly
 *
 */
public final class SequenceSmoothTest {

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
        Sequence<Integer> seq2 = this.createFromArgs(-5, 12);
        Sequence<Integer> expectedSeq2 = this.createFromArgs(3, 5);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs(13, 17, 11);
        Sequence<Integer> expectedSeq2 = this.createFromArgs();
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs();
        Sequence<Integer> expectedSeq2 = this.createFromArgs(3);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs(6);
        Sequence<Integer> expectedSeq2 = this.createFromArgs(2);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs(3, 2);
        Sequence<Integer> expectedSeq2 = this.createFromArgs(-3);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs(100, 5);
        Sequence<Integer> expectedSeq2 = this.createFromArgs(2);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs(100425423, 5244234,
                244324);
        Sequence<Integer> expectedSeq2 = this.createFromArgs(60501734);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs(1, 2, 3, 4, 5, 6, 7, 8, 9,
                10);
        Sequence<Integer> expectedSeq2 = this.createFromArgs(2, 8, 9, 44, 50,
                84, 81, 28, 39);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs();
        Sequence<Integer> expectedSeq2 = this.createFromArgs(1073741825);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs();
        Sequence<Integer> expectedSeq2 = this.createFromArgs(0);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
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
        Sequence<Integer> seq2 = this.createFromArgs();
        Sequence<Integer> expectedSeq2 = this.createFromArgs(0);
        SequenceSmooth.smooth(seq1, seq2);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(expectedSeq2, seq2);
    }

}
