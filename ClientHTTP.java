import java.io.*;
import java.net.*;

public class ClientHTTP {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2016);

            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader isv = new InputStreamReader(socket.getInputStream());

            BufferedWriter bufOut = new BufferedWriter(osw);
            BufferedReader bufIn = new BufferedReader(isv);

            String request = "GET / HTTP/1.0\r\n\r\n";
            bufOut.write(request, 0, request.length());
            bufOut.flush();

            String line = bufIn.readLine(); // Use readLine instead of readLines
            while (line != null) {
                System.out.println(line);
                line = bufIn.readLine();
            }

            bufIn.close();
            bufOut.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
