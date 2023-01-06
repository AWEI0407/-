package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;
//创建room类利用hashmap实现房间之间的互通关系，在玩家新活动之后给出出口的方向
public class Room
{
    private String description;
    private HashMap<String, Room> exits;
//创建一个房间实例，包含房间的名字
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }
//用setexit方法链接hashmap
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
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
}


