package pl.sdacademy.todoapp;


import org.junit.Assert;
import org.junit.Test;

public class FirstUnitTest {

    @Test
    public void testTree(){
        Tree tree = new Tree();
        tree.add(100);
        tree.add(200);
        tree.add(10);

        boolean result = tree.search(100);
        Assert.assertTrue(tree.search(100));
        Assert.assertTrue(tree.search(999));

    }
}
