import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Jonathan Chemaly and Dean Emerine
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    /**
     * Test default constructor.
     */
    @Test
    public final void testConstructor() {

        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected = this.constructorRef();

        assertEquals(n, nExpected);
    }

    /**
     * Test constructor from integer.
     */
    @Test
    public final void testIntConstructor() {

        int i = 5;
        NaturalNumber n = this.constructorTest(i);
        NaturalNumber nExpected = this.constructorRef(i);

        assertEquals(n, nExpected);
    }

    /**
     * Test constructor from String.
     */
    @Test
    public final void testStringConstructor() {

        String s = "123";
        NaturalNumber n = this.constructorTest(s);
        NaturalNumber nExpected = this.constructorRef(s);

        assertEquals(n, nExpected);
    }

    /**
     * Test constructor from NaturalNumber.
     */
    @Test
    public final void testNaturalNumberConstructor() {

        NaturalNumber1L num = new NaturalNumber1L(10);
        NaturalNumber n = this.constructorTest(num);
        NaturalNumber nExpected = this.constructorRef(num);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with two zero values.
     */
    @Test
    public final void testMultiplyBy10ZeroZero() {

        NaturalNumber n = this.constructorTest(0);
        NaturalNumber nExpected = this.constructorRef(0);

        n.multiplyBy10(0);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with zero value and nonzero value.
     */
    @Test
    public final void testMultiplyBy10ZeroValue() {

        NaturalNumber n = this.constructorTest(0);
        NaturalNumber nExpected = this.constructorRef(7);

        n.multiplyBy10(7);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with IntegerMax value.
     */
    @Test
    public final void testMultiplyBy10() {

        NaturalNumber n = this.constructorTest(Integer.MAX_VALUE);
        NaturalNumber nExpected = this.constructorRef("21474836474");

        n.multiplyBy10(4);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with typical int values.
     */
    @Test
    public final void testMultiplyBy10typical() {

        NaturalNumber n = this.constructorTest(138);
        NaturalNumber nExpected = this.constructorRef(1386);

        n.multiplyBy10(6);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with strings of "0".
     */
    @Test
    public final void testMultiplyBy10ZeroStrings() {

        NaturalNumber n = this.constructorTest("0");
        NaturalNumber nExpected = this.constructorRef("0");

        n.multiplyBy10(0);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with 1 string of "0".
     */
    @Test
    public final void testMultiplyBy10OneZeroString() {

        NaturalNumber n = this.constructorTest("0");
        NaturalNumber nExpected = this.constructorRef("7");

        n.multiplyBy10(7);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with typical string value.
     */
    @Test
    public final void testMultiplyBy10TypicalStrings() {

        NaturalNumber n = this.constructorTest("765234");
        NaturalNumber nExpected = this.constructorRef("7652348");

        n.multiplyBy10(8);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with greater than MAXInt string value.
     */
    @Test
    public final void testMultiplyBy10MaxIntStringPlusK() {

        String num = String.valueOf(Integer.MAX_VALUE) + "456";
        NaturalNumber n = this.constructorTest(num);
        NaturalNumber nExpected = this.constructorRef("21474836474567");

        n.multiplyBy10(7);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with zero NN value.
     */
    @Test
    public final void testMultiplyBy10ZeroNN() {

        NaturalNumber temp1 = new NaturalNumber1L(0);
        NaturalNumber temp2 = new NaturalNumber1L(0);

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        n.multiplyBy10(0);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with zero NN value plus k.
     */
    @Test
    public final void testMultiplyBy10ZeroNNPlusK() {

        NaturalNumber temp1 = new NaturalNumber1L(0);
        NaturalNumber temp2 = new NaturalNumber1L(7);

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        n.multiplyBy10(7);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with typical NN value plus k.
     */
    @Test
    public final void testMultiplyBy10TypicalNNPlusK() {

        NaturalNumber temp1 = new NaturalNumber1L(7625);
        NaturalNumber temp2 = new NaturalNumber1L(76257);

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        n.multiplyBy10(7);

        assertEquals(n, nExpected);
    }

    /**
     * Test multiplyBy10 method with greater than MaxInt value.
     */
    @Test
    public final void testMultiplyBy10MaxIntNNPlusK() {

        NaturalNumber temp1 = new NaturalNumber1L(
                String.valueOf(Integer.MAX_VALUE) + "456");
        NaturalNumber temp2 = new NaturalNumber1L("21474836474567");

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        n.multiplyBy10(7);

        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with integer zero.
     */
    @Test
    public final void testDivideBy10IntZero() {

        NaturalNumber n = this.constructorTest(0);
        NaturalNumber nExpected = this.constructorRef(0);

        int rem = n.divideBy10();
        int remExpected = 0;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with single digit integer.
     */
    @Test
    public final void testDivideBy10IntSingle() {

        NaturalNumber n = this.constructorTest(4);
        NaturalNumber nExpected = this.constructorRef(0);

        int rem = n.divideBy10();
        int remExpected = 4;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with max integer.
     */
    @Test
    public final void testDivideBy10IntMax() {

        NaturalNumber n = this.constructorTest(Integer.MAX_VALUE);
        NaturalNumber nExpected = this.constructorRef(214748364);

        int rem = n.divideBy10();
        int remExpected = 7;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with typical integer.
     */
    @Test
    public final void testDivideBy10IntTypical() {

        NaturalNumber n = this.constructorTest(45964);
        NaturalNumber nExpected = this.constructorRef(4596);

        int rem = n.divideBy10();
        int remExpected = 4;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with string of "0".
     */
    @Test
    public final void testDivideBy10ZeroString() {

        NaturalNumber n = this.constructorTest("0");
        NaturalNumber nExpected = this.constructorRef("0");

        int rem = n.divideBy10();
        int remExpected = 0;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with single digit string.
     */
    @Test
    public final void testDivideBy10SingleDigitString() {

        NaturalNumber n = this.constructorTest("8");
        NaturalNumber nExpected = this.constructorRef("0");

        int rem = n.divideBy10();
        int remExpected = 8;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with typical string.
     */
    @Test
    public final void testDivideBy10StringTypical() {

        NaturalNumber n = this.constructorTest("3745");
        NaturalNumber nExpected = this.constructorRef("374");

        int rem = n.divideBy10();
        int remExpected = 5;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with greater than MaxInt string value.
     */
    @Test
    public final void testDivideBy10MaxIntString() {

        NaturalNumber n = this
                .constructorTest(String.valueOf(Integer.MAX_VALUE) + "456");
        NaturalNumber nExpected = this.constructorRef("214748364745");

        int rem = n.divideBy10();
        int remExpected = 6;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with zero NN value.
     */
    @Test
    public final void testDivideBy10ZeroNN() {

        NaturalNumber temp1 = new NaturalNumber1L(0);
        NaturalNumber temp2 = new NaturalNumber1L(0);

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        int rem = n.divideBy10();
        int remExpected = 0;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with single digit NN value.
     */
    @Test
    public final void testDivideBy10SingleNN() {

        NaturalNumber temp1 = new NaturalNumber1L(6);
        NaturalNumber temp2 = new NaturalNumber1L(0);

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        int rem = n.divideBy10();
        int remExpected = 6;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with typical NN value.
     */
    @Test
    public final void testDivideBy10TypicalNN() {

        NaturalNumber temp1 = new NaturalNumber1L(88754);
        NaturalNumber temp2 = new NaturalNumber1L(8875);

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        int rem = n.divideBy10();
        int remExpected = 4;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test divideBy10 method with greater than MaxInt value.
     */
    @Test
    public final void testDivideBy10MaxIntNN() {

        NaturalNumber temp1 = new NaturalNumber1L(
                String.valueOf(Integer.MAX_VALUE) + "456");
        NaturalNumber temp2 = new NaturalNumber1L("214748364745");

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        int rem = n.divideBy10();
        int remExpected = 6;

        assertEquals(rem, remExpected);
        assertEquals(n, nExpected);
    }

    /**
     * Test isZero method with a zero int value.
     */
    @Test
    public final void testIsZeroIntTrue() {

        NaturalNumber n = this.constructorTest(0);
        NaturalNumber nExpected = this.constructorRef(0);

        boolean r = n.isZero();
        boolean rExpected = true;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

    /**
     * Test isZero method with a non zero int value.
     */
    @Test
    public final void testIsZeroIntFalse() {

        NaturalNumber n = this.constructorTest(123);
        NaturalNumber nExpected = this.constructorRef(123);

        boolean r = n.isZero();
        boolean rExpected = false;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

    /**
     * Test isZero method with a non zero max int value.
     */
    @Test
    public final void testIsZeroMaxIntFalse() {

        NaturalNumber n = this.constructorTest(Integer.MAX_VALUE);
        NaturalNumber nExpected = this.constructorRef(Integer.MAX_VALUE);

        boolean r = n.isZero();
        boolean rExpected = false;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

    /**
     * Test isZero method with a zero String value.
     */
    @Test
    public final void testIsZeroStrTrue() {

        NaturalNumber n = this.constructorTest("0");
        NaturalNumber nExpected = this.constructorRef("0");

        boolean r = n.isZero();
        boolean rExpected = true;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

    /**
     * Test isZero method with a non zero String value.
     */
    @Test
    public final void testIsZeroStrFalse() {

        NaturalNumber n = this.constructorTest("123");
        NaturalNumber nExpected = this.constructorRef("123");

        boolean r = n.isZero();
        boolean rExpected = false;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

    /**
     * Test isZero method with a non zero greater than max int string value.
     */
    @Test
    public final void testIsZeroStrMaxIntFalse() {

        NaturalNumber n = this
                .constructorTest(String.valueOf(Integer.MAX_VALUE) + "456");
        NaturalNumber nExpected = this.constructorRef("2147483647456");

        boolean r = n.isZero();
        boolean rExpected = false;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

    /**
     * Test isZero method with a zero NN value.
     */
    @Test
    public final void testIsZeroNNTrue() {

        NaturalNumber temp1 = new NaturalNumber1L(0);
        NaturalNumber temp2 = new NaturalNumber1L(0);

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        boolean r = n.isZero();
        boolean rExpected = true;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

    /**
     * Test isZero method with a non zero String value.
     */
    @Test
    public final void testIsZeroNNFalse() {

        NaturalNumber temp1 = new NaturalNumber1L(547);
        NaturalNumber temp2 = new NaturalNumber1L(547);

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        boolean r = n.isZero();
        boolean rExpected = false;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

    /**
     * Test isZero method with a non zero greater than max int NN value.
     */
    @Test
    public final void testIsZeroNNMaxIntFalse() {

        NaturalNumber temp1 = new NaturalNumber1L(
                String.valueOf(Integer.MAX_VALUE) + "456");
        NaturalNumber temp2 = new NaturalNumber1L("2147483647456");

        NaturalNumber n = this.constructorTest(temp1);
        NaturalNumber nExpected = this.constructorRef(temp2);

        boolean r = n.isZero();
        boolean rExpected = false;

        assertEquals(n, nExpected);
        assertEquals(r, rExpected);
    }

}
