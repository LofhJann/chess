package data;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

public class PairTest {

    @Test
    public void addOnlyAtoPairWorks() {
        Pair<Object, Object> testPair = new Pair<>();
        testPair.setA("hello");
        Assert.assertNotNull(testPair.getA());
    }

    @Test
    public void addOnlyBtoPairWorks() {
        Pair<Object, Object> testPair = new Pair<>();
        testPair.setB("hello");
        Assert.assertNotNull(testPair.getB());
    }

    @Test
    public void addBothToPairConstructorWorks() {
        Pair<Object, Object> testPair = new Pair<>("hello", "world");
        Assert.assertNotNull(testPair.getA());
        Assert.assertNotNull(testPair.getB());
    }

    @Test
    public void pairGenericsWorks() {
        Pair<String, String> testPair = new Pair<>("hello", "world");

        Assert.assertThat(testPair.getA(), instanceOf(String.class));
        Assert.assertThat(testPair.getB(), instanceOf(String.class));
    }
}
