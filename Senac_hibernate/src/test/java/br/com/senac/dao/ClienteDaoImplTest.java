///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.senac.dao;
//
//import br.com.senac.entidade.Cliente;
//import br.com.senac.entidade.Profissao;
//import br.com.senac.util.Gerador;
//import java.util.List;
//import org.hibernate.Session;
//import static org.junit.Assert.*;
//
///**
// *
// * @author marina.hoffmann
// */
//public class ClienteDaoImplTest {
//    
//    private Cliente cliente;
//    private ClienteDao clienteDao;
//    private Session sessao;
//    
//    public ClienteDaoImplTest() {
//        clienteDao = new ClienteDaoImpl();
//    }
//    
////    @Test
////    public void testSalvar (){
////        System.out.println("salvar");
////        ProfissaoDaoImplTest pdit = new ProfissaoDaoImplTest();
////        Profissao profissao = pdit.buscarProfissaoBd();
////        cliente = new Cliente(Gerador.gerarNome(), Gerador.gerarCpf(), Gerador.gerarNumero(5), 564564.5);
////        cliente.setProfissao(profissao);
////        sessao = HibernateUtil.abrirConexao();
////        clienteDao.salvarOuAlterar(cliente, sessao);
////        sessao.close();
////        assertNotNull(cliente.getId());   
//        
//}
//    
////    @Test
//    public void testPesquisarPorId() {
//        System.out.println("pesquisarPorId");
//        Long id = null;
//        Session sessao = null;
//        ClienteDaoImpl instance = new ClienteDaoImpl();
//        Cliente expResult = null;
//        Cliente result = instance.pesquisarPorId(id, sessao);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of pesquisarPorNome method, of class ClienteDaoImpl.
//     */
////    @Test
//    public void testPesquisarPorNome() {
//        System.out.println("pesquisarPorNome");
//        String nome = "";
//        Session sessao = null;
//        ClienteDaoImpl instance = new ClienteDaoImpl();
//        List<Cliente> expResult = null;
//        List<Cliente> result = instance.pesquisarPorNome(nome, sessao);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
