package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.figures.*;

public class Board {

    private Figure[] figures = new Figure[32];
    public void add(Figure figure) {
    }

    /**
     *Проверка диагонали
     */
    public static boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y));
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean move = true;
        if (!Board.isDiagonal(source, dest)) {
            move = false;
            throw new ImpossibleMoveException("Вы не можете перемещать фигуру по этому пути.");
        }

        return move;
    }
}
