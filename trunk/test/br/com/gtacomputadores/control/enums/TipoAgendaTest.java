/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gtacomputadores.control.enums;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeandro
 */
public class TipoAgendaTest {
    
    public TipoAgendaTest() {
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

    /**
     * Test of values method, of class TipoAgenda.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        TipoAgenda[] expResult = null;
        TipoAgenda[] result = TipoAgenda.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class TipoAgenda.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        TipoAgenda expResult = null;
        TipoAgenda result = TipoAgenda.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
