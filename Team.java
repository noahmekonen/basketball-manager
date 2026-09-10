   import java.util.*;
   public class Team implements Playable { 
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
     
     public Player getHighestScorer() {
         Player highestScore = players.get(0);
         for (Player p : players) {
            if(p.getPoints() > highestScore.getPoints()) {
                  highestScore = p;
            }
         }  
         return highestScore;
     }
     
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
     
     public int getTotalPoints() {
         int total = 0;
         for (Player p : players) {
            total += p.getPoints();
         }
         return total;
     }
     
     public double getAveragePoints() {
      double average = 0;
      int count = 0;
      if (players.size() == 0) {
         return 0;
      }
      for (Player p: players) {
         average += p.getPoints();
         count++;
      }
      return average/count;
    }

    public void tradePlayer(Player playerTrade, Team otherTeam) {
      if (players.contains(playerTrade)) {
         players.remove(playerTrade);
         otherTeam.addPlayer(playerTrade);
      } else {
         System.out.println("Player not found.");
      }
    }
     
     public void play() {
      System.out.println("Lets Keep Going");
     }
      
  }