package Bank.Repository;

import Bank.Database.DatabaseConfig;
import Bank.Domain.Cont;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
public class ContRepository {
    public void insert(Cont cont) {
        String insertContSql = "INSERT INTO cont (id, numeClient, sold) VALUES (?, ?, ?)";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertContSql);
            preparedStatement.setInt(1, cont.getId());
            preparedStatement.setString(2, cont.getNumeClient());
            preparedStatement.setDouble(3, cont.getSold());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Optional<Cont> getById(int id) {
        String selectSql = "SELECT * FROM cont c WHERE c.id = ?";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCont(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    private Optional<Cont> mapToCont(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String numeClient = resultSet.getString("numeClient");
            double sold = resultSet.getDouble("sold");
            return Optional.of(new Cont(id, numeClient, sold));
        }
        return Optional.empty();
    }
    public void updateSold(double sold, int id) {
        String updateContSql = "UPDATE cont SET sold = ? WHERE id = ?";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(updateContSql);
            preparedStatement.setDouble(1, sold);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Optional<ArrayList<Cont>> getAll(){
        ArrayList<Cont> returnList = new ArrayList<Cont>();
        String comandaSelect = "SELECT * FROM cont";
        Connection conexiune = DatabaseConfig.getDatabaseConnection();
        try{
            Statement statement = conexiune.createStatement();
            ResultSet resultSet = statement.executeQuery(comandaSelect);
            while(true){
                Optional<Cont> mapare = mapToCont(resultSet);
                if(mapare.isEmpty())
                    break;
                returnList.add(mapare.get());
            }
            return Optional.of(returnList);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public void delete(String nume)
    {
        String comandaDelete = "DELETE FROM cont WHERE numeClient = ? ";
        Connection conexiune = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = conexiune.prepareStatement(comandaDelete);
            preparedStatement.setString(1, nume);
            preparedStatement.executeUpdate();
            String line = "Am sters contul " + nume;
            //auditService.writeLine("log.csv", line);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteAll(){
        String comandaDelete = "DELETE FROM cont";
        Connection conexiune = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = conexiune.prepareStatement(comandaDelete);
            preparedStatement.executeUpdate();
            String line = "Am sters contulurile " ;
            //auditService.writeLine("log.csv", line);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
