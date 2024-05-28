package Bank.Repository;

import Bank.Database.DatabaseConfig;
import Bank.Domain.Card;
import Bank.Domain.Cont;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
public class CardRepository {
    public void insert(Card card) {
        String insertCardSql = "INSERT INTO card (idCard,tipCard, blocat, idCont) VALUES (?, ?, ?, ?)";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertCardSql);
            preparedStatement.setInt(1, card.getIdCard());
            preparedStatement.setInt(4, card.getIdCont());
            preparedStatement.setString(2, card.getTipCard());
            preparedStatement.setBoolean(3, card.isBlocat());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Optional<Card> getById(int id) {
        String selectSql = "SELECT * FROM card c WHERE c.id = ?";
        Connection conn = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCard(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    private Optional<Card> mapToCard(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int idCard = resultSet.getInt("idCard");
            int idCont = resultSet.getInt("idCont");
            String tipCard = resultSet.getString("tipCard");
            boolean blocat = resultSet.getBoolean("blocat");
            return Optional.of(new Card(idCard,idCont,blocat,tipCard));
        }
        return Optional.empty();
    }

    public Optional<ArrayList<Card>> getAll(){
        ArrayList<Card> returnList = new ArrayList<Card>();
        String comandaSelect = "SELECT * FROM card";
        Connection conexiune = DatabaseConfig.getDatabaseConnection();
        try{
            Statement statement = conexiune.createStatement();
            ResultSet resultSet = statement.executeQuery(comandaSelect);
            while(true){
                Optional<Card> mapare = mapToCard(resultSet);
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
    public void delete(int id)
    {
        String comandaDelete = "DELETE FROM card WHERE idCard = ? ";
        Connection conexiune = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = conexiune.prepareStatement(comandaDelete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            String line = "Am sters cardul " + id;
            //auditService.writeLine("log.csv", line);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteAll(){
        String comandaDelete = "DELETE FROM card";
        Connection conexiune = DatabaseConfig.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = conexiune.prepareStatement(comandaDelete);
            preparedStatement.executeUpdate();
            String line = "Am sters cardurile " ;
            //auditService.writeLine("log.csv", line);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
