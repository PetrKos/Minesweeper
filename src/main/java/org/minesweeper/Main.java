package org.minesweeper;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setTitle("Minesweeper");
        jFrame.setContentPane(new Screen(20, 20, 3));
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);



//        Container contentPane = jFrame.getContentPane();
//        var test = new JPanel() {
//            public void paintComponent(Graphics graphics) {
//                graphics.drawImage(new Flag().scale(10), 0, 0, null);
//            }
//        };
//        jFrame.setContentPane(test);
//        jFrame.setPreferredSize(new Dimension(200,200));
//        jFrame.pack();
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setVisible(true);
    }
}