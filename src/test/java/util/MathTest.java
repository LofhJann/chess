package util;

import org.junit.Assert;
import org.junit.Test;

public class MathTest {

    @Test
    public void absReturnsCorrectValueOnPositive() {
        Assert.assertEquals(1, Math.abs(1));
    }

    @Test
    public void absReturnsCorrectValueOnNegative() {
        Assert.assertEquals(1, Math.abs(-1));
    }

    @Test
    public void absReturnsCorrectValueOnZero() {
        Assert.assertEquals(0, Math.abs(0));
    }
}
