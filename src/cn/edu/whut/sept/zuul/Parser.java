package cn.edu.whut.sept.zuul;

/**
*��������硱��һ��ǳ��򵥵Ļ����ı���ð����Ϸ��
 * 
* �˽�������ȡ�û����벢���Խ������Ϊ��ð�ա�
*���ÿ�ε�����ʱ����������ն˶�ȡһ�У�Ȼ��
* ���Խ����н���Ϊ�������ʵ��������������
* ��Ϊ������Ķ���
 *
* ��������һ����֪�������֡�������û�����
* ��֪���������벻����֪����֮һ����
* ���ر��Ϊδ֪������������
**/
import java.util.Scanner;
/*����parser�Ի�ȡ��������ؼ��ʽ��н���*/
public class Parser
{
    private CommandWords commands;
    private Scanner reader;

    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
      //������ʼ��
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");
     //���ػس���֮ǰ��������Ϣ
        inputLine = reader.nextLine();
   //���ɨ�赽������Ϣ���ֱ𱣴������ִʺ����Ϣ
        @SuppressWarnings("resource")
		Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();   
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
//��ʶ�𵽵�ָ������з����Ƿ���Ч��
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
