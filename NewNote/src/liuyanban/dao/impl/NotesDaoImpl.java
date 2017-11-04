package liuyanban.dao.impl;
import liuyanban.dao.NotesDao;
import liuyanban.model.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
public class NotesDaoImpl extends BaseDao implements NotesDao
{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	public int addNote(Notes note)
	{
		String sql="insert into notes(content,pubTime,title,userId) values(?,?,?,?)";
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String[] param={note.getcontent(),time,note.gettitle(),note.getuser().getuserId().toString()};
		return this.executeSQL(sql, param);
	}
	public List<Notes> getAllNotes()
	{
		List<Notes> list=new ArrayList<Notes>();
		String sql="select * from notes order by pubTime desc";
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Notes note=new Notes();
				note.setnoteId(rs.getInt("noteId"));
				note.settitle(rs.getString("title"));
				Users user=new UserDaoImpl().findUser(rs.getInt("userId"));
				note.setuser(user);
				list.add(note);
			}
		}catch(Exception e){e.printStackTrace();}
		finally{this.closeAll(conn, pstmt, rs);}
		return list;
	}
	public Notes getNoteById(int noteId)
	{
		Notes note=new Notes();
		String sql="select * from notes where noteId="+noteId;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				note.setnoteId(rs.getInt("noteId"));
				note.setcontent(rs.getString("content"));
				note.setpubTime(rs.getTimestamp("pubTime"));
				note.settitle(rs.getString("title"));
				Users user=new UserDaoImpl().findUser(rs.getInt("userId"));
				note.setuser(user);
			}
		}catch(Exception e){e.printStackTrace();}
		finally{this.closeAll(conn, pstmt, rs);}
		return note;
		}
	
}

