/**
 * Created by Brian on 10/01/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewSandbox extends JFrame{

    /* Text fields*/
    private JTextField city = new JTextField();;
    private JTextField zipCode = new JTextField();;

    /* Labels */
    private JLabel cityLabel = new JLabel("     City");
    private JLabel zipCodeLabel = new JLabel("     Zip Code");

    /* Button */
    private JButton getZPButton = new JButton("Search Zip Code");


    /* View Constructor */
    ViewSandbox() {
        // Create a frame.
        setTitle("Find Zip Codes");
        setSize(300, 200);
        // Create panel 1
        JPanel panel1 = new JPanel();
        // Set layout for panel 1
        panel1.setLayout(new GridLayout(3, 2, 10, 20));
        // Create panel 2
        JPanel panel2 = new JPanel();
        // Set layout for panel 2
        panel2.setLayout(new FlowLayout());

        // Add the components to the frame.
        panel1.add(cityLabel);
        panel1.add(city);
        panel1.add(zipCodeLabel);
        panel1.add(zipCode);
        panel2.add(getZPButton);

        // Add the panels to the frame.
        add(panel1);
        add(panel2, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // convert what the user enters to an integer to give to the Controller
    public String getCity(){
        return city.getText();
    }
    public void setZipCode(String zipCode){
        this.zipCode.setText(zipCode);
    }

    // listener for add button when clicked
    void searchZPButtonListener(ActionListener listenForSearchZPButton){
        getZPButton.addActionListener(listenForSearchZPButton);
    }
}
