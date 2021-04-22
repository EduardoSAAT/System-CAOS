/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Algoritms.Cad;
import Algoritms.Nums;

/**
 *
 * @author Ing Lalux
 */
public class Editor_Actividades extends javax.swing.JFrame {
    public String Act;
    boolean isAct=false;
    boolean actDeleted=false;
    
    
    /**
     * Creates new form Editor_Actividades
     */
    public Editor_Actividades() {
        initComponents();
    }
    
    
    
     /**
     * Descripcion: Comprobar si un nodo es actividad o nodo
     *
     * @param	act Comprobar si una actividad es actividad o nodo
     * @return	false no es actividad, true es actividad
     */
    public boolean isActividad (String act){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Si es una actividad entonces debe tener el parametro FF()
            String fecha = Cad.subCadCadACadB(act,"FF(",")");
            
            if(Cad.isNulloVacia(fecha)==false){
                salida=true;
            }
	}else{
            System.out.println("ERROR en isActividad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }

    
    
    
    /**
     * Descripcion: Construir un editor de actividad con la actividad a editar
     *
     * @param	actividad a editar
     */
    public Editor_Actividades(String actividad){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            initComponents();
            Act=actividad;
            
            //Comprobar si se trata de una actividad o de un nodo
            isAct = isActividad(Act);
            if(isAct){
                System.out.println("Modificando Actividad:"+Act);
                
                //Obtener los parametros de la actividad
                String ID = Cad.subCadCadACadB(actividad,"ID(",")");
                String name=Cad.subCadCadACadB(actividad,"ACT(",")");
                String FF=Cad.subCadCadACadB(actividad,"FF(",")");
                String Prioridad=Cad.subCadCadACadB(actividad,"P(",")");
                    if(Cad.Equals(Prioridad,"ALTA",true)){
                        comboPrioridad.setSelectedIndex(0);
                    }
                    if(Cad.Equals(Prioridad,"MEDIA",true)){
                        comboPrioridad.setSelectedIndex(1);
                    }
                    if(Cad.Equals(Prioridad,"BAJA",true)){
                        comboPrioridad.setSelectedIndex(2);
                    }
                String Tmax=Cad.subCadCadACadB(actividad,"Tmax(",")");
                String Tuse=Cad.subCadCadACadB(actividad,"Tuse(",")");    
                String porcent=Cad.subCadCadACadB(actividad,"%(",")");
                String CBP=Cad.subCadCadACadB(actividad,"CBP(",")");
                String PBP=Cad.subCadCadACadB(actividad,"PBP(",")");
                    if(Cad.Equals(PBP,"CORTO",true)){
                        comboPBP.setSelectedIndex(0);
                    }
                    if(Cad.Equals(PBP,"MEDIANO",true)){
                        comboPBP.setSelectedIndex(1);
                    }
                    if(Cad.Equals(PBP,"LARGO",true)){
                        comboPBP.setSelectedIndex(2);
                    }
                String RBP=Cad.subCadCadACadB(actividad,"RBP(",")");
                    if(Cad.Equals(RBP,"YES",true)){
                        comboRBP.setSelectedIndex(0);
                    }
                    if(Cad.Equals(RBP,"NO",true)){
                        comboRBP.setSelectedIndex(1);
                    }
                String PadreID=Principal.DataControll.getActual_PadreID_byHijoID(ID);


                //Construir la ventana
                textNameAct.setText(name);
                textFF.setText(FF);
                textTMAX.setText(Tmax);
                texTUSE.setText(Tuse);
                textPorcentaje.setText(porcent);
                textCBP.setText(CBP);
                textPadreID.setText(PadreID);
            }else{
                System.out.println("Modificando Nodo:"+Act);
                
                //Obtener los parametros del nodo
                String ID = Cad.subCadCadACadB(actividad,"ID(",")");
                String name=Cad.subCadCadACadB(actividad,"ACT(",")");  
                String porcent=Cad.subCadCadACadB(actividad,"%(",")");
                String PadreID=Principal.DataControll.getActual_PadreID_byHijoID(ID);
                

                //Construir la ventana
                textNameAct.setText(name);
                textFF.setEnabled(false);
                textTMAX.setEnabled(false);
                texTUSE.setEnabled(false);
                textPorcentaje.setText(porcent);
                textCBP.setEnabled(false);
                textPadreID.setText(PadreID);
                comboPrioridad.setEnabled(false);
                comboPBP.setEnabled(false);
                comboRBP.setEnabled(false);
            }
	}else{
            System.out.println("ERROR en Editor_Actividades: nombreClase, motivo: "+motivo);
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

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNameAct = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textFF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboPrioridad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        textTMAX = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        texTUSE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textPorcentaje = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textCBP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboPBP = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboRBP = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        textMensaje = new javax.swing.JTextField();
        textPadreID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Editor de Actividades");

        jLabel2.setText("Nombre Actividad:");

        jLabel3.setText("Fecha FIN");

        jLabel4.setText("Prioridad");

        comboPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Media", "Baja" }));

        jLabel5.setText("TMax");

        jLabel6.setText("Tuse");

        jLabel7.setText("Avance%");

        jLabel8.setText("Cantidad BP ($/hora_trabajo)");

        jLabel9.setText("Plazo BP (L,M,C)");

        comboPBP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corto", "Mediano", "Largo" }));

        jLabel10.setText("Tipo Retorno BP");

        comboRBP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recurrente", "NoRecurrente" }));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Hacer Hijo del Nodo con ID: ");

        jButton2.setText("Eliminar Elemento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNameAct)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textPorcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(texTUSE, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTMAX, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboPrioridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textCBP)
                                            .addComponent(comboPBP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboRBP, 0, 151, Short.MAX_VALUE)
                                            .addComponent(textPadreID, javax.swing.GroupLayout.Alignment.TRAILING)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNameAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboPrioridad)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(textCBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texTUSE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboPBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(comboRBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPadreID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(textMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Primero comprobar si la actividad se elimino
        if(actDeleted){
            //simplemente cerrar esta ventana
            this.dispose();
        }else{
            //Continuar con la Edicion
            
            //Comprobar si es una actividad o un Nodo
            if(isAct){
                //Evaluar todos los elementos a agregar en la actividad
                boolean correcto=true;
                    //Evaluar el nombre
                    if(Cad.isNulloVacia(textNameAct.getText())){
                        correcto=false;
                        textMensaje.setText("Nombre de actividad vacio");
                    }

                    //Evaluar la fecha
                    if(time.AlgoritmsT.validarFecha(textFF.getText())==false){
                        correcto=false;
                        textMensaje.setText("Fecha FF no valida, verificarla");
                    }

                    //Evaluar el Tmax
                    if(Cad.aEntero(textTMAX.getText(),-1)<0){
                        correcto=false;
                        textMensaje.setText("Tiempo Maximo debe ser mayor igual a 0");
                    }

                    //Evaluar el Tuse
                    if(Cad.aEntero(texTUSE.getText(),-1)<0){
                        correcto=false;
                        textMensaje.setText("Tiempo Uso debe ser mayor igual a 0");
                    }

                    //Evaluar porcentaje de avance
                    int porcent = Cad.aEntero(textPorcentaje.getText(),-1);
                    if(Nums.Range(porcent,0,100)==false){
                        correcto=false;
                        textMensaje.setText("Porcentaje fuera de rango de 0 a 100");
                    }

                    //Evaluar el CBP
                    if(Cad.aEntero(textCBP.getText(),-1)<0){
                        correcto=false;
                        textMensaje.setText("Cantidad de BP debe ser mayor o igual a 0");
                    }
                    
                    //Evaluar el ID del padre, si existe o si es el mismo que el de la actividad, o si no es un ancestro
                    String ubicacionPadre = Principal.DataControll.getActual_Registro().getUbicacionNode_byID(textPadreID.getText());
                    if(Cad.isNulloVacia(ubicacionPadre)){
                        correcto=false;
                        textMensaje.setText("Ubicacion del padre no encontrada");
                    }
                    //Evaluar si el ID del padre es el mismo que el ID de esta actividad
                        String ID_este = Cad.subCadCadACadB(Act,"ID(",")");
                        String ID_padre = Principal.DataControll.getActualNode_byID(textPadreID.getText());
                               ID_padre = Cad.subCadCadACadB(ID_padre,"ID(",")");
                               
                        if(ID_este.equals(ID_padre)){
                            correcto=false;
                            String mensaje="Error en Editor de actividades, el ID del padre es el mismo que el de la actividad";
                            System.out.println(mensaje);
                            textMensaje.setText(mensaje);
                        }
                       


                //Si todo esta correcto, entonces guardar los cambios
                if(correcto){
                    //Construir la actividad
                    String arbol=Cad.subCadCadACadB(Act,"A(",")");
                    String ID=Cad.subCadCadACadB(Act,"ID(",")");;
                    String stat=Cad.subCadCadACadB(Act, "STAT(",")");

                    String act="A("+arbol+")";
                        act=act+"ID("+ID+")";
                        act=act+"FF("+textFF.getText()+")";
                        act=act+"P("+comboPrioridad.getItemAt(comboPrioridad.getSelectedIndex())+")";
                        act=act+"Tmax("+textTMAX.getText()+")";
                        act=act+"Tuse("+texTUSE.getText()+")";
                        act=act+"%("+textPorcentaje.getText()+")";
                        act=act+"CBP("+textCBP.getText()+")";
                        act=act+"PBP("+comboPBP.getItemAt(comboPBP.getSelectedIndex())+")";

                        String rbp = comboRBP.getItemAt(comboRBP.getSelectedIndex());
                        if(rbp.equals("Recurrente")){
                            rbp="YES";
                        }else{
                            rbp="NO";
                        }
                        act=act+"RBP("+rbp+")";

                        act=act+"ACT("+textNameAct.getText()+")";
                        act=act+"STAT("+stat+")";


                    //Mandar a modificar la actividad//
                    Principal.DataControll.modActual_Act(act,textPadreID.getText());
                    System.out.println("Valor Final al Modificar:"+act);
                    this.dispose();
                }
            }else{
                //Evaluar todos los elementos para modificar nodo
                boolean correcto=true;
                    //Evaluar el nombre
                    if(Cad.isNulloVacia(textNameAct.getText())){
                        correcto=false;
                        textMensaje.setText("Nombre de actividad vacio");
                    }

                    //Evaluar porcentaje de avance
                    int porcent = Cad.aEntero(textPorcentaje.getText(),-1);
                    if(Nums.Range(porcent,0,100)==false){
                        correcto=false;
                        textMensaje.setText("Porcentaje fuera de rango de 0 a 100");
                    }
                    
                    //Evaluar el ID del padre, si existe o si es el mismo que el de la actividad
                    String ubicacionPadre = Principal.DataControll.getActual_Registro().getUbicacionNode_byID(textPadreID.getText());
                    if(Cad.isNulloVacia(ubicacionPadre)){
                        correcto=false;
                        textMensaje.setText("Ubicacion del padre no encontrada");
                    }
                    //Evaluar si el ID del padre es el mismo que el ID de esta actividad
                        String ID_este = Cad.subCadCadACadB(Act,"ID(",")");
                        String ID_padre = Principal.DataControll.getActualNode_byID(textPadreID.getText());
                               ID_padre = Cad.subCadCadACadB(ID_padre,"ID(",")");
                               
                        if(ID_este.equals(ID_padre)){
                            correcto=false;
                            String mensaje="Error en Editor de actividades, el ID del padre es el mismo que el de la actividad";
                            System.out.println(mensaje);
                            textMensaje.setText(mensaje);
                        }
                        
                    //Evaluar si el ID del padre no es un hijo de este nodo, (no se puede hacer un hijo de su hijo)
                        //Obtener la ruta del ID padre
                        String pathPadre = Cad.subCadCadACadB(ubicacionPadre,"POS(",")");
                        String arbolPadre = Cad.subCadCadACadB(ubicacionPadre,"A(",")");
                        //Obtener la ruta del ID actual
                        String ubicacionActual = Principal.DataControll.getActual_Registro().getUbicacionNode_byID(ID_este);
                        String pathActual = Cad.subCadCadACadB(ubicacionActual,"POS(",")");
                        String arbolActual = Cad.subCadCadACadB(ubicacionActual,"A(",")");
                        
                        //Si son del mismo arbol hacer esa evaluacion
                        if(Cad.Equals(arbolPadre,arbolActual,false)){
                            int posArbol = Principal.DataControll.posActual_ArbolID(arbolActual);
                            
                            //si el hijo es un ancestro del padre entonces mandar un mensaje de alerta
                            if(Principal.DataControll.getActual_Registro().arboles[posArbol].isAncestro_byPaths(pathActual,pathPadre)){
                                correcto=false;
                                textMensaje.setText("ERROR un nodo padre no se puede convertir en hijo de sus hijos");
                            }
                        }


                //Si todo esta correcto, entonces guardar los cambios
                if(correcto){
                    //Construir la actividad
                    String arbol=Cad.subCadCadACadB(Act,"A(",")");
                    String ID=Cad.subCadCadACadB(Act,"ID(",")");;

                    String node="A("+arbol+")";
                        node=node+"ID("+ID+")";
                        node=node+"%("+textPorcentaje.getText()+")";
                        node=node+"ACT("+textNameAct.getText()+")";


                    //Mandar a modificar el nodo//
                    Principal.DataControll.modActual_Nodo(node,textPadreID.getText());


                    System.out.println("Valor Final al Modificar:"+node);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Eliminar elemento por ID
        String ID = Cad.subCadCadACadB(Act, "ID(",")");
        
        //comprobar si se trata de la raiz de un arbol o un nodo
        if(Principal.DataControll.AllHistory[Principal.DataControll.sizeHistory-1].isRaiz_byID(ID)){
            //Eliminar el arbol por completo
            String IDarbol = Cad.subCadCadACadB(Act,"A(",")");
            Principal.DataControll.eliminaActual_Arbol(IDarbol);
            
            //Mostrar resultados
            String mensaje="El nodo se elimino correctamente";
                System.out.println(mensaje);
                textMensaje.setText(mensaje);
                actDeleted=true;
            
            //Pedir un Reload del Trablero
            Principal.MenuP.MenuTablero.Cargar_ComboAreas();
            Principal.MenuP.MenuTablero.Reload();
        }else{
            //Eliminar como elemento del arbol
            Principal.DataControll.deleteActualNode_byID(ID);
        
            //Comprobar si se elimino correctamente
            if(Principal.DataControll.getActualNode_byID(ID)==null){
                String mensaje="El nodo se elimino correctamente";
                System.out.println(mensaje);
                textMensaje.setText(mensaje);
                actDeleted=true;
            }else{
                String mensaje="Ocurrio un problema al eliminar el nodo";
                System.out.println(mensaje);
                textMensaje.setText(mensaje);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Editor_Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor_Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor_Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor_Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor_Actividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboPBP;
    private javax.swing.JComboBox<String> comboPrioridad;
    private javax.swing.JComboBox<String> comboRBP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
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
    private javax.swing.JTextField texTUSE;
    private javax.swing.JTextField textCBP;
    private javax.swing.JTextField textFF;
    private javax.swing.JTextField textMensaje;
    private javax.swing.JTextField textNameAct;
    private javax.swing.JTextField textPadreID;
    private javax.swing.JTextField textPorcentaje;
    private javax.swing.JTextField textTMAX;
    // End of variables declaration//GEN-END:variables
}
