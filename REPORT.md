#软件工程试验报告
1. 用UML图来表示样例工程软件结构
![image](https://github.com/wutcst/sept1-AWEI0407/commit/a8b88703b63f247b4860bf3e176f91fe08dff217#diff-8aba99e0f4fba8fb568de3dd633f6cb0ea1e439ee8b34d893159fa4c12e27f98)
![image](https://github.com/wutcst/sept1-AWEI0407/commit/a8b88703b63f247b4860bf3e176f91fe08dff217#diff-99842f548b7c68248962755ff461a84798af256dc9036bea84c6b2ab8352598f)
```mermaid大致结构
 classDiagram
      Game *--> Room
      Game *--> Parser
      Command <.. Parser:<<create>>
      Command <.. Game
      Parser *--> CommandWords
      CommandWords <.. Parser:<<create>>
	  Room <.. Game :<<create>>
      Parser <.. Game :<<create>>
      
      class Game{
          -Parser parser
          -Room currentRoom
          +Game()
          -createRooms()
          +play()
          -printWelcome()
          -processCommand()
          -printHelp()
          -goRoom()
          -quit()  
      }
      class Command{
          -String firstCommandWord
          -String secondCommandWord
          +Command()
		  +getCommandWord()
		  +getSecondWord()
		  +isUnknown()
		  +hasSecondWord()
      }
      class CommandWords{
          -String[] VALIDCOMMANDS
          +CommandWords()
		  +isCommand()
		  +showAll()
      }
      class Room{
          -String description
          -HashMap<String, Room> exits
          +Room()
		  +setExit()
		  +getShortDescription()
		  +getLongDescription()
		  -getExitString()
		  +getExit()
      }
	  class Parser{
          -CommandWords commands
          -Scanner reader
          +Parser()
		  +getCommand()
		  +showCommands()
      }
      
2. 文字说明

- 《World of Zuul》是一款简单的文本冒险游戏，用户可以在一些房间组成的迷宫中探险。用户如果想开始游戏，则需要创建Game类的一个实例并调用“play”方法。
- **Game**类的实例将创建并初始化所有其他类：
  - 它创建所有房间，并将它们连接成迷宫；
  - 它创建解析器，接收用户输入，并将用户输入转换成命令后开始运行游戏。
- **Room**对象代表游戏中的位置。房间可以由出口通到其他房间。
- **Parser**解析器读取用户输入并尝试将其解析为冒险命令：
  - 每次调用解析器时，它都从终端读取一行，尝试将其解析为一个两个单词的命令，并返回该命令作为Command类的对象。
  - 解析器有一组已知的命令词。它根据这些已知命令词检查用户输入，如果输入不是已知命令之一，则返回一个标记为未知命令的Command类的对象。  

 * **CommandWords**类通过存储一个命令词汇字符串数组来定义游戏中所有有效的命令。
 * **Command**对象代表用户输入的命令：
    * 它有一些方法可以判断其是否为有效的命令；
    * 还可以将命令中的第一个单词和第二个单词分离出来。
#二、代码规范与标注

### 1、Javadoc

##### （1）简介

​		在进行项目开发过程中，项目接口文档是很重要的一块内容，在java项目中我们可以用swagger，asciidoc，javadoc等方式来生产文档，而其中最基本的文档生成方式就是javadoc，它一般用在离线文档的生成上，我们需要按排它的规定来书写注释，从而最终生成文档。

##### （2）写在类上面的Javadoc

- 写在类上的文档标注一般分为三段：

  - 第一段：概要描述，用一句或者一段话简要描述该类的作用，以英文句号作为结束。
    - @link：{@link 包名.类名#方法名(参数类型)}	用于快速链接到相关代码；
    - @code：{@code text}	将文本标记为code。
  - 第二段：详细描述，用一段或者多段话来详细描述该类的作用，一般每段话都以英文句号作为结束。
    - @param：一般类中支持泛型时会通过@param来解释泛型的类型；

  - 第三段：文档标注，用于标注作者、创建时间、参阅类等信息。
    - @author：详细描述后面一般使用@author来标记作者，如果一个文件有多个作者来维护就标记多个@author；
    - @since：一般用于标记文件创建时项目当时对应的版本，一般后面跟版本号，也可以跟一个时间，表示文件当前创建的时间；
    - @version：用于标记当前版本，默认为1.0；
    - @see：一般用于标记该类参阅的其他类。

##### （3）写在方法上的Javadoc

- 写在方法上的文档标注一般分为三段：
  - 第一段：概要描述，用一句或者一段话简要描述该方法的作用，以英文句号作为结束；
  - 第二段：详细描述，用一段或者多段话来详细描述该方法的作用，一般每段话都以英文句号作为结束；
  - 第三段：文档标注，用于标注参数、返回值、异常、参阅等。
    - @param：后面跟参数名，再跟参数描述；
    - @return：跟返回值的描述；
    - @throws：跟异常类型，异常描述 , 用于描述方法内部可能抛出的异常；
    - @value：用于标注在常量上，{@value} 用于表示常量的值；
    - @inheritDoc：用于注解在重写方法或者子类上，用于继承父类中的Javadoc。
### 2、示例（以Command类为例）
```java
package cn.edu.whut.sept.zuul;

/**
 * Command对象代表用户输入的命令，它有一些方法可以判断其是否为有效的命令.
 * 还可以将命令中的第一个单词和第二个单词分离出来.
 */
@SuppressWarnings("checkstyle:JavadocStyle")
public class Command {

    /**
     * 创建存放命令的第一个单词的字符串.
     */
    private String firstCommandWord;
    /**
     * 创建存放命令的第二个单词的字符串.
     */
    private String secondCommandWord;

    /**
     * 对存放命令的第一个单词和第二个单词的字符串赋值.
     * @param firstWord 解析器解析出的命令的第一个单词
     * @param secondWord 解析器解析出的命令的第二个单词
     */
    public Command(final String firstWord, final String secondWord) {
        firstCommandWord = firstWord;
        secondCommandWord = secondWord;
    }

    /**
     * 读取用户输入的命令.
     * @return 返回命令的第一个单词
     */
    public String getCommandWord() {
        return firstCommandWord;
    }

    /**
     * 读取用户输入的命令.
     * @return 返回命令的第二个单词
     */
    public String getSecondWord() {
        return secondCommandWord;
    }

    /**
     * 判断输入命令是否可读.
     * @return 如果命令的第一个单词为空，则返回1；反之返回0
     */
    public boolean isUnknown() {
        return (firstCommandWord == null);
    }

    /**
     * 判断输入命令是否有第二个单词.
     * @return 如果命令的第二个单词不为空，则返回1；反之返回0
     */
    public boolean hasSecondWord() {
        return (secondCommandWord != null);
    }
}

     以上为根据game类的标注参考得来，详细程度相似
     
     
## 二、扩充和维护样例工程

### 1、待改进的功能点

> （1）在Game类的processCommand()方法中，当用户输入的命令被辨认出来以后，有一系列的if语句用来分派程序到不同的地方去执行。从面向对象的设计原则来看，这种解决方案不太好，因为每当要加入一个新的命令时，就得在这一堆if语句中再加入一个if分支，最终会导致这个方法的代码膨胀得极其臃肿。

```java
源代码：
    if (commandWord.equals("help")) {
        printHelp();
    } else if (commandWord.equals("go")) {
        goRoom(command);
    } else if (commandWord.equals("quit")) {
        wantToQuit = quit(command);
    }
```

- **解决思路**：通过switch-case优化解决if-else嵌套问题，并用CheckStyle规范化。

```java
修改后：
    switch (commandWord) {
        case "help" -> printHelp();
        case "go" -> goRoom(command);
        case "quit" -> {
            wantToQuit = quit(command);
        }
        default -> { }
    }
```

> （2）在Game类中有一个私有方法叫作printWelcome()，用来输出欢迎文字，当play方法开始游戏的时候就会调用这个方法。从功能的角度看，完全可以把printWelcome()方法中的语句直接放在play方法中，不需要另外定义方法，也不需要做方法调用，也能到得到相同的运行效果。顺便说，同样的事情也可以对processCommand()方法来做，它也是在play方法中调用的，它的代码也可以直接插入到play方法中去。

```java
源代码：
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.print("World of Zuul is a new, ");
        System.out.println("incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
```

- **解决思路**：把printWelcome()方法中的语句直接放在play方法中，不需要另外定义方法。该方法不会被其他地方调用，所以有必要减少代码量

```java
修改后：
    public void play() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.print("World of Zuul is a new, ");
        System.out.println("incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
> （3）
```
### 2、扩充的功能点

####当在一个房间里输入了一系列的命令后，先前输出的房间的描述信息和出口信息早已不在当前屏幕上了，而我们又记不住当前房间的出口在哪里。在这样的情况下，我们可以把命令字look（看）加入到有效命令的集合中去。

```java
扩充后：
Game类：
	private void look() {
		System.out.println(currentRoom.getLongDescription());
	}

	private void printWelcome() {
        switch (commandWord) {
            case "help" -> printHelp();
            case "go" -> goRoom(command);
            case "quit" -> {
                wantToQuit = quit(command);
            }
            case "look" -> look();
            default -> { }
        }
    }
CommandWords类：
    private static final String VALIDCOMMANDS [] = {
    	"go","quit","help","look"
	};
	
	
####增加玩家和怪物功能，玩家可以操控角色和怪物战斗，怪物生成可以是自主的，战斗时玩家和怪物呼唤血量
  
  public Character(int health, String info)
    {  
       super(health);
       this.info = info;    
       items = new HashMap<String, Item>();
    }
    
private void createCharacters() {
    	superman = new Character(100,"The legendary Superman");
        rambo = new Character(50,"The Rambo"); 
	}


    
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

private void createMonsters()
    {// 制造怪物
    Monster imp,im;
    imp = new Monster(10);
    hiddencave.addMonster("m1", imp);
    moutain.addMonster("2", imp);
    field.addMonster("3", imp);
    }
     //在房间里添加怪物
 public void addMonster(String name, Monster monster)
    {
        monsters.put(name, monster);
        
 private void fight()//战斗逻辑方法
    { 
       int a = currentPlayer.getHealth();
       int b = currentRoom.getMonstersHealth();//获取怪物生命值
       if (b==0){
           System.out.println("Current Health:" + currentPlayer.getHealth());}
           else {if (currentPlayer.itemSize() > 0){
               useItem();
            }
            else {if(a > b){ //如果玩家的生命值超过房间中的怪物
           
           //修改玩家生命值。
           
           currentPlayer.health= a-b;
           System.out.println("Current Health:" + currentPlayer.getHealth());
          
           currentRoom.clear();
           
        }else {// 玩家血量过低就会死亡
          currentPlayer.health = 0;
          System.out.println("You were eaten by the monster");} }  }
    }
     private void printPlayerDetails(){// 打印玩家的当前健康状况
        System.out.println(currentPlayer.getInfo());
    }
    private void printPocketItemInfo()
    {  // 打印出口袋里中当前存在的物品
       System.out.println("Current items in your pocket: ");
       System.out.println();
       System.out.println(currentPlayer.listItems());
    }
    
####新增物品功能，房间内会出现物品，玩家可以拾取物品，物品有重量

public class Item implements Unamed
{    
    private String info;//物品描述
    private int weight;//物品重量
    /**
     * 物品类的构造
     */
    public Item(String info,int weight)
    {
     this.info = info;
     this.weight = weight;
    }
    public String getInfo()//获取物品的描述
    {
     return info;
    }
   
    //添加物品
    public void addItem(String code, Item item)
    {  
        items.put(code, item);
    }
    	private void createItems()
    {   //向房间里添加物品
        Item grenade;
        grenade = new Item("A grenade which can kill enemy with 1 hit", 20);//并没有作用只是属于物品描述
        hiddencave.addItem("1", grenade);
        rambo.addItem("1",grenade);//引用additem方法
        rambo.addItem("2",grenade);
        
 private void printRoomInfo()
    {  // 打印出房间中当前物品
       System.out.println("Current items in the room: ");
       System.out.println();
       System.out.println(currentRoom.listItems());
    }
}
