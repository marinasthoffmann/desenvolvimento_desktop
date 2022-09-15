/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

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
public class UsuarioDaoImplTest {
    
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    
    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

    //@Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        usuario = new Usuario(
                Gerador.gerarNome(),
                Gerador.gerarLogin(), 
                Gerador.gerarSenha(5)
        );
        usuarioDao.salvar(usuario);
        assertNotNull(usuario.getId());
    }

    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        buscarUsuarioBD();
        usuario.setNome(Gerador.gerarNome());
        usuarioDao.alterar(usuario);
        
        Usuario usuarioAlt = usuarioDao.pesquisarPorId(usuario.getId());
        assertEquals(usuario.getNome(), usuarioAlt.getNome());
    }

    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        buscarUsuarioBD();
        usuarioDao.excluir(usuario.getId());
        
        Usuario usuarioExc = usuarioDao.pesquisarPorId(usuario.getId());
        assertNull(usuarioExc);
    }

    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        buscarUsuarioBD();
        Usuario usuarioPesquisado = usuarioDao.pesquisarPorId(usuario.getId());
        assertNotNull(usuarioPesquisado);
    }

    //@Test
    public void testPesquisarTudo() throws Exception {
        System.out.println("pesquisarTudo");
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.pesquisarTudo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
//    public void testPesquisarPorNome() throws Exception {;
//        System.out.println("pesquisarPorNome");
//        String nome = "";
//        UsuarioDaoImpl instance = new UsuarioDaoImpl();
//        List<Usuario> expResult = null;
//        List<Usuario> result = instance.pesquisarPorNome(nome);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
    private Usuario buscarUsuarioBD() throws SQLException, Exception{
        String sql = "SELECT * FROM usuario";
        Connection conn = FabricaConexao.abrirConexao();
        PreparedStatement pmst = conn.prepareStatement(sql);
        ResultSet rs = pmst.executeQuery();
        if(rs.next()){
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setUltimoAcesso(rs.getDate("ultimo_acesso"));
        }else{
            testSalvar();
        }
        return usuario;
    }
    
}
