import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ボタンによって背景が変わるフレームクラス
 */
public class ColorFrame extends JFrame implements ActionListener {
    private final Panel panel;

    public ColorFrame() {
        setTitle("Prog4Lec10Sub2");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new Panel();

        Button redButton = new Button("赤");
        Button blueButton = new Button("青");
        Button greenButton = new Button("緑");
        Button yellowButton = new Button("黄色");

        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);
        yellowButton.addActionListener(this);

        panel.add(redButton);
        panel.add(blueButton);
        panel.add(greenButton);
        panel.add(yellowButton);

        add(panel);
    }

    /**
     * ボタンが押された時の処理
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String colorString = e.getActionCommand();

        switch (colorString) {
            case "赤":
                panel.setBackground(Color.RED);
                break;
            case "青":
                panel.setBackground(Color.BLUE);
                break;
            case "緑":
                panel.setBackground(Color.GREEN);
                break;
            case "黄色":
                panel.setBackground(Color.YELLOW);
                break;
        }
    }
}
