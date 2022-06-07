package com.co.indra.coinmarketcap.notifications.repositories;

import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class UserNotificationsDataRowMapper implements RowMapper<UserNotificationsData> {
    @Override
    public UserNotificationsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserNotificationsData userNotificationsData= new UserNotificationsData();
        userNotificationsData.setUsername(rs.getString("user_id"));
        userNotificationsData.setPhoneNumber(rs.getString("phone_number"));
        userNotificationsData.setMailUser(rs.getString("mail"));
        return userNotificationsData;
    }
}

@Repository
public class UserNotificationDataRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserNotificationsData> getPhoneNumberByUsername(String username){
        return jdbcTemplate.query(
                "SELECT user_id, phone_number, mail FROM public.tbl_users WHERE user_id=?",
                new UserNotificationsDataRowMapper(), username);
    }
}
