# Basketball Manager
A Java command-line application that simulates managing a basketball league. Users can create teams, manage rosters, trade players, simulate games, and view league standings.

# Features
- View all teams in the league
- Create new teams and build rosters
- View team rosters and player stats
- Add and remove players
- Trade players between teams
- Simulate games between teams
- Track player points per game (PPG)
- Track team wins and losses
- View league standing sorted by wins
- Input validation for menu selections, teams, players, and positions

# Starting Teams
The program starts with two preloaded teams:
- Warriors
- Lakers

This is so the program's features can be tested immediately.

# How it works
When the program starts, the user is presented with a menu:
1. View Teams
2. Add Team
3. View Teams Roster
4. Add Player(s)
5. Remove Player
6. Trade Player
7. Play Game
8. View Standings
9. Exit
The program continues running until the user chooses to exit.

# Project Structure
- basketballManager.java, runs the main menu and handles user
  interaction
- Player.java, stores player information and season statistics
- Team.java, manages team rosters and win/loss records
- Game.java, simulates games and updates player/team statistics
- League.java, manages teams and league standings

# Concepts Used
- Object-Oriented Programming
- Classes and objects
- Constructors
- ArrayLists
- Loops and conditionals
- Methods
- User input with Scanner
- Input validation
- Random number generation
- Comparators and sorting
- Object relationships
- Multiple teams
- Season Standings
- Save and load data from files
