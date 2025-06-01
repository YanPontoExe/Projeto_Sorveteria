package DAO;

import DTO.funcionarioDTO;
import DTO.saborDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class saborDAO {
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        ArrayList<saborDTO> lista = new ArrayList<>();

        public void cadastrarSabor(saborDTO objsaborDTO) {
            String sql = "insert into tb_Sabor(descricao_sabor) values (?)";

            conn = new conexaodaO().conectabD();

            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, objsaborDTO.getDescricao_sabor());

                pstm.execute();
                pstm.close();


            } catch (Exception erro) {

                JOptionPane.showMessageDialog(null, "SaborDAO cadastrar: " + erro);
            }

    
    }
        
        public ArrayList<saborDTO> pesquisarSabor(){
            String sql = "select * from tb_sabor";
         conn = new conexaodaO().conectabD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                    saborDTO objsaborDTO = new saborDTO();
                    objsaborDTO.setId_sabor(rs.getInt("id_sabor"));
                    objsaborDTO.setDescricao_sabor(rs.getString("descricao_sabor"));
                    
                    lista.add(objsaborDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "SaborDAO Pesquisar: "+erro);
        }
        return lista;
        }
        
        public void alterarSabor(saborDTO objsaborDTO){
        String sql = "update tb_sabor set descricao_sabor=? where id_sabor=?";
        
        conn = new conexaodaO().conectabD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objsaborDTO.getDescricao_sabor());
            pstm.setInt(2, objsaborDTO.getId_sabor());
            
            pstm.execute();
            pstm.close();
            

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "SaborDAO alterar: " + erro);
        }
    }
        
        public void excluirSabor(saborDTO objsaborDTO){
        String sql="delete from tb_sabor where id_sabor=?";
        conn = new conexaodaO().conectabD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objsaborDTO.getId_sabor());
            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "SaborDAO Excluir: "+erro);
        }
    }
}
