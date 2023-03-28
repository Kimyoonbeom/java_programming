package assignments;
import java.util.Scanner;

public class Weeks3 {
	public static void main(String[] args) {
		String com[] = {"가위","바위","보"};
		Scanner sc = new Scanner(System.in);
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		
		//1. 사용자 입력
		while(true) {
			System.out.print("가위 바위 보!>>");
			String user = sc.nextLine(); //사용자가 낸 것
			
			if(user.equals("그만")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			//2. 컴퓨터가 내는 것
			int index = (int)(Math.random()*3); 
			String strCom = com[index];
			
			System.out.print("나는" + user);
			System.out.print(", 컴퓨터는"+strCom);
			
			if(user.equals("가위")) {
				if(strCom.equals("가위"))
					System.out.println("비겼음");
				else if(strCom.equals("바위"))
					System.out.println("졌음");
				else if(strCom.equals("보"))
					System.out.println("이겼음");
			}
			else if(user.equals("바위")) {
				if(strCom.equals("가위"))
					System.out.println("이겼음");
				else if(strCom.equals("바위"))
					System.out.println("비겼음");
				else if(strCom.equals("보"))
					System.out.println("졌음");
			}
			else if(user.equals("보")) {
				if(strCom.equals("가위"))
					System.out.println("졌음");
				else if(strCom.equals("바위"))
					System.out.println("이겼음");
				else if(strCom.equals("보"))
					System.out.println("비겼음");
			}
			else {
				System.out.println("잘못 냈습니다.");
				
				
			
				                      
			}
		}
	}


}
