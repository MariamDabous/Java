public class Test{
    public static void main(String[] args){

        PuzzleJava mypuzzle = new PuzzleJava();
        System.out.println(mypuzzle.getTenRolls());
        System.out.println(mypuzzle.getRandomLetter());
        System.out.println(mypuzzle.generatePassword());
        System.out.println(mypuzzle.getNewPasswordSet(5));
    }
}