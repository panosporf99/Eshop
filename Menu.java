import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
    
    String buyer_email,owner_email;
    Eshop eshop = null;
    ArrayList<Item> ItemsList = new ArrayList<>();
    ArrayList<Buyer> BuyersList = new ArrayList<>();
    ArrayList<Owner> ownersList = new ArrayList<>();
    boolean exit;//false
    Eshop es1= new Eshop("Library");
  
    
   
    Menu()
    {
        es1.addItem(new Paper("Paper",5.0,"Paper A4",10,1,9,500));
        es1.addItem(new Paper("Paper",6.0,"Paper A3",15,2,8,400));
       
    }
    

    public void runMenu(){
        printHeader();
        
        while(!exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
        }        
    }
    
    public int getInput(){
        Scanner kb = new Scanner(System.in);
        int choice=-1;
        while(choice<1 || choice >3){
            try{
                System.out.print("\n\nEnter your choice:");
               choice = Integer.parseInt(kb.nextLine());
            }
            
            catch(NumberFormatException e){
                System.out.println("Invalid selection plz try again.");
            }
        }
        return choice;
    }
    
    public void printHeader(){
        System.out.println("+-------------------------------------------+");
        System.out.println("|                                           |");
        System.out.println("|         Welcome to our Eshop Menu         |");//+Eshop.getname();
        System.out.println("|                                           |");
        System.out.println("+-------------------------------------------+");
    }
    
    public void printMenu(){
        System.out.println("\nPlease make a selection:");
        System.out.println("1)Login ");
        System.out.println("2)Sign up");
        System.out.println("3)Exit!!!!");
    }
    
    public void enteremail()
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner codeboard = new Scanner(System.in);
        Scanner identityboard = new Scanner(System.in);
        Scanner nameboard = new Scanner(System.in);
        Scanner distanceboard = new Scanner(System.in);
         String email=null;
         String idiotita=null;
         String name=null;
         String epilogi=null;
        int code=0,apostasi=0;
        boolean truth=false,finalle=false;
        
        System.out.println("\nEnter your name:");//Bazw onoma
        name=nameboard.nextLine();
        System.out.println("\n\nEnter your email:");//Bazw email
        email=keyboard.nextLine();        
        do{
        System.out.println("\nEnter what you are Buyer or Owner");
        idiotita=identityboard.nextLine();//Bazw tin idiotita tou
        
            if (idiotita.compareTo("Buyer")==0)//An grapsw Buyer tote
        {
            ShoppingCart sc1=new ShoppingCart();//Dhmiourgw Shopping Cart
            do{
            System.out.println("If you live in Patras press A\nIf you live outside Patras press B\nIf you live outside Greece press C");
            epilogi=distanceboard.nextLine();//Pou zeis gia na ftiaksei to distance
            
            
                if(epilogi.equals("A")){//An A
                    apostasi=5;
                    truth=true;
                }                       
                else if(epilogi.equals("B")){//An B
                    apostasi=50;
                    truth=true;
                }                    
                else if(epilogi.equals("C")){//An C
                    apostasi=101;
                    truth=true;
                }                    
                else
                    System.out.println("Type one of the three options:A,B or C");//Tipota apo ta tria
                    //System.out.println(truth);
                }while(truth==false);                
            Buyer b=new Buyer(name,email,0,sc1,apostasi);//Ftiaxnw dhmiourgo
           
            
            b.setdistance(apostasi);
            
            
            if (es1.buyersList.size()==0){
                es1.buyersList.add(b);
                finalle=true;
                System.out.println("Eftiaksa 1o Buyers");
            }
            
            else{
                for(int i=0;i<es1.buyersList.size();i++){
                    if(email.equals(es1.buyersList.get(i).getemail())){
                        System.out.println("The email already exists");//An to email iparxei teleiwnei to programma
                        System.exit(0);
                    }
                }
                
                
                
                for(int i=0;i<es1.buyersList.size();i++){
                    if(!email.equals(es1.buyersList.get(i).getemail())){
                        es1.buyersList.add(b);
                        finalle=true;
                        
                    }
            }
            
            System.out.println("LISTA BUYERS EHSOP");
            for(int i=0;i<es1.buyersList.size();i++){
                es1.buyersList.get(i).print();
            }
        }          
            
        }
        
        
        else if(idiotita.compareTo("Owner")==0)//AN GRAPSW OWNER
        {
            Scanner nameo = new Scanner(System.in);
            Scanner emailo = new Scanner(System.in);
            Scanner codeo = new Scanner(System.in);
            int counter=3;
            int attempt=3;
            int pin=9999;
            int temp=0;
            String email0=null,name0=null;
            
            System.out.print("Enter the code to become an Owner:");
            
            temp=codeo.nextInt();
            
            if(temp==pin)
                {
                    System.out.println("Correct PIN entered!");
                   Owner o= new Owner(name,email); 
                    
                    if(ownersList.size()==0){
                        ownersList.add(o);
                        finalle=true; 
                    }
                    else{
                        for(int i=0;i<ownersList.size();i++){
                            if(email.equals(ownersList.get(i).getemail())){
                                System.out.println("The email already exists");
                                System.exit(0);
                            }
                        }
                        
                        for(int i=0;i<ownersList.size();i++){
                            if(!email.equals(ownersList.get(i).getemail())){
                                //ownersList.add(o);
                                finalle=true;
                            }
                        }
                        
                    }
                    
            
                    //ownersList.add(o);//Kanei add
                  
                    //Eshop es2=new Eshop(es1.getname(),o);
                    //finalle=true;
                      
                }
                
            while(temp!=pin && attempt !=0){
                System.out.println("Invalid PIN entered!. "+ --attempt + "\tattempts remaining.");
                counter--;
                
                if(attempt !=0){
                    System.out.println("Enter the PIN again:");
                    temp=codeo.nextInt();
                    if(temp==pin){
                    System.out.println("Correct PIN entered!");
                    
                    Owner o= new Owner(name,email);
                    if(ownersList.size()==0){
                        ownersList.add(o);
                        finalle=true; 
                    }
                    else{//An den einai size==1 o pinakas
                        for(int i=0;i<ownersList.size();i++){
                            if(email.equals(ownersList.get(i).getemail())){
                                System.out.println("The email already exists");
                                System.exit(0);
                            }
                        }
                        
                        for(int i=0;i<ownersList.size();i++){
                            if(!email.equals(ownersList.get(i).getemail())){//Se periptwsi pou prosthesw deutero stimgiotipo
                               // ownersList.add(o);
                                finalle=true;
                            }
                        }
                        
                    }
                    //ownersList.add(o);//Kanei add
                   // Eshop es2=new Eshop(es1.getname(),o);
                    //finalle=true;
                    }
                    if(temp!=pin){
                        System.out.println("The code you entered is wrong!\nPlease try again!");
                    }
                        
                }
                else{
                    System.out.println("The System has thrown you away!!");
                    System.exit(0);
                    break;
                }
            }            
            
            es1.owner=new Owner(name,email);
            System.out.println("OWNER EHSOP");
            es1.owner.printowner();
        }
        else
            System.out.println("You need to type Buyer or Owner!\nPlease try again!!!!");
           
    }while(finalle==false);
    
    }
    
    public void loginin()
    {
        Scanner login=new Scanner(System.in);
        Scanner emailogin= new Scanner(System.in);
        Scanner options= new Scanner(System.in);
        Scanner own=new Scanner(System.in);
        Scanner epilog=new Scanner(System.in);
        
        int log=0,epilogi=0,i=0,ownep=0;
        String emaillogin=null;
        
        System.out.println("Write 1 if you are a Buyer or 0 if you are an Owner!!\n(No other answers are accepted)");
        log=login.nextInt();
        if(log==1)
            {
                System.out.println("Enter your email in order to login:");
                buyer_email=emailogin.nextLine();
                System.out.println(es1.buyersList.size());
                
                
                for(i=0;i<es1.buyersList.size();i++){                    
                    if(buyer_email.equals(es1.buyersList.get(i).getemail())){
                        //System.out.println("Hello dear"+buyersList.get(i).getname()+"!!!\n How are you?");                            
                        System.out.println(es1.buyersList.get(i).toString());
                        System.out.println("Hello dear "+es1.buyersList.get(i).getname()+"!!!"); 
                        
                        System.out.println("\n1.browse store\n2.view cart"+
                        "\n3.checkout\n4.back\n5.log out"+
                        "\n6.exit");
                        epilogi=options.nextInt();
                        
                        switch(epilogi){
                            case 1:
                            browse_store(es1.buyersList.get(i)); 
                            break;
                            case 2:
                            view_cart(es1.buyersList.get(i));
                            break;
                            case 6:
                            System.exit(0);
                            case 5:
                            loginin();
                            break;                           
                            case 4:
                            loginin();
                            break;
                        }
                    }}
                
                for(i=0;i<es1.buyersList.size();i++)   
                    if(!buyer_email.equals(es1.buyersList.get(i).getemail())){
                        System.out.println("This email has not been registered. Plz sign up!!");
                        //System.exit(0);
                    }
                        
                
                
            }
        
        else if(log==0)
        {
            Scanner p=new Scanner(System.in);
            Scanner l=new Scanner(System.in);
            String del,name; 
            System.out.println("Enter your email in order to login:");
            owner_email=own.nextLine();
            for(i=0;i<ownersList.size();i++){
                if(owner_email.equals(ownersList.get(0).getemail())){
                    System.out.print("Greetings Owner"+ownersList.get(0).getemail()+"\t"+ownersList.get(0).getname());
                    System.out.println("\n What would you like to do?\n1.Browse Store\n2.Check Status"+
                        "\n3.Back\n4.Log out \n5. Exit");
                       
                    ownep=epilog.nextInt();    
                    switch(ownep){
                        
                            case 1:
                            browse_storeo(ownersList.get(i));
                            break;
                            case 2:
                            for(int a=0; a<es1.buyersList.size();a++){
                                Buyer b;
                                b=es1.buyersList.get(a);
                                es1.checkStatus(b);
                        }                            
                            System.out.println("Would you like to delete a certain Buyer? Yes or No");
                            del=p.nextLine();
                            if(del.equals("Yes")){
                                System.out.println("Enter his/her name");
                                name=l.nextLine();
                                if(name.equals(es1.buyersList.get(i).getname()))
                                    es1.removeBuyer(es1.buyersList.get(i));
                                
                                   for(int c=0;c<es1.buyersList.size();c++)
                                    es1.buyersList.get(i).print();
                                }
                            break;
                            case 3:
                            loginin();
                            break;   
                            case 4:
                            loginin();
                            break;
                            case 5:
                            System.exit(0);
                            
                            
            
        } 
                    
                    for(i=0;i<ownersList.size();i++)   
                    if(!owner_email.equals(ownersList.get(i).getemail())){
                        System.out.println("This email has not been registered. Plz sign up!!");
                        System.exit(0);
                }
    }
        
    }
  }
} 
   
   
public void browse_storeo(Owner own)
    {
        Item item=null;
        Scanner choice=new Scanner(System.in);
        Scanner mikonos=new Scanner(System.in);
        Scanner pen=new Scanner(System.in);
        String apad,arap;
        int nstock=0;
        System.out.println("Would you like to change the stock from one product? Y or N");
        apad=choice.nextLine();
        if(apad.equals("Y")){
            es1.showCategories();
            System.out.println("From which Category would you like to change the stock :");
            arap=mikonos.nextLine();
           if(arap.equals("Pen")){
                System.out.println("What would you like the new stock of pens to be ? ");
                nstock=pen.nextInt();
                es1.updateItemStock(es1.getadditem().getitem(),nstock);
                es1.getadditem().printA();
           }
            if(arap.equals("Pencil"))
            {
                System.out.println("What would you like the new stock of pencils to be ? ");
                nstock=pen.nextInt();
                es1.updateItemStock(es1.getadditem().getitem(),nstock);
                es1.getadditem().printA();               
            }
            if(arap.equals("Notebook"))
            {
                System.out.println("What would you like the new stock of notebooks to be ? ");
                nstock=pen.nextInt();               
                es1.updateItemStock(es1.getadditem().getitem(),nstock);
                es1.getadditem().printA();               
            }
            
            if(arap.equals("Paper")){
                System.out.println("What would you like the new stock of notebooks to be ? ");
                nstock=pen.nextInt();
                es1.updateItemStock(es1.getadditem().getitem(),nstock);
                es1.getadditem().printA();                                                
}
}
}
    
    
    public void view_cart(Buyer pelatis0){
        ShoppingCart cart=pelatis0.getcart();
        Scanner ans= new Scanner(System.in);
        boolean fin=false;
        int answ=0;
        
        if(cart.orderList.size()==0)
            System.out.println("The cart is empty:");
        else{
            for(int i=0;i<cart.orderList.size();i++){
                (cart.orderList.get(i)).printA();
            }
                
        }
            
        System.out.println("1.Delete the order\n2.Change the quantity of the order for an item"+        
        "\n3.Clear the cart\n4.Checkout");
        answ=ans.nextInt();
        do{
            if(answ==1){
               cart.clearCart();            
               break;
            }
            if(answ==3){
               cart.clearCart();
               break;}
            if(answ==4){
                System.out.println("Are you sure you want to checkout?\n\nYes or No");
                String checkoutOption=null;
                Scanner checkout=new Scanner(System.in);
                checkoutOption=checkout.nextLine();
                
                if(checkoutOption== "Yes" && cart.orderList.size()==0){
                    cart.checkout(cart,pelatis0);
                }                
            }
            if(answ==2)
            {
                if(cart.orderList.size()!=0){
                    System.out.println("1.Change the quantity\n\n2.Back");
                    int epilog= ans.nextInt();
                    switch(epilog){
                        case 2:
                        break;
                        case 1:
                        System.out.println("From which item you want to change the quantity:"+
                        "\n\n(Type the correct id and an item that you have ordered)");
                        Scanner product=new Scanner(System.in);
                        int today=product.nextInt();
                        for(int i=0;i<cart.orderList.size();i++){
                            if(today==cart.orderList.get(i).getitem().getid()){
                                System.out.println("Select quantity:");
                                int tod=0;
                                tod=product.nextInt();
                                cart.changeItemOrderedQuantity(es1,cart.orderList.get(i),tod);
                            }
                            else{
                                System.out.println("You are dumb you deserve to be thrown away");
                                System.exit(0);
                            }
                            
                        }
                        
                       
                    }
                }
                else
                    System.out.println("You should first add some items!");
                
            }
            
            
        }while(fin==false);
        
        
        
    }
    
    
    public void browse_store(Buyer pelatis){        
        Scanner ha=new Scanner(System.in);
        String h=null;
        int papercounter=0,pencounter=0,notebookcounter=0,pencilcounter=0,quant=0;;//Tha to doume sto telos
        ShoppingCart s1=new ShoppingCart();
        //do{
        pelatis.setcart(s1);
        
        s1.showCart(pelatis);
        
        System.out.println(es1.getname());
        es1.showCategories();
        System.out.println("\n\nTotal pencil:"+pencilcounter+"\tTotal pen:"+pencounter+"\tTotal Notebook:"+notebookcounter+"\tTotal Paper:"+papercounter);
        es1.showProductsInCategory();        
        
        pelatis.placeOrder(s1,es1.getadditem(),es1.returnquant());
                        
        s1.showCart(pelatis);
        
        pelatis.awardBonus(pelatis,s1);
               
        
       
        
        for (int i=0;i<es1.itemsList.size();i++)
        {
            if (es1.itemsList.get(i).getClass().getName().compareTo("Paper")==0){
                papercounter++;
                ;
        }
        
        if (es1.itemsList.get(i).getClass().getName().compareTo("Pen")==0){
                pencounter++;
                
          }
          
        if (es1.itemsList.get(i).getClass().getName().compareTo("Notebook")==0){
                notebookcounter++;
                
          }
          
        if (es1.itemsList.get(i).getClass().getName().compareTo("Pencil")==0){
            pencilcounter++;            
        }
         
    };
        
    //}while(h.equals("Yes"));
}



 
      
 
private void performAction(int choice){
        switch(choice){
            case 3:
                exit = true;
                System.out.println("Sta tsakidia!!!");
                break;
            case 2:
                enteremail();
                break;
            case 1:  
                loginin();
                break;
        }
    }
}