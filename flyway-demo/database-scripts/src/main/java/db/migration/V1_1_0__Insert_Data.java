package db.migration;

import java.sql.Connection;
import java.sql.Statement;
import org.flywaydb.core.api.migration.jdbc.JdbcMigration;


public class V1_1_0__Insert_Data implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute("Insert into person (first_name, last_name) Values ('Alice', 'Bob')");
        }

    }

}
