package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

//创建room类利用hashmap实现房间之间的互通关系，在玩家新活动之后给出出口的方向
public class Room
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> items;
    private HashMap<String, Monster> monsters;//创建monster
//创建一个房间实例，包含房间的名字
    public Room(String description)
    {
    	  this.description = description;
          exits = new HashMap<String, Room>();
          items = new HashMap<String, Item>();
          monsters = new HashMap<String, Monster>();
    }
//用setexit方法链接hashmap
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
//添加物品
    public void addItem(String code, Item item)
    {  
        items.put(code, item);
    }
    
    public void addMonster(String name, Monster monster)
    {
        monsters.put(name, monster);
    }
    public void clear()
    {
    monsters.clear();
    items.clear();
    }
    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
//依据hashmap中的keys找到出口提示
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
//hashmap的get方法，得到出口的提示
    public Room getExit(String direction)
    {
        return exits.get(direction);
        }
    

public String listItems() 
{
   String returnString = new
   String("Code\tDescription\n");
   Iterator<String> iter = items.keySet().iterator();
   Item item = null;
   String code = null;
   while (iter.hasNext()) {//物品位置与房间是两个表，没有强相关
	   
   code = (String)iter.next();
   item = (Item)items.get(code);
   returnString += code + '\t' + item.getInfo()  + '\n';
   }
   return returnString;}

public int getMonstersHealth() //获取怪物的健康值
{
    Monster m1=null;
    int health=0;
    Set<String> keyset= monsters.keySet();//
    Iterator<String> itr1=keyset.iterator();
    while(itr1.hasNext()){
    String key1=itr1.next();//确定怪物
    m1=monsters.get(key1);
    }
    if(m1!=null){
    health=m1.getHealth();
    }
    return health;
}
public int monstersSize(){
      return monsters.size();
}


}




