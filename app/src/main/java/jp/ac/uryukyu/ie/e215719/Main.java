package jp.ac.uryukyu.ie.e215719;

import java.util.Scanner;

public class Main {
    public static final String PROMPT_FORMST = "%sの番です。%dターン目>";
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean gameFinished = false;
        while (true) {
            System.out.print(board.getDisplayString()); //盤を出力
            gameFinished = board.end();
            if (gameFinished) {
                System.out.println("ゲームが終了しました");
                break;
            } else {
            System.out.format(PROMPT_FORMST, board.isRedTurn() ? "赤" : "青", board.getMoveCount());
            line = scanner.nextLine(); //一行読み取り
            System.out.println(line);
            board.move(line); //駒を動かす
            }
        }
    }
}