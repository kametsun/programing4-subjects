import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private final Button button;
    private final Label label;
    private boolean isRunning = false;
    private int count = 0;

    public MyFrame() {
        setTitle("Prog4Lec14Sub1-22R903010");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());

        label = new Label(String.valueOf(count));
        add(label);

        button = new Button("Start");
        button.addActionListener(e -> {
            if (isRunning) {
                isRunning = false;
                button.setLabel("Start");
            } else {
                isRunning = true;
                button.setLabel("Stop");
                startCount();
            }
        });
        add(button);
    }

    private void startCount() {
        Thread counterThread = new Thread(() -> {
            count = 0;
            while (isRunning) {
                count++;
                label.setText(String.valueOf(count));
                if (count == Integer.MAX_VALUE) {
                    isRunning = false;
                    return;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException error) {
                    error.printStackTrace();
                }
            }
        });
        counterThread.start();
    }
}
