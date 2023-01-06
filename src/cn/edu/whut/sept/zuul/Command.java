package cn.edu.whut.sept.zuul;//���ļ����浽zuulָ��·���ļ���

public class Command
/*���������࣬��ȡ����ؼ���
�õ�����Ļ��������Ƿ�Ϊ��
*/
{
    private String commandWord;//�����ַ����ֲ�����
    private String secondWord;
//command����������ȡ����
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }
//��ȡ��һ������ʣ��������ʼ�validcommand
    public String getCommandWord()
    {
        return commandWord;
    }
//��ȡ����ʣ���Ϊ��
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
