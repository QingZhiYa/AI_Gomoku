package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static String teamName = "teamname1";

    public static void main(String[] args) {

        if(readFile("end_game") == null){
            while(readFile(teamName + ".go") != null){
                System.out.println(".go file founded");
                Game game = new Game(readFile("move_file"));



                return;
            }
        }else{
            System.out.println("Game Ended");
        }







    }


    private static String readFile(String fileN){
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
            return content;
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            return null;
        }
    }
}
