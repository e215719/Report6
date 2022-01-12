package jp.ac.uryukyu.ie.e215719;

import java.util.ArrayList;

public class Board {
    
    public static ArrayList<Piece> pieces;
    public String[][] gameboard;

    public Board() {
        this.pieces = new ArrayList<>(); //駒のリスト
        this.gameboard = new String[3][3]; //盤情報リスト
        pieces.add(new Red(0, 0));
        pieces.add(new Red(1, 0));
        pieces.add(new Red(2, 0));
        pieces.add(new Blue(0, 2));
        pieces.add(new Blue(1, 2));
        pieces.add(new Blue(2, 2));
    }

    public String getDisplayString() { //盤を作成する
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

}