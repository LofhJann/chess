package chess.engine.board;

/**
 * Converts square notation to index in Board array
 */
public enum Square {
    A1(0), B1(1), C1(2), D1(3), E1(4),
    F1(5), G1(6), H1(7), A2(16), B2(17),
    C2(18),D2(19), E2(20), F2(21), G2(22),
    H2(23), A3(32), B3(33), C3(34), D3(35),
    E3(36), F3(37), G3(38), H3(39), A4(48),
    B4(49), C4(50), D4(51), E4(52), F4(53),
    G4(54), H4(55), A5(64), B5(65), C5(66),
    D5(67), E5(68), F5(69), G5(70), H5(71),
    A6(80), B6(81), C6(82), D6(83), E6(84),
    F6(85), G6(86), H6(87), A7(96), B7(97),
    C7(98), D7(99), E7(100), F7(101), G7(102),
    H7(103), A8(112), B8(113), C8(114), D8(115),
    E8(116), F8(117), G8(118), H8(119);


    private final int intValue;

    Square(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    // TODO: THIS IS UGLY AF, REPLACE THIS!!!11!!1111!!!
    public static String getString(int intValue) {
        switch (intValue) {
            default:
                throw new IllegalArgumentException("integer given doesn't represent any square");
            case 0:
                return "A1";
            case 1:
                return "B1";
            case 2:
                return "C1";
            case 3:
                return "D1";
            case 4:
                return "E1";
            case 5:
                return "F1";
            case 6:
                return "G1";
            case 7:
                return "H1";
            case 16:
                return "A2";
            case 17:
                return "B2";
            case 18:
                return "C2";
            case 19:
                return "D2";
            case 20:
                return "E2";
            case 21:
                return "F2";
            case 22:
                return "G2";
            case 23:
                return "H2";
            case 32:
                return "A3";
            case 33:
                return "B3";
            case 34:
                return "C3";
            case 35:
                return "D3";
            case 36:
                return "E3";
            case 37:
                return "F3";
            case 38:
                return "G3";
            case 39:
                return "H3";
            case 48:
                return "A4";
            case 49:
                return "B4";
            case 50:
                return "C4";
            case 51:
                return "D4";
            case 52:
                return "E4";
            case 53:
                return "F4";
            case 54:
                return "G4";
            case 55:
                return "H4";
            case 64:
                return "A5";
            case 65:
                return "B5";
            case 66:
                return "C5";
            case 67:
                return "D5";
            case 68:
                return "E5";
            case 69:
                return "F5";
            case 70:
                return "G5";
            case 71:
                return "H5";
            case 80:
                return "A6";
            case 81:
                return "B6";
            case 82:
                return "C6";
            case 83:
                return "D6";
            case 84:
                return "E6";
            case 85:
                return "F6";
            case 86:
                return "G6";
            case 87:
                return "H6";
            case 96:
                return "A7";
            case 97:
                return "B7";
            case 98:
                return "C7";
            case 99:
                return "D7";
            case 100:
                return "E7";
            case 101:
                return "F7";
            case 102:
                return "G7";
            case 103:
                return "H7";
            case 112:
                return "A8";
            case 113:
                return "B8";
            case 114:
                return "C8";
            case 115:
                return "D8";
            case 116:
                return "E8";
            case 117:
                return "F8";
            case 118:
                return "G8";
            case 119:
                return "H8";
        }
    }
}
