/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author marina.hoffmann
 */
public interface ClienteDao {
    // public static é implicito, pois é uma interface
    
    void salvar(Cliente usuario) throws SQLException;
    
    void alterar(Cliente usuario) throws SQLException;
    
    void excluir(Integer id) throws SQLException;
    
    Cliente pesquisarPorId(Integer id) throws SQLException;
    
    List<Cliente> pesquisarTudo()throws SQLException;
    
    List<Cliente> pesquisarPorNome(String nome)throws SQLException;
    
}
