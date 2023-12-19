package DAO;

import DTO.PetDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PetEncontradoCAD {

    Connection conn;
    PreparedStatement pstm;

    public void cadastrarUmEncontro(PetDTO pets, String usr_cpf) {

        String SQL = "Insert into encontrados_usuario (usr_cpf_encontrou, usr_cpf_dono_pet, id_pet_encontrado, pets_encontrados) values (?, ?, ?, ?)";
        int i = 0;

        String petID;

        try {

            petID = returnPetId(pets);

            i++;
            conn = new SQLConnection().conectaBD();
            pstm = conn.prepareStatement(SQL);

            pstm.setString(1, usr_cpf);
            pstm.setString(2, pets.getUsr_cpf());
            pstm.setString(3, petID);
            pstm.setInt(4, i);

            System.out.println("USR CPF: " + usr_cpf + "pet usuario: " + pets.getUsr_cpf() + "ID pet" + petID);

            int rowsAffected = pstm.executeUpdate();

            // Verificar se a inserção foi bem-sucedida
            if (rowsAffected > 0) {
                System.out.println("Inserção bem-sucedida!");
            } else {
                System.out.println("Nenhuma linha afetada. Inserção falhou.");
            }
        } catch (SQLException err) {
            if (err.getSQLState().equals("23000")) {
                // Tratar a violação da restrição única
                JOptionPane.showMessageDialog(null, "Cadastro já foi feito.");
            } else {
                // Outro tratamento para exceções SQL
                JOptionPane.showMessageDialog(null, "Sobre o Pet, Falha ao cadastrar pet: " + err.getMessage());
            }
        } finally {
            // Certificar-se de fechar a conexão e a declaração preparada
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String returnPetId(PetDTO pet) {

        String animal_nome, dono_cpf, id_animal = null;

        animal_nome = pet.getNome_pet();
        dono_cpf = pet.getUsr_cpf();

        try {

            ResultSet rs = (ResultSet) new PetDAO().getAnimais_dados();

            while (rs.next()) {

                if (dono_cpf.equals(rs.getString("usr_cpf")) && animal_nome.equals(rs.getString("nome"))) {

                    id_animal = rs.getString("id_pet");

                    rs.close();

                    break;
                }

            }

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(null, "PetEcontradoCAD, falha ao consultar tabela animais: " + err);
            return null;
        }
        return id_animal;
    }
    
    public ResultSet checarTabela(String cpfusr){
        
        String sql = "Select * from encontrados_usuario where usr_cpf_dono_pet = ?";
        
        try{
            conn = new SQLConnection().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, cpfusr);
            
            ResultSet rs = pstm.executeQuery();
             
            return  rs;
        }catch(SQLException err){
            
            JOptionPane.showMessageDialog(null, "PetEncontradoCAD, falha ao recuperar dados da tabela: " + err);
            return null;
        }
    }

}
