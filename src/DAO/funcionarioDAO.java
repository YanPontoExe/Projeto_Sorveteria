package DAO;

import DTO.funcionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class funcionarioDAO {
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        ArrayList<funcionarioDTO> lista = new ArrayList<>();

        public void cadastrarFuncionario(funcionarioDTO objfuncionarioDTO) {
            String sql = "insert into tb_funcionario(nome_funcionario, cpf_funcionario) values (?, ?)";

            conn = new conexaodaO().conectabD();

            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, objfuncionarioDTO.getNome_funcionario());
                pstm.setString(2, objfuncionarioDTO.getCpf_funcionario());

                pstm.execute();
                pstm.close();


            } catch (Exception erro) {

                JOptionPane.showMessageDialog(null, "FuncionarioDAO cadastrar: " + erro);
            }

    
    }
        
        public ArrayList<funcionarioDTO> pesquisarFuncionario(){
            String sql = "select * from tb_funcionario";
         conn = new conexaodaO().conectabD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                    funcionarioDTO objfuncionarioDTO = new funcionarioDTO();
                    objfuncionarioDTO.setId_funcionario(rs.getInt("id_funcionario"));
                    objfuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                    objfuncionarioDTO.setCpf_funcionario(rs.getString("cpf_funcionario"));
                    
                    
                    lista.add(objfuncionarioDTO);
            }
             
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Pesquisar: "+erro);
        }
        return lista;
        }
        
        public void alterarFuncionario(funcionarioDTO objfuncionarioDTO){
        String sql = "update tb_funcionario set nome_funcionario=?, cpf_funcionario=?  where id_funcionario=?";
        
        conn = new conexaodaO().conectabD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionarioDTO.getNome_funcionario());
            pstm.setString(2, objfuncionarioDTO.getCpf_funcionario());
            pstm.setInt(3, objfuncionarioDTO.getId_funcionario());
            
            pstm.execute();
            pstm.close();
            

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO alterar: " + erro);
        }
    }
        
        public void excluirFuncionario(funcionarioDTO objfuncionarioDTO){
        String sql="delete from tb_funcionario where id_funcionario=?";
        conn = new conexaodaO().conectabD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objfuncionarioDTO.getId_funcionario());
            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Excluir: "+erro);
        }
    }
}
