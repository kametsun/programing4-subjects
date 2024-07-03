import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private final Button button;
    private volatile boolean isRunning = false;
    private int count = 0;

    public MyFrame() {
        setTitle("Prog4Lec14Sub1-22R903010");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new Button("Start");
        button.addActionListener(e -> {
            synchronized (this) {
                if (isRunning) {
                    isRunning = false;
                    button.setLabel("Start");
                } else {
                    isRunning = true;
                    startCount();
                }
            }
        });

        add(button);
    }

    /**
     * ボタンが押された時にカウントとラベルを変更する
     */
    private void startCount() {
        Thread counterThread = new Thread(() -> {
            count = 0;
            while (isRunning) {
                button.setLabel(String.valueOf(++count));
                if (count == Integer.MAX_VALUE) {
                    /** 最大値になったらカウント停止する */
                    isRunning = false;
                    return;
                }
                try {
                    /** カウント間隔 */
                    Thread.sleep(1);
                } catch (InterruptedException error) {
                    error.printStackTrace();
                }
            }
        });
        counterThread.start();
    }
}
