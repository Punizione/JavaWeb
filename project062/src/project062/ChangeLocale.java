package project062;
import java.util.Locale;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.LocaleProvider;
public class ChangeLocale implements LocaleProvider {   
    private String lan;   
    public String getLan() {   
        return lan;   
    }   
    public void setLan(String lan) {   
        this.lan = lan;   
    }   
    public Locale getLocale() {   
        Locale locale=null;   
        if(lan.equals("1")){   
            locale=new Locale("zh", "cn");   
        }else if(lan.equals("2")){   
            locale=new Locale("en", "US");   
        }   
        return locale;   
    } 
    
    public String execute(){   
        ActionContext ac=ActionContext.getContext();   
        ac.setLocale(getLocale());   
        return "success";   
    }  
}  
