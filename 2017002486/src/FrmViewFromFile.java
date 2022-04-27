//Elliot Morrison
//2017002486
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmViewFromFile extends JFrame{
    private JLabel viewFromFileLabel;
    private JTable viewFromFileTable;
    private JPanel viewFromFilePanel;
    private JButton returnToMainMenuButton;
    private Laptop laptop;

    public FrmViewFromFile() {
        laptop = new Laptop();
        String[] columnName = {"Laptop ID", "Brand", "Model","Manufacture Date","Price","Quantity"};
        setContentPane(viewFromFilePanel);
        setTitle("View From File");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        DefaultTableModel defaultTableModel = new DefaultTableModel(columnName, 0);
        laptop.FileInitialization();
        ArrayList<Laptop> LaptopFileList = laptop.ReadFromFile();
        for (Laptop l : LaptopFileList) {
            defaultTableModel.addRow(new String[]{
                    String.valueOf(l.getLaptopId()),
                    l.getBrand(),
                    l.getModel(),
                    l.getManufactureDate(),
                    "$ " + l.calculatePrice(),
                    String.valueOf(l.getQuantity())
            });
        }
        viewFromFileTable.setModel(defaultTableModel);
        returnToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmMainMenu frmMainMenu = new FrmMainMenu();
                dispose();
            }
        });
    }
}
