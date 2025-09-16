package chess;

import java.util.ArrayList;
import java.util.Collection;
import static chess.MovesCalculatorUtils.slidingMoves;

public class BishopMovesCalculator implements PieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> validMoves = new ArrayList<>();
        int directions[][] = {
                { 1,  1},
                { 1, -1},
                {-1, -1},
                {-1,  1},
        };

        slidingMoves(board, myPosition, directions, validMoves);
        return validMoves;
    }
}
