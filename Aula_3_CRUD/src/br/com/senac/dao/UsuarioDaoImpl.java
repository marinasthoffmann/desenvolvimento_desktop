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
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author marina.hoffmann
 */
// herança
public class UsuarioDaoImpl implements UsuarioDao {
    
    private Connection conn;
    private PreparedStatement prepara; //prepara a instrução p bd
    private ResultSet resultado;
    
    @Override
    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario(nome, login, senha)" 
                + " values(?, ?, ?)"; //nome da tabela
        try{
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);
            prepara.setString(1, usuario.getNome());
            prepara.setString(2, usuario.getLogin());
            prepara.setString(3, usuario.getSenha());
            prepara.executeUpdate();
            resultado = prepara.getGeneratedKeys();
            resultado.next(); //retorna true se tiver valor e aponta pra primeira (e única) linha
            usuario.setId(resultado.getInt(1));
        } catch (SQLException e){
            System.out.println("Erro ao salvar" + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(conn, prepara, resultado);
        }
    }

    @Override
    public void alterar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ? "
                + "WHERE id = ?";
        try{
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(sql);
            prepara.setString(1, usuario.getNome());
            prepara.setString(2, usuario.getLogin());
            prepara.setString(3, usuario.getSenha());
            prepara.setInt(4, usuario.getId());
            prepara.executeUpdate();
        } catch (SQLException e){
            System.err.println("Erro ao alterar usuário " + e.getMessage());
        } finally{
            FabricaConexao.fecharConexao(conn, prepara, resultado);
        }
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement("DELETE FROM usuario WHERE id = ?");
            prepara.setInt(1, id);
            prepara.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(conn, prepara, resultado);
        }
    }

    @Override
    public Usuario pesquisarPorId(Integer id) throws SQLException {
        Usuario usuario = null;
        String consulta = "SELECT * FROM usuario WHERE id = ?";
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(consulta);
            prepara.setInt(1, id);
            resultado = prepara.executeQuery();
            if (resultado.next()){
                usuario = new Usuario();
                usuario.setId(0);
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setUltimoAcesso(resultado.getDate("ultimo_acesso"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar por id" + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(conn, prepara, resultado);
        }
        return usuario;
    }

    @Override
    public List<Usuario> pesquisarTudo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> pesquisarPorNome(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
