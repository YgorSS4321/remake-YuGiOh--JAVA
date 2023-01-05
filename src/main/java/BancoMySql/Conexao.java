package BancoMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ygor
 * esta classe é  responsável pela conexao entre o codigo java
 * e o banco de dados em mysql
 */
public class Conexao {
    
    public static Connection getConnection(){
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            
            String user = "teste2";
            String password = "12345678";
            String url =  "jdbc:mysql://localhost:3306/BANCO";
            
            return DriverManager.getConnection(url, user, password);
            
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
}
