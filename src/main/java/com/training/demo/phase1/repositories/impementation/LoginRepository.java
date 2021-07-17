package com.training.demo.phase1.repositories.impementation;

import java.util.List;

import com.training.demo.phase1.models.Roles;
import com.training.demo.phase1.repositories.specification.ILoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginRepository implements ILoginRepository {

    @Autowired
    private Environment env;


    @Autowired
    @Qualifier("jdbcTemplate_db")
    JdbcTemplate jdbcTemplate;
    @Override
    public Integer verifyLogin(Integer i) throws Exception {
        try {
            String s = env.getProperty("secure_app_database.url");
            String s1 = env.getProperty("server.port");
            // Integer result = i / 0;

            String query="select * from roles;";
            RowMapper<Roles> rowMapper = new BeanPropertyRowMapper<>(Roles.class);
            List<Roles> roles = jdbcTemplate.query(query, rowMapper);

            return 1;
        } catch (Exception e) {
            throw new Exception(e);
        // return 0;
        }

    }

    @Override
    public void verifyLogin1(Integer i) {

    }

}
