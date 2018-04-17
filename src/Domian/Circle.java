/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domian;

/**
 *
 * @author Arturo
 */
public class Circle {
   private int row;
    private int column;
    private int width;
    private int height;

    public Circle() {
        this.row = 0;
        this.column = 0;
        this.width = 0;
        this.height = 0;
    }

    public void setRow(int laFila) {
        row = laFila;
    }

    public void setColumn(int laColumna) {
        column = laColumna;
    }

    public void setWidth(int elAncho) {
        width = elAncho;
    }

    public void setHeight(int elAlto) {
        height = elAlto;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
  

