public class Notebook extends Item
{
    private int sections;//  arithmos thematwn tetradiou 
    
    
    Notebook(String name, double price, String description, int stock, int id, int sections)
   {
       super(name,price,description,stock,id);
       this.sections=sections;
   }
   
   public String getDetails()
   {
       return "Sections:"+sections;
   }
   
   public String Category()
   {
       Class n=getClass();
       return n.getSimpleName(); 
   }
}