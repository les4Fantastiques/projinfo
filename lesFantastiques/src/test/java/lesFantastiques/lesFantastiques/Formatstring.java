package lesFantastiques.lesFantastiques;

public class Formatstring {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tata = new String();
		tata= "#taTataTTisE";
		tata=tata.replaceAll("#","");
		
		for(int i=0;i<tata.length();i++){
			if(Character.isUpperCase(tata.charAt(i)) && tata.charAt(i-1)!=' '){
				tata=tata.replace(tata.charAt(i)+"", " "+tata.charAt(i));
				Character.isLowerCase(tata.charAt(i-1));
			}
		
		}
		System.out.println(tata);
	}

}
