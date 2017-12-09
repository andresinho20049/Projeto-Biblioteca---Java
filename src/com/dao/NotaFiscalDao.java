/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.beans.NotaFiscal;
import com.conexao.ConnectionFactory;
import com.interfaces.FrEmprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class NotaFiscalDao {

    Connection con;
    
    public NotaFiscalDao() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(NotaFiscal p) {
        PreparedStatement stmt = null;
        try {            
            stmt = con.prepareStatement("insert into NF (data_nf,cd_usuario) values (GETDATE(),?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getUsuario().getId());
            stmt.executeUpdate();
            FrEmprestimo e = new FrEmprestimo();
            
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
            final int fk = rs.getInt(1);
            p.setId(fk);
            e.setId_nf(fk);
            }
            
            JOptionPane.showMessageDialog(null, "NF gerada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
    
