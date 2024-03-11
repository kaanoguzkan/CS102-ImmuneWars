// TODO I just only wrote simple GUI code, later will add 
// operations such as change background picture, maybe language, 
// and some render process, but this is simple just at this point
import javax.swing.*;

public class startMenu extends JFrame {
    public startMenu() {
        setTitle("Immune Wars");
        setSize(480, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public static void main(String[] args) {
        startMenu start = new startScreen();
        start.setVisible(true);
    }
}
