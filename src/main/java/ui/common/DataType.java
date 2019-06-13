package ui.common;

public enum DataType {
    CLEAR,
    GLIDER,
    SMALL_EXPLODER,
    EXPLODER,
    CELL_ROW_10,
    LIGHTWEIGHT_SPACESHIP,
    TUMBLER,
    GOSPER_GLIDER_GUN;

    public static String toString(DataType dtype) {
        switch (dtype) {
            case CLEAR:
                return "clear";
            case GLIDER:
                return "glider";
            case SMALL_EXPLODER:
                return "small exploder";
            case EXPLODER:
                return "exploder";
            case CELL_ROW_10:
                return "10 cell row";
            case LIGHTWEIGHT_SPACESHIP:
                return "lightweight";
            case TUMBLER:
                return "tumbler";
            case GOSPER_GLIDER_GUN:
                return "gosper glider gun";
        }
        return "clear";
    }
}
