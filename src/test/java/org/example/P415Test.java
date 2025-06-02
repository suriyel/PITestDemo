package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class P415Test {
    @Test
    public void test1() {
        P415 p415 = new P415();
        int num = p415.findNumber("0023", "0059");

        Assert.assertTrue(num == 6);
    }
}