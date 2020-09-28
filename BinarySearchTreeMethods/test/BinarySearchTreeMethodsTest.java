import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTree1;

/**
 * JUnit test fixture for {@code BinarySearchTreeMethods}'s static methods
 * isInTree (and removeSmallest).
 */
public final class BinarySearchTreeMethodsTest {

    /**
     * Constructs and return a BST created by inserting the given {@code args}
     * into an empty tree in the order in which they are provided.
     *
     * @param args
     *            the {@code String}s to be inserted in the tree
     * @return the BST with the given {@code String}s
     * @requires [the Strings in args are all distinct]
     * @ensures createBSTFromArgs = [the BST with the given Strings]
     */
    private static BinaryTree<String> createBSTFromArgs(String... args) {
        BinaryTree<String> t = new BinaryTree1<String>();
        for (String s : args) {
            BinaryTreeUtility.insertInTree(t, s);
        }
        return t;
    }

    /**
     * Test isInTree regular true.
     */
    @Test
    public void testIsInTreeRegularT() {

        BinaryTree<String> t1 = createBSTFromArgs("b", "a", "c");
        BinaryTree<String> t2 = createBSTFromArgs("b", "a", "c");

        boolean inTree = BinarySearchTreeMethods.isInTree(t1, "a");

        assertEquals(true, inTree);
        assertEquals(t2, t1);
    }

    /**
     * Test isInTree regular false.
     */
    @Test
    public void testIsInTreeRegularF() {

        BinaryTree<String> t1 = createBSTFromArgs("b", "a", "c");
        BinaryTree<String> t2 = createBSTFromArgs("b", "a", "c");

        boolean inTree = BinarySearchTreeMethods.isInTree(t1, "d");

        assertEquals(false, inTree);
        assertEquals(t2, t1);
    }

    /**
     * Test isInTree with one value.
     */
    @Test
    public final void testIsInTreeOne() {
        BinaryTree<String> t1 = createBSTFromArgs("a");
        BinaryTree<String> t2 = createBSTFromArgs("a");

        boolean inTree = BinarySearchTreeMethods.isInTree(t1, "a");

        assertEquals(true, inTree);
        assertEquals(t2, t1);
    }

    /**
     * Test isInTree with an empty string.
     */
    @Test
    public final void testIsInTreeEmpty() {
        BinaryTree<String> t1 = createBSTFromArgs();
        BinaryTree<String> t2 = createBSTFromArgs();

        boolean inTree = BinarySearchTreeMethods.isInTree(t1, "a");

        assertEquals(false, inTree);
        assertEquals(t2, t1);
    }

    // (and for BinarySearchTreeMethods.removeSmallest)

}
