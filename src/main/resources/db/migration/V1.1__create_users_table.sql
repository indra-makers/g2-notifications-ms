--Crear tabla de usuarios para notificaciones
CREATE TABLE public.tbl_users(
     user_id VARCHAR(255),
     phone_number VARCHAR(255) NOT NULL,
     mail TEXT NOT NULL,
     PRIMARY KEY (user_id)
);