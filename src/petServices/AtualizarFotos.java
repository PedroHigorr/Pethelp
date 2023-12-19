/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petServices;

import DAO.PetDAO;
import DTO.PetDTO;
import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class AtualizarFotos {

    private static PetDAO petDAO = new PetDAO();

    public static List<PetDTO> loadAnimalPhotos(int idLocal, List<JLabel> labels, int choise) {
        // Obtendo a lista de animais do banco
        List<PetDTO> animais = obterAnimaisDoBanco(idLocal, labels.size(), choise);

        

        for (int i = 0; i < labels.size(); i++) {
            PetDTO animal = (i < animais.size()) ? animais.get(i) : null;

            // Verificando se o animal é nulo antes de definir a imagem
            if (animal != null) {
                String caminho = animal.getFoto_end();
                
                definirImagemJlabel(labels.get(i), caminho);
            } else {
                
                
            }
        }
        return animais;
    }

    //Método para carregar as fotos dos animais em labels com base no id_local
    private static List<PetDTO> obterAnimaisDoBanco(int idLocal, int quantidadeLabels, int i) {
        List<PetDTO> animais = new ArrayList<>();
        ResultSet rs = null;

        if (i == 1) {
            rs = petDAO.getbasedONuser(idLocal, quantidadeLabels);
        } else if (i == 2) {
            rs = petDAO.getEncontrados(idLocal, quantidadeLabels);
        }

        try {

            while (rs.next()) {

                String fotoEnd = rs.getString("foto_end");

                if (fotoEnd != null) {
                    fotoEnd = fotoEnd.replace("\\\\", "\\");
                } else {
                    System.out.println("Caminho fotos é nulo.");
                    continue; // Pula para a próxima iteração do loop
                }

                fotoEnd = fotoEnd.replace("\\\\", "\\");
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                String raca = rs.getString("raca");
                String sexo = rs.getString("sexo");
                String porte = rs.getString("porte");
                String cor = rs.getString("cor");
                String status = rs.getString("status_animal");
                String cpf = rs.getString("usr_cpf");
                String localEncontro = rs.getString("local_encontro");
                String localDes = rs.getString("local_desaparecimento");
                // Obtenha outros campos conforme necessário

                PetDTO animal = new PetDTO();

                animal.setNome_pet(nome);
                animal.setTipo(tipo);
                animal.setRaca(raca);
                animal.setSexo(sexo);
                animal.setPorte(porte);
                animal.setCor(cor);
                animal.setStatus(status);
                animal.setUsr_cpf(cpf);
                animal.setLocal_econtro(localEncontro);
                animal.setLocal_desaparecimento(localDes);
                animal.setFoto_end(fotoEnd);
                
                /* System.out.println("Nome: " + nome + ", Tipo: " + tipo + ", Raça: " + raca
                    + ", Sexo: " + sexo + ", Porte: " + porte + ", Cor: " + cor
                    + ", Status: " + status + ", CPF: " + cpf + ", Local Encontro: " + localEncontro
                    + ", Local Desaparecimento: " + localDes + ", Foto End: " + fotoEnd);
                */
                animais.add(animal); // Adiciona o animal à lista
            }

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao obter os animais do banco: " + ex.getMessage());
        } finally {
            try {
                //fechando o resultset após o uso
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // ou trate de acordo com as necessidades do seu aplicativo
            }
        }

        
        // Retorna a LISTA(List) de animais
        return animais;
    }

    // Método para definir a imagem em um componente JLabel
    public static void definirImagemJlabel(JLabel label, String caminho) {
        if (caminho != null) {
            ImageIcon icon = new ImageIcon(caminho);
            Image image = icon.getImage(); // Converte ImageIcon para Image
            Image novaImagem = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon novaIcone = new ImageIcon(novaImagem);
            label.setIcon(novaIcone);

        } else {
            // Se o caminho for nulo, limpe o ícone da JLabel
            label.setIcon(null);

        }
    }

    private static List<String> obterCaminhosFixos() {
        List<String> caminhos = new ArrayList<>();
        caminhos.add("C:\\Users\\Kalisto\\Pictures\\dog.png");
        caminhos.add("C:\\Users\\Kalisto\\Pictures\\dog.png");
        
        return caminhos;
    }
}

/*
public static void loadAnimalPhotos(int idLocal, List<JLabel> labels, int choise) {
        //obtendo os caminhos das imagens do banco
        List<String> caminhos = obterCaminhosImagensDoBanco(idLocal, labels.size(), choise);

        //List<String> caminhos = obterCaminhosFixos();
        System.out.println("Quantidade de Labels: " + labels.size());

        for (int i = 0; i < labels.size(); i++) {
            String caminho = (i < caminhos.size()) ? caminhos.get(i) : null;

            System.out.println("Caminho para Label " + i + ": " + caminho);

            definirImagemJlabel(labels.get(i), caminho);
        }
    }

 */
 /*
//Método para obter os caminhos das imagens do banco
    private static List<String> obterCaminhosImagensDoBanco(int idLocal, int quantidadeLabels, int i) {
        //Lista para armazenar os caminhos das imagens
        // Lista para armazenar os caminhos das imagens
       
        
        List<String> caminhos = new ArrayList<>();
        ResultSet rs = (ResultSet) null;

        if (i == 1) {
            rs = petDAO.getbasedONuser(idLocal, quantidadeLabels);
        } else if(i == 2) {
            rs = petDAO.getEncontrados(idLocal, quantidadeLabels);
        }
 

        try {
            while (rs.next()) {
                String fotoEnd = rs.getString("foto_end");
                
                if (fotoEnd != null) {
                    fotoEnd = fotoEnd.replace("\\\\", "\\");
                    caminhos.add(fotoEnd);
                    System.out.println("Caminho fotos: " + fotoEnd);
                } else {
                    System.out.println("Caminho fotos é nulo.");
                }
            }

            if (caminhos.size() > 0) {
                System.out.println("Caminhos: " + caminhos);
            } else {
                System.out.println("Nenhum caminho encontrado.");
            }
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao obter os caminhos da imagem no banco: " + ex.getMessage());
            
        } finally {
            try {
                // Certifique-se de fechar o ResultSet após o uso
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // ou trate de acordo com as necessidades do seu aplicativo
            }
        }

        System.out.println("Caminhos: " + caminhos);
        // Retorna a LISTA(List) de caminhos das imagens
        return caminhos;
    }

 */
