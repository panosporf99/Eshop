import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class ShoppingCart{
    
    ArrayList <ItemOrdered> orderList=new ArrayList <ItemOrdered>();
    private int capacity;
    private double totalprice=0;
    private int itemCount;
    private int stockvalue;   
    
    
    
    ShoppingCart()
    {
        capacity=5;
        itemCount=0;
        totalprice=0.0;
    }
    
    public void settotalprice(double totalprice)
    {
        this.totalprice=totalprice;
    }
    
    public double calculateNet(Buyer buu)
    {        
        return totalprice+buu.gettransfercost();
    }
                    
      public void addItemOrdered(ItemOrdered ItemO) 
    {        
        int i;
        int flag=0;
        if(capacity>=0)//Prepei na doume pws mporoume na arxikopoioume to quantity me 0, giati otan kanoume ItemOrdered antikeimeno parolo pou den exei ginei add exei quantity
          {        
            if(ItemO.getquantity()<= ItemO.getitem().getstock())
            {                
                for(i=0;i<orderList.size();i++)
                {                     
                    if((ItemO.getitem().getid()) == (orderList.get(i).getitem().getid()))
                        {
                            
                            flag=1;                            
                            orderList.get(i).getitem().setstockitem((orderList.get(i).getitem().getstock()) - (ItemO.getquantity()));
                            orderList.get(i).setquantity(orderList.get(i).getquantity() + ItemO.getquantity());
                            
                        }            
                }        
        if(flag==0)
        {            
            orderList.add(ItemO);     
            ItemO.getitem().setstockitem(ItemO.getitem().getstock()-ItemO.getquantity());
            System.out.println("\n\nAllazw to stock::"+ItemO.getitem().getstock());
            System.out.println("\nTo stock tou item:"+ItemO.getitem().getstock()+"\tTo quantity:"+ItemO.getquantity() );
            
        }        
            capacity--;
       } 
        else
            System.out.println("Den iparxei i zitoumeni posotita bale ligoteri!!!");//else throw new IllegalArgumentException ();    
   }
    else
        System.out.println("Den iparxei allos xwros sto kalathi agorwn sou");
            
          
    }
    
    public int getcapacity()
    {
        return capacity;
    }

    
    public void removeItemOrdered(ItemOrdered ItemO)
    {
        for(int i=0; i<orderList.size(); i++)
            if(orderList.get(i).getitem().getid() == ItemO.getitem().getid())
            {
                orderList.remove(ItemO);
                ItemO.getitem().setstockitem( (ItemO.getitem().getstock()) + (ItemO.getquantity()) );
                ItemO.setquantity(0);
                capacity++;
            }
            else 
                System.out.println("Den iparxei to sigkekrimeno proion sto kalathi!!!.Bale kapoio pou na iparxei!!!");
    }
    
    public void changeItemOrderedQuantity(Eshop es1,ItemOrdered ItemO,int quantity)
    {
        if(orderList.contains(ItemO))
                if(ItemO.getitem().getstock() >= quantity && quantity>0)
                    {
                        ItemO.getitem().setstockitem((ItemO.getitem().getstock()) + (ItemO.getquantity()) );
                        ItemO.setquantity(quantity);
                        es1.updateItemStock(ItemO.getitem(),ItemO.getitem().getstock()-quantity);
                    }
                else 
                    System.out.println("Den iparxei stin diathesimi posotita. Bale ligoteri!!!");
        else 
            System.out.println("Den periexetai to item sto kalathi agorwn!!.Bale allo antikeimeno!!!");
    }            
    
    public void CountShoppingCart(ShoppingCart shoppingcart)
    {                
        if(orderList.size()>0)
            for(int i=0; i<orderList.size();i++)                
                    totalprice+=orderList.get(i).getquantity() * orderList.get(i).getitem().getprice(); 
        settotalprice(totalprice);                                
    }
    
    public void showCart(Buyer b)
    {
        int sum=0;
        for(int i=0;i<orderList.size();i++)
            {System.out.println(orderList.get(i).getitem().toString()+
             "\nQuantity"+orderList.get(i).getquantity()+
            "\tPrice of Item:"+orderList.get(i).getquantity()*orderList.get(i).getitem().getprice()+"\n"); 
            sum+=orderList.get(i).getquantity()*orderList.get(i).getitem().getprice();
            }        
        System.out.println("\nKostos paraggelias:"+sum+"\tKostos Metaforikwn:"+b.gettransfercost());
    }
    
    public void clearCart()
    {
        orderList.clear();
        //System.out.println(orderList.size());
        /*
         * ItemOrdered io1;for(int i=0;i<orderList.size();i++)
            {
                
                io1=orderList.get(i);
                System.out.println("Pira to"+ i +"antikeimeno!!!");
                removeItemOrdered(io1);
                System.out.println("To ebgala apo ton pinaka");
            }
            System.out.println(orderList.size());*/
            //Sc1.removeItemOrdered(io1);
    }   
    
    public void checkout(ShoppingCart s1,Buyer b1)
    {
        String answer;
        Scanner keyboard= new Scanner(System.in);
        s1.showCart(b1);
        //System.out.println("\nTo kostos tou kalathiou sou:"+CountShoppingCart(s1));
        System.out.println("Epibebaiwsi plirwmis? Yes or No");
        answer = keyboard.next();
        if(answer.equals("Yes"))
        {
            b1.awardBonus(b1,s1);
             s1.clearCart();
        }
        else
            System.out.println("Telos tis periigisis");
        //System.out.println(orderList.size());    
    }
    
    public int getsize()
    {
        return orderList.size();
    }
        
}


  