import java.util.ArrayList;
import java.io.*;

public class Person extends User{
    int password=0;
    User idiotita;
    ArrayList <Person> personList=new ArrayList<Person>();
    
    Person(String email,int password,User idiotita)
    {
        this.email=email;
        this.password=password;
        this.idiotita=idiotita;
    }
    
    public void Register(Person a)
    {
        personList.add(a);
    }
    
    public void setemail(String email)
    {
        this.email=email;
    }
    
    public String getemail()    
    {
        return email;
    }
    
    public void setpassword(int password)
    {
        this.password=password;
    }
    
    public int getpassword()
    {
        return password;
    }
    
    /*public void setidentity(String identity)
    {
        this.idiotita=idiotita;
    }
    
    public String getidiotita()
    {
        return idiotita;
    }
    */
}