public class Paper extends Item
{
    private int weight;
    private int pages;
    
    Paper(String name, double price, String description, int stock, int id, int weight, int pages)
    {
        super(name,price,description,stock,id);
        this.weight=weight;
        this.pages=pages;
    }
    
    public String getDetails()
    {
        return "Pages:" +pages+ "Weight:" +weight;
    }
    
    public String Category()//Trolia
    {
        Class pa=getClass();
        return pa.getSimpleName();
    }
}