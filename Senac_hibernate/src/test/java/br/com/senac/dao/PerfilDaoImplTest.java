/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Perfil;
import java.util.List;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marina.hoffmann
 */
public class PerfilDaoImplTest {
    
    public PerfilDaoImplTest() {
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
     * Test of pesquisarPorId method, of class PerfilDaoImpl.
     */
    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Long id = null;
        Session sessao = null;
        PerfilDaoImpl instance = new PerfilDaoImpl();
        Perfil expResult = null;
        Perfil result = instance.pesquisarPorId(id, sessao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarPorNome method, of class PerfilDaoImpl.
     */
    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        String nome = "";
        Session sessao = null;
        PerfilDaoImpl instance = new PerfilDaoImpl();
        List<Perfil> expResult = null;
        List<Perfil> result = instance.pesquisarPorNome(nome, sessao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarTodos method, of class PerfilDaoImpl.
     */
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        Session sessao = null;
        PerfilDaoImpl instance = new PerfilDaoImpl();
        List<Perfil> expResult = null;
        List<Perfil> result = instance.pesquisarTodos(sessao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
