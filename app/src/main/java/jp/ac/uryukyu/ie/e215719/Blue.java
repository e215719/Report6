package jp.ac.uryukyu.ie.e215719;

public class Blue extends Piece { //青の駒
    
    public Blue(int x, int y) {
        super(x, y);
    }

    @Override
    public char toChar() { //盤に表示させる文字
        return 'B';
    }

}