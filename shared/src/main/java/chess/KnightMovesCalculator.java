package chess;

import java.util.ArrayList;
import java.util.Collection;
import static chess.MovesCalculatorUtils.staticMoves;

public class KnightMovesCalculator implements PieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> validMoves = new ArrayList<>();
        int directions[][] = {
                {2, 1},
                {2, -1},
                {1, 2},
                {1, -2},
                {-1, 2},
                {-1, -2},
                {-2, 1},
                {-2, -1}
        };

        staticMoves(board, myPosition, directions, validMoves);
        return validMoves;
    }
}
