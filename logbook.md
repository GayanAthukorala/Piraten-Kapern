# LOGBOOK
## 01/01/24
- Allowed user to roll 8 dies, added this feature to the main file for now, but I have plans to move it to its own file later/

## 01/01/25
- User can now re-roll dice randomly, with their turn ending when they have rolled 3 skulls
- Dice that roll skulls are not able to be rerolled

## 01/01/26
- Created a player class and moved the turns features into that class
- Calculated player's turn score based on Gold and Diamonds only

## 01/01/27
- Player rolls at least 2 dice when they re-roll, to adhere to the game rules
- There are 42 games played and each player's win percentage is displayed at the end

## 01/01/28
- Player randomly chooses if they will be re-rolling or not
- Player's scores get continually added after each turn
- Players go back and forth taking turns until one or both reach a score of 6000
- Created a release for my MVP and then went back and paid technical debt by refining and cleaning up my code
- Implemented trace mode to have debug outputs that can be hidden 
- Improved the score method to now calculate combos as well

## 01/01/29
- Created a new strategy where the player tries to get combos
- User can now choose which strategy they want each player to be using, through command line arguments 