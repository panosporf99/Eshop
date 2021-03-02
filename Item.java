
public abstract class Item {
    private String name;
    private  double price;
    private  String description;
    private int stock;
    private int id;
    
    public Item()
    {
        
    }
    
    public Item (String name, double price, String description, int stock,int id)
    {
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
        this.id=id;
    }

    private  String getBasicInfo() 
    {
        return "\nname=" + name + "\t" +
                "price=" + price + "\t" +
                "description=" + description + "\t" +
                "stock=" + stock + "\t" +
                "\tid=" + id + "\t";
                
    }
         
    public abstract String getDetails();

    public String toString()
    {
        return getBasicInfo() + "\t" + getDetails();
    }  
           
    public void printinfo()//Tipwnei tis arxikes plirofories tou prointos
    {
        System.out.println(toString());
    }
           
    public String getname()
    {
        return name;        
    }

    public double getprice()
    {
        return price;
    }
    
    public String getdescription()
    {
        return description;
    }

    public int getid()
    {
        return id;
    }
    
    public int getstock()
    {
        return stock;
    }
    
    public void setstockitem(int stocka)
    {
        stock=stocka;
    }
    
     
   
}


