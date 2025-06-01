package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexaodaO {
    public Connection conectabD(){  /*criou o método publico de tipo Connection, chamado conectaBD*/
        Connection conn=null;       /*declarou uma variável do tipo connection, chamada conn*/
        
        try {
            String url="jdbc:mysql://localhost:3306/sorveteria?user=root&password=";    /*criou uma variável do tipo String e atribuiu o endereço do banco de dados*/
            conn = DriverManager.getConnection(url);    /*criou a variável conn e atribuiu o sql DriverManager*/
            
        } catch (SQLException erro) {       /*menssagem de erro, produzida pelo próprio sistema*/
            JOptionPane.showMessageDialog(null, "Conexao DAO 7 Funcionario "+erro.getMessage());   /*exibição personalizada da menssagem de erro, produzida anteriormente pelo próprio sistema*/
        }
        return conn;    /*retorno da variável conn*/
    }
}
