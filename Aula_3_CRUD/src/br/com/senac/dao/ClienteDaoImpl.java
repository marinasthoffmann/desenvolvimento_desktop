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
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author marina.hoffmann
 */
public class ClienteDaoImpl implements ClienteDao {
    
    private Connection conn;
    private PreparedStatement prepara; //prepara a instrução p bd
    private ResultSet resultado;
    
    @Override
    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente(nome, cpf, rg, salario)" 
                + " values(?, ?, ?, ?)"; //nome da tabela
        try{
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);
            prepara.setString(1, cliente.getNome());
            prepara.setString(2, cliente.getCpf());
            prepara.setString(3, cliente.getRg());
            prepara.setDouble(4, cliente.getSalario());
            prepara.executeUpdate();
            resultado = prepara.getGeneratedKeys();
            resultado.next(); //retorna true se tiver valor e aponta pra primeira (e única) linha
            cliente.setId(resultado.getInt(1));
        } catch (SQLException e){
            System.out.println("Erro ao salvar" + e.getMessage());
        }
    }

    @Override
    public void alterar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, rg = ?, salario = ? "
                + "WHERE id = ?";
        try{
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(sql);
            prepara.setString(1, cliente.getNome());
            prepara.setString(2, cliente.getCpf());
            prepara.setString(3, cliente.getRg());
            prepara.setDouble(4, cliente.getSalario());
            prepara.setInt(5, cliente.getId());
            prepara.executeUpdate();
        } catch (SQLException e){
            System.err.println("Erro ao alterar cliente " + e.getMessage());
        } finally{
            FabricaConexao.fecharConexao(conn, prepara, resultado);
        }
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
            prepara.setInt(1, id);
            prepara.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(conn, prepara, resultado);
        }
    }

    @Override
    public Cliente pesquisarPorId(Integer id) throws SQLException {
        Cliente cliente = null;
        String consulta = "SELECT * FROM cliente WHERE id = ?";
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(consulta);
            prepara.setInt(1, id);
            resultado = prepara.executeQuery();
            if (resultado.next()){
                cliente = new Cliente();
                cliente.setId(0);
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setSalario(resultado.getDouble("salario"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar por id" + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(conn, prepara, resultado);
        }
        return cliente;
    }

    @Override
    public List<Cliente> pesquisarTudo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
