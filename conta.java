import java.util.*;

public class conta {

    ArrayList<Integer> cdb = new ArrayList<>();
    public String email, senha, nome, log;
    public int id, index_user;

    public conta(String email, String senha, String nome, int id) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.id = id;
    }
}
