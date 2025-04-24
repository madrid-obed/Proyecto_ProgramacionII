
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Transferir_Llamada extends javax.swing.JInternalFrame {
    private final Telefono_Emisor formaEmisor;
    private final Telefono_Receptor formaReceptor;
    private final ADM_Agentes formaAgentes;
    private ArrayList<agentes> listaAgentes;
    private ArrayList<llamadas> registroLlamadas;
    
    public Transferir_Llamada(Telefono_Emisor formaEmisor, ADM_Agentes formaAgentes, Telefono_Receptor formaReceptor) {
        this.formaAgentes = formaAgentes;
        this.formaReceptor = formaReceptor;
        this.formaEmisor = formaEmisor;

        this.listaAgentes = formaAgentes.getAgentes();
        this.registroLlamadas = formaEmisor.getLlamadas();

        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txt_Extension = new javax.swing.JTextField();
        cb_Departamento = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/transfer (2).png"))); // NOI18N
        jButton1.setText("Transferir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cb_Departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnico", "Cobros", "Ventas", "Atencion al cliente" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cb_Departamento, 0, 233, Short.MAX_VALUE)
                        .addComponent(txt_Extension)))
                .addGap(0, 58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(cb_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txt_Extension, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private agentes buscarAgente(int extension) {
    if (listaAgentes == null) return null;

    for (agentes ag : listaAgentes) {
        if (ag.getID_Agente() == extension) {
            String departamento = ag.getDepartamento();
            formaEmisor.setPantalla(extension, departamento);
            formaAgentes.incrementarLlamadasAgente(extension);
            formaReceptor.setExtensionReceptor(extension);
            return ag;
        }
    }
    return null;
    }
    
    private agentes buscarDepartamento(String departamento) {
    if (listaAgentes == null) return null;

    int extensionActual = formaEmisor.getExtensionActual();

    for (agentes ag : listaAgentes) {
        formaAgentes.refrescar(listaAgentes);
        if (ag.getDepartamento().equals(departamento) && ag.getID_Agente() != extensionActual) {
            formaEmisor.seleccionarAgente(listaAgentes, ag.getID_Agente());
            formaEmisor.setPantalla(ag.getID_Agente(), departamento);
            formaAgentes.incrementarLlamadasAgente(ag.getID_Agente());
            formaReceptor.setExtensionReceptor(ag.getID_Agente());
            return ag;
        }
    }
    return null;
}


    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String extText = txt_Extension.getText().trim();
        String departamento = String.valueOf(cb_Departamento.getSelectedItem());

    if ((extText.isEmpty() && (departamento == null || departamento.equals("Seleccione...")))) {
        JOptionPane.showMessageDialog(this, 
            "Debe ingresar una extensión o seleccionar un departamento.",
            "Advertencia", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    agentes resultado = null;

    if (!extText.isEmpty()) {
        try {
            int extension = Integer.parseInt(extText);
            resultado = buscarAgente(extension);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Extensión inválida. Debe ser un número.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
    } 
    else if (departamento != null && !departamento.equals("Seleccione...")) {
        resultado = buscarDepartamento(departamento);
    }

    if (resultado != null) {
        JOptionPane.showMessageDialog(this, 
            "Transferencia realizada a: " + resultado.getNombre(), 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, 
            "No se encontró ningún agente con esos datos.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_Departamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField txt_Extension;
    // End of variables declaration//GEN-END:variables
}
