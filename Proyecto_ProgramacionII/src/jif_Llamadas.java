
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author Edgardo Mancia
 */
public class jif_Llamadas extends javax.swing.JInternalFrame {

    
    private ArrayList<llamadas> registroGlobal;
    private ArrayList<agentes> listaAgentes;
    
    public jif_Llamadas(ArrayList<llamadas> llamadas, ArrayList<agentes> agentes) {
        initComponents();
        this.registroGlobal = llamadas;
        this.listaAgentes = agentes;
        cargarLlamadas();
    }

    private void cargarLlamadas() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        for (llamadas l : registroGlobal) {
            String fechaInicioStr = (l.getFechaInicio() != null)
                ? formatter.format(l.getFechaInicio())
                : "Sin inicio";

            String fechaFinStr = (l.getFechaFin() != null)
                ? formatter.format(l.getFechaFin())
                : "Sin fin";
            
            model.addRow(new Object[]{
                l.getID_Agente(),
                buscarNombreAgente(l.getID_Agente()),
                fechaInicioStr,
                fechaFinStr,
                l.getDuracionFormateada(),
                l.getTipoLlamada()
            });
        }
    }
    private String buscarNombreAgente(int idAgente) {
        for (agentes ag : listaAgentes) {
            if (ag.getID_Agente() == idAgente) {
                return ag.getNombre();
            }
        }
        return "Desconocido";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fcNumeroAgente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fcNombreAgente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fcRangoFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"8753", "Mauricio Dias", "04/01/2025 14:02:56", "04/01/2025 15:02:56", "1 H", null},
                {"4525", "Eymi Sanchez", "04/01/2025 11:05:56", "04/01/2025 11:20:00", "15 min 4 s", null},
                {"2004", "Justo Pastor", "03/01/2025 16:03:06", "03/01/2025 16:47:32", "43 min 26 s", null},
                {"1964", "Jose Vazquez", "03/01/2025 13:56:02", "03/01/2025 13:58:02", "2 min", null},
                {"2000", "Julio Vazquez", "03/01/2025 12:30:02", "03/01/2025 12:40:02", "10 min", null},
                {"2345", "Dalila Sanchez", "03/01/2025 12:03:02", "03/01/2025 12:23:02", "20 min", null}
            },
            new String [] {
                "Numero Agente", "Agente", "Fecha Inicio", "Fecha Final", "Duracion", "Tipo"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Numero Agente");

        jLabel2.setText("Agente");

        jLabel3.setText("Rango de Fecha");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fcNumeroAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fcNombreAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fcRangoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Buscar)))
                .addContainerGap(325, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fcNumeroAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fcNombreAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fcRangoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        String fcnumeroAgente = fcNumeroAgente.getText().trim();
        String fcnombreAgente = fcNombreAgente.getText().trim();
        String fcrangoFecha = fcRangoFecha.getText().trim();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
        
        ArrayList<RowFilter<Object, Object>> filters = new ArrayList<>();
        
        if (!fcnumeroAgente.isEmpty()) {
            filters.add(RowFilter.regexFilter("(?i)" + fcnumeroAgente, 0));
        }

        if (!fcnombreAgente.isEmpty()) {
            filters.add(RowFilter.regexFilter("(?i)" + fcnombreAgente, 1));
        }
        
        if (!fcrangoFecha.isEmpty()) 
        {
            try {
                String[] fechas = fcrangoFecha.split("-");
                if (fechas.length == 2) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                    Date fechaInicio = sdf.parse(fechas[0].trim());
                    Date fechaFin = sdf.parse(fechas[1].trim());

                    RowFilter<Object, Object> filtroFecha = new RowFilter<Object, Object>() {
                        @Override
                        public boolean include(Entry<? extends Object, ? extends Object> entry) {
                            try {
                                SimpleDateFormat sdfFila = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                Date fechaInicioFila = sdfFila.parse(entry.getStringValue(2));
                                return !fechaInicioFila.before(fechaInicio) && !fechaInicioFila.after(fechaFin);
                            } catch (ParseException ex) {
                                return false;
                            }
                        }
                    };

                    filters.add(filtroFecha);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "El formato del rango de fecha debe ser:\ndd/MM/yyyy HH:mm - dd/MM/yyyy HH:mm", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        }
         RowFilter<Object, Object> compoundFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(compoundFilter);
        
    }//GEN-LAST:event_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField fcNombreAgente;
    private javax.swing.JTextField fcNumeroAgente;
    private javax.swing.JTextField fcRangoFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
