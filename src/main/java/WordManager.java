import java.util.Scanner;

public class WordManager {
    /*
    우클릭 후 제너레이트 하면 오버라이딩 등 여러가지 가능
     */
    int num;
    WordCRUD word = new WordCRUD();
    Scanner keyboard = new Scanner(System.in);

    public void selectMenu()
    {
        while(true)
        {
            System.out.println();
            System.out.println("*** 영단어 마스터 ***");
            System.out.println("******************");
            System.out.println("1. 모든 단어 보기");
            System.out.println("4. 단어 추가");
            System.out.println("0. 나가기");
            System.out.println("******************");
            System.out.println("==> 원하는 메뉴는? ");
            num = keyboard.nextInt();
            if(num==1)
            {
                word.read();
            }
            else if(num==4)
            {
                word.create();
            }
            else if(num==0)
            {
                break;
            }
        }

    }


}
