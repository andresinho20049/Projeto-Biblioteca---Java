/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.beans.Autor;
import com.conexao.ConnectionFactory;
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
public class AutorDao {
    Connection con;
    
    public AutorDao() {
        con = ConnectionFactory.getConnection();
    }
    
        public List<Autor> leia() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Autor> cs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Autor");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Autor c = new Autor();

                c.setId(rs.getInt("cd_autor"));
                c.setNome(rs.getString("nm_autor"));
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
