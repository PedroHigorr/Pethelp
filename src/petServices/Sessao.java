package petServices;

public class Sessao {

    private static Sessao instance;
    private String loggedUserCPF;
    private String loggedUserName;
    private int loggedUserLocationID; // Novo campo para armazenar o id_local

    private Sessao() {
        // Construtor privado para impedir a criação direta de instâncias
    }

    public static Sessao getInstance() {
        if (instance == null) {
            instance = new Sessao();
        }
        return instance;
    }

    public String getLoggedUserCPF() {
        return loggedUserCPF;
    }

    public String getLoggedUserName() {
        return loggedUserName;
    }

    public int getLoggedUserLocationID() {
        return loggedUserLocationID;
    }

    public void setLoggedUser(String cpf, String userName, int locationID) {
        loggedUserCPF = cpf;
        loggedUserName = userName;
        loggedUserLocationID = locationID;
    }
}
