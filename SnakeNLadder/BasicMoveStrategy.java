class BasicMoveStrategy implements IMakeMoveStrategy {

    public int makeMove(int currentPosition, int diceRoll, int boardSize) {
        int newPosition = currentPosition + diceRoll;

        if (newPosition > boardSize) {
            return currentPosition;
        }

        return newPosition;
    }
}