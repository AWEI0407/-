package cn.edu.whut.sept.zuul;

/*����commandwords��ʶ��ָ���Ƿ���Ч*/

public class CommandWords
{   //������Ȼ�޷����̳�
    private static final String[] validCommands = {
            "go", "quit", "help"
    };

    public CommandWords()
    {
        // nothing to do at the moment...
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
