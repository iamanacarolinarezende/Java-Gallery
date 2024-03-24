import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainForm_CGS extends JFrame{

    public JTabbedPane CgsPanel;
    private JLabel labelCuratorID;
    private JLabel labelFistName;
    private JLabel labelLastName;
    private JButton buttonAddCurator;
    private JButton buttonClear;
    private JTextField textFieldCuratorID;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JLabel labArtistID;
    private JLabel labelCuratorIDA;
    private JLabel labelFirstN;
    private JLabel labelLstN;
    private JTextField textFieldCommission;
    private JButton buttonAddArtist;
    private JButton buttonClearA;
    private JTextField textFieldArtistID;
    private JTextField textFieldCuratorIDA;
    private JTextField textFieldFirstNameArtist;
    private JTextField textFieldLastNameArtist;
    private JLabel labelArtPID;
    private JLabel labelArtistIDAP;
    private JLabel labelCuratorIDAP;
    private JLabel labelTitle;
    private JLabel labelYear;
    private JLabel labelEstimate;
    private JButton buttonClearAP;
    private JButton buttonAddAP;
    private JButton buttonSell;
    private JTextField textFieldArtPieceID;
    private JTextField textFieldArtistIdAP;
    private JTextField textFieldCuratorIDAP;
    private JTextField textFieldTitle;
    private JTextField textFieldYear;
    private JTextField textFieldEstimate;


    public Gallery gal = new Gallery();
    public MainForm_CGS() {

        //Button Add Curator
        buttonAddCurator.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve text from text fields
                String userID = textFieldCuratorID.getText();
                String fname = textFieldFirstName.getText();
                String lname = textFieldLastName.getText();
                String commissionText = textFieldCommission.getText();

                // Check if commission text is not empty
                if (!commissionText.isEmpty()) {
                    try {
                        // Parse commission text to double
                        double commission = Double.parseDouble(commissionText);

                        // Create Gallery instance and add curator

                        String curatorAdd = gal.addCurator(userID, fname, lname, commission);

                        // Display the message to the user
                        JOptionPane.showMessageDialog(null, curatorAdd);
                        if (curatorAdd.startsWith("Success")) {
                            // Clear text fields if curator added successfully
                            textFieldCuratorID.setText("");
                            textFieldFirstName.setText("");
                            textFieldLastName.setText("");
                            textFieldCommission.setText("");
                        }
                    } catch (NumberFormatException ex) {
                        // Handle case where commission text cannot be parsed to double
                        JOptionPane.showMessageDialog(null, "Error! Commission should be a valid number.");
                    }
                } else {
                    // Handle case where commission text field is empty
                    JOptionPane.showMessageDialog(null, "Error! Commission cannot be empty.");
                }
            }
        });

        //Button Add Artist
        buttonAddArtist.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Retrieve text from text fields
                String artistID = textFieldArtistID.getText();
                if (gal.ArtistIdVerifier(artistID) != true) {
                    // error message
                    JOptionPane.showMessageDialog(buttonAddArtist, "Error! Artist ID.");


                } else {
                    String userID = textFieldCuratorIDA.getText();
                    if (gal.CuratorIdVerifier(userID) != true) {
                        // error message
                        JOptionPane.showMessageDialog(buttonAddArtist, "Error! Curator ID.");
                    } else {
                        String fname = textFieldFirstNameArtist.getText();
                        String lname = textFieldLastNameArtist.getText();

                        String artistAdd = gal.addArtist(artistID, userID, fname, lname);

                        JOptionPane.showMessageDialog(null, artistAdd);
                        if (artistAdd.startsWith("Success")) {
                            // Clear text fields if curator added successfully
                            textFieldArtistID.setText("");
                            textFieldCuratorIDA.setText("");
                            textFieldFirstNameArtist.setText("");
                            textFieldLastNameArtist.setText("");
                        }
                    }
                }
            }
        });

        //Button Add Piece
        buttonAddAP.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = "";
                // Retrieve text from text fields
                String peiceID = textFieldArtPieceID.getText();
                if (gal.peiceVerifier(peiceID) != true) {
                    // error message
                } else {
                    String artistID = textFieldArtistIdAP.getText();
                    if (gal.ArtistIdVerifier(artistID) != true) {
                        // error message
                        msg = "Error! This Curator is does not exist! Please check.";
                    } else {
                        String curatorID = textFieldCuratorIDAP.getText();
                        if (gal.CuratorIdVerifier(curatorID) != true) {
                            // error message
                            msg = "Error! This Curator is does not exist! Please check.";
                        } else {
                            String title = textFieldTitle.getText();
                            String yearText = textFieldYear.getText();
                            String estimateText = textFieldEstimate.getText();

                            if (!yearText.isEmpty() && !estimateText.isEmpty()) {
                                try {
                                    // Parse year text to int
                                    int year = Integer.parseInt(yearText);

                                    // Parse estimate text to double
                                    double estimate = Double.parseDouble(estimateText);

                                    // Create Gallery instance and add art piece
                                    String artPieceAdd = gal.addPiece(peiceID, title, year, estimate, artistID, curatorID);

                                    // Display the message to the user
                                    JOptionPane.showMessageDialog(null, artPieceAdd);
                                    if (artPieceAdd.startsWith("Success")) {
                                        // Clear text fields if art piece added successfully
                                        textFieldArtPieceID.setText("");
                                        textFieldArtistIdAP.setText("");
                                        textFieldCuratorIDAP.setText("");
                                        textFieldTitle.setText("");
                                        textFieldYear.setText("");
                                        textFieldEstimate.setText("");
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
                }
            }
        });

        //Button Sell ArtPiece
        buttonSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellPanel sell = new SellPanel();
                sell.setContentPane(sell.SellPanel);
                sell.setTitle("CGS - SELL");
                sell.setSize(350, 200);
                sell.setLocationRelativeTo(null);
                sell.setVisible(true);
            }
        });

        //Clear buttons
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldLastName.setText("");
                textFieldFirstName.setText("");
                textFieldCuratorID.setText("");
            }
        });
        buttonClearA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldArtistID.setText("");
                textFieldFirstNameArtist.setText("");
                textFieldLastNameArtist.setText("");
                textFieldCuratorIDA.setText("");
            }
        });
        buttonClearAP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCuratorIDAP.setText("");
                textFieldArtistIdAP.setText("");
                textFieldArtPieceID.setText("");
                textFieldTitle.setText("");
                textFieldEstimate.setText("");
                textFieldYear.setText("");
            }
        });
    }
}

