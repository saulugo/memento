package text_editor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;

/** 
 * @author saul
 * Esta clase implementa el programa principal para crear un editor de texto muy básico.
 * Tiene dos características o features:
 * 1) Acepta texto para ir agregando al buffer
 * 2) Tiene el comando "Undo" que permite al usuario regresar el buffer al estado anterior
 * 
 * Este programa sirve para ilustrar el patrón de diseño MEMENTO
 *
 */
public class CoolEditor {
	
	public static void main(String[] args) throws Exception{
		//VARIABLES
		
		//variable para almacenar al línea de texto del usuario
		String line;
		//creo el editor
		Editor editor=new Editor();
		//creo el comando Undo
		Command undo=new Command(editor);
		//variable para controlar el salir del programa
		boolean quit=false;
		//creo un BufferedReaded para poder leer las entradas por pantalla del usuario
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		
		while(quit==false) {
			System.out.println("\nEditar texto. Ayuda (Undo: ^u, Salir: ^s):");
			line = br.readLine();
			/**
			 *si es la primera línea que se escribe en el editor, la toma como text del editor
			 *sino, agrega la línea a lo que ya tenga de valor text del editor. Antes de agregar
			 *la nueva línea, hace un backup para que el usuario pueda volver al estado anterior
			 *si lo desea.
			 */
			if(!line.equals("^s")) {
				if(!line.equals("^u")) {
					if(editor.getText()==null) editor.setText(line);
					else {
						undo.makeBackup();
						editor.addText(line);
					}
				} else {
					undo.undo();
				}
				editor.printText();
			} else {
				quit=true;
			}
		}
		
		System.out.println("Has salido del editor!");

	}

}
