package DAO;

import DTO.funcionarioDTO;
import DTO.sorveteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class sorveteDAO {
    Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        ArrayList<sorveteDTO> lista = new ArrayList<>();
    private int cod_calda;

        public void cadastrarSorvete(sorveteDTO objsorveteDTO) {
            String sql = "insert into tb_sorvete(preco_sorvete, sabor_sorvete) values (?, ?)";

            conn = new conexaodaO().conectabD();

            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, objsorveteDTO.getPreco_sorvete());
                pstm.setString(2, objsorveteDTO.getSabor_sorvete());
                
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso! ");

                pstm.execute();
                pstm.close();


            } catch (Exception erro) {

                JOptionPane.showMessageDialog(null, "SorveteDAO cadastrar: " + erro);
            }

    
    }
        
        public ArrayList<sorveteDTO> pesquisarSorvete(){
            String sql = "select * from tb_sorvete";
         conn = new conexaodaO().conectabD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                    sorveteDTO objsorveteDTO = new sorveteDTO();
                    objsorveteDTO.setId_sorvete(rs.getInt("id_sorvete"));
                    objsorveteDTO.setPreco_sorvete(rs.getString("preco_sorvete"));
                    objsorveteDTO.setSabor_sorvete(rs.getString("sabor_sorvete"));
                    
                    
                    lista.add(objsorveteDTO);
            }
             
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "SorveteDAO Pesquisar: "+erro);
        }
        return lista;
        }
        
   
        public void alterarSorvete(sorveteDTO objsorveteDTO){
        String sql = "update tb_sorvete set preco_sorvete=?, sabor_sorvete=?  where id_sorvete=?";
        
        conn = new conexaodaO().conectabD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(0, objsorveteDTO.getPreco_sorvete());
            pstm.setString(1, objsorveteDTO.getSabor_sorvete());
            pstm.setInt(2, objsorveteDTO.getId_sorvete());
            
            pstm.execute();
            pstm.close();
            

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "SorveteDAO alterar: " + erro);
        }
    }
        
        public void excluirSorvete(sorveteDTO objsorveteDTO){
        String sql="delete from tb_sorvete where id_sorvete=?";
        conn = new conexaodaO().conectabD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objsorveteDTO.getId_sorvete());
            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "SorveteDAO Excluir: "+erro);
        }
    }
        
        

    

    
}


