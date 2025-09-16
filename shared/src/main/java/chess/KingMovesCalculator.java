package chess;

import java.util.ArrayList;
import java.util.Collection;
import static chess.MovesCalculatorUtils.staticMoves;

public class KingMovesCalculator implements PieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> validMoves = new ArrayList<>();
        int directions[][] = {
                {1, 0},
                {-1, 0},
                {1, 1},
                {-1, -1},
                {1, -1},
                {-1, 1},
                {0, 1},
                {0, -1}
        };

        staticMoves(board, myPosition, directions, validMoves);
        return validMoves;
    }
}
