package com.playLoud.tests;

import com.playLoud.core.TestBase;
import com.playLoud.utils.DbData;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectorTests extends TestBase {

    @Test
    public void getDataTableTest() {
        try {
            //create statement object
            Statement statement = connection.createStatement();
            //execute sql query, save result in ResultSet
            ResultSet resultSet = statement.executeQuery(DbData.querySelect);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " *** " +
                        resultSet.getString(3));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
