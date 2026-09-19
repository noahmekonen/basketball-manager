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
        homeScore = 0;
        awayScore = 0;
        for (Player p: homeTeam.getPlayers()) {
            int gamePoints = (int) (Math.random() * 31);

            p.addPoints(gamePoints);
            homeScore += gamePoints;
        }
        for (Player p: awayTeam.getPlayers()) {
            int gamePoints = (int) (Math.random() * 31);

            p.addPoints(gamePoints);
            awayScore += gamePoints;
        }

        while (homeScore == awayScore) {
            for (Player p: homeTeam.getPlayers()) {
                int overtimePoints = (int) (Math.random() * 8);

                p.addPoints(overtimePoints);
                homeScore += overtimePoints;
            }
           for (Player p: awayTeam.getPlayers()) {
                int overtimePoints = (int) (Math.random() * 8);

                p.addPoints(overtimePoints);
                awayScore += overtimePoints;
           }
        }

        if (homeScore > awayScore) {
            homeTeam.addWin();
            awayTeam.addLoss();
        } else {
            homeTeam.addLoss();
            awayTeam.addWin();
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

    



