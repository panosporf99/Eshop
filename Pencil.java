  

public class Pencil extends Item
{
    public double tipSize;
    
    public enum type
    {
        H,B,HB
    }
        
    public type ptype;
   
    Pencil(String name,double price,String description,int stock,int id, double tipSize,type ptype)
    {
        super(name,price,description,stock,id);
        this.tipSize=tipSize;
        this.ptype=ptype;
    }
    
    public String getDetails()
    {
        return "TipSize:" +tipSize+ "\tType of pencil:" +ptype;
    }
    
    
    
}