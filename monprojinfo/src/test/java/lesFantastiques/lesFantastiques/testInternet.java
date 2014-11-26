package lesFantastiques.lesFantastiques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
 
/**
 * tester le contact de l'Internet 
 * 
 * @author Yishuo
 */
public class testInternet  {
    static BufferedReader bufferedReader;
 
    public  testInternet() throws IOException {
//    	String address = IPexterne.IPobtenir();
//    	System.out.println(address);
    	InetAddress addr = InetAddress.getLocalHost();
    	String address = addr.getHostAddress().toString();
    	try {
            InputStream in = new URL("http://www.baidu.com").openStream();
            in.close();
            Process process = Runtime.getRuntime().exec("ping " + address);
            bufferedReader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String connectionStr = null;
            while ((connectionStr = bufferedReader.readLine()) != null) {
                System.out.println(connectionStr);
            }
 
             windows fen = new windows();
        } catch (IOException e) {
//          System.out.println("��chouer");
            // e.printStackTrace();
             windowsFaut fen1 = new windowsFaut();
        } 
        finally {
            bufferedReader.close();
        }
    }
    



}