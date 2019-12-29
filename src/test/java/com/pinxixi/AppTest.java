<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
package com.pinxixi;

import static org.junit.Assert.assertTrue;

import com.pinxixi.sevices.GenerateVerificationCodeSevicesImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.pinxixi.sevices.RegisterService;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
//  assertTrue( true );

            try {
                System.out.println(a());
            }catch (Exception e) {
                e.printStackTrace();
            }
    }

    public int a()  {
        int a = 0;
        a = 10 / 0;

        System.out.println(":adada");
        return a;

    }
}
<<<<<<< HEAD
=======
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
        assertTrue(true);

    }


}
>>>>>>> pinxixi
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
