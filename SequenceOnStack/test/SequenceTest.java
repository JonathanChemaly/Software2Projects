import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Jonathan Chemaly & Dean Emerine
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    @Test
    public final void testConstructor() {
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        assertEquals(s, sExpected);
    }

    @Test
    public final void testadd() {
        Sequence<String> s = this.createFromArgsTest("one", "three");
        Sequence<String> sExpected = this.createFromArgsRef("one", "two",
                "three");

        s.add(1, "two");

        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemove() {
        Sequence<String> s = this.createFromArgsTest("one", "two", "three");
        Sequence<String> sExpected = this.createFromArgsRef("two", "three");
        String removed = s.remove(0);
        assertEquals(sExpected, s);
        assertEquals(removed, "one");
    }

    @Test
    public final void testLength() {
        Sequence<String> s = this.createFromArgsTest("one", "two", "three");
        Sequence<String> sExpected = this.createFromArgsRef("one", "two",
                "three");
        int lExpected = s.length();
        assertEquals(sExpected, s);
        assertEquals(lExpected, 3);
    }

}
