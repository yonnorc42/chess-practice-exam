package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMovesCalculator implements PieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> validMoves = new ArrayList<>();

        ChessGame.TeamColor myColor = board.getPiece(myPosition).getTeamColor();

        int startRow = (myColor == ChessGame.TeamColor.WHITE) ? 2 : 7;
        int promotionRow = (myColor == ChessGame.TeamColor.WHITE) ? 8 : 1;
        int direction = (myColor == ChessGame.TeamColor.WHITE) ? 1 : -1;

        int row = myPosition.getRow();
        int col = myPosition.getColumn();

        ChessPosition forwardPosition = new ChessPosition(row+direction, col);
        ChessPosition doubleForwardPosition = new ChessPosition(row + 2*direction, col);
        ChessPosition leftPosition = new ChessPosition(row+direction, col-1);
        ChessPosition rightPosition = new ChessPosition(row+direction, col+1);

        // forward position and double forward position
        if (board.getPiece(forwardPosition) == null) {
            if (forwardPosition.getRow() == promotionRow) {
                addPromotionPieces(validMoves, myPosition, forwardPosition);
            }
            else {
                validMoves.add(new ChessMove(myPosition, forwardPosition, null));
                if (row == startRow && board.getPiece(doubleForwardPosition) == null) {
                    validMoves.add(new ChessMove(myPosition, doubleForwardPosition, null));
                }
            }
        }

        // left position
        if (col > 1) {
            if (board.getPiece(leftPosition) != null && board.getPiece(leftPosition).getTeamColor() != myColor) {
                if (leftPosition.getRow() == promotionRow) {
                    addPromotionPieces(validMoves, myPosition, leftPosition);
                }
                else {
                    validMoves.add(new ChessMove(myPosition, leftPosition, null));
                }
            }
        }
        // right position
        if (col < 8) {
            if (board.getPiece(rightPosition) != null && board.getPiece(rightPosition).getTeamColor() != myColor) {
                if (leftPosition.getRow() == promotionRow) {
                    addPromotionPieces(validMoves, myPosition, rightPosition);
                }
                else {
                    validMoves.add(new ChessMove(myPosition, rightPosition, null));
                }
            }
        }
        return validMoves;
    }

    private void addPromotionPieces(Collection<ChessMove> validMoves, ChessPosition startPosition, ChessPosition endPosition) {
        validMoves.add(new ChessMove(startPosition, endPosition, ChessPiece.PieceType.QUEEN));
        validMoves.add(new ChessMove(startPosition, endPosition, ChessPiece.PieceType.ROOK));
        validMoves.add(new ChessMove(startPosition, endPosition, ChessPiece.PieceType.BISHOP));
        validMoves.add(new ChessMove(startPosition, endPosition, ChessPiece.PieceType.KNIGHT));

    }

}
