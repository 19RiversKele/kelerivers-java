public class Drawboxes {
    public static void main(String[] args) {
        var securityCounter = 0;
        for (var i = 0; i < 3; i++) {
            securityCounter ++;
            if (securityCounter == 10) {
                break;
            }

            drawBox();
        }

    }

    public static void drawBox() {
        System.out.println();
        topBottom();
        sides();
        topBottom();
    }

    public static void topBottom() {
        System.out.println("+---+");
    }
    public static void sides() {
        System.out.println("|   |");
        System.out.println("|   |");
        System.out.println("|   |");
    }
}
