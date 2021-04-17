/*
 * Registro individual del grupo de arboles
 */
package Data;
import DataStructure.TreeString;
import Dinamic.VectorString;
import Core.Principal;
import java.io.Serializable;
import Algoritms.Cad;

/**
 *
 * @author Ing Lalux
 */
public class Registro implements Serializable{
    //Registro de Coleccion de Arboles
    // Formato de Actividad para cada Arbol
    // NAME() - Parametro para el nombre de las raices y ramas
    //
    // A()    - Nombre del Arbol
    // ID()   - Identificador de la actividad, unico en todo el sistema, en todos los arboles
    // FF()   - Fecha de Fin, en la cual la actividad no tiene sentido ser realizada
    // P()    - Prioridad de la actividad, Alta=Obligatoria, Media=No Obligatoria, pero importante, Baja=Practicamente un hobbie
    // Tmax() - Tiempo maximo destinado para cumplir la actividad, medido en minutos
    // Tuse() - Tiempo gastado en intentar cumplir la actividad en mins
    // %()    - Porcentaje de avance percibido 0 a 100%
    // CBP()  - Cantidad de beneficio potencial medido en pesos/horas_trabajo  ejm 150/h  de trabajo activo, no pasivo
    // PBP()  - Plazo para percibir efectos del beneficio potencial esperado, Corto=dias,meses  Mediano=varios meses, Largo=muchos meses, incluso años
    // RBP()  - Tipo de retorno de beneficio potencial, recurrente o no recurrente YES o NO
    // ACT()  - Nombre de la actividad
    // STAT() - Estado en el Periodo Actual  true Activo   false pasivo
    //
    // A(Personal)ID(100)FF(1/1/2030)P(ALTA)Tmax(60)Tuse(30)%(50)PBP(Largo)RBP(YES)CBP(100)ACT(Trabajar mas)STAT(false)
    public TreeString[] arboles;
    public int sizeTrees;

    
    //Areas de Trabajo Definidas, solo para consulta
    public VectorString AreasWork;
    
    //Coleccion completa de Actividades, solo para consulta rapida
    public VectorString Actividades;
    
    //Coleccion completa de Ramas, solo para consultas
    //public VectorString Ramas;
    
     
            
    /**
     * Descripcion: CrearPrimerRegistro, con valores basura
     *
     */
    public void CrearPrimerRegistro(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear el primer Arbol
            sizeTrees=1;
            arboles = new TreeString[sizeTrees];
            
            //Construir arbol
            TreeString a1 = new TreeString("Prueba","A(Prueba)ID(1)%(1)ACT(Prueba)");
            a1.addSon("R","A(Prueba)ID(2)%(50)ACT(Paquete General)");
            a1.addSon("1H","A(Prueba)ID(3)FF(1/1/2030)P(ALTA)Tmax(60)Tuse(30)%(50)PBP(Largo)RBP(YES)CBP(100)ACT(Actividad 1)STAT(false)");
            arboles[0] = a1;
                
                System.out.println("----------- Primer Registro Creado -------------");
                arboles[0].showTree();
                System.out.println("\n");
            
                
            //Modificar el contador de Actividades
            Principal.numActivity=3;
            
            
            //Cargar lo nuevos Datos
            Cargar_AreasWork();
            Cargar_Actividades();
            //Cargar_Ramas();
        }else{
            System.out.println("ERROR en CrearPrimerRegistro, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso CrearPrimerRegistro Terminado con EXITO");
    	}else{
            System.out.println("Proceso CrearPrimerRegistro Terminado con FALLO");
    	}
    }
    
    
    
    
    
    /**
     * Descripcion: Crear un Arbol en este Registro
     *
     * @param   ID Nombre del identificador del Arbol
     * @param   NameRaiz  Nombre de la Raiz del Arbol
     */
    public void Crear_Arbol(String ID, String NameRaiz){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
            //no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Aumentar el tamaño de los Arboles
            sizeTrees=sizeTrees+1;
            TreeString[] temp = new TreeString[sizeTrees];
            //Pasar todos los arboles viejos al nuevo
                for(int i=0; i<sizeTrees-1; i++){
                    temp[i] = arboles[i].Clone();
                }
            
            
            //Meter el nuevo Arbol
            TreeString a1 = new TreeString(ID,NameRaiz);
            temp[sizeTrees-1] = a1.Clone();
                
            System.out.println("----------- Estructura de Arboles Final -------------");
            
            for(int i=0; i<sizeTrees; i++){
                temp[i].showTree();
                System.out.println("\n");
            }
            System.out.println("\n");
            
            
            //Cambiar la estructura de arboles vieja por la nueva
            arboles = temp.clone();
            
            
            //Cargar lo nuevos Datos
            Cargar_AreasWork();
            Cargar_Actividades();
            //Cargar_Ramas();
        }else{
            System.out.println("ERROR en Crear_Arbol, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Crear_Arbol Terminado con EXITO");
    	}else{
            System.out.println("Proceso Crear_Arbol Terminado con FALLO");
    	}
    }
    
    
    
    
    /**
     * Descripcion: Cargar las diferentes areas de trabajo que se encuentren en el Registro
     *
     */
    public void Cargar_AreasWork(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            AreasWork = new VectorString(sizeTrees);
            
            for(int i=0; i<sizeTrees; i++){
                AreasWork.addVauleRigth(arboles[i].IdArbol);
            }
        }else{
            System.out.println("ERROR en Cargar_AreasWork, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Cargar_AreasWork Terminado con EXITO");
    	}else{
            System.out.println("Proceso Cargar_AreasWork Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Modificar una actividad existente
     *  Se conseva el contador de nodos
     *  Se conserva el id de la actividad
     *  Su ruta puede cambiar
     *
     * @param   newAct  Actividad con todos sus parametros
     * @param   position Posicion del posible nuevo padre de esta ACT A(arbol) POS(path)
     */
    public void ModifyActivity(String newAct, String position){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    //no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Obtener los datos de la posicion
            String arbol = Cad.subCadCadACadB(position,"A(",")");
            String path =Cad.subCadCadACadB(position,"POS(",")");
            
            //Eliminar la actividad anteior
            String ID = Cad.subCadCadACadB(newAct,"ID(",")");
            deleteNode_byID(ID);
            
            //Agregar la nueva actividad en el nuevo path
            arboles[pos_ArbolID(arbol)].addSon(path, newAct);
            
            //Recargar la lista de actividades
            Cargar_Actividades();
        }else{
            System.out.println("ERROR en ModifyActivity, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso ModifyActivity Terminado con EXITO");
    	}else{
            System.out.println("Proceso ModifyActivity Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Editar el nombre de un Arbol
     *
     * @param oldName  Nombre viejo del Arbol por ID
     * @param newName  Nombre nuevo del Arbol por ID
     */
    public void EditaName_Arbol(String oldName, String newName){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    int posArbol = pos_ArbolID(oldName);
    if(posArbol==-1){
        condiciones=false;
        motivo="Arbol con ID: "+oldName+" no encontrado!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Modificar el Arbol
            arboles[posArbol].IdArbol = newName;
            arboles[posArbol].remplazeNode("R", newName);
            
            //Recargar Variables
            Cargar_AreasWork();
            reloadActALL_Area(newName);
        }else{
            System.out.println("ERROR en EditaName_Arbol, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso EditaName_Arbol Terminado con EXITO");
    	}else{
            System.out.println("Proceso EditaName_Arbol Terminado con FALLO");
    	}
    }
    
    
    
     /**
     * Descripcion: Eliminar un Arbol del Regisro
     *
     * @param nameID  Nombre del Arbol a Eliminar
     */
    public void EliminaArbol(String nameID){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    int posArbol = pos_ArbolID(nameID);
    if(posArbol==-1){
        condiciones=false;
        motivo="Arbol con ID: "+nameID+" no encontrado!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear una nueva coleccion de arboles reducida de tamaño
            sizeTrees=sizeTrees-1;
            TreeString[] arbolesTemp = new TreeString[sizeTrees];
            
            //Pasar los elementos del arbol original al arbol temporal, ignorando el Borrado
            int posTemp=0;
            for(int i=0; i<sizeTrees+1; i++){
                if(arboles[i].IdArbol.equals(nameID)){
                    //Ignorar esta posicion
                }else{
                    arbolesTemp[posTemp] = arboles[i].Clone();
                    posTemp=posTemp+1;
                }
            }
            
            //Cambiar el nuevo arbol por el viejo
            arboles= arbolesTemp.clone();
            
            //Recargar Variables
            Cargar_AreasWork();
            Cargar_Actividades();
            //Cargar_Ramas();
        }else{
            System.out.println("ERROR en Elimina_Arbol, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Elimina_Arbol Terminado con EXITO");
    	}else{
            System.out.println("Proceso Elimina_Arbol Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Cargar todas las actividades del Registro
     *
     */
    public void Cargar_Actividades(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear el vector
            Actividades = new VectorString(Principal.numActivity);
            
            //Para todos los arboles obtener sus actividades//
            for(int i=0; i<sizeTrees; i++){
                VectorString temp = new VectorString(arboles[i].getHojasAll());
                
                //Pasar cada una de las actividades en temp al conjunto global
                for(int x=0; x<temp.Longitud(); x++){
                    Actividades.addVauleRigth(temp.getValue(x,"Error al obtener actividad"));
                }
            }
            
            System.out.println("------------ Actividades Cargadas -------------");
            Actividades.ImprimirConsola("\n");
            System.out.println("\n");
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
     * Descripcion: Cargar todas las ramas del Registro
     *
     */
    /*public void Cargar_Ramas(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear el vector
            Ramas = new VectorString(Principal.numActivity);
            
            //Para todos los arboles obtener sus ramas//
            for(int i=0; i<sizeTrees; i++){
                VectorString temp = new VectorString(arboles[i].getRamasAll());
                
                //Pasar cada una de las actividades en temp al conjunto global
                for(int x=0; x<temp.Longitud(); x++){
                    Ramas.addVauleRigth(temp.getValue(x,"Error al obtener actividad"));
                }
            }
            
            System.out.println("------------ Ramas Cargadas -------------");
            Ramas.ImprimirConsola("\n");
            System.out.println("\n");
        }else{
            System.out.println("ERROR en Cargar_Ramas, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Cargar_Ramas Terminado con EXITO");
    	}else{
            System.out.println("Proceso Cargar_Ramas Terminado con FALLO");
    	}
    }*/
    
    
    
    /**
     * Descripcion: Actualizar el nombre del Arbol a que pertenece cada actividad
     *
     * @param nameIDArbol Nombre del ID del Arbol a actualizar actividades
     */
    public void reloadActALL_Area(String nameIDArbol){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        int posArbol=-1;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(nameIDArbol)){
        condiciones=false;
        motivo="Nombre ID de arbol null o vacio";
    }else{
        posArbol = pos_ArbolID(nameIDArbol);
        
        if(posArbol==-1){
            condiciones=false;
            motivo="ID del Arbol no existe";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear el nuevo arboly modificarlo
            TreeString arbolTemp = arboles[posArbol].Clone();
            String rutaElement=null;
            do {    
                //Buscar cualquier elemento que tenga Actividades, para ser modificado
                rutaElement = arbolTemp.getRutaElementLike("#A("+nameIDArbol+")#", "#");
                
                if(rutaElement!=null){
                    //Obtener el Valor del Elemento a modificar//
                    String value = arbolTemp.getElement(rutaElement, "ERROR en getElemento");
                    
                    //Modificar el Elemento//
                    String newValor = Cad.remplazarSubcad_CadACadB(value,"A(",")",nameIDArbol);
                    
                    //Guardar el elemento modificado//
                    arbolTemp.remplazeNode(rutaElement, newValor);
                }
            } while (rutaElement!=null);
            
            //Enviar el nuevo arbol en la posicion del anterior
            arboles[posArbol] = arbolTemp.Clone();
        }else{
            System.out.println("ERROR en reloadActALL_Area, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso reloadActALL_Area Terminado con EXITO");
    	}else{
            System.out.println("Proceso reloadActALL_Area Terminado con FALLO");
    	}
    }
    
    
    
    
    /**
     * Descripcion: convertir el Arbol es su vercion Ligera
     *      Quitar las Variables y solo dejar el ID() ACT() %()
     *
     * @param	arbol Arbol con todo el contenido
     * @return	Arbol o null
     */
    public TreeString convertArbolLigth (TreeString arbol){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        TreeString salida=null;
    //Comprobar Condiciones Iniciales//
    if(arbol==null){
        condiciones=false;
        motivo="Arbol null!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = arbol.Clone();
            String rutaElement=null;
            do {    
                //Buscar cualquier elemento que tenga Actividades, para ser modificado
                rutaElement = salida.getRutaElementLike("#ACT(#)#", "#");
                
                if(rutaElement!=null){
                    //Obtener el Valor del Elemento a modificar//
                    String value = salida.getElement(rutaElement, "ERROR en getElemento");
                    
                    //Modificar el Elemento//
                    String newValor = "ID(" + Cad.subCadCadACadB(value,"ID(",")") + ") ";
                           newValor = newValor + Cad.subCadCadACadB(value,"ACT(",")")+ " ";
                           newValor = newValor + "%("+Cad.subCadCadACadB(value,"%(",")") + ")";
                    
                    //Guardar el elemento modificado//
                    salida.remplazeNode(rutaElement, newValor);
                }
            } while (rutaElement!=null);
	}else{
            System.out.println("ERROR en convertArbolLigth, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el arbol ligero para usar en el diagrama del tablero
     *
     * @param	nameArbol Nombre del Arbol a obtener
     * @return	TreeString o null
     */
    public TreeString getArbolLigth (String nameArbol){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        TreeString salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Buscar la posicion del Arbol que me requieren
            int pos=-1;
            for(int i=0; i<sizeTrees; i++){
                if(arboles[i].IdArbol.equals(nameArbol)){
                    pos=i;
                    i=sizeTrees;
                }
            }
            
            if(pos==-1){
                //Entonces no se encontro arbol y mandar error
                Principal.ErrorController.addError("No se encontro Arbolname: "+nameArbol+" En el Vector de Arboles");
            }else{
                salida = convertArbolLigth(arboles[pos]);
            }
	}else{
            System.out.println("ERROR en getArbolLigth, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la posicion de un Arbol basado en su ID
     *
     * @param	ID Nombre del identificador del Arbol
     * @return	-1 ERROR otro caso de 0 a sizeTrees-1
     */
    public int pos_ArbolID (String ID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<sizeTrees; i++){
                if(Cad.Equals(arboles[i].IdArbol,ID, false)){
                    salida=i;
                    i=sizeTrees;
                }
            }
	}else{
            System.out.println("ERROR en pos_ArbolID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener El ID del padre de un Hijo por su ID
     *
     * @param	HijoID Para buscar su padre
     * @return	String de su ID o null si no esta
     */
    public String getPadreID_byHijoID (String HijoID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Buscar la actividad y obtener su ubicacion
            String ubicacion = getUbicacionNode_byID(HijoID);
            String arbol = Cad.subCadCadACadB(ubicacion,"A(",")");
            String path = Cad.subCadCadACadB(ubicacion,"POS(",")");
            
            //Obtener al padre con los datos del hijo
            String padre = arboles[pos_ArbolID(arbol)].getPadre(path,null);
            salida = Cad.subCadCadACadB(padre,"ID(",")");
	}else{
            System.out.println("ERROR en getPadreID_byHijoID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la ubicacion de algun nodo (actividad o rama) dado su ID
     *  Nomenglatura: A(NombreArbol)POS(1H2H1H)
     *
     * @param	nodeID Para obtener su ubicacion
     * @return	String con ubicacion o null en caso de error
     */
    public String getUbicacionNode_byID (String nodeID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Buscar en todos los arboles hasta encontrar el ID
            String ruta=null;
            int posArbol=-1;
            for(int i=0; i<sizeTrees; i++){
                ruta = arboles[i].getRutaElementLike("#ID("+nodeID+")#","#");
                
                //Si la ruta es diferente de null entonces encontro
                if(ruta!=null){
                    posArbol=i;
                    i=sizeTrees;
                }
            }
            
            //Construir la salida con los datos
            if(Cad.isNulloVacia(ruta)||posArbol==-1){
                //Mensaje de error
            }else{
                salida="A("+arboles[posArbol].IdArbol+")"+"POS("+ruta+")";
            }
	}else{
            System.out.println("ERROR en getUbicacionNode_byID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener String de una actividad buscandola por ID
     *
     * @param	ID de la actividad
     * @return	String con valor o null
     */
    public String getAct_byID (String ID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Buscar en todas las actividades
            int size=Actividades.Longitud();
            String line="";
            String subID="";
            for(int i=0; i<size; i++){
                line=Actividades.getValue(i,null);
                
                subID = Cad.subCadCadACadB(line,"ID(",")");
                if(Cad.Equals(subID,ID,false)){
                    //Encontramos la actividad
                    salida=line;
                    i=size;
                }
            }
	}else{
            System.out.println("ERROR en getAct_byID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Obtener String de un nodo buscandola por ID
     *
     * @param	ID del nodo en general
     * @return	String con valor o null
     */
    public String getNode_byID (String NodeID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Obtener la ubicacion del node por ID
            String ubicacion = getUbicacionNode_byID(NodeID);
            String arbol = Cad.subCadCadACadB(ubicacion,"A(",")");
            String path = Cad.subCadCadACadB(ubicacion,"POS(",")");
            
            //Obtener el elemento
            salida = arboles[pos_ArbolID(arbol)].getElement(path,null);
	}else{
            System.out.println("ERROR en getAct_byID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Eliminar un nodo del Registro por su ID
     *
     * @param   ID del nodo a eliminar
     */
    public void deleteNode_byID(String ID){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            //Obtener la ubicacion del elemento
            String ubicacion = getUbicacionNode_byID(ID);
            String arbolID = Cad.subCadCadACadB(ubicacion,"A(",")");
            String path = Cad.subCadCadACadB(ubicacion,"POS(",")");
            
            //Eliminar el Registro
            arboles[pos_ArbolID(arbolID)].deleteNodo(path);
        }else{
            System.out.println("ERROR en deleteNode_byID, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso deleteNode_byID Terminado con EXITO");
    	}else{
            System.out.println("Proceso deleteNode_byID Terminado con FALLO");
    	}
    }
    
    
}
