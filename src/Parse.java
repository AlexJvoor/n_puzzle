import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parse {
    private static int []extractArray(String str) {
        String []splitedStr = str.split(" ");
        int[] array =  new int[splitedStr.length];
        for(int i = 0; i < splitedStr.length; i++) {
            array[i] = Integer.parseInt(splitedStr[i]);
        }
        return array;
    }

    public static void reader(String []args, Puzzle puzzle) throws Exception {
        String line;
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bReader = new BufferedReader(fileReader);

        line = bReader.readLine();
        puzzle.setSize(Integer.parseInt(line));
        int [][]array = new int[puzzle.size][puzzle.size];
        for (int i = 0; i < puzzle.size; i++) {
            line = bReader.readLine();
            int[] arr = extractArray(line);
            array[i] = arr;
        }
        if (validate(array, puzzle)){
            puzzle.setFields(array);
        }
    }

    private static boolean validate(int[][] array, Puzzle puzzle){
        int max = puzzle.size*puzzle.size;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < puzzle.size; i++) {
            if (array[i].length != puzzle.size) {
                return false;
            }
            for (int j = 0; j < puzzle.size; j++) {
                if (array[i][j] == 0) {
                    puzzle.zeroX = i;
                    puzzle.zeroY = j;
                }
                if (array[i][j] >= max || list.contains(array[i][j])) {
                    return false;
                }
                list.add(array[i][j]);
            }
        }
        return true;
    }
}
