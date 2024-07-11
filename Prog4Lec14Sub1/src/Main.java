import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CounterApp extends JFrame {

    private JButton startButton;
    private JLabel countLabel;
    private volatile boolean isCounting;

    public CounterApp() {
        super("Counter App");

        startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonActionListener());

        countLabel = new JLabel("0");

        setLayout(new BorderLayout());
        add(startButton, BorderLayout.PAGE_END);
        add(countLabel, BorderLayout.CENTER);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CounterApp();
    }

    private class StartButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isCounting) {
                isCounting = false;
                startButton.setText("Start");
            } else {
                isCounting = true;
                startButton.setText("Stop");
                Thread thread = new Thread(() -> {
                    int count = 0;
                    while (isCounting) {
                        count++;
                        countLabel.setText(String.valueOf(count));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        }
    }
}
