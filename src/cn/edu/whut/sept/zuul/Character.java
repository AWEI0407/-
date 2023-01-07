package cn.edu.whut.sept.zuul;
import java.util.HashMap;
import java.util.Iterator;
//每一个可选角色可以拥有物品，查看房间内的物品
public class Character extends Family implements Unamed
{    
    private String info;   
    private HashMap<String, Item> items;
      
    public Character(int health, String info)
    {  
       super(health);
       this.info = info;    
       items = new HashMap<String, Item>();
    }
    
     public void addItem(String code, Item item)
    {  
       items.put(code, item);
    }
    public void removeItem(String code) {    
       items.remove(code);    
    }
   
    public String getInfo()
    {
       return info + " You have " + health + " health.";
    }
    
    public int getHealth()
    {
       return health;
    }
    
    public String listItems() 
    {
       String returnString = new
       String("Code\tDescription\n");
       Iterator<String> iter = items.keySet().iterator();
       Item item = null;
       String code = null;
       while (iter.hasNext()) {
       code = (String)iter.next();
	   item = (Item)items.get(code);
       returnString += code + '\t' + item.getInfo()  + '\n';
    }
       return returnString;
}
     public void removeLastItem(){
       @SuppressWarnings("unused")
	String returnString = new
       String("Code\tDescription\n");
       Iterator<String> iter = items.keySet().iterator();
       @SuppressWarnings("unused")
	Item item = null;
       String code = null;
       while (iter.hasNext()) {
       code = (String)iter.next();
	   //item = (Item)items.get(code);
       //returnString += code + '\t' + item.getInfo()  + '\n';        
        } 
        if(code!=null){
        items.remove(code);
        }
        else;
        
    }
    public int itemSize(){
    return items.size();
}
        
}    

