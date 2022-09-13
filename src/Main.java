import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            /** Classe que representa um Endereço ip. */
            InetAddress host = null;
            /** Porta onde o programa está rodando. */
            int port = 5000;
            try {
                /** Metodo que determina o endereço ip do host a partir de seu nome.  */
                host = InetAddress.getByName("moodle.inf.poa.ifrs.edu.br");
            } catch (UnknownHostException e) {
                /** Caso o host não exista é disparada a UnknownHostException. */
                System.out.println("Host não existe");
            }
            /** Instanciação do objeto client a partir da classe Client. */
            Client client = new Client();
            try {
                assert host != null;
                /** Client tenta conectar ao servidor a partir do endereço trazido pelo objeto host. */
                client.startConnection(host.getHostAddress(), port);
            } catch (IOException e) {
                /** Caso haja erro de conexão, IOException é disparada. */
                System.out.println("Erro na Conexão");
            } finally {
                /** Caso a conexão ocorra é mostrada a mensagem de sucesso. */
                assert host != null;
                System.out.println("Conexão estabelecida, IP= " + host.getHostAddress() + ":" + port);
            }

            /** String que armazenará a linha de texto que o usuário digitar no terminal. */
            String text = scanner.next();
            /** String que armazenará a resposta do servidor.  */
            String response = null;

            try {
                /** Objeto client manda a mensagem para o servidor.*/
                response = client.sendMessage(text);
            } catch (IOException e) {
                /** Caso ocorra um erro, IOException é disparada. */
                System.out.println("Erro desconhecido");
            } finally {
                /** Em caso de sucesso, o texto retornado do servidor é mostrado. */
                System.out.println(response);
            }
        }
    }

}