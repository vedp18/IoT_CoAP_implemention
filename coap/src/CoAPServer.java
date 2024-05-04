import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.server.resources.CoapExchange;


import java.util.Date;
import java.util.Scanner;

public class CoAPServer {

    private static CoapServer server;

    public static void main(String[] args) {

        // Set the CoAP port
        System.setProperty("org.eclipse.californium.coap.port", "5683");

        // Set the network interface
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("coap.networkInterfaces", "127.0.0.1");

        server = new CoapServer(); // CoAP default port is 5683

        // Resource for handling time
        server.add(new CoapResource("time") {
            @Override
            public void handleGET(CoapExchange exchange) {

                byte[] clientAddress = exchange.getSourceAddress().getAddress();
                String clientIP = ((int)(clientAddress[0] & 0xFF)) + "." +
                                 ((int)(clientAddress[1] & 0xFF)) + "." +
                                 ((int)(clientAddress[2] & 0xFF)) + "." +
                                 ((int)(clientAddress[3] & 0xFF));
                                 
                System.out.println("Received GET request on resource time from client: " + clientIP);
                                
                exchange.respond("Current Time: " + new Date());

                System.out.println("Response Sent to client: " + clientIP + " ,*time*");
            }
        });

        // Resource for handling team data
        server.add(new CoapResource("team") {
            @Override
            public void handleGET(CoapExchange exchange) {
                String teamData = "Team members:\n" +
                        "Ved\n" +
                        "Priyank\n" +
                        "Yashvi\n" +
                        "Nehal\n" +
                        "Shivani\n" +
                        "Madhav";
                        
                // Accessing client's IP address and port
                byte[] clientAddress = exchange.getSourceAddress().getAddress();
                String clientIP = ((int)(clientAddress[0] & 0xFF)) + "." +
                                 ((int)(clientAddress[1] & 0xFF)) + "." +
                                 ((int)(clientAddress[2] & 0xFF)) + "." +
                                 ((int)(clientAddress[3] & 0xFF));
                
                System.out.println("Received GET request on resource team from client: " + clientIP);

                exchange.respond(teamData);

                System.out.println("Response Sent to client: " + clientIP + " ,*team");
            }
        });

        server.start();
        System.out.println("CoAP server started");

        // Listen for input from the terminal
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'exit' to stop the server");
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input) || "stop".equalsIgnoreCase(input)) {
                stopServer();
                break;
            }
        }
        scanner.close();
    }

    private static void stopServer() {
        if (server != null) {
            server.stop();
            System.out.println("CoAP server stopped");
        }
    }
}
