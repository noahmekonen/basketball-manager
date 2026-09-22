     // Represents a basketball player and tracks their stats
     public class Player {
      private String name;
      private String position;
      private int totalPoints;
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

      public int getGamesPlayed() {
         return gamesPlayed;
      }

      public void addPoints(int amount) {
         if (amount > 0) {
           totalPoints += amount;
         }
      }

      public void addGamesPlayed() {
         gamesPlayed++;
      }

     public void printInfo() {
        System.out.println(name + " - " + getPPG() + " PPG");
     } 
  }

