package Assignment3;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * This is a server class that that will listen for a client connection. It will then receive
 * an object from the client and run the credit card's setIsValid method which will run static
 * methods toDigit, doubleSecond, and sumDigits in order. The result will then return true or false
 * for the credit card number.
 * @author Philip
 *
 */
public class CardServer {
	
	public static void main(String [] args){
		
		ServerSocket serverSocket;
		
		try{
			serverSocket = new ServerSocket(0141);
			System.out.println("Listening for a connection with a client");
				
			Socket socketConnection = serverSocket.accept();
			
			ObjectOutputStream oosToClient = new ObjectOutputStream(socketConnection.getOutputStream());
			ObjectInputStream oisFromClient = new ObjectInputStream(socketConnection.getInputStream());
			CreditCard creditCard;
			
			try{
				
					creditCard = (CreditCard)oisFromClient.readObject();
					System.out.println("The server is receiving credit card number from the client and validating: " + creditCard);
					
					creditCard.setIsValid(CardValidation.isValid(creditCard.getCreditCardNumber()));
					
					System.out.println("The server is sending the results to the Client...");
					
					oosToClient.writeObject(creditCard);
					oosToClient.flush();
					
					
					
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(EOFException eof){
				System.out.println("The client has terminated connection");
			}catch(IOException e){
				e.printStackTrace();
			}
			oosToClient.close();
			oisFromClient.close();
			socketConnection.close();
			serverSocket.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		  System.out.println("The server is now terminating!");
		  
	}

}
