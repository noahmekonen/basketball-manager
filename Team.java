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
        if (players.size() == 0) {
            return null;
        }
         Player highestScore = players.get(0);
         for (Player p : players) {
            if(p.getPPG() > highestScore.getPPG()) {
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