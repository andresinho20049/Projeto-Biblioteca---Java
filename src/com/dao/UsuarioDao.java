/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.beans.Cargo;
import com.beans.Funcionario;
import com.conexao.ConnectionFactory;
import com.beans.Usuario;
import com.interfaces.FrLogin;
import com.interfaces.FrPrincipal;
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
public class UsuarioDao {

    Connection con;
    
    public UsuarioDao() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Usuario p) {

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into Usuário(cd_func,nm_usuario,senha,tipo_usuario) values (?,?,?,?)");
            stmt.setInt(1, p.getFuncionario().getId());
            stmt.setString(2, p.getLogin());
            stmt.setString(3, p.getSenha());
            stmt.setInt(4, p.getTipo_usuario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro " + ex + "!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void update(Usuario p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Usuário SET nm_usuario = ?,senha = ?,tipo_usuario = ? WHERE cd_usuario = ?");
            stmt.setString(1, p.getLogin());
            stmt.setString(2, p.getSenha());
            stmt.setInt(3, p.getTipo_usuario());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: \n " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Usuario p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Usuário WHERE cd_usuario = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public List<Funcionario> findAll_cad() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select Funcionário.cd_func,nm_func,dt_nasc_func,rg,cpf,Logradouro,numero,bairro,cidade,uf,cep,cargo.cd_cargo,nm_cargo,salario,ctps,serie_ctps "
                    + "from Funcionário Inner join Cargo on Funcionário.cd_cargo = Cargo.cd_cargo left join Usuário as u on u.cd_func = Funcionário.cd_func where u.cd_func is null");
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
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcs;

    }
    
    public List<Usuario> findAll_con() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> us = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select funcionário.cd_func,nm_func,cd_usuario,nm_usuario,senha,tipo_usuario "
                    + "from Usuário inner join Funcionário on Usuário.cd_func = Funcionário.cd_func");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Funcionario fu = new Funcionario();
                Usuario u = new Usuario();

                u.setId(rs.getInt("cd_usuario"));
                fu.setId(rs.getInt("cd_func"));
                fu.setNome(rs.getString("nm_func"));
                u.setFuncionario(fu);
                u.setLogin(rs.getString("nm_usuario"));
                u.setSenha(rs.getString("senha"));
                u.setTipo_usuario(rs.getInt("tipo_usuario"));
                us.add(u);
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return us;

    }
    
    public void Login(Usuario p){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        FrLogin log = new FrLogin();
        FrPrincipal principal = new FrPrincipal();
        try{
            stmt = con.prepareStatement("select cd_usuario,Funcionário.cd_func,nm_func,nm_usuario,senha,tipo_usuario "
                    + "from Usuário inner join Funcionário on Usuário.cd_func = Funcionário.cd_func "
                    + "where nm_usuario = ? and senha = ?");
            stmt.setString(1, p.getLogin());
            stmt.setString(2, p.getSenha());
            
            rs = stmt.executeQuery();
            if (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("cd_func"));
                func.setNome(rs.getString("nm_func"));
                p.setFuncionario(func);
                p.setId(rs.getInt("cd_usuario"));
                p.setLogin(rs.getString("nm_usuario"));
                p.setSenha(rs.getString("senha"));
                p.setTipo_usuario(rs.getInt("tipo_usuario"));
                principal.restricao(p);
                JOptionPane.showMessageDialog(null, "Prezado Sr." + p.getFuncionario().getNome() + " Seja bem vindo!");
                
                log.dispose();                
                principal.setVisible(true);

            }else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto!!!");
            }
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Usuário Incorreto! \n " + e);
        }
    }

}
