package VIEW;

import DAO.PetDAO;
import DTO.PetDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import petServices.Sessao;
import petServices.getLocais;

public class AnimalLocation extends javax.swing.JFrame {

    static PetDTO pets;
    Vector<Integer> estados = new Vector<Integer>();

    public AnimalLocation(PetDTO petDados) {
        setUndecorated(true);

        initComponents();
        FundoLayout();

        pets = petDados;

        getLocais locais = new getLocais();

        locais.getEstados(estados, AnLocation_UF_VIEW);

        mudarTexto();

        //Obersvador para pegar a cidade pelo estado
        AnLocation_UF_VIEW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Obter o ID do estado selecionado na primeira ComboBox
                int idEstadoSelecionado = estados.get(AnLocation_UF_VIEW.getSelectedIndex());

                //Chamar o método para preencher o comboBox da cidade
                locais.getCidadesByEstado(idEstadoSelecionado, AnLocation_CIDADE_VIEW);
                
            }
        });

    }

    public void mudarTexto() {

        String status = pets.getStatus();

        if (status.equals("Encontrado")) {
            TXTvariavel_VIEW.setText(null);
            TXTvariavel_VIEW.setText("Adicionar localização de um pet " + status);
        }

    }

    public void FundoLayout() {

        FlatLightLaf.setup();
        // Crie um novo JPanel com o fundo colorido
        JPanel backgroundLogin = new JPanel();
        backgroundLogin.setBackground(new Color(201, 213, 181));
        backgroundLogin.setOpaque(true);

        // Definindo o layout do JPanel como null para permitir a sobreposição
        backgroundLogin.setLayout(null);

        // Adicione o JPanel como plano de fundo
        backgroundLogin.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLogin);

        //Forma arredondada do Jframe
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AnLocation_QUIT_VIEW = new javax.swing.JButton();
        Animal_Logo = new javax.swing.JLabel();
        TXT_estado = new javax.swing.JLabel();
        TXT_cidade = new javax.swing.JLabel();
        AnLocation_UF_VIEW = new javax.swing.JComboBox<>();
        AnLocation_CIDADE_VIEW = new javax.swing.JComboBox<>();
        AnLocation_ANUNCIAR_VIEW = new javax.swing.JButton();
        AnLocation_VOLTAR_VIEW = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        TXTvariavel_VIEW = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AnLocation_QUIT_VIEW.setBackground(new java.awt.Color(201, 213, 181));
        AnLocation_QUIT_VIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/quit2.png"))); // NOI18N
        AnLocation_QUIT_VIEW.setBorderPainted(false);
        AnLocation_QUIT_VIEW.setDoubleBuffered(true);
        AnLocation_QUIT_VIEW.setFocusCycleRoot(true);
        AnLocation_QUIT_VIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnLocation_QUIT_VIEWActionPerformed(evt);
            }
        });

        Animal_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CadIcon.png"))); // NOI18N

        TXT_estado.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXT_estado.setForeground(new java.awt.Color(57, 106, 64));
        TXT_estado.setText("Estado: *");

        TXT_cidade.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXT_cidade.setForeground(new java.awt.Color(57, 106, 64));
        TXT_cidade.setText("Cidade: *");

        AnLocation_ANUNCIAR_VIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AnLocation_ANUNCIAR_VIEW.setForeground(new java.awt.Color(57, 106, 64));
        AnLocation_ANUNCIAR_VIEW.setText("Anunciar");
        AnLocation_ANUNCIAR_VIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnLocation_ANUNCIAR_VIEWActionPerformed(evt);
            }
        });

        AnLocation_VOLTAR_VIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AnLocation_VOLTAR_VIEW.setForeground(new java.awt.Color(57, 106, 64));
        AnLocation_VOLTAR_VIEW.setText("Voltar");
        AnLocation_VOLTAR_VIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnLocation_VOLTAR_VIEWActionPerformed(evt);
            }
        });

        TXTvariavel_VIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        TXTvariavel_VIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTvariavel_VIEW.setText("Adicionar localização de um pet perdido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(TXT_estado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TXT_cidade)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AnLocation_QUIT_VIEW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AnLocation_VOLTAR_VIEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AnLocation_ANUNCIAR_VIEW)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Animal_Logo)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(AnLocation_UF_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AnLocation_CIDADE_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(TXTvariavel_VIEW)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnLocation_QUIT_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Animal_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TXTvariavel_VIEW)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_cidade)
                    .addComponent(TXT_estado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnLocation_CIDADE_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnLocation_UF_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnLocation_ANUNCIAR_VIEW)
                    .addComponent(AnLocation_VOLTAR_VIEW))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AnLocation_QUIT_VIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnLocation_QUIT_VIEWActionPerformed
        System.exit(0);
    }//GEN-LAST:event_AnLocation_QUIT_VIEWActionPerformed

    private void AnLocation_ANUNCIAR_VIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnLocation_ANUNCIAR_VIEWActionPerformed
        
        enviarBD();

    }//GEN-LAST:event_AnLocation_ANUNCIAR_VIEWActionPerformed

    private int setIDLocal() {

        getLocais gl = new getLocais();

        String uf = AnLocation_UF_VIEW.getSelectedItem().toString();
        String cidade = AnLocation_CIDADE_VIEW.getSelectedItem().toString();

        pets.setId_local(gl.getIdLocal(uf, cidade));

        int idLocal = getLocais.getIdLocal(uf, cidade);

        if (idLocal != -1) {
            return idLocal;
            // faça o que precisar com o idLocal
        } else {
            return 0;
        }

    }

    private void enviarBD() {

        PetDAO cad = new PetDAO();
        telaInicial tl = new telaInicial();

        Sessao sessao = Sessao.getInstance();

        int local_ID = setIDLocal();

        if (local_ID > 0) {

            if (pets.getStatus().equals("Encontrado")) {
                
                pets.setId_local(local_ID);
                
                cad.cadPet_Encontrado(pets, sessao.getLoggedUserCPF());
                
                JOptionPane.showMessageDialog(null, "Pet cadastrado com sucesso!");
                
                dispose();
                
                setVisible(false);
                
                tl.setVisible(true);

            } else if (pets.getStatus().equals("Perdido")) {
                cad.cadPet_Perdido(pets, sessao.getLoggedUserCPF());
                JOptionPane.showMessageDialog(null, "Pet cadastrado com sucesso!");
                dispose();
                setVisible(false);
                tl.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Sistema quebrado: :X");
            }
        }else{ JOptionPane.showMessageDialog(null, "Insira um local válido!");}

    }


    private void AnLocation_VOLTAR_VIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnLocation_VOLTAR_VIEWActionPerformed
        AdicionaPet adpt = new AdicionaPet();
        dispose();
        adpt.setVisible(true);
    }//GEN-LAST:event_AnLocation_VOLTAR_VIEWActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PetDTO dados = new PetDTO();
                dados = pets;
                new AnimalLocation(dados).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnLocation_ANUNCIAR_VIEW;
    private javax.swing.JComboBox<String> AnLocation_CIDADE_VIEW;
    private javax.swing.JButton AnLocation_QUIT_VIEW;
    private javax.swing.JComboBox<String> AnLocation_UF_VIEW;
    private javax.swing.JButton AnLocation_VOLTAR_VIEW;
    private javax.swing.JLabel Animal_Logo;
    private javax.swing.JLabel TXT_cidade;
    private javax.swing.JLabel TXT_estado;
    private javax.swing.JLabel TXTvariavel_VIEW;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
