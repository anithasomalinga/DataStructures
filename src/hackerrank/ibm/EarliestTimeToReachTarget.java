package hackerrank.ibm;

/**
 * Problem Statement
 *
 * In a 2D grid, you start at coordinate (startX, startY) and want to reach (endX, endY).
 * You are given a string directions of length n,
 * containing characters representing moves:
 * E: move right (x+1, y)
 * S: move down (x, y-1)
 * W: move left (x-1, y)
 * N: move up (x, y+1)
 *
 * At the ith second, you can either move one unit in the direction specified by directions[i] or stay in place.
 * Implement a function to calculate the earliest time required to reach the target.
 * Return -1 if the target cannot be reached within n seconds.
 *
 * Input
 *
 * startX, startY: integers representing the starting coordinates.
 * endX, endY: integers representing the target coordinates.
 * directions: string of length n representing the moves at each second.
 * Output
 * An integer representing the earliest time at which the target can be reached, or -1 if unreachable within n seconds.
 * Example:
 * directions = "WWNNSSE"
 * startX = 1
 * startY = -1
 * endX = -1
 * endY = -1
 * # Output
 * 6
 *
 * directions.length() is not necessarily the earliest time.
 * The string length n is only the maximum number of seconds available.
 * The earliest time is the first i + 1 at which you reach the target.
 * For example:
 * start = (0,0)
 * target = (2,0)
 * directions = "EEEEE"
 * You reach (2,0) at second 2, even though directions.length() = 5.
 * So:
 * return i + 1;
 * is what gives the earliest time, while directions.length() is the deadline.
 * If the target is never reached after processing all n directions, return -1.
 */
public class EarliestTimeToReachTarget {
    public static void main(String[] args) {

//        int startX = 0, startY = 0;
//        int endX = 2, endY = 1;
//        String directions = "EEN";
        int startX = 0, startY = 0;
        int endX = 2, endY = 0;
        String directions = "EEEEE";
        int op = earliestTime(startX, startY, endX, endY, directions);
        System.out.println(op);
    }

    public static int earliestTime(int startX, int startY,
                                   int endX, int endY,
                                   String directions) {
        if(startX == endX && startY == endY) {
            return 0;
        }
        for (int i = 0; i < directions.length(); i++) {
            char dir = directions.charAt(i);
            switch (dir) {
                case 'E':
                    if (startX < endX)
                        startX++;
                    break;
                case 'W':
                    if (startX > endX)
                        startX--;
                    break;
                case 'N':
                    if (startY < endY)
                        startY++;
                    break;
                case 'S':
                    if (startY > endY)
                        startY--;
                    break;
            }
            // Earliest time reached
            if (startX == endX && startY == endY) {
                return i + 1;
            }

        }
        return -1;
    }
}
