/*
************************************************
* Kele Rivers
* AP CS A
* Period 1
* 22 October 2018
* Distance Project #1 (Theoretical Coordinates)
* **********************************************
 */

public class DistanceLab {
    public static void main(String[] args) {
        //Distance From Tacoma to Gig Harbor to Auburn round trip. VVV
        System.out.println(distance(16, 10, 4, 28, 21, 21));

    }
//Distance method.
    public static double distance(double c1x, double c1y, double c2x, double c2y, double c3x, double c3y) {
        //Distance from Tacoma to Gig Harbor.
        double pt1 = Math.pow((c2x - c1x), 2);
        double pt2 = Math.pow((c2y - c1y), 2);
        double d1 = Math.sqrt(pt1 + pt2);
        //Distance from Gig Harbor to Auburn.
        double twoPt1 = Math.pow((c3x -c2x), 2);
        double twoPt2 = Math.pow((c3y - c2y), 2);
        double d2 = Math.sqrt(twoPt1 + twoPt2);
        //Distance from Auburn to Tacoma.
        double threePt1 = Math.pow((c3x - c1x), 2);
        double threePt2 = Math.pow((c3y - c1y), 2);
        double d3 = Math.sqrt(threePt1 + threePt2);
        //Combined Distances for a round trip.
        double finalDistance = (d1 + d2 + d3);
        return finalDistance;
    }
}
