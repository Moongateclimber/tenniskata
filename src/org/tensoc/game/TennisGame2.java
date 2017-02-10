package org.tensoc.game;

public class TennisGame2 implements TennisGame
{
    private int player1WonPoints = 0;
    private int player2WonPoints = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String P1res = "";
        String P2res = "";

        String score = "";
        if (player1WonPoints == player2WonPoints && player1WonPoints < 4)
        {
            if (player1WonPoints==0)
                score = "Love";
            if (player1WonPoints==1)
                score = "Fifteen";
            if (player1WonPoints==2)
                score = "Thirty";
            score += "-All";
        }
        if (player1WonPoints==player2WonPoints && player1WonPoints>=3)
            score = "Deuce";
        
        if (player1WonPoints > 0 && player2WonPoints==0)
        {
            if (player1WonPoints==1)
                P1res = "Fifteen";
            if (player1WonPoints==2)
                P1res = "Thirty";
            if (player1WonPoints==3)
                P1res = "Forty";
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (player2WonPoints > 0 && player1WonPoints==0)
        {
            if (player2WonPoints==1)
                P2res = "Fifteen";
            if (player2WonPoints==2)
                P2res = "Thirty";
            if (player2WonPoints==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (player1WonPoints>player2WonPoints && player1WonPoints < 4)
        {
            if (player1WonPoints==2)
                P1res="Thirty";
            if (player1WonPoints==3)
                P1res="Forty";
            if (player2WonPoints==1)
                P2res="Fifteen";
            if (player2WonPoints==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (player2WonPoints>player1WonPoints && player2WonPoints < 4)
        {
            if (player2WonPoints==2)
                P2res="Thirty";
            if (player2WonPoints==3)
                P2res="Forty";
            if (player1WonPoints==1)
                P1res="Fifteen";
            if (player1WonPoints==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (player1WonPoints > player2WonPoints && player2WonPoints >= 3)
        {
            score = "Advantage "+player1Name;
        }
        
        if (player2WonPoints > player1WonPoints && player1WonPoints >= 3)
        {
            score = "Advantage "+player2Name;
        }
        
        if (player1WonPoints>=4 && player2WonPoints>=0 && (player1WonPoints-player2WonPoints)>=2)
        {
            score = "Win for "+player1Name;
        }
        if (player2WonPoints>=4 && player1WonPoints>=0 && (player2WonPoints-player1WonPoints)>=2)
        {
            score = "Win for "+player2Name;
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1WonPoints++;
    }
    
    public void P2Score(){
        player2WonPoints++;
    }

    public void wonPoint(String player) {
        if (player == player1Name)
            P1Score();
        else
            P2Score();
    }
}