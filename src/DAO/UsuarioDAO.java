package DAO;

//Glossário
/*
DAO (Data Access Object):
  O DAO é um padrão de projeto que separa a lógica de acesso a dados da lógica de negócios de uma aplicação.

DTO (Data Transfer Object):
  DTO é um objeto que carrega dados entre os processos da aplicação

VIEW:
  A camada VIEW representa a interface do usuário em um aplicativo.

 */
import DTO.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class UsuarioDAO {

    Connection conn;
    PreparedStatement pstm;

    // ResulteSet = recuperar os dados obtidos de uma consulta SQL
    public ResultSet autenticacaoUsr(UsuarioDTO UsrDTO) throws SQLException {

        //Toda vez que a var Conn for chamada ela irá conectar no sql
        conn = new SQLConnection().conectaBD();

        try {
            String SQL = "Select * from usuario where nome = ? and senha = ?";

            //PreparedStatment = permite consultas sql predefinidas
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, UsrDTO.getNome_usr());
            pstm.setString(2, UsrDTO.getSenha_usr());

            ResultSet rs = (ResultSet) pstm.executeQuery();

            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }

    }
    
    public ResultSet getusrDados(String cpf_usr){
        
        String sql = "select * from usuario where cpf = ?";
        
        try{
            
            conn = new SQLConnection().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, cpf_usr);

            ResultSet rs = pstm.executeQuery();
            
            return rs;
        }catch(SQLException err){
        
            JOptionPane.showMessageDialog(null,"UsuarioDAO, Falha ao recuperar dados do usuario apartir do cpf: "+ err);
            return null;
        }
    }

   /* public Resultset GetCidade(int idEstado){
        String sql = "select * from locais where id_estado = ? ORDER BY cidade;";
        
        try{
            conn = new SQLConnection().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, idEstado);
            
            return (Resultset) pstm.executeQuery();
            
        }catch (SQLException err){
        
            System.out.println("ERRO " + err.getMessage());
            return null;
        }
    }
    
    //Somente obter as informações do sql
    public Resultset GetInformationBD() {
        String sql = "Select * from estados ORDER BY id_estado;";

        try {
            conn = new SQLConnection().conectaBD();

            pstm = conn.prepareStatement(sql);
            return (Resultset) pstm.executeQuery();

        } catch (SQLException erro) {

            System.out.println("ERRO " + erro.getMessage());
            return null;
        }
    }
*/
}
