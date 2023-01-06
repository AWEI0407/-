package cn.edu.whut.sept.zuul;//将文件保存到zuul指定路径文件中

public class Command
/*定义命令类，获取命令关键词
得到命令的基本特征是否为空
*/
{
    private String commandWord;//两个字符串局部变量
    private String secondWord;
//command方法从外界获取命令
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }
//获取第一个命令词，即动作词集validcommand
    public String getCommandWord()
    {
        return commandWord;
    }
//获取方向词，或为空
    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
