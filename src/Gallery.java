import com.sun.source.doctree.EscapeTree;
import com.sun.source.tree.ArrayAccessTree;
import com.sun.tools.jconsole.JConsoleContext;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import java.util.ConcurrentModificationException;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.ArrayList;

public class Gallery {
    public Gallery(){}
    public Curators myCurators = new Curators();
    public Artists myArtists = new Artists();
    public ArtPieces myArtPieces = new ArtPieces();

    public void addCurator(){
        System.out.println("Please enter a Curator ID:");
        Scanner scanner = new Scanner(System.in);
        String userID = scanner.nextLine();
        if(userID.length() != 5){
            System.out.println("Invalid Input - UserID should be 5 chars");
        }
        else {
            // here we have to search for the ID inside of the myCurators
            // array in order to not to create another ID which already
            // exists in the list.
            if (CuratorIdVerifier(userID) == true) {
                System.out.println("Error! There is already one curator with this ID.");
            }
            else {
                System.out.println("Please enter Firstname: ");
                String fname = scanner.nextLine();
                System.out.println("Please enter Lastname: ");
                String lname = scanner.nextLine();
                if (fname.length() + lname.length() <= 30) {
                    Curator cur = new Curator(userID, 0.0,
                            0.15, fname, lname);
                    myCurators.addCurator(cur);
                    System.out.println("Success! Curator has been " +
                            "added to the List");
                } else {
                    System.out.println("Error! Firstname and Lastname " +
                            "should have below 30 characters");
                    return;
                }
            }
        }
    }
    public String addCurator(String userID, String fname, String lname, double commission){
        String msg = "";

        if(userID.length() != 5){
            msg = "Invalid Input - UserID should be 5 chars";
        }
        else {
            // here we have to search for the ID inside of the myCurators
            // array in order to not to create another ID which already
            // exists in the list.
            if (CuratorIdVerifier(userID) == true) {
                msg = "Error! There is already one curator with this ID.";
            }
            else {
                if (fname.length() + lname.length() <= 30) {
                    Curator cur = new Curator(userID, commission,
                            0.15, fname, lname);
                    myCurators.addCurator(cur);
                    msg = "Success! Curator has been " +
                            "added to the List";
                } else {
                    msg = "Error! Firstname and Lastname " +
                            "should have below 30 characters";
                }
            }
        }
        return msg;
    }
    public boolean ArtistIdVerifier(String ID){
        boolean flag = false;
        for(Artist artist : myArtists){
            if(artist.getArtistID().equals(ID)){
                flag = true;
            }
        }
        return flag;
    }
    public void DisplyAllArtpieces(){
        for(ArtPiece piece : myArtPieces){
            System.out.println(piece.ToString());
        }
    }
    public boolean CuratorIdVerifier(String cID){
        boolean flag = false;
        for(Curator cur : myCurators){
            if(cur.CuratorID.equals(cID)){
                flag = true;
                break;
            }
        }
        return flag;
    }
    public boolean peiceVerifier(String ID){
        boolean flag = false;
        for(ArtPiece piece : myArtPieces){
            if(piece.getPieceID().equals(ID)){
                flag = true;
            }
        }
        return flag;
    }
    public void addArtist(){
        System.out.println("Please enter artistID: ");
        Scanner scanner = new Scanner(System.in);
        String ArtistID = scanner.nextLine();
        if(ArtistID.length() != 5){
            System.out.println("ArtistId should be exactly 5 characters!");
        }
        else{
            if(ArtistIdVerifier(ArtistID) == true){
                System.out.println("Error! There exist already an Artist with this ID!");
            }
            else{
                System.out.println("Please enter the curatorID associated with this artistID: ");
                String curatorID = scanner.nextLine();
                if(CuratorIdVerifier(curatorID) != true){
                    System.out.println("Error! There is no Curator with this ID");
                }
                else{
                    System.out.println("Please enter your Firstname: ");
                    String fname = scanner.nextLine();
                    System.out.println("Please enter your lastname: ");
                    String lname = scanner.nextLine();
                    if(fname.length() + lname.length() > 30){
                        System.out.println("Error! Firstname and Lastname should not exceed 30 chars!");
                    }
                    else{
                        Artist aritst = new Artist(ArtistID, curatorID, fname, lname);
                        myArtists.addArtist(aritst);
                        System.out.println("Success! Artist has been added to the list!");
                    }
                }

            }
        }
    }
    public String addArtist(String artistID, String fname, String lname, String userID){
        String msg = "";
        if(artistID.length() != 5){
            msg = "ArtistId should be exactly 5 characters!";
        }
        else{
            if(ArtistIdVerifier(artistID) == true){
                msg = "Error! There exist already an Artist with this ID!";
            }
            else{
                if (CuratorIdVerifier(userID) == true) {
                    msg = "Error! There is already one curator with this ID.";
                }
                else{
                    if(fname.length() + lname.length() > 30){
                        msg = "Error! Firstname and Lastname should not exceed 30 chars!";
                    }
                    else{
                        Artist artist = new Artist(artistID, userID, fname, lname);
                        myArtists.addArtist(artist);
                        msg = "Success! Artist has been added to the list!";
                    }
                }

            }
        }
        return msg;
    }
    public void addPiece(){
        System.out.println("Please enter the ArtPieceID: ");
        Scanner scanner = new Scanner(System.in);
        String peiceID = scanner.nextLine();
        if(peiceID.length() != 5){
            System.out.println("Error! PeiceID should be exactly 5 characters!");
        }
        else{
            if(peiceVerifier(peiceID) == true){
                System.out.println("Error! There exist one artpice with the ID.");
            }
            else{
                System.out.println("Please enter the associated ArtistID: ");
                String artistID = scanner.nextLine();
                if(ArtistIdVerifier(artistID) != true){
                    System.out.println("Error! There is no artist with this ID in CGS!");
                }
                else{
                    System.out.println("Please enter the associated curatorID: ");
                    String curtorID = scanner.nextLine();
                    if(CuratorIdVerifier(curtorID) != true){
                        System.out.println("Error! There is no curator with the ID in CGS!");
                    }
                    else {
                        System.out.println("Please enter the title: ");
                        String title = scanner.nextLine();
                        if(title.length() > 40){
                            System.out.println("Error! Title should be below 40 characters!");
                        }
                        else{
                            System.out.println("Please enter the estimate for this artpiece: ");
                            double estimate = scanner.nextDouble();
                            System.out.println("Please enter the year: ");
                            int year = scanner.nextInt();
                            // the below line forms the data read from the console into an object
                            ArtPiece peice = new ArtPiece(peiceID, title, year, estimate, 0.0,
                                    artistID, curtorID, 'D');
                            // the next line adds the object into the artpiece list (myArtPieces)
                            myArtPieces.addArtPiece(peice);
                            System.out.println("Success! The object was successfully added to the list.");
                        }
                    }

                }
            }
        }
    }
    public String addPiece(String peiceID, String title, int year, double estimate, String artistID, String curatorID){
        String msg = "";
        if(peiceID.length() != 5){
            msg = "Error! Piece ID should be exactly 5 characters!";
        }
        else{
            if(peiceVerifier(peiceID) == true){
                msg = "Error! There exist one artpice with the ID.";
            }
            else{
                if(ArtistIdVerifier(artistID) != true){
                    msg = "Error! There is no artist with this ID in CGS!";
                }
                else{
                    if(CuratorIdVerifier(curatorID) != true){
                        msg = "Error! There is no curator with the ID in CGS!";
                    }
                    else {
                        if(title.length() > 40){
                            msg = "Error! Title should be below 40 characters!";
                        }
                        else{
                            // the below line forms the data read from the console into an object
                            ArtPiece peice = new ArtPiece(peiceID, title, year, estimate, 0.0,
                                    artistID, curatorID, 'D');
                            // the next line adds the object into the artpiece list (myArtPieces)
                            myArtPieces.addArtPiece(peice);
                            msg = "Success! The object was successfully added to the list.";
                        }
                    }

                }
            }
        }
        return msg;
    }
    public char statusChecker(String PeiceID){
        char status = ' ';
        for(ArtPiece piece : myArtPieces){
            if(piece.getPieceID().equals(PeiceID)){
                status = piece.getStatus();
            }
        }
        return status;
    }
    public double getEstimate(String peiceID){
        double estimate = 0.0;
        for(ArtPiece piece : myArtPieces){
            if(piece.getPieceID().equals(peiceID)){
                estimate = piece.getEstimate();
            }
        }
        return estimate;
    }
    public void changeStatusAfterSale(String artpieceID){
        for(ArtPiece piece : myArtPieces){
            if(piece.getPieceID().equals(artpieceID)){
                piece.setStatus('S');
            }
        }
    }
    public void CommisionUpdate(String ArtpiceID, double price, double estimate){
        String curatorID="";
        for(ArtPiece piece : myArtPieces){
            if(piece.getPieceID().equals(ArtpiceID)){
                curatorID = piece.getCuratorID();
            }
        }
        double commission = (price - estimate)* 1.15;
        for(Curator curator : myCurators){
            if(curator.getCuratorID().equals(curatorID)){
                curator.setCommission(curator.getCommission() + commission);
            }
        }
    }
    public void DisplayAllCurators(){
        for(Curator curator : myCurators){
            System.out.println(curator.ToString());
        }
    }
    public void sellArtpiece(){
        System.out.println("Please enter the ArtPieceID: ");
        Scanner scanner = new Scanner(System.in);
        String artPieceID = scanner.nextLine();
        if(peiceVerifier(artPieceID) != true){
            System.out.println("Error! These is no Artpiece with this ID!");
        }
        else{
            if(statusChecker(artPieceID) != 'D'){
                System.out.println("This artpice is already sold.");
            }
            else{
                System.out.println("Please enter the price: ");
                double price = scanner.nextDouble();
                if(price >= getEstimate(artPieceID)){
                    changeStatusAfterSale(artPieceID);
                    double estimate = getEstimate(artPieceID);
                    CommisionUpdate(artPieceID, price, estimate);
                    System.out.println("Success! Item has be sold!");
                }
                else{
                    System.out.println("Error! The entered price is" +
                            " below the actual value of the artpiece!");
                }
            }
        }
    }
    public String sellArtpiece(String artPieceID, double price){
        String msg = "";
        if(peiceVerifier(artPieceID) == true){
            msg = "Error! There exist one art piece with the ID.";
        }
        else{
            if(statusChecker(artPieceID) != 'D'){
                msg = "This art piece is already sold.";
            }
            else{
                if(price >= getEstimate(artPieceID)){
                    changeStatusAfterSale(artPieceID);
                    double estimate = getEstimate(artPieceID);
                    CommisionUpdate(artPieceID, price, estimate);
                    msg = "Success! Item has be sold!";
                }
                else{
                    msg = "Error! The entered price is" +
                            " below the actual value of the artpiece!";
                }
            }
        }
        return msg;
    }
}
