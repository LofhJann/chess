package data;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

public class ArrayListTest {

    @Test
    public void addWorksAsExpected() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello World!");

        Assert.assertEquals("Hello World!", arrayList.get(0));
    }

    @Test
    public void removeWorksAsExpected() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("Hello world!");
        arrayList.add("Not true!");
        arrayList.remove(0);

        Assert.assertEquals("Not true!", arrayList.get(0));
    }

    @Test
    public void getWorksAsExpected() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("Hello World!");

        Assert.assertEquals("Hello World!", arrayList.get(0));
    }

    @Test
    public void replaceWorksAsExpected() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("Hello World!");
        arrayList.replace(0, "Hey!");

        Assert.assertEquals("Hey!", arrayList.get(0));
    }

    @Test
    public void removeElementWorks() {
        String hello = "Hello";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(hello);
        arrayList.remove(hello);

        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void removeElementDoesntThrowNullPointer() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.remove(null);

        Assert.assertTrue(true);
    }

    @Test
    public void arrayListSizeValueIsIncrementedWhenAdding() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("Hello World!");

        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void arrayListSizeValueIsDecreasedWhenRemoving() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("Hello World!");
        arrayList.remove(0);

        Assert.assertEquals(0, arrayList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexUnderZeroThrowsException() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOverSizeThrowsException() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.get(0);
    }
}
