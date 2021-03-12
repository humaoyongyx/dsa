package issac.study.dsa.nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author issac.hu
 */
public class OServer {

    static class ClientHandler extends Thread {
        private Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = client.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                // 实际的阻塞是 inputStream.read();
                String msg = bufferedReader.readLine();
                System.out.println("client read ");
                while (msg != null) {
                    System.out.println(msg);
                    //这里会被阻塞，如果没有数据
                    msg = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8090);
        System.out.println("server start " + serverSocket.getLocalPort());
        while (true) {
            //阻塞，直到有连接
            Socket client = serverSocket.accept();
            System.out.println("client accept " + client.getPort());
            OutputStream outputStream = client.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("hello：" + client.getPort() + ",welcome!\n");
            printWriter.flush();
            new ClientHandler(client).start();
        }

    }
}
