import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// Write your Checker class here

class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){
        
        System.out.println("*******************Welcome to guess the movie program**************");
        

        ArrayList <String> movieList = readAfile();
        String randomMovie =  selectRandomMovie(movieList);
        System.out.println(randomMovie);
        int lostcount = 10;
        Character input;
        int index;
        HashSet<Character> set = new HashSet<Character>();
        ArrayList <Character> wrongMovieList = new ArrayList<>();
        ArrayList <Character> movieToCharArray = addMovieStringToCharArrayList(randomMovie);
        ArrayList <Character> movieWithUnderscorCharacters = addMovieStringToUnderscoreCharArrayList(randomMovie);
        
        while(lostcount>0 && !movieToCharArray.toString().isEmpty()){
            System.out.println("You are Guessing : " + movieWithUnderscorCharacters.toString());
            System.out.println("You have guessed (" + wrongMovieList.size()+ ") letters" + wrongMovieList.toString());
            if (set.size()==1) {
                System.out.println("You Won!!");
                return;
            }
            input = takeUserInput();
            index = checkCharacter(movieToCharArray, input, set);
            if (index>=0) {
                movieWithUnderscorCharacters.set(index, input);
            } else {
                wrongMovieList.add(input);
                lostcount--;
            }
            System.out.println("String : " + movieToCharArray.toString().length());
            if (lostcount == 0 ) {
                System.out.println("Game Over, You Lose!");
                return;
            } else{
                set.clear();
            }
            for (Character character : movieToCharArray) {
                set.add(character);
            }
            
        }

        
    }
    private static int checkCharacter(ArrayList<Character> movieToCharArray, Character input, HashSet set) {
        int index;
        if (movieToCharArray.contains(input)) {
            index = movieToCharArray.indexOf(input);
            movieToCharArray.set(index, '\u0000');  
            return index;
        } else {
            return -1;
        }
        // return 0;
    }
    private static ArrayList<Character> addMovieStringToUnderscoreCharArrayList(String randomMovie) {
        int length = randomMovie.length();
        int index = 0;
        ArrayList <Character> movieCharArray = new ArrayList<>();
        while (length>0) {
            movieCharArray.add('_');
            length--;
        }
        return movieCharArray;
    }
    private static Character takeUserInput() {
        System.out.print("Guess A Letter: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        // sc.close();
        return input.charAt(0);
    }
    private static ArrayList<Character> addMovieStringToCharArrayList(String randomMovie) {
        int length = randomMovie.length();
        int index = 0;
        ArrayList <Character> movieCharArray = new ArrayList<>();
        while (index<length) {
            movieCharArray.add(randomMovie.charAt(index));
            index++;
        }
        return movieCharArray;
    }
    private static String selectRandomMovie(ArrayList<String> movieList) {
        Random rand = new Random();
        int random = rand.nextInt(movieList.size());
        
        return movieList.get(random);
    }
    private static ArrayList<String> readAfile() {
        File file = new File("movie.txt");
        ArrayList<String> movieList = new ArrayList<String>();
        Scanner in;
        try {
            in = new Scanner(file);
            while (in.hasNextLine()) {
                movieList.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return movieList;
    }
}
