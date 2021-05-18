/*
 * Controlar de datos y almacenamiento de conjunto de Registros
 */
package Data;

import Algoritms.Cad;
import Algoritms.Nums;
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
     *  Con todos los parametros
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
     * Descripcion: Obtener el Arbol completo indicado del Registro Actual
     *
     * @return	TreeString o null
     */
    public TreeString getActual_Arbol (String nameArbol){
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
            int posArbol = AllHistory[sizeHistory-1].pos_ArbolID(nameArbol);
            salida = AllHistory[sizeHistory-1].arboles[posArbol];
	}else{
            System.out.println("ERROR en getActual_Arbol , motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Obtener el Registro actual
     *
     * @return	TreeString o null
     */
    public Registro getActual_Registro (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Registro salida=null;
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
            salida = AllHistory[sizeHistory-1];
	}else{
            System.out.println("ERROR en getActual_Registro , motivo: "+motivo+", valor regresado: "+salida);
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
     *  ID va a ser el nombre del arbol
     *  RAIZ es el nodo completo con todos sus parametros
     *
     *  @param Elemento Raiz con todos sus parametros
     */
    public void crearActual_Arbol(String element){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Pedir al registro actual que cree un nuevo Arbol
            String id = Cad.subCadCadACadB(element,"ACT(",")");
            AllHistory[sizeHistory-1].Crear_Arbol(id, element);
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
            
                //Cambiar el contador de Nodos
                int posline = file.posLineLike("#Nodos#(#)#","#");
                file.RemplaceLineN(posline,"Nodos("+Principal.numNodos+")");
                
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
                int posline = file.posLineLike("#Nodos#(#)#","#");
                file.RemplaceLineN(posline,"Nodos("+Principal.numNodos+")");
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
    if(Cad.isNulloVacia(ID)){
        condiciones=false;
        motivo="ID null o vacio";
    }
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
            
            //Recalcular el porcentaje del padre
            AllHistory[sizeHistory-1].refreshPorcent_byUbication(position);
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
     * Descripcion: Modificar un Nodo del registro actual
     * 
     * @param   newNodo  Nodo con todos sus parametros
     * @param   padreID ID del nuevo posible padre para este Nodo
     */
    public void modActual_Nodo(String newNodo, String padreID){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            String position = AllHistory[sizeHistory-1].getUbicacionNode_byID(padreID);
            
            if(Cad.isNulloVacia(position)){
                condiciones=false;
                motivo="No se encontro ubicacion de ID:"+padreID;
            }else{
                AllHistory[sizeHistory-1].ModifyNodo(newNodo, position);
            }
        }else{
            System.out.println("ERROR en modActual_Nodo, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso modActual_Nodo Terminado con EXITO");
    	}else{
    		System.out.println("Proceso modActual_Nodo Terminado con FALLO"+motivo);
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
    
    
    
    
    /**
     * Descripcion: Exportar los Archivos de History a Archivos TXT del mismo nombre
     *
     */
    public void HistoryCAOS_to_TXT(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Para todos los archivos de History
            for(int i=0; i<sizeHistory; i++){
                //Crear el nuevo Archivo de texto
                String nameFile = "History/History_"+(i+1)+".txt";
                Text.CrearNewFile(nameFile);
                Text file = new Text(nameFile);
                
                //Para todos los arboles del Registro, mandalos a este archivo
                for(int x=0; x<AllHistory[i].sizeTrees; x++){
                    String nameArbol = AllHistory[i].arboles[x].IdArbol;
                    
                    //Agregar las linea de separador del nombre de Arbol
                    file.AgregarLine("INICIO("+nameArbol+")");
                    file.AgregarLine("FIN("+nameArbol+")");
                    int posLine = file.NumLines();
                    
                    //Agregar este arbol
                    AllHistory[i].arboles[x].printTreeFileTxt(nameFile, posLine, "\t", 1);
                }
            }
        }else{
            System.out.println("ERROR en History_to_TXT, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso History_to_TXT Terminado con EXITO");
    	}else{
            System.out.println("Proceso History_to_TXT Terminado con FALLO");
    	}
    }
    
    
    
    
    
    /**
     * Descripcion: Convertir los archivos encontrados en History de tipo TXT en tipo CAOS
     *
     * @return	true exito, false fallo
     */
    public boolean HistoryTXT_to_CAOS(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=true;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear un Cargador para el Proceso
            Graphic.Loader.loadWindows7 cargador = new loadWindows7();
            cargador.Avanzar("Iniciando Convercion de Archivos de Texto a CAOS");
            
            
            //Encontrar todos los elementos tipo TXT en la carpetaHistory
            //Primero reparar el numero de History
            boolean exist_File = true;
            int contadorFile = 1;
            while (exist_File) {
                //Construir el archivo
                String nameFile = "History/History_"+contadorFile+".txt";
                
                if(Binary.FileExist(nameFile)){
                    contadorFile=contadorFile+1;
                    cargador.Avanzar("Archivo History encontrado:"+nameFile);
                }else{
                    exist_File=false;
                }
            }
            contadorFile=contadorFile-1;
            
            
            //Para cada Archivo Trabajar
            for(int i=1; i<=contadorFile; i++){
                //Abrir el Archivo txt
                String fileNameText = "History/History_"+i+".txt";
                Text fileText = new Text(fileNameText);
                cargador.Avanzar("Trabajando con Archivo:"+fileNameText);
                System.out.println("Trabajando con Archivo: "+fileNameText);
                
                    //Contar el numero de Arboles del Archivo de Texto
                    int numArboles=0;
                    for(int x=1;x<=fileText.NumLines(); x++){
                        if(Cad.LikeA(fileText.LeerLineaN(x), "#INICIO#(#)#","#")){
                            numArboles=numArboles+1;
                        }
                    }
                    System.out.println("Numero de arboles encontrado:"+numArboles);
                    cargador.Avanzar("Numero de arboles encontrado:"+numArboles);
                    
                    
                    //Cargar los arboles a un vector de arboles
                    TreeString[] arbolesFound = new TreeString[numArboles];
                        for(int j=1; j<=numArboles; j++){
                            int posInicioArbol = fileText.posLineLikeN("#INICIO#(#)#", "#", j);
                            int posFinalArbol = fileText.posLineLikeN("#FIN#(#)#", "#", j);
                            String nameArbol = fileText.LeerLineaN(posInicioArbol);
                            nameArbol = Cad.subCadCadACadB(nameArbol,"(",")");
                            TreeString arbol = new TreeString(nameArbol);
                            arbol.createTreeFromFileTxt(posInicioArbol+1, posFinalArbol-1, "\t", fileNameText);
                            arbol.IdArbol=nameArbol;
                            arbolesFound[j-1]=arbol;
                            
                            //Mostrar el arbol cargado
                            cargador.Avanzar("Arbol Cargado: "+nameArbol);
                            arbol.showTree();
                            System.out.println("\n");
                        }
                    
                //Crear el Registro nuevo de CAOS
                Registro reg = new Registro();
                
                    //Cargar los Datos del Registro
                    reg.arboles = arbolesFound.clone();
                    reg.sizeTrees = numArboles;
                    reg.Cargar_AreasWork();
                    reg.Cargar_Actividades();
                    
                    //Crear el nuevo Archivo .CAOS
                    String nameFileBinary = "History/History_"+i+".caos";
                    Binary.CrearNewFile(nameFileBinary);
                    Binary binaryFile = new Binary(nameFileBinary);
                    binaryFile.Escribir(reg);
                    cargador.Avanzar("Creando Archivo Binario: "+nameFileBinary);
            }
            
            //Finalmente actualizar el Sistema por completo por los nuevos registro
            Repair_ConfigFile();
	}else{
            System.out.println("ERROR en HistoryTXT_to_CAOS, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    
     /**
     * Descripcion: Reparar Archivo de Configuracion
     *  Usando los archivos .caos encontrados en History
     *
     * @return	true Exito, false, Fallo
     */
    public boolean Repair_ConfigFile (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=true;
    //Comprobar Condiciones Iniciales//
    if(Binary.FileExist("History/History_"+1+".caos")==false){
        condiciones=false;
        motivo="No existe el archivo inicial: History/History_1.caos";
        salida=false;
    }
    if(Text.FileExist(Principal.configFile)==false){
        condiciones=false;
        motivo="El archivo de configuracion actual no existe";
        salida=false;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear un Cargador para el Proceso
            Graphic.Loader.loadWindows7 cargador = new loadWindows7();
            cargador.Avanzar("Iniciando Reparacion del Archivo");
            
            //Abrir el actual archivo de configuracion
            Text config = new Text(Principal.configFile);
            
            //Primero reparar el numero de History
            boolean exist_File = true;
            int contadorFile = 1;
            while (exist_File) {
                //Construir el archivo
                String nameFile = "History/History_"+contadorFile+".caos";
                
                if(Binary.FileExist(nameFile)){
                    contadorFile=contadorFile+1;
                    cargador.Avanzar("Archivo History encontrado:"+nameFile);
                }else{
                    exist_File=false;
                }
            }
            contadorFile=contadorFile-1;
            int posLine = config.posLineLike("#History(#","#");
            String line = config.LeerLineaN(posLine);
            line = Cad.remplazarSubcad_CadACadB(line,"History(",")", Nums.aCadena(contadorFile));
            config.RemplaceLineN(posLine, line);
                cargador.Avanzar("Contador de History Reparado, Historys found:"+contadorFile);
            
            //Actualizar el sistema con los valores de Historys
            Principal.numHistory = contadorFile;
            CargarHistorys();
            for(int i=0;i<getActual_Registro().sizeTrees; i++){
                System.out.println("Arbol Cargado:"+getActual_Registro().arboles[i].IdArbol);
            }
                
           
            
            //Reparar el Contador de Nodos, ya cargados los registros
            cargador.Avanzar("Reparando el contador de Nodos");
            int ID = 0; 
            
            //Para el ultimo registro y para todos sus arboles
            for(int arbol=0; arbol<getActual_Registro().sizeTrees; arbol++){
                //Obtener todas las ramas
                VectorString Ramas = getActual_Registro().arboles[arbol].getRamasAll();
                    
                    //Ver si en algun elemento hay algun ID mayor al actual
                    for(int rama=0; rama<=Ramas.Longitud(); rama++){
                        String ramaString = Ramas.getValue(rama,"0");
                        ramaString = Cad.subCadCadACadB(ramaString,"ID(",")");
                        int value = Cad.aEntero(ramaString,0);
                        
                        if(value>ID){
                            ID = value;
                        }
                    }
                
                //Obtener todas las hojas
                VectorString Hojas = getActual_Registro().arboles[arbol].getHojasAll();
                    
                    //Ver si en algun elemento hay algun ID mayor al actual
                    for(int hojas=0; hojas<=Hojas.Longitud(); hojas++){
                        String hojaString = Hojas.getValue(hojas,"0");
                        hojaString = Cad.subCadCadACadB(hojaString, "ID(", ")");
                        int value = Cad.aEntero(hojaString,0);
                        
                        if(value>ID){
                            ID = value;
                        }
                    }
            }
            
            //Pasar los datos del contador de nodos al file config
            int countNode = ID;
            posLine = config.posLineLike("#Nodos(#","#");
            line = config.LeerLineaN(posLine);
            line = Cad.remplazarSubcad_CadACadB(line,"Nodos(",")", Nums.aCadena(countNode));
            config.RemplaceLineN(posLine, line);
                System.out.println("Contador de Nodos Reparado, Nodos found:"+countNode);
                cargador.Avanzar("Contador de Nodos Reparado, Nodos found:"+countNode);
                
                
            
            //Reparar el Estado del Periodo
            cargador.Avanzar("Comprobando estado del Sistema");
            boolean stateFinal = false;
                //Comprobar si en algun arbol existe un nodo con estado activo
                Registro lastReg = getActual_Registro();
                for(int i=0; i<lastReg.sizeTrees; i++){
                    cargador.Avanzar("Comprobando arbol: "+lastReg.arboles[i].IdArbol);
                    
                    String ruta = lastReg.arboles[i].getRutaElementLike("#STAT(true)#","#");
                    //Si esta ruta existe entonces el estado es true
                    if(Cad.isNulloVacia(ruta)==false){
                        stateFinal=true;
                    }
                }
            posLine = config.posLineLike("#Periodo(#","#");
            line = config.LeerLineaN(posLine);
            if(stateFinal){
                line = Cad.remplazarSubcad_CadACadB(line,"Periodo(",")","true");
            }else{
                line = Cad.remplazarSubcad_CadACadB(line,"Periodo(",")","false");
            }
            config.RemplaceLineN(posLine, line);
                System.out.println("Periodo del sistema reparado, Estado Final:"+stateFinal);
                cargador.Avanzar("Periodo del sistema reparado, Estado Final:"+stateFinal);   
            
            
            //Terminar el Proceso
            cargador.Terminar();
            Principal.Inicializar();
            Principal.MenuP.Reload();
	}else{
            System.out.println("ERROR en Repair_ConfigFile, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
}
