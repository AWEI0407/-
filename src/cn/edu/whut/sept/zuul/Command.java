package cn.edu.whut.sept.zuul;//将文件保存到zuul指定路径文件中
/**此类是“世界Zuul”应用程序的一部分。
*“祖尔世界”是一款非常简单的基于文本的冒险游戏。
 *
* 此类包含有关用户发出的命令的信息。
* 命令当前由两个字符串组成：一个命令字和一个第二个
* word（例如，如果命令是“take map”，则两个字符串
*显然是“采取”和“地图”）。
 * 
* 使用方式是：已检查命令是否有效
* 命令词。如果用户输入了无效的命令（一个不是
* 已知），则命令字为 <null>。
 *
* 如果命令只有一个单词，则第二个单词为 <null>。
**/
public class Command
{
    private String commandWord;//两个字符串局部变量
    private String secondWord;
//command方法从外界获取命令
/**
* 创建一个命令对象。必须提供第一个和第二个单词，但是
* 其中一个（或两个）都可以为空。
*/
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }
//获取第一个命令词，即动作词集validcommand
//返回此命令的命令字（第一个字）。如果* 命令未被理解，结果为空。
    public String getCommandWord()
    {
        return commandWord;
    }
//获取方向词，或为空
    public String getSecondWord()
    {
        return secondWord;
    }
//如果不理解此命令，则return为真。
    public boolean isUnknown()
    {
        return (commandWord == null);
    }
//如果命令有第二个单词，则return true。
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
