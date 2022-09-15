/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Gerador;

/**
 *
 * @author marina.hoffmann
 */
public class ClienteDaoImplTest {
    
    private Cliente cliente;
    private ClienteDao clienteDao;
 
    
    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
    }

    //@Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Cliente cliente = new Cliente(
                Gerador.gerarNome(),
                Gerador.gerarCPF(), 
                Gerador.gerarNumero(5),
                1500.78
        );
        clienteDao.salvar(cliente);
        assertNotNull(cliente.getId());
    }

    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        buscarUsuarioBD();
        cliente.setNome(Gerador.gerarNome());
        clienteDao.alterar(cliente);
        
        Cliente clienteAlt = clienteDao.pesquisarPorId(cliente.getId());
        assertEquals(cliente.getNome(), clienteAlt.getNome());
    }

    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        buscarUsuarioBD();
        clienteDao.excluir(cliente.getId());
        
        Cliente clienteExc = clienteDao.pesquisarPorId(cliente.getId());
        assertNull(clienteExc);
    }

    //@Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        Integer id = null;
        ClienteDaoImpl instance = new ClienteDaoImpl();
        Cliente expResult = null;
        Cliente result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testPesquisarTudo() throws Exception {
        System.out.println("pesquisarTudo");
        ClienteDaoImpl instance = new ClienteDaoImpl();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.pesquisarTudo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("pesquisarPorNome");
        String nome = "";
        ClienteDaoImpl instance = new ClienteDaoImpl();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.pesquisarPorNome(nome);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    private Cliente buscarUsuarioBD() throws SQLException, Exception{
        String sql = "SELECT * FROM cliente";
        Connection conn = FabricaConexao.abrirConexao();
        PreparedStatement pmst = conn.prepareStatement(sql);
        ResultSet rs = pmst.executeQuery();
        if(rs.next()){
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRg(rs.getString("rg"));
            cliente.setSalario(rs.getDouble("salario"));
        }else{
            testSalvar();
        }
        return cliente;
    }
    
}


