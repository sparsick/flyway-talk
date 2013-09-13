package db.migration;

import java.sql.Connection;
import java.sql.Statement;

import com.googlecode.flyway.core.api.migration.jdbc.JdbcMigration;

public class V1_1_0__Insert_Data implements JdbcMigration {

    public void migrate(Connection connection) throws Exception {
        Statement statement = connection.createStatement();

        try {
            statement.execute("Insert into person (first_name, last_name) Values (Alice, Bob)");
        } finally {
            statement.close();
        }

    }

}
