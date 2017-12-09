/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaces;

import com.beans.Acervo;
import com.beans.Autor;
import com.beans.Editora;
import com.beans.Funcionario;
import com.beans.Genero;
import com.dao.AcervoDao;
import com.dao.AutorDao;
import com.dao.EditoraDao;
import com.dao.GeneroDao;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author andre
 */
public class FrLivro extends javax.swing.JFrame {

    /**
     * Creates new form FrCadastroLivro
     */
    public FrLivro() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        URL url = this.getClass().getClassLoader().getResource("com/imagens/New_16x16.png"); 
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconeTitulo);
        
        GeneroDao g = new GeneroDao();
        AutorDao a = new AutorDao();
        EditoraDao e = new EditoraDao();
        
        for(Genero ge: g.leia()){
            g_box.addItem(ge);
        }
        for(Editora ed: e.leia()){
            g_box1.addItem(ed);
        }
        for(Autor au: a.leia()){
            g_box2.addItem(au);
        }
        
        painel1.setVisible(false);
        btn_edit.setEnabled(false);
        btn_excluir.setEnabled(false);
        btn_cad.setEnabled(true);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        nm_txt = new javax.swing.JTextField();
        qt_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vr_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        btn_cad = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        g_box = new javax.swing.JComboBox<>();
        g_box1 = new javax.swing.JComboBox<>();
        g_box2 = new javax.swing.JComboBox<>();
        painel1 = new javax.swing.JPanel();
        lb_c = new javax.swing.JLabel();
        cd_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        isqn_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Livro");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nome");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Qtde");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Valor Unit");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Genero");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Editora");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Autor");

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkginterface/Imagem/Edit_16x16.png"))); // NOI18N
        btn_edit.setText("Editar");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_cad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkginterface/Imagem/Add_16x16.png"))); // NOI18N
        btn_cad.setText("Cadastrar");
        btn_cad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadActionPerformed(evt);
            }
        });

        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkginterface/Imagem/Delete_16x16.png"))); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        g_box.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                g_boxItemStateChanged(evt);
            }
        });
        g_box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                g_boxMouseClicked(evt);
            }
        });

        g_box1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                g_box1ItemStateChanged(evt);
            }
        });
        g_box1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                g_box1MouseClicked(evt);
            }
        });

        g_box2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                g_box2ItemStateChanged(evt);
            }
        });
        g_box2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                g_box2MouseClicked(evt);
            }
        });

        lb_c.setText("ID");

        javax.swing.GroupLayout painel1Layout = new javax.swing.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addComponent(lb_c)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cd_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_c)
                    .addComponent(cd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("ISQN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 81, Short.MAX_VALUE)
                        .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(g_box1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(g_box2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vr_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(isqn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nm_txt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qt_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(nm_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(qt_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(isqn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(vr_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(g_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(g_box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g_box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit)
                    .addComponent(btn_cad)
                    .addComponent(btn_excluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void preencher_dados(Acervo f){
        painel1.setVisible(true);
        btn_edit.setEnabled(true);
        btn_excluir.setEnabled(true);
        btn_cad.setEnabled(false);
        cd_txt.setText(String.valueOf(f.getId()));
        nm_txt.setText(f.getNome());
        isqn_txt.setText(String.valueOf(f.getIsqn()));
        qt_txt.setText(String.valueOf(f.getQuatidade()));
        vr_txt.setText(String.valueOf(f.getValor()));
        g_box.getModel().setSelectedItem(f.getGenero());
        g_box1.getModel().setSelectedItem(f.getEditora());
        g_box2.getModel().setSelectedItem(f.getAutor());
    }
    
    
    
    
    private void btn_cadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadActionPerformed
        // TODO add your handling code here:
        
        AcervoDao c = new AcervoDao();
        Acervo p = new Acervo();
        
        Genero ge = (Genero) g_box.getSelectedItem();
        Editora ed = (Editora) g_box1.getSelectedItem();
        Autor au = (Autor) g_box2.getSelectedItem();

        //p.setId(Integer.parseInt(id_txt.getText()));
        p.setNome(nm_txt.getText());
        p.setIsqn(Integer.parseInt(isqn_txt.getText()));
        p.setQuatidade(Integer.parseInt(qt_txt.getText()));
        p.setValor(Double.parseDouble(vr_txt.getText()));
        p.setGenero(ge);
        p.setAutor(au);
        p.setEditora(ed);
        c.create(p);

        nm_txt.setText("");
        //isqn_txt.setText("");
        qt_txt.setText("");
        vr_txt.setText("");
        cd_txt.setText("");
        g_box.setSelectedIndex(0);
        g_box1.setSelectedIndex(0);
        g_box2.setSelectedIndex(0);
        
    }//GEN-LAST:event_btn_cadActionPerformed

    private void g_boxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_g_boxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_g_boxItemStateChanged

    private void g_boxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_g_boxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_g_boxMouseClicked

    private void g_box1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_g_box1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_g_box1ItemStateChanged

    private void g_box1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_g_box1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_g_box1MouseClicked

    private void g_box2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_g_box2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_g_box2ItemStateChanged

    private void g_box2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_g_box2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_g_box2MouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        AcervoDao c = new AcervoDao();
        Acervo p = new Acervo();
        
        Genero ge = (Genero) g_box.getSelectedItem();
        Editora ed = (Editora) g_box1.getSelectedItem();
        Autor au = (Autor) g_box2.getSelectedItem();

        p.setId(Integer.parseInt(cd_txt.getText()));
        p.setNome(nm_txt.getText());
        p.setIsqn(Integer.parseInt(isqn_txt.getText()));
        p.setQuatidade(Integer.parseInt(qt_txt.getText()));
        p.setValor(Double.parseDouble(vr_txt.getText()));
        p.setGenero(ge);
        p.setAutor(au);
        p.setEditora(ed);
        c.update(p);

        nm_txt.setText("");
        isqn_txt.setText("");
        qt_txt.setText("");
        vr_txt.setText("");
        cd_txt.setText("");
        g_box.setSelectedIndex(0);
        g_box1.setSelectedIndex(0);
        g_box2.setSelectedIndex(0);
        painel1.setVisible(false);
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // TODO add your handling code here:
        AcervoDao c = new AcervoDao();
        Acervo p = new Acervo();
        
        p.setId(Integer.parseInt(cd_txt.getText()));
        c.delete(p);
        
        nm_txt.setText("");
        isqn_txt.setText("");
        qt_txt.setText("");
        vr_txt.setText("");
        cd_txt.setText("");
        g_box.setSelectedIndex(0);
        g_box1.setSelectedIndex(0);
        g_box2.setSelectedIndex(0);
        painel1.setVisible(false);
    }//GEN-LAST:event_btn_excluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cad;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JTextField cd_txt;
    private javax.swing.JComboBox<Object> g_box;
    private javax.swing.JComboBox<Object> g_box1;
    private javax.swing.JComboBox<Object> g_box2;
    private javax.swing.JTextField isqn_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_c;
    private javax.swing.JTextField nm_txt;
    private javax.swing.JPanel painel1;
    private javax.swing.JTextField qt_txt;
    private javax.swing.JTextField vr_txt;
    // End of variables declaration//GEN-END:variables
}
