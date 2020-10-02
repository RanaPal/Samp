package A_Interview_String_prorams;
import java.util.Arrays;
import java.util.Scanner;

public class CarecterOccurance {
	public static void main(String[] args) {
		int[]  num= {11,3,2,2,3,11,4,3,5,4,2,11};
	//	integerNumberOccurance(  num) ;
		Scanner nm=new Scanner(System.in);
		System.out.println("Entra any String ");
		String name=nm.nextLine();
		charNumberOccurance( name);
	//	reverseString( name);
//		for(int i=0;i<num.length;i++)
//			System.out.println(num[i]);
	}
	public static void charNumberOccurance( String name) {
		char [] nchar=name.toCharArray();
			Arrays.sort(nchar);
			char temp=' ';
			int cnt=1;	
			System.out.println("Name : "+name);
			
		
			for (int i=0;i<nchar.length;i++){
				if (nchar[i]!=temp) {
					for (int j=i+1;j<nchar.length;j++) {
						if( nchar[i]==nchar[j])	
							cnt++;
					}
					//					System.out.println( Character.toString(nchar[i]).toUpperCase()+" is "+ cnt);
					System.out.println( nchar[i]+"  is "+ cnt);
					cnt=1;
					temp=nchar[i];
				}
			}	
	}
	
	public static void integerNumberOccurance( int [] num1) {
	  int [] num=num1.clone();
		Arrays.sort(num);
		int temp=99999;
		int cnt=1;	
		for (int i=0;i<num.length;i++){
			if (num[i]!=temp) {
				for (int j=i+1;j<num.length;j++) {
					if( num[i]==num[j])	
						cnt++;
				}
				System.out.println("Occurance of "+num[i]+ " is "+ cnt);
				cnt=1;	temp=num[i];
			}
		}	
	}
	public static void reverseString(String name) {
		StringBuffer name1= new StringBuffer(name);
		System.out.println("Reverse name is : "+name1.reverse());
	}
}

