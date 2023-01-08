import java.util.ArrayList;
import java.util.List;

public class Puzzle {
    int size;
    int zeroX;
    int zeroY;
    int[][] fields;

    void setSize(int size) {
        this.size = size;
    }

    void setFields(int[][] fields) {
        this.fields = fields;
    }

    void setZeroX(int zeroX) {
        this.zeroX = zeroX;
    }

    void setZeroY(int zeroY) {
        this.zeroY = zeroY;
    }

    boolean isSolvable() {
        if (size % 2 == 1 && countInversions() % 2 == 0) {
                return true;
        }
        else if (zeroX % 2 == 0 && countInversions() % 2 == 1 ||
                zeroX % 2 == 1 && countInversions() % 2 == 0) {
            return true;
        }
        return false;
    }

    private int countInversions() {
        int counter = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (Integer integer : list) {
                    if (fields[i][j] < integer && fields[i][j] != 0) {
                        counter++;
                    }
                }
                list.add(fields[i][j]);
            }
        }
        return counter;
    }
}
