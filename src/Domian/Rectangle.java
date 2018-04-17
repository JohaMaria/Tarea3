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
public class Rectangle {
  private int row;
    private int column;
    private int width;
    private int height;

    public Rectangle() {
        this.row = 0;
        this.column = 0;
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int row, int column, int width, int height) {
        this.row = row;
        this.column = column;
        this.width = width;
        this.height = height;
    }
    
    
    

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

