package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


//Glossário
/*
DAO (Data Access Object):
  O DAO é um padrão de projeto que separa a lógica de acesso a dados da lógica de negócios de uma aplicação.

DTO (Data Transfer Object):
  DTO é um objeto que carrega dados entre os processos da aplicação

VIEW:
  A camada VIEW representa a interface do usuário em um aplicativo.

*/

public class Cadastrar_usr {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrar_usr(UsuarioDTO dadosUsr){
    
        String sql = "insert into usuario (cpf, nome, senha, data_nasc, email, tel, id_local) values (?, ?, ?, ?, ?, ?, ?)"; 
        
        
        
        
        
        try{
            
            conn = new SQLConnection().conectaBD();
            
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, dadosUsr.getCpf_usr());
            pstm.setString(2, dadosUsr.getNome_usr());
            pstm.setString(3, dadosUsr.getSenha_usr());
            pstm.setString(4, dadosUsr.getData_usr());
            pstm.setString(5, dadosUsr.getEmail());
            pstm.setString(6, dadosUsr.getTel());
            pstm.setInt(7, dadosUsr.getId_local());
            
            pstm.execute();
            pstm.close();
            
        
        }catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "cadstrarDAO: falha ao INSERIR os dados: " + Erro);
        }
        
    }
    
}
