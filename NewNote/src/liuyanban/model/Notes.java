package liuyanban.model;
import java.sql.Timestamp;
public class Notes 
{
	public int noteId;
	public String title;
	public String content;
	public Timestamp pubTime;
	public Users user;
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
	public void setpubTime(Timestamp pubTime)
	{
		this.pubTime=pubTime;
	}
	public Timestamp getpubTime()
	{
		return pubTime;
	}
	public void setuser(Users user)
	{
		this.user=user;
	}
	public Users getuser()
	{
		return user;
	}
}
