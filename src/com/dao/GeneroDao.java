/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexao.ConnectionFactory;
import com.beans.Cargo;
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
public class GeneroDao {
    Connection con;
    
    public GeneroDao() {
        con = ConnectionFactory.getConnection();
    }
    
        public List<Genero> leia() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Genero> cs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Genero_livro");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Genero c = new Genero();

                c.setId(rs.getInt("cd_genero"));
                c.setNome(rs.getString("nm_genero"));
                cs.add(c);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cs;

    }
    
}
