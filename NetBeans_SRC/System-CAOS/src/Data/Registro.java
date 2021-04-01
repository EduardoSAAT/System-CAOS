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

    
    //Areas de Trabajo Definidas
    public VectorString AreasWork;
    
    //Coleccion completa de Actividades
    public VectorString Actividades;
    
     
            
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
            a1.addSon("R","A(Prueba)ID(1)FF(1/1/2030)P(ALTA)Tmax(60)Tuse(30)%(50)PBP(Largo)RBP(YES)CBP(100)ACT(Actividad Prueba)");
            arboles[0] = a1;
                
                System.out.println("----------- Primer Registro Creado -------------");
                arboles[0].showTree();
                System.out.println("\n");
            
                
            //Modificar el contador de Actividades
            Principal.numActivity=1;
            
            
            //Cargar lo nuevos Datos
            Cargar_AreasWork();
            Cargar_Actividades();
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
    
    
}
