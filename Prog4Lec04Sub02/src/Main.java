import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MyData> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MyData data = new MyData(i, Math.random());
            list.add(data);
        }
        list.sort(
                // MyDataの添え字でソートする
                Comparator.comparing(MyData::getIndex).reversed()
        );
        list.forEach(data -> System.out.println(
                "[" + data.getIndex() + "]" + data.getData())
        );
    }
}