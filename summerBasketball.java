import java.util.*;
public class summerBasketball {
   public static void main(String[] args) {
      Team warriors = new Team(" Warriors");
      Player steph = new Player("Steph Curry", "PG", 30, 6, 5);
      Player jimmy = new Player("Jimmy Butler", "SG", 22, 5, 7);
      Player draymond = new Player("Draymond Green", "SF", 10, 10, 9);
      Coach kerr = new Coach("Steve Kerr", 12, warriors);

      Scanner input = new Scanner(System.in);
      
      warriors.addPlayer(steph);
      warriors.addPlayer(jimmy);
      warriors.addPlayer(draymond);
      
      System.out.println("Team: " + warriors.getTeamName());
      System.out.println();
      kerr.printInfo();
      System.out.println();
      
      System.out.println("Roster:");
      warriors.printRoster();
      System.out.println();
      
      Player best = warriors.getHighestScorer();
      
      System.out.println("Highest Scorer:");
      best.printInfo();
      System.out.println();
      
      kerr.motivateTeam();
      System.out.println();
      
      best.addPoints(10);
      warriors.getPlayers().get(1).addPoints(10);
      steph.addPoints(5);
      jimmy.removeRebounds(3);
      draymond.addAssists(7);
      
      System.out.println("After the stats update: ");
      warriors.printRoster();
      System.out.println();
      
      kerr.play();
      System.out.println();
      
      Player found1 = warriors.findPlayer("steph curry");
      if (found1 != null) {
         found1.printInfo();
      } else {
         System.out.println("Player not found");
      }

      System.out.println();
      warriors.removePlayer("Jimmy");
      warriors.printRoster();
      System.out.println();
      
           
      best.play();
      warriors.play();
      System.out.println();

      
      Team lakers = new Team("Lakers");
      Player luka = new Player("Luka Doncic", "PG",25, 8, 9);
      Player deandre = new Player("Deandre Ayton","C", 11, 3, 15);
      Player austin = new Player("Austin Reaves", "SG", 22, 4, 6);
      Coach jj = new Coach("JJ Redick", 2, lakers);
      
      lakers.addPlayer(luka);
      lakers.addPlayer(deandre);
      lakers.addPlayer(austin);
      
      jj.printInfo();
      lakers.printRoster();
      Player top = lakers.getHighestScorer();
      System.out.println("Highest Scorer: ");
      top.printInfo();
      
      System.out.printf("Average points: %.2f%n", lakers.getAveragePoints());

      warriors.tradePlayer(steph, lakers);
      System.out.println("After the trade: ");
      System.out.println("Warriors Roster: ");
      warriors.printRoster();
      System.out.println("Lakers Roster: ");
      lakers.printRoster();
      System.out.println();
      
      Player found2 = lakers.findPlayer("luka doncic");
      if (found2 != null) {
         found2.printInfo();
      } else {
         System.out.println("Player not found");
      }

      Game game1 = new Game(warriors, lakers);
         game1.playGame();
         game1.printScore();
         Team winner = game1.getWinner();
         System.out.println("The winner is: " + winner.getTeamName());
     
     League nba = new League(); 
     nba.addTeam(warriors);
     nba.addTeam(lakers);

     boolean running = true;
     while (running) {
        System.out.println("    Basketball League Manager   ");
        System.out.println("1. View Teams");
        System.out.println("2. Add Team");
        System.out.println("3. View Teams Roster");
        System.out.println("4. Add Player(s)");
        System.out.println("5. Remove Player");
        System.out.println("6. Trade Player");
        System.out.println("7. Play Game");
        System.out.println("8. View Standings");
        System.out.println("9. Exit");
        System.out.println();
      
        System.out.println("Choose an option (list the corresponding number): ");
        int choice = input.nextInt();

        switch (choice) {
           case 1:
            for (Team tm : nba.getTeams()) {
               System.out.println(tm.getTeamName());
            }
            break;
            case 2:
               System.out.print("Enter team name: ");
               input.nextLine();
               break;
            case 3:
               for (Team tm : nba.getTeams()) {
                  System.out.println(tm.getTeamName() + " Roster: ");
                  tm.getPlayers();
                  break;
               }
            case 4:
               System.out.print("Enter the team name to add player(s) on: ");
               String teams = input.nextLine();
               Team nbaTeam = nba.findTeam(teams);
               if (nbaTeam == null) {
                  System.out.println("Team not found.");
                  break;
               }
               System.out.println("Enter the player name: ");
               String player = input.nextLine();
               System.out.println("Enter the player position: ");
               String position = input.nextLine();
               Player newPlayer = new Player(player, position, 0, 0, 0);
               nbaTeam.addPlayer(newPlayer);
               break;
            case 5:
               System.out.print("Enter the team name to remove player(s) from: ");
               String teamName = input.nextLine();
               Team team = nba.findTeam(teamName);
               System.out.print("Enter the player name that you want to remove: ");
               String removePlayer = input.nextLine();
               team.removePlayer(removePlayer);
               break;
            case 6:
               System.out.print("Enter the team name to trade player(s) from: ");
               String fromTeamName = input.nextLine();
               Team fromTeam = nba.findTeam(fromTeamName);
               System.out.print("Enter the player name that you want to trade: ");
               String tradePlayer = input.nextLine();
               Player playerToTrade = fromTeam.findPlayer(tradePlayer);
               System.out.print("Enter the team name to trade player(s) to: ");
               String toTeamName = input.nextLine();
               Team toTeam = nba.findTeam(toTeamName);
               fromTeam.tradePlayer(playerToTrade, toTeam);
               break;
            case 7:
               System.out.print("Enter the first team name to play a game: ");
               String firstTeamName = input.nextLine();
               Team firstTeam = nba.findTeam(firstTeamName);
               System.out.print("Enter the second team name to play a game: ");
               String secondTeamName = input.nextLine();
               Team secondTeam = nba.findTeam(secondTeamName);
               Game game = new Game(firstTeam, secondTeam);
               game.playGame();
               game.printScore();
               Team gameWinner = game.getWinner();
               System.out.println("The winner is: " + gameWinner.getTeamName());
               break;
           case 8:
              nba.printStandings();
              break;
           case 9:
              running = false;
              break;
         } 

      } 
      input.close();
   } 
}