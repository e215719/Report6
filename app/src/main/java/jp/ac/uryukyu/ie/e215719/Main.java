package jp.ac.uryukyu.ie.e215719;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            System.out.println(board.getDisplayString()); //盤を出力
            line = scanner.nextLine(); //一行読み取り
            board.move(line); //駒を動かす
            System.out.println(line);
        }
    }
}