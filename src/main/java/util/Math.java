package util;

public class Math {

    private Math() {
    }

    /**
     *
     * @param integer Any Integer.
     * @return Absolute value of given integer
     */
    public static int abs(int integer) {
        if (integer < 0) {
            return integer * (-1);
        }
        return integer;
    }
}
