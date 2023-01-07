package cn.edu.whut.sept.zuul;
//创建怪物类,以便在游戏开始时构造实例
public class Monster extends Family
{
    public Monster(int health)
    {
     super(health);
    }
   public int getHealth()
    {
     return health;
    }
}