
     public class Player implements Playable {
      private String name;
      private String position;
      private int totalPoints;
      private int totalAssists;
      private int totalRebounds;
      private int gamesPlayed;
      public Player(String name, String position) {
         this.name = name;
         this.position = position;
      }
      
      public String getName() {
         return name;
      }

      public String getPosition() {
         return position;
      }
      
      public double getPPG() {
         if (gamesPlayed == 0) {
            return 0;
         }
         return (double) totalPoints / gamesPlayed;
      }
      public double getAPG() {
         if (gamesPlayed == 0) {
            return 0;
         }
         return (double) totalAssists / gamesPlayed;
      }
      public double getRPG() {
         if (gamesPlayed == 0) {
            return 0;
         }
         return (double) totalRebounds / gamesPlayed;
      }
      
      public void addPoints(int amount) {
         if (amount > 0) {
           totalPoints += amount;
         }
      }
      public void addAssists(int amount) {
         if (amount > 0) {
           totalAssists += amount;
         }
      }
      public void addRebounds(int amount) {
         if (amount > 0) {
           totalRebounds += amount;
         }
      }
      
     public void printInfo() {
        System.out.println(name + " - " + getPPG() + " PPG" + " - " + getAPG() + " APG" + 
           " - " + getRPG() + " RPG");
     } 
     
     public void play() {
        System.out.println("Keep it up");
     }
         
   
   
  }

