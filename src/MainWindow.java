import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class MainWindow extends JFrame
{
    public MainWindow()
    {
        openGUI();
    }

    public void openGUI()
    {
        JFrame frame = new JFrame();
        DatabaseConnection db = new DatabaseConnection();

        frame.setTitle("Gym Management System");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
