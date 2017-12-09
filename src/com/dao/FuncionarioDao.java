/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexao.ConnectionFactory;
import com.beans.Cargo;
import com.beans.Funcionario;
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
public class FuncionarioDao {
    Connection con;
    
    public FuncionarioDao() {
        con = ConnectionFactory.getConnection();
    }
    
        public void create(Funcionario p) {
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into Funcionário (nm_func,Logradouro,numero,bairro,cidade,uf,cep,dt_nasc_func,cd_cargo,ctps,serie_ctps,rg,cpf) values (?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRua());
            stmt.setInt(3, p.getNumero());
            stmt.setString(4, p.getBairro());
            stmt.setString(5, p.getCidade());
            stmt.setString(6, p.getUf());
            stmt.setString(7, p.getCep());
            stmt.setString(8, p.getDt_nasc());
            stmt.setInt(9, p.getCargo().getId());
            stmt.setString(10, p.getCtps());
            stmt.setString(11, p.getSerie());
            stmt.setString(12, p.getRg());
            stmt.setString(13, p.getCpf());

            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
            final int fk = rs.getInt(1);
            
            stmt = con.prepareStatement("insert into telefone_func(numero,cd_func) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[0]);
            stmt.setInt(2, fk);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("insert into telefone_func(numero,cd_func) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[1]);
            stmt.setInt(2, fk);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("insert into telefone_func(numero,cd_func) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[2]);
            stmt.setInt(2, fk);
            stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro " + ex + "!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void update(Funcionario p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Funcionário SET nm_func = ? ,Logradouro = ?,numero = ?,bairro = ?,cidade = ?,uf = ?,cep = ?,dt_nasc_func = ?,cd_cargo = ?,ctps = ?, serie_ctps = ?,rg = ?,cpf = ? WHERE cd_func = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRua());
            stmt.setInt(3, p.getNumero());
            stmt.setString(4, p.getBairro());
            stmt.setString(5, p.getCidade());
            stmt.setString(6, p.getUf());
            stmt.setString(7, p.getCep());
            stmt.setString(8, p.getDt_nasc());
            stmt.setInt(9, p.getCargo().getId());
            stmt.setString(10, p.getCtps());
            stmt.setString(11, p.getSerie());
            stmt.setString(12, p.getRg());
            stmt.setString(13, p.getCpf());
            stmt.setInt(14, p.getId());

            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE telefone_func SET numero = ?  WHERE cd_fone_func = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[0]);
            stmt.setInt(2, p.getFone().getIds()[0]);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE telefone_func SET numero = ?  WHERE cd_fone_func = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[1]);
            stmt.setInt(2, p.getFone().getIds()[1]);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE telefone_func SET numero = ?  WHERE cd_fone_func = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getFone().getTelefones()[2]);
            stmt.setInt(2, p.getFone().getIds()[2]);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Funcionário Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Funcionario p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from telefone_func where cd_func = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("delete from Funcionário where cd_func = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();


            JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
        public List<Funcionario> findAll() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select Funcionário.cd_func,nm_func,"
                    + "dt_nasc_func,rg,cpf,Logradouro,numero,bairro,cidade,uf,cep,cargo.cd_cargo,nm_cargo,salario,ctps,serie_ctps "
                    + "from Funcionário LEFT  join Cargo on Funcionário.cd_cargo = Cargo.cd_cargo ");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Funcionario func = new Funcionario();
                Cargo ca = new Cargo();

                func.setId(rs.getInt("cd_func"));
                func.setNome(rs.getString("nm_func"));
                func.setRua(rs.getString("Logradouro"));
                func.setNumero(rs.getInt("numero"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setUf(rs.getString("uf"));
                func.setCep(rs.getString("cep"));
                func.setDt_nasc(rs.getString(3));
                
                ca.setId(rs.getInt("cd_cargo"));
                ca.setNome(rs.getString("nm_cargo"));
                ca.setSalario(rs.getDouble("salario"));
                
                func.setCtps(rs.getString("ctps"));
                func.setSerie(rs.getString("serie_ctps"));
                func.setRg(rs.getString("RG"));
                func.setCpf(rs.getString("CPF"));
                func.setCargo(ca);
                funcs.add(func);
                          
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! /n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcs;

    }
        public List<Funcionario> findAll_filtro(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario func = new Funcionario();

                func.setId(rs.getInt("cd_func"));
                func.setNome(rs.getString("nm_func"));
                func.setRua(rs.getString("Logradouro"));
                func.setNumero(rs.getInt("numero"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setUf(rs.getString("uf"));
                func.setCep(rs.getString("cep"));
                func.setDt_nasc(rs.getString("dt_nasc_func"));
                Cargo cc = new Cargo();
                cc.setId(rs.getInt("cd_cargo"));
                cc.setNome(rs.getString("nm_cargo"));
                cc.setSalario(rs.getDouble("salario"));
                func.setCtps(rs.getString("ctps"));
                func.setSerie(rs.getString("serie_ctps"));
                func.setRg(rs.getString("RG"));
                func.setCpf(rs.getString("CPF"));
                func.setCargo(cc);
                funcs.add(func);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! /n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcs;

    }
}
