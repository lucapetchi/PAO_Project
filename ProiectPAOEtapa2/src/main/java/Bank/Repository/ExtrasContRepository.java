package Bank.Repository;

import Bank.Database.DatabaseConfig;
import Bank.Domain.Cont;
import Bank.Domain.ExtrasCont;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Optional;
public class ExtrasContRepository {
    public void insert(ExtrasCont extrasCont) {
        String insertContSql = "INSERT INTO extrasCont (idExtras,idCont,numeDetinator,sold) VALUES (null, ?, ?,?)";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertContSql);
            preparedStatement.setInt(1, extrasCont.getIdCont());
            preparedStatement.setString(2, extrasCont.getNumeDetinator());
            preparedStatement.setDouble(3, extrasCont.getSold());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert(int idCont,String numeDetinator,double sold) {
        String insertContSql = "INSERT INTO extrasCont (idExtras,idCont,numeDetinator,sold) VALUES (null, ?, ?,?)";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertContSql);
            preparedStatement.setInt(1, idCont);
            preparedStatement.setString(2, numeDetinator);
            preparedStatement.setDouble(3, sold);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Optional<ExtrasCont> getById(int id) {
        String selectSql = "SELECT * FROM extras_cont c WHERE c.id = ?";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToExtras(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    private Optional<ExtrasCont> mapToExtras(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int idCont = resultSet.getInt("idCont");
            String numeDetinator = resultSet.getString("numeDetinator");
            double sold = resultSet.getDouble("sold");
            return Optional.of(new ExtrasCont(idCont, numeDetinator, sold));
        }
        return Optional.empty();
    }
    public void delete(int id)
    {
        String comandaDelete = "DELETE FROM extras_cont WHERE idExtras = ? ";
        Connection conexiune = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = conexiune.prepareStatement(comandaDelete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            String line = "Am sters extrasul de cont cu id: " + id;
            //auditService.writeLine("log.csv", line);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
