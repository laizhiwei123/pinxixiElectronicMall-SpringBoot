package com.pinxixi;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
       // assertTrue(true);

        try {
            a();
        }catch (Exception e) {
            System.out.println("dad");
            
        }
    }

    public void  a() throws Exception {
        b();
        System.out.println("a");
    }
    public void b() throws Exception {
        throw  new Exception();
    }


}
