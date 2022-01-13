package jp.ac.uryukyu.ie.e215719;

public abstract class Piece {

    private int x;
    private int y;

    public Piece (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public abstract char toChar(); //駒の種類で変える

}