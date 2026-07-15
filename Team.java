   import java.util.*;
   public class Team implements Playable { 
      private String teamName;
      private ArrayList<Player> players;
   
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
     
     public void play() {
      System.out.println("Lets Keep Playing");
     }
      
  }