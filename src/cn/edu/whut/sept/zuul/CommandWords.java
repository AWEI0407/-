package cn.edu.whut.sept.zuul;

/*创建commandwords类识别指令是否有效*/

public class CommandWords
{   //该类显然无法被继承
    private static final String[] validCommands = {
            "go", "quit", "help"
    };

    public CommandWords()
    {
        // nothing to do at the moment...
    }
    
     //判断指令是否在validcommand可用指令集中，是则返回true
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
    
     //向用户提示示可用指令
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
