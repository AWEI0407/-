package cn.edu.whut.sept.zuul;//���ļ����浽zuulָ��·���ļ���
/**�����ǡ�����Zuul��Ӧ�ó����һ���֡�
*��������硱��һ��ǳ��򵥵Ļ����ı���ð����Ϸ��
 *
* ��������й��û��������������Ϣ��
* ���ǰ�������ַ�����ɣ�һ�������ֺ�һ���ڶ���
* word�����磬��������ǡ�take map�����������ַ���
*��Ȼ�ǡ���ȡ���͡���ͼ������
 * 
* ʹ�÷�ʽ�ǣ��Ѽ�������Ƿ���Ч
* ����ʡ�����û���������Ч�����һ������
* ��֪������������Ϊ <null>��
 *
* �������ֻ��һ�����ʣ���ڶ�������Ϊ <null>��
**/
public class Command
{
    private String commandWord;//�����ַ����ֲ�����
    private String secondWord;
//command����������ȡ����
/**
* ����һ��������󡣱����ṩ��һ���͵ڶ������ʣ�����
* ����һ������������������Ϊ�ա�
*/
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }
//��ȡ��һ������ʣ��������ʼ�validcommand
//���ش�����������֣���һ���֣������* ����δ����⣬���Ϊ�ա�
    public String getCommandWord()
    {
        return commandWord;
    }
//��ȡ����ʣ���Ϊ��
    public String getSecondWord()
    {
        return secondWord;
    }
//��������������returnΪ�档
    public boolean isUnknown()
    {
        return (commandWord == null);
    }
//��������еڶ������ʣ���return true��
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
