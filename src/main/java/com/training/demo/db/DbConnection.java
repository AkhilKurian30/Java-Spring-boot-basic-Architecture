package  com.training.demo.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DbConnection {
    @Autowired
    private Environment env;

    @Bean("data_source")
    public DataSource data_source() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.username"));
        dataSource.setPassword(env.getProperty("database.password"));
        // dataSource.setInitialSize(Integer.parseInt(env.getProperty("database.initialSize")));
        // dataSource.setMaxTotal(Integer.parseInt(env.getProperty("database.maxTotal")));
        // dataSource.setMaxIdle(Integer.parseInt(env.getProperty("database.maxIdle")));
        // dataSource.setMinIdle(Integer.parseInt(env.getProperty("database.minIdle")));
        // dataSource.setPoolPreparedStatements(Boolean.parseBoolean(env.getProperty("database.poolPreparedStatements")));
        // dataSource
        //         .setMaxOpenPreparedStatements(Integer.parseInt(env.getProperty("database.maxOpenPreparedStatements")));
        // 
        return dataSource;
    }

    @Bean("jdbcTemplate_db")
    public JdbcTemplate createJdbcTemplate_db(
            @Autowired @Qualifier("data_source") DataSource dataSource_global) throws SQLException {
        return new JdbcTemplate(dataSource_global);
    }



    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager_db(
            @Autowired @Qualifier("data_source") DataSource dataSource_global) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource_global);
        return transactionManager;
    }


    // @Bean("transactionManager")
    // public ChainedTransactionManager transactionManager(
    //         @Qualifier("transaction_db") PlatformTransactionManager ds1) {
    //     return new ChainedTransactionManager(ds1);
    // }




}