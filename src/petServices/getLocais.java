package petServices;

import DAO.LocaisBD;
import DTO.PetDTO;
import com.mysql.cj.xdevapi.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class getLocais {

    public void getCidadesByEstado(int idEstado, JComboBox<String> cidades) {

        cidades.removeAllItems();
        try {
            LocaisBD locais = new LocaisBD();
            ResultSet rs = (ResultSet) locais.GetCidade(idEstado);

            while (rs.next()) {
                cidades.addItem(rs.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO_VIEW_CAD: Erro ao carregar CIDADES: " + e.getMessage());
        }

    }

    //Carregar estados do SQL para a ComboBox
    public void getEstados(Vector<Integer> estados, JComboBox<String> uf) {

        try {
            //Instancianto um obj da usrDAO e um obj ResultSet
            LocaisBD locais = new LocaisBD();
            ResultSet rs = (ResultSet) locais.GetInformationBD();

            // Enquanto houver linhas no banco de dados ele irá 
            // Edicionar um elemento no vetor e
            // Uma descrição deste elemento na combo box
            while (rs.next()) {
                //Adiciona um elemento no vetor
                estados.addElement(rs.getInt(1));
                //Adiciona um elemento na comboBox
                uf.addItem(rs.getString(3));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar ESTADOS na comboBox: " + e.getMessage());
        }

    }

    public static int getIdLocal(String uf, String cidade) {
        int idLocal = -1;

        try {
            LocaisBD locais = new LocaisBD();
            ResultSet rs = (ResultSet) locais.GetInformationBD();

            while (rs.next()) {
                if (uf.equals(rs.getString("uf"))) {
                    int idEstado = rs.getInt(1);
                    

                    ResultSet rsCidade = (ResultSet) locais.GetCidade(idEstado);

                    while (rsCidade.next()) {
                        if (cidade.equals(rsCidade.getString("cidade"))) {
                            idLocal = rsCidade.getInt(1);
                            
                            break;
                        }
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao CONFERIR locais: " + e.getMessage());
        }

        return idLocal;
    }
    
}


//Código para o tratamento do get idlocal quando ele for chamado
/*

int idLocal = getLocais.getIdLocal(uf, cidade);

if (idLocal != -1) {
    dados.setId_local(idLocal);
    // faça o que precisar com o idLocal
} else {
    // lidar com o caso em que o idLocal não foi encontrado
}

*/


//Antiga conferencia de local:

/*
    public void confereLocal(String uf, String cidade, PetDTO dados) {
    int id_estado = -1;
    int id_local = -1;

    try {
        LocaisBD locais = new LocaisBD();
        ResultSet rs = (ResultSet) locais.GetInformationBD();

        while (rs.next()) {
            if (uf.equals(rs.getString("uf"))) {
                id_estado = rs.getInt(1);
                break;
            }
        }

        if (id_estado != -1) {
            System.out.println("UF: " + uf);
            System.out.println("ID Estado: " + id_estado);

            ResultSet rsCidade = (ResultSet) locais.GetCidade(id_estado);

            while (rsCidade.next()) {
                if (cidade.equals(rsCidade.getString("cidade"))) {
                    id_local = rsCidade.getInt(1);
                    break;
                }
            }
        }

        if (id_local != -1) {
            System.out.println("Cidade: " + cidade);
            System.out.println("ID Local: " + id_local);
            dados.setId_local(id_local);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao CONFERIR locais: " + e.getMessage());
    }
}


    
}*/
//Método ultilizado originalmente na VIEW cadScreen;

/* private void getCidadesByEstado(int idEstado) {

        CadComboCIDADE_VIEW.removeAllItems();

        try {
            UsuarioDAO usrD = new UsuarioDAO();
            ResultSet rs = (ResultSet) usrD.GetCidade(idEstado);

            while (rs.next()) {
                CadComboCIDADE_VIEW.addItem(rs.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO_VIEW_CAD: Erro ao carregar cidades " + e.getMessage());
        }

    }*/

   /* //Carregar estados do SQL para a ComboBox
    private void getEstados(){
    
        try{
        //Instancianto um obj da usrDAO e um obj ResultSet
        UsuarioDAO usr = new UsuarioDAO(); 
        ResultSet rs = (ResultSet) usr.GetInformationBD();
        
        // Enquanto houver linhas no banco de dados ele irá 
        // Edicionar um elemento no vetor e
        // Uma descrição deste elemento na combo box
        while(rs.next()){
            //Adiciona um elemento no vetor
            estados.addElement(rs.getInt(1));
            //Adiciona um elemento na comboBox
            cadComboUF_VIEW.addItem(rs.getString(3));
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao carregar ComboBOX " +e.getMessage());
        }
        
        System.out.println("Index selecionado: " + cadComboUF_VIEW.getSelectedIndex());
       
    }
    */
