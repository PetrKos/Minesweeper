package org.minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mine extends Scalable {

    public Mine() {
        super(12, 12, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = getGraphics();
        graphics.setColor(Theme.EIGHT);
        graphics.fillRect(0,0,getWidth(), getHeight());
        graphics.setColor(Theme.BLACK);
        graphics.drawLine(2, 2, 10, 10);
        graphics.drawLine(2,10,10,2);
        graphics.drawLine(6,1,6,11);
        graphics.drawLine(1,6,11,6);
        graphics.drawRect(4,4,4,4);
        graphics.fillRect(2, 4, 9, 5);
        graphics.fillRect(4, 2, 5, 9);
        graphics.setColor(Theme.WHITE);
        graphics.fillRect(4, 4,2,2);
//        graphics.drawLine(6, 1,6,5);
//        graphics.fillRect(3, 2,2,3);
//        graphics.drawLine(2, 3,2,3);
    }

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        Container contentPane = jFrame.getContentPane();
        var test = new JPanel() {
            public void paintComponent(Graphics graphics) {
                graphics.drawImage(new Mine().scale(10), 0, 0, null);
            }
        };
        jFrame.setContentPane(test);
        jFrame.setPreferredSize(new Dimension(200,200));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }


}
