import java.util.*;
public class League {
    private ArrayList<Team> teams;

    public League() {
        this.teams = new ArrayList<>();
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(Team team) {
        teams.remove(team);
    }
    
    public Team getBestTeam() {
        Team bestTeam = null;
        int maxWins = -1;
        for (Team tm : teams) {
            if (tm.getWins() > maxWins) {
                maxWins = tm.getWins();
                bestTeam = tm;
            }
        }
        return bestTeam;
    }


    public Team findTeam(String team) {
        for (Team tm: teams) {
            if (tm.getTeamName().equalsIgnoreCase(team)) {
                return tm;
            }
        }
        return null;
    }

    public void printStandings() {
        ArrayList<Team> standings = new ArrayList<>(teams);
        Comparator<Team> byWins = new Comparator<>() {
            @Override
            public int compare(Team team1, Team team2) {
                return team2.getWins() - team1.getWins();
            }
        };
        standings.sort(byWins);
        for (int i = 0; i < standings.size(); i++) {
            System.out.println((i + 1) + ". " + standings.get(i).getTeamName() + ": " + 
            standings.get(i).getWins() + " - " + standings.get(i).getLosses());
        }

    }
}

    


