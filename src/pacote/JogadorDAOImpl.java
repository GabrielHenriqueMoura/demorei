package pacote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAOImpl implements JogadorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/esportesdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public void salvarJogador(Jogador jogador) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Jogador (nome, equipe_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, jogador.getNome());
            statement.setInt(2, jogador.getEquipe().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarJogador(Jogador jogador) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "UPDATE Jogador SET nome = ?, equipe_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, jogador.getNome());
            statement.setInt(2, jogador.getEquipe().getId());
            statement.setInt(3, jogador.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarJogador(Jogador jogador) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "DELETE FROM Jogador WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, jogador.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Jogador buscarJogadorPorId(int id) {
        Jogador jogador = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Jogador WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int equipeId = resultSet.getInt("equipe_id");
                EquipeDAO equipeDAO = new EquipeDAOImpl();
                Equipe equipe = equipeDAO.buscarEquipePorId(equipeId);
                jogador = new Jogador(id, nome, equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogador;
    }

    @Override
    public List<Jogador> listarJogadoresPorEquipe(Equipe equipe) {
        List<Jogador> jogadores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Jogador WHERE equipe_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, equipe.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                Jogador jogador = new Jogador(id, nome, equipe);
                jogadores.add(jogador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogadores;
    }
}

