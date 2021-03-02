
public class Owner extends User
{
    private boolean isAdmin; 
    
    
    Owner(String name,String email)
    {
        this.name=name;
        this.email=email;
        this.isAdmin=true;
    }
    
    Owner()
    {
        this.name="";
        this.email="";
        this.isAdmin=true;
    }
    
    public String getname()
    {
        return name;
    }
    
    public String getemail()
    {
        return email;
    }
    
    public void printowner()
    {
        System.out.println("Owner Name:"+name+" Owner Email:"+email);
    }
}