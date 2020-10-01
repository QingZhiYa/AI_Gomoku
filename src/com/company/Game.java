package com.company;

public class Game {
    String moves = "";

    Game(String moves){
        this.moves = moves;
        System.out.println(moves);
    }

    public boolean makeMove(){
        if(moves == ""){
            return firstMove();

        }else{
            //second move

            //move
            return minimax();
        }


        //return false;


    }

    private boolean firstMove(){
        return true;
    }

    private boolean minimax(){
        return true;
    }


}
