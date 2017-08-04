import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<String> vetor = LerArquivo("2.txt");
		String op = vetor.get(vetor.size()-1);
		Integer total = 0;
		System.out.println(vetor.size());
		if(op.equals("+")){
			for(int i = 0;i<vetor.size()-1;i++){
				total = total + Integer.parseInt(vetor.get(i));
				System.out.println(total);
			}
		}
		System.out.println(total);

	}
	
	public static ArrayList LerArquivo(String arq) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(arq));
		ArrayList<String> vetor = new ArrayList();
		String line;
		boolean num = false;
		String count = "";
		
		while((line = br.readLine()) != null) {
			line = line.trim();
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i)==',' || line.charAt(i)==' ' ) num = false;
				if(line.charAt(i) != ',' && line.charAt(i) != '-' && line.charAt(i) != '.' && line.charAt(i) != ' ' ){
					if(num){
						count = vetor.get(vetor.size()-1);
						vetor.remove(vetor.size()-1);
						count = count +line.charAt(i);
						vetor.add(count);
					}
					else{
						vetor.add(""+line.charAt(i));
						count="";
					}
					num=true;
				}
			}
			line="";
		}
		for(String s: vetor){
			System.out.print(s);
		
		}
	
		
		return vetor;
	}

}