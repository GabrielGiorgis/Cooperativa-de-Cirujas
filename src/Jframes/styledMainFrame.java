package Jframes;

import clases.*;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author agusm
 */
public class styledMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form styledMainFrame
     */
    public styledMainFrame() {
        initComponents();
        vista = (CardLayout) mainPanel.getLayout();
    }
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        showAll = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        editOne = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        deleteOne = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        addOne = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        showAll.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        showAll.setForeground(new java.awt.Color(51, 51, 51));
        showAll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showAll.setText("Mostrar todos");
        showAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showAllMouseClicked(evt);
            }
        });

        editOne.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        editOne.setForeground(new java.awt.Color(51, 51, 51));
        editOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editOne.setText("Modificar");
        editOne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editOneMouseClicked(evt);
            }
        });

        deleteOne.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        deleteOne.setForeground(new java.awt.Color(51, 51, 51));
        deleteOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteOne.setText("Eliminar");
        deleteOne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteOneMouseClicked(evt);
            }
        });

        addOne.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        addOne.setForeground(new java.awt.Color(51, 51, 51));
        addOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addOne.setText("Agregar ciruja");
        addOne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(deleteOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addOne, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showAll, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addOne, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editOne, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteOne, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(957, 957, 957))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(661, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showAllMouseClicked
        allCantantes.addComponents();
        mainPanel.add(allCantantes, "allCantantes");
        vista.show(mainPanel, "allCantantes");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_showAllMouseClicked

    private void editOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOneMouseClicked
        modifyCantante.addComponents();
        mainPanel.add(modifyCantante, "editCantante");
        vista.show(mainPanel, "editCantante");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_editOneMouseClicked

    private void addOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOneMouseClicked
        mainPanel.add(addCantante, "addCantante");
        vista.show(mainPanel, "addCantante");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_addOneMouseClicked

    private void deleteOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteOneMouseClicked
        removeCantante.addComponents();
        mainPanel.add(removeCantante, "deleteCantante");
        vista.show(mainPanel, "deleteCantante");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_deleteOneMouseClicked

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
            java.util.logging.Logger.getLogger(styledMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(styledMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(styledMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(styledMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new styledMainFrame().setVisible(true);
            }
        });
    }
    
    private JList<String> obtenerJListDesdePanel(JPanel panel) {
    JList<String> jList = null;
    
    Component[] components = panel.getComponents();
    for (Component component : components) {
        if (component instanceof JList) {
            jList = (JList<String>) component;
            break;
        }
    }
    
    return jList;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addOne;
    private javax.swing.JLabel deleteOne;
    private javax.swing.JLabel editOne;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel showAll;
    // End of variables declaration//GEN-END:variables
    public CardLayout vista;
    public AddCiruja addCantante = new AddCiruja();
    public EditCiruja modifyCantante = new EditCiruja();
    public AllCirujas allCantantes = new AllCirujas();
    public DeleteCiruja removeCantante = new DeleteCiruja();
}