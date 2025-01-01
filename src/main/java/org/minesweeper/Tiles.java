package org.minesweeper;

import java.util.Random;

public class Tiles {

    private static final Random random = new Random();

    private Tile[][] tiles;

    private int width, height, mines;
    private double chance;

    public Tiles(int x, int y, double probability) {
        this.width = x;
        this.height = y;
        this.chance = probability;
        this.tiles = new Tile[x][y];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
        int mines = (int) ((width * height) * probability);
        do {
            int mineX = random.nextInt(x);
            int mineY = random.nextInt(y);
            Tile tile = tiles[mineX][mineY];
            if (tile.isMine()) continue;
            mines--;
            tile.setMine(true);
        } while (mines > 0);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Tile tile = tiles[i][j];
                int total = 0;
                for (int k = i - 1; k < i + 2; ++k) {
                    for (int l = j - 1; l < j+2; ++l) {
                            if(k>0 && l >=0 && k < width && l < height) {
                                Tile target = tiles[k][l];
                                if(!target.isMine()) continue;
                                total++;
                            }

                    }
                    
                }
                tile.setSurrounding(total);
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
