package org.minesweeper;

public class Tile {
    private TileState state = TileState.UNKNOWN;
    private boolean mine;

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    private boolean revealed;

    private int total;


    public void setState(TileState state) {
        this.state = state;
    }

    public TileState getState() {
        return state;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void setSurrounding(int total) {
        this.total = total;
    }

    public boolean isRevealed() {
        return revealed;
    }
}
