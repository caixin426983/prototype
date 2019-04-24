package com.cx.prototype;

/**
 * @Description TODO
 * @Author cx
 * @Date 2019/3/25 15:59
 **/
public class AA {


    private AA shang;


    private AA xia;


    private int index;

    public AA() {
    }

    public AA(AA shang, AA xia, int index) {
        this.shang = shang;
        this.xia = xia;
        this.index = index;
    }

    public AA getShang() {
        return shang;
    }

    public void setShang(AA shang) {
        this.shang = shang;
    }

    public AA getXia() {
        return xia;
    }

    public void setXia(AA xia) {
        this.xia = xia;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}


class BB {

    public static void main(String[] args) {


    }


}