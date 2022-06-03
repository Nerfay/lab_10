package com.example.lab_10;

public class Prism extends Square {
    private int h;

    public int getHeight() {
        return h;
    }

    public void setHeight(int h) {
        if (h > 0) {
            this.h = h;
        } else {
            this.h = 1;
        }
    }

    public Prism(int side, int h) {
        super(side);
        this.setHeight(h);
    }

    public float getSquareOfSide (){
        return  (super.getPerimeter()*h);
    }

    public float getSqureOfPrism() {
        return  (getSquareOfSide() + (2 * super.getSquareOfSquare()));
    }

    public float getVolume() {
        return (super.getSquareOfSquare()*h);
    }

    public float getDiagonal(){
        return (float) ((h*h)+(super.getD()*super.getD()));
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Height= " + this.getHeight() +
                ", SquareOfPrism= " + this.getSqureOfPrism() +
                ", Volume= " + this.getVolume()+
                ", DiagonalOfPrism=" + this.getDiagonal() ;
    }
}
