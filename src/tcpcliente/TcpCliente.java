/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author wilson.adm
 */
public class TcpCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket s = null; 
        try {
            int serverPort = 7896;
//            s = new Socket(args[1], serverPort);
            s = new Socket("localhost", serverPort);
            DataInputStream in = new DataInputStream(s.getInputStream( )); 
            DataOutputStream out = new DataOutputStream( s.getOutputStream( )); 
//            out.writeUTF(args[0]); // UTF é uma codificação de string; veja a Seção 4.3
            out.writeUTF("Oi, mundo Java!"); // UTF é uma codificação de string; veja a Seção 4.3
            String data = in.readUTF(); 
            System.out.println("Received: "+ data);
        } catch (UnknownHostException e) { 
            System.out.println("Sock:"+e.getMessage( ));
        } catch (EOFException e) { 
            System.out.println("EOF:"+e.getMessage( ));
        } catch (IOException e) { 
            System.out.println("IO:"+e.getMessage( ));
        } finally { 
            if(s!=null) 
                try { 
                    s.close( );
                } catch (IOException e) {
                /*close falhou*/
                }
        }
    }
    
}
