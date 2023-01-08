public class Main {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        try {
            Parse.reader(args, puzzle);//ready
            //add solving for puzzle

            //add output of solving process
            //add visualization
            System.out.println(puzzle.isSolvable());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}