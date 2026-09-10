public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }
    public Team getAwayTeam() {
        return awayTeam;
    }
    public int getHomeScore() {
        return homeScore;
    }
    public int getAwayScore() {
        return awayScore;
    }

    public void playGame() {
        int randHomeScore = (int) (Math.random() * 100) + 60;
        int randAwayScore = (int) (Math.random() * 100) + 60;
        homeScore = randHomeScore;
        awayScore = randAwayScore;
        while (homeScore == awayScore) {
            int overtimeHomeScore = (int) (Math.random() * 20) + 10;
            int overtimeAwayScore = (int) (Math.random() * 20) + 10;
            homeScore += overtimeHomeScore;
            awayScore += overtimeAwayScore;
        }
    }

    public void printScore() {
        System.out.println("The final score: " + homeTeam.getTeamName() + ": "
        + homeScore + " - " + awayTeam.getTeamName() + ": " + awayScore);
    }

    public Team getWinner() {
        if (homeScore > awayScore) {
            homeTeam.addWin();
            awayTeam.addLoss();
            return homeTeam;
        } else {
            homeTeam.addLoss();
            awayTeam.addWin();
            return awayTeam;
        }
    }
}

    



