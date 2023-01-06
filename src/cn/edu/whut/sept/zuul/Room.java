package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;
//����room������hashmapʵ�ַ���֮��Ļ�ͨ��ϵ��������»֮��������ڵķ���
public class Room
{
    private String description;
    private HashMap<String, Room> exits;
//����һ������ʵ�����������������
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }
//��setexit��������hashmap
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
}


