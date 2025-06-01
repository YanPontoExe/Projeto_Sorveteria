package DAO;

import DTO.funcionarioDTO;
import DTO.usuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class usuarioDAO {
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        ArrayList<funcionarioDTO> lista = new ArrayList<>();
    
    public ResultSet autenticacaoUsuario(usuarioDTO objusuarioDTO){
        conn = new conexaodaO().conectabD();
        
        try {
            String sql = "select * from tb_usuario where nome_usuario=? && senha_usuario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuarioDTO.getNome_usuario());
            pstm.setString(2, objusuarioDTO.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: "+erro);
            return null;
        }
    }
    
    public void cadastrarFuncionario(usuarioDTO objusuarioDTO) {
            String sql = "insert into tb_usuario(nome_usuario, senha_usuario) values (?, ?)";

            conn = new conexaodaO().conectabD();

            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, objusuarioDTO.getNome_usuario());
                pstm.setString(2, objusuarioDTO.getSenha_usuario());
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

                pstm.execute();
                pstm.close();


            } catch (Exception erro) {

                JOptionPane.showMessageDialog(null, "UsuarioDAO cadastrar: " + erro);
            }

    
    }
}
