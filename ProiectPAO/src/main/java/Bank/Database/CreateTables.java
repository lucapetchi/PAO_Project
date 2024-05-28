package Bank.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTables {
    public void createTableCont() {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS cont (
                id int PRIMARY KEY ,
                numeClient varchar(40),
                sold double
            )
            """;

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTableCard() {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS card (
                idCard int PRIMARY KEY ,
                tipCard varchar(40),
                blocat boolean,
                idCont int,
                foreign key(idCont) references cont(id)
            )
            """;

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void createTableTranzactie() {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS tranzactie (
                idTranzactie int PRIMARY KEY AUTO_INCREMENT,
                suma double
            )
            """;

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableExtras() {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS extras_cont (
                idExtras int PRIMARY KEY AUTO_INCREMENT,
                numeDetinator varchar(40),
                sold double,
                idCont int,
                foreign key(idCont) references cont(id)
            )
            """;

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
