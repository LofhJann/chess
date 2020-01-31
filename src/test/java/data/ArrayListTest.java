package data;

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
}
