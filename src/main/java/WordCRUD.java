import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements Icrud{

    int tempDifficulty;
    String tempWord;
    String tempMeaning;
    ArrayList<Dictionary> dictionary = new ArrayList<Dictionary>();


    public void create()
    {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("난이도(1, 2, 3) & 새 단어 입력 : ");
        tempDifficulty = keyboard.nextInt();
        tempWord = keyboard.nextLine();
        System.out.println("뜻 입력 : ");
        tempMeaning = keyboard.nextLine();
        Dictionary temp = new Dictionary(tempDifficulty, tempWord, tempMeaning);
        dictionary.add(temp);

        System.out.println("새 단어가 단어장에 추가되었습니다.");


    }

    public void read()
    {
        System.out.println("-------------------");
        for(int i=0; i<dictionary.size(); i++)
        {
            System.out.print(i);
            if(dictionary.get(i).getDifficulty()==1)
            {
                System.out.print(" *");
            }
            if(dictionary.get(i).getDifficulty()==2)
            {
                System.out.print(" **");
            }
            if(dictionary.get(i).getDifficulty()==3)
            {
                System.out.print(" ***");
            }
            System.out.println(dictionary.get(i).getWord()+" "+dictionary.get(i).getMeaning());


        }
    }


}
