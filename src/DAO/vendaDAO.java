package DAO;

import DTO.funcionarioDTO;
import DTO.sorveteDTO;
import DTO.vendaDTO;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class vendaDAO {
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        ArrayList<vendaDTO> lista = new ArrayList<>();

        public void cadastrarVenda(vendaDTO objvendaDTO) {
            String sql = "insert into tb_venda(id_venda, cod_funcionario, data_venda, cod_cliente, valor_venda, cod_sorvete, qtd_venda) values (?, ?, ?, ?, ?, ?, ?)";

            conn = new conexaodaO().conectabD();
            

            try {
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, objvendaDTO.getId_venda());
                pstm.setInt(2, objvendaDTO.getCod_funcionario());
                pstm.setString(3, objvendaDTO.getData_venda());
                pstm.setInt(4, objvendaDTO.getCod_cliente());
                pstm.setFloat(5, objvendaDTO.getValor_venda());
                pstm.setInt(6, objvendaDTO.getItem_venda());
                pstm.setInt(7, objvendaDTO.getQtd_venda());
                

                pstm.execute();
                pstm.close();


            } catch (Exception erro) {

                JOptionPane.showMessageDialog(null, "VendaDAO cadastrar: " + erro);
            }

    
    }
        
        public ArrayList<vendaDTO> pesquisarVenda(){
            String sql = "select * from tb_venda";
         conn = new conexaodaO().conectabD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                    vendaDTO objvendaDTO = new vendaDTO();
                    objvendaDTO.setId_venda(rs.getInt("id_venda"));
                    objvendaDTO.setCod_funcionario(rs.getInt("cod_funcionario"));
                    objvendaDTO.setData_venda(rs.getString("data_venda"));
                    objvendaDTO.setCod_cliente(rs.getInt("cod_cliente"));
                    objvendaDTO.setItem_venda(rs.getInt("cod_sorvete"));
                    objvendaDTO.setQtd_venda(rs.getInt("qtd_venda"));
                    objvendaDTO.setValor_venda(rs.getFloat("valor_venda"));
                    
                    
                    lista.add(objvendaDTO);
            }
             
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO Pesquisar: "+erro);
        }
        return lista;
        }
        
        public void alterarVenda(vendaDTO objvendaDTO){
        String sql = "update tb_venda set cod_funcionario=?, cod_cliente=?, data_venda=?, valor_venda=?, cod_sorvete=?, qtd_venda=?  where id_venda=?";
        
        conn = new conexaodaO().conectabD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objvendaDTO.getCod_funcionario());
            pstm.setInt(2, objvendaDTO.getCod_cliente());
            pstm.setString(3, objvendaDTO.getData_venda());
            pstm.setFloat(4, objvendaDTO.getValor_venda());
            pstm.setInt(5, objvendaDTO.getItem_venda());
            pstm.setInt(6, objvendaDTO.getQtd_venda());
            pstm.setInt(7, objvendaDTO.getId_venda());
            
            pstm.execute();
            pstm.close();
            

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "VendaDAO alterar: " + erro);
        }
    }
        
        public void excluirVenda(vendaDTO objvendaDTO){
        String sql="delete from tb_venda where id_venda=?";
        conn = new conexaodaO().conectabD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objvendaDTO.getId_venda());
            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "VendaDAO Excluir: "+erro);
        }
    }
        
        
        
     
        public ResultSet listarCodFun() {
            conn = new conexaodaO().conectabD();

            String sql = "SELECT * FROM tb_funcionario fun ORDER BY fun.id_funcionario";

            try {
                pstm = conn.prepareStatement(sql);

                return pstm.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }
    }
        public ResultSet listarItem() {
            conn = new conexaodaO().conectabD();

            String sql = "SELECT * FROM tb_sorvete sor ORDER BY sor.id_sorvete";

            try {
                pstm = conn.prepareStatement(sql);

                return pstm.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }
    }
        
        public ResultSet listarCodCli() {
            conn = new conexaodaO().conectabD();

            String Sql = "SELECT * FROM tb_cliente cli ORDER BY cli.nome_cliente";

            try {
                pstm = conn.prepareStatement(Sql);

                return pstm.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }
    }
        
     
        
}
