# Snake & Ladder Game — Design & Implementation

## Overview

This project implements the classic **Snake & Ladder game** using clean object-oriented design principles.
The system is designed to be **extensible, modular, and easy to maintain**, following SOLID principles and common design patterns.

---

## Requirements Covered

* Board of size `n x n`
* Random placement of `n` snakes and `n` ladders
* Multiple players
* Turn-based gameplay using a dice
* Snake → move down
* Ladder → move up
* Game ends when only one player remains

---

## High-Level Design

The system is divided into the following core components:

### 1. Game

* Orchestrates gameplay
* Manages player turns (Queue)
* Uses Dice and Strategy
* Determines winners

---

### 2. Board

* Stores all snakes and ladders
* Responsible for resolving player position
* Uses a `Map<Integer, GameObjectInterface>` for O(1) lookup

---

### 3. Player

* Represents each player
* Maintains current position

---

### 4. GameObjectInterface

* Common abstraction for Snake and Ladder
* Provides:

  * `getStart()`
  * `getEnd()`

---

### 5. Snake & Ladder

* Implement `GameObjectInterface`
* Represent jumps on the board

---

### 6. Dice

* Generates random values between 1–6

---

### 7. IMakeMoveStrategy (Strategy Pattern)

* Encapsulates movement rules
* Example: BasicMoveStrategy

---

### 8. BoardFactory (Factory Pattern)

* Creates the board
* Uses generation strategies

---

### 9. SnakeGenStrategy & LadderGenStrategy

* Generate snakes and ladders
* Allow different difficulty levels

---

## Design Patterns Used

### Strategy Pattern

Used in:

* Move Strategy (`IMakeMoveStrategy`)
* Snake & Ladder Generation

**Why?**

* Allows flexible rule changes
* Supports multiple game modes (easy, hard, etc.)

---

### Factory Pattern

Used in:

* `BoardFactory`
* `GameFactory`

**Why?**

* Encapsulates object creation
* Keeps initialization logic clean

---

### Dependency Injection

* Strategies are passed into factories
* Avoids tight coupling

---

## UML Diagram

```
+---------------------+
|        Game         |
+---------------------+
| - players: Queue    |
| - board: Board      |
| - dice: Dice        |
| - strategy: IMakeMoveStrategy |
| - winners: List     |
+---------------------+
| + startGame()       |
| + playTurn()        |
+---------------------+

          |
          v

+---------------------+
|       Board         |
+---------------------+
| - jumps: Map<int, GameObjectInterface> |
+---------------------+
| + resolvePosition(int pos): int        |
+---------------------+

          |
          v

+-----------------------------+
|   GameObjectInterface       |
+-----------------------------+
| + getStart(): int           |
| + getEnd(): int             |
+-----------------------------+
        /        \
       /          \
+-----------+   +-----------+
|   Snake   |   |  Ladder   |
+-----------+   +-----------+

+---------------------+
|       Player        |
+---------------------+
| - id: String        |
| - position: int     |
+---------------------+

+---------------------+
|        Dice         |
+---------------------+
| + roll(): int       |
+---------------------+

+-------------------------------+
|     IMakeMoveStrategy         |
+-------------------------------+
| + makeMove(pos, dice): int    |
+-------------------------------+

+-------------------------------+
|   BasicMoveStrategy           |
+-------------------------------+

+-------------------------------+
|       BoardFactory            |
+-------------------------------+
| + createBoard(): Board        |
+-------------------------------+

+-------------------------------+
|   SnakeGenStrategy            |
+-------------------------------+

+-------------------------------+
|   LadderGenStrategy           |
+-------------------------------+
```

---

## Game Flow

1. Players are added to a queue
2. Each player rolls the dice
3. Strategy calculates next position
4. Board resolves:

   * Snake → move down
   * Ladder → move up
5. Player position updated
6. If player reaches final cell → wins
7. Game continues until only one player remains

---

## Key Design Decisions

### Map for Board Storage

* `Map<start, GameObject>`
* Ensures O(1) lookup

---

### Board Handles Movement Resolution

* Keeps Game class clean
* Centralizes logic

---

### Strategy for Flexibility

* Easily extend rules without modifying Game

---

### Factory for Object Creation

* Clean separation of initialization logic

---

## How to Compile and Run

1. Navigate to the `SnakeNLadder` directory:
   ```bash
   cd SnakeNLadder
   ```

2. Compile all the Java files:
   ```bash
   javac *.java
   ```

3. Run the Main class:
   ```bash
   java Main
   ``
