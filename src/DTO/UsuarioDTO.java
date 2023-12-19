package DTO;

//Glossário
/*
DAO (Data Access Object):
  O DAO é um padrão de projeto que separa a lógica de acesso a dados da lógica de negócios de uma aplicação.

DTO (Data Transfer Object):
  DTO é um objeto que carrega dados entre os processos da aplicação

VIEW:
  A camada VIEW representa a interface do usuário em um aplicativo.

*/

public class UsuarioDTO {
    
    private String cpf_usr;
    private String nome_usr;
    private String senha_usr;
    private String data_usr;
    private int id_local;
    private String email;
    private String tel;
    private String Foto_usr;

    public String getCpf_usr() {
        return cpf_usr;
    }

    public void setCpf_usr(String cpf_usr) {
        this.cpf_usr = cpf_usr;
    }

    public void setNome_usr(String nome_usr) {
        this.nome_usr = nome_usr;
    }

    public void setSenha_usr(String senha_usr) {
        this.senha_usr = senha_usr;
    }

    public void setData_usr(String data_usr) {
        this.data_usr = data_usr;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setFoto_usr(String Foto_usr) {
        this.Foto_usr = Foto_usr;
    }

    public String getNome_usr() {
        return nome_usr;
    }

    public String getSenha_usr() {
        return senha_usr;
    }

    public String getData_usr() {
        return data_usr;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getFoto_usr() {
        return Foto_usr;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }
    
}
