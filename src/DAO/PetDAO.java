package DAO;

import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import java.sql.Connection;
import DTO.PetDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import petServices.Sessao;

public class PetDAO {

    Connection conn;
    PreparedStatement pstm;

    // ResulteSet = recuperar os dados obtidos de uma consulta SQL
    public void cadPet_Perdido(PetDTO pet_DTO, String usr_cpf) {

        // LEMBRETE >>>>> adicionar local de desaparecimento
        String sql = "insert into animais (nome, tipo, raca, sexo, porte, cor, status_animal, usr_cpf, local_desaparecimento, foto_end) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = new SQLConnection().conectaBD();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, pet_DTO.getNome_pet());
            pstm.setString(2, pet_DTO.getTipo());
            pstm.setString(3, pet_DTO.getRaca());
            pstm.setString(4, pet_DTO.getSexo());
            pstm.setString(5, pet_DTO.getPorte());
            pstm.setString(6, pet_DTO.getCor());
            pstm.setString(7, pet_DTO.getStatus());
            pstm.setString(8, usr_cpf);
            pstm.setInt(9, pet_DTO.getId_local());
            pstm.setString(10, pet_DTO.getFoto_end());

            pstm.execute();
            pstm.close();

        } catch (Exception Erro) {
            JOptionPane.showMessageDialog(null, "PetDAO, Falha ao carregar dados do animal PERDIDO para o banco de dados:  " + Erro);
        }

    }

    public void cadPet_Encontrado(PetDTO pet_DTO, String usr_cpf) {

        // LEMBRETE >>>>> adicionar local de desaparecimento
        String sql = "insert into animais (nome, tipo, raca, sexo, porte, cor, status_animal, usr_cpf, local_encontro, foto_end) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = new SQLConnection().conectaBD();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, pet_DTO.getNome_pet());
            pstm.setString(2, pet_DTO.getTipo());
            pstm.setString(3, pet_DTO.getRaca());
            pstm.setString(4, pet_DTO.getSexo());
            pstm.setString(5, pet_DTO.getPorte());
            pstm.setString(6, pet_DTO.getCor());
            pstm.setString(7, pet_DTO.getStatus());
            pstm.setString(8, usr_cpf);
            pstm.setInt(9, pet_DTO.getId_local());
            pstm.setString(10, pet_DTO.getFoto_end());

            pstm.execute();
            pstm.close();

        } catch (Exception Erro) {
            JOptionPane.showMessageDialog(null, "PetDAO, Falha ao carregar dados do animal ENCONTRADO para o banco de dados: " + Erro);
        }

    }

    public Resultset getAnimais_dados() {

        String sql = "select * from animais;";

        try {

            conn = new SQLConnection().conectaBD();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            return (Resultset) pstm.executeQuery();

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(null, "PetDAO, falha ao recuperar dados dos animais: " + err.getMessage());
            return null;
        }

    }

    public ResultSet getbasedONuser(int id_local, int JlabelsNUM) {

       

        String sql = "SELECT * FROM animais where local_desaparecimento = ? LIMIT ?;";
        
        try {
            
            conn = new SQLConnection().conectaBD();
            pstm = conn.prepareStatement(sql);

            // id_local do usuário conectado em "sessao"
            pstm.setInt(1, id_local);
            pstm.setInt(2, JlabelsNUM);  // Número de JLabels que irão receber o caminho da foto

            /*ResultSet rs = (ResultSet) pstm.executeQuery();
            
            if (!rs.next()) {
                System.out.println("Nenhum resultado encontrado para id_local: " + id_local);
            } else {
                do {
                    System.out.println("PetDAO Caminhos: " + rs.getString("foto_end"));
                } while (rs.next());
            }*/

            return (ResultSet) pstm.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "PetDAO, falha ao recuperar caminho da foto dos animais: " + err.getMessage());
            return null;
        }
    }
    
    
    public ResultSet getEncontrados(int id_local, int JlabelsNUM) {

        String sql = "SELECT * FROM animais WHERE local_encontro = ? LIMIT ?;";
        
        try {
            
            conn = new SQLConnection().conectaBD();
            pstm = conn.prepareStatement(sql);

            // id_local do usuário conectado em "sessao"
            pstm.setInt(1, id_local);
            pstm.setInt(2, JlabelsNUM);  // Número de JLabels que irão receber o caminho da foto


            return (ResultSet) pstm.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "PetDAO, falha ao recuperar caminho da foto dos animais: " + err.getMessage());
            return null;
        }
    }
    
    public ResultSet getAnimalDadosPerdido(String cpf_usr, String animal_nome){
    
        String sql = "Select * from animais where usr_cpf = ? and nome = ?";
        
        try{
            
            conn = new SQLConnection().conectaBD();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setString(1, cpf_usr);
            pstm.setString(2, animal_nome);
            
            return pstm.executeQuery();
        }catch( SQLException err){
            JOptionPane.showMessageDialog(null, "PetDAO, Falha ao recuperar animal baseado em CPF_USR:  "+err);
            
            return null;
        }
    
    }

}
