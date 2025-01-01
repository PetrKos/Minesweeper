package org.minesweeper;

import javax.swing.*;
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

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        Container contentPane = jFrame.getContentPane();
        var test = new JPanel() {
            public void paintComponent(Graphics graphics) {
                graphics.drawImage(new Flag().scale(10), 0, 0, null);
            }
        };
        jFrame.setContentPane(test);
        jFrame.setPreferredSize(new Dimension(200,200));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }



}
