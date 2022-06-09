--Crear tabla de notificaciones
CREATE TABLE public.tbl_notifications(
    user_id VARCHAR(255) NOT NULL,
    type_of VARCHAR(255) NOT NULL,
    subject TEXT NOT NULL,
    message TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT NOW()
    --FOREIGN KEY (mail_user) REFERENCES tbl_users(mail_user)
);