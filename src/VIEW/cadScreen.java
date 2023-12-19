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
import DAO.Cadastrar_usr;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import com.formdev.flatlaf.FlatLightLaf;
import com.mysql.cj.protocol.Resultset;
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
import java.sql.ResultSet;
import petServices.getLocais;

public class cadScreen extends javax.swing.JFrame {

    Vector<Integer> estados = new Vector<Integer>();

    private boolean senhaVisivel = false;

    public cadScreen() {

        //Removendo decoração padrão
        setUndecorated(true);

        initComponents();

        FundoLayout();

        getLocais locais = new getLocais();

        locais.getEstados(estados, cadComboUF_VIEW);

        //Observador de mudanças para saber se o botão de mostrar a senha está selecionada ou não
        CadCheckShowPswdVIEW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                senhaVisivel = CadCheckShowPswdVIEW.isSelected();
                mudarVisibilidade();
            }
        });

        //Obersvador para pegar a cidade pelo estado
        cadComboUF_VIEW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Obter o ID do estado selecionado na primeira ComboBox
                int idEstadoSelecionado = estados.get(cadComboUF_VIEW.getSelectedIndex());

                //Chamar o método para preencher o comboBox da cidade
                locais.getCidadesByEstado(idEstadoSelecionado, CadComboCIDADE_VIEW);
               
            }
        });

        // Adicionando um ouvinte de ação para a JComboBox de mês
        CadMesChooserVIEW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarDias();
            }
        });

        // Adicionando um ouvinte de ação para a JComboBox de ano
        CadAnoChooserVIEW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarDias();
            }
        });

    }

    private void mudarVisibilidade() {
        if (senhaVisivel) {
            // Se a caixa de seleção estiver marcada, mostre a senha
            CadPasswordVIEW.setEchoChar((char) 0); // Define o caractere de eco como nulo para mostrar o texto
            CadConfirmPasswordVIEW.setEchoChar((char) 0); // O mesmo para o campo de confirmação de senha
        } else {
            // Se a caixa de seleção estiver desmarcada, oculte a senha
            CadPasswordVIEW.setEchoChar('\u2022'); // Define o caractere de eco como um círculo para ocultar o texto
            CadConfirmPasswordVIEW.setEchoChar('\u2022'); // O mesmo para o campo de confirmação de senha
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

    private void atualizarDias() {
        // Obtendo o mês e ano selecionados
        String mesSelecionado = (String) CadMesChooserVIEW.getSelectedItem();
        String anoSelecionado = (String) CadAnoChooserVIEW.getSelectedItem();

        // Convertendo o mês para um número inteiro
        int mes = Integer.parseInt(mesSelecionado);

        // Lógica para determinar os dias disponíveis com base no mês e ano
        int diasNoMes;
        if (mes == 2) {
            // Fevereiro
            int ano = Integer.parseInt(anoSelecionado);
            if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                // Ano bissexto
                diasNoMes = 29;
            } else {
                // Não é um ano bissexto
                diasNoMes = 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            // Abril, Junho, Setembro, Novembro
            diasNoMes = 30;
        } else {
            // Outros meses
            diasNoMes = 31;
        }

        // Atualizando a lista de dias na JComboBox de dia
        CadDiaChooserVIEW.removeAllItems();
        for (int i = 1; i <= diasNoMes; i++) {
            //"%02d" é um modo de formatar uma string para que caso seja um numero de 0 a 9
            //o número receba um 0 na frente ex 2 = 02, 3 = 03;
            CadDiaChooserVIEW.addItem(String.format("%02d", i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        CadQuitButtonVIEW = new javax.swing.JButton();
        CadTextCadastreseVIEW = new javax.swing.JTextField();
        CadCpfVIEW = new javax.swing.JTextField();
        CadNameVIEW = new javax.swing.JTextField();
        CadTextLoginVIEW = new javax.swing.JTextField();
        CadTxtNomeVIEW = new javax.swing.JTextField();
        CadTxtDateVIEW = new javax.swing.JTextField();
        CadTxtSenhaVIEW = new javax.swing.JTextField();
        CadtxtConfirmeSVIEW = new javax.swing.JTextField();
        CadCheckShowPswdVIEW = new javax.swing.JCheckBox();
        CadCancelButtonVIEW = new javax.swing.JButton();
        CadConfirmButtonVIEW = new javax.swing.JButton();
        CadLogoIconVIEW = new javax.swing.JLabel();
        CadDiaChooserVIEW = new javax.swing.JComboBox<>();
        TXTDiaCadVIEW = new javax.swing.JLabel();
        TXTMesCadVIEW = new javax.swing.JLabel();
        CadMesChooserVIEW = new javax.swing.JComboBox<>();
        CadAnoChooserVIEW = new javax.swing.JComboBox<>();
        CadPasswordVIEW = new javax.swing.JPasswordField();
        TXTAnoCadVIEW = new javax.swing.JLabel();
        CadConfirmPasswordVIEW = new javax.swing.JPasswordField();
        CadTxtEMAIL_VIEW = new javax.swing.JTextField();
        CadTxtWHATS_VIEW = new javax.swing.JTextField();
        CadTxtUFVIEW1 = new javax.swing.JTextField();
        CadTxtCIDADEVIEW = new javax.swing.JTextField();
        cadComboUF_VIEW = new javax.swing.JComboBox<>();
        CadComboCIDADE_VIEW = new javax.swing.JComboBox<>();
        cadEMAIL_VIEW = new javax.swing.JTextField();
        cadWHATS_VIEW = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CadQuitButtonVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadQuitButtonVIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/quit2.png"))); // NOI18N
        CadQuitButtonVIEW.setBorderPainted(false);
        CadQuitButtonVIEW.setName("QuitCadButton"); // NOI18N
        CadQuitButtonVIEW.setRolloverEnabled(false);
        CadQuitButtonVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadQuitButtonVIEWActionPerformed(evt);
            }
        });

        CadTextCadastreseVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadTextCadastreseVIEW.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        CadTextCadastreseVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadTextCadastreseVIEW.setText("CADASTRE-SE");
        CadTextCadastreseVIEW.setBorder(null);
        CadTextCadastreseVIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTextCadastreseVIEW.setFocusable(false);
        CadTextCadastreseVIEW.setRequestFocusEnabled(false);
        CadTextCadastreseVIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTextCadastreseVIEW.setVerifyInputWhenFocusTarget(false);

        CadCpfVIEW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(57, 106, 64)));
        CadCpfVIEW.setCaretColor(new java.awt.Color(57, 106, 64));

        CadNameVIEW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(57, 106, 64)));
        CadNameVIEW.setCaretColor(new java.awt.Color(57, 106, 64));

        CadTextLoginVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadTextLoginVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadTextLoginVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadTextLoginVIEW.setText("DIGITE SEU CPF");
        CadTextLoginVIEW.setActionCommand("<Not Set>");
        CadTextLoginVIEW.setBorder(null);
        CadTextLoginVIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTextLoginVIEW.setFocusable(false);
        CadTextLoginVIEW.setName("cpf"); // NOI18N
        CadTextLoginVIEW.setRequestFocusEnabled(false);
        CadTextLoginVIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTextLoginVIEW.setVerifyInputWhenFocusTarget(false);

        CadTxtNomeVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadTxtNomeVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadTxtNomeVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadTxtNomeVIEW.setText("DIGITE SEU NOME");
        CadTxtNomeVIEW.setBorder(null);
        CadTxtNomeVIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTxtNomeVIEW.setFocusable(false);
        CadTxtNomeVIEW.setName("nome"); // NOI18N
        CadTxtNomeVIEW.setRequestFocusEnabled(false);
        CadTxtNomeVIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTxtNomeVIEW.setVerifyInputWhenFocusTarget(false);

        CadTxtDateVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadTxtDateVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadTxtDateVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadTxtDateVIEW.setText("DATA DE NASCIMENTO");
        CadTxtDateVIEW.setBorder(null);
        CadTxtDateVIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTxtDateVIEW.setFocusable(false);
        CadTxtDateVIEW.setName("dataNasc"); // NOI18N
        CadTxtDateVIEW.setRequestFocusEnabled(false);
        CadTxtDateVIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTxtDateVIEW.setVerifyInputWhenFocusTarget(false);

        CadTxtSenhaVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadTxtSenhaVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadTxtSenhaVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadTxtSenhaVIEW.setText("SENHA:");
        CadTxtSenhaVIEW.setBorder(null);
        CadTxtSenhaVIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTxtSenhaVIEW.setFocusable(false);
        CadTxtSenhaVIEW.setName("senha"); // NOI18N
        CadTxtSenhaVIEW.setRequestFocusEnabled(false);
        CadTxtSenhaVIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTxtSenhaVIEW.setVerifyInputWhenFocusTarget(false);

        CadtxtConfirmeSVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadtxtConfirmeSVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadtxtConfirmeSVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadtxtConfirmeSVIEW.setText("CONFIRME A SENHA");
        CadtxtConfirmeSVIEW.setBorder(null);
        CadtxtConfirmeSVIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadtxtConfirmeSVIEW.setFocusable(false);
        CadtxtConfirmeSVIEW.setName("senhaConfirm"); // NOI18N
        CadtxtConfirmeSVIEW.setRequestFocusEnabled(false);
        CadtxtConfirmeSVIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadtxtConfirmeSVIEW.setVerifyInputWhenFocusTarget(false);

        CadCheckShowPswdVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadCheckShowPswdVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadCheckShowPswdVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadCheckShowPswdVIEW.setText("Mostrar senha");
        CadCheckShowPswdVIEW.setRolloverEnabled(false);

        CadCancelButtonVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadCancelButtonVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadCancelButtonVIEW.setText("Cancelar");
        CadCancelButtonVIEW.setRolloverEnabled(false);
        CadCancelButtonVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadCancelButtonVIEWActionPerformed(evt);
            }
        });

        CadConfirmButtonVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadConfirmButtonVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadConfirmButtonVIEW.setText("Confirmar");
        CadConfirmButtonVIEW.setRolloverEnabled(false);
        CadConfirmButtonVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadConfirmButtonVIEWActionPerformed(evt);
            }
        });

        CadLogoIconVIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CadIcon.png"))); // NOI18N

        CadDiaChooserVIEW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        TXTDiaCadVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TXTDiaCadVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTDiaCadVIEW.setText("DIA");

        TXTMesCadVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TXTMesCadVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTMesCadVIEW.setText("MÊS");

        CadMesChooserVIEW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        CadAnoChooserVIEW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        CadPasswordVIEW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(57, 106, 64)));
        CadPasswordVIEW.setMinimumSize(new java.awt.Dimension(64, 31));

        TXTAnoCadVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TXTAnoCadVIEW.setForeground(new java.awt.Color(57, 106, 64));
        TXTAnoCadVIEW.setText("ANO");

        CadConfirmPasswordVIEW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(57, 106, 64)));

        CadTxtEMAIL_VIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadTxtEMAIL_VIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadTxtEMAIL_VIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadTxtEMAIL_VIEW.setText("EMAIL:");
        CadTxtEMAIL_VIEW.setBorder(null);
        CadTxtEMAIL_VIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTxtEMAIL_VIEW.setFocusable(false);
        CadTxtEMAIL_VIEW.setName("senhaConfirm"); // NOI18N
        CadTxtEMAIL_VIEW.setRequestFocusEnabled(false);
        CadTxtEMAIL_VIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTxtEMAIL_VIEW.setVerifyInputWhenFocusTarget(false);

        CadTxtWHATS_VIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadTxtWHATS_VIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadTxtWHATS_VIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadTxtWHATS_VIEW.setText("WHATSAPP:");
        CadTxtWHATS_VIEW.setBorder(null);
        CadTxtWHATS_VIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTxtWHATS_VIEW.setFocusable(false);
        CadTxtWHATS_VIEW.setName("senhaConfirm"); // NOI18N
        CadTxtWHATS_VIEW.setRequestFocusEnabled(false);
        CadTxtWHATS_VIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTxtWHATS_VIEW.setVerifyInputWhenFocusTarget(false);

        CadTxtUFVIEW1.setBackground(new java.awt.Color(201, 213, 181));
        CadTxtUFVIEW1.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadTxtUFVIEW1.setForeground(new java.awt.Color(57, 106, 64));
        CadTxtUFVIEW1.setText("UF:");
        CadTxtUFVIEW1.setBorder(null);
        CadTxtUFVIEW1.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTxtUFVIEW1.setFocusable(false);
        CadTxtUFVIEW1.setName("dataNasc"); // NOI18N
        CadTxtUFVIEW1.setRequestFocusEnabled(false);
        CadTxtUFVIEW1.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTxtUFVIEW1.setVerifyInputWhenFocusTarget(false);

        CadTxtCIDADEVIEW.setBackground(new java.awt.Color(201, 213, 181));
        CadTxtCIDADEVIEW.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        CadTxtCIDADEVIEW.setForeground(new java.awt.Color(57, 106, 64));
        CadTxtCIDADEVIEW.setText("CIDADE:");
        CadTxtCIDADEVIEW.setBorder(null);
        CadTxtCIDADEVIEW.setCaretColor(new java.awt.Color(201, 213, 181));
        CadTxtCIDADEVIEW.setFocusable(false);
        CadTxtCIDADEVIEW.setName("dataNasc"); // NOI18N
        CadTxtCIDADEVIEW.setRequestFocusEnabled(false);
        CadTxtCIDADEVIEW.setSelectionColor(new java.awt.Color(201, 213, 181));
        CadTxtCIDADEVIEW.setVerifyInputWhenFocusTarget(false);

        cadEMAIL_VIEW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(57, 106, 64)));
        cadEMAIL_VIEW.setCaretColor(new java.awt.Color(57, 106, 64));

        cadWHATS_VIEW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(57, 106, 64)));
        cadWHATS_VIEW.setCaretColor(new java.awt.Color(57, 106, 64));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CadLogoIconVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(CadQuitButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CadCancelButtonVIEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CadConfirmButtonVIEW)
                        .addGap(27, 27, 27))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadWHATS_VIEW, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadEMAIL_VIEW, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CadNameVIEW, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addComponent(CadCpfVIEW, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addComponent(CadPasswordVIEW, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CadConfirmPasswordVIEW, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CadTxtSenhaVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(TXTDiaCadVIEW)
                                                .addGap(69, 69, 69)
                                                .addComponent(TXTMesCadVIEW)))
                                        .addGap(66, 66, 66))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(CadDiaChooserVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CadMesChooserVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CadAnoChooserVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXTAnoCadVIEW))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CadTxtUFVIEW1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cadComboUF_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CadComboCIDADE_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CadTxtCIDADEVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(CadTxtDateVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CadtxtConfirmeSVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CadTxtNomeVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CadTextLoginVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CadCheckShowPswdVIEW)
                            .addComponent(CadTxtEMAIL_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CadTxtWHATS_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(CadTextCadastreseVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CadQuitButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CadLogoIconVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CadTextCadastreseVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(CadTextLoginVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadCpfVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadTxtNomeVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadNameVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadTxtDateVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTDiaCadVIEW)
                    .addComponent(TXTMesCadVIEW)
                    .addComponent(TXTAnoCadVIEW)
                    .addComponent(CadTxtUFVIEW1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadTxtCIDADEVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CadAnoChooserVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadMesChooserVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadDiaChooserVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadComboUF_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadComboCIDADE_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadTxtSenhaVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadPasswordVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadtxtConfirmeSVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadConfirmPasswordVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CadCheckShowPswdVIEW)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadTxtEMAIL_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadEMAIL_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(CadTxtWHATS_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadWHATS_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CadCancelButtonVIEW)
                    .addComponent(CadConfirmButtonVIEW))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CadQuitButtonVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadQuitButtonVIEWActionPerformed
        dispose();
        System.exit(0);

    }//GEN-LAST:event_CadQuitButtonVIEWActionPerformed

    private void CadCancelButtonVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadCancelButtonVIEWActionPerformed
        LoginScreen ls = new LoginScreen();

        ls.setVisible(true);

        dispose();
    }//GEN-LAST:event_CadCancelButtonVIEWActionPerformed

    private void CadConfirmButtonVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadConfirmButtonVIEWActionPerformed

        salvaDados();

    }//GEN-LAST:event_CadConfirmButtonVIEWActionPerformed

    private void salvaDados() {

        //Cadastrar um usuario no banco de dados
        LoginScreen lg = new LoginScreen();

        //Instanciando objetos da DAO e DTO
        UsuarioDTO usrDados = new UsuarioDTO();
        Cadastrar_usr cad_usr = new Cadastrar_usr();

        //Declaração de variaveis
        String usr_cpf;
        String usr_nome, dia, mes, ano, data, email, whats, cidade, uf;

        String senha1 = new String(CadPasswordVIEW.getPassword());
        String senha2 = new String(CadConfirmPasswordVIEW.getPassword());

        //If-Else Para validar CPF
        if (CadCpfVIEW.getText().length() != 11) {
            //Se diferente de 11 digitos  =  cpf inválido
            JOptionPane.showMessageDialog(rootPane, "Numero de CPF inválido!");
        } else if (!senha1.equals(senha2)) {

            JOptionPane.showMessageDialog(rootPane, "Senhas não correspondem!");
        } else {

            //Caso CPF = 11 digitos, receba os dados restantes
            dia = (String) CadDiaChooserVIEW.getSelectedItem();
            mes = (String) CadMesChooserVIEW.getSelectedItem();
            ano = (String) CadAnoChooserVIEW.getSelectedItem();
            usr_cpf = (String) CadCpfVIEW.getText();
            email = (String) cadEMAIL_VIEW.getText();
            whats = (String) cadWHATS_VIEW.getText();
            uf = (String) cadComboUF_VIEW.getSelectedItem();
            cidade = (String) CadComboCIDADE_VIEW.getSelectedItem();

            // Tranformando a data, para o tipo date do SQL
            data = ano + "-" + mes + "-" + dia;

            //Recebendo nome do usuario
            usr_nome = CadNameVIEW.getText();

            //Passando os dados para a DTO
            usrDados.setData_usr(data);
            usrDados.setNome_usr(usr_nome);
            usrDados.setSenha_usr(senha1);
            usrDados.setCpf_usr(usr_cpf);
            usrDados.setEmail(email);
            usrDados.setTel(whats);
            getIDlocal(uf, cidade, usrDados);
            
            

            try {

                cad_usr.cadastrar_usr(usrDados);
                JOptionPane.showMessageDialog(null, "Cadastro, efetuado com sucesso!");
                dispose();
                lg.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(cadScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
    
    private void getIDlocal(String uf, String cidade, UsuarioDTO dados) {
        
        getLocais gl = new getLocais();
        
        int idLocal = getLocais.getIdLocal(uf, cidade);

        if (idLocal != -1) {
            dados.setId_local(idLocal);
            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um local válido!! ");
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CadAnoChooserVIEW;
    private javax.swing.JButton CadCancelButtonVIEW;
    private javax.swing.JCheckBox CadCheckShowPswdVIEW;
    private javax.swing.JComboBox<String> CadComboCIDADE_VIEW;
    private javax.swing.JButton CadConfirmButtonVIEW;
    private javax.swing.JPasswordField CadConfirmPasswordVIEW;
    private javax.swing.JTextField CadCpfVIEW;
    private javax.swing.JComboBox<String> CadDiaChooserVIEW;
    private javax.swing.JLabel CadLogoIconVIEW;
    private javax.swing.JComboBox<String> CadMesChooserVIEW;
    private javax.swing.JTextField CadNameVIEW;
    private javax.swing.JPasswordField CadPasswordVIEW;
    private javax.swing.JButton CadQuitButtonVIEW;
    private javax.swing.JTextField CadTextCadastreseVIEW;
    private javax.swing.JTextField CadTextLoginVIEW;
    private javax.swing.JTextField CadTxtCIDADEVIEW;
    private javax.swing.JTextField CadTxtDateVIEW;
    private javax.swing.JTextField CadTxtEMAIL_VIEW;
    private javax.swing.JTextField CadTxtNomeVIEW;
    private javax.swing.JTextField CadTxtSenhaVIEW;
    private javax.swing.JTextField CadTxtUFVIEW1;
    private javax.swing.JTextField CadTxtWHATS_VIEW;
    private javax.swing.JTextField CadtxtConfirmeSVIEW;
    private javax.swing.JLabel TXTAnoCadVIEW;
    private javax.swing.JLabel TXTDiaCadVIEW;
    private javax.swing.JLabel TXTMesCadVIEW;
    private javax.swing.JComboBox<String> cadComboUF_VIEW;
    private javax.swing.JTextField cadEMAIL_VIEW;
    private javax.swing.JTextField cadWHATS_VIEW;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
