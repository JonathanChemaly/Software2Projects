import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Dean Emerine & Jonathan Chemaly
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    @Test
    public final void testConstructor() {
        Set<String> s = this.constructorTest();
        Set<String> sExpected = this.constructorRef();

        assertEquals(s, sExpected);
    }

    @Test
    public final void testadd() {
        Set<String> s = this.createFromArgsTest("one", "two");
        Set<String> sExpected = this.createFromArgsRef("one", "two", "three");

        s.add("three");

        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemove() {
        Set<String> s = this.createFromArgsTest("one", "two", "three");
        Set<String> sExpected = this.createFromArgsRef("two", "three");
        String removed = s.remove("one");

        assertEquals(sExpected, s);
        assertEquals(removed, "one");
    }

    @Test
    public final void testSize() {
        Set<String> s = this.createFromArgsTest("one", "two", "three");
        Set<String> sExpected = this.createFromArgsRef("one", "two", "three");
        int sizeExpected = s.size();

        assertEquals(sExpected, s);
        assertEquals(sizeExpected, 3);
    }

    @Test
    public final void removeAny() {
        Set<String> s = this.createFromArgsTest("one", "two", "three");
        String strExpected = s.removeAny();
        boolean removedTest = s.contains(strExpected);

        assertEquals(removedTest, false);
    }

    @Test
    public final void testContains() {
        Set<String> s = this.createFromArgsTest("one", "two", "three");
        Set<String> sExpected = this.createFromArgsRef("one", "two", "three");
        boolean bExpected = s.contains("two");

        assertEquals(sExpected, s);
        assertEquals(bExpected, true);
    }

}
