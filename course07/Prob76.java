public class Prob76 {
    static final double R = 6371;

    private static double deg2rad(double d) {
        return d * Math.PI / 180;
    }

    private static double hav(double theta) {
        return (1.0 - Math.cos(theta)) / 2;
    }

    private static double ahav(double h) {
        return 2 * Math.asin(Math.sqrt(h));
    }

    private static double calc_d(double a1, double a2, double b1, double b2) {
        double phi1 = deg2rad(a1);
        double phi2 = deg2rad(a2);
        double lambda1 = deg2rad(b1);
        double lambda2 = deg2rad(b2);

        double hav_theta = hav(phi2 - phi1) + Math.cos(phi1) * Math.cos(phi2) * hav(lambda2 - lambda1);
        double d = R * ahav(hav_theta);

        return d;
    }

    public static void main(String[] args) {
        double a1 = Double.parseDouble(args[0]);
        double b1 = Double.parseDouble(args[1]);
        double a2 = Double.parseDouble(args[2]);
        double b2 = Double.parseDouble(args[3]);

        System.out.println(calc_d(a1, a2, b1, b2));
    }
}
