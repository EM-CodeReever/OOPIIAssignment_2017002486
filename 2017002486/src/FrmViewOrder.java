import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmViewOrder extends JFrame{
    private JTextField laptopIDTextField;
    private JTextField brandTextField;
    private JTextField modelTextField;
    private JTextField manufactureDateTextField;
    private JTextField quantityTextField;
    private JTextField priceTextField;
    private JLabel laptopIDLabel;
    private JButton acceptAndReturnToButton;
    private JPanel viewOrderPanel;

    public FrmViewOrder(){
        setContentPane(viewOrderPanel);
        setTitle("View Order");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public FrmViewOrder(Laptop laptop){
        setContentPane(viewOrderPanel);
        setTitle("View Order");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        laptopIDTextField.setText(String.valueOf(laptop.getLaptopId()));
        brandTextField.setText(laptop.getBrand());
        modelTextField.setText(laptop.getModel());
        manufactureDateTextField.setText(laptop.getManufactureDate());
        quantityTextField.setText(String.valueOf(laptop.getQuantity()));
        priceTextField.setText("$ " + laptop.calculatePrice());
        acceptAndReturnToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmMainMenu frmMainMenu = new FrmMainMenu();
                dispose();
            }
        });
    }
}
