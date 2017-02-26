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
        System.err.println("No @ found");
        assertFalse(Utils.checkMail("aa@aafr"));
        System.err.println("No . found");
        assertFalse(Utils.checkMail("a@aa.frr"));
        System.err.println("Substring before @ size is below 2");
        assertFalse(Utils.checkMail("aa@f.frr"));
        System.err.println("Substring between @ and . size is below 2");
        assertFalse(Utils.checkMail("aa@ff.r"));
        System.err.println("Substring after . size is below 2");
        assertTrue(Utils.checkMail("aa@ff.fr"));
        System.err.println("email is valid");

    }
}
