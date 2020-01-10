package text_editor;

/**
 * La clase Command actúa como el CARETAKER del patrón
 * La idea es que el objeto Command obtenga un MEMENTO (Snapshot) antes de cambiar el estado del 
 * ORIGINATOR (Editor).
 * Cuando el usuario solicita el comando "Undo" (deshacer) el Command hace el restore del 
 * Editor al estado previamente guardado en el MEMENTO (Snapshot)
 * @author saul
 *
 */
public class Command {
	private Editor.Snapshot backup;
	private Editor editor;
	
	
	//constructor de la clase
	public Command(Editor editor) {
		this.editor=editor;
	}
	/**
	 * Este método hace el backup del estado actual del editor
	 */
	public void makeBackup() {
		backup = editor.createSnapshot();
	}
	
	/** 
	 * Este método es el comando "undo" para que el usuario pueda volver el editor
	 * al estado anterior almacenado en el Snapshot
	 */
	public void undo() {
		if(backup!=null) backup.restore();
	}

}
