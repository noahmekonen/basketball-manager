public class practice621 {
   public static void main(String[] args) {
      Team warriors = new Team("Warriors");
      Player steph = new Player("Steph", 30, 6, 5);
      Player jimmy = new Player("Jimmy", 22, 5, 7);
      Player draymond = new Player("Draymond", 10, 10, 9);
      
      warriors.addPlayer(steph);
      warriors.addPlayer(jimmy);
      warriors.addPlayer(draymond);
      
      System.out.println("Team: " + warriors.getTeamName());
      System.out.println();
      
      System.out.println("Roster:");
      warriors.printRoster();
      System.out.println();
      
      Player best = warriors.getHighestScorer();
      
      System.out.println("Highest Scorer:");
      best.printInfo();
      System.out.println();
      
      best.addPoints(10);
      warriors.getPlayers().get(1).addPoints(10);
      steph.addPoints(5);
      jimmy.removeRebounds(3);
      draymond.addAssists(7);
      
      System.out.println("After the stats update: ");
      warriors.printRoster();
      System.out.println();
      
      best.play();
      warriors.play();
      
   } 
}