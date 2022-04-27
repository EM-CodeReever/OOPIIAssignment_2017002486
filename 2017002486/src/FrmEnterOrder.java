//Elliot Morrison
//2017002486
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FrmEnterOrder extends JFrame{
    private JTextField laptopIDTextField;
    private JTextField manufactureDateTextField;
    private JTextField modelTextField;
    private JTextField brandTextField;
    private JTextField quantityTextField;
    private JRadioButton storeToFileRadioButton;
    private JRadioButton storeToListRadioButton;
    private JButton placeOrderButton;
    private JLabel quantityLabel;
    private JLabel manufactureDateLabel;
    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel laptopIDLabel;
    private JPanel EnterOrderPanel;
    private JButton backToMainMenuButton;

    public FrmEnterOrder() {
        setContentPane(EnterOrderPanel);
        setTitle("Enter Order");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmMainMenu mainMenu = new FrmMainMenu();
                dispose();
            }
        });
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (laptopIDTextField.getText().contentEquals("")) {
                    JOptionPane.showMessageDialog(EnterOrderPanel, "Enter LaptopID");
                } else if (modelTextField.getText().contentEquals("")) {
                    JOptionPane.showMessageDialog(EnterOrderPanel, "Enter Model");
                } else if (brandTextField.getText().contentEquals("")) {
                    JOptionPane.showMessageDialog(EnterOrderPanel, "Enter Brand");
                } else if (manufactureDateTextField.getText().contentEquals("")) {
                    JOptionPane.showMessageDialog(EnterOrderPanel, "Enter Manufacture Date");
                } else if (quantityTextField.getText().contentEquals("")) {
                    JOptionPane.showMessageDialog(EnterOrderPanel, "Enter Quantity");
                } else if (!storeToFileRadioButton.isSelected() && !storeToListRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(EnterOrderPanel, "Select a storage option");
                } else {
                    try {
                        int quantity = Integer.parseInt(quantityTextField.getText());
                        int laptopId = Integer.parseInt(laptopIDTextField.getText());

                        Laptop laptop = new Laptop();
                        laptop.setModel(modelTextField.getText());
                        laptop.setBrand(brandTextField.getText());
                        laptop.setManufactureDate(manufactureDateTextField.getText());
                        laptop.setLaptopId(laptopId);
                        laptop.setQuantity(quantity);

                        if(storeToFileRadioButton.isSelected()){
                            ArrayList<Laptop> LaptopFile = new ArrayList<>();
                            if(!laptop.FileInitialization()){
                                LaptopFile = laptop.ReadFromFile();
                            }
                            LaptopFile.add(laptop);
                            laptop.WriteToFile(LaptopFile);
                            JOptionPane.showMessageDialog(EnterOrderPanel, "Stored in File!");
                        }else {
                            Laptop.ListTracker.LaptopList.add(laptop);
                            JOptionPane.showMessageDialog(EnterOrderPanel, "Stored in List!");
                        }
                        FrmViewOrder frmViewOrder = new FrmViewOrder(laptop);
                        dispose();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(EnterOrderPanel, "Enter Valid Quantity\n" + ex.getMessage());
                    }
                }
            }
        });
    }
}
