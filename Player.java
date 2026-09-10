
     public class Player implements Playable {
      private String name;
      private String position;
      private int points;
      private int assists;
      private int rebounds;
   
      public Player(String name, String position, int points, int assists, int rebounds) {
         this.name = name;
         this.position = position;
         this.points = points;
         this.assists = assists;
         this.rebounds = rebounds;
      }
      
      public String getName() {
         return name;
      }

      public String getPosition() {
         return position;
      }
      
      public int getPoints() {
         return points;
      }
      public int getAssists() {
         return assists;
      }
      public int getRebounds() {
         return rebounds;
      }
      
      public void addPoints(int amount) {
         if (amount > 0) {
           points += amount;
         }
      }
      public void addAssists(int amount) {
         if (amount > 0) {
           assists += amount;
         }
      }
      public void addRebounds(int amount) {
         if (amount > 0) {
           rebounds += amount;
         }
      }
      
      public void removePoints(int amount) {
         if (amount > points) {
            System.out.println("The amount is larger than the player's points");
         } else if (amount > 0) {
            points -= amount;
         }
      }
      public void removeAssists(int amount) {
         if (amount > assists) {
            System.out.println("The amount is larger than the player's assists");
         } else if (amount > 0) {
            assists -= amount;
         }
     }
     public void removeRebounds(int amount) {
        if (amount > rebounds) {
           System.out.println("The amount is larger than the player's rebounds");
        } else if (amount > 0) {
            rebounds -= amount;
        }
     }
      
     public void printInfo() {
        System.out.println(name + " - " + points + " points" + " - " + assists + " assists" + 
           " - " + rebounds + " rebounds");
     } 
     
     public void play() {
        System.out.println("Keep it up");
     }
         
   
   
  }

