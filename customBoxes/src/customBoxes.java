import java.sql.SQLOutput;

public class customBoxes {
    public static final int BOX_WIDTH = 5;
    public static final int BOX_HEIGHT = 3;
    public static void main(String[] args) {
        SplatBox();
        DollarBox();
        SplatBox();

    }

    public static void SplatBox() {
        for (int x = 0; x < BOX_HEIGHT; x++) {
            for (int y = 0; y < BOX_WIDTH; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void DollarBox() {
        for (int x = 0; x < BOX_HEIGHT; x++) {
            for (int y = 0; y < BOX_WIDTH; y++) {
                System.out.print("$");
            }
            System.out.println();
        }
        System.out.println();
    }
}
