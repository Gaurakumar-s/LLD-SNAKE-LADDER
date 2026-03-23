import java.util.*;

interface LadderGenStrategy {
    List<Ladder> generate(int boardSize, int numberOfLadders, Set<Integer> used);
}