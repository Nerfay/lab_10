package com.example.lab_10;

public class Square {
    protected int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        if (side > 0) {
            this.side = side;
        } else {
            this.side = 1;
        }
    }

    public int getPerimeter() {
        return side * 4;
    }

    public float getSquareOfSquare() {
        return side * side;
    }

    public double getD() {
        return side * Math.sqrt(2);
    }

    @Override
    public String toString() {
        return this.getClass().getName().split("\\.")[1] +
                ": side= " + this.getSide() +
                ", Perimeter= " + this.getPerimeter() +
                ", Square= " + this.getSquareOfSquare() +
                ", Diagonal= " + this.getD();
    }
}
