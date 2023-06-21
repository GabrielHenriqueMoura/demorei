package pacote;

public class Jogador {
    private int id;
    private String nome;
    private Equipe equipe;

    public Jogador(int id, String nome, Equipe equipe) {
        this.id = id;
        this.nome = nome;
        this.equipe = equipe;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
