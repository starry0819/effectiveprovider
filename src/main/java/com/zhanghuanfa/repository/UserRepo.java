package com.zhanghuanfa.repository;

import com.google.common.collect.Maps;
import com.zhanghuanfa.model.po.Book;
import com.zhanghuanfa.model.po.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhanghuanfa
 * @date 2018-05-03 14:43
 */
@Repository
public class UserRepo {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Book> getBooksByUser() {
        return null;
    }

    public User getUserById(Integer id) {
        String sql = "SELECT * FROM user WHERE id = ? ;";
        return jdbcTemplate.query(sql, new Object[]{id}, rs -> {
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
            }
            return user;
        });
    }

    public int updateUser(User user) {
        String sql = "UPDATE user SET password = ? WHERE id = ? ";
        return jdbcTemplate.update(sql, user.getPassword(), user.getId());
    }

    public List<User> getUserByUserCondition(User user) {
        String sql = "SELECT * FROM user WHERE id = :id ";
        HashMap<String, Object> params = Maps.newHashMap();
        params.put("id", user.getId());
        return namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(User.class));
    }
}
