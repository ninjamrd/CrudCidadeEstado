/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcidadeestado.model;

/**
 *
 * @author Mateus
 */

import com.mycompany.crudcidadeestado.model.Estado;

public class Cidade {

    private long id;
    private String nome;
    private long idEstado;
    private Estado estado;

    
    public Cidade() {
    }

    public Cidade(long id, String nome, long idEstado) {
        this.id = id;
        this.nome = nome;
        this.idEstado = idEstado;
    }

    public Cidade(long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        if (estado != null) {
            this.idEstado = estado.getId();
        }
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        if (estado != null) {
            this.idEstado = estado.getId();
        }
    }

    
    public String getNomeEstado() {
        return (estado != null) ? estado.getNome() : "Desconhecido";
    }

    public String toString() {
        return nome + " - " + getNomeEstado();
    }
}
