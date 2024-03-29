# A1 - Piraten Karpen

  * Author: Gayan Athukorala
  * Email: gayan42004@gmail.com

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
  * Trace Mode
    * To enable Trace mode change `"ERROR` in `Configurator.setAllLevels(loggerConfig.getName(), Level.getLevel("ERROR"));`, which is at the top of every method that uses trace, to `"TRACE`



## Decisions and Assumptions for Unspecified Details
* If both players get above 6000 points on a turn, it is considered a tie, and neither get a point added to their win count
* When the player's strategy is random, there is a 50% chance they will choose not to roll and end their turn, and a 50% chance they will randomly re-roll
* For the combo strategy, the player does not re-roll any gold or diamond dice, and will stop re-rolling once they get a combo of over 3, or get 3 or more skulls

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * A feature is done when it functions as intended, and is correctly implemented in the code, not causing errors or issues with existing features/code

### Backlog 

| MVP? | Id  |                              Feature                               | Status |  Started   | Delivered |
|:----:|:---:|:------------------------------------------------------------------:|:------:|:----------:|:---------:|
|  x   | F01 |                            Roll a dice                             |   D    |  01/01/23  | 01/01/23  |
|  x   | F02 |                          Roll eight dices                          |   D    |  01/01/24  | 01/01/24  |
|  x   | F03 |                Turn ends when player gets 3 skulls                 |   D    |  01/01/24  | 01/01/25  |
|  x   | F04 |              Player randomly chooses dice to re-roll               |   D    |  01/01/24  | 01/01/25  |
|  x   | F05 |        Dice that roll a skull are not able to be re-rolled         |   D    |  01/01/25  | 01/01/25  |
|  x   | F06 |                          Create 2 players                          |   D    |  01/01/25  | 01/01/26  |
|  x   | F07 |          Calculate Score based on Gold and Diamonds only           |   D    |  01/01/26  | 01/01/26  |
|  x   | F08 |                   Player re-rolls multiple dice                    |   D    |  01/01/26  | 01/01/27  |
|  x   | F09 |                      Game is played 42 times                       |   D    |  01/01/26  | 01/01/27  |
|  x   | F10 |                Display each players win percentage                 |   D    |  01/01/26  | 01/01/27  |
|  x   | F11 |                Rounds win percentage to 2 decimals                 |   D    |  01/01/27  | 01/01/27  |
|  x   | F12 |         Player Randomly chooses whether they will re-roll          |   D    |  01/01/28  | 01/01/28  |
|  x   | F13 |           Player wins a game when they reach 6000 points           |   D    |  01/01/28  | 01/01/28  |
|  x   | F14 |           Player tries to maximize combos as a strategy            |   D    |  01/01/28  | 01/01/29  |
|  x   | F15 | User is able to select which strategy they want the players to use |   D    |  01/01/29  | 01/01/29  |
|  x   | F16 |           Calculate each player's score including combos           |   D    |  01/01/29  | 01/01/29  |
|  x   | F17 |               Add cards that the user can draw from                |   D    |  01/01/29  | 01/01/29  |
|  x   | F18 |        New player strategy if they draw the Sea Battle card        |   D    |  01/01/29  | 01/01/29  |
|  x   | F19 |               Add monkey business card to card deck                |   D    |  01/01/29  | 01/01/29  |
|  x   | F20 |       Create new scoring method for the monkey business card       |   D    |  01/01/29  | 01/01/29  |

