/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Mateus
 * Created: 31 de mar. de 2025
 */

CREATE TABLE cidade (
    id IDENTITY PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_estado BIGINT NOT NULL,
    CONSTRAINT fk_cidade_estado FOREIGN KEY (id_estado) REFERENCES estado(id) ON DELETE CASCADE
);