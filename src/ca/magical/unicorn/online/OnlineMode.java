package ca.magical.unicorn.online;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import ca.magical.unicorn.windows.WindowGame;

public class OnlineMode {
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static ServerSocket server;	// Socket Serveur côté serveur
	public static Socket client;		// Socket client côté serveur
	public static Socket socket;		// Socket côté client
	public static String serverIP = "127.0.0.1"; 	// Socket serveur sur cette adresse IP
	public static String connectIP = "127.0.0.1"; // Client se connecte sur cette adresse
	public static int port = 25567;				// Port de connection pour le Serveur et le client
	
	public OnlineMode(boolean host, GameContainer _container, StateBasedGame _game, WindowGame _wgame){
		try{
			if(host){
				System.out.println("Hosting...");
				server = new ServerSocket(port, 4, InetAddress.getByName(serverIP));
				System.out.println("Ready!\nAwaiting client...");
				client = server.accept();
				System.out.println("Client connected!\nBuffering...");
				out = new ObjectOutputStream(client.getOutputStream());
				in = new ObjectInputStream(client.getInputStream());
				System.out.println("Buffered!\nPinging for 256 bytes...");
				long start = System.currentTimeMillis();
				byte[] ping = new byte[256];
				in.read(ping);
				System.out.println("Latency: "+(System.currentTimeMillis()-start));
				out.writeLong(start);
				out.flush();
				System.out.println("Starting threads...");
				new ThreadSend(_container, _game, _wgame, out);
				new ThreadReceive(_container, _game, _wgame, in);
				System.out.println("Started!\nCreating game world...");
			}else{
				System.out.println("Connecting...");
				socket = new Socket(connectIP, port);
				System.out.println("Connected!\nBuffering...");
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				byte[] ping = new byte[256];
				new Random().nextBytes(ping);
				System.out.println("Buffered\nPinging for 256 bytes...");
				out.write(ping);
				out.flush();
				long latency = in.readLong();
				System.out.println("Latency: "+(System.currentTimeMillis()-latency));
				System.out.println("Starting threads...");
				new ThreadReceive(_container, _game, _wgame, in);
				new ThreadSend(_container, _game, _wgame, out);
				System.out.println("Started!\nCreating game world...");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
