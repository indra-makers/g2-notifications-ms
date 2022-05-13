package com.co.indra.coinmarketcap.notifications.repositories;
import com.co.indra.coinmarketcap.notifications.model.*;
import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


class NotificationsRowMapper implements RowMapper<Notification> {
        @Override
        public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
            Notification notification = new Notification();
            notification.set_id_notification(rs.getString("id_notification"));
            notification.setTypeof(rs.getString("typeof"));
            notification.setMessage(rs.getString("message"));
            notification.setSent_at(rs.getTimestamp("sent_at"));
            notification.setMailUser(rs.getString("mailuser"));
            notification.setSubject(rs.getString("subject"));
            notification.setPhonenumber(rs.getString("phonenumber"));
            return notification;
        }
}

@Repository
public class NotificationsRepository{
    @Autowired
    private JdbcTemplate template;
}