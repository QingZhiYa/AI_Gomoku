package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static String teamName = "teamname1";

    public static void main(String[] args) {
        Game game = new Game(teamName);
        String lastMove = "INITIATE";
         while(true){

              //if it is my turn
              if(readFile(teamName + ".go") != null){
                  //System.out.println("variable:"+lastMove);
                  //System.out.println("Inside the file:"+game.readMove(readFile("move_file")));
                  File moveF = readFile("move_File");
                  if(moveF != null && !game.readMove(moveF).equals(lastMove)){
                      //System.out.println(readFile("end_game"));
                      if(readFile("end_game") == null){
                          //System.out.println(".go file founded");
                          game.updateBoard(readFile("move_file"));
                          lastMove = game.makeMove(readFile("move_file"));



                      }else{
                          System.out.println("Game Ended");
                          System.exit(0);
                      }
                  }

              }


         }



    }


    private static File readFile(String fileN){
        try {
            String path = "./" + fileN;
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
