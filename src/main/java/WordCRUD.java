import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;

public class WordCRUD implements Icrud{

    int tempDifficulty;
    String tempWord;
    String tempMeaning;
    Scanner keyboard = new Scanner(System.in);
    ArrayList<Dictionary> dictionary = new ArrayList<Dictionary>();
    final String fname = "Dictionary.txt";


    public void create()
    {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("난이도(1, 2, 3) & 새 단어 입력 : ");
        tempDifficulty = keyboard.nextInt();
        tempWord = keyboard.nextLine();
        System.out.println("뜻 입력 : ");
        tempMeaning = keyboard.nextLine();
        Dictionary temp = new Dictionary(0,tempDifficulty, tempWord, tempMeaning);
        dictionary.add(temp);

        System.out.println("새 단어가 단어장에 추가되었습니다.");


    }

    public void read()
    {
        System.out.println("-------------------");
        for(int i=0; i<dictionary.size(); i++)
        {
            System.out.print(i+1);
            if(dictionary.get(i).getDifficulty()==1)
            {
                System.out.print(" * ");
            }
            if(dictionary.get(i).getDifficulty()==2)
            {
                System.out.print(" ** ");
            }
            if(dictionary.get(i).getDifficulty()==3)
            {
                System.out.print(" *** ");
            }
            System.out.println(dictionary.get(i).getWord()+" "+dictionary.get(i).getMeaning());


        }
    }

    public ArrayList<Integer> read(String keyword)
    {   
        ArrayList<Integer> idlist = new ArrayList<>();
        int j=0;

        System.out.println("-------------------");
        for(int i=0; i<dictionary.size(); i++)
        {   
            String word = dictionary.get(i).getWord();
            if(!word.contains(keyword)) continue;

            System.out.print(j+1);
            if(dictionary.get(i).getDifficulty()==1)
            {
                System.out.print(" * ");
            }
            if(dictionary.get(i).getDifficulty()==2)
            {
                System.out.print(" ** ");
            }
            if(dictionary.get(i).getDifficulty()==3)
            {
                System.out.print(" *** ");
            }
            System.out.println(dictionary.get(i).getWord()+" "+dictionary.get(i).getMeaning());
            idlist.add(i);
            j++;


        }
        System.out.println("-------------------");
        return idlist;
    }

    public void read(int level)
    {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j=0;

        System.out.println("-------------------");
        for(int i=0; i<dictionary.size(); i++)
        {
            int tempLevels = dictionary.get(i).getDifficulty();
            if(tempLevels !=level) continue;

            System.out.print(j+1);
            if(dictionary.get(i).getDifficulty()==1)
            {
                System.out.print(" * ");
            }
            if(dictionary.get(i).getDifficulty()==2)
            {
                System.out.print(" ** ");
            }
            if(dictionary.get(i).getDifficulty()==3)
            {
                System.out.print(" *** ");
            }
            System.out.println(dictionary.get(i).getWord()+" "+dictionary.get(i).getMeaning());
            j++;


        }
        System.out.println("-------------------");
    }



    public void updateItem(){



        System.out.print("==> 수정할 단어 검색: ");
        String keyword = keyboard.next();
        ArrayList<Integer> idlist = read(keyword); // 이거는 뭐지??
        System.out.print("==> 수정할 번호 선택 : ");
        int id = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("==> 뜻 입력: ");
        String meaning = keyboard.nextLine();
        Dictionary word = dictionary.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.print("단어가 수정되었습니다. ");



    }

    public void deleteItem(){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("==> 삭제할 단어 검색: ");
        String keyword = keyboard.next();
        ArrayList<Integer> idlist = read(keyword);
        System.out.print("==> 삭제할 번호 선택 : ");
        int id = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("==> 정말로 삭제하실래요?(Y/N) ");
        String answer = keyboard.next();
        if(answer.equalsIgnoreCase("y")){
            dictionary.remove((int)idlist.get(id-1));
            System.out.print("단어가 삭제되었습니다. ");
        }
        else{
            System.out.print("취소되었습니다. ");
        }
        



    }   

    public void saveFile() {

        try {
            PrintWriter pr = new PrintWriter(new FileWriter("test.txt"));
            for(Dictionary one : dictionary){
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("==> 데이터 저장 완료!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }

    public void loadFile() {
        try {

            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count =0;

            while(true){
                line = br.readLine();
                if(line==null) break;

                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                dictionary.add(new Dictionary(0, level, word, meaning));
                count++;
            }
            br.close();
            System.out.println("==> "+count+" 개 로딩 완료!");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        
    }


    public void searchLevel() {

        System.out.println("==> 원하는 레벨은?(1~3) ");
        int level = keyboard.nextInt();
        read(level);

    }

    public void search() {

        System.out.println("==> 원하는 단어는? ");
        String keyword = keyboard.next();
        read(keyword);

    }
}
