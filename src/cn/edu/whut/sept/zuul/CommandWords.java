package cn.edu.whut.sept.zuul;
/**�����ǡ�����Zuul��Ӧ�ó����һ���֡�
*��������硱��һ��ǳ��򵥵Ļ����ı���ð����Ϸ��
 * 
* ���������Ϸ��֪�����������ֵ�ö�١�
*������ʶ����������
/*����commandwords��ʶ��ָ���Ƿ���Ч*/

public class CommandWords
{   //������Ȼ�޷����̳�
    private static final String[] validCommands = {
            "go", "quit", "help"
    };

    public CommandWords()
    {
    	//ֻ���߸�����
    }
    
     //�ж�ָ���Ƿ���validcommand����ָ��У����򷵻�true
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
    
     //���û���ʾʾ����ָ��
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
