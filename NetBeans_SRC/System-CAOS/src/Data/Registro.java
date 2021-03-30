/*
 * Registro individual del grupo de arboles
 */
package Data;
import DataStructure.TreeString;
import System.Main;

/**
 *
 * @author Ing Lalux
 */
public class Registro {
    //Registro de Coleccion de Arboles
    // Formato de Actividad para cada Arbol
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
    //
    // A(Personal)ID(100)FF(1/1/2030)P(ALTA)Tmax(60)Tuse(30)%(50)PBP(Largo)RBP(YES)CBP(100)ACT(Trabajar mas)
    public TreeString[] arboles;
    public int sizeTrees;

    
    
    
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
            TreeString a1 = new TreeString("Prueba","Raiz");
            a1.addSon("R","A(Prueba)ID(0)FF(1/1/2030)P(ALTA)Tmax(60)Tuse(30)%(50)PBP(Largo)RBP(YES)CBP(100)ACT(Actividad Prueba)");
            arboles[0] = a1;
            
            //Modificar el contador de Actividades
            Main.numActivity=1;
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
    
    
    
    
}
