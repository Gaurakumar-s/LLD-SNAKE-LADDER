import java.util.Map;

class Board {
    private Map<Integer, IGameObject> jumps;

    public Board(Map<Integer, IGameObject> jumps) {
        this.jumps = jumps;
    }

    public int resolvePosition(int position) {
        while (jumps.containsKey(position)) {
            position = jumps.get(position).getEnd();
        }
        return position;
    }
}