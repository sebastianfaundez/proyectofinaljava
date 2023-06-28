-- CREACIÓN DE LA BASE DE DATOS (SCHEMA)
CREATE DATABASE dbfinal; 

-- SELECCION DE LA BASE DE DATOS CREADA
USE dbfinal;

-- CREACIÓN DE TABLAS USUARIO Y TELEFONO (CON IDs BIGINT)
CREATE TABLE usuario (
  id int NOT NULL  AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  correo VARCHAR(60) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT correo_usuario_unique UNIQUE (correo)
);

CREATE TABLE telefono (
  id_telefono int NOT NULL AUTO_INCREMENT,
  usuario_id int NOT NULL,
  numero VARCHAR(60),
  cod_ciudad VARCHAR(5),
  cod_pais VARCHAR(5),
  PRIMARY KEY (id_telefono),
  CONSTRAINT fk_usuarios FOREIGN KEY(usuario_id)
  REFERENCES usuario(id)
);
