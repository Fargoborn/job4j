package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;

public abstract class Figure {
    public final Cell position;

    protected Figure(Cell position) {
        this.position = position;
    }
}
