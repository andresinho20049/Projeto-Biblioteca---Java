/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

/**
 *
 * @author andre
 */
public class Acervo {
    private int id,isqn,quatidade;
    private String nome;
    private double valor;
    private Genero genero;
    private Autor autor;
    private Editora editora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsqn() {
        return isqn;
    }

    public void setIsqn(int isqn) {
        this.isqn = isqn;
    }

    public int getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(int quatidade) {
        this.quatidade = quatidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    public String toString() {
        return getNome();
    }
}
