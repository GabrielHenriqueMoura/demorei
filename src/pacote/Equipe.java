package pacote;

import java.util.List;
import java.util.ArrayList;   
public class Equipe {
    private int id;
    private String nome;
    private List<Jogador> jogadores;

    public Equipe(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.jogadores = new ArrayList<>();
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

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    // Métodos de negócio
    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }
}

