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


import DAO.UsuarioDAO;
import DTO.PetDTO;
import DTO.UsuarioDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import petServices.Sessao;

/**
 *
 * @author Kalisto
 */
public class LoginScreen extends javax.swing.JFrame {

   private boolean visibilidadeSenha = false;
   
   
    public LoginScreen() {
        
         //Removendo a decoração padrao
        setUndecorated(true);
        
        initComponents();   
         
        FlatLightLaf.setup();

        
        // Crie um novo JPanel com o fundo colorido
        JPanel backgroundLogin = new JPanel();
        backgroundLogin.setBackground(new Color(201,213,181));
        backgroundLogin.setOpaque(true);
        
        // Definindo o layout do JPanel como null para permitir a sobreposição
        backgroundLogin.setLayout(null);
        
        // Adicione o JPanel como plano de fundo
        backgroundLogin.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLogin);
        
        
        //Forma arredondada do Jframe
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        
        
        Color minhaCor = new Color(255, 0, 0); // Substitua pela sua cor personalizada

        Border customBorder = BorderFactory.createLineBorder(minhaCor, 2); // 2 é a largura da borda

       
        
   
        LoginCheckShowPswrVIEW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visibilidadeSenha = LoginCheckShowPswrVIEW.isSelected();
                visivel();
            }
        });

    }

    private void visivel() {
        if (visibilidadeSenha) {
            // Se a caixa de seleção estiver marcada, mostre a senha
            LoginUsrPasswordVIEW.setEchoChar((char) 0); // Define o caractere de eco como nulo para mostrar o texto
        } else {
            // Se a caixa de seleção estiver desmarcada, oculte a senha
            LoginUsrPasswordVIEW.setEchoChar('\u2022'); // Define o caractere de eco como um círculo para ocultar o texto   
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginQuitButtonVIEW = new javax.swing.JButton();
        LogintUsrLoginVIEW = new javax.swing.JTextField();
        LoginTxtLoginVIEW = new javax.swing.JLabel();
        LoginTxtSenhaVIEW = new javax.swing.JLabel();
        LoginUsrPasswordVIEW = new javax.swing.JPasswordField();
        LoginCheckShowPswrVIEW = new javax.swing.JCheckBox();
        LoginEnterButtonVIEW = new javax.swing.JButton();
        LoginCadButtonVIEW = new javax.swing.JButton();
        LoginMainLogoVIEW = new javax.swing.JLabel();
        LoginDogIconVIEW = new javax.swing.JLabel();
        LoginCatIconVIEW = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setName("Login"); // NOI18N

        LoginQuitButtonVIEW.setBackground(new java.awt.Color(201, 213, 181));
        LoginQuitButtonVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginQuitButtonVIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/quit2.png"))); // NOI18N
        LoginQuitButtonVIEW.setBorderPainted(false);
        LoginQuitButtonVIEW.setName("ExitLoginButton"); // NOI18N
        LoginQuitButtonVIEW.setRolloverEnabled(false);
        LoginQuitButtonVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginQuitButtonVIEWActionPerformed(evt);
            }
        });

        LogintUsrLoginVIEW.setToolTipText("");
        LogintUsrLoginVIEW.setName("LoginText"); // NOI18N
        LogintUsrLoginVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogintUsrLoginVIEWActionPerformed(evt);
            }
        });

        LoginTxtLoginVIEW.setBackground(new java.awt.Color(201, 213, 181));
        LoginTxtLoginVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginTxtLoginVIEW.setForeground(new java.awt.Color(57, 106, 64));
        LoginTxtLoginVIEW.setText("Login");

        LoginTxtSenhaVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginTxtSenhaVIEW.setForeground(new java.awt.Color(57, 106, 64));
        LoginTxtSenhaVIEW.setText("Senha");

        LoginUsrPasswordVIEW.setCaretColor(new java.awt.Color(57, 106, 64));
        LoginUsrPasswordVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginUsrPasswordVIEWActionPerformed(evt);
            }
        });

        LoginCheckShowPswrVIEW.setBackground(new java.awt.Color(201, 213, 181));
        LoginCheckShowPswrVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginCheckShowPswrVIEW.setForeground(new java.awt.Color(57, 106, 64));
        LoginCheckShowPswrVIEW.setText("Mostra Senha");
        LoginCheckShowPswrVIEW.setRolloverEnabled(false);
        LoginCheckShowPswrVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginCheckShowPswrVIEWActionPerformed(evt);
            }
        });

        LoginEnterButtonVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginEnterButtonVIEW.setForeground(new java.awt.Color(57, 106, 64));
        LoginEnterButtonVIEW.setText("Entrar");
        LoginEnterButtonVIEW.setRequestFocusEnabled(false);
        LoginEnterButtonVIEW.setRolloverEnabled(false);
        LoginEnterButtonVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginEnterButtonVIEWActionPerformed(evt);
            }
        });

        LoginCadButtonVIEW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginCadButtonVIEW.setForeground(new java.awt.Color(57, 106, 64));
        LoginCadButtonVIEW.setText("Cadastrar");
        LoginCadButtonVIEW.setFocusPainted(false);
        LoginCadButtonVIEW.setFocusable(false);
        LoginCadButtonVIEW.setRolloverEnabled(false);
        LoginCadButtonVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginCadButtonVIEWActionPerformed(evt);
            }
        });

        LoginMainLogoVIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LogoPrincipal.png"))); // NOI18N

        LoginDogIconVIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/dog_shadowIC .png"))); // NOI18N

        LoginCatIconVIEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cat_shadowIC .png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(LoginCatIconVIEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LoginTxtSenhaVIEW))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LoginCadButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LoginEnterButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LoginUsrPasswordVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LoginCheckShowPswrVIEW)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(LoginMainLogoVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LoginDogIconVIEW)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LoginTxtLoginVIEW))
                                    .addComponent(LogintUsrLoginVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LoginQuitButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginQuitButtonVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(LoginMainLogoVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LoginTxtLoginVIEW)
                    .addComponent(LoginDogIconVIEW))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogintUsrLoginVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginTxtSenhaVIEW, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LoginCatIconVIEW, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginUsrPasswordVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginCheckShowPswrVIEW)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginEnterButtonVIEW)
                    .addComponent(LoginCadButtonVIEW))
                .addGap(11, 11, 11))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogintUsrLoginVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogintUsrLoginVIEWActionPerformed
       
    }//GEN-LAST:event_LogintUsrLoginVIEWActionPerformed

    private void LoginCheckShowPswrVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginCheckShowPswrVIEWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginCheckShowPswrVIEWActionPerformed

    private void LoginEnterButtonVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginEnterButtonVIEWActionPerformed
        
        Sessao section = Sessao.getInstance();
        
        
        
        try {
        
        PetDTO petCPF = new PetDTO();

        // declaração de variáveis
        String nome_usr;
        UsuarioDTO user = new UsuarioDTO();

        // Instanciando um usuarioDAO
        UsuarioDAO usrDAO = new UsuarioDAO();

        // o campo JPassword funciona como um array
        char[] senha_usr;

        // as variáveis irão receber o conteúdo contido nos campos indicados
        senha_usr = LoginUsrPasswordVIEW.getPassword();
        nome_usr = LogintUsrLoginVIEW.getText();

        // O conteúdo que vem do JPassword é um array e
        // é preciso converter o array para uma string
        String senha = new String(senha_usr);
        
        // mudando as variáveis da classe UsuarioDTO
        user.setNome_usr(nome_usr);
        user.setSenha_usr(senha);

        // passando todos os dados do usuário para a consulta no SQL
        ResultSet resConsulta = (ResultSet) usrDAO.autenticacaoUsr(user);
        
        
        
        // Se houver ao menos uma linha no banco de dados
        if (resConsulta.next()) {
            //Armazenando o cpf do usuario logado para poder salvar para cadastro de um pet
            int local = resConsulta.getInt("id_local");
            petCPF.setUsr_cpf(resConsulta.getString("cpf"));
            

            // Configurar informações do usuário na sessão
            section.setLoggedUser(petCPF.getUsr_cpf(), user.getNome_usr(), local);
            
            
            // Chamar tela inicial
            dispose();
            setVisible(false);
            telaInicial tl = new telaInicial();
            tl.setVisible(true);

        } else {
            // Mensagem de erro
            JOptionPane.showMessageDialog(null, "Usuário ou senha Inválida");
        }

    } catch (SQLException erro) {
        // Aparece uma msg LoginVIEW para facilitar de encontrar em que classe está o erro
        JOptionPane.showMessageDialog(null, "LoginVIEW: " + erro);
    }

       
    }//GEN-LAST:event_LoginEnterButtonVIEWActionPerformed

    
   
    
    private void LoginUsrPasswordVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginUsrPasswordVIEWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginUsrPasswordVIEWActionPerformed

    private void LoginCadButtonVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginCadButtonVIEWActionPerformed
       cadScreen cad = new cadScreen();
       cad.setVisible(true);
       setVisible(false);
       dispose();
    }//GEN-LAST:event_LoginCadButtonVIEWActionPerformed

    private void LoginQuitButtonVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginQuitButtonVIEWActionPerformed

        System.exit(0);
    }//GEN-LAST:event_LoginQuitButtonVIEWActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginCadButtonVIEW;
    private javax.swing.JLabel LoginCatIconVIEW;
    private javax.swing.JCheckBox LoginCheckShowPswrVIEW;
    private javax.swing.JLabel LoginDogIconVIEW;
    private javax.swing.JButton LoginEnterButtonVIEW;
    private javax.swing.JLabel LoginMainLogoVIEW;
    private javax.swing.JButton LoginQuitButtonVIEW;
    private javax.swing.JLabel LoginTxtLoginVIEW;
    private javax.swing.JLabel LoginTxtSenhaVIEW;
    private javax.swing.JPasswordField LoginUsrPasswordVIEW;
    private javax.swing.JTextField LogintUsrLoginVIEW;
    // End of variables declaration//GEN-END:variables
}
