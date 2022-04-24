import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmMainMenu extends JFrame{
    private JLabel mainMenuLabel;
    private JPanel mainMenuPanel;
    private JButton enterOrderButton;
    private JButton viewListButton;
    private JButton viewRecordsButton;
    private JButton logoutButton;

    public FrmMainMenu() {
        setContentPane(mainMenuPanel);
        setTitle("Enter Order");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        enterOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEnterOrder enterOrder = new FrmEnterOrder();
                dispose();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainMenuPanel,"Goodbye!");
                dispose();
            }
        });
        viewListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmViewFromList frmViewFromList = new FrmViewFromList();
                dispose();
            }
        });
        viewRecordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmViewFromFile frmViewFromFile = new FrmViewFromFile();
                dispose();
            }
        });
    }
}
