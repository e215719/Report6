package jp.ac.uryukyu.ie.e215719;

import java.util.ArrayList;
import java.util.Objects;

public class Board {
    
    public static ArrayList<Piece> pieces;
    public String[][] gameboard;
    public static int counter = 1; //ターン情報

    public Board() {
        this.pieces = new ArrayList<>(); //駒のリスト
        this.gameboard = new String[3][3]; //盤情報リスト
        pieces.add(new Red(0, 0, true));
        pieces.add(new Red(1, 0, true));
        pieces.add(new Red(2, 0, true));
        pieces.add(new Blue(0, 2, false));
        pieces.add(new Blue(1, 2, false));
        pieces.add(new Blue(2, 2, false));
    }

    public String getDisplayString() { //盤を作成する
        for (int j=0; j<3; j++) { //盤情報をnullに
            for (int i=0; i<3; i++) {
                gameboard[i][j] = null;
            }
        }
        for (int a=0; a<pieces.size(); a++) { //駒をリストに追加
            int i = pieces.get(a).getX();
            int j = pieces.get(a).getY();
            gameboard[i][j] = pieces.get(a).toChar() + "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("   a   b   c"); //上の座標を表示
        sb.append("\n");
        sb.append(" +---+---+---+"); //上線
        sb.append("\n");
        for (int j=0; j<3; j++) {
            sb.append(j+1 + "|"); // 左の座標の表示
            for (int i=0; i<3; i++) {
                if (gameboard[i][j] == null) { //駒がない場合
                    if (i<2) {
                        sb.append(" " + " " + " -");
                    } else {
                        sb.append(" " + " " + " |"); //右マス
                    }
                } else {
                    if (i<2) {
                        sb.append(" " + gameboard[i][j] + " -");
                    } else {
                        sb.append(" " + gameboard[i][j] + " |"); //右マス
                    }
                }
            }
            sb.append(j+1); // 右の座標を表示
            sb.append("\n");
            switch (j) {
                case 0: sb.append(" +-|-\\-|-/-|-+");
                    break;
                case 1: sb.append(" +-|-/-|-\\-|-+");
                    break;
                case 2: sb.append(" +---+---+---+"); //下線
                    break;
            }
            sb.append("\n");
        }
        sb.append("   a   b   c"); //下の座標を表示
        sb.append("\n");
        return sb.toString();
    }

    public void move(String moveText) { //駒を動かす
        String[] words = moveText.split(",");
        String from = words[0]; //駒の出発地
        String to = words[1]; //駒の到着地
        char tempfrx = from.charAt(0);
        char tempfry = from.charAt(1);
        int fromx = tempfrx - 97; //ASCIIコードに変換し計算で盤に合わせる
        int fromy = tempfry - 49;
        char temptox = to.charAt(0);
        char temptoy = to.charAt(1);
        int tox = temptox - 97; //ASCIIコードに変換し計算で盤に合わせる
        int toy = temptoy - 49;

        if (chackPiece(fromx, fromy)) { //駒があるかチェックする
            int activepiece = grabPiece(fromx, fromy); //駒を掴む
            if (isRedTurn() == pieces.get(activepiece).isRed()) { //自分の駒か判定する
                if (pieces.get(activepiece).isValid(fromx, fromy, tox, toy)) { //動かせる座標なのか判定する
                    if (chackPiece(tox, toy) == false) {
                        pieces.get(activepiece).setX(tox);
                        pieces.get(activepiece).setY(toy);
                        counter = counter + 1;
                    } else {
                        System.out.println("他の駒があります");
                    }
                } else {
                    System.out.println("この駒はそこに移動できない");
                }
            } else {
                System.out.println("自分の駒ではありません");
            }
        } else {
            System.out.println("そこに駒はありません");
        }
    }
    
    public static boolean chackPiece(int x, int y) { //その座標にある駒を判別する
        for (int a=0; a<pieces.size(); a++) {
            if (pieces.get(a).getX()==x && pieces.get(a).getY()==y) {
                return true;
            }
        }
        return false;
    }

    public int grabPiece(int x, int y) { //駒を掴む
        for (int a=0; a<pieces.size(); a++) {
            if (pieces.get(a).getX()==x && pieces.get(a).getY()==y) {
                return a;
            }
        }
        return 9; //エラー解決
    }

    public boolean isRedTurn() { //赤のターンか判定する
        return counter % 2 == 1;
    }

    public int getMoveCount() { //ターンをカウントする
        return (int) Math.floor((counter + 1) / 2);
    }

    public boolean end() { //盤の状況が勝ちの条件を満たしているか判定する
        if ( Objects.equals(gameboard[0][0], "R") && Objects.equals(gameboard[0][1], "R") && Objects.equals(gameboard[0][2], "R")||
             Objects.equals(gameboard[1][0], "R") && Objects.equals(gameboard[1][1], "R") && Objects.equals(gameboard[1][2], "R")||
             Objects.equals(gameboard[2][0], "R") && Objects.equals(gameboard[2][1], "R") && Objects.equals(gameboard[2][2], "R")||
             Objects.equals(gameboard[0][1], "R") && Objects.equals(gameboard[1][1], "R") && Objects.equals(gameboard[2][1], "R")||
             Objects.equals(gameboard[0][2], "R") && Objects.equals(gameboard[1][2], "R") && Objects.equals(gameboard[2][2], "R")||
             Objects.equals(gameboard[0][0], "R") && Objects.equals(gameboard[1][1], "R") && Objects.equals(gameboard[2][2], "R")||
             Objects.equals(gameboard[2][0], "R") && Objects.equals(gameboard[1][1], "R") && Objects.equals(gameboard[0][2], "R")){
            System.out.println("赤の勝ちです");
            return true;
        }
        if ( Objects.equals(gameboard[0][0], "B") && Objects.equals(gameboard[0][1], "B") && Objects.equals(gameboard[0][2], "B")||
             Objects.equals(gameboard[1][0], "B") && Objects.equals(gameboard[1][1], "B") && Objects.equals(gameboard[1][2], "B")||
             Objects.equals(gameboard[2][0], "B") && Objects.equals(gameboard[2][1], "B") && Objects.equals(gameboard[2][2], "B")||
             Objects.equals(gameboard[0][0], "B") && Objects.equals(gameboard[1][0], "B") && Objects.equals(gameboard[2][0], "B")||
             Objects.equals(gameboard[0][1], "B") && Objects.equals(gameboard[1][1], "B") && Objects.equals(gameboard[2][1], "B")||
             Objects.equals(gameboard[0][0], "B") && Objects.equals(gameboard[1][1], "B") && Objects.equals(gameboard[2][2], "B")||
             Objects.equals(gameboard[2][0], "B") && Objects.equals(gameboard[1][1], "B") && Objects.equals(gameboard[0][2], "B")){
            System.out.println("青の勝ちです");
            return true;
        }
        return false;
    }

}