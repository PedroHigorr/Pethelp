package DAO;


//Glossário:

/*
DAO (Data Access Object):
  O DAO é um padrão de projeto que separa a lógica de acesso a dados da lógica de negócios de uma aplicação.

DTO (Data Transfer Object):
  DTO é um objeto que carrega dados entre os processos da aplicação

VIEW:
  A camada VIEW representa a interface do usuário em um aplicativo.

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    
    public Connection conectaBD()throws SQLException{
        
        try {
            
             Class.forName("com.mysql.cj.jdbc.Driver");
             
             String url ="jdbc:mysql://localhost:3306/PetHelp?user=root&password=";
             String user = "root";
             String password = "";
            
             return DriverManager.getConnection(url, user, password);
             
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
}
