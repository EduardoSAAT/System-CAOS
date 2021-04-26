/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;
import Algoritms.Cad;
import Algoritms.Nums;
import Core.Principal;
import DataStructure.TreeString;
import Dinamic.VectorString;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
    
    
    //Variables del agregador de actividades
    public Agregador_Actividades ActAdder;
    
    
    //Variables del Filtro
    public Filtro Filter;
    public String filtro;
        
    
    
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
            Crear_Filtro("FF(false),P(false),PBP(false),RBP(false),CBP(false)");
            Cargar_Actividades();
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
     * Descripcion: Cargar Actividades y ordenarlas por el filtro en la tabla
     *
     */
    public void Cargar_Actividades(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Borrar la tabla Anterior
            DefaultTableModel modelTabla = (DefaultTableModel) Tabla.getModel();
            modelTabla.setRowCount(0);
            
            
            
            //Para todas actividades del registro actual
            int numActividades=Principal.DataControll.getActual_Registro().Actividades.Longitud();
            String element="";
            String ID="";
            String ACT="";
            String P="";
            String FF="";
            String Tmax="";
            String Tuse="";
            int Trest=0;
            String PBP="";
            String RBP="";
            String CBP="";
            String state="";
            for(int posInsert=0; posInsert<numActividades; posInsert++){
                element=Principal.DataControll.getActual_Registro().Actividades.getValue(posInsert,"ERROR inter operation....");
            
                ID = Cad.subCadCadACadB(element,"ID(",")");
                ACT = Cad.subCadCadACadB(element, "ACT(",")");
                P = Cad.subCadCadACadB(element,"P(",")");
                FF = Cad.subCadCadACadB(element, "FF(",")");
                Tmax = Cad.subCadCadACadB(element,"Tmax(", ")");
                Tuse = Cad.subCadCadACadB(element,"Tuse(",")");
                Trest= Cad.aEntero(Tmax,0)-Cad.aEntero(Tuse,0);
                
                PBP = Cad.subCadCadACadB(element,"PBP(",")");
                RBP = Cad.subCadCadACadB(element,"RBP(",")");
                CBP = Cad.subCadCadACadB(element,"CBP(",")");
                state = Cad.subCadCadACadB(element,"STAT(",")");
                
                //Meter nuevo valor en la tabla
                DefaultTableModel modeloTabla = (DefaultTableModel) Tabla.getModel();
                modeloTabla.addRow(new Object[0]);
                
                modelTabla.setValueAt(ID, posInsert,0);
                modelTabla.setValueAt(ACT, posInsert, 1);
                modelTabla.setValueAt(Trest,posInsert,2);
                modelTabla.setValueAt(FF,posInsert,3);
                modelTabla.setValueAt(P,posInsert,4);
                modelTabla.setValueAt(PBP,posInsert,5);
                modelTabla.setValueAt(RBP,posInsert,6);
                modelTabla.setValueAt(CBP,posInsert,7);
                
                //Comprobar si el estado de esta actividad es activo
                if(state.equalsIgnoreCase("false")){
                    modelTabla.setValueAt(false,posInsert,8);
                }else{
                    modelTabla.setValueAt(true,posInsert,8);
                }
            }
        }else{
            System.out.println("ERROR en Cargar_Actividades, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Cargar_Actividades Terminado con EXITO");
    	}else{
            System.out.println("Proceso Cargar_Actividades Terminado con FALLO");
    	}
    }
    
    
    
    
    
    /**
     * Descripcion: Crear el filtro en base al conjunto de parametros
     *          Si tiene true el parametro es que es de menor a mayor
     *          Si tiene false entonces es de mayor a menor
     *          Y ordenar actividades al final
     * @param FF(true),P(true),PBP(true),RBP(true),CBP(true)
     */
    public void Crear_Filtro(String parametros){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Comprobar si el filtro es el mismo que el anterior
            if(Cad.Equals(filtro,parametros,false)){
                //Entonces no reordenar
            }else{
                //Guardar el nuevo filtro y reordenar
                filtro = parametros;
                
                
                //Obtener los valores del filtro
                String P = Cad.subCadCadACadB(parametros,"P(",")");
                    boolean order_P = false;
                    if(Cad.Equals(P, "true", false)){
                        order_P = true;
                    }

                String FF = Cad.subCadCadACadB(parametros,"FF(",")");
                    boolean order_FF = false;
                    if(Cad.Equals(FF, "true", false)){
                        order_FF = true;
                    }   

                String PBP = Cad.subCadCadACadB(parametros,"PBP(",")");
                    boolean order_PBP = false;
                    if(Cad.Equals(PBP, "true", false)){
                        order_PBP = true;
                    }  

                String RBP = Cad.subCadCadACadB(parametros,"RBP(",")");
                    boolean order_RBP = false;
                    if(Cad.Equals(RBP, "true", false)){
                        order_RBP = true;
                    }

                String CBP = Cad.subCadCadACadB(parametros,"CBP(",")");
                    boolean order_CBP = false;
                    if(Cad.Equals(CBP, "true", false)){
                        order_CBP = true;
                    } 
                VectorString orden_parametros = new VectorString(Cad.aVector(parametros,","));


                //Crear bloques de ordenamiento
                Dinamic.VectorString.BloqueOrder bloqueFF = new VectorString.BloqueOrder("FF(",")","Fecha",order_FF);
                
                VectorString customPriority = new VectorString(3);
                    customPriority.addVauleRigth("Baja");
                    customPriority.addVauleRigth("Media");
                    customPriority.addVauleRigth("Alta");
                Dinamic.VectorString.BloqueOrder bloqueP  = new VectorString.BloqueOrder("P(",")","CUSTOM",customPriority,order_P);
                
                VectorString customPBP = new VectorString(3);
                    customPBP.addVauleRigth("Corto");
                    customPBP.addVauleRigth("Mediano");
                    customPBP.addVauleRigth("Largo");
                Dinamic.VectorString.BloqueOrder bloquePBP  = new VectorString.BloqueOrder("PBP(",")","CUSTOM",customPBP,order_PBP);
                
                VectorString customRBP = new VectorString(2);
                    customRBP.addVauleRigth("YES");
                    customRBP.addVauleRigth("NO");
                Dinamic.VectorString.BloqueOrder bloqueRBP  = new VectorString.BloqueOrder("RBP(",")","CUSTOM",customRBP,order_RBP);
                Dinamic.VectorString.BloqueOrder bloqueCBP  = new VectorString.BloqueOrder("CBP(",")","Numerico",order_CBP);   


                //Crear el vector de bloques de ordenamiento en orde
                Dinamic.VectorString.BloqueOrder[] bloques = new VectorString.BloqueOrder[5];
                int posFF = orden_parametros.posValueLike("#FF(#", "#", false);
                    bloques[posFF]=bloqueFF;
                int posP  = orden_parametros.posValueLike("#P(#", "#", true);
                    bloques[posP]=bloqueP;
                int posPBP= orden_parametros.posValueLike("#PBP(#", "#", false);
                    bloques[posPBP]=bloquePBP;
                int posRBP= orden_parametros.posValueLike("#RBP(#", "#", false);
                    bloques[posRBP]=bloqueRBP;
                int posCBP= orden_parametros.posValueLike("#CBP(#", "#", false);
                    bloques[posCBP]=bloqueCBP;

                //Odenar las actividades al final
                Principal.DataControll.getActual_Registro().Actividades.OrderBy_Bloques(bloques);
            }
        }else{
            System.out.println("ERROR en Crear_Filtro, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Crear_Filtro Terminado con EXITO");
    	}else{
            System.out.println("Proceso Crear_Filtro Terminado con FALLO");
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
            Cargar_Actividades();
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
                //Obtener solo el nombre del Area
                comboAreas.addItem(temp.getValue(i,"ERROR en cargar combo"));
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
        Tabla = new javax.swing.JTable();
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
        barSemana = new javax.swing.JProgressBar();
        textTimeFree = new javax.swing.JTextField();
        textTimeOcupado = new javax.swing.JTextField();
        textTimeRest = new javax.swing.JTextField();
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

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Trest", "Fecha Fin", "Prioridad", "PBP", "RBP", "CBP", "OK"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setMaxWidth(40);
            Tabla.getColumnModel().getColumn(1).setMinWidth(270);
            Tabla.getColumnModel().getColumn(6).setMaxWidth(40);
            Tabla.getColumnModel().getColumn(8).setMaxWidth(50);
        }

        jButton3.setText("Filter");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        textTimeOcupado.setEditable(false);

        textTimeRest.setEditable(false);

        jLabel9.setText("Tiempo Libre");

        jLabel10.setText("Tiempo Ocupado");

        jLabel11.setText("Tiempo Restante");

        jButton7.setText("OK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Check");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

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
                            .addComponent(barSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                    .addComponent(textTimeFree)
                                    .addComponent(textTimeOcupado)
                                    .addComponent(textTimeRest))))))
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
                        .addComponent(barSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTimeFree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTimeOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTimeRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        
        //Ver si se pudo obtener elemento
        if(Cad.isNulloVacia(elemento)==false){
            //Obtener ID del elemento
            String ID = Cad.subCadCadACadB(elemento, "ID(",")");
                //Obtener el nodo por su ID
                String act = Principal.DataControll.getActualNode_byID(ID);
                //Obtener la ubicacion del nodo
                String ubicacion =Principal.DataControll.getActual_Registro().getUbicacionNode_byID(ID);
                String path_ubication=Cad.subCadCadACadB(ubicacion,"POS(", ")");
            
            //Comprobar si se trata de algun nodo Raiz, para mandar mensaje de error
            if(path_ubication.equals("R")){
                //Mandar mensaje
                String mensaje="No se puede editar el nodo RAIZ, intente en: Editor de Arboles";
                Principal.ErrorController.addError(mensaje);
                Principal.ErrorController.showError();
            }else{
                //Abrir el menu de edicion, si ID fue exitoso
                if(Cad.isNulloVacia(ID)==false){
                    ActEditor = new Editor_Actividades(act);
                    ActEditor.setVisible(true);
                }else{
                    String mensaje="Alerta: No se puede editar, seleccione actividad primero";
                    Principal.ErrorController.addError(mensaje);
                    Principal.ErrorController.showError();
                }
            } 
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String arbol = comboAreas.getItemAt(comboAreas.getSelectedIndex());
        ActAdder = new Agregador_Actividades(arbol);
        ActAdder.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Filter = new Filtro(filtro);
        Filter.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //Obtener el tiempo restante de las actividades seleccionadas y sumarlo
            //Obtener la Tabla//
            TableModel modelTabla = Tabla.getModel();
            
            //Para todas las filas de la tabla comprobar si estan en activo
            boolean state;
            int tRest_total=0;
            for(int fila=0; fila<modelTabla.getRowCount(); fila++){
                //Obtener el valor del estado
                state = (boolean) modelTabla.getValueAt(fila,8);
                
                //si el estado es activo entonces obtener el tiempo restante
                if(state==true){
                    int temp = (int) modelTabla.getValueAt(fila,2);
                    tRest_total=tRest_total+temp;
                }
            }
        
        //Calcular el tiempo ocupado por todas las actividades
        textTimeOcupado.setText(Nums.aCadena(tRest_total));
        
        //Calcular el tiempo restante del sistema
        int TRest = Cad.aEntero(textTimeFree.getText(),0)-tRest_total;
        textTimeRest.setText(Nums.aCadena(TRest));
        
        //Cargar la barra de avance
        barSemana.setMaximum(Cad.aEntero(textTimeFree.getText(),0));
        barSemana.setValue(tRest_total);
    }//GEN-LAST:event_jButton8ActionPerformed

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
    private javax.swing.JTable Tabla;
    private javax.swing.JProgressBar barSemana;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField textActID;
    private javax.swing.JTextField textActNameAct;
    private javax.swing.JTextField textActTag;
    private javax.swing.JTextField textActVarChar;
    private javax.swing.JTextArea textActividad;
    private javax.swing.JTextField textTimeFree;
    private javax.swing.JTextField textTimeOcupado;
    private javax.swing.JTextField textTimeRest;
    // End of variables declaration//GEN-END:variables
}
