import java.util.*;
public class basketballManager {
   public static void main(String[] args) {
      // Create the two starting teams and their rosters
      Team warriors = new Team("Warriors");
      Player steph = new Player("Steph Curry", "PG");
      Player klay = new Player("Klay Thompson", "SG");
      Player jimmy = new Player("Jimmy Butler", "SF");
      Player draymond = new Player("Draymond Green", "PF");
      Player demarcus = new Player("Demarcus Cousins", "C");
      
      warriors.addPlayer(steph);
      warriors.addPlayer(klay);
      warriors.addPlayer(jimmy);
      warriors.addPlayer(draymond);
      warriors.addPlayer(demarcus);
      
      Team lakers = new Team("Lakers");
      Player luka = new Player("Luka Doncic", "PG");
      Player austin = new Player("Austin Reaves", "SG");
      Player lebron = new Player("Lebron James", "SF");
      Player anthony = new Player("Anthony Davis", "PF");
      Player deandre = new Player("Deandre Ayton","C");
      
      lakers.addPlayer(luka);
      lakers.addPlayer(austin);
      lakers.addPlayer(lebron);
      lakers.addPlayer(anthony);
      lakers.addPlayer(deandre);
     
      // Scanner for user input
     Scanner input = new Scanner(System.in);
 
     // Create basketball league
     League nba = new League(); 
     nba.addTeam(warriors);
     nba.addTeam(lakers);

     // Run main menu until user chooses to exit
     boolean running = true;
     while (running) {
        // Display menu options
        System.out.println();
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
        // Validate the user's menu selection
        if (input.hasNextInt()) {
         int choice = input.nextInt();
         input.nextLine();
         if (choice < 1 || choice > 9) {
            System.out.println("Invalid. List one of the corresponding numbers");
         } else {
            switch (choice) {
            
               case 1: {
                  // Display all teams
                  System.out.println();
                  System.out.println("Teams in the league: ");
                  for (Team tm : nba.getTeams()) {
                     System.out.println(tm.getTeamName());
                  }
                  break;
               }

               case 2: {
                  // Create a new team and roster
                  System.out.println();
                  System.out.print("Enter team name (Ex. \"rockets\"...): ");
                  String teamName = input.nextLine();
                  Team newTeam = new Team(teamName);
                  if (nba.findTeam(teamName) != null) {
                     System.out.println("Team already exists.");
                     System.out.println();
                     break;
                  }
                  System.out.println();
                  System.out.println("Enter 5 players for the " + teamName + ": ");
                  System.out.println();
                  ArrayList<String> positions = new ArrayList<>();
                  positions.add("PG");
                  positions.add("SG");
                  positions.add("SF");
                  positions.add("PF");
                  positions.add("C");
                  for (int i = 0; i < 5; i++) {
                     System.out.println("Enter player " + (i + 1) + " name: ");
                     String playerName = input.nextLine();
                     System.out.println();
                     System.out.println("Enter a position for " + playerName + " (Ex. PG, SG,...): ");
                     for (String pos : positions) {
                        System.out.println(pos);
                     }
                     System.out.println();
                     System.out.print("Position: ");
                     String position = input.nextLine();
                     while (!positions.contains(position.toUpperCase())) {
                        System.out.println("Invalid. Please enter a valid position.");
                        System.out.print("Position: ");
                        position = input.nextLine();
                     }
                     positions.remove(position.toUpperCase());

                     Player newPlayer = new Player(playerName, position);
                     newTeam.addPlayer(newPlayer);
                     System.out.println();
                  }
                  nba.addTeam(newTeam);
                  break;
               }

               case 3: {
                  // Display each team roster with player stats
                  System.out.println();
                  for (Team tm : nba.getTeams()) {
                     System.out.println(tm.getTeamName() + " Roster: ");
                     tm.printRoster();
                     System.out.println();
                  }
                  break;
               }

               case 4: {
                  // Add players to an existing team
                  System.out.println();
                  System.out.print("Enter the team name to add player(s) on: ");
                  String teams = input.nextLine();
                  Team nbaTeam = nba.findTeam(teams);
                  if (nbaTeam == null) {
                     System.out.println("Team not found.");
                     System.out.println();
                     System.out.println("Would you like to try again? (Y/N) ");
                     String tryAgain = input.nextLine();
                     if (tryAgain.equalsIgnoreCase("Y")) {
                        System.out.print("Enter the team name to add player(s) on: ");
                        teams = input.nextLine();
                        nbaTeam = nba.findTeam(teams);
                     }
                  }
                  ArrayList<String> positions = new ArrayList<>();
                  positions.add("PG");
                  positions.add("SG");
                  positions.add("SF");
                  positions.add("PF");
                  positions.add("C");

                  System.out.println();
                  System.out.println("How many players would you like to add? ");
                  while (!input.hasNextInt()) {
                     System.out.println("Invalid. Please enter a number.");
                     input.nextLine();
                     System.out.print("How many players would you like to add? ");
                  }
                  int numPlayers = input.nextInt();
                  input.nextLine();
                  for (int i = 0; i < numPlayers; i++) {
                     System.out.println();
                     System.out.println("Enter the player name: ");
                     String player = input.nextLine();
                     System.out.println();
                     System.out.println("List of Positions: ");
                     for (String pos : positions) {
                        System.out.println(pos);
                     }
                     System.out.println();
                     System.out.println("Enter the player position: ");
                     String position = input.nextLine();
                     while (!positions.contains(position.toUpperCase())) {
                        System.out.println();
                        System.out.println("Invalid. Please enter a valid position.");
                        System.out.print("Enter the player position: ");
                        position = input.nextLine();
                     }
                     positions.remove(position.toUpperCase());
                     Player newPlayer = new Player(player, position);
                     nbaTeam.addPlayer(newPlayer);
                  }
                  break;
               }

               case 5: {
                  // Remove a player from a team
                  System.out.println();
                  System.out.print("Enter the team name to remove player(s) from: ");
                  String teamPlayer = input.nextLine();
                  Team team = nba.findTeam(teamPlayer);
                  if (team == null) {
                     System.out.println("Team not found.");
                     System.out.println();
                     break;
                  }
                  System.out.println();
                  System.out.println(teamPlayer + " Roster: ");
                  team.printRoster();
                  System.out.println();
                  System.out.print("Enter the player name that you want to remove: ");
                  String removePlayer = input.nextLine();
                  while (team.findPlayer(removePlayer) == null) {
                     System.out.println();
                     System.out.println("Invalid Player");
                     System.out.print("Enter the player name that you want to remove: ");
                     removePlayer = input.nextLine();
                  }
                  team.removePlayer(removePlayer);
                  System.out.println();
                  System.out.println(removePlayer + " has been removed from the " + teamPlayer + ".");
                  break;
               }

               case 6: {
                  // Display available teams
                  System.out.println();
                  System.out.println("Teams in the league: ");
                  for (Team tm : nba.getTeams()) {
                     System.out.println(tm.getTeamName());
                  }
                  
                  System.out.println();
                  // Select the team trading a player
                  System.out.print("Enter the team name to trade player(s) from: ");
                  String fromTeamName = input.nextLine();
                  Team fromTeam = nba.findTeam(fromTeamName);
                  System.out.println();
                  while (fromTeam == null) {
                     System.out.println("Team not found.");
                     System.out.println("Would you like to try again? (Y/N) ");
                     String tryAgain = input.nextLine();
                     if (tryAgain.equalsIgnoreCase("Y")) {
                        System.out.print("Enter the team name to trade player(s) from: ");
                        fromTeamName = input.nextLine();
                        fromTeam = nba.findTeam(fromTeamName);
                     } else {
                        break;
                     }
                  }
                  if (fromTeam == null) {
                     break;
                  }
                  
                  System.out.println();
                  System.out.println(fromTeamName + "' " + "Roster: ");
                  fromTeam.printRoster();
                  
                  // Select the player to trade
                  System.out.println();
                  System.out.print("Enter the player name that you want to trade: ");
                  String tradePlayer = input.nextLine();
                  Player playerToTrade = fromTeam.findPlayer(tradePlayer);
                  while (playerToTrade == null) {
                     System.out.println("Player not found.");
                     System.out.println("Would you like to try again? (Y/N) ");
                     String tryAgain = input.nextLine();
                     if (tryAgain.equalsIgnoreCase("Y")) {
                        System.out.print("Enter the player that you want to trade: ");
                        tradePlayer = input.nextLine();
                        playerToTrade = fromTeam.findPlayer(tradePlayer);
                     } else {
                        break;
                     }
                  }
                  if (playerToTrade == null) {
                     break;
                  }
                  
                  // Select the team recieving the player
                  System.out.print("Enter the team name to trade " + tradePlayer + " to: ");
                  String toTeamName = input.nextLine();
                  Team toTeam = nba.findTeam(toTeamName);
                  while (toTeam == null) {
                     System.out.println("Team not found.");
                     System.out.println("Would you like to try again? (Y/N) ");
                     String tryAgain = input.nextLine();
                     if (tryAgain.equalsIgnoreCase("Y")) {
                        System.out.print("Enter the team name to trade the player(s) to: ");
                        toTeamName = input.nextLine();
                        toTeam = nba.findTeam(toTeamName);

                     } else {
                        break;
                     }
                  }
                  if (toTeam == null) {
                     break;
                  }

                  System.out.println();
                  System.out.println(toTeamName + "' " + "Roster: ");
                  toTeam.printRoster();
                  
                  // Select a player to receive in return
                  System.out.println();
                  System.out.println("Enter the player that you want to receive from " + toTeamName + ": ");
                  String receivePlayer = input.nextLine();
                  Player playerToReceive = toTeam.findPlayer(receivePlayer);
                  while (playerToReceive == null) {
                     System.out.println("Player not found.");
                     System.out.println("Would you like to try again? (Y/N) ");
                     String tryAgain = input.nextLine();
                     if (tryAgain.equalsIgnoreCase("Y")) {
                        System.out.print("Enter the player that you want to receive from " + toTeamName + ": ");
                        receivePlayer = input.nextLine();
                        playerToReceive = toTeam.findPlayer(receivePlayer);
                     } else {
                        break;
                     }
                  }
                  if (playerToReceive == null) {
                     break;
                  }
                  
                  // Complete the trade
                  fromTeam.tradePlayer(playerToTrade, toTeam);
                  toTeam.tradePlayer(playerToReceive, fromTeam);
                  System.out.println();
                  System.out.println("Trade completed: " );
                  System.out.println(playerToTrade.getName() + " --> " + toTeam.getTeamName());
                  System.out.println(playerToReceive.getName() + " --> " + fromTeam.getTeamName());
                  break;
               }

               case 7: {
                  // Simulate a game between two teams
                  System.out.println();
                  System.out.print("Enter the first team name to play a game: ");
                  String firstTeamName = input.nextLine();
                  Team firstTeam = nba.findTeam(firstTeamName);
                  System.out.println();
                  if (firstTeam == null) {
                     System.out.println("Team not found.");
                     break;
                  }
                  System.out.print("Enter the second team name to play a game: ");
                  String secondTeamName = input.nextLine();
                  Team secondTeam = nba.findTeam(secondTeamName);
                  System.out.println();
                  if (secondTeam == null) {
                     System.out.println("Team not found.");
                     break;
                  }
                  Game game = new Game(firstTeam, secondTeam);
                  game.playGame();
                  game.printScore();
                  System.out.println();
                  Team gameWinner = game.getWinner();
                  System.out.println("The winner is: " + gameWinner.getTeamName());
                  System.out.println();
                  break;
               }

            case 8: {
               // Display league standings
               System.out.println();
               System.out.println("League standings...");
               nba.printStandings();
               break;
            }

            case 9: {
               // Exit the program
               System.out.println();
               System.out.println("Thank you for using the Basketball Manager!");
               running = false;
               break;
            }
            }
        } 
       } else {
         System.out.println("Invalid. Enter a number.");
         input.nextLine();
        }
         System.out.println(); 
         if (running) {
            System.out.println();
            System.out.println("Press Enter to continue...");
            input.nextLine();
            System.out.println();
         }
       }

      input.close();
   } 
}