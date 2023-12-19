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


public class PetDTO {
    private int id_local;
    private String usr_cpf;
    private String status;
    private String nome_pet;
    private String raca;
    private String porte;
    private String sexo;
    private String cor;
    private String local_econtro;
    private String local_desaparecimento;
    private String foto_end;
    private String data_desaparecimento;
    private String tipo;

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    
    
    public String getUsr_cpf() {
        return usr_cpf;
    }

    public void setUsr_cpf(String usr_cpf) {
        this.usr_cpf = usr_cpf;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getData_desaparecimento() {
        return data_desaparecimento;
    }

    public void setData_desaparecimento(String data_desaparecimento) {
        this.data_desaparecimento = data_desaparecimento;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setLocal_econtro(String local_econtro) {
        this.local_econtro = local_econtro;
    }

    public void setLocal_desaparecimento(String local_desaparecimento) {
        this.local_desaparecimento = local_desaparecimento;
    }

    public void setFoto_end(String foto_end) {
        this.foto_end = foto_end;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public String getRaca() {
        return raca;
    }

    public String getPorte() {
        return porte;
    }

    public String getCor() {
        return cor;
    }

    public String getLocal_econtro() {
        return local_econtro;
    }

    public String getLocal_desaparecimento() {
        return local_desaparecimento;
    }

    public String getFoto_end() {
        return foto_end;
    }
    
    
}
