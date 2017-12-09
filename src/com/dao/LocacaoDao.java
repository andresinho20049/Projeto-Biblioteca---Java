/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexao.ConnectionFactory;
import com.beans.Locacao;
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
public class LocacaoDao {
    Connection con;
    
    public LocacaoDao() {
        con = ConnectionFactory.getConnection();
    }
    
        public void create(Locacao p) {
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into Locação (cd_nf,cd_cliente,cd_livro,quantidade,valor,dt_prevista,dt_locacao) values (?,?,?,?,?,?,GETDATE())");
            stmt.setInt(1, p.getNf().getId());
            stmt.setInt(2, p.getCliente().getId());
            stmt.setInt(3, p.getAcervo().getId());
            stmt.setInt(4, p.getQuantidade());
            stmt.setDouble(5, p.getValor());
            stmt.setString(6, p.getData());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }

    public List<Locacao> findAll() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Locacao> ac = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Acervo inner join Editora on Acervo.cd_editora = Editora.cd_editora "
                    + "inner join Autor on  Acervo.cd_autor = Autor.cd_autor inner join Genero_livro on "
                    + "Acervo.cd_genero = Genero_livro.cd_genero");
            rs = stmt.executeQuery();

            while (rs.next()) {
/*
                Locacao p = new Locacao();
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
                
                ac.add(p); */
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! /n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return ac;

    }
        
       
}
