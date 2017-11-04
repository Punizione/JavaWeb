package liuyanban.dao;
import java.util.List;

import liuyanban.model.Notes;
public interface NotesDao 
{
	public int addNote(Notes note);
	public List<Notes>getAllNotes();
	public Notes getNoteById(int noteId);
}
