package model;

public class Veterinario {
    
    private int id;
    private String nome;
    private String email;
    private String telefone;

    
    //Construtor

    public Veterinario(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
      
    //Getters e Setters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
               @Override
    public String toString() {
        return "Veterinario: " + "\nNome: " + nome + "\nEmail: " + email + "\nTelefone: " + telefone + "\n\n";
    }
}
