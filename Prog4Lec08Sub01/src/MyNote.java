import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * タイトル: マイノート
 * 幅480, 高さ320
 */
public class MyNote extends JFrame implements KeyListener {
    /**
     * タイトル
     */
    private final static String TITLE = "マイノート";

    public MyNote() {
        super();
        setTitle("マイノート");
        setSize(480, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(this);
    }

    /**
     * キーがタイプされたときに呼び出される
     */
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("キーがタイプされました:" + e.getKeyCode());
    }

    /**
     * キーが押されたときに呼び出される
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e != null) {
            Point location = getLocation();

            System.out.println("キーが押されました: " + e.getKeyCode());
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_RIGHT) {
                setTitle(TITLE + "(Right)");
                setLocation(location.x + 10, location.y);
            } else if (keyCode == KeyEvent.VK_LEFT) {
                setTitle(TITLE + "(Left)");
                setLocation(location.x - 10, location.y);
            } else if (keyCode == KeyEvent.VK_UP) {
                setTitle(TITLE + "(Up)");
                setLocation(location.x, location.y - 10);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                setTitle(TITLE + "(Down)");
                setLocation(location.x, location.y + 10);
            }

            if (e.isControlDown() && e.isAltDown()) {
                dispose();
                System.exit(0);
            }
        }
    }

    /**
     * キーが離れたときに呼び出される
     */
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("キーが離れました:" + e.getKeyCode());
    }
}
