package com.zhanghuanfa.repository;

import com.zhanghuanfa.model.po.Book;
import com.zhanghuanfa.model.po.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghuanfa
 * @date 2018-05-03 14:43
 */
@Repository
public class UserRepo {
    @Resource
    private JdbcTemplate jdbcTemplate;

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
}
