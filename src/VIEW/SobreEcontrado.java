package VIEW;

import DAO.LocaisBD;
import DAO.UsuarioDAO;
import DTO.PetDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import petServices.AtualizarFotos;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SobreEcontrado extends javax.swing.JFrame {

    static PetDTO pet;

    public SobreEcontrado(PetDTO pets) {
        pet = pets;
        initComponents();

        setLayout();
        atualizarComponente();
        atualizarJLabelsSemRetorno();
        retornaCPF_usr();

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

    public void atualizarComponente() {

        TXT_NOMEanimal.setText(null);
        TXT_RACA.setText(null);
        TXT_COR.setText(null);

        TXT_NOMEanimal.setText(pet.getNome_pet());
        TXT_RACA.setText(pet.getRaca());
        TXT_COR.setText(pet.getCor());

        if (pet.getSexo().equals('F')) {
            TXT_SEXO.setText("Fêmea");
        } else if (pet.getSexo().equals("M")) {
            TXT_SEXO.setText("Macho");
        }

        AtualizarFotos.definirImagemJlabel(label_PHOTO, pet.getFoto_end());
    }

    public void atualizarJLabelsSemRetorno() {
        int id_uf = 0;

        TXT_CIDADE.setText(null);
        TXT_UF.setText(null);

        try {
            // Obter informações da cidade
            ResultSet cidadeResultSet = new LocaisBD().getcidadeinfo();

            while (cidadeResultSet.next()) {
                int id_local = cidadeResultSet.getInt("id_local");

                if (id_local == Integer.parseInt(pet.getLocal_econtro())) {
                    String cidade = cidadeResultSet.getString("cidade");
                    id_uf = cidadeResultSet.getInt("id_estado");
                    // Atualizar o JLabel correspondente
                    TXT_CIDADE.setText(cidade);

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
                        TXT_UF.setText(uf);

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
    
    String usrCPF = pet.getUsr_cpf();
    String localDES = pet.getLocal_econtro();
    
    try{
       
             System.out.println("local des: "+ localDES);
             System.err.println("cpf: " + usrCPF);
            
             if(localDES != null){
               ResultSet usr = new UsuarioDAO().getusrDados(usrCPF);
               
               while(usr.next()){
                
                 if(usr.getString("cpf").equals(usrCPF)){
                
                     TXT_NOME_usr.setText(usr.getString("nome"));
                     TXT_TEL.setText(usr.getString("tel"));
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

        label_PHOTO = new javax.swing.JLabel();
        label_usrPHOTO = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXT_NOME_usr = new javax.swing.JLabel();
        TXT_NOMEanimal = new javax.swing.JLabel();
        ABOUT_TXTName1 = new javax.swing.JLabel();
        ABOUT_TXTName2 = new javax.swing.JLabel();
        ABOUT_TXTName3 = new javax.swing.JLabel();
        TXT_SEXO = new javax.swing.JLabel();
        TXT_COR = new javax.swing.JLabel();
        TXT_RACA = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BTN_QUIT = new javax.swing.JButton();
        TXT_LOCAL = new javax.swing.JLabel();
        TXT_UF = new javax.swing.JLabel();
        TXT_CIDADE = new javax.swing.JLabel();
        ABOUT_BTNvoltar = new javax.swing.JButton();
        BTN_meuPET = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TXT_TEL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        label_PHOTO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        label_usrPHOTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PenguimPerfil.png"))); // NOI18N
        label_usrPHOTO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(57, 106, 64));
        jLabel3.setText("Anuciante");

        TXT_NOME_usr.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        TXT_NOME_usr.setText("nome");

        TXT_NOMEanimal.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        TXT_NOMEanimal.setForeground(new java.awt.Color(57, 106, 64));
        TXT_NOMEanimal.setText("NOME");

        ABOUT_TXTName1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ABOUT_TXTName1.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_TXTName1.setText("SEXO: ");

        ABOUT_TXTName2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ABOUT_TXTName2.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_TXTName2.setText("COR: ");

        ABOUT_TXTName3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ABOUT_TXTName3.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_TXTName3.setText("RAÇA: ");

        TXT_SEXO.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        TXT_SEXO.setForeground(new java.awt.Color(57, 106, 64));
        TXT_SEXO.setText("Macho");

        TXT_COR.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        TXT_COR.setForeground(new java.awt.Color(57, 106, 64));
        TXT_COR.setText("Azul");

        TXT_RACA.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        TXT_RACA.setForeground(new java.awt.Color(57, 106, 64));
        TXT_RACA.setText("Pischer");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CadIcon.png"))); // NOI18N

        BTN_QUIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/quit2.png"))); // NOI18N
        BTN_QUIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_QUITActionPerformed(evt);
            }
        });

        TXT_LOCAL.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXT_LOCAL.setForeground(new java.awt.Color(57, 106, 64));
        TXT_LOCAL.setText("LOCAL DE DESAPARECIMENTO");

        TXT_UF.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXT_UF.setForeground(new java.awt.Color(57, 106, 64));
        TXT_UF.setText("UF");

        TXT_CIDADE.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXT_CIDADE.setForeground(new java.awt.Color(57, 106, 64));
        TXT_CIDADE.setText("CIDADE");

        ABOUT_BTNvoltar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ABOUT_BTNvoltar.setForeground(new java.awt.Color(57, 106, 64));
        ABOUT_BTNvoltar.setText("Voltar");
        ABOUT_BTNvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABOUT_BTNvoltarActionPerformed(evt);
            }
        });

        BTN_meuPET.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        BTN_meuPET.setForeground(new java.awt.Color(57, 106, 64));
        BTN_meuPET.setText("Meu pet");
        BTN_meuPET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_meuPETActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 106, 64));
        jLabel1.setText("Contato");

        TXT_TEL.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        TXT_TEL.setText("tel..");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_usrPHOTO)
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ABOUT_TXTName3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_RACA, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ABOUT_TXTName2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_COR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TXT_NOME_usr, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_PHOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_NOMEanimal)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ABOUT_TXTName1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_SEXO, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1)
                    .addComponent(TXT_TEL, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(ABOUT_BTNvoltar)
                                .addGap(18, 18, 18)
                                .addComponent(BTN_meuPET))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TXT_LOCAL)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(BTN_QUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(TXT_UF)
                        .addGap(33, 33, 33)
                        .addComponent(TXT_CIDADE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXT_LOCAL)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TXT_CIDADE)
                                    .addComponent(TXT_UF)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(label_PHOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_usrPHOTO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(TXT_NOMEanimal)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ABOUT_TXTName1)
                            .addComponent(TXT_SEXO))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ABOUT_TXTName2)
                            .addComponent(TXT_COR))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ABOUT_TXTName3)
                            .addComponent(TXT_RACA)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTN_QUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TXT_NOME_usr)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_meuPET)
                            .addComponent(ABOUT_BTNvoltar))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_TEL)
                        .addContainerGap(14, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_QUITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_QUITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BTN_QUITActionPerformed

    private void ABOUT_BTNvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABOUT_BTNvoltarActionPerformed
        dispose();

        telaInicial tl = new telaInicial();
        tl.setVisible(true);
    }//GEN-LAST:event_ABOUT_BTNvoltarActionPerformed

    private void BTN_meuPETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_meuPETActionPerformed


    }//GEN-LAST:event_BTN_meuPETActionPerformed

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
            java.util.logging.Logger.getLogger(SobreEcontrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SobreEcontrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SobreEcontrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SobreEcontrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SobreEcontrado(pet).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ABOUT_BTNvoltar;
    private javax.swing.JLabel ABOUT_TXTName1;
    private javax.swing.JLabel ABOUT_TXTName2;
    private javax.swing.JLabel ABOUT_TXTName3;
    private javax.swing.JButton BTN_QUIT;
    private javax.swing.JButton BTN_meuPET;
    private javax.swing.JLabel TXT_CIDADE;
    private javax.swing.JLabel TXT_COR;
    private javax.swing.JLabel TXT_LOCAL;
    private javax.swing.JLabel TXT_NOME_usr;
    private javax.swing.JLabel TXT_NOMEanimal;
    private javax.swing.JLabel TXT_RACA;
    private javax.swing.JLabel TXT_SEXO;
    private javax.swing.JLabel TXT_TEL;
    private javax.swing.JLabel TXT_UF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel label_PHOTO;
    private javax.swing.JLabel label_usrPHOTO;
    // End of variables declaration//GEN-END:variables
}
