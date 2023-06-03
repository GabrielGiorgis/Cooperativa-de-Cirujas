package Jframes;

import clases.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author agusm
 */
public class EditCiruja extends javax.swing.JPanel {

    /**
     * Creates new form editCantante
     */
    public EditCiruja() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        for (Ciruja obj : Jframes.Main.cantantes) {     
            listModel.addElement(obj); 
        } //Hay que recibir a todos los cirujas desde la base de datos
        javax.swing.JList<Ciruja> jList1 = new JList<Ciruja>(listModel);
 
 ;
        jButton3 = new javax.swing.JButton();
        specialtyField = new javax.swing.JComboBox<>();
        joiningDate = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        materialField = new JList<Material>(listModel);

        ;
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setName("editCantante"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Editar");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jList1.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            {
                setOpaque(true);
            }

            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, java.lang.Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof Ciruja) {
                    Ciruja newCiruja = (Ciruja) value;
                    setText(newCiruja.nombre);
                }

                return this;
            }
        });
        jList1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jList1FocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton3.setText("Eliminar instrumento");
        jButton3.setActionCommand("Eliminar material");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        specialtyField.setEditable(true);
        specialtyField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguna", "Cartón y papel", "Vidrio", "metales" }));
        specialtyField.setToolTipText("Seleccionar tipo");

        joiningDate.setText("dd/mm/aaaa\n");
        joiningDate.setToolTipText("");
        joiningDate.setInheritsPopupMenu(true);
        joiningDate.setName("joinDate"); // NOI18N

        jLabel6.setText("Fecha de ingreso");

        jLabel7.setText("Materiales");

        jButton4.setText("Añadir material");

        materialField.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            {
                setOpaque(true);
            }

            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, java.lang.Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof Material) {
                    Material newMaterial = (Material) value;
                    setText(newMaterial.nombre);
                }

                return this;
            }
        });
        jScrollPane4.setViewportView(materialField);

        jLabel8.setText("Especialidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(specialtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(joiningDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specialtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(joiningDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
        for (int i = 0; i < instrumentModel.getSize(); i++) {
            instrumentos.add(instrumentModel.getElementAt(i));
        }
        for (int i = 0; i < Main.cantantes.size(); i++) {
            if (Main.cantantes.get(i).nombre.equals(jList1.getSelectedValue().nombre)) {
                switch (Main.cantantes.get(i).tipo.toLowerCase()) {
                    case "persona": {
                        Artista persona = new Artista(nameField.getText(), typeField.getSelectedItem().toString(), new Momento(Main.cantantes.get(i).cuando.getTipo(), hapinessField.isSelected()),instrumentos);
                        Main.cantantes.set(i, persona);
                        break;
                    }
                    case "gallo": {
                        Gallo gallo = new Gallo(nameField.getText(), typeField.getSelectedItem().toString(), new Momento(Main.cantantes.get(i).cuando.getTipo(), hapinessField.isSelected()), instrumentos);
                        Main.cantantes.set(i, gallo);
                        break;
                    }
                    case "canario": {
                        Canario canario = new Canario(nameField.getText(), typeField.getSelectedItem().toString(), new Momento(Main.cantantes.get(i).cuando.getTipo(), hapinessField.isSelected()), instrumentos);
                        Main.cantantes.set(i, canario);
                        break;
                    }
                    default: {
                        break;
                    }
                }
                addComponents();
            }
        }
        nameField.setText("");
        typeField.setSelectedItem("Persona");
        instrumentModel.clear();
        hapinessField.setSelected(false);
        JOptionPane.showMessageDialog(null, "Cantante modificado");
        this.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList1FocusGained

        nameField.setText(jList1.getSelectedValue().nombre);
        typeField.setSelectedItem(jList1.getSelectedValue().tipo);
        hapinessField.setSelected(jList1.getSelectedValue().cuando.isAlegria());
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
        if (jList1.getSelectedValue() instanceof Artista) {
            instrumentos = ((Artista) jList1.getSelectedValue()).getArrayInstrumentos();
        }
        if (jList1.getSelectedValue() instanceof Gallo) {
            instrumentos = ((Gallo) jList1.getSelectedValue()).getArrayInstrumentos();
        }
        if (jList1.getSelectedValue() instanceof Canario) {
            instrumentos = ((Canario) jList1.getSelectedValue()).getArrayInstrumentos();
        }
        instrumentModel.clear();
        for (int i = 0; i < instrumentos.size(); i++) {
            instrumentModel.addElement(instrumentos.get(i));
        }
    }//GEN-LAST:event_jList1FocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (instrumentField.getSelectedValue() != null) {
            for (int i = 0; i < instrumentModel.getSize(); i++) {
                if (instrumentField.getSelectedValue().nombre.equals(instrumentModel.getElementAt(i).nombre)) {
                    instrumentModel.remove(i);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void addComponents() {
        listModel.clear();
        for (SerCantor obj : Main.cantantes) {
            listModel.addElement(obj);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JFormattedTextField joiningDate;
    private javax.swing.JList<Material> materialField;
    private javax.swing.JTextField nameField;
    private javax.swing.JComboBox<String> specialtyField;
    // End of variables declaration//GEN-END:variables

    DefaultListModel<SerCantor> listModel = new DefaultListModel<>();
    DefaultListModel<Instrumento> instrumentModel = new DefaultListModel<>();
}