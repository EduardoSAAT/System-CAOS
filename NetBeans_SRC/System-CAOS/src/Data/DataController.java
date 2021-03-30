/*
 * Controlar de datos y almacenamiento de conjunto de Registros
 */
package Data;

import Archivos.Binary;
import System.Main;

/**
 *
 * @author Ing Lalux
 */
public class DataController {
    //Conjunto de todo el Historial
    // Donde 0 es el mas viejo y N el actual, es decir el ultimo Registro del Historial
    Registro[] AllHistory;
    int sizeHistory;
    
    
    
    
    
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
            if(Main.numHistory==0){
                //Crear el primer History
                CrearPrimerHistory();
            }else{
                //CargarHistorys
                
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
     * Descripcion: Guardar el registro Actual en un nuevo Archivo
     *              Esto aumenta el contador de History y de Actividad y posiblemente de Periodo
     *
     */
    public void saveNewFile(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear el nuevo archivo
            String nombreNew = Main.nameHistoryFiles+(Main.numHistory+1)+".caos";
            Archivos.Binary.CrearNewFile(nombreNew);
            
            //Agregar los datos del ultimo registro
            Binary archivo = new Binary(nombreNew);
            archivo.Escribir(AllHistory[sizeHistory-1]);
            
            //Modificar el Archivo de Configuracion
                //Cambiar el contador de Actividad
                
                //Cambiar el Numero de Historys
                
                //Cambiar el estado del Periodo
        }else{
            System.out.println("ERROR en saveNewFile, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso saveNewFile Terminado con EXITO");
    	}else{
    		System.out.println("Proceso saveNewFile Terminado con FALLO");
    	}
    }
    
    
}
