import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private Button startButton;
    private Label countLabel;
    private int cnt = 0;
    private volatile boolean isRunning = true;

    public MyFrame() {
        setTitle("Prog4Lec14Sub1-22R903010");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton = new Button("Start");
        countLabel = new Label(String.valueOf(cnt));

        startButton.addActionListener(e -> {
            isRunning = !isRunning;
            if (isRunning) {
                startButton.set;
            }
        });
    }
}
