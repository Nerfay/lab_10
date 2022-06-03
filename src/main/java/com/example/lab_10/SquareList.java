package com.example.lab_10;

import java.util.ArrayList;
import java.util.List;

public class SquareList {
    private final List<Square> squares;

    public SquareList() {
        squares = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Squares " + squares;
    }

    public boolean add(Square square) {
        return squares.add(square);
    }

    public void remove(int number) {
        if (number < squares.size())
            squares.remove(number);
    }

    public void remove(Square square) {
        squares.remove(square);
    }
    public float getMaxSquare() {
        float maxSquare = 0;
        for (Square square : squares) {
            if(square.getSquareOfSquare()> maxSquare) {
                maxSquare = square.getSquareOfSquare();
            }
        }
        return maxSquare;
    }
}
