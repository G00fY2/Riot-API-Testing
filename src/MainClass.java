import java.io.BufferedReader;
import java.io.FileReader;


public class MainClass {
	
	public static void main(String[] args) throws Exception {
		
		String apiFile = "F:\\apikey.txt";
		String apiKey = null;
		

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(apiFile));
		String currentLine; 
		while ((currentLine = br.readLine()) != null) {
			apiKey = currentLine;
		}

		
		String summonerName = "G00fY2";
		summonerName = summonerName.toLowerCase();	
		
		Request.sendGet(apiKey, summonerName);

	}



}
