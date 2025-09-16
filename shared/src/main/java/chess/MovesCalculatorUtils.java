package chess;

import java.util.Collection;


public class MovesCalculatorUtils {
    public static void slidingMoves(ChessBoard board, ChessPosition myPosition, int[][] directions, Collection<ChessMove> validMoves) {
        ChessGame.TeamColor myColor = board.getPiece(myPosition).getTeamColor();
        for (int dir[] : directions) {
            int row = myPosition.getRow();
            int col = myPosition.getColumn();

            while (true) {
                row += dir[0];
                col += dir[1];
                if (col>8 || col<1 || row>8 || row<1) {
                    break;
                }
                ChessPosition potentialPosition = new ChessPosition(row, col);
                if (board.getPiece(potentialPosition) == null) {
                    validMoves.add(new ChessMove(myPosition, potentialPosition, null));
                }
                else if (board.getPiece(potentialPosition).getTeamColor() != myColor) {
                    validMoves.add(new ChessMove(myPosition, potentialPosition, null));
                    break;
                }
                else {
                    break;
                }
            }
        }
    }

    public static void staticMoves(ChessBoard board, ChessPosition myPosition, int[][] directions, Collection<ChessMove> validMoves) {
        ChessGame.TeamColor myColor = board.getPiece(myPosition).getTeamColor();
        for (int dir[] : directions) {
            int row = myPosition.getRow();
            int col = myPosition.getColumn();
            row += dir[0];
            col += dir[1];
            if (col>8 || col<1 || row>8 || row<1) {
                continue;
            }
            ChessPosition potentialPosition = new ChessPosition(row, col);
            if (board.getPiece(potentialPosition) == null) {
                validMoves.add(new ChessMove(myPosition, potentialPosition, null));
            }
            else if (board.getPiece(potentialPosition).getTeamColor() != myColor) {
                validMoves.add(new ChessMove(myPosition, potentialPosition, null));
            }
        }
    }
}
