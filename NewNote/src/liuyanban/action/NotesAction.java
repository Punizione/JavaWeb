package liuyanban.action;
import java.util.*;
import liuyanban.dao.impl.NotesDaoImpl;
import liuyanban.dao.NotesDao;
import liuyanban.model.*;
import com.opensymphony.xwork2.*;
public class NotesAction extends ActionSupport
{
	public Notes note=new Notes();
	public List<Notes>notes=new ArrayList<Notes>();
	public int noteId;
	public String content;
	public String title;
	public void setnoteId(int noteId)
	{
		this.noteId=noteId;
	}
	public int getnoteId()
	{
		return noteId;
	}
	public void settitle(String title)
	{
		this.title=title;
	}
	public String gettitle()
	{
		return title;
	}
	public void setcontent(String content)
	{
		this.content=content;
	}
	public String getcontent()
	{
		return content;
	}
	public String list()
	{
		NotesDao notesDao=new NotesDaoImpl();
		notes=notesDao.getAllNotes();
		return SUCCESS;
	}
	public String add()
	{
		if((null==content||content.equals(""))||(null==title||title.equals("")))
			return INPUT;
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		Users user=(Users)session.get("user");
		if(null==user)return LOGIN;
		note.setuser(user);
		note.content=content;
		note.title=title;
		NotesDao notesDao=new NotesDaoImpl();
		notesDao.addNote(note);
		return SUCCESS;
	}
	public String detail()
	{
		NotesDao notesDao=new NotesDaoImpl();
		note=notesDao.getNoteById(noteId);
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		session.put("note",note);
		return SUCCESS;
	}
}
