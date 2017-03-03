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
    public final void testCheckLenghtBeforeAt() {

        System.out.println("TEST : a@aa.frr");
        assertFalse(Utils.checkMail("a@aa.frr"));
        System.out.println("Substring before @ size is below 2");
    }

    @Test
    public final void testCheckLenghtBeforeFinalPoint() {

        System.out.println("TEST : aa@f.frr");
        assertFalse(Utils.checkMail("aa@f.frr"));
        System.out.println("Substring between @ and . size is below 2");

    }

    @Test
    public final void testCheckAtSignalPresence() {

        System.out.println("TEST : eeeeee");
        assertFalse(Utils.checkMail("eeeeee"));
        System.out.println("No @ found");

    }

    @Test
    public final void testCheckPointPresence() {

        System.out.println("TEST : aa@aafr");
        assertFalse(Utils.checkMail("aa@aafr"));
        System.out.println("No . found");

    }

    @Test
    public final void testCheckLenghtAfterLastPoint() {

        System.out.println("TEST : aa@ff.r");
        assertFalse(Utils.checkMail("aa@ff.r"));
        System.out.println("Substring after . size is below 2");
    }

    @Test
    public final void testCheckLenghtBetweenTwoPoints() {

        System.out.println("TEST : aa@ff.rf.f");
        assertFalse(Utils.checkMail("aa@ff.rf.f"));
        System.out.println("Substring after final . is below 2");
    }
    
        @Test
    public final void testCheckValidMails() {

        System.out.println("TEST : aa@ff.fr");
        assertTrue(Utils.checkMail("aa@ff.fr"));
        System.out.println("email is valid");

        System.out.println("TEST : aa@ff.fr.fr");
        assertTrue(Utils.checkMail("aa@ff.fr.fr"));
        System.out.println("email is valid");

    }

}
