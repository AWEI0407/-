/**
 * 璇ョ被鏄�淲orld-of-Zuul鈥濆簲鐢ㄧ▼搴忕殑涓荤被銆�
 * 銆奧orld of Zuul銆嬫槸涓�娆剧畝鍗曠殑鏂囨湰鍐掗櫓娓告垙銆傜敤鎴峰彲浠ュ湪涓�浜涙埧闂寸粍鎴愮殑杩峰涓帰闄┿��
 * 浣犱滑鍙互閫氳繃鎵╁睍璇ユ父鎴忕殑鍔熻兘浣垮畠鏇存湁瓒�!.
 *
 * 濡傛灉鎯冲紑濮嬫墽琛岃繖涓父鎴忥紝鐢ㄦ埛闇�瑕佸垱寤篏ame绫荤殑涓�涓疄渚嬪苟璋冪敤鈥減lay鈥濇柟娉曘��
 *
 * Game绫荤殑瀹炰緥灏嗗垱寤哄苟鍒濆鍖栨墍鏈夊叾浠栫被:瀹冨垱寤烘墍鏈夋埧闂达紝骞跺皢瀹冧滑杩炴帴鎴愯糠瀹紱瀹冨垱寤鸿В鏋愬櫒
 * 鎺ユ敹鐢ㄦ埛杈撳叆锛屽苟灏嗙敤鎴疯緭鍏ヨ浆鎹㈡垚鍛戒护鍚庡紑濮嬭繍琛屾父鎴忋��
 *
 * @author  Michael K枚lling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;
import java.util.Iterator;
import java.util.*;
public class Game
{
    private static final String Scanner = null;
	private Parser parser;
    private Room currentRoom;
    Character currentPlayer;
    Character superman, rambo;
    Room town, moutain, hiddencave, field, swamp, cave, highland, castle, ruin, forest, victorychamber; 
     /**
    /**
     * 鍒涘缓娓告垙骞跺垵濮嬪寲鍐呴儴鏁版嵁鍜岃В鏋愬櫒.
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
        createRooms();
        createCharacters();
        createRooms();
    }
    @SuppressWarnings("unused")
	private void createMonsters()
    {// 制造怪物
    Monster imp,im;
    imp = new Monster(10);
    hiddencave.addMonster("m1", imp);
    moutain.addMonster("2", imp);
    field.addMonster("3", imp);
    }
    
    @SuppressWarnings("unused")
	private void createItems()
    {   //向房间里添加物品
        Item grenade;
        grenade = new Item("A grenade which can kill enemy with 1 hit", 20);
        hiddencave.addItem("1", grenade);
        rambo.addItem("1",grenade);
        rambo.addItem("2",grenade);
        
    }
    private void createCharacters() {
    	superman = new Character(100,"The legendary Superman");
        rambo = new Character(50,"The Rambo"); 
	}

	/**
     * 鍒涘缓鎵�鏈夋埧闂村璞″苟杩炴帴鍏跺嚭鍙ｇ敤浠ユ瀯寤鸿糠瀹�.
     */
    private void createRooms()
    {
    	 town = new Room("in a deserted town");
         moutain = new Room("in a high, cold moutain");
         hiddencave = new Room("in a hiddencave, no body ever been here before");
         field = new Room("in a wide field, better becareful");
         swamp = new Room("in a swamp");
         cave = new Room("in a cave");
         highland = new Room("in a highland");
         castle = new Room("in the castle");
         ruin = new Room("in a ruin");
         forest = new Room("in a forest");
         victorychamber = new Room("in the Victory Chamber");
         // initialise room exits
         town.setExit("north", field);
         town.setExit("west", swamp);
         town.setExit("east", moutain);
         town.setExit("south", cave);
         
         moutain.setExit("north", hiddencave);
         moutain.setExit("west", town);
         
         hiddencave.setExit("south", moutain);
         
         field.setExit("south", town);
         
         swamp.setExit("east", town);
         
         cave.setExit("north", town);
         cave.setExit("south", highland);
         
         highland.setExit("north", cave);
         highland.setExit("south", castle);
         highland.setExit("east", ruin);
         highland.setExit("west", forest);
         
         ruin.setExit("east", highland);
         
         forest.setExit("west", highland);
         
         castle.setExit("north", highland);
         
         castle.setExit("up", victorychamber);
         currentRoom = town;   // 在初始房间开始游戏
    }

    /**
     *  娓告垙涓绘帶寰幆锛岀洿鍒扮敤鎴疯緭鍏ラ��鍑哄懡浠ゅ悗缁撴潫鏁翠釜绋嬪簭.
     */
    public void play()
    {     Scanner get=new Scanner(System.in);
          String strcharacterName = get.nextLine();
    	  if(strcharacterName.equalsIgnoreCase("superman")){
              currentPlayer=superman;
          }else if(strcharacterName.equalsIgnoreCase("rambo")){
              currentPlayer=rambo;
          }else{
              System.out.println("Please choose between superman or rambo or you will not be able to play the game.");
              return;
          }
          printWelcome();
          // 进入主命令循环。 在这里，我们反复读取命令
          //执行它们，直到游戏结束。
                  
          boolean finished = false;
          while (! finished){ if (currentPlayer.health != 0){ 
             if (currentRoom != victorychamber){
              Command command = parser.getCommand();
              finished = processCommand(command);}
              else {System.out.println("Congratulation. You are the winner !");
              finished = true;}
              }
              else finished = true;   
              } 
                   
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 鍚戠敤鎴疯緭鍑烘杩庝俊鎭�.
     */
    private void printWelcome()
    {
    	System.out.println();
        System.out.println("WELCOME!");
        System.out.println("If you can get to the castle, you're the winner. Be careful, there are monsters in the way, your health will decreased if you meet those!!  ");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        System.out.println();
        System.out.println("You are playing as");
        printPlayerDetails();
        printPocketItemInfo();
        }
    

    /**
     * 鎵ц鐢ㄦ埛杈撳叆鐨勬父鎴忔寚浠�.
     * @param command 寰呭鐞嗙殑娓告垙鎸囦护锛岀敱瑙ｆ瀽鍣ㄤ粠鐢ㄦ埛杈撳叆鍐呭鐢熸垚.
     * @return 濡傛灉鎵ц鐨勬槸娓告垙缁撴潫鎸囦护锛屽垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
            
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("reveal")){
            printRoomInfo();
        }
        else if (commandWord.equals("status")){
            printPocketItemInfo();
            printPlayerDetails();
        }
       
        return wantToQuit;
    }

	/**
     * 鎵цhelp鎸囦护锛屽湪缁堢鎵撳嵃娓告垙甯姪淇℃伅.
     * 姝ゅ浼氳緭鍑烘父鎴忎腑鐢ㄦ埛鍙互杈撳叆鐨勫懡浠ゅ垪琛�
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * 鎵цgo鎸囦护锛屽悜鎴块棿鐨勬寚瀹氭柟鍚戝嚭鍙ｇЩ鍔紝濡傛灉璇ュ嚭鍙ｈ繛鎺ヤ簡鍙︿竴涓埧闂达紝鍒欎細杩涘叆璇ユ埧闂达紝
     * 鍚﹀垯鎵撳嵃杈撳嚭閿欒鎻愮ず淇℃伅.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // 如果第二个词为空，我们将不知道去哪里
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // 尝试离开初始房间
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no way there!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
        fight();
        
        
    }
  
    private void printRoomInfo()
    {  // 打印出房间中当前物品
       System.out.println("Current items in the room: ");
       System.out.println();
       System.out.println(currentRoom.listItems());
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
    
    private void fight()
    { 
       int a = currentPlayer.getHealth();
       int b = currentRoom.getMonstersHealth();
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
    
    private void useItem(){
        currentPlayer.removeLastItem();
        currentRoom.clear();
        System.out.println("Current Health:" + currentPlayer.getHealth());
        }
        

    /**
    /**
     * 鎵цQuit鎸囦护锛岀敤鎴烽��鍑烘父鎴忋�傚鏋滅敤鎴峰湪鍛戒护涓緭鍏ヤ簡鍏朵粬鍙傛暟锛屽垯杩涗竴姝ヨ闂敤鎴锋槸鍚︾湡鐨勯��鍑�.
     * @return 濡傛灉娓告垙闇�瑕侀��鍑哄垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // 表示我们要退出了
        }
    }
}