package com.co.indra.coinmarketcap.notifications.repositories;
import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


class NotificationsRowMapper implements RowMapper<Notification> {
        @Override
        public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
            Notification notification = new Notification();
            notification.setUserId(rs.getString("user_id"));
            notification.setTypeOf(rs.getString("type_of"));
            notification.setSubject(rs.getString("subject"));
            notification.setMessage(rs.getString("message"));
            notification.setSentAt(rs.getTimestamp("sent_at"));
            return notification;
        }
}

@Repository
public class NotificationsRepository {
    @Autowired
    private JdbcTemplate template;

    public void sendNotification(Notification notification) {
        template.update("INSERT INTO tbl_notifications( user_id, type_of, subject, message) values(?,?,?,?)",
                notification.getUserId(),
                notification.getTypeOf(),
                notification.getSubject(),
                notification.getMessage()
        );
    }

    public List<Notification> getNotificationsByUserId(String userId) {
        return template.query(
                "SELECT user_id, type_of, subject, message, sent_at FROM tbl_notifications WHERE user_id=?",
                new NotificationsRowMapper(), userId);
    }

    public List<Notification> getAllNotifications() {
        return template.query(
                "SELECT user_id, type_of, subject, message, sent_at FROM tbl_notifications",
                new NotificationsRowMapper());
    }
}