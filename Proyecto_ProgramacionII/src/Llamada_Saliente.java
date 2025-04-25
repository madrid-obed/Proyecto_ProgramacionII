
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author Obed
 */
public final class Llamada_Saliente extends javax.swing.JInternalFrame {
    
    private Telefono_Emisor formaEmisor;
    private Telefono_Receptor formaReceptor;
    private final ADM_Agentes formaAgentes;
    private ArrayList<agentes> listaAgentes;
    javax.swing.JDesktopPane DS;
    
    private llamadas llamadaActual;
    private ArrayList<llamadas> registro = new ArrayList<>();
    
    public ArrayList<llamadas> getLlamadas() {
        return registro;
    }
    
    public Llamada_Saliente(Telefono_Emisor formaEmisor, Telefono_Receptor formaReceptor, ADM_Agentes formaAgentes, javax.swing.JDesktopPane desktopPane) {
        this.formaEmisor = formaEmisor;
        this.formaReceptor = formaReceptor;
        this.formaAgentes = formaAgentes;
        this.DS = desktopPane;

        initComponents();

        this.listaAgentes = formaAgentes.getAgentes();
        llenarComboBoxExtensiones(listaAgentes);
    }
    
    public void iniciarLlamada(int telefono, int idAgente, String tipo) {
        llamadaActual = new llamadas();
        llamadaActual.setTelefono(telefono);
        llamadaActual.setID_Agente(idAgente);
        llamadaActual.setTipoLlamada(tipo);
        llamadaActual.setFechaInicio(java.time.LocalDateTime.now());
        JOptionPane.showMessageDialog(this, "Tipo de llamada: " + tipo);
    }

    public void finalizarLlamada() {
        if (llamadaActual != null) {
            llamadaActual.setFechaFin(java.time.LocalDateTime.now());
            registro.add(llamadaActual);
            llamadaActual = null;
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cb_Extensiones = new javax.swing.JComboBox<>();

        setClosable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Seleccione su extensión de teléfono:");

        jButton1.setText("Abrir Teléfono");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cb_Extensiones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cb_Extensiones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(cb_Extensiones, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        formaReceptor = new Telefono_Receptor(formaEmisor, formaAgentes, DS);
        centrarInternalFrame(formaReceptor);
        int extension = Integer.parseInt(this.cb_Extensiones.getSelectedItem().toString());
        formaReceptor.setExtensionReceptor(extension);
        
        this.dispose();
        formaReceptor.bloquearBoton();
        formaReceptor.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void centrarInternalFrame(JInternalFrame frame) {
    DS.add(frame);
    frame.setVisible(true);
    
        int x = (DS.getWidth() - frame.getWidth()) / 2;
        int y = (DS.getHeight() - frame.getHeight()) / 2;
        frame.setLocation(x, y);
        frame.toFront();
    }
    
    public void llenarComboBoxExtensiones(ArrayList<agentes> agente) {
    cb_Extensiones.removeAllItems();

        for (agentes ag : agente) {
            cb_Extensiones.addItem(String.valueOf(ag.getID_Agente()));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_Extensiones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
