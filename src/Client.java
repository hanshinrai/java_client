import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class Client {

	public static void main(String args[])throws Exception{
		String host = "127.0.0.1";//�����ip
		int port = ;//�˿�
		Socket client = new Socket(host,port);//��������
		
		//������������Ϣ
		Writer writer = new OutputStreamWriter(client.getOutputStream());
		writer.write("hello");
		writer.flush();
		
		//����Ϣ
		Reader reader = new InputStreamReader(client.getInputStream());
		char chars[] = new char[64];
		int len;
		StringBuffer sb = new StringBuffer(); 
		while((len=reader.read(chars))!= -1){
			sb.append(new String(chars,0,len));
		}
		System.out.println("from server:" + sb);
		writer.close();
		reader.close();
		client.close();
	}
}
