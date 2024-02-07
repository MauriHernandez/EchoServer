import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    //parámetros de tiempo de ejecución
    public static void main(String[] p) {
        //validación de puerto, para que no esté vacío
        if (p.length != 1) {
            System.out.println("Debes especificar un único valor entero que represente el número del puerto");
            System.exit(-1);
        }
        //recuperar el valor del puerto
        int puerto = Integer.parseInt(p[0]);

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            Socket cliente = servidor.accept();

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream())
            );

            PrintWriter salida = new PrintWriter(
                    cliente.getOutputStream(), true);

            String lectura;
            while (true){
                lectura  = entrada.readLine();
                System.out.println(lectura);
                salida.println(lectura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}