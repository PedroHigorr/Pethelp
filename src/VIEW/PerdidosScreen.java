package VIEW;

import petServices.AtualizarFotos;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import petServices.Sessao;

/**
 *
 * @author Kalisto
 */
public class PerdidosScreen extends javax.swing.JFrame {

    public PerdidosScreen() {
        initComponents();

        setLayout();

        carregarFotosAnimais();
        
        
    }

    private void setLayout() {

        FlatLightLaf.setup();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crie um novo JPanel com o fundo colorido
        JPanel backgroundLogin = new JPanel();
        backgroundLogin.setBackground(new Color(201, 213, 181));
        backgroundLogin.setOpaque(true);

        // Definindo o layout do JPanel como null para permitir a sobreposição
        backgroundLogin.setLayout(null);

        // Adicione o JPanel como plano de fundo
        backgroundLogin.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLogin);
    }

    private void carregarFotosAnimais() {
        int i = 1;
        int id_local = Sessao.getInstance().getLoggedUserLocationID();
        List<JLabel> labels = List.of(Photo_1, Photo_2, Photo_3, Photo_4, Photo_5, Photo_6);

        AtualizarFotos.loadAnimalPhotos(id_local, labels, i);
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CheckPequeno = new javax.swing.JCheckBox();
        CheckMedio = new javax.swing.JCheckBox();
        CheckGrande = new javax.swing.JCheckBox();
        CheckMacho = new javax.swing.JCheckBox();
        CheckFemea = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Photo_1 = new javax.swing.JLabel();
        sobreBTN_1 = new javax.swing.JButton();
        Photo_2 = new javax.swing.JLabel();
        Photo_3 = new javax.swing.JLabel();
        sobreBTN_2 = new javax.swing.JButton();
        sobreBTN_3 = new javax.swing.JButton();
        Photo_4 = new javax.swing.JLabel();
        Photo_5 = new javax.swing.JLabel();
        Photo_6 = new javax.swing.JLabel();
        sobreBTN_4 = new javax.swing.JButton();
        sobreBTN_5 = new javax.swing.JButton();
        sobreBTN_6 = new javax.swing.JButton();
        ProxBTN = new javax.swing.JButton();
        VoltarBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 213, 181), 1, true));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 106, 64));
        jLabel2.setText("PORTE");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(57, 106, 64));
        jLabel3.setText("SEXO");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(57, 106, 64));
        jLabel4.setText("BUSCA");

        CheckPequeno.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        CheckPequeno.setForeground(new java.awt.Color(57, 106, 64));
        CheckPequeno.setText("Pequeno");

        CheckMedio.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        CheckMedio.setForeground(new java.awt.Color(57, 106, 64));
        CheckMedio.setText("Médio");

        CheckGrande.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        CheckGrande.setForeground(new java.awt.Color(57, 106, 64));
        CheckGrande.setText("Grande");

        CheckMacho.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        CheckMacho.setForeground(new java.awt.Color(57, 106, 64));
        CheckMacho.setText("Macho");

        CheckFemea.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        CheckFemea.setForeground(new java.awt.Color(57, 106, 64));
        CheckFemea.setText("Femea");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 106, 64));
        jLabel5.setText("Cidade onde se perdeu");

        jButton9.setForeground(new java.awt.Color(57, 106, 64));
        jButton9.setText("Atualizar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckMacho))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(CheckGrande)
                            .addComponent(CheckMedio)
                            .addComponent(CheckPequeno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CheckFemea))))
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButton9)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckPequeno)
                    .addComponent(CheckMacho))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckMedio)
                    .addComponent(CheckFemea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckGrande)
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(39, 39, 39))
        );

        jButton7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(57, 106, 64));
        jButton7.setText("GATO");

        jButton8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(57, 106, 64));
        jButton8.setText("CACHORRO");

        Photo_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        sobreBTN_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        sobreBTN_1.setForeground(new java.awt.Color(57, 106, 64));
        sobreBTN_1.setText("Sobre");

        Photo_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        Photo_3.setBackground(new java.awt.Color(201, 213, 181));
        Photo_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        sobreBTN_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        sobreBTN_2.setForeground(new java.awt.Color(57, 106, 64));
        sobreBTN_2.setText("Sobre");

        sobreBTN_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        sobreBTN_3.setForeground(new java.awt.Color(57, 106, 64));
        sobreBTN_3.setText("Sobre");
        sobreBTN_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobreBTN_3ActionPerformed(evt);
            }
        });

        Photo_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        Photo_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        Photo_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        sobreBTN_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        sobreBTN_4.setForeground(new java.awt.Color(57, 106, 64));
        sobreBTN_4.setText("Sobre");

        sobreBTN_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        sobreBTN_5.setForeground(new java.awt.Color(57, 106, 64));
        sobreBTN_5.setText("Sobre");

        sobreBTN_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        sobreBTN_6.setForeground(new java.awt.Color(57, 106, 64));
        sobreBTN_6.setText("Sobre");

        ProxBTN.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ProxBTN.setForeground(new java.awt.Color(57, 106, 64));
        ProxBTN.setText("Próximo");

        VoltarBTN.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        VoltarBTN.setForeground(new java.awt.Color(57, 106, 64));
        VoltarBTN.setText("Voltar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(sobreBTN_4)
                .addGap(80, 80, 80)
                .addComponent(sobreBTN_5)
                .addGap(80, 80, 80)
                .addComponent(sobreBTN_6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(Photo_4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Photo_5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Photo_6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProxBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VoltarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(sobreBTN_1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Photo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(sobreBTN_2)
                                .addGap(80, 80, 80)
                                .addComponent(sobreBTN_3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Photo_2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Photo_3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton8))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Photo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Photo_2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Photo_3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sobreBTN_1)
                            .addComponent(sobreBTN_2)
                            .addComponent(sobreBTN_3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Photo_4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Photo_5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Photo_6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(VoltarBTN)
                                .addGap(18, 18, 18)
                                .addComponent(ProxBTN))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sobreBTN_4)
                    .addComponent(sobreBTN_5)
                    .addComponent(sobreBTN_6))
                .addGap(31, 31, 31))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LogoPrincipal.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(201, 213, 181));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(57, 106, 64));
        jButton1.setText("Inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(201, 213, 181));
        jButton2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(57, 106, 64));
        jButton2.setText("Perdidos");

        jButton3.setBackground(new java.awt.Color(201, 213, 181));
        jButton3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(57, 106, 64));
        jButton3.setText("Cadastrar Pet");

        jButton4.setBackground(new java.awt.Color(201, 213, 181));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/quit2.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(201, 213, 181));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PenguimPerfil.png"))); // NOI18N
        jButton5.setBorderPainted(false);

        jButton6.setBackground(new java.awt.Color(201, 213, 181));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Black_alert.png"))); // NOI18N
        jButton6.setBorderPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addComponent(jButton2)
                        .addGap(50, 50, 50)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addGap(42, 42, 42)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(5, 5, 5)
                                .addComponent(jButton5))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void sobreBTN_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobreBTN_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sobreBTN_3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();

        telaInicial tl = new telaInicial();

        tl.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      
    }//GEN-LAST:event_jButton9ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerdidosScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckFemea;
    private javax.swing.JCheckBox CheckGrande;
    private javax.swing.JCheckBox CheckMacho;
    private javax.swing.JCheckBox CheckMedio;
    private javax.swing.JCheckBox CheckPequeno;
    private javax.swing.JLabel Photo_1;
    private javax.swing.JLabel Photo_2;
    private javax.swing.JLabel Photo_3;
    private javax.swing.JLabel Photo_4;
    private javax.swing.JLabel Photo_5;
    private javax.swing.JLabel Photo_6;
    private javax.swing.JButton ProxBTN;
    private javax.swing.JButton VoltarBTN;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton sobreBTN_1;
    private javax.swing.JButton sobreBTN_2;
    private javax.swing.JButton sobreBTN_3;
    private javax.swing.JButton sobreBTN_4;
    private javax.swing.JButton sobreBTN_5;
    private javax.swing.JButton sobreBTN_6;
    // End of variables declaration//GEN-END:variables
}
