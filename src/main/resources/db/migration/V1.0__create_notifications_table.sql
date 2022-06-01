--Crear tabla de notificaciones
CREATE TABLE public.tbl_Notifications(
    id_notification SERIAL PRIMARY KEY,
    typeof VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT NOW(),
    mailUser TEXT NOT NULL,
    subject TEXT NOT NULL,
    phonenumber TEXT NOT NULL
    --FOREIGN KEY (mailUser) REFERENCES tbl_Users(mail_user) --Reference to tbl_users in g2-users-ms
);