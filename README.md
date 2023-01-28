# A1 - Piraten Karpen

  * Author: Gayan Athukorala
  * Email: athukorg@mcmaster.ca

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

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * A feature is done when it functions as intended, and is correctly implemented in the code, not causing errors or issues with existing features/code

### Backlog 

| MVP? | Id  |                       Feature                       | Status | Started  | Delivered |
|:----:|:---:|:---------------------------------------------------:|:------:|:--------:|:---------:|
|  x   | F01 |                     Roll a dice                     |   D    | 01/01/23 | 01/01/23  |
|  x   | F02 |                  Roll eight dices                   |   D    | 01/01/24 | 01/01/24  |
|  x   | F03 |         Turn ends when player gets 3 skulls         |   D    | 01/01/24 | 01/01/25  |
|  x   | F04 |       Player randomly chooses dice to re-roll       |   D    | 01/01/24 | 01/01/25  |
|  x   | F05 | Dice that roll a skull are not able to be re-rolled |   D    | 01/01/25 | 01/01/25  |
|  x   | F06 |                  Create 2 players                   |   D    | 01/01/25 | 01/01/26  |
|  x   | F07 |   Calculate Score based on Gold and Diamonds only   |   D    | 01/01/26 | 01/01/26  |
|  x   | F08 |            Player re-rolls multiple dice            |   D    | 01/01/26 | 01/01/27  |
|  x   | F09 |               Game is played 42 times               |   D    | 01/01/26 | 01/01/27  |
|  x   | F10 |         Display each players win percentage         |   D    | 01/01/26 | 01/01/27  |
|  x   | F11 |         Rounds win percentage to 2 decimals         |   D    | 01/01/27 | 01/01/27  |
|  x   | F12 |  Player Randomly chooses whether they will re-roll  |   D    | 01/01/28 | 01/01/28  |
|  x   | F13 |   Player wins a game when they reach 6000 points    |   D    | 01/01/27 | 01/01/28  |

