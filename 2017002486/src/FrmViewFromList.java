import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmViewFromList extends JFrame {
    private JTable viewFromListTable;
    private JPanel viewFromListPanel;
    private JButton returnToMainMenuButton;

    public FrmViewFromList() {
        String[] columnName = {"Laptop ID", "Brand", "Model","Manufacture Date","Price","Quantity"};
        setContentPane(viewFromListPanel);
        setTitle("View From List");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        DefaultTableModel defaultTableModel = new DefaultTableModel(columnName, 0);
        for (Laptop l : Laptop.ListTracker.LaptopList) {
            defaultTableModel.addRow(new String[]{
                    String.valueOf(l.getLaptopId()),
                    l.getBrand(),
                    l.getModel(),
                    l.getManufactureDate(),
                    "$ " + l.calculatePrice(),
                    String.valueOf(l.getQuantity())
            });
        }
        viewFromListTable.setModel(defaultTableModel);
        returnToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmMainMenu frmMainMenu = new FrmMainMenu();
                dispose();
            }
        });
    }
}