package com.example.lab_10;

import java.util.ArrayList;
import java.util.List;

public class PrismList {
    private final List<Prism> prisms;

    public PrismList() {
        prisms = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Prisms " + prisms;
    }

    public boolean add(Prism prism) {
        return prisms.add(prism);
    }

    public void remove(int number) {
        if (number < prisms.size())
            prisms.remove(number);
    }

    public void remove(Prism prism) {
        prisms.remove(prism);
    }
    public float getMaxDiagonal() {
        float maxDiagonal = 0;
        for (Prism prism : prisms) {
            if(prism.getDiagonal()>maxDiagonal) {
                maxDiagonal = prism.getDiagonal();
            }
        }
        return maxDiagonal;
    }
}