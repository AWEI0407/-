package cn.edu.whut.sept.zuul;

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
