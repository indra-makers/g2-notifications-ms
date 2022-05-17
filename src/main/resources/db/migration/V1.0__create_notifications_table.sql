--Crear tabla de notificaciones
CREATE TABLE public.tbl_Notifications(
    id_notification VARCHAR(255),
    typeof VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    sent_at TIMESTAMP,
    mailUser TEXT NOT NULL,
    subject TEXT NOT NULL,
    phonenumber TEXT NOT NULL,
    PRIMARY KEY (id_notification)
    --FOREIGN KEY (mailUser) REFERENCES tbl_Users(mail_user) --Reference to tbl_users in g2-users-ms
);