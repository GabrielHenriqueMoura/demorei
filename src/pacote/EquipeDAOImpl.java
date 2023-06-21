package pacote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAOImpl implements EquipeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/esportesdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public void salvarEquipe(Equipe equipe) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Equipe (nome) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, equipe.getNome());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarEquipe(Equipe equipe) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "UPDATE Equipe SET nome = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, equipe.getNome());
            statement.setInt(2, equipe.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarEquipe(Equipe equipe) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "DELETE FROM Equipe WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, equipe.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipe buscarEquipePorId(int id) {
        Equipe equipe = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Equipe WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                equipe = new Equipe(id, nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipe;
    }

    @Override
    public List<Equipe> listarEquipes() {
        List<Equipe> equipes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Equipe";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                Equipe equipe = new Equipe(id, nome);
                equipes.add(equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipes;
    }
}
