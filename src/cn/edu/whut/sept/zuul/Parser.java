package cn.edu.whut.sept.zuul;

/**
*“祖尔世界”是一款非常简单的基于文本的冒险游戏。
 * 
* 此解析器读取用户输入并尝试将其解释为“冒险”
*命令。每次调用它时，它都会从终端读取一行，然后
* 尝试将该行解释为两个单词的命令。它返回命令
* 作为类命令的对象。
 *
* 解析器有一组已知的命令字。它检查用户输入
* 已知命令，如果输入不是已知命令之一，则
* 返回标记为未知命令的命令对象。
**/
import java.util.Scanner;
/*创建parser对获取到的命令关键词进行解析*/
public class Parser
{
    private CommandWords commands;
    private Scanner reader;

    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
      //变量初始化
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");
     //返回回车键之前的所有信息
        inputLine = reader.nextLine();
   //如果扫描到键入信息，分别保存两个分词后的信息
        @SuppressWarnings("resource")
		Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();   
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
//对识别到的指令动作进行分析是否有效，
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2);
        }
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
