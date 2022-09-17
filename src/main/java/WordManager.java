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
        word.loadFile();
        while(true)
        {
            System.out.println();
            System.out.println("*** 영단어 마스터 ***");
            System.out.println("******************");
            System.out.println("1. 모든 단어 보기");
            System.out.println("2. 수준별 단어 보기");
            System.out.println("3. 단어 검색");
            System.out.println("4. 단어 추가");
            System.out.println("5. 단어 수정");
            System.out.println("6. 단어 삭제");
            System.out.println("7. 파일 저장");
            System.out.println("0. 나가기");
            System.out.println("******************");
            System.out.println("==> 원하는 메뉴는? ");
            num = keyboard.nextInt();
            if(num==1)
            {
                word.read();
            }
            if(num==2)
            {
                word.searchLevel();
            }
            if(num==3)
            {
                word.search();
            }
            else if(num==4)
            {
                word.create();
            }
            else if(num==5)
            {
                word.updateItem();
            }
            else if(num==6)
            {
                word.deleteItem();
            }
            else if(num==7)
            {
                word.saveFile();
            }
            else if(num==0)
            {
                break;
            }
        }

    }


}
