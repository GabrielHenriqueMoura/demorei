package pacote;

import java.util.List;

public interface JogadorDAO {
    void salvarJogador(Jogador jogador);
    void atualizarJogador(Jogador jogador);
    void deletarJogador(Jogador jogador);
    Jogador buscarJogadorPorId(int id);
    List<Jogador> listarJogadoresPorEquipe(Equipe equipe);
}
