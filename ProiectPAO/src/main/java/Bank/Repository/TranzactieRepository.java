package Bank.Repository;

import Bank.Database.DatabaseConfig;
import Bank.Domain.Cont;
import Bank.Domain.Tranzactie;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Optional;
public class TranzactieRepository {
    public void insert(Tranzactie tranzactie) {
        String insertContSql = "INSERT INTO cont (id, suma) VALUES (null, ?)";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertContSql);
            preparedStatement.setDouble(1, tranzactie.getSuma());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Tranzactie> getById(int id) {
        String selectSql = "SELECT * FROM tranzactie c WHERE c.id = ?";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToTranzactie(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    private Optional<Tranzactie> mapToTranzactie(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            double suma = resultSet.getDouble("suma");
            return Optional.of(new Tranzactie(id, suma));
        }
        return Optional.empty();
    }

    public void delete(int id)
    {
        String comandaDelete = "DELETE FROM tranzactie WHERE id = ? ";
        Connection conexiune = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = conexiune.prepareStatement(comandaDelete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            String line = "Am sters tranzactia " + id;
            //auditService.writeLine("log.csv", line);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}

