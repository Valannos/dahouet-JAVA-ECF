/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.afpa.dahouet.MismatchYearsException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.afpa.dahouet.Utils;
import com.afpa.dahouet.model.Commissaire;
import com.afpa.dahouet.model.Licencie;
import com.afpa.dahouet.model.Personne;
import com.afpa.dahouet.model.Proprietaire;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public final void testCalculPoints() throws MismatchYearsException {
        Date date = new Date();
        Licencie lic = new Licencie(100, 100, 2017, "Nagepas", "Jean-Michel", "jmng@plouf.fr", 1980);
        assertEquals(150, lic.calculPoints(date, 50), 50);

    }

    @Test
    public final void testReturnAge() {

        Commissaire com = new Commissaire("Sud-Bretagne", "Goff", "Erwann", "ccc@ccc.com", 1970);
        Proprietaire pro = new Proprietaire("Le Hire", "Dédé", "sfggf@gsr.fr", 1965);
        Licencie lic = new Licencie(100, 100, 2017, "Nagepas", "Jean-Michel", "jmng@plouf.fr", 1980);
        
       assertEquals(47, com.getAge(), 0);
       assertEquals(52, pro.getAge(), 0);
       assertEquals(37, lic.getAge(), 0);
       

    }
    @Test
    public final void testAverageAge(){
        
          List<Personne> personnes = new ArrayList<>();

        Licencie lic1 = new Licencie(100, 100, 2016, "Nagepas", "Jean-Michel", "jmng@plouf.fr", 1980);
        personnes.add(lic1);
        Licencie lic2 = new Licencie(100, 150, 2017, "Le Gall", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic2);
        Licencie lic3 = new Licencie(100, 200, 2017, "Le Floc\'h", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic3);
        Commissaire comi1 = new Commissaire("Sud-Bretagne", "Goff", "Erwann", "ccc@ccc.com", 1970);
        personnes.add(comi1);
        Proprietaire pro1 = new Proprietaire("Le Hire", "Dédé", "sfggf@gsr.fr", 1965);
        personnes.add(pro1);
        Proprietaire pro2 = new Proprietaire("Le Gronec", "Gwen", "sdfgdsfg@sdfg.com", 1975);
        personnes.add(pro2);
        
        assertEquals(37,Utils.averageAge(personnes), 0);
        
    }
    @Test
    public final void testMedianCalculationOdd(){
        
            List<Personne> personnes = new ArrayList<>();

        Licencie lic1 = new Licencie(100, 100, 2016, "Nagepas", "Jean-Michel", "jmng@plouf.fr", 1980);
        personnes.add(lic1);
        Licencie lic2 = new Licencie(100, 150, 2017, "Le Gall", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic2);
        Licencie lic3 = new Licencie(100, 200, 2017, "Le Floc\'h", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic3);
        Commissaire comi1 = new Commissaire("Sud-Bretagne", "Goff", "Erwann", "ccc@ccc.com", 1970);
        personnes.add(comi1);
        Proprietaire pro1 = new Proprietaire("Le Hire", "Dédé", "sfggf@gsr.fr", 1965);
        personnes.add(pro1);
        Proprietaire pro2 = new Proprietaire("Le Gronec", "Gwen", "sdfgdsfg@sdfg.com", 1975);
        personnes.add(pro2);
        
        assertEquals(39,Utils.medianAge(personnes), 0);
        
    }
    
        @Test
    public final void testMedianCalculationEven(){
        
            List<Personne> personnes = new ArrayList<>();

        Licencie lic1 = new Licencie(100, 100, 2016, "Nagepas", "Jean-Michel", "jmng@plouf.fr", 1980);
        personnes.add(lic1);
        Licencie lic2 = new Licencie(100, 150, 2017, "Le Gall", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic2);
        Licencie lic3 = new Licencie(100, 200, 2017, "Le Floc\'h", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic3);
        Commissaire comi1 = new Commissaire("Sud-Bretagne", "Goff", "Erwann", "ccc@ccc.com", 1970);
        personnes.add(comi1);
        Proprietaire pro1 = new Proprietaire("Le Hire", "Dédé", "sfggf@gsr.fr", 1965);
        personnes.add(pro1);
        Proprietaire pro2 = new Proprietaire("Le Gronec", "Gwen", "sdfgdsfg@sdfg.com", 1975);
        personnes.add(pro2);
         personnes.add(new Commissaire("Normadie", "Jacq", "Daniel", "Blo@fgf.fr", 1985));
        
        assertEquals(37,Utils.medianAge(personnes), 0);
        
    }
    

}
