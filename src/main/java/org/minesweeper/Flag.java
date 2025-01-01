package org.minesweeper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Flag extends Scalable {
    public Flag() {
        super(12, 12, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = getGraphics();
        graphics.setColor(Theme.EIGHT);
        graphics.fillRect(0,0,getWidth(), getHeight());
        graphics.setColor(Theme.BLACK);
        graphics.drawLine(6, 6, 6, 9);
        graphics.fillRect(4, 8, 4, 2);
        graphics.fillRect(2, 9, 8, 2);
        graphics.setColor(Theme.RED);
        graphics.drawLine(6, 1,6,5);
        graphics.fillRect(5, 1,2,5);
        graphics.fillRect(3, 2,2,3);
        graphics.drawLine(2, 3,2,3);
    }
}
