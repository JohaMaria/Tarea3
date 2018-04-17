/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * http://galia.fc.uaslp.mx/~medellin/Applets/LineasRectas/Recta.htm
 * http://technogy-2012.blogspot.com/2012/05/blog-post.html
 * https://es.wikihow.com/hacer-funciones-lineales
 *
 * @author monge55
 */
public class TareaLinea extends JPanel {

    public TareaLinea() {
        this.setPreferredSize(new Dimension(1500, 700));
    } // constructor


    private void draw(Graphics g) throws InterruptedException {

        g.setColor(Color.cyan);
        g.setColor(Color.GREEN);
        linearFunction(g);

    } // draw

    //Método que pinta N cantidad de lineas en diferentes posiciones utilizando un random
    public void linearFunction(Graphics g) {
        int i = 0;
        //pinta 1000 lineas aleatoriamente
        while (i <= 1000) {
            int x0 = (int) ((Math.random() * 1450) + 1);
            int y0 = (int) ((Math.random() * 1450) + 1);

            int x1 = (int) ((Math.random() * 1450) + 1);
            int y1 = (int) ((Math.random() * 1450) + 1);
//            System.out.println(x0 + " " + x1 + " " + y0 + " " + y1);

            int x, y, dx, dy, p, incE, incNE, stepx, stepy;
            dx = (x1 - x0);
            dy = (y1 - y0);

            /* determinar que punto usar para empezar, cual para terminar */
            if (dy < 0) {
                dy = -dy;
                stepy = -1;
            } else {
                stepy = 1;
            }

            if (dx < 0) {
                dx = -dx;
                stepx = -1;
            } else {
                stepx = 1;
            }

            x = x0;
            y = y0;
            g.drawLine(x0, y0, x0, y0);
            /* se cicla hasta llegar al extremo de la línea */
            if (dx > dy) {
                p = 2 * dy - dx;
                incE = 2 * dy;
                incNE = 2 * (dy - dx);
                while (x != x1) {
                    x = x + stepx;
                    if (p < 0) {
                        p = p + incE;
                    } else {
                        y = y + stepy;
                        p = p + incNE;
                    }
                    g.drawLine(x, y, x, y);
                }
            } else {
                p = 2 * dx - dy;
                incE = 2 * dx;
                incNE = 2 * (dx - dy);
                while (y != y1) {
                    y = y + stepy;
                    if (p < 0) {
                        p = p + incE;
                    } else {
                        x = x + stepx;
                        p = p + incNE;
                    }

                    g.drawLine(x, y, x, y);

                }
            }
            i++;
        }
    }

    private double coord_x(double x) {
        return x;
    }

    private double coord_y(double y) {
        double real_y = (double) this.getHeight() - y;
        return real_y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            // se llama al meto draw
            draw(g);
        } catch (InterruptedException ex) {
            Logger.getLogger(TareaLinea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Graphing Function");
        window.setContentPane(new TareaLinea());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.pack();
        window.setResizable(false);
        window.setLocation(150, 100);
        window.setVisible(true);
    }

} // fin clase

