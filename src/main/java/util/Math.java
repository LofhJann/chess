package util;

public class Math {

    private Math() {

    }

    public static int abs(int integer) {
        if (integer < 0) {
            return integer * (-1);
        }
        return integer;
    }
}
