package pacote;
import java.util.List;

public interface EquipeDAO {
    void salvarEquipe(Equipe equipe);
    void atualizarEquipe(Equipe equipe);
    void deletarEquipe(Equipe equipe);
    Equipe buscarEquipePorId(int id);
    List<Equipe> listarEquipes();
}
