# pigbattle
Project from PRO1
This is a simulator that puts different strategies of playing pig up against each other, see: [https://en.wikipedia.org/wiki/Pig_(dice_game)](https://en.wikipedia.org/wiki/Pig_%28dice_game%29)

### Run
Eclipse project

To run in from a console:

```
javac -d bin src/module-info.java src/dk/ninjabear/pigbattle/PigApp.java
java -p bin/ -m dk.ninjabear.pigbattle/dk.ninjabear.pigbattle.PigApp
```

### Optimal strategy
The optimal strategy used in `ComputerPlayer_Optimal.java` is not trivial and is implemented from: [http://cs.gettysburg.edu/~tneller/nsf/pig/](http://cs.gettysburg.edu/~tneller/nsf/pig/)