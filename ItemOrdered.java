
public class ItemOrdered 
{
    
    private Item item;
    private int quantity;
    //protected static int rstock;
    
    ItemOrdered(Item item, int quantity)
    {        
        this.item=item;
        this.quantity=quantity;                
    }
    
    /*public static int getstock()
    {        
        return rstock;
    }
    */
    
    
    public Item getitem()
    {
        return item;
    }
    
    public int getquantity()
    {
        return quantity;
    }
    
    public void setquantity(int q)
    {
        quantity=q;
    }
    
    public void printA()
    {
        System.out.println(getitem()+ "\tQuantity:"+getquantity() + "\tStock:"+item.getstock());
    }
}