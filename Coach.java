   public class Coach implements Playable {
      private String name;
      private int yearsCoaching;
      private Team team;
      
      public Coach(String name, int yearsCoaching, Team team) {
         this.name = name;
         this.yearsCoaching = yearsCoaching;
         this.team = team;
      }
      
      public String getName() {
        return name;
      }
      public int getYearsCoaching() {
         return yearsCoaching;
      }
      public Team getTeam() {
         return team;
      }
      
      public void printInfo() {
         System.out.println("Coach: " + name + "\n" + "Team: " + team.getTeamName() + "\n" + 
                           "Years Coaching: " + yearsCoaching);
      }
      
      public void motivateTeam() {
         System.out.println(name + " says: " + "Don't stop, Keep playing hard!");
      }
      
      public void play() {
         System.out.println("I like the energy" + " - " + name);
      }
  }