import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Socket Client class
 */
public class Client {

    /** Classe que implementa o Socket do Client. */
    private Socket clientSocket;

    /** Classe responsável por enviar texto para o Servidor. */
    private PrintWriter out;

    /** Classe responsável por receber a resposta do Servidor. */
    private BufferedReader in;

    /**
     * Inicia a conexão com o servidor.
     *
     * @param ip : Endereço ip do server
     * @param port : Número da porta
     * @throws IOException
     */
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Envia uma mensagem de texto para o Servidor.
     *
     * @param msg : Mensagem de texto
     *
     * @return Retorna a resposta do servidor;
     * @throws IOException
     */
    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    /**
     * Interrompe a conexão com o servidor.
     *
     * @throws IOException
     */
    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}