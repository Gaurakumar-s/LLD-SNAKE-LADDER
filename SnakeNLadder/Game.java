import java.util.*;

class Game {
    private Queue<Player> players;
    private Board board;
    private Dice dice;
    private IMakeMoveStrategy strategy;
    private List<Player> winners;
    private int boardSize;

    public Game(List<Player> playersList, Board board, int boardSize) {
        this.players = new LinkedList<>(playersList);
        this.board = board;
        this.dice = new Dice();
        this.strategy = new BasicMoveStrategy();
        this.winners = new ArrayList<>();
        this.boardSize = boardSize;
    }

    public void startGame() {
        while (players.size() > 1) {
            Player player = players.poll();
            playTurn(player);

            if (player.getPosition() == boardSize) {
                System.out.println(player.getId() + " wins!");
                winners.add(player);
            } else {
                players.offer(player);
            }
        }

        System.out.println("Game Over");
    }

    private void playTurn(Player player) {
        int diceRoll = dice.roll();
        System.out.println(player.getId() + " rolled: " + diceRoll);

        int newPosition = strategy.makeMove(player.getPosition(), diceRoll, boardSize);
        newPosition = board.resolvePosition(newPosition);

        player.setPosition(newPosition);
        System.out.println(player.getId() + " moved to: " + newPosition);
    }
}