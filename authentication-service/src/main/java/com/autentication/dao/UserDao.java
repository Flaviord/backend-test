package com.autentication.dao;

import com.autentication.models.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Optional;

@RegisterBeanMapper(UserMapper.class)
public interface UserDao {

    final String COLUMNS = "" +
        "users.id, " +
        "users.username, " +
        "users.email, " +
        "users.password ";

    @SqlQuery("SELECT " +
            COLUMNS +
    "FROM users users " +
    "WHERE users.username = :username")
    Optional<User> findByUsername(@Bind("username") String username);

    @SqlQuery("SELECT EXISTS(SELECT 1 " +
            "FROM users users " +
            "WHERE users.username = :username )")
    boolean userExists(@Bind("username") String username);

    @SqlUpdate("INSERT INTO users (username, password) " +
            "values (:user.userName, :user.password)")
    int insert(@BindBean("user") User user);
}
