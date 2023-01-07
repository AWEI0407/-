package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

//����room������hashmapʵ�ַ���֮��Ļ�ͨ��ϵ��������»֮��������ڵķ���
public class Room
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> items;
    private HashMap<String, Monster> monsters;//����monster
//����һ������ʵ�����������������
    public Room(String description)
    {
    	  this.description = description;
          exits = new HashMap<String, Room>();
          items = new HashMap<String, Item>();
          monsters = new HashMap<String, Monster>();
    }
//��setexit��������hashmap
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
//�����Ʒ
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
//����hashmap�е�keys�ҵ�������ʾ
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
//hashmap��get�������õ����ڵ���ʾ
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
   while (iter.hasNext()) {//��Ʒλ���뷿����������û��ǿ���
	   
   code = (String)iter.next();
   item = (Item)items.get(code);
   returnString += code + '\t' + item.getInfo()  + '\n';
   }
   return returnString;}

public int getMonstersHealth() //��ȡ����Ľ���ֵ
{
    Monster m1=null;
    int health=0;
    Set<String> keyset= monsters.keySet();//
    Iterator<String> itr1=keyset.iterator();
    while(itr1.hasNext()){
    String key1=itr1.next();//ȷ������
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




