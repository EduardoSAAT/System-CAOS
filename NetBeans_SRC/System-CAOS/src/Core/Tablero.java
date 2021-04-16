/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;
import Algoritms.Cad;
import Core.Principal;
import DataStructure.TreeString;
import Dinamic.VectorString;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Ing Lalux
 */
public class Tablero extends javax.swing.JFrame {

    //Variable de Tipo de Trabajo de la Tabla
    // True=Crear    False=Report
    public boolean TypeWork = true;
    
    
    //Variables del Editor de Area
    public Editor_Areas AreaEditor;
    
    
    //Variables del editor de actividades
    public Editor_Actividades ActEditor;
    
    
    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
    }
    
    
    
    /**
     * Descripcion: Crear un tablero especificando si es para crear Periodos de Trabajo o para Reportalos
     *
     * @param	typeWork   True=Crear Periodo de Trabajo   False=Reportar Periodo de Trabajo
     */
    public Tablero(boolean typeWork){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            initComponents();
            TypeWork=typeWork;
            
            //Mandar a Cargar los Diferentes elementos de la Tabla
            Cargar_ComboAreas();
            Cargar_ArbolSelected();
	}else{
            System.out.println("ERROR en Constructor: Tablero, motivo: "+motivo);
	}
    }

    
    
    /**
     * Descripcion: Cargar el Arbol en especifico
     *
     * @param Arbol nombre del Arbol a Cargar
     */
    public void Cargar_Arbol(String Arbol){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Arbol == null){
        condiciones=false;
        motivo="Nombre Arbol null";
        
        //Limpiar el Diagrama anterior
            Diagram_Arbol.setModel(new DefaultTreeModel(new TreeString("vacio","vacio").getDefaultMutableTreeNode()));
            DefaultTreeModel modelo = (DefaultTreeModel) Diagram_Arbol.getModel();
            modelo.reload();
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Pedir al controlador de datos que entrege el Arbol//
            TreeString ArbolSelected = Principal.DataControll.getActual_ArbolLigth(Arbol);
            
            //Convertir el Arbol a un JTree//
            DefaultMutableTreeNode arbol = ArbolSelected.getDefaultMutableTreeNode();
            
            //Mostrar el JTree//
            Diagram_Arbol.setModel(new DefaultTreeModel(arbol));
            DefaultTreeModel modelo = (DefaultTreeModel) Diagram_Arbol.getModel();
            modelo.reload();
            
            //Modificar el comboBox//
            //comboAreas.setSelectedItem(Arbol);
        }else{
            System.out.println("ERROR en Cargar_Arbol, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Cargar_Arbol Terminado con EXITO");
    	}else{
            System.out.println("Proceso Cargar_Arbol Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Cargar el Arbol Seleccionado en el Combo Areas
     *
     */
    public void Cargar_ArbolSelected(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Leer cual es el Arbol actual
            String element = comboAreas.getItemAt(comboAreas.getSelectedIndex());
            Cargar_Arbol(element);
        }else{
            System.out.println("ERROR en Cargar_ArbolSelected, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Cargar_ArbolSelected Terminado con EXITO");
    	}else{
            System.out.println("Proceso Cargar_ArbolSelected Terminado con FALLO");
    	}
    }
    
    
    
    
    /**
     * Descripcion: Recargar Todo el Tablero tomando en cuenta el Tipo de Trabajo
     *
     */
    public void Reload(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            Cargar_ArbolSelected();
        }else{
            System.out.println("ERROR en Reload, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Reload Terminado con EXITO");
    	}else{
            System.out.println("Proceso Reload Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Mostrar la informacion ordenada de una actividad en el Tablero
     *
     * @param   actividad Que debe tener todas las variables
     */
    public void Cargar_Actividad(String actividad){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(actividad)){
        condiciones=false;
        motivo="Actividad null o vacia";
        textActividad.setText("");
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Limpiar el texto
            textActividad.setText("");
            
            //Obtener los datos//
            String NombreActividad=Cad.subCadCadACadB(actividad, "ACT(",")");
            String ID=Cad.subCadCadACadB(actividad, "ID(",")");
            String Prioridad=Cad.subCadCadACadB(actividad, "P(",")");
            String FF=Cad.subCadCadACadB(actividad, "FF(",")");
            String Porcentaje=Cad.subCadCadACadB(actividad, "%(",")");
            String Tmax=Cad.subCadCadACadB(actividad, "Tmax(",")");
            String Tuse=Cad.subCadCadACadB(actividad, "Tuse(",")");
            String CBP=Cad.subCadCadACadB(actividad, "CBP(",")");
            String PBP=Cad.subCadCadACadB(actividad, "PBP(",")");
            String RBP=Cad.subCadCadACadB(actividad, "RBP(",")");
            
            
            //Construir el cuadro
            textActividad.append("ID("+ID+")"+"   Actividad: "+NombreActividad+"\n");
            textActividad.append("Prioridad: "+Prioridad+"   Porcentaje Avance: "+Porcentaje+"%\n");
            textActividad.append("FF("+FF+")   Tmax:"+Tmax+"mins   Tuse:"+Tuse+"mins\n");
            textActividad.append("\n");
            textActividad.append("Cantida BP:"+CBP+"$ /hora_trabajo\n");
            textActividad.append("Plazo BP:"+PBP+" plazo\n");
            textActividad.append("Retorno BP:"+RBP+" recurrente\n");
            
        }else{
            System.out.println("ERROR en Cargar_Actividad, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Cargar_Actividad Terminado con EXITO");
    	}else{
            System.out.println("Proceso Cargar_Actividad Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Cargar las areas del sistema para hacer el comboBox de areas
     *
     */
    public void Cargar_ComboAreas(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Limpiar el combo de Areas
            comboAreas.removeAllItems();
            
            //Agregar todas las nuevas Areas
            VectorString temp = Principal.DataControll.getActual_AreasWork();
            
            for(int i=0; i<temp.Longitud(); i++){
                comboAreas.addItem(temp.getValue(i,"ERROR en cargarCombo"));
            }
        }else{
            System.out.println("ERROR en Cargar_ComboAreas, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso Cargar_ComboAreas Terminado con EXITO");
    	}else{
    		System.out.println("Proceso Cargar_ComboAreas Terminado con FALLO");
    	}
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
        comboAreas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Diagram_Arbol = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        textActNameAct = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textActTag = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textActVarChar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textActID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textActividad = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("AREA");

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(Diagram_Arbol);

        jLabel2.setText("ACTIVIDADES");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton3.setText("Filter");

        textActNameAct.setText("Name ACT");

        jLabel3.setText("Tag");

        textActTag.setText("$");

        jLabel4.setText("VarChar");

        textActVarChar.setText("#");

        jLabel5.setText("ID");

        jButton4.setText("Edit Act");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Add Act");

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        textActividad.setColumns(20);
        textActividad.setRows(5);
        jScrollPane3.setViewportView(textActividad);

        jLabel6.setText("ESTADISTIC");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jLabel7.setText("GENERAL INFO");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jLabel8.setText("CREAR SEMANA");

        jLabel9.setText("Tiempo Libre");

        jLabel10.setText("Tiempo Ocupado");

        jLabel11.setText("Tiempo Restante");

        jButton7.setText("OK");

        jButton8.setText("Check");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(textActNameAct)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textActTag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textActVarChar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(textActID))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField6)
                                    .addComponent(jTextField7))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboAreas)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textActNameAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textActTag)
                            .addComponent(textActVarChar)
                            .addComponent(textActID)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton8))
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Crear la ventana del Editor de Area
        AreaEditor = new Editor_Areas();
        AreaEditor.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Reload();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Buscar la actividad por ID si este esta
        if(Cad.isNulloVacia(textActID.getText())==false){
            String actID = textActID.getText();
            String actFULL = Principal.DataControll.getActual_Act_ID(actID);
            
            Cargar_Actividad(actFULL);
        }else{
            //Si no intentar buscar por Nombre, si este esta
            if(Cad.isNulloVacia(textActNameAct.getText())==false){
                
            }else{
                //Si no Mandar error
                textActID.setText("Edite filtros de busqueda");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Tomar el elemento seleccionado
        DefaultMutableTreeNode selectedNode;
        String elemento=null;
        try {
            selectedNode =(DefaultMutableTreeNode) Diagram_Arbol.getSelectionPath().getLastPathComponent();
            elemento = selectedNode.getUserObject().toString();
        } catch (Exception e) {
        }
        
        //Obtener ID del elemento
            String ID = Cad.subCadCadACadB(elemento, "ID(",")");
                //Obtener el nodo por su ID
                String act = Principal.DataControll.getActualNode_byID(ID);
                System.out.println("Editando Actividad: "+act);
            
            //Abrir el menu de edicion, si ID fue exitoso
            if(Cad.isNulloVacia(ID)==false){
                ActEditor = new Editor_Actividades(act);
                ActEditor.setVisible(true);
            }else{
                textActNameAct.setText("Alerta: No se puede editar, seleccione actividad primero");
            }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Diagram_Arbol;
    public javax.swing.JComboBox<String> comboAreas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField textActID;
    private javax.swing.JTextField textActNameAct;
    private javax.swing.JTextField textActTag;
    private javax.swing.JTextField textActVarChar;
    private javax.swing.JTextArea textActividad;
    // End of variables declaration//GEN-END:variables
}
