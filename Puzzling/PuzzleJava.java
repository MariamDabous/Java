import java.util.Random;
import java.util.ArrayList;
public class PuzzleJava{

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        Random myRandom= new Random();
        for(int i=0; i<10; i++){
            myList.add(myRandom.nextInt(20));
        }
        return myList;
    }

    public String getRandomLetter(){
        String [] myLetters = {"A","B", "C", "D","E"};
        Random myAlph= new Random();
        String resultAlphet= myLetters[myAlph.nextInt(5)];
        return resultAlphet;

    }

    public String generatePassword(){
        String password=new String();
        for(int i=0; i<8; i++){
            password+=getRandomLetter();
        }
        return password;
    }

    public  ArrayList<String> getNewPasswordSet(int number){                 //////we need arraylist because not fixed size
        ArrayList<String> setPassword =new ArrayList<String> ();
        for(int i=0; i<number; i++){
            setPassword.add(generatePassword());
        }
        return setPassword;

    }


}