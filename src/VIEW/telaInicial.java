package VIEW;

//Glossário
/*
DAO (Data Access Object):
  O DAO é um padrão de projeto que separa a lógica de acesso a dados da lógica de negócios de uma aplicação.

DTO (Data Transfer Object):
  DTO é um objeto que carrega dados entre os processos da aplicação

VIEW:
  A camada VIEW representa a interface do usuário em um aplicativo.

 */
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import petServices.AtualizarFotos;
import petServices.Sessao;
import DTO.PetDTO;
import DAO.PetEncontradoCAD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class telaInicial extends javax.swing.JFrame {

    PetDTO perdido1, perdido2, perdido3, perdido4, perdido5, perdido6, perdido7;
    PetDTO encontrado1, encontrado2, encontrado3, encontrado4, encontrado5, encontrado6, encontrado7;
    int alerta = 0;

    public telaInicial() {

        initComponents();

        setLayout();

        carregarFotosAnimaisPerdidos();
        carregarFotosAnimaisEncontrados();

        checkAnimais();
        alertar();

    }

    private void setLayout() {

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

    }

    private void carregarFotosAnimaisPerdidos() {
        int i = 1;
        int id_local = Sessao.getInstance().getLoggedUserLocationID();
        List<JLabel> labels = List.of(PerdidoPic_1, PerdidoPic_2, PerdidoPic_3, PerdidoPic_4, PerdidoPic_5, PerdidoPic_6);

        List<PetDTO> animaisPerdidos = AtualizarFotos.loadAnimalPhotos(id_local, labels, i);

        associarInstanciasPet(animaisPerdidos, "perdido");
    }

    private void carregarFotosAnimaisEncontrados() {
        int i = 2;
        int id_local = Sessao.getInstance().getLoggedUserLocationID();
        List<JLabel> labels = List.of(EncontradoPIC_1, EncontradoPIC_2, EncontradoPIC_3, EncontradoPIC_4, EncontradoPIC_5, EncontradoPIC_6, EncontradoPIC_7);

        List<PetDTO> animaisEncontrados = AtualizarFotos.loadAnimalPhotos(id_local, labels, i);

        associarInstanciasPet(animaisEncontrados, "encontrado");
    }

    private void associarInstanciasPet(List<PetDTO> animais, String tipo) {
        for (int j = 0; j < 7; j++) {
            PetDTO animal = (j < animais.size()) ? animais.get(j) : null;

            if (animal != null) {
                associarInstanciaPet(animal, j + 1, tipo);
            }
        }
    }

    private void associarInstanciaPet(PetDTO animal, int numero, String tipo) {
        switch (tipo) {
            case "perdido":
                switch (numero) {
                    case 1:
                        perdido1 = animal;

                        break;
                    case 2:
                        perdido2 = animal;
                        break;
                    case 3:
                        perdido3 = animal;
                        break;
                    case 4:
                        perdido4 = animal;
                        break;
                    case 5:
                        perdido5 = animal;

                        break;
                    case 6:
                        perdido6 = animal;
                        break;
                    case 7:
                        perdido7 = animal;
                        break;
                }
                break;
            case "encontrado":
                switch (numero) {
                    case 1:
                        encontrado1 = animal;
                        break;
                    case 2:
                        encontrado2 = animal;
                        break;
                    case 3:
                        encontrado3 = animal;
                        break;
                    case 4:
                        encontrado4 = animal;
                        break;
                    case 5:
                        encontrado5 = animal;
                        break;
                    case 6:
                        encontrado6 = animal;
                        break;
                    case 7:
                        encontrado7 = animal;
                        break;
                }
                break;
            // Adicione mais casos conforme necessário
        }
    }

    private void checkAnimais() {

        Sessao sessao = Sessao.getInstance();

        try {

            ResultSet rs = new PetEncontradoCAD().checarTabela(sessao.getLoggedUserCPF());

            while (rs.next()) {
                System.out.println(rs.getInt("pets_encontrados"));
                if (rs.getInt("pets_encontrados") > 0) {

                    alerta = 1;
                }

            }

        } catch (SQLException err) {

            JOptionPane.showMessageDialog(null, "Tela inicial, falha em receber alerta: " + err.getMessage());
        }
    }

    private void alertar() {

        if (alerta == 1) {
            alertBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alert.png")));
        } else if (alerta == 0) {
            alertBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Black_alert.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CentralPainel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PerdidoPic_1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PerdidoPic_2 = new javax.swing.JLabel();
        PerdidoPic_3 = new javax.swing.JLabel();
        PerdidoPic_4 = new javax.swing.JLabel();
        PerdidoPic_5 = new javax.swing.JLabel();
        PerdidoPic_6 = new javax.swing.JLabel();
        PerdidoPic_7 = new javax.swing.JLabel();
        TXT_animaisPerdidos = new javax.swing.JLabel();
        AboutPerdidoBTN_1 = new javax.swing.JButton();
        AboutPerdidoBTN_2 = new javax.swing.JButton();
        AboutPerdidoBTN_3 = new javax.swing.JButton();
        AboutPerdidoBTN_4 = new javax.swing.JButton();
        AboutPerdidoBTN_5 = new javax.swing.JButton();
        AboutPerdidoBTN_6 = new javax.swing.JButton();
        AboutPerdidoBTN_7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        EncontradoPIC_2 = new javax.swing.JLabel();
        EncontradoPIC_1 = new javax.swing.JLabel();
        EncontradoPIC_3 = new javax.swing.JLabel();
        EncontradoPIC_4 = new javax.swing.JLabel();
        EncontradoPIC_5 = new javax.swing.JLabel();
        EncontradoPIC_6 = new javax.swing.JLabel();
        EncontradoPIC_7 = new javax.swing.JLabel();
        AboutEncontradoBTN_1 = new javax.swing.JButton();
        AboutEncontradoBTN_2 = new javax.swing.JButton();
        AboutEncontradoBTN_3 = new javax.swing.JButton();
        AboutEncontradoBTN_4 = new javax.swing.JButton();
        AboutEncontradoBTN_5 = new javax.swing.JButton();
        AboutEncontradoBTN_6 = new javax.swing.JButton();
        AboutEncontradoBTN_7 = new javax.swing.JButton();
        TopLogoLabel = new javax.swing.JLabel();
        InitialLostButtonVIEW = new javax.swing.JButton();
        InitialFoundButtonVIEW = new javax.swing.JButton();
        InitialCadButtonVIEW = new javax.swing.JButton();
        quitBTN = new javax.swing.JButton();
        InitialLoginPhotoButtonVIEW = new javax.swing.JButton();
        alertBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        CentralPainel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Banner.png"))); // NOI18N

        PerdidoPic_1.setBackground(new java.awt.Color(201, 213, 181));
        PerdidoPic_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        PerdidoPic_2.setBackground(new java.awt.Color(201, 213, 181));
        PerdidoPic_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        PerdidoPic_3.setBackground(new java.awt.Color(201, 213, 181));
        PerdidoPic_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        PerdidoPic_4.setBackground(new java.awt.Color(201, 213, 181));
        PerdidoPic_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        PerdidoPic_5.setBackground(new java.awt.Color(201, 213, 181));
        PerdidoPic_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        PerdidoPic_6.setBackground(new java.awt.Color(201, 213, 181));
        PerdidoPic_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        PerdidoPic_7.setBackground(new java.awt.Color(201, 213, 181));
        PerdidoPic_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        TXT_animaisPerdidos.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        TXT_animaisPerdidos.setForeground(new java.awt.Color(57, 106, 64));
        TXT_animaisPerdidos.setText("ANIMAIS PERDIDOS");

        AboutPerdidoBTN_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutPerdidoBTN_1.setForeground(new java.awt.Color(57, 106, 64));
        AboutPerdidoBTN_1.setText("Sobre o pet");
        AboutPerdidoBTN_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutPerdidoBTN_1ActionPerformed(evt);
            }
        });

        AboutPerdidoBTN_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutPerdidoBTN_2.setForeground(new java.awt.Color(57, 106, 64));
        AboutPerdidoBTN_2.setText("Sobre o pet");
        AboutPerdidoBTN_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutPerdidoBTN_2ActionPerformed(evt);
            }
        });

        AboutPerdidoBTN_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutPerdidoBTN_3.setForeground(new java.awt.Color(57, 106, 64));
        AboutPerdidoBTN_3.setText("Sobre o pet");
        AboutPerdidoBTN_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutPerdidoBTN_3ActionPerformed(evt);
            }
        });

        AboutPerdidoBTN_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutPerdidoBTN_4.setForeground(new java.awt.Color(57, 106, 64));
        AboutPerdidoBTN_4.setText("Sobre o pet");
        AboutPerdidoBTN_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutPerdidoBTN_4ActionPerformed(evt);
            }
        });

        AboutPerdidoBTN_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutPerdidoBTN_5.setForeground(new java.awt.Color(57, 106, 64));
        AboutPerdidoBTN_5.setText("Sobre o pet");
        AboutPerdidoBTN_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutPerdidoBTN_5ActionPerformed(evt);
            }
        });

        AboutPerdidoBTN_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutPerdidoBTN_6.setForeground(new java.awt.Color(57, 106, 64));
        AboutPerdidoBTN_6.setText("Sobre o pet");
        AboutPerdidoBTN_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutPerdidoBTN_6ActionPerformed(evt);
            }
        });

        AboutPerdidoBTN_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutPerdidoBTN_7.setForeground(new java.awt.Color(57, 106, 64));
        AboutPerdidoBTN_7.setText("Sobre o pet");
        AboutPerdidoBTN_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutPerdidoBTN_7ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 106, 64));
        jLabel2.setText("ANIMAIS ENCONTRADOS");

        EncontradoPIC_2.setBackground(new java.awt.Color(201, 213, 181));
        EncontradoPIC_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        EncontradoPIC_1.setBackground(new java.awt.Color(201, 213, 181));
        EncontradoPIC_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        EncontradoPIC_3.setBackground(new java.awt.Color(201, 213, 181));
        EncontradoPIC_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        EncontradoPIC_4.setBackground(new java.awt.Color(201, 213, 181));
        EncontradoPIC_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        EncontradoPIC_5.setBackground(new java.awt.Color(201, 213, 181));
        EncontradoPIC_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        EncontradoPIC_6.setBackground(new java.awt.Color(201, 213, 181));
        EncontradoPIC_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        EncontradoPIC_7.setBackground(new java.awt.Color(201, 213, 181));
        EncontradoPIC_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 213, 181), 4));

        AboutEncontradoBTN_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutEncontradoBTN_1.setForeground(new java.awt.Color(57, 106, 64));
        AboutEncontradoBTN_1.setText("Sobre o pet");
        AboutEncontradoBTN_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutEncontradoBTN_1ActionPerformed(evt);
            }
        });

        AboutEncontradoBTN_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutEncontradoBTN_2.setForeground(new java.awt.Color(57, 106, 64));
        AboutEncontradoBTN_2.setText("Sobre o pet");
        AboutEncontradoBTN_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutEncontradoBTN_2ActionPerformed(evt);
            }
        });

        AboutEncontradoBTN_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutEncontradoBTN_3.setForeground(new java.awt.Color(57, 106, 64));
        AboutEncontradoBTN_3.setText("Sobre o pet");
        AboutEncontradoBTN_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutEncontradoBTN_3ActionPerformed(evt);
            }
        });

        AboutEncontradoBTN_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutEncontradoBTN_4.setForeground(new java.awt.Color(57, 106, 64));
        AboutEncontradoBTN_4.setText("Sobre o pet");
        AboutEncontradoBTN_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutEncontradoBTN_4ActionPerformed(evt);
            }
        });

        AboutEncontradoBTN_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutEncontradoBTN_5.setForeground(new java.awt.Color(57, 106, 64));
        AboutEncontradoBTN_5.setText("Sobre o pet");
        AboutEncontradoBTN_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutEncontradoBTN_5ActionPerformed(evt);
            }
        });

        AboutEncontradoBTN_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutEncontradoBTN_6.setForeground(new java.awt.Color(57, 106, 64));
        AboutEncontradoBTN_6.setText("Sobre o pet");
        AboutEncontradoBTN_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutEncontradoBTN_6ActionPerformed(evt);
            }
        });

        AboutEncontradoBTN_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        AboutEncontradoBTN_7.setForeground(new java.awt.Color(57, 106, 64));
        AboutEncontradoBTN_7.setText("Sobre o pet");
        AboutEncontradoBTN_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutEncontradoBTN_7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CentralPainelLayout = new javax.swing.GroupLayout(CentralPainel);
        CentralPainel.setLayout(CentralPainelLayout);
        CentralPainelLayout.setHorizontalGroup(
            CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentralPainelLayout.createSequentialGroup()
                .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentralPainelLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(CentralPainelLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_animaisPerdidos)
                            .addGroup(CentralPainelLayout.createSequentialGroup()
                                .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CentralPainelLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(AboutPerdidoBTN_1))
                                    .addComponent(PerdidoPic_1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CentralPainelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(PerdidoPic_2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(PerdidoPic_3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(PerdidoPic_4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(PerdidoPic_5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(PerdidoPic_6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(PerdidoPic_7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(CentralPainelLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(AboutPerdidoBTN_2)
                                        .addGap(46, 46, 46)
                                        .addComponent(AboutPerdidoBTN_3)
                                        .addGap(46, 46, 46)
                                        .addComponent(AboutPerdidoBTN_4)
                                        .addGap(47, 47, 47)
                                        .addComponent(AboutPerdidoBTN_5)
                                        .addGap(46, 46, 46)
                                        .addComponent(AboutPerdidoBTN_6)
                                        .addGap(45, 45, 45)
                                        .addComponent(AboutPerdidoBTN_7))))
                            .addComponent(jLabel2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CentralPainelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(EncontradoPIC_1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EncontradoPIC_2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EncontradoPIC_3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EncontradoPIC_4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EncontradoPIC_5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EncontradoPIC_6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EncontradoPIC_7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(CentralPainelLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(AboutEncontradoBTN_1)
                        .addGap(46, 46, 46)
                        .addComponent(AboutEncontradoBTN_2)
                        .addGap(45, 45, 45)
                        .addComponent(AboutEncontradoBTN_3)
                        .addGap(47, 47, 47)
                        .addComponent(AboutEncontradoBTN_4)
                        .addGap(45, 45, 45)
                        .addComponent(AboutEncontradoBTN_5)
                        .addGap(46, 46, 46)
                        .addComponent(AboutEncontradoBTN_6)
                        .addGap(46, 46, 46)
                        .addComponent(AboutEncontradoBTN_7)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        CentralPainelLayout.setVerticalGroup(
            CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentralPainelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(TXT_animaisPerdidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PerdidoPic_1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PerdidoPic_2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PerdidoPic_3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PerdidoPic_4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PerdidoPic_5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PerdidoPic_6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PerdidoPic_7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AboutPerdidoBTN_1)
                    .addComponent(AboutPerdidoBTN_2)
                    .addComponent(AboutPerdidoBTN_3)
                    .addComponent(AboutPerdidoBTN_4)
                    .addComponent(AboutPerdidoBTN_5)
                    .addComponent(AboutPerdidoBTN_6)
                    .addComponent(AboutPerdidoBTN_7))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EncontradoPIC_2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EncontradoPIC_1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EncontradoPIC_3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EncontradoPIC_4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EncontradoPIC_5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EncontradoPIC_6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EncontradoPIC_7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CentralPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AboutEncontradoBTN_1)
                    .addComponent(AboutEncontradoBTN_2)
                    .addComponent(AboutEncontradoBTN_3)
                    .addComponent(AboutEncontradoBTN_4)
                    .addComponent(AboutEncontradoBTN_5)
                    .addComponent(AboutEncontradoBTN_6)
                    .addComponent(AboutEncontradoBTN_7))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        TopLogoLabel.setBackground(new java.awt.Color(201, 213, 181));
        TopLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LogoPrincipal.png"))); // NOI18N

        InitialLostButtonVIEW.setBackground(new java.awt.Color(201, 213, 181));
        InitialLostButtonVIEW.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        InitialLostButtonVIEW.setForeground(new java.awt.Color(57, 106, 64));
        InitialLostButtonVIEW.setText("Perdidos");
        InitialLostButtonVIEW.setFocusable(false);
        InitialLostButtonVIEW.setRolloverEnabled(false);
        InitialLostButtonVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InitialLostButtonVIEWActionPerformed(evt);
            }
        });

        InitialFoundButtonVIEW.setBackground(new java.awt.Color(201, 213, 181));
        InitialFoundButtonVIEW.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        InitialFoundButtonVIEW.setForeground(new java.awt.Color(57, 106, 64));
        InitialFoundButtonVIEW.setText("Resgatados");
        InitialFoundButtonVIEW.setToolTipText("");
        InitialFoundButtonVIEW.setFocusable(false);
        InitialFoundButtonVIEW.setRolloverEnabled(false);

        InitialCadButtonVIEW.setBackground(new java.awt.Color(201, 213, 181));
        InitialCadButtonVIEW.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        InitialCadButtonVIEW.setForeground(new java.awt.Color(57, 106, 64));
        InitialCadButtonVIEW.setText("Cadastrar pet");
        InitialCadButtonVIEW.setToolTipText("");
        InitialCadButtonVIEW.setFocusable(false);
        InitialCadButtonVIEW.setRolloverEnabled(false);
        InitialCadButtonVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InitialCadButtonVIEWActionPerformed(evt);
            }
        });

        quitBTN.setBackground(new java.awt.Color(201, 213, 181));
        quitBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/quit2.png"))); // NOI18N
        quitBTN.setRolloverEnabled(false);
        quitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBTNActionPerformed(evt);
            }
        });

        InitialLoginPhotoButtonVIEW.setBackground(new java.awt.Color(201, 213, 181));
        InitialLoginPhotoButtonVIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PenguimPerfil.png"))); // NOI18N

        alertBTN.setBackground(new java.awt.Color(201, 213, 181));
        alertBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Black_alert.png"))); // NOI18N
        alertBTN.setBorderPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CentralPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(TopLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InitialLostButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InitialFoundButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(InitialCadButtonVIEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InitialLoginPhotoButtonVIEW)
                            .addComponent(alertBTN))
                        .addGap(45, 45, 45)
                        .addComponent(quitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InitialLostButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InitialFoundButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InitialCadButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TopLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alertBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InitialLoginPhotoButtonVIEW)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(CentralPainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InitialCadButtonVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InitialCadButtonVIEWActionPerformed
        AdicionaPet Ad_Pet = new AdicionaPet();

        dispose();

        Ad_Pet.setVisible(true);
    }//GEN-LAST:event_InitialCadButtonVIEWActionPerformed

    private void quitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBTNActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitBTNActionPerformed

    private void InitialLostButtonVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InitialLostButtonVIEWActionPerformed
        PerdidosScreen perdido = new PerdidosScreen();

        dispose();

        perdido.setVisible(true);
    }//GEN-LAST:event_InitialLostButtonVIEWActionPerformed

    private void AboutPerdidoBTN_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutPerdidoBTN_1ActionPerformed
        int i = 1;
        dispose();
        Sobre_O_Pet sp = new Sobre_O_Pet(perdido1, i);

        sp.setVisible(true);
    }//GEN-LAST:event_AboutPerdidoBTN_1ActionPerformed

    private void AboutPerdidoBTN_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutPerdidoBTN_2ActionPerformed
        int i = 1;
        dispose();
        Sobre_O_Pet sp = new Sobre_O_Pet(perdido2, i);

        sp.setVisible(true);
    }//GEN-LAST:event_AboutPerdidoBTN_2ActionPerformed

    private void AboutPerdidoBTN_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutPerdidoBTN_3ActionPerformed
        int i = 1;
        dispose();
        Sobre_O_Pet sp = new Sobre_O_Pet(perdido3, i);

        sp.setVisible(true);
    }//GEN-LAST:event_AboutPerdidoBTN_3ActionPerformed

    private void AboutPerdidoBTN_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutPerdidoBTN_4ActionPerformed
        int i = 1;
        dispose();
        Sobre_O_Pet sp = new Sobre_O_Pet(perdido4, i);

        sp.setVisible(true);
    }//GEN-LAST:event_AboutPerdidoBTN_4ActionPerformed

    private void AboutPerdidoBTN_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutPerdidoBTN_5ActionPerformed
        int i = 1;
        dispose();
        Sobre_O_Pet sp = new Sobre_O_Pet(perdido5, i);

        sp.setVisible(true);
    }//GEN-LAST:event_AboutPerdidoBTN_5ActionPerformed

    private void AboutPerdidoBTN_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutPerdidoBTN_6ActionPerformed
        int i = 1;
        dispose();
        Sobre_O_Pet sp = new Sobre_O_Pet(perdido6, i);

        sp.setVisible(true);
    }//GEN-LAST:event_AboutPerdidoBTN_6ActionPerformed

    private void AboutPerdidoBTN_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutPerdidoBTN_7ActionPerformed
        int i = 1;
        dispose();
        Sobre_O_Pet sp = new Sobre_O_Pet(perdido7, i);

        sp.setVisible(true);
    }//GEN-LAST:event_AboutPerdidoBTN_7ActionPerformed

    private void AboutEncontradoBTN_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutEncontradoBTN_1ActionPerformed
        dispose();

        SobreEcontrado se = new SobreEcontrado(encontrado1);

        se.setVisible(true);
    }//GEN-LAST:event_AboutEncontradoBTN_1ActionPerformed

    private void AboutEncontradoBTN_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutEncontradoBTN_2ActionPerformed
        dispose();

        SobreEcontrado se = new SobreEcontrado(encontrado2);

        se.setVisible(true);
    }//GEN-LAST:event_AboutEncontradoBTN_2ActionPerformed

    private void AboutEncontradoBTN_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutEncontradoBTN_3ActionPerformed
        dispose();

        SobreEcontrado se = new SobreEcontrado(encontrado3);

        se.setVisible(true);
    }//GEN-LAST:event_AboutEncontradoBTN_3ActionPerformed

    private void AboutEncontradoBTN_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutEncontradoBTN_4ActionPerformed
        dispose();

        SobreEcontrado se = new SobreEcontrado(encontrado4);

        se.setVisible(true);
    }//GEN-LAST:event_AboutEncontradoBTN_4ActionPerformed

    private void AboutEncontradoBTN_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutEncontradoBTN_5ActionPerformed
        dispose();

        SobreEcontrado se = new SobreEcontrado(encontrado5);

        se.setVisible(true);
    }//GEN-LAST:event_AboutEncontradoBTN_5ActionPerformed

    private void AboutEncontradoBTN_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutEncontradoBTN_6ActionPerformed
        dispose();

        SobreEcontrado se = new SobreEcontrado(encontrado6);

        se.setVisible(true);
    }//GEN-LAST:event_AboutEncontradoBTN_6ActionPerformed

    private void AboutEncontradoBTN_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutEncontradoBTN_7ActionPerformed
        dispose();

        SobreEcontrado se = new SobreEcontrado(encontrado7);

        se.setVisible(true);
    }//GEN-LAST:event_AboutEncontradoBTN_7ActionPerformed

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
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaInicial().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutEncontradoBTN_1;
    private javax.swing.JButton AboutEncontradoBTN_2;
    private javax.swing.JButton AboutEncontradoBTN_3;
    private javax.swing.JButton AboutEncontradoBTN_4;
    private javax.swing.JButton AboutEncontradoBTN_5;
    private javax.swing.JButton AboutEncontradoBTN_6;
    private javax.swing.JButton AboutEncontradoBTN_7;
    private javax.swing.JButton AboutPerdidoBTN_1;
    private javax.swing.JButton AboutPerdidoBTN_2;
    private javax.swing.JButton AboutPerdidoBTN_3;
    private javax.swing.JButton AboutPerdidoBTN_4;
    private javax.swing.JButton AboutPerdidoBTN_5;
    private javax.swing.JButton AboutPerdidoBTN_6;
    private javax.swing.JButton AboutPerdidoBTN_7;
    private javax.swing.JPanel CentralPainel;
    private javax.swing.JLabel EncontradoPIC_1;
    private javax.swing.JLabel EncontradoPIC_2;
    private javax.swing.JLabel EncontradoPIC_3;
    private javax.swing.JLabel EncontradoPIC_4;
    private javax.swing.JLabel EncontradoPIC_5;
    private javax.swing.JLabel EncontradoPIC_6;
    private javax.swing.JLabel EncontradoPIC_7;
    private javax.swing.JButton InitialCadButtonVIEW;
    private javax.swing.JButton InitialFoundButtonVIEW;
    private javax.swing.JButton InitialLoginPhotoButtonVIEW;
    private javax.swing.JButton InitialLostButtonVIEW;
    private javax.swing.JLabel PerdidoPic_1;
    private javax.swing.JLabel PerdidoPic_2;
    private javax.swing.JLabel PerdidoPic_3;
    private javax.swing.JLabel PerdidoPic_4;
    private javax.swing.JLabel PerdidoPic_5;
    private javax.swing.JLabel PerdidoPic_6;
    private javax.swing.JLabel PerdidoPic_7;
    private javax.swing.JLabel TXT_animaisPerdidos;
    private javax.swing.JLabel TopLogoLabel;
    private javax.swing.JButton alertBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton quitBTN;
    // End of variables declaration//GEN-END:variables
 
    
    /*private void carregarFotosAnimaisPerdidos() {
        int i = 1;
        int id_local = Sessao.getInstance().getLoggedUserLocationID();
        List<JLabel> labels = List.of(PerdidoPic_1, PerdidoPic_2, PerdidoPic_3, PerdidoPic_4, PerdidoPic_5, PerdidoPic_6);

        AtualizarFotos.loadAnimalPhotos(id_local, labels, i);
    }

    private void carregarFotosAnimaisEncontrados() {
        int i = 2;
        int id_local = Sessao.getInstance().getLoggedUserLocationID();
        List<JLabel> labels = List.of(EncontradoPIC_1, EncontradoPIC_2, EncontradoPIC_3, EncontradoPIC_4, EncontradoPIC_5, EncontradoPIC_6, EncontradoPIC_7);

        AtualizarFotos.loadAnimalPhotos(id_local, labels, i);
    }*/
}
