package DAO;

import DTO.clienteDTO;
import DTO.funcionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class clienteDAO {   
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        ArrayList<clienteDTO> lista = new ArrayList<>();

        public void cadastrarCliente(clienteDTO objclienteDTO) {
            String sql = "insert into tb_cliente(nome_cliente, cpf_cliente, endereco_cliente, telefone_cliente) values (?, ?, ?, ?)";

            conn = new conexaodaO().conectabD();

            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, objclienteDTO.getNome_cliente());
                pstm.setString(2, objclienteDTO.getCpf_cliente());
                pstm.setString(3, objclienteDTO.getEndereco_cliente());
                pstm.setString(4, objclienteDTO.getTelefone_cliente());

                pstm.execute();
                pstm.close();


            } catch (Exception erro) {

                JOptionPane.showMessageDialog(null, "ClienteDAO cadastrar: " + erro);
            }

    
    }
        
        public void alterarCliente(clienteDTO objclienteDTO){
        String sql = "update tb_cliente set nome_cliente=?, endereco_cliente=?, telefone_cliente=? where cpf_cliente=?";
        
        conn = new conexaodaO().conectabD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objclienteDTO.getNome_cliente());
            pstm.setString(2, objclienteDTO.getEndereco_cliente());
            pstm.setString(3, objclienteDTO.getTelefone_cliente());
            pstm.setString(4, objclienteDTO.getCpf_cliente());
            
            
            pstm.execute();
            pstm.close();
            

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "ClienteDAO alterar: " + erro);
        }
    }
        
        public ArrayList<clienteDTO> pesquisarCliente(){
            String sql = "select * from tb_cliente";
         conn = new conexaodaO().conectabD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                    clienteDTO objclienteDTO = new clienteDTO();
                    
                    objclienteDTO.setId_cliente(rs.getInt("id_cliente"));
                    objclienteDTO.setNome_cliente(rs.getNString("nome_cliente"));
                    objclienteDTO.setCpf_cliente(rs.getNString("cpf_cliente"));
                    objclienteDTO.setEndereco_cliente(rs.getNString("endereco_cliente"));
                    objclienteDTO.setTelefone_cliente(rs.getNString("telefone_cliente"));
                    
                    lista.add(objclienteDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO Pesquisar: "+erro);
        }
        return lista;
        }
        
        public void excluirCliente(clienteDTO objclienteDTO){
        String sql="delete from tb_cliente where id_cliente=?";
        conn = new conexaodaO().conectabD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objclienteDTO.getId_cliente());
            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "ClienteDAO Excluir: "+erro);
        }
    }
        
}
