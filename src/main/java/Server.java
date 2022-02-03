import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private final int SERVER_PORT = 6667;
    private ServerSocket serverSocket;
    private final ArrayList<Socket> sockets = new ArrayList<>();
    private final ArrayList<ObjectInputStream> inputStreams = new ArrayList<>();
    private final ArrayList<ObjectOutputStream> outputStreams = new ArrayList<>();
    Game game;

    private void initialize() {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            game = new Game();
            System.out.println("Server initialized. Waiting for players...");
            while(game.players_connected < game.TOTAL_PLAYERS - 2) {
                <1> // missing 8 statements 
                game.players_connected++;
                System.out.println("Player " + game.players_connected + " has joined!");
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    private void startGame() {
        System.out.println("\nStarting game...\n");
        try {
            for(int i = 0; i < sockets.size(); i++) {
                while (game.current_player == i) {
                    outputStreams.get(i).writeObject(game);
                    outputStreams.get(i).flush();
                    outputStreams.get(i).reset();
                    System.out.println(game);

                    String command = (String) inputStreams.get(i).readObject();
                    System.out.println("Player command: "+ command);

                    if(command.toLowerCase().startsWith("h")) game.hit();
                    else game.stay();

                    outputStreams.get(i).writeObject(game);
                    outputStreams.get(i).flush();
                    outputStreams.get(i).reset();
                }
            }
            game.nextRound();
            System.out.println(game);
            showGameResults();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void showGameResults() {
        System.out.println(game.getGameResults());
        try {
            boolean playAgain = true;
            for(int i = 0; i < sockets.size(); i++) {
                outputStreams.get(i).writeObject(game);
                outputStreams.get(i).flush();
                outputStreams.get(i).reset();

                outputStreams.get(i).writeObject(game.getGameResults() + "\nPlay again?(y/n)");
                outputStreams.get(i).flush();
                outputStreams.get(i).reset();
            }
            for(int i = 0; i < sockets.size(); i++) {
                String command = (String) inputStreams.get(i).readObject();
                if(command.toLowerCase().startsWith("n")) playAgain = false;
            }
            if(playAgain) {
                game.resetGame();
                startGame();
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void closeConnection() {
        try {
            serverSocket.close();
            for(int i = 0; i < sockets.size(); i++) {
                sockets.get(i).close();
                inputStreams.get(i).close();
                outputStreams.get(i).close();
            }
            System.out.println("Server connection closed.");
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public static void main(String[] args) {
        <2> // 4 missing statements
    }
}
