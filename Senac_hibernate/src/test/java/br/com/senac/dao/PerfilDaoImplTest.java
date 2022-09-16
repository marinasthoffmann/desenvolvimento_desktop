/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Perfil;
import br.com.senac.entidade.Usuario;
import static br.com.senac.util.Gerador.gerarSenha;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marina.hoffmann
 */
public class PerfilDaoImplTest {
    
    private Perfil perfil;
    private PerfilDao perfilDao;
    private Session sessao;
    
    public PerfilDaoImplTest() {
        perfilDao = new PerfilDaoImpl();
    }
    
    //@Test
    public void testSalvar() {
        System.out.println("salvar");
        perfil = new Perfil(gerarSenha(7), "bla bla bla ....");
        sessao = HibernateUtil.abrirConexao();
        perfilDao.salvarOuAlterar(perfil, sessao);
        sessao.close();
        assertNotNull(perfil.getId());              
    }
    
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }

    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        buscarPerfilBd();
        sessao = HibernateUtil.abrirConexao();
        List<Perfil> perfis = perfilDao
                                .pesquisarTodos(sessao);
        sessao.close();
        mostrar(perfis);
        assertTrue(!perfis.isEmpty());
    }
    
    private void mostrar(List<Perfil> perfis) {
        
        perfis.stream()                
                .forEach(perf ->{
            System.out.println("ID " + perf.getId());
            System.out.println("Nome " + perf.getNome());
            System.out.println("Descrição " + perf.getDescricao());
        });
    }
    
    public Perfil buscarPerfilBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Perfil> consulta = sessao
                .createQuery("from Perfil p"); //HQL
        consulta.setMaxResults(1);
        List<Perfil> perfis = consulta.getResultList();
        sessao.close();
        if (perfis.isEmpty()) {
            testSalvar();
        } else {
            perfil = perfis.get(0);
        }
        return perfil;
    }
    
}
