import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class Client {

	public static void main(String args[])throws Exception{
		String host = "127.0.0.1";//服务端ip
		int port = ;//端口
		Socket client = new Socket(host,port);//建立连接
		
		//往服务器发消息
		Writer writer = new OutputStreamWriter(client.getOutputStream());
		writer.write("hello");
		writer.flush();
		
		//收消息
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
