package com.co.indra.coinmarketcap.notifications.repositories;
import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import com.co.indra.coinmarketcap.notifications.model.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


class UsersRowMapper implements RowMapper<Users> {
        @Override
        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
            Users user = new Users();
            user.setUserId(rs.getString("user_id"));
            user.setMailUser(rs.getString("mail_user"));
            user.setPhoneNumber(rs.getString("phone_number"));
            return user;
        }
}


@Repository
public class UsersRepository {
    @Autowired
    private JdbcTemplate template;

    public void addUser(Users user) {
        template.update("INSERT INTO tbl_users( user_id, mail_user, phone_number) values(?,?,?)",
                user.getUserId(), user.getMailUser(), user.getPhoneNumber());
    }
    public List<Users> listUserById(String userid) {
        return template.query(
                "SELECT user_id, mail_user, phone_number FROM tbl_users WHERE user_id=?",
                new UsersRowMapper(), userid);
    }
    public List<Users> listAllUsers() {
        return template.query(
                "SELECT user_id, mail_user, phone_number FROM tbl_users",
                new UsersRowMapper());
    }
}