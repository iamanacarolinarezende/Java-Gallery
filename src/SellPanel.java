import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SellPanel extends JFrame {
    public JPanel SellPanel;
    private JLabel ArtPieceId;
    private JTextField textFieldArtPieceID;
    private JTextField textFieldArtPieacePrice;
    private JLabel ArtPieacePrice;
    private JButton clearButtonSell;
    private JButton sellButton;
    private JButton BackButton;

    public Gallery gal = new Gallery();
    public SellPanel(){
        sellButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = "";
                // Retrieve text from text fields
                String pieceID = textFieldArtPieceID.getText();
                if (gal.peiceVerifier(pieceID) != true) {
                    // error message
                    msg = "Error! This Curator is does not exist! Please check.";
                } else {
                    String priceText = textFieldArtPieacePrice.getText();

                    if (!priceText.isEmpty()) {
                        try {
                            double price = Double.parseDouble(priceText);

                            // Create Gallery instance and add art piece
                            String sellArtpiece = gal.sellArtpiece(pieceID, price);

                            // Display the message to the user
                            JOptionPane.showMessageDialog(null, sellArtpiece);
                            if (sellArtpiece.startsWith("Success")) {
                                // Clear text fields if art piece added successfully
                                textFieldArtPieceID.setText("");
                                textFieldArtPieacePrice.setText("");
                            }
                        } catch (NumberFormatException ex) {
                            // Handle case where year text or estimate text cannot be parsed
                            JOptionPane.showMessageDialog(null, "Error! Year should be a valid number and estimate should be a valid decimal number.");
                        }
                    } else {
                        // Handle case where year text field or estimate text field is empty
                        JOptionPane.showMessageDialog(null, "Error! Year and estimate cannot be empty.");
                    }
                }
            }
        });

        //Others buttons
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        clearButtonSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldArtPieceID.setText("");
                textFieldArtPieacePrice.setText("");
            }
        });
    }

}