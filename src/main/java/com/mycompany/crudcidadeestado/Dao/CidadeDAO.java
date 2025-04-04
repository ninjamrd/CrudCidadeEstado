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
import com.mycompany.crudcidadeestado.model.Cidade;
import com.mycompany.crudcidadeestado.model.Estado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {

    public void salvar(Cidade cidade) {
        String sql = "INSERT INTO Cidade (nome, id_estado) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cidade.getNome());
            stmt.setLong(2, cidade.getIdEstado());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cidade.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            
        }
    }

    public List<Cidade> listar() {
        List<Cidade> cidades = new ArrayList<>();
        String sql = """
            SELECT c.id, c.nome, c.id_estado, e.nome AS nome_estado
            FROM Cidade c
            JOIN Estado e ON c.id_estado = e.id
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getLong("id"));
                cidade.setNome(rs.getString("nome"));
                cidade.setIdEstado(rs.getLong("id_estado"));

                Estado estado = new Estado();
                estado.setId(rs.getLong("id_estado"));
                estado.setNome(rs.getString("nome_estado"));

                cidade.setEstado(estado);

                cidades.add(cidade);
            }
        } catch (SQLException e) {
            
        }

        return cidades;
    }

    public void atualizar(Cidade cidade) {
        String sql = "UPDATE Cidade SET nome = ?, id_estado = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cidade.getNome());
            stmt.setLong(2, cidade.getIdEstado());
            stmt.setLong(3, cidade.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            
        }
    }

    public void deletar(long id) {
        String sql = "DELETE FROM Cidade WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            
        }
    }

    public Cidade buscarPorId(long id) {
        String sql = """
            SELECT c.id, c.nome, c.id_estado, e.nome AS nome_estado
            FROM Cidade c
            JOIN Estado e ON c.id_estado = e.id
            WHERE c.id = ?
        """;

        Cidade cidade = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cidade = new Cidade();
                    cidade.setId(rs.getLong("id"));
                    cidade.setNome(rs.getString("nome"));
                    cidade.setIdEstado(rs.getLong("id_estado"));

                    Estado estado = new Estado();
                    estado.setId(rs.getLong("id_estado"));
                    estado.setNome(rs.getString("nome_estado"));

                    cidade.setEstado(estado);
                }
            }
        } catch (SQLException e) {
            
        }

        return cidade;
    }
}
