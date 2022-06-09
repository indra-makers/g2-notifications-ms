--Crear tabla de usuarios para notificaciones
CREATE TABLE public.tbl_users(
     user_id VARCHAR(255) NOT NULL PRIMARY KEY,
     phone_number VARCHAR(255) NOT NULL,
     mail_user TEXT NOT NULL
);