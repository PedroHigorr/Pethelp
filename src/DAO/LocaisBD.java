package DAO;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LocaisBD {
    
    Connection conn;
    PreparedStatement pstm;
    
    public ResultSet GetCidade(int idEstado){
        String sql = "select * from locais where id_estado = ? ORDER BY cidade;";
        
        try{
            conn = new SQLConnection().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, idEstado);
            
            return (ResultSet) pstm.executeQuery();
            
        }catch (SQLException err){
        
            JOptionPane.showMessageDialog(null,"LocaisBD, Falha ao receber informações dos locais: " + idEstado);
            return null;
        }
    }
    
    //Somente obter as informações do sql
    public ResultSet GetInformationBD() {
        String sql = "Select * from estados ORDER BY id_estado;";

        try {
            conn = new SQLConnection().conectaBD();

            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "LocaisBD, Falha ao receber informações de 'estados': "  + erro);
            
            return null;
        }
    }
    
    public ResultSet getcidadeinfo(){
        
        String sql = "Select * from locais";
        
        try{
            conn = new SQLConnection().conectaBD();
            
            pstm = conn.prepareStatement(sql);
            
            return pstm.executeQuery();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"locaisBD, falha ao receber informações da cidade: " + err);
            return null;
        }
        
    }
}
