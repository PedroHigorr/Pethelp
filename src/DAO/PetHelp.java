package DAO;

//Glossário
/*
DAO (Data Access Object):
  O DAO é um padrão de projeto que separa a lógica de acesso a dados da lógica de negócios de uma aplicação.

DTO (Data Transfer Object):
  DTO é um objeto que carrega dados entre os processos da aplicação

VIEW:
  A camada VIEW representa a interface do usuário em um aplicativo.

*/

import VIEW.AdicionaPet;
import VIEW.LoginScreen;
import VIEW.telaInicial;


public class PetHelp {

   
    public static void main(String[] args) {
        
        LoginScreen ls = new LoginScreen();
        telaInicial tl = new telaInicial();
        AdicionaPet ap = new AdicionaPet();
        
        
        ap.setVisible(true);
        //ls.setVisible(true);
        //tl.setVisible(true);
    }
    
}


