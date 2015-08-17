package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;


public class V1_2_0__Create_Table_With_Spring_Support implements SpringJdbcMigration {

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
       jdbcTemplate.execute("Create table address (street Varchar(128), place Varchar(128))");
    }

}
