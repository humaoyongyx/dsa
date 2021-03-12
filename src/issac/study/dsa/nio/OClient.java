package issac.study.dsa.nio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author issac.hu
 */
public class OClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(8090));
        System.out.println("connect success...");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String serverMsg = bufferedReader.readLine();
        System.out.println(serverMsg);
        System.out.println("please input:");
        //inputStream.read是阻塞的
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext() ) {
            String read = scanner.next();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(read);
            printWriter.flush();
        }

    }
}
