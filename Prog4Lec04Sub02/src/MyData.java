/**
 * データの生成番号と値を格納するクラス
 */
public class MyData {
    public int index;
    public double data;

    public MyData(int i, double random) {
        index = i;
        data = random;
    }

    public int getIndex() {
        return index;
    }

    public double getData() {
        return data;
    }
}
