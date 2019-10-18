# Dices
## Observer pattern
Write a program to play a simple dice game with a number of players:<br/>
Three players take turns throwing two dice. There are four turns. Per roll, calculate the player's score as follows:<br/>
The score of a player is equal to the sum of the eyes of the dice thrown. If one player throws the same number of pips per die, his score is equal to the sum of the the score times two (example 2 times a three throw gives as score (3+3)*2 = 12). If the sum of the thrown eyes of the player is equal to the sum of the thrown eyes of that player player in the previous turn, he gets 5 extra points.<br/>
The player with the highest score after a turn is the winner of that turn. The player with the highest total score after four turns wins the game.<br/><br/>

We provide a separate screen (Stage) for each player with in the title bar "player" + serial number. On the screen is a button with the text "Throw dice", a label with the outcome of the throw and the score achieved in that turn (e.g.: turn 3: 4 and 4 - score: 16).<br/>
This text (result throw and score) is also shown on the screens of the other players. Example player 2 throws two times four. On the screens of players 1 and 3 the text "Player 2 throws 4 and 4 - score 16" appears.<br/>
The screens of three players are drawn next to each other. Only the button of the player who is is next in line to throw is enabled.<br/><br/>

In addition to the 3 player screens, there is also a score screen (separate Stage).<br/>
After each turn, the text on the score screen is updated as follows: added a line containing the turn number, the player numbers and their total score that turn.<br/>
Example after 2 turns:<br/>
Turn 1: sp1: 4 sp2: 5 sp3: 8<br/>
Turn 2: sp1:16 sp2:11 sp3:17<br/>

#### Points of attention:
* Use JavaFX for the view section. In startcodeDobbelspel.zip you will find the simple javaFX code that draws 3 player windows and 1 score window. Continue working on this code;
* Provide model classes
* Use the Observer pattern to display the different screens at the right time (updated). You have the choice to use the Java observer classes or you can do it yourself.
