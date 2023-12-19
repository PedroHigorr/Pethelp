/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.PetDAO;
import DTO.PetDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class AdicionaPet extends javax.swing.JFrame {

    String CaminhoFoto;
    
    public AdicionaPet() {
        setUndecorated(true);

        initComponents();
        
       
        //Mudando o Layout do fundo
        FundoLayout();

        //Tratamento de seleção de botões
        sexo_Grupo();
        TipoAnimal_Grupo();
        porte_Grupo();
        Status_Grupo();

        //Tratamento dos textos no campo TEXT FIELD
        //O TEXT FIELD deverá ter um texto que irá sumir ao usuario clicar no campo
        nomeFocus();
        racaFocus();
        corFocus();

        
    }
    
    public void FundoLayout() {

        FlatLightLaf.setup();
        
        Color cor = new Color(57,106,64);
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
        //Forma arredondada do Jframe
       

    }

    public ButtonGroup sexo_Grupo() {
        //setando uma ação "String" para retornar como atributo para o banco
        ADDPetRadioMACHOBtnVIEW.setActionCommand("M");
        ADDPetRadioFEMEABtnVIEW.setActionCommand("F");
        
        //Criando um Button Group
        /*
        O Button Group serve para que caso eu tenha dois botões de seleção 
        Somente um seja selecionado por vez
         */
        ButtonGroup SexChooser = new ButtonGroup();

        SexChooser.add(ADDPetRadioMACHOBtnVIEW);
        SexChooser.add(ADDPetRadioFEMEABtnVIEW);
        
        return SexChooser;
    }
    
    public ButtonGroup TipoAnimal_Grupo(){
    
        //setando uma ação "String" para retornar como atributo para o banco
        ADDPetRadioCatBtnVIEW.setActionCommand("Gato");
        ADDPetRadioDogBtnVIEW.setActionCommand("Cachorro");
        
        //Criando um Button Group
        /*
        O Button Group serve para que caso eu tenha dois botões de seleção 
        Somente um seja selecionado por vez
         */
        //Instancia de um novo ButtonGroup
        ButtonGroup AnimalChooser = new ButtonGroup();

        //Adicionando os botões que eu não quero que sejam selecionados simultaneamente
        AnimalChooser.add(ADDPetRadioCatBtnVIEW);
        AnimalChooser.add(ADDPetRadioDogBtnVIEW);
        
        return AnimalChooser;

    }
    
    public ButtonGroup porte_Grupo(){
        //setando uma ação "String" para retornar como atributo para o banco
        ADDPetRadioPEQBtnVIEW.setActionCommand("Pequeno");
        ADDPetRadioMEDIOBtnVIEW.setActionCommand("Médio");
        ADDPetRadioGRANDEBtnVIEW.setActionCommand("Grande");
         //Criando um Button Group
        /*
        O Button Group serve para que caso eu tenha dois botões de seleção 
        Somente um seja selecionado por vez
         */
        ButtonGroup PorteChooser = new ButtonGroup();

        PorteChooser.add(ADDPetRadioPEQBtnVIEW);
        PorteChooser.add(ADDPetRadioMEDIOBtnVIEW);
        PorteChooser.add(ADDPetRadioGRANDEBtnVIEW);
        
        return PorteChooser;}
    
    public ButtonGroup Status_Grupo() {
        //setando uma ação "String" para retornar como atributo para o banco
        ADDPetENCRadioVIEW.setActionCommand("Encontrado");
        ADDPetPERDIDORadioVIEW.setActionCommand("Perdido");
        
        //Criando um Button Group
        /*
        O Button Group serve para que caso eu tenha dois botões de seleção 
        Somente um seja selecionado por vez
         */
        
        ButtonGroup statusChooser = new ButtonGroup();

        statusChooser.add(ADDPetENCRadioVIEW);
        statusChooser.add(ADDPetPERDIDORadioVIEW);
        
        return statusChooser;
    }
 
    public void nomeFocus() {

        //Setando a cor do texto para CINZA
        ADDPetTxtFNomeVIEW.setForeground(Color.GRAY);

        //Criando um novo FOCUS LISTENER para observar se o usuario clicou no campo
        ADDPetTxtFNomeVIEW.addFocusListener(new FocusListener() {

            //Sobrescrevendo o método original para quando o usuario clicar no campo
            @Override
            public void focusGained(FocusEvent e) { //Quando o campo for selecionado ele irá verificar o texto contido no campo
                if (ADDPetTxtFNomeVIEW.getText().equals(" Digite o nome do Pet ")) { //Se o texto no campo for igual ao texto pedido
                    ADDPetTxtFNomeVIEW.setText(" ");//O campo selecionado irá receber um " " vazio
                    ADDPetTxtFNomeVIEW.setForeground(Color.BLACK);//E irá setar a cor da letra para preto
                }
            }

            //Sobrescrevendo o método original para quando o campo esteja vazio
            @Override
            public void focusLost(FocusEvent e) { //Caso o campo perca o foco, ou o usuario clique fora do campo
                if (ADDPetTxtFNomeVIEW.getText().isEmpty()) {//Verifica se o campo está vazio = " "
                    ADDPetTxtFNomeVIEW.setText(" Digite o nome do Pet ");//Caso esteja vazio, o campo receberá o seguinte texto
                    ADDPetTxtFNomeVIEW.setForeground(Color.GRAY); // E a cor será setada para cinza
                } else if (ADDPetTxtFNomeVIEW.getText().equals(" ")) {
                    ADDPetTxtFNomeVIEW.setText(" Digite o nome do Pet ");
                    ADDPetTxtFNomeVIEW.setForeground(Color.GRAY);
                }

            }
        });
    }

    public void racaFocus() {
        ADDPetTxtFRacaVIEW.setForeground(Color.GRAY);

        ADDPetTxtFRacaVIEW.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ADDPetTxtFRacaVIEW.getText().equals("Ex: Pitbull")) {
                    ADDPetTxtFRacaVIEW.setText("");
                    ADDPetTxtFRacaVIEW.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ADDPetTxtFRacaVIEW.getText().isEmpty()) { //isEmpty() para verificar se está vazio
                    ADDPetTxtFRacaVIEW.setText("Ex: Pitbull");
                    ADDPetTxtFRacaVIEW.setForeground(Color.GRAY);
                }
            }
        });
    }

    public void corFocus() {
        ADDPetTxtFCorVIEW.setForeground(Color.GRAY);

        ADDPetTxtFCorVIEW.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ADDPetTxtFCorVIEW.getText().equals("Ex: Branca")) {
                    ADDPetTxtFCorVIEW.setText("");
                    ADDPetTxtFCorVIEW.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ADDPetTxtFCorVIEW.getText().isEmpty()) {
                    ADDPetTxtFCorVIEW.setText("Ex: Branca");
                    ADDPetTxtFCorVIEW.setForeground(Color.GRAY);
                }
            }
        });
    }

    public class FileChooser {

        public static String AbrirArquivo() {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                return fileChooser.getSelectedFile().getAbsolutePath();
            }

            return null; // Retornar null se nenhum arquivo for selecionado
        }
    }
    
    
    public String getRadioSelecionado(ButtonGroup grupo){
        
        ButtonModel botaoSelecionado = grupo.getSelection();
        
        if(botaoSelecionado != null){
            return botaoSelecionado.getActionCommand();
        }else{
            return null;
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoADDPetView = new javax.swing.JLabel();
        SaparadorADDPetVIEW = new javax.swing.JSeparator();
        TXTAddPetTopVIEW = new javax.swing.JLabel();
        TXTAddPetUnderTopVIEW = new javax.swing.JLabel();
        ADDPetQuitBtnVIEW = new javax.swing.JButton();
        ADDPetRadioDogBtnVIEW = new javax.swing.JRadioButton();
        ADDPetRadioCatBtnVIEW = new javax.swing.JRadioButton();
        TXTAddChoosePetVIEW = new javax.swing.JLabel();
        TXTAddPetNomeVIEW = new javax.swing.JLabel();
        ADDPetTxtFNomeVIEW = new javax.swing.JTextField();
        TXTAddPetRacaVIEW = new javax.swing.JLabel();
        ADDPetTxtFRacaVIEW = new javax.swing.JTextField();
        TXTAddPetPorteVIEW = new javax.swing.JLabel();
        ADDPetRadioPEQBtnVIEW = new javax.swing.JRadioButton();
        ADDPetRadioMEDIOBtnVIEW = new javax.swing.JRadioButton();
        ADDPetRadioGRANDEBtnVIEW = new javax.swing.JRadioButton();
        TXTAddPetCorVIEW = new javax.swing.JLabel();
        ADDPetTxtFCorVIEW = new javax.swing.JTextField();
        TXTAddChooseSexVIEW = new javax.swing.JLabel();
        ADDPetRadioMACHOBtnVIEW = new javax.swing.JRadioButton();
        ADDPetRadioFEMEABtnVIEW = new javax.swing.JRadioButton();
        TXTAddPetFotoVIEW = new javax.swing.JLabel();
        ADDPetAddFotoBtnVIEW = new javax.swing.JButton();
        ADDPetFOTOLabelVIEW = new javax.swing.JLabel();
        ADDPetANUNCIARBtnVIEW = new javax.swing.JButton();
        ADDPetVOLTABtnVIEW = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ADDPetENCRadioVIEW = new javax.swing.JRadioButton();
        ADDPetPERDIDORadioVIEW = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        LogoADDPetView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CadIcon.png"))); // NOI18N

        SaparadorADDPetVIEW.setBackground(new java.awt.Color(153, 153, 153));
        SaparadorADDPetVIEW.setForeground(new java.awt.Color(153, 153, 153));

        TXTAddPetTopVIEW.setBackground(new java.awt.Color(201, 213, 181));
        TXTAddPetTopVIEW.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        TXTAddPetTopVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAddPetTopVIEW.setText("ADICIONAR SEU PET");

        TXTAddPetUnderTopVIEW.setBackground(new java.awt.Color(201, 213, 181));
        TXTAddPetUnderTopVIEW.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        TXTAddPetUnderTopVIEW.setText("Adicione um pet perdido ou encontrado!");

        ADDPetQuitBtnVIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/quit2.png"))); // NOI18N
        ADDPetQuitBtnVIEW.setBorderPainted(false);
        ADDPetQuitBtnVIEW.setFocusPainted(false);
        ADDPetQuitBtnVIEW.setFocusable(false);
        ADDPetQuitBtnVIEW.setRequestFocusEnabled(false);
        ADDPetQuitBtnVIEW.setRolloverEnabled(false);
        ADDPetQuitBtnVIEW.setVerifyInputWhenFocusTarget(false);
        ADDPetQuitBtnVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDPetQuitBtnVIEWActionPerformed(evt);
            }
        });

        ADDPetRadioDogBtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetRadioDogBtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetRadioDogBtnVIEW.setText("Cachorro");

        ADDPetRadioCatBtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetRadioCatBtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetRadioCatBtnVIEW.setText("Gato");
        ADDPetRadioCatBtnVIEW.setRolloverEnabled(false);

        TXTAddChoosePetVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXTAddChoosePetVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAddChoosePetVIEW.setText("Selecione o animal");

        TXTAddPetNomeVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXTAddPetNomeVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAddPetNomeVIEW.setText("Nome: *");

        ADDPetTxtFNomeVIEW.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ADDPetTxtFNomeVIEW.setText(" Digite o nome do Pet ");
        ADDPetTxtFNomeVIEW.setSelectionColor(new java.awt.Color(204, 204, 204));

        TXTAddPetRacaVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXTAddPetRacaVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAddPetRacaVIEW.setText("Raça: *");

        ADDPetTxtFRacaVIEW.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ADDPetTxtFRacaVIEW.setText("Ex: Pitbull");

        TXTAddPetPorteVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXTAddPetPorteVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAddPetPorteVIEW.setText("Porte: *");

        ADDPetRadioPEQBtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetRadioPEQBtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetRadioPEQBtnVIEW.setText("Pequeno");

        ADDPetRadioMEDIOBtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetRadioMEDIOBtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetRadioMEDIOBtnVIEW.setText("Médio");

        ADDPetRadioGRANDEBtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetRadioGRANDEBtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetRadioGRANDEBtnVIEW.setText("Grande");

        TXTAddPetCorVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXTAddPetCorVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAddPetCorVIEW.setText("Cor: *");

        ADDPetTxtFCorVIEW.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ADDPetTxtFCorVIEW.setText("Ex: Branca");
        ADDPetTxtFCorVIEW.setToolTipText("");

        TXTAddChooseSexVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXTAddChooseSexVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAddChooseSexVIEW.setText("Sexo: *");

        ADDPetRadioMACHOBtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ADDPetRadioMACHOBtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetRadioMACHOBtnVIEW.setText("Macho");

        ADDPetRadioFEMEABtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ADDPetRadioFEMEABtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetRadioFEMEABtnVIEW.setText("Fêmea");

        TXTAddPetFotoVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        TXTAddPetFotoVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAddPetFotoVIEW.setText("Foto do animal: *");

        ADDPetAddFotoBtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        ADDPetAddFotoBtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetAddFotoBtnVIEW.setText("Adicionar Foto");
        ADDPetAddFotoBtnVIEW.setActionCommand("");
        ADDPetAddFotoBtnVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDPetAddFotoBtnVIEWActionPerformed(evt);
            }
        });

        ADDPetFOTOLabelVIEW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181)));

        ADDPetANUNCIARBtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetANUNCIARBtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetANUNCIARBtnVIEW.setText("Continuar");
        ADDPetANUNCIARBtnVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDPetANUNCIARBtnVIEWActionPerformed(evt);
            }
        });

        ADDPetVOLTABtnVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetVOLTABtnVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetVOLTABtnVIEW.setText("Voltar");
        ADDPetVOLTABtnVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDPetVOLTABtnVIEWActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 106, 64));
        jLabel1.setText("Status: *");

        ADDPetENCRadioVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetENCRadioVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetENCRadioVIEW.setText("Encontrado");

        ADDPetPERDIDORadioVIEW.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ADDPetPERDIDORadioVIEW.setForeground(new java.awt.Color(57, 106, 64));
        ADDPetPERDIDORadioVIEW.setText("Perdido");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 297, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ADDPetQuitBtnVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ADDPetFOTOLabelVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ADDPetVOLTABtnVIEW))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ADDPetANUNCIARBtnVIEW)
                        .addGap(12, 12, 12))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTAddPetFotoVIEW)
                    .addComponent(ADDPetAddFotoBtnVIEW))
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(TXTAddPetTopVIEW))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(LogoADDPetView)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(TXTAddPetUnderTopVIEW)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SaparadorADDPetVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 318, Short.MAX_VALUE))
                            .addComponent(ADDPetTxtFCorVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ADDPetRadioPEQBtnVIEW)
                            .addComponent(TXTAddPetPorteVIEW, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TXTAddPetCorVIEW)
                        .addGap(145, 145, 145))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(TXTAddPetNomeVIEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TXTAddPetRacaVIEW)
                        .addGap(130, 130, 130))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ADDPetRadioMEDIOBtnVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ADDPetRadioGRANDEBtnVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(TXTAddChoosePetVIEW)
                                .addGap(107, 107, 107)
                                .addComponent(TXTAddChooseSexVIEW))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ADDPetRadioCatBtnVIEW)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ADDPetRadioDogBtnVIEW))
                                    .addComponent(ADDPetTxtFNomeVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ADDPetRadioMACHOBtnVIEW)
                                        .addGap(18, 18, 18)
                                        .addComponent(ADDPetRadioFEMEABtnVIEW))
                                    .addComponent(ADDPetTxtFRacaVIEW)))
                            .addComponent(ADDPetENCRadioVIEW)
                            .addComponent(ADDPetPERDIDORadioVIEW))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADDPetQuitBtnVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(LogoADDPetView, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXTAddPetTopVIEW)
                .addGap(43, 43, 43)
                .addComponent(TXTAddPetUnderTopVIEW)
                .addGap(18, 18, 18)
                .addComponent(SaparadorADDPetVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTAddChooseSexVIEW)
                    .addComponent(TXTAddChoosePetVIEW))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADDPetRadioDogBtnVIEW)
                    .addComponent(ADDPetRadioMACHOBtnVIEW)
                    .addComponent(ADDPetRadioCatBtnVIEW)
                    .addComponent(ADDPetRadioFEMEABtnVIEW))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTAddPetNomeVIEW)
                    .addComponent(TXTAddPetRacaVIEW))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADDPetTxtFNomeVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADDPetTxtFRacaVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTAddPetCorVIEW, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TXTAddPetPorteVIEW))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ADDPetRadioPEQBtnVIEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ADDPetRadioMEDIOBtnVIEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ADDPetRadioGRANDEBtnVIEW))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ADDPetTxtFCorVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TXTAddPetFotoVIEW)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ADDPetAddFotoBtnVIEW)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ADDPetENCRadioVIEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ADDPetPERDIDORadioVIEW))
                    .addComponent(ADDPetFOTOLabelVIEW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADDPetANUNCIARBtnVIEW)
                    .addComponent(ADDPetVOLTABtnVIEW))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ADDPetQuitBtnVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDPetQuitBtnVIEWActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ADDPetQuitBtnVIEWActionPerformed

    private void ADDPetAddFotoBtnVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDPetAddFotoBtnVIEWActionPerformed
        
        
        //Config Para abrir um arquivo
         CaminhoFoto = FileChooser.AbrirArquivo();
        if (CaminhoFoto != null) {
            // O usuário selecionou um arquivo
            
            //Ajustando a imagem para o tamanho do label
            
            //Carrega a imagem do arquivo
            ImageIcon img = new ImageIcon(CaminhoFoto);
            //Obtem a imagem carregada
            Image image = img.getImage();
            
            //recuperando altura e largura da Label que irá comportar a imagem
            int labelWidth = ADDPetFOTOLabelVIEW.getWidth();
            int labelHeight = ADDPetFOTOLabelVIEW.getHeight();

            //Redimensiona a imagem para caber na label
            Image scaledImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            
            //Criando um novo image icon já reescalado
            ImageIcon imagemScalada = new ImageIcon(scaledImage);
            
            ADDPetFOTOLabelVIEW.setIcon(imagemScalada);
            
        } else {
            // O usuário cancelou a seleção do arquivo ou ocorreu algum erro
            JOptionPane.showMessageDialog(null, "Nenhuma foto selecionada");
        }
        
        
        
        
    }//GEN-LAST:event_ADDPetAddFotoBtnVIEWActionPerformed

    private void ADDPetVOLTABtnVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDPetVOLTABtnVIEWActionPerformed
        telaInicial inicial = new telaInicial();
        
        dispose();
        
        inicial.setVisible(true);
    }//GEN-LAST:event_ADDPetVOLTABtnVIEWActionPerformed

    private void ADDPetANUNCIARBtnVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDPetANUNCIARBtnVIEWActionPerformed
        
        PetDTO petDados = preencherPetDTO();
        exibirAnimalLocation(petDados);
        
        
    }//GEN-LAST:event_ADDPetANUNCIARBtnVIEWActionPerformed

    private PetDTO preencherPetDTO() {
        
    PetDTO petDados = new PetDTO();
    
    petDados.setNome_pet(ADDPetTxtFNomeVIEW.getText());
    petDados.setCor(ADDPetTxtFCorVIEW.getText());
    petDados.setPorte(getRadioSelecionado(porte_Grupo()));
    petDados.setSexo(getRadioSelecionado(sexo_Grupo()));
    petDados.setTipo(getRadioSelecionado(TipoAnimal_Grupo()));
    petDados.setStatus(getRadioSelecionado(Status_Grupo()));
    petDados.setRaca(ADDPetTxtFRacaVIEW.getText());
    petDados.setFoto_end(CaminhoFoto);
        
    return petDados;
}

    private void exibirAnimalLocation(PetDTO petDados) {
        
    AnimalLocation animalLocation = new AnimalLocation(petDados);
    dispose();
    animalLocation.setVisible(true);
    
}
    
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
            java.util.logging.Logger.getLogger(AdicionaPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionaPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionaPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionaPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionaPet().setVisible(true);
            }
        });
    }
    
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDPetANUNCIARBtnVIEW;
    private javax.swing.JButton ADDPetAddFotoBtnVIEW;
    private javax.swing.JRadioButton ADDPetENCRadioVIEW;
    private javax.swing.JLabel ADDPetFOTOLabelVIEW;
    private javax.swing.JRadioButton ADDPetPERDIDORadioVIEW;
    private javax.swing.JButton ADDPetQuitBtnVIEW;
    private javax.swing.JRadioButton ADDPetRadioCatBtnVIEW;
    private javax.swing.JRadioButton ADDPetRadioDogBtnVIEW;
    private javax.swing.JRadioButton ADDPetRadioFEMEABtnVIEW;
    private javax.swing.JRadioButton ADDPetRadioGRANDEBtnVIEW;
    private javax.swing.JRadioButton ADDPetRadioMACHOBtnVIEW;
    private javax.swing.JRadioButton ADDPetRadioMEDIOBtnVIEW;
    private javax.swing.JRadioButton ADDPetRadioPEQBtnVIEW;
    private javax.swing.JTextField ADDPetTxtFCorVIEW;
    private javax.swing.JTextField ADDPetTxtFNomeVIEW;
    private javax.swing.JTextField ADDPetTxtFRacaVIEW;
    private javax.swing.JButton ADDPetVOLTABtnVIEW;
    private javax.swing.JLabel LogoADDPetView;
    private javax.swing.JSeparator SaparadorADDPetVIEW;
    private javax.swing.JLabel TXTAddChoosePetVIEW;
    private javax.swing.JLabel TXTAddChooseSexVIEW;
    private javax.swing.JLabel TXTAddPetCorVIEW;
    private javax.swing.JLabel TXTAddPetFotoVIEW;
    private javax.swing.JLabel TXTAddPetNomeVIEW;
    private javax.swing.JLabel TXTAddPetPorteVIEW;
    private javax.swing.JLabel TXTAddPetRacaVIEW;
    private javax.swing.JLabel TXTAddPetTopVIEW;
    private javax.swing.JLabel TXTAddPetUnderTopVIEW;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
