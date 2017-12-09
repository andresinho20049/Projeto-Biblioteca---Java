/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.beans.Acervo;
import com.beans.Autor;
import com.beans.Editora;
import com.conexao.ConnectionFactory;
import com.beans.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class AcervoDao {
    Connection con;
    
    public AcervoDao() {
        con = ConnectionFactory.getConnection();
    }
    
        public void create(Acervo p) {
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into Acervo "
                    + "(nm_livro,vlr_unit,isqn,qtde_estoque,cd_autor,cd_editora,cd_genero) values (?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getValor());
            stmt.setInt(3, p.getIsqn());
            stmt.setInt(4, p.getQuatidade());
            stmt.setInt(5, p.getAutor().getId());
            stmt.setInt(6, p.getEditora().getId());
            stmt.setInt(7, p.getGenero().getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void update(Acervo p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Acervo SET nm_livro = ? ,vlr_unit = ?,isqn = ?,"
                                        + "qtde_estoque = ?,cd_autor = ?,cd_editora = ?,cd_genero = ? WHERE cd_livro = ?");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getValor());
            stmt.setInt(3, p.getIsqn());
            stmt.setInt(4, p.getQuatidade());
            stmt.setInt(5, p.getAutor().getId());
            stmt.setInt(6, p.getEditora().getId());
            stmt.setInt(7, p.getGenero().getId());
            stmt.setInt(8, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Livro " + p.getNome() + " foi atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Acervo p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Acervo WHERE cd_livro = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public List<Acervo> findAll() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Acervo> ac = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Acervo inner join Editora on Acervo.cd_editora = Editora.cd_editora "
                    + "inner join Autor on  Acervo.cd_autor = Autor.cd_autor inner join Genero_livro on "
                    + "Acervo.cd_genero = Genero_livro.cd_genero");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Acervo p = new Acervo();
                Editora e = new Editora();
                Autor a = new Autor();
                Genero g = new Genero();

                p.setId(rs.getInt("cd_livro"));
                p.setNome(rs.getString("nm_livro"));
                p.setValor(rs.getDouble("vlr_unit"));
                p.setIsqn(rs.getInt("isqn"));
                p.setQuatidade(rs.getInt("qtde_estoque"));
                
                e.setId(rs.getInt("cd_editora"));
                e.setNome(rs.getString("nm_editora"));
                
                a.setId(rs.getInt("cd_autor"));
                a.setNome(rs.getString("nm_autor"));
                
                g.setId((rs.getInt("cd_genero")));
                g.setNome(rs.getString("nm_genero"));
                                
                p.setAutor(a);
                p.setEditora(e);
                p.setGenero(g);
                
                ac.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! /n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return ac;

    }
        
       
}
