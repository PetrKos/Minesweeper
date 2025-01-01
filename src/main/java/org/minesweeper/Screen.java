package org.minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Screen extends JPanel implements MouseListener, MouseMotionListener {

    private final BufferedImage mine, flag;
    Tiles tiles;
    private final int BASE_SIZE = 13, scale;

    private int x, y, fieldX, fieldY;


    public Screen(int x, int y, int scale) {
        this.scale = scale;
        this.x = x;
        this.y = y;
        this.tiles = new Tiles(x, y, 0.2);
        Dimension dimension = new Dimension(
                (x * BASE_SIZE * scale),
                (y * BASE_SIZE * scale));
        this.setPreferredSize(dimension);
        this.mine = new Mine().scale(scale);
        this.flag = new Flag().scale(scale);
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int scale = BASE_SIZE * this.scale;
        for (int x = 0; x < tiles.getWidth(); x++) {
            for (int y = 0; y < tiles.getHeight(); y++) {
                int positionX = x * scale;
                int positionY = y * scale;
                Tile tile = tiles.getTile(x, y);

                if (!tile.isRevealed()) {
                    g.setColor(Theme.TILE);
                    g.fillRect(positionX, positionY, scale, scale);
                    g.setColor(Theme.WHITE);
                    g.drawLine(positionX, positionY, positionX + scale - this.scale, positionY);
                    g.drawLine(positionX, positionY, positionX, positionY + scale - this.scale);
                    g.setColor(Theme.TILE_SHADOW);
                    g.drawLine(positionX + this.scale, positionY + scale - 1, positionX + scale, positionY + scale - 1);
                    g.drawLine(positionX + scale - 1, positionY + this.scale, positionX + scale - 1, positionY + scale);
                } else {
                    if (tile.isMine()) {
                        g.drawImage(mine, positionX, positionY, null);
                    } else {

                        g.setColor(Theme.TILE_SHADOW);
                        g.fillRect(positionX, positionY, scale, scale);
                    }
                }

            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.fieldX = (int) Math.floor(((double) e.getX() / scale) / x);
        this.fieldY = (int) Math.floor(((double) e.getY() / scale) / y);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Tile tile = tiles.getTile(fieldX, fieldY);
        switch (e.getButton()) {
            case 1:
                tile.setRevealed(true);
                break;
            case 3:
                tile.setState(TileState.FLAG);
                break;
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
