package data;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIndexOverSizeThrowsException() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIndexUnderZeroThrowsException() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.remove(-1);
    }

    @Test
    public void arrayListGrowsWhenNeeded() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            arrayList.add(i);
        }

        Assert.assertEquals(10, (int)arrayList.get(10));
    }

    @Test
    public void growIfNeededKeepsDataInSameIndex() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrayList.add(i);
        }

        for (int i = 0; i < 50; i++) {
            if (arrayList.get(i) != i) {
                Assert.fail();
            }
        }

    }

    @Test
    public void arrayListIteratorNextWorksCorrectly() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Hello");
        arrayList.add("World!");

        Iterator<String> iterator = arrayList.iterator();


        Assert.assertEquals("Hello", iterator.next());
        Assert.assertEquals("World!", iterator.next());
    }

    @Test
    public void arrayListIteratorHasNextWorksCorrectly() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> iterator = arrayList.iterator();

        Assert.assertFalse("Iterator should've been empty", iterator.hasNext());

        arrayList.add("Hello");

        Assert.assertTrue("Iterator should have had next value", iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void exceptionIsThrownWhenIteratingEmptyList() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.iterator().next();

        Assert.fail("Exception wasn't thrown when trying to iterate non existing element");
    }
}
