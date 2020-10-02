package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static String teamName = "teamname1";

    public static void main(String[] args) {
        Game game = new Game();
        if(readFile("end_game") == null){
            while(readFile(teamName + ".go") != null){
                System.out.println(".go file founded");
                game.updateBoard(readFile("move_file"));
                game.makeMove();

                return;
            }
        }else{
            System.out.println("Game Ended");
        }







    }


    private static File readFile(String fileN){
        try {
            String path = "./referee/" + fileN;
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            String content = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content += data;
            }
            myReader.close();
            return file;
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            return null;
        }
    }
}
