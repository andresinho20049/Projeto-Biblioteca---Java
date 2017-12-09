/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexao.ConnectionFactory;
import com.beans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ClienteJDao {
    Connection con;
    
    public ClienteJDao() {
        con = ConnectionFactory.getConnection();
    }
    
        public void create(Cliente p) {
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into Cliente (nm_cliente,logradouro,numero,bairro,cidade,uf,cep) values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRua());
            stmt.setInt(3, p.getNumero());
            stmt.setString(4, p.getBairro());
            stmt.setString(5, p.getCidade());
            stmt.setString(6, p.getUf());
            stmt.setString(7, p.getCep());

            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
            final int fk = rs.getInt(1);
            
            stmt = con.prepareStatement("insert into Telefone_cliente (numero,cd_cliente) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[0]);
            stmt.setInt(2, fk);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("insert into Telefone_cliente (numero,cd_cliente) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[1]);
            stmt.setInt(2, fk);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("insert into Telefone_cliente (numero,cd_cliente) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[2]);
            stmt.setInt(2, fk);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("insert into Cliente_Juridico(cd_cliente,razao_social,CNPJ) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, fk);
            stmt.setString(2, p.getRazao_s());
            stmt.setString(3, p.getCnpj());
            stmt.executeUpdate();
            
            }
            
        

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void update(Cliente p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Cliente SET nm_cliente = ? ,logradouro = ?,numero = ?,bairro = ?,cidade = ?,uf = ?,cep = ? WHERE cd_cliente = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRua());
            stmt.setInt(3, p.getNumero());
            stmt.setString(4, p.getBairro());
            stmt.setString(5, p.getCidade());
            stmt.setString(6, p.getUf());
            stmt.setString(7, p.getCep());
            stmt.setInt(8, p.getId());

            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE Telefone_cliente SET numero = ? WHERE cd_fone_c = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[0]);
            stmt.setInt(2, p.getFone().getIds()[0]);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE Telefone_cliente SET numero = ? WHERE cd_fone_c = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[1]);
            stmt.setInt(2, p.getFone().getIds()[1]);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE Telefone_cliente SET numero = ? WHERE cd_fone_c = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[2]);
            stmt.setInt(2, p.getFone().getIds()[2]);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE Cliente_Juridico SET razao_social = ? ,CNPJ = ? WHERE cd_cliente = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getRazao_s());
            stmt.setString(2, p.getCnpj());
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();
            
            

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Cliente p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from telefone_cliente where cd_cliente = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("delete from Cliente_Juridico where cd_cliente = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("delete from Cliente where cd_cliente = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();


            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public List<Cliente> findAll() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> cl = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Cliente "
                    + "inner join Cliente_Juridico on Cliente.cd_cliente = Cliente_Juridico.cd_cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("cd_cliente"));
                c.setNome(rs.getString("nm_cliente"));
                c.setRua(rs.getString("Logradouro"));
                c.setNumero(rs.getInt("numero"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setCep(rs.getString("cep"));
                c.setCnpj(rs.getString("CNPJ"));
                c.setRazao_s(rs.getString("razao_social"));
                c.setStatus(rs.getInt("t_status"));
                cl.add(c);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cl;

    }
}
