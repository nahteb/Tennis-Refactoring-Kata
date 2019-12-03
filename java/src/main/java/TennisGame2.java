
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String player1Result = "";
    public String player2Result = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (P1point==P2point && P1point>=3) {
            score = "Deuce";
        } else if (P1point == P2point) {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";
            score += "-All";
        }
        
        if (P1point > 0 && P2point==0)
        {
            if (P1point==1)
                player1Result = "Fifteen";
            if (P1point==2)
                player1Result = "Thirty";
            if (P1point==3)
                player1Result = "Forty";
            
            player2Result = "Love";
            score = player1Result + "-" + player2Result;
        }
        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                player2Result = "Fifteen";
            if (P2point==2)
                player2Result = "Thirty";
            if (P2point==3)
                player2Result = "Forty";
            
            player1Result = "Love";
            score = player1Result + "-" + player2Result;
        }
        
        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                player1Result ="Thirty";
            if (P1point==3)
                player1Result ="Forty";
            if (P2point==1)
                player2Result ="Fifteen";
            if (P2point==2)
                player2Result ="Thirty";
            score = player1Result + "-" + player2Result;
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                player2Result ="Thirty";
            if (P2point==3)
                player2Result ="Forty";
            if (P1point==1)
                player1Result ="Fifteen";
            if (P1point==2)
                player1Result ="Thirty";
            score = player1Result + "-" + player2Result;
        }
        
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
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
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
