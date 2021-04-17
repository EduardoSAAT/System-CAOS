/*
 * Controlar de datos y almacenamiento de conjunto de Registros
 */
package Data;

import Algoritms.Cad;
import Archivos.Binary;
import Archivos.Text;
import Core.Principal;
import DataStructure.TreeString;
import Dinamic.VectorString;
import Graphic.Loader.*;
        
/**
 *
 * @author Ing Lalux
 */
public class DataController {
    //Conjunto de todo el Historial
    // Donde 0 es el mas viejo y N el actual, es decir el ultimo Registro del Historial
    public Registro[] AllHistory;
    public int sizeHistory;
    
    
    
    
    
    /**
     * Descripcion: Inicializar el controlador de Datos
     *
     */
    public void InicializarController(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Si el numero de History=0, entonces crear el primer History, si no cargar todo los Historys
            if(Principal.numHistory==0){
                //Crear el primer History
                CrearPrimerHistory();
            }else{
                //CargarHistorys
                CargarHistorys();
            }
        }else{
            System.out.println("ERROR en InicializarController, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso InicializarController Terminado con EXITO");
    	}else{
            System.out.println("Proceso InicializarController Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Obtener los valores de las areas de trabajo del registro Actual
     *
     * @return	VectorString, null en caso de error
     */
    public VectorString getActual_AreasWork (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorString salida=null;
    //Comprobar Condiciones Iniciales//
    if(sizeHistory<=0){
        condiciones=false;
        motivo="sizeHistory == 0";
    }else{
        if(AllHistory==null){
            condiciones=false;
            motivo="No hay Registros de Historial";
        }else{
            if(AllHistory[sizeHistory-1]==null){
                condiciones=false;
                motivo="Posicion en vector History no valida";
            }
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = AllHistory[sizeHistory-1].AreasWork;
	}else{
            System.out.println("ERROR en getActual_AreasWork, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener el Arbol Ligero indicado del Registro Actual
     *
     * @return	TreeString o null
     */
    public TreeString getActual_ArbolLigth (String nameArbol){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        TreeString salida=null;
    //Comprobar Condiciones Iniciales//
    if(sizeHistory<=0){
        condiciones=false;
        motivo="sizeHistory == 0";
    }else{
        if(AllHistory==null){
            condiciones=false;
            motivo="No hay Registros de Historial";
        }else{
            if(AllHistory[sizeHistory-1]==null){
                condiciones=false;
                motivo="Posicion en vector History no valida";
            }
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = AllHistory[sizeHistory-1].getArbolLigth(nameArbol);
	}else{
            System.out.println("ERROR en getActual_ArbolLigth, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Cargar todos los Registros encontrados en la carpeta de Historial
     *
     */
    public void CargarHistorys(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Variables del contador de Registros
            int lastRegister = Principal.numHistory;
            int lastFound=0;
            
            ////Crear un loader para ver el estado del proceso
            Graphic.Loader.loadWindows7 Load = new loadWindows7(lastRegister*2);
            Load.setVisible(true);
            
            //Evaluar hasta que registros anteriores se tiene almacenado en la carpeta History
            System.out.println("Cargando Archivos History.....");
            for(int i=lastRegister; i>0; i--){
                if(Text.FileExist(Principal.rutaHistory+Principal.nameHistoryFiles+i)){
                    //El archivo existe y se sigue con el bucle
                }else{
                    //El archivo no se encontro y se termina el bucle en:
                    lastFound=i;
                }
                
                //Avanzar el loader
                Load.Avanzar("Buscando History_"+i);
            }
            
            //Crear el vector de Historys
            sizeHistory=lastRegister-lastFound+1;
            AllHistory = new Registro[sizeHistory];
            System.out.println("Total de Archivos History encontrados: "+sizeHistory);
            
            
            //Cargar los Datos del History
            for(int i=1; i<=sizeHistory; i++){
                Archivos.Binary file = new Binary(Principal.rutaHistory+Principal.nameHistoryFiles+i+".caos");
                AllHistory[i-1]=(Registro) file.Leer();
                Load.Avanzar("History_"+i+"  Cargado");
            }
            
            Load.Terminar();
        }else{
            System.out.println("ERROR en CargarHistorys, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso CargarHistorys Terminado con EXITO");
    	}else{
            System.out.println("Proceso CargarHistorys Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Crear el primer History del Sistema, en caso de ser usado por primera vez
     *
     */
    public void CrearPrimerHistory(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear la coleccion de Registros
            sizeHistory=1;
            AllHistory = new Registro[sizeHistory];
            
            //Crear el Registro y agregarlo
            Registro r = new Registro();
            r.CrearPrimerRegistro();
            
            //Agrego el Registro al History
            AllHistory[0] = r;
            
            //Guardar Cambios
            saveActualReg_newFile();
        }else{
            System.out.println("ERROR en CrearPrimerHistory, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso CrearPrimerHistory Terminado con EXITO");
    	}else{
            System.out.println("Proceso CrearPrimerHistory  Terminado con FALLO");
    	}
    }
    
    
    
    
    /**
     * Descripcion: Crear un Arbol en el Registro Actual
     *
     */
    public void crearActual_Arbol(String nameArbol){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Pedir al registro actual que cree un nuevo Arbol
            AllHistory[sizeHistory-1].Crear_Arbol(nameArbol, nameArbol);
        }else{
            System.out.println("ERROR en crearActual_Arbol, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso crearActual_Arbol Terminado con EXITO");
    	}else{
            System.out.println("Proceso crearActual_Arbol  Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Editar el nombre de
     *
     * @param oldName Viejo nombre a Editar ID
     * @param newName Nuevo nombre a poner
     */
    public void editaNameActual_Arbol(String oldName, String newName){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Pedir al registro actual
            AllHistory[sizeHistory-1].EditaName_Arbol(oldName, newName);
        }else{
            System.out.println("ERROR en editaNameActual_Arbol, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso editaNameActual_Arbol Terminado con EXITO");
    	}else{
            System.out.println("Proceso editaNameActual_Arbol  Terminado con FALLO");
    	}
    }
    
    
    
    
    /**
     * Descripcion: Eliminar un Arbol del Registro Actual
     *
     * @param nameID Nombre del Arbol a eliminar por ID
     */
    public void eliminaActual_Arbol(String nameID){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Pedir al registro actual
            AllHistory[sizeHistory-1].EliminaArbol(nameID);
        }else{
            System.out.println("ERROR en eliminaActual_Arbol, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso eliminaActual_Arbol Terminado con EXITO");
    	}else{
            System.out.println("Proceso eliminaActual_Arbol Terminado con FALLO");
    	}
    }
    
    
    
     /**
     * Descripcion: Obtener la posicion de un Arbol del Registro Actual basado en su ID
     *
     * @param	ID Nombre del identificador del Arbol
     * @return	-1 ERROR otro caso de 0 a sizeTrees-1
     */
    public int posActual_ArbolID (String ID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            salida=AllHistory[sizeHistory-1].pos_ArbolID(ID);
	}else{
            System.out.println("ERROR en posActual_ArbolID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la posicion de un Arbol del Registro Actual basado en su ID
     *
     * @param	HijoID  el ID del Hijo
     * @return	String ID del padre o null
     */
    public String getActual_PadreID_byHijoID (String HijoID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            salida = AllHistory[sizeHistory-1].getPadreID_byHijoID(HijoID);
	}else{
            System.out.println("ERROR en getActual_PadreID_byHijoID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener un nodo del registro actual dado su ID
     *
     * @param	nodeID Para obtener sus datos
     * @return	String con datos o null
     */
    public String getActualNode_byID (String nodeID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            salida=AllHistory[sizeHistory-1].getNode_byID(nodeID);
	}else{
            System.out.println("ERROR en getActualNode_byID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Guardar el registro Actual en un nuevo Archivo
     *              Esto aumenta el contador de History y de Actividad y posiblemente de Periodo
     *
     */
    public void saveActualReg_newFile(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear el nuevo archivo
            Principal.numHistory=Principal.numHistory+1;
            String nombreNew = Principal.rutaHistory+Principal.nameHistoryFiles+(Principal.numHistory)+".caos";
            Archivos.Binary.CrearNewFile(nombreNew);
            
            //Agregar los datos del ultimo registro
            Binary archivo = new Binary(nombreNew);
            archivo.Escribir(AllHistory[sizeHistory-1]);
            
            //Modificar el Archivo de Configuracion
            Archivos.Text file = new Text(Principal.configFile);
            
                //Cambiar el contador de Actividad
                int posline = file.posLineLike("#Actividad#(#)#","#");
                file.RemplaceLineN(posline,"Actividad("+Principal.numActivity+")");
                
                //Cambiar el Numero de Historys
                posline = file.posLineLike("#History#(#)#","#");
                file.RemplaceLineN(posline,"History("+Principal.numHistory+")");
                
                //Cambiar el estado del Periodo
                posline = file.posLineLike("#Periodo#(#)#","#");
                file.RemplaceLineN(posline,"Periodo("+Principal.PeriodoActivo+")");
        }else{
            System.out.println("ERROR en saveActualReg_newFile, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso saveActualReg_newFile Terminado con EXITO");
    	}else{
    		System.out.println("Proceso saveActualReg_newFile Terminado con FALLO");
    	}
    }
    
    
    
    
    
    /**
     * Descripcion: Guardar el registro Actual en el Archivo Actual
     *              Esto solo podria aumentar el cotnador de Actividad
     *
     */
    public void saveActualReg_actualFile(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear el nuevo archivo
            String nombreNew = Principal.rutaHistory+Principal.nameHistoryFiles+(Principal.numHistory)+".caos";
            Archivos.Binary.CrearNewFile(nombreNew);
            
            //Agregar los datos del ultimo registro
            Binary archivo = new Binary(nombreNew);
            archivo.Escribir(AllHistory[sizeHistory-1]);
            
            //Modificar el Archivo de Configuracion
            Archivos.Text file = new Text(Principal.configFile);
            
                //Cambiar el contador de Actividad
                int posline = file.posLineLike("#Actividad#(#)#","#");
                file.RemplaceLineN(posline,"Actividad("+Principal.numActivity+")");
        }else{
            System.out.println("ERROR en saveActualReg_newFile, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso saveActualReg_newFile Terminado con EXITO");
    	}else{
    		System.out.println("Proceso saveActualReg_newFile Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Eliminar un nodo por ID del registro actual
     *
     */
    public void deleteActualNode_byID(String ID){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            AllHistory[sizeHistory-1].deleteNode_byID(ID);
        }else{
            System.out.println("ERROR en deleteActualNode_byID, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso deleteActualNode_byID Terminado con EXITO");
    	}else{
    		System.out.println("Proceso deleteActualNode_byID Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Modificar una actividad del registro actual
     * 
     * @param   newAct  Actividad con todos sus parametros
     * @param   padreID ID del nuevo posible padre para esta actividad
     */
    public void modActual_Act(String newAct, String padreID){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            String position = AllHistory[sizeHistory-1].getUbicacionNode_byID(padreID);
            AllHistory[sizeHistory-1].ModifyActivity(newAct, position);
        }else{
            System.out.println("ERROR en modActual_Act, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso modActual_Act Terminado con EXITO");
    	}else{
    		System.out.println("Proceso modActual_Act Terminado con FALLO");
    	}
    }
    
    
     /**
     * Descripcion: Obtener una actividad por ID del registro Actual
     *
     * @param	ID de la actividad
     * @return	String con valor o null
     */
    public String getActual_Act_ID (String ID){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
        
	//Comenzar Proceso//
        if(condiciones==true){
            salida=AllHistory[sizeHistory-1].getAct_byID(ID);
	}else{
            System.out.println("ERROR en getActual_Act_ID, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
}
