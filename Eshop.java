
import java.util.ArrayList;
import java.lang.reflect.Method; 
import java.util.Scanner;
import java.io.*;

public class Eshop 
{
    protected String name;
    protected Owner owner;
    protected ItemOrdered additem;
    int quant=0;     
     ArrayList <Item> itemsList = new ArrayList <Item>();
     ArrayList <Buyer> buyersList = new ArrayList <Buyer>();
     
    Eshop(String name,Owner owner)
    {
        this.name=name;
        this.owner=owner;
    }
    
    Eshop(String name)
    {
        this.name=name;
    }
    
    public void addItem(Item add)//Xreiazetai exception
    {
        if (add.getstock()>0)
            itemsList.add(add);
        else 
            System.out.println("Den einai diathesimo to proion");//Tha mpei to exception
    }
    
       public void addBuyer(Buyer add)//Xreiazetai exception gia to an iparxei idi o Buyer(Einai ousiastika axristi)
    {
        
        if(!buyersList.contains(add)){
            
            buyersList.add(add);
        }
        else
            System.out.println("Iparxei idi autos o Buyer");// Tha mpei to exception
    }
    
     public Item getItemById(int id)
    {
        
        for(int i=0;i<itemsList.size();i++)
            if(id == itemsList.get(i).getid()){//trolia tha doume
                
               return itemsList.get(i);
            }
            
                
            return null;
    }
    
    public void removeItem(Item remove)
    {
        itemsList.remove(remove);
    }
    
 
    public void removeBuyer(Buyer remove)
    {
        buyersList.remove(remove);        
    }
    
    public void updateItemStock(Item item,int stock)
    {
        
        if(stock>=0)
            item.setstockitem(stock);
        else
            System.out.println("Filarako prepei na baleis mh arnhtiko stock");
    }
            
    public void showCategories()
    {
        System.out.println("\n1)Pencil\n2)Pen\n3)Notebook\n4)Paper");
    }
    
    public  void showProductsInCategory()
    {
        Scanner cat = new Scanner(System.in);
        Scanner keyboard= new Scanner(System.in);
        Scanner quantity=new Scanner(System.in);
        Scanner color=new Scanner (System.in);
        Scanner section=new Scanner(System.in);
        Scanner select= new Scanner(System.in);
        
        String answer=null,option0=null,option1=null,option2=null,option3=null;
        
        do{
         
        
        
        System.out.println("\nEpelekse apo poia katigoria theleis na deis ta prointa\n(Pen,Pencil,Notebook,Paper)");
        String category= cat.nextLine();
        
        
        if(category.equals("Pen")){
            System.out.println("\nPen: Blue Pen 10mm");
            System.out.println("\nDo you want to add the item to the Shopping Cart\nY or N");
            option0=select.nextLine();
            if(option0.equals("Y")){
                Pen pen1= new Pen("Blue Pen",10.0,"Good product",100,0,"Blue",10.0);                
                ItemOrdered pen= new ItemOrdered(pen1,0);                
                additem=pen;
                additem.printA();
                System.out.println("\n\n Type the Quantity you want to order:");
                quant=quantity.nextInt();
            }                                            
        }
            
        else if(category.equals("Pencil")){
             System.out.println("\nPencil:Pencil HB");
            System.out.println("\nDo you want to add the item to the Shopping Cart\nY or N");
            option1=select.nextLine();
            if(option1.equals("Y")){
                Pencil pencil1= new Pencil("Pencil HB",10.0,"Good product",100,1,1.0,Pencil.type.HB);
                ItemOrdered pencil=new ItemOrdered(pencil1,0);
                additem=pencil;
                additem.printA();
                System.out.println("\n\n Type the Quantity you want to order:");
                quant=quantity.nextInt();
            } 
        }
        
        else if(category.equals("Notebook")){            
            System.out.println("\nNotebook:Notebook with 3 themes");
            System.out.println("\nDo you want to add the item to the Shopping Cart\nY or N");
            option2=select.nextLine();
            if(option2.equals("Y")){
                Notebook notebook1= new Notebook("Notebook with 3 themes",10.0,"Good product",100,2,3);
                ItemOrdered notebook= new ItemOrdered(notebook1,0);
                additem=notebook;
                additem.printA();
                System.out.println("\n\n Type the Quantity you want to order:");
                quant=quantity.nextInt();                
            } 
        }
        
        else if(category.equals("Paper")){
          System.out.println("\nPaper:Paper with 100 pages");
            System.out.println("\nDo you want to add the item to the Shopping Cart\nY or N");
            option3=select.nextLine();
            if(option3.equals("Y")){
                Paper paper1= new Paper("Pencil HB",100000.0,"Good product",100,1,100,100);
                ItemOrdered paper= new ItemOrdered(paper1,0);
                //ShoppingCart.orderList.add(paper);
                additem=paper;                
                additem.printA();
                System.out.println("\n\n Type the Quantity you want to order:");
                quant=quantity.nextInt();//Ama mporoume sto telos otan ksanablepoume tis katigories                 
            } 
        }        
        else
            System.out.println("There is no such category");
            
        System.out.println("\nDo you want to see the products again?\n\nYes or No");
        answer=color.nextLine();
    }while(answer.equals("Yes"));
}
     
    public void showProduct(Item item)
    {
        item.printinfo();
    }
    
    public void checkStatus(Buyer buyer)
    {
        buyer.print();
    }
    
    public String getname()
    {
        return name;
    }
    
    public ItemOrdered getadditem()
    {
        return additem;
    }
    
    public int returnquant()
    {
        return quant;
    }
}    