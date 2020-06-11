package Model;

public class User{
    private String nome;
    private String email;
    private String pass;
    
    //Construct
    public User(){}
    public User(String nome, String email, String pass){
        this.nome = nome;
        this.email = email;
        this.pass = pass;
    }
    //Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Password
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    
}