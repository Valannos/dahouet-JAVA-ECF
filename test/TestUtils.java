/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.afpa.dahouet.Utils;
import java.util.Arrays;
import junit.framework.AssertionFailedError;

/**
 *
 * @author Valannos
 */
public class TestUtils {

    public TestUtils() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public final void testCheckMailAtPresence() {

        assertFalse(Utils.checkMail("eeeeee"));
        assertFalse(Utils.checkMail("aa@aafr"));

        assertFalse(Utils.checkMail("a@aa.frr"));
        System.err.println("Substring size before @ is below 2");
        assertFalse(Utils.checkMail("aa@f.frr"));
        assertFalse(Utils.checkMail("aa@ff.r"));
        assertFalse(Utils.checkMail("aa@ff.r"));
        assertTrue(Utils.checkMail("aa@ff.fr"));
        System.err.println("email is valid");

    }
}
