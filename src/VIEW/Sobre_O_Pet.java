/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.LocaisBD;
import DAO.PetEncontradoCAD;
import DAO.UsuarioDAO;
import DTO.PetDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.ResultSet;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import petServices.AtualizarFotos;
import petServices.Sessao;

/**
 *
 * @author Kalisto
 */
public class Sobre_O_Pet extends javax.swing.JFrame {

    static int tipo;
    static PetDTO pets;

    public Sobre_O_Pet(PetDTO pet, int status) {
        initComponents();
        
        ABOUT_nomeUSR.setText(null);
        ABOUT_txtCIDADE.setText(null);
        ABOUT_txtUF.setText(null);

        tipo = status;
        pets = pet;

        setLayout();

        getPet_info();
        atualizarJLabelsSemRetorno();
        retornaCPF_usr();
    }

    private void getPet_info() {
        
        ABOUT_TXTName.setText(null);
        ABOUT_TXTcor.setText(null);
        ABOUT_TXTraca.setText(null);
        ABOUT_TXTsexo.setText(null);
        ABOUT_txtLOCAL.setText(null);
        ABOUT_BTNencontrei.setText(null);

        ABOUT_TXTcor.setText(pets.getCor());
        ABOUT_TXTName.setText(pets.getNome_pet());
        ABOUT_TXTraca.setText(pets.getRaca());

        if (tipo == 1) {
            ABOUT_txtLOCAL.setText("LOCAL DE DESAPARECIMENTO");
            ABOUT_BTNencontrei.setText("Encontrei!");
        } else {
            ABOUT_txtLOCAL.setText("LOCAL DE ENCONTRO");
            ABOUT_BTNencontrei.setText("Verificar");
        }

        if (pets.getSexo().equals('F')) {
            ABOUT_TXTsexo.setText("Fêmea");
        } else if (pets.getSexo().equals("M")) {
            ABOUT_TXTsexo.setText("Macho");
        }

        

        AtualizarFotos.definirImagemJlabel(ABOUT_PHOTOlabel, pets.getFoto_end());

    }

    private void setLayout() {

        FlatLightLaf.setup();

        Color cor = new Color(201, 213, 181);
        Border border = new LineBorder(cor, 2);

        // Crie um novo JPanel com o fundo colorido
        JPanel backgroundLogin = new JPanel();
        backgroundLogin.setBackground(new Color(255, 255, 255));
        backgroundLogin.setBorder(border);
        backgroundLogin.setOpaque(true);

        // Definindo o layout do JPanel como null para permitir a sobreposição
        backgroundLogin.setLayout(null);

        // Adicione o JPanel como plano de fundo
        backgroundLogin.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLogin);

    }

public void atualizarJLabelsSemRetorno() {
    int id_uf = 0;

    try {
        // Obter informações da cidade
        ResultSet cidadeResultSet = new LocaisBD().getcidadeinfo();
  
        while (cidadeResultSet.next()) {
            int id_local = cidadeResultSet.getInt("id_local");
            
            if (id_local == Integer.parseInt(pets.getLocal_desaparecimento())) {
                String cidade = cidadeResultSet.getString("cidade");
                id_uf = cidadeResultSet.getInt("id_estado");
                // Atualizar o JLabel correspondente
                ABOUT_txtCIDADE.setText(cidade);
                
                cidadeResultSet.close();
                break;
            }
        }

        // Verificar se há cidades e obter informações do estado
        if (id_uf != 0) {
            // Obter informações do estado
            ResultSet estadoResultSet = new LocaisBD().GetInformationBD();

            while (estadoResultSet.next()) {
                if (estadoResultSet.getInt("id_estado") == id_uf) {
                    String uf = estadoResultSet.getString("uf");
                    // Atualizar o JLabel correspondente
                    ABOUT_txtUF.setText(uf);
                    
                    estadoResultSet.close();
                    break;
                }
            }
        }
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Falha ao atualizar JLabels: " + erro);
    }
}

public void retornaCPF_usr(){
    
    String usrCPF = pets.getUsr_cpf();
    String localDES = pets.getLocal_desaparecimento();
    
    try{
       // ResultSet rs = new PetDAO().getAnimalDadosPerdido(pets.getUsr_cpf(), pets.getNome_pet());
        
        //while(rs.next()){
             System.out.println("local des: "+ localDES);
             System.err.println("cpf: " + usrCPF);
            
             if(localDES != null){
               ResultSet usr = new UsuarioDAO().getusrDados(usrCPF);
               
               while(usr.next()){
                
                 if(usr.getString("cpf").equals(usrCPF)){
                
                     ABOUT_nomeUSR.setText(usr.getString("nome"));
                     
                     usr.close();
                     break;
                 }
               }
            }
           
        
        
    }catch(SQLException err){
    
        JOptionPane.showMessageDialog(null, "sobre o pet, falha ao recuperar dados dos usuarios: "  + err.getMessage());
    }

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ABOUT_PHOTOlabel = new javax.swing.JLabel();
        About_perfilPHOTO = new javax.swing.JLabel();
        ABOUT_TXTName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ABOUT_TXTsexo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ABOUT_TXTcor = new javax.swing.JLabel();
        ABOUT_TXTraca = new javax.swing.JLabel();
        ABOUT_txtLOCAL = new javax.swing.JLabel();
        ABOUT_txtUF = new javax.swing.JLabel();
        ABOUT_txtCIDADE = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ABOUT_BTNencontrei = new javax.swing.JButton();
        ABOUT_BTNvoltar = new javax.swing.JButton();
        about_quit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ABOUT_nomeUSR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        ABOUT_PHOTOlabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        About_perfilPHOTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PenguimPerfil.png"))); // NOI18N
        About_perfilPHOTO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        ABOUT_TXTName.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        ABOUT_TXTName.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_TXTName.setText("NOME");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(57, 106, 64));
        jLabel4.setText("SEXO:");

        ABOUT_TXTsexo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ABOUT_TXTsexo.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_TXTsexo.setText("Macho");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 106, 64));
        jLabel5.setText("COR: ");

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(57, 106, 64));
        jLabel6.setText("RAÇA: ");

        ABOUT_TXTcor.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ABOUT_TXTcor.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_TXTcor.setText("Azul");

        ABOUT_TXTraca.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ABOUT_TXTraca.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_TXTraca.setText("Pinscher");

        ABOUT_txtLOCAL.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ABOUT_txtLOCAL.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_txtLOCAL.setText("LOCAL DE DESAPARECIMENTO");

        ABOUT_txtUF.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ABOUT_txtUF.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_txtUF.setText("UF");

        ABOUT_txtCIDADE.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ABOUT_txtCIDADE.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_txtCIDADE.setText("CIDADE");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CadIcon.png"))); // NOI18N

        ABOUT_BTNencontrei.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ABOUT_BTNencontrei.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_BTNencontrei.setText("Encontrei");
        ABOUT_BTNencontrei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABOUT_BTNencontreiActionPerformed(evt);
            }
        });

        ABOUT_BTNvoltar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ABOUT_BTNvoltar.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_BTNvoltar.setText("Voltar");
        ABOUT_BTNvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABOUT_BTNvoltarActionPerformed(evt);
            }
        });

        about_quit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/quit2.png"))); // NOI18N
        about_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_quitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 106, 64));
        jLabel1.setText("Anunciante");

        ABOUT_nomeUSR.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        ABOUT_nomeUSR.setText("nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ABOUT_nomeUSR)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ABOUT_txtUF)
                        .addGap(37, 37, 37)
                        .addComponent(ABOUT_txtCIDADE)
                        .addGap(94, 94, 94))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ABOUT_PHOTOlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(About_perfilPHOTO))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(ABOUT_TXTName))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ABOUT_TXTcor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ABOUT_TXTsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ABOUT_TXTraca, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 3, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(about_quit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ABOUT_BTNvoltar)
                                        .addGap(18, 18, 18)
                                        .addComponent(ABOUT_BTNencontrei)
                                        .addGap(16, 16, 16))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(ABOUT_txtLOCAL)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(about_quit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ABOUT_TXTName))
                        .addGap(18, 18, 18)
                        .addComponent(ABOUT_txtLOCAL))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(ABOUT_TXTsexo)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ABOUT_PHOTOlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addComponent(About_perfilPHOTO))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ABOUT_TXTcor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ABOUT_TXTraca))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ABOUT_txtUF)
                    .addComponent(ABOUT_txtCIDADE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ABOUT_nomeUSR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ABOUT_BTNencontrei)
                    .addComponent(ABOUT_BTNvoltar))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void about_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_quitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_about_quitActionPerformed

    private void ABOUT_BTNvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABOUT_BTNvoltarActionPerformed
        dispose();

        telaInicial tl = new telaInicial();
        tl.setVisible(true);
    }//GEN-LAST:event_ABOUT_BTNvoltarActionPerformed

    private void ABOUT_BTNencontreiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABOUT_BTNencontreiActionPerformed
       
        Sessao sessao = Sessao.getInstance();
        String usr;
        
        PetEncontradoCAD pe = new PetEncontradoCAD();
        usr = sessao.getLoggedUserCPF();
        
        pe.cadastrarUmEncontro(pets, usr);
        
        JOptionPane.showMessageDialog(null, "Dados enviado ao usuario, o usuario entrará em contato");
        
        dispose();
        
        telaInicial tl = new telaInicial();
        
        tl.setVisible(true);
    }//GEN-LAST:event_ABOUT_BTNencontreiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sobre_O_Pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sobre_O_Pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sobre_O_Pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sobre_O_Pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sobre_O_Pet(pets, tipo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ABOUT_BTNencontrei;
    private javax.swing.JButton ABOUT_BTNvoltar;
    private javax.swing.JLabel ABOUT_PHOTOlabel;
    private javax.swing.JLabel ABOUT_TXTName;
    private javax.swing.JLabel ABOUT_TXTcor;
    private javax.swing.JLabel ABOUT_TXTraca;
    private javax.swing.JLabel ABOUT_TXTsexo;
    private javax.swing.JLabel ABOUT_nomeUSR;
    private javax.swing.JLabel ABOUT_txtCIDADE;
    private javax.swing.JLabel ABOUT_txtLOCAL;
    private javax.swing.JLabel ABOUT_txtUF;
    private javax.swing.JLabel About_perfilPHOTO;
    private javax.swing.JButton about_quit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
