/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;
import Algoritms.Cad;
import Archivos.*;
import Data.DataController;
import Core.Tablero;
import Graphic.ErrorCatcher;

/**
 *
 * @author Ing Lalux
 */
public class Principal {
    //Sistema de control de errores//
    public static ErrorCatcher ErrorController;
    
    //Ruta de los archivos del Sistema
    public static String configFile = "Config.txt";
    public static String rutaHistory = "History/";
    public static String nameHistoryFiles="History_";
    public static int numHistory=0;
    public static int numActivity=0;
    public static boolean PeriodoActivo=false;
    
    //Variables del controlador de Datos
    public static Data.DataController DataControll;
    
    
    //Variables del MenuPrincipal
    public static Core.MenuPrincipal MenuP;
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ErrorController = new ErrorCatcher();
        
        if(Inicializar()==true){
            //Abrir el menu principal
            MenuP = new Core.MenuPrincipal(PeriodoActivo);
            MenuP.setVisible(true);
        }else{
            ErrorController.showError();
        }
    }
    
    
    
    
     /**
     * Descripcion: Inicializar el Sistema General
     *
     * @return	Exito o Fallo
     */
    public static boolean Inicializar (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida = true;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            System.out.println("Inicializando el Sistema");
            
            //Cargar la configuracion del Sistema//
                CargarConfig();
            
            //Inicializar el Controlador de Datos//
                DataControll = new DataController();
                DataControll.InicializarController();
	}else{
            System.out.println("ERROR en Inicializar, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Cargar la configuracion de los archivos del Sistema
     *
     * @return	valores de retorno
     */
    public static boolean CargarConfig (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida = false;
    //Comprobar Condiciones Iniciales//
    if(Archivos.Text.FileExist(configFile)==false){
        ErrorController.addError("Archivo de configuracion no encontrado");
    }
	//Comenzar Proceso//
        if(condiciones==true){
            System.out.println("Cargando la configuracion del Archivo");
            
            
            Archivos.Text archivo = new Text(configFile);
            
            //Cargar el numero de Archivo de Historial Actual
            String line = archivo.getLineLike("#History#(#)#","#");
            line = Cad.subCadCadACadB(line,"(",")");
            numHistory = Cad.aEntero(line,-1);
            
            //Cargar el numero de Arctividad Actual
            line = archivo.getLineLike("#Actividad#(#)#","#");
            line = Cad.subCadCadACadB(line,"(",")");
            numActivity = Cad.aEntero(line,-1);
            
            //Cargar el periodo//
            line = archivo.getLineLike("#Periodo#(#)#","#");
            line = Cad.subCadCadACadB(line,"(",")");
            if(Cad.Equals(line,"TRUE",true)){
                PeriodoActivo=true;
            }else{
                PeriodoActivo=false;
            }
            
            //Comprobar proceso//
            if (numHistory != -1  &&  numActivity != -1){
                salida=true;
            }else{
                ErrorController.addError("Error en Cargar configuracion, lineas de config no encontradas");
            }
	}else{
            System.out.println("ERROR en CargarConfig, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
