/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.PerfilDao;
import br.com.senac.dao.PerfilDaoImpl;
import br.com.senac.dao.UsuarioDao;
import br.com.senac.dao.UsuarioDaoImpl;
import br.com.senac.entidade.Perfil;
import br.com.senac.entidade.Usuario;
import br.com.senac.util.Gerador;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author felipe.ticiani
 */
public class CadastroUsuario extends javax.swing.JFrame {
    
    private UsuarioDao usuarioDao;
    private List<Perfil> perfis;
    private Session sessao;
    private Usuario usuario;

    /**
     * Creates new form CadastroUsuario
     */
    public CadastroUsuario() {
        initComponents();
        carregarComboPerfil();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastrarUsuario = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        varLogin = new javax.swing.JTextField();
        lblLogin1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        varComboPerfil = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCadastrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCadastrarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastrarUsuario.setText("Cadastrar Usuário");

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNome.setText("Nome:");

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogin.setText("Login:");

        lblLogin1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLogin1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogin1.setText("Perfil:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        varComboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um perfil..." }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCadastrarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(varComboPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(varNome)
                                .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar)
                        .addGap(66, 66, 66)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblCadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNome)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogin)
                    .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogin1)
                    .addComponent(varComboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(0, 76, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            sessao = HibernateUtil.abrirConexao();
            usuario = new Usuario(varNome.getText(), varLogin.getText(), Gerador.gerarSenha(5));
            if (validarFormulario()) {
                int indice = varComboPerfil.getSelectedIndex();
                indice--;
                usuario.setPerfil(perfis.get(indice));
                new UsuarioDaoImpl().salvarOuAlterar(usuario, sessao);
                dispose(); //fecha janela atual
                JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuário!");
        } finally {
            sessao.close();
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void carregarComboPerfil(){
        
        PerfilDao perfilDao = new PerfilDaoImpl();
        
        try{
            sessao = HibernateUtil.abrirConexao();
            perfis = perfilDao.pesquisarTodos(sessao);
            perfis.forEach(perfil -> {
                varComboPerfil.addItem(perfil.getNome());
            });
        } catch (HibernateException e){
            System.out.println("Erro ao pesquisar todos os perfis " + e.getMessage());
        } finally{
            sessao.close();
        }
        
    }
    
    private boolean validarFormulario() {
        
        String nome =  varNome.getText().trim();
        if (validarCampoMenor3Caracter(nome)){
            JOptionPane.showMessageDialog(null, "O nome deve possuir mais de 3 caracteres!");
            return false;
        }
        
        String login =  varLogin.getText().trim();
        if (validarCampoMenor3Caracter(login)){
            JOptionPane.showMessageDialog(null, "O login deve possuir mais de 3 caracteres!");
            return false;
        }
        
        int indice = varComboPerfil.getSelectedIndex();
        if (indice == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um perfil!");
            return false;
        }
        return true;        
    }
    
    private boolean validarCampoMenor3Caracter(String campo){
        return campo.length() < 3;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCadastrarUsuario;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLogin1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JComboBox<String> varComboPerfil;
    private javax.swing.JTextField varLogin;
    private javax.swing.JTextField varNome;
    // End of variables declaration//GEN-END:variables
}
