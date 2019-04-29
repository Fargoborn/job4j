package ru.job4j.chess.figures.black;

import ru.job4j.chess.Board;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int size;
        Board board = new Board();
        Cell steps[] = new Cell[0];
        try {
            if (board.move(source, dest)) {
                size = Math.abs(source.x - dest.x);
                int deltaX = source.x > dest.x ? -1 : 1;
                int deltaY = source.y > dest.y ? -1 : 1;
                steps = new Cell[size];
                for (int i = 0; i < size; i++) {
                    int x = source.x + (i + 1) * deltaX;
                    int y = source.y + (i + 1) * deltaY;
                    steps[i] = Cell.values()[8 * x + y];
                }
            }
        } catch (Exception e) {}
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
