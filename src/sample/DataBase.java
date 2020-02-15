package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String CONN = "jdbc:sqlite:Prisoners.sqlite";

    public static List<Prisoner> getAllPrisonersFromDB() {


        String sqlQuery = "SELECT * FROM Prisoners;";


        try {
            Connection connection = DriverManager.getConnection(CONN);

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            try (connection; preparedStatement; resultSet) {
                return resultSetToPrisoners(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//
//    public static void savePrisonerInDB(Prisoner prisoner) {
//        try {
//            Connection connection = DriverManager.getConnection(CONN);
//
//            String insertSQL = "INSERT INTO Prisoners (ID, Name, Surname, Crime, isMale, SentenceYears, ToBeExecuted, Age, JailCell, Points) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
//            try (connection; preparedStatement) {
//                preparedStatement.setLong(0, prisoner.getPrisonerID());
//                preparedStatement.setString(1, prisoner.getName());
//                preparedStatement.setInt();
//                preparedStatement.setInt();
//                preparedStatement.setInt();
//                preparedStatement.setInt();
//                preparedStatement.setInt();
//                preparedStatement.setInt();
//                preparedStatement.setInt();
//                preparedStatement.setInt();
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void deletePrisonerById(long id)  {
        try {
            Connection connection = DriverManager.getConnection(CONN);

            String deleteSQL = "DELETE FROM Prisoners where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);

            try (connection; preparedStatement) {
                preparedStatement.setLong(0, id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Prisoner> findPrisonerByNameAndSurname(String name, String surname) {
        try {
            Connection connection = DriverManager.getConnection(CONN);

            String findSQL = "SELECT * FROM Prisoners where Name = ? and Surname = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(findSQL);

            try (connection; preparedStatement) {
                preparedStatement.setString(0, name);
                preparedStatement.setString(1, surname);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSetToPrisoners(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: 2/14/2020 find prisoners by id


    private static List<Prisoner> resultSetToPrisoners(ResultSet resultSet) throws SQLException {
        List<Prisoner> prisoners = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("ID");
            String name = resultSet.getString("Name");
            String surname = resultSet.getString("Surname");
            String crime = resultSet.getString("Crime");
            Boolean isMale = resultSet.getBoolean("isMale");
            int sentenceYears = resultSet.getInt("SentenceYears");
            Boolean toBeExecuted = resultSet.getBoolean("ToBeExecuted");
            int age = resultSet.getInt("Age");
            String jailCell = resultSet.getString("JailCell");
            int points = resultSet.getInt("Points");


            Prisoner prisoner = new Prisoner(id, age, sentenceYears, points, crime, name, surname, toBeExecuted, isMale, jailCell);
            prisoners.add(prisoner);
        }
        return prisoners;
    }

}