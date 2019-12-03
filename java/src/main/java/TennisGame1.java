
public class TennisGame1 implements TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        String score = "";
        if (playerOneScore == playerTwoScore)
        {
            score = formatEvenScore();
        }
        else if (playerOneWins()) {
            score = formatWin("player1");
        }
        else if (playerTwoWins()) {
            score = formatWin("player2");
        }
        else if (playerOneAdvantage()) {
            score = formatAdvantage("player1");
        }

        else if (playerTwoAdvantage()) {
            score = formatAdvantage("player2");
        }
        else
        {
            score = formatUnequalScore();
        }
        return score;
    }

    private String formatUnequalScore() {
        String score = formatScorePart(playerOneScore);
        score += "-";
        score += formatScorePart(playerTwoScore);
        return score;
    }

    private String formatWin(String playerName) {
        return "Win for " + playerName;
    }

    private String formatAdvantage(String playerName) {
        return "Advantage " + playerName;
    }

    private boolean playerOneWins() {
        return playerOneScore >=4 && (playerOneScore - playerTwoScore >= 2);
    }

    private boolean playerOneAdvantage() {
        return playerOneScore >=4 && (playerOneScore - playerTwoScore == 1);
    }

    private boolean playerTwoWins() {
        return playerTwoScore >=4 && (playerTwoScore - playerOneScore >= 2);
    }

    private boolean playerTwoAdvantage() {
        return playerTwoScore >=4 && (playerTwoScore - playerOneScore == 1);
    }

    private String formatEvenScore() {
        String score;
        switch (playerOneScore)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }

    private String formatScorePart(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}
