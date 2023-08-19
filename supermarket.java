

package com.mycompany.supermarket;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/////////////////////////////////////////////////////////////////////////////////////MAIN//////////////////////////////////////////////////////////////////////////

public class Supermarket {

    public static item items[]=new item[1000];
    public static int size=0;
    
    public static void main(String[] args) {
       
        
        mainmenu();
    }
   public static void mainmenu()
    {
        while  (true)
        {
String menu="Super market menu \n"+
"1. Add a new item to store \n"+
"2. Add a new customer to store \n"+
"3. Add an item to customer shopping cart \n"+
"4. Remove an item from customer shopping cart \n"+
"5. View the items in customer shopping cart \n"+
"6. End shopping an go to checkout \n"+
"7. Empty customer shopping cart\n"+
"8. Exit the program";

 String num =JOptionPane.showInputDialog(null,menu);

 int ch=Integer.parseInt(num);
 switch(ch){
case 1: 
ADDitem();
break;
case 2: 
break;
case 3: 
break;
case 4: 
break;
case 5: 
break;
case 6: 
break;
case 7: 
break;
case 8: 
System.exit(0);

break;
 }

    }
    }
private static void ADDitem() {
   
String nu=" ";
   do{
    JTextField id =new JTextField();
     JTextField name =new JTextField();
      JTextField price =new JTextField();
       JTextField quantity =new JTextField();
           JTextField type =new JTextField();
     JTextField prodate =new JTextField();
     JTextField expdate =new JTextField();
      JTextField weight =new JTextField();
     
   
   Object [] Message={"Enter item number ",id,"Enter item name ",name,"Enter item quantity ",quantity," Enter the type of item",type,"Enter item price",price};
    Object [] dairy={"Enter the production date ",prodate,"Enter the expire date ",expdate};
     Object [] meat={"Enter the production date ",prodate,"Enter the expire date ",expdate,"Enter the weight",weight};
      Object [] drinks={"Enter the production date ",prodate,"Enter the expire date ",expdate};
       Object [] fruits={"Enter the production date ",prodate,"Enter the expire date ",expdate,"Enter the weight",weight};
  int yesorno= JOptionPane.showConfirmDialog(null, Message);
  int result1=1;
    if (type.getText().toUpperCase().equals("D")) {
     result1=   JOptionPane.showConfirmDialog(null, dairy);
    }
    else if (type.getText().toUpperCase().equals("M")) {
        result1 =JOptionPane.showConfirmDialog(null, meat);
    }
    else if (type.getText().toUpperCase().equals("Dr")) {
      result1=  JOptionPane.showConfirmDialog(null, drinks);
    }
    else if (type.getText().toUpperCase().equals("F")) {
       result1=  JOptionPane.showConfirmDialog(null, fruits);
    }
    if (yesorno==JOptionPane.YES_OPTION && result1==JOptionPane.YES_OPTION) {
        int ID=Integer.parseInt(id.getText());
        String Name=name.getText();
        int Quantity = Integer.parseInt(quantity.getText());
        int Price = Integer.parseInt(price.getText());
        String Type=type.getText();
        int Weight=Integer.parseInt(weight.getText());
                int Prodate=Integer.parseInt(prodate.getText());
                  int Expdate=Integer.parseInt(expdate.getText());
                
        int indexname=Searchname(Name);
        int index=Searchid(ID);
        if (indexname!=-1) {
             JOptionPane.showMessageDialog(null,"This item already exists and the new quantity will be added to the old quantity");
             items[indexname].Addquan(Quantity);
             return;
        }
        if (index==-1) {

            items[size]=new item( ID,  Quantity,  Price,  Weight,  Prodate,  Expdate,  Name,Type);
        size++;
        JOptionPane.showMessageDialog(null,"the item has been added");
    }
        else {
            JOptionPane.showMessageDialog(null,"This number is already registered");
            
        }
        String re= JOptionPane.showInputDialog(null,"Do you want to add another item(y/n)?");
                nu=re.toUpperCase();
    } 
   
   } while(nu.equals("Y"));
           
   }
   

    private static int Searchid(int ID) {
        for (int i = 0; i < size; i++) {
            if (ID==items[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    private static int Searchname(String Name) {
        for (int i = 0; i < size; i++) {
            if (Name.equals(items[i].getName())) {
                return i;
            }
        }
        return -1;
    }
        
    }
//////////////////////////////////////////////////////////////////////////////// ITEM CLASS///////////////////////////////////////////////////////////////////////////////////////////////////////////////


package com.mycompany.supermarket;

import javax.swing.JTextField;


public class item {
    
    int id,quantity,price ,weight,prodate,expdate;
    String name,type;

    public item(int id, int quantity, int price, int weight, int prodate, int expdate, String name,String type) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        this.prodate = prodate;
        this.expdate = expdate;
        this.name = name;
        this.type=type;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public int getProdate() {
        return prodate;
    }

    public int getExpdate() {
        return expdate;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setProdate(int prodate) {
        this.prodate = prodate;
    }

    public void setExpdate(int expdate) {
        this.expdate = expdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
public void Addquan(int quan)
{
 this.quantity+=quan;
    
}
}
