   import java.util.*;
   // Represents a team and manages its roster and win/loss record.
   public class Team { 
      private String teamName;
      private ArrayList<Player> players;
      private int wins;
      private int losses;
   
      public Team(String teamName) {
         this.teamName = teamName;
         this.players = new ArrayList<>();
      }
     
     public String getTeamName() {
         return teamName;
     }
     public ArrayList<Player> getPlayers() {
         return players;
     }

     public int getWins() {
         return wins;
     }

     public int getLosses() {
         return losses;
     }
     

     public void addWin() {
         wins++;
     }

     public void addLoss() {
         losses++;
     }
     
     public void addPlayer(Player player) {
         players.add(player);
     }
     
     public void printRoster() {
         for (Player p : players) {
            p.printInfo();
         }
     }
     
     // Finds a team by name, ignoring capitalization
     public Player findPlayer(String name) {
       for (Player p : players) {
          if (p.getName().equalsIgnoreCase(name)) {
             return p;
          }
       }
        return null;
     }
     
     public void removePlayer(String name) {
       for (Player p : players) {
         if (p.getName().equalsIgnoreCase(name)) {
             players.remove(p);
             return;
         }
       }
     }

    public void tradePlayer(Player playerTrade, Team otherTeam) {
      if (players.contains(playerTrade)) {
         players.remove(playerTrade);
         otherTeam.addPlayer(playerTrade);
      } else {
         System.out.println("Player not found.");
      }
    }
}