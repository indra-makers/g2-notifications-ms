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
            notification.set_idNotification(rs.getString("id_notification"));
            notification.settypeOf(rs.getString("typeof"));
            notification.setMessage(rs.getString("message"));
            notification.setSent_at(rs.getTimestamp("sent_at"));
            notification.setMailUser(rs.getString("mailuser"));
            notification.setSubject(rs.getString("subject"));
            notification.setphoneNumber(rs.getString("phonenumber"));
            return notification;
        }
}

@Repository
public class NotificationsRepository {
    @Autowired
    private JdbcTemplate template;

    public void sendNotification(Notification notification) {
        template.update("INSERT INTO tbl_notifications( typeof, message, mailuser, subject, phonenumber) values(?,?,?,?,?)",
                notification.gettypeOf(), notification.getMessage(), notification.getMailUser(),
                notification.getSubject(), notification.getphoneNumber());
    }

    public List<Notification> logNotificationsByEmail(String mailuser) {
        return template.query(
                "SELECT id_notification, typeof, message, sent_at, mailuser, subject, phonenumber FROM tbl_notifications WHERE mailuser=?",
                new NotificationsRowMapper(), mailuser);
    }


}