package text_editor;
import java.lang.String;

/**
 * 
 * @author saul
 * Editor es el "originator" de patrón de diseño "Memento"
 * 
 * Snapshop es el "memento" y está anidada dentro de la clase Editor de manera
 * que sólo el Editor pueda modificar los campos del memento Snapshopt
 * 
 */

// El ORIGINATOR Editor
public class Editor {
	private String text;
	
	
	//setters y getters
	public void setText(String text) {
		if(text!=null) this.text=text;
		else this.text="";
	}
	
	public String getText() {
		return text;
	}
	
	/**
	 * Este método agrega una nueva línea de texto al editor
	 */
	public void addText(String text) {
		if(text!=null) this.text=this.text+"\n"+text;
	}
	
	public void printText() {
		System.out.println("Contenido del editor:");
		System.out.print(getText());
	}
	/**
	 * el método para crear los Snapshot y salvar el estado actual del objeto editor
	 * dentro del MEMENTO (objeto de la clase Snapshot)
	 * @return un objeto de clase Snapshot que representa al MEMENTO
	 * nótese que al crear el Snapshot el método se pasa a si mismo (al Editor) al objeto Snapshot
	 */
	public Snapshot createSnapshot() {
		return new Snapshot(this,text);
	}
	
	/**
	 * La clase anidada Snapshop es el MEMENTO del patrón
	 * Los objetos Snapshop almacenan los estados de los objetos Editor
	 * @author saul
	 *
	 */
	public class Snapshot {
		private Editor editor;
		private String text;
		
		//constructor de la clase 
		// PENDIENTE: REVISAR SI EL CONSTRUCTOR TIENE QUE SER PUBLIC O PRIVATE
		public Snapshot(Editor editor,String text) {
			this.editor=editor;
			this.text=text;
		}
		
		//el metodo para hacer restore del snapshot almacenado en el memento
		public void restore() {
			editor.setText(text);
		}
	}
}
