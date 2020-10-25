package com.testjdbc.repository;

import com.testjdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public User getByUsername(String username) {
        String sql = "SELECT * FROM usergood WHERE username=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
    }


    public List<User> getAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public void save (User user) {
        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getUsername(),user.getPassword());

    }


    public String getEmailByName(String name) {
        String sql = "SELECT email FROM user WHERE token=?";
        return jdbcTemplate.queryForObject(sql, new Object[] { name }, String.class);


    }
}
