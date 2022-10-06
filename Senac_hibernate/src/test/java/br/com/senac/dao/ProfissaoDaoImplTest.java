/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Perfil;
import br.com.senac.entidade.Profissao;
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
public class ProfissaoDaoImplTest {
    
    private Profissao profissao;
    private ProfissaoDao profissaoDao;
    private Session sessao;
    
    public ProfissaoDaoImplTest() {
         profissaoDao = new ProfissaoDaoImpl();
    }
    
    //@Test
    public void testSalvar() {
        System.out.println("salvar");
        profissao = new Profissao(gerarSenha(7), "bla bla bla ....");
        sessao = HibernateUtil.abrirConexao();
        profissaoDao.salvarOuAlterar(profissao, sessao);
        sessao.close();
        assertNotNull(profissao.getId());              
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
        buscarProfissaoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Profissao> profissoes = profissaoDao
                                .pesquisarTodos(sessao);
        sessao.close();
        mostrar(profissoes);
        assertTrue(!profissoes.isEmpty());
    }
    
    private void mostrar(List<Profissao> profissoes) {
        
        profissoes.stream()                
                .forEach(prof ->{
            System.out.println("ID " + prof.getId());
            System.out.println("Nome " + prof.getNome());
            System.out.println("Descrição " + prof.getDescricao());
        });
    }
    
    public Profissao buscarProfissaoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Profissao> consulta = sessao
                .createQuery("from Profissao p"); //HQL
        consulta.setMaxResults(1);
        List<Profissao> profissoes = consulta.getResultList();
        sessao.close();
        if (profissoes.isEmpty()) {
            testSalvar();
        } else {
            profissao = profissoes.get(0);
        }
        return profissao;
    }
    
}
