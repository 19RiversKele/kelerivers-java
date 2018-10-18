public class DrawBoxes2 {
    public static void main(String[] args) {
       box(5,5,"*");
       box(4,4,"#");
       box(7,7,"&");
    }

    public static void box(int height, int width, String symbol) {
        for (int row = 0; row < height; row++ ) {
           for (int column = 0; column < width; column++) {
               System.out.print(symbol);
           }
            System.out.println();
        }
        System.out.println();
    }
}
