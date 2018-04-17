/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea3;

import Domian.Circle;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Arturo
 */
public class tarea3 extends JFrame {

    private Rectangle rect;
    private int x;
    private int y;
    private int xx;
    private int yy;
    private int dir;
    private int dir2;
    private Thread t;
    private boolean running;
    private Circle myCircle;
    private Rectangle myRectangle;
    tarea3() {

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rect = getBounds(); // Para obtener las medidas del JFrame
        pantalla p = new pantalla((int) rect.width, (int) rect.height);
        getContentPane().add(p);
        pack();
        setVisible(true);
        p.start();
    }

   
    public static void main(String args[]) {
        new tarea3();
    }

    /* Deaclaracion de las Variables locales de esta clase */
    class pantalla extends Canvas implements Runnable {

        /* Constructor de pantalla */
        pantalla(int x, int y) {
            setSize(x, y);

            rect = getBounds();
        }

        public void paint(Graphics g) {
            g.setColor(Color.blue);
            g.fillOval(x, y, 20, 20);

        }

        public void paintRec(Graphics g) {
            
            g.setColor(Color.PINK);
            g.fillRect(xx, yy, 20, 20);
        }

        public void run() {//metodo que verifica la posicion del Dir para ir sumando o restando direccion, tambien rebota.
            try {
                while (running) {
                    if (dir == 1) {
                        x--;
                        y--;
                        if (x == 0) {
                            dir = 2;
                        }
                        if (y == 0) {
                            dir = 4;
                        }
                    }
                    if (dir == 2) {
                        x++;
                        y--;
                        if (x == (rect.width - 12)) 
                        {
                            dir = 1;
                        }
                        if (y == 0) {
                            dir = 3;
                        }
                    }
                    if (dir == 3) {
                        x++;
                        y++;
                        if (x == (rect.width - 12)) {
                            dir = 4;
                        }
                        if (y == (rect.height - 12)) {
                            dir = 2;
                        }
                    }
                    if (dir == 4) {
                        x--;
                        y++;
                        if (x == 0) {
                            dir = 3;
                        }
                        if (y == (rect.height - 12)) {
                            dir = 1;
                        }
                    }
                    if (dir2 == 1) {
                        xx--;
                        yy--;
                        if (xx == 0) {
                            dir2 = 2;
                        }
                        if (yy == 0) {
                            dir2 = 4;
                        }
                    }
                    if (dir2 == 2) {
                        xx++;
                        yy--;
                        if (xx == (rect.width - 12)) // Es menos 12 por el diametro de la pelotita
                        {
                            dir2 = 1;
                        }
                        if (yy == 0) {
                            dir2 = 3;
                        }
                    }
                    if (dir2 == 3) {
                        xx++;
                        yy++;
                        if (xx == (rect.width - 12)) {
                            dir2 = 4;
                        }
                        if (yy == (rect.height - 12)) {
                            dir2 = 2;
                        }
                    }
                    if (dir2 == 4) {
                        xx--;
                        yy++;
                        if (xx == 0) {
                            dir2 = 1;
                        }
                        if (yy == (rect.height - 12)) {
                            dir2 = 1;
                        }
                    }

                    //   System.out.println(" -> " + x + " " + y + " " + dir);
                    repaint();
                    t.sleep(5);
                }
            } catch (InterruptedException e) {
                running = false;
            }
        }

        public void start() {
            if (t == null) {
                x = getPointsX();
                y = getPointsY();
                xx = getPointsXX();
                yy = getPointsYY();
                
                dir = dir();
                dir2 = dir();
                running = true;
                t = new Thread(this);
                t.start();
            }
        }

        public void update(Graphics g) {

            rect = getBounds();
            Image image = createImage(rect.width, rect.height);
            Graphics gi = image.getGraphics();
            gi.clearRect(0, 0, rect.width, rect.height);
            paint(gi);
            paintRec(gi);
            g.drawImage(image, 0, 0, null);

        }

        /* Metodo que da la coordenada X inicial */
        private int getPointsX() {
            int num;
            do {
                num = (int) Math.round(Math.random() * 10000);
            } while (num >= rect.width - 12);
            return num;
        }

       // da la primera posicion de x y al circulo y xx yy al cuadrado
        private int getPointsY() {
            int num;
            do {
                num = (int) Math.round(Math.random() * 10000);
            } while (num >= rect.height - 12);
            return num;
        }

        private int getPointsXX() {
            int num;
            do {
                num = (int) Math.round(Math.random() * 10000);
            } while (num >= rect.width - 12);
            return num;
        }

        /* Metodo que da la coordenada YY inicial del cuadrado*/
        private int getPointsYY() {
            int num;
            do {
                num = (int) Math.round(Math.random() * 10000);
            } while (num >= rect.height - 12);
            return num;
        }

        /* Metodo que da la direccion inicial del cuadrado y circulo */
        private int dir() {
            int num;
            do {
                num = (int) Math.round(Math.random() * 10);
            } while ((num > 4) || (num == 0));
            return num;
        }

        
    }
}
