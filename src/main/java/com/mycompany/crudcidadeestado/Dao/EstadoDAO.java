/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcidadeestado.Dao;

/**
 *
 * @author Mateus
 */

import com.mycompany.crudcidadeestado.infra.ConnectionFactory;
import com.mycompany.crudcidadeestado.model.Estado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    public void salvar(Estado estado) {
        String sql = "INSERT INTO Estado (nome, uf) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, estado.getNome());
            stmt.setString(2, estado.getUf());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    estado.setId(generatedKeys.getLong(1)); 
                }
            }
        } catch (SQLException e) {
            
        }
        
    }

    public List<Estado> listar() {
        List<Estado> estados = new ArrayList<>();
        String sql = "SELECT * FROM Estado";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getLong("id")); 
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("uf"));
                estados.add(estado);
            }
        } catch (SQLException e) {
            
        }
        return estados;
    }

    public void atualizar(Estado estado) {
        String sql = "UPDATE Estado SET nome = ?, uf = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estado.getNome());
            stmt.setString(2, estado.getUf());
            stmt.setLong(3, estado.getId()); 
            stmt.executeUpdate();

        } catch (SQLException e) {
            
        }
    }

    public void excluir(long id) { 
        String sql = "DELETE FROM Estado WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id); 
            stmt.executeUpdate();

        } catch (SQLException e) {
            
        }
    }

    public Estado buscarPorId(long id) { 
        String sql = "SELECT * FROM Estado WHERE id = ?";
        Estado estado = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id); 
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    estado = new Estado();
                    estado.setId(rs.getLong("id"));
                    estado.setNome(rs.getString("nome"));
                    estado.setUf(rs.getString("uf"));
                }
            }
        } catch (SQLException e) {
            
        }
        return estado;
    }
}
