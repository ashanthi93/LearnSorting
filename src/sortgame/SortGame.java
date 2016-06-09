package sortgame;

/**
 *
 * @author ASHI
 */
public class SortGame {

    public static HomeScreen homeScreen = new HomeScreen();

    public static void main(String[] args) {

        homeScreen.setLocation(400, 100);
        homeScreen.setSize(500, 300);
        homeScreen.setResizable(false);
        homeScreen.setVisible(true);
    }

}
