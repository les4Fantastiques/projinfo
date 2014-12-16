package lesFantastiques.lesFantastiques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * tester la connecte de l'Internet 
 * 
 * @author Yishuo
 */
public class testInternet  {
    static BufferedReader bufferedReader; 
    public  testInternet() throws IOException {
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
 
             @SuppressWarnings("unused")
			windows fen = new windows();
        } catch (IOException e) {
             @SuppressWarnings("unused")
			windowsFaut fen1 = new windowsFaut();
        } 
        finally {
            bufferedReader.close();
        }
    }
    public static void main(String[] args) throws IOException{
    	@SuppressWarnings("unused")
		testInternet test = new testInternet();
    }
    
}