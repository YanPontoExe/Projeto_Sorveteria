package DAO;

import DTO.caldaDTO;
import DTO.funcionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class caldaDAO {
    Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        ArrayList<caldaDTO> lista = new ArrayList<>();

        public void cadastrarCalda(caldaDTO objcaldaDTO) {
            String sql = "insert into tb_calda(descricao_calda, adicional_calda) values (?, ?)";

            conn = new conexaodaO().conectabD();

            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, objcaldaDTO.getDescricao_calda());
                pstm.setString(2, objcaldaDTO.getAdicional_calda());

                pstm.execute();
                pstm.close();


            } catch (Exception erro) {

                JOptionPane.showMessageDialog(null, "CaldaDAO cadastrar: " + erro);
            }

    
    }
        
        public ArrayList<caldaDTO> pesquisarCalda(){
            String sql = "select * from tb_calda";
         conn = new conexaodaO().conectabD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                    caldaDTO objcaldaDTO = new caldaDTO();
                    objcaldaDTO.setId_calda(rs.getInt("id_calda"));
                    objcaldaDTO.setDescricao_calda(rs.getString("descricao_calda"));
                    objcaldaDTO.setAdicional_calda(rs.getString("adicional_calda"));
                    
                    
                    lista.add(objcaldaDTO);
            }
             
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CaldaDAO Pesquisar: "+erro);
        }
        return lista;
        }
        
        public void alterarCalda(caldaDTO objcaldaDTO){
        String sql = "update tb_calda set descricao_calda=?, adicional_calda=?  where id_calda=?";
        
        conn = new conexaodaO().conectabD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcaldaDTO.getDescricao_calda());
            pstm.setString(2, objcaldaDTO.getAdicional_calda());
            pstm.setInt(3, objcaldaDTO.getId_calda());
            
            pstm.execute();
            pstm.close();
            

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "CaldaDAO alterar: " + erro);
        }
    }
        
        public void excluirCalda(caldaDTO objcaldaDTO){
        String sql="delete from tb_calda where id_calda=?";
        conn = new conexaodaO().conectabD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objcaldaDTO.getId_calda());
            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "CaldaDAO Excluir: "+erro);
        }
    }
}
