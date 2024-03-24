import java.lang.constant.Constable;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Gallery gal = new Gallery();
        while (true) {
            System.out.println("Please select one of the following options: \n" +
                    "1. Add Curator \n" + "2. Add Artist \n" + "3. Add ArtPiece \n" +
                    "4. Sell ArtPiece \n" + "5. Display Inventory \n" + "6. Display All Curators \n" + "7. Exit \n");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    gal.addCurator();
                    break;
                case "2":
                    gal.addArtist();
                    break;
                case "3":
                    gal.addPiece();
                    break;
                case "4":
                    gal.sellArtpiece();
                    break;
                case "5":
                    gal.DisplyAllArtpieces();
                    break;
                case "6":
                    gal.DisplayAllCurators();
                    break;
                case "7":
                    System.exit(0);
            }
        }
    }
}