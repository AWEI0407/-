package cn.edu.whut.sept.zuul;
public class Item implements Unamed
{    
    private String info;
    private int weight;
    /**
     * ��Ʒ��Ĺ���
     */
    public Item(String info,int weight)
    {
     this.info = info;
     this.weight = weight;
    }
    public String getInfo()
    {
     return info;
    }

}
