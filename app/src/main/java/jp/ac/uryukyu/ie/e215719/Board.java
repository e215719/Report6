package jp.ac.uryukyu.ie.e215719;

public class Board {

    public Board() {
    }

    public String getDisplayString() { //盤を作成する
        StringBuilder sb = new StringBuilder();
        sb.append("   a   b   c"); //上の座標を表示
        sb.append("\n");
        sb.append(" +---+---+---+"); //上線
        sb.append("\n");
        for (int j=0; j<3; j++) {
            sb.append(j+1 + "|"); // 左の座標の表示
            for (int i=0; i<3; i++) {
                if (i<2) {
                    sb.append(" " + " " + " -");
                } else {
                    sb.append(" " + " " + " |"); //右マス
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