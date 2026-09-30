# Higher / Lower Card Game

A console card game where you guess whether the next card will be higher or lower.

## Features

- Shuffled 13-rank deck each round
- Score tracking with persistent high score
- Tie ranks count as a free pass
- Play-again loop

## Run

```bash
javac -d out $(find src -name "*.java")
java -cp out griffith.CardGame
```

## Structure

```
src/griffith/
  CardGame.java   # game loop
  Deck.java       # shuffle + draw
  Card.java       # rank display names
  HighScore.java  # persistent best score
Game_Manual.docx
```

## Author

Hardik Rathee (Hardik-4)
