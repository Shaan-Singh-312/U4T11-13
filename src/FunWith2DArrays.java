import java.util.ArrayList;

public class FunWith2DArrays {
    public static int totalElements(int[][] arr) {
        return arr.length * arr[0].length;
    }

    public static void fourCorners(String[][] arr) {
        System.out.println(arr[0][0]);
        System.out.println(arr[0][arr[0].length - 1]);
        System.out.println(arr[arr.length - 1][0]);
        System.out.println(arr[arr.length - 1][arr[arr.length - 1].length - 1]);
    }

    public static void swapFrontAndBackRows(String[][] arr) {
        String[] temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }

    public static double average(int[][] ints) {
        int total = 0;
        for (int[] row : ints) {
            for (int num : row) {
                total += num;
            }
        }
        return (double) total / totalElements(ints);
    }

    public static int edgeSum(int[][] ints) {
        int total = 0;
        for (int i = 0; i < ints[0].length; i++) {
            total += ints[0][i] + ints[ints.length - 1][i];
        }
        for (int i = 1; i < ints.length - 1; i++) {
            total += ints[i][0] + ints[i][ints[i].length - 1];
        }
        return total;
    }

    public static int[] indexFound(String[][] strings, String target) {
        for (int col = 0; col < strings[0].length; col++) {
            for (int row = 0; row < strings.length; row++) {
                if (strings[row][col].equals(target)) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[][] split(int[][] ints, int row, int column) {
        if (ints.length <= row || ints[0].length <= column) return new int[0][0];
        int[][] result = new int[row + 1][column + 1];

        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < column + 1; j++) {
                result[i][j] = ints[i][j];
            }

        }
        return result;
    }

    public static int[][] invert(int[][] ints) {
        int[][] arr = new int[ints[0].length][ints.length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                arr[j][i] = ints[i][j];
            }

        }
        return arr;
    }

    /**
     * Return the sum of all elements of arr that are in the one particular row,
     * specified by the row parameter
     * <p>
     * PRECONDITION:  0 <= row < arr.length (i.e. row is guaranteed to be valid)
     *
     * @param arr 2D array of ints
     * @param row the row to add up
     * @return the sum of all elements in row
     */
    public static int sumForRow(int[][] arr, int row) {
        int sum = 0;
        for (int i = 0; i < arr[row].length; i++) {
            sum += arr[row][i];
        }
        return sum;
    }

    /**
     * Return the sum of all elements of arr that are in the one particular column
     * <p>
     * PRECONDITION:  0 <= col < arr[0].length (i.e. col is valid)
     *
     * @param arr 2D array of ints
     * @param col the column to add up
     * @return the sum of all elements in column
     */
    public static int sumForColumn(int[][] arr, int col) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][col];
        }
        return sum;
    }

    /**
     * Replaces all even integers in arr with 0; all odd integers are unchanged.
     * It then returns the number of changes that were made.
     * <p>
     * Example: if arr is {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {4, 6, 8, 3, 5}}
     * then this method modifies arr to be:
     * {{1, 0, 3, 0, 5}, {0, 7, 0, 9, 0}, {0, 0, 0, 3, 5}}
     * and returns 8 (the number of even numbers replaced by 0)
     * <p>
     * POSTCONDITION: this method modifies the original 2D array referenced by arr
     *
     * @param arr 2D array of ints
     * @return the number of changes made
     */
    public static int replaceEvensWithZero(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] % 2 == 0) {
                    arr[i][j] = 0;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Searches through the 2D array wordChart and finds all strings with
     * length len; these strings are added to an ArrayList and returned.
     * If no strings have that length, return an empty ArrayList
     *
     * @param wordChart 2D array of Strings
     * @param len       the length of strings to search for
     * @return an ArrayList containing all strings in wordChart with length len
     */
    public static ArrayList<String> findStringsOfLength(String[][] wordChart, int len) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < wordChart.length; i++) {
            for (int j = 0; j < wordChart[0].length; j++) {
                if (wordChart[i][j].length() == len) {
                    strings.add(wordChart[i][j]);
                }
            }
        }
        return strings;
    }

    /**
     * calculates and returns the average class grade as a double for a
     * all Students in the 2D array seatingChart
     * <p>
     * PRECONDITION:  seatingChart contains at least one element with at least
     * one student (i.e. no need to worry about division by 0)
     *
     * @param seatingChart 2D array of Student objects
     * @return the average grade of all Students in seatingChart, as a double
     */
    public static double classAverage(Student[][] seatingChart) {
        int total = 0;
        for (int i = 0; i < seatingChart.length; i++) {
            for (int j = 0; j < seatingChart[0].length; j++) {
                total += seatingChart[i][j].getGrade();
            }
        }

        return (double) total / (seatingChart.length * seatingChart[0].length);
    }

    /**
     * Returns true if any two consecutive elements, horizontally or vertically,
     * are equal, false otherwise.  You do not need to check for "wrap around"
     * consecutiveness, such as if the last element in a row is the same as
     * the first:
     * <p>
     * For example, if arr is:
     * 1, 2, 3, 4
     * 2, 7, 3, 5
     * 3, 4, 5, 6
     * <p>
     * then this method returns true because there is a pair of consecutive
     * numbers (vertically)
     * <p>
     * As another example, if arr is:
     * 1, 2, 3, 4
     * 2, 7, 8, 5
     * 3, 4, 4, 6
     * <p>
     * then this method returns true because there is a pair of consecutive
     * numbers (horizontally)
     * <p>
     * As another example, if arr is:
     * 1, 2, 3, 8
     * 2, 7, 8, 5
     * 3, 2, 5, 3
     * <p>
     * then this method returns false because there are not two consecutive
     * numbers, vertically or horizontally, that are equal.
     * <p>
     * NOTE: do not consider "wrap around" consecutive numbers, in other words,
     * the 3's and 6's below are not considered consecutive:
     * 1, 6, 3, 8
     * 2, 7, 8, 5
     * 3, 6, 5, 3
     * <p>
     * Similarly, equal numbers on a diagonal are not considered consecutive,
     * so the 8's below are not consecutive:
     * 1, 2, 3, 8
     * 2, 7, 8, 5
     * 3, 2, 5, 3
     *
     * @param arr 2D array of ints
     */
    public static boolean consecutive(int[][] arr) {
        int[][] arr2 = new int[arr.length + 2][arr[0].length + 2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr2[i + 1][j + 1] = arr[i][j];
            }
        }

        for (int i = 1; i < arr2.length - 1; i++) {
            for (int j = 1; j < arr2[0].length - 1; j++) {
                int up = arr2[i - 1][j];
                int down = arr2[i + 1][j];
                int left = arr2[i][j - 1];
                int right = arr2[i][j + 1];
                int currentPosition = arr2[i][j];
                if (currentPosition == up || currentPosition == down || currentPosition == left || currentPosition == right)
                    return true;
            }

        }
        return false;
    }

    /**
     * A "magic square" is a square grid filled with distinct integers such
     * that each element is a different integer, and the sum of the integers
     * in each row, column and diagonal is equal.  This method should return true
     * if arr is a magic square.
     * <p>
     * PRECONDITION: arr is a square 2D array with the same number of rows and
     * columns
     * <p>
     * For example, if arr is:
     * 7, 2, 3
     * 0, 4, 8
     * 5, 6, 1
     * <p>
     * then this method returns true because each row, column, and diagonal add
     * up to the same sum (12) and all numbers are unique (i.e. no duplicate
     * values appear)
     * <p>
     * As another example, if arr is the following (note the 3 and 2 swapped):
     * 7, 3, 2
     * 0, 4, 8
     * 5, 6, 1
     * <p>
     * then this method returns false because the column sums no longer add up to
     * the same value
     * <p>
     * As another example, if arr is:
     * 1, 3, 2
     * 3, 2, 1
     * 2, 1, 3
     * <p>
     * then this method returns false because, although the rows, columns, and
     * diagonals add up to the same sum (6), there are duplicate numbers.
     *
     * @param arr 2D array of ints
     */
    public static boolean magicSquare(int[][] arr) {
        ArrayList<Integer> seenNums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int num : seenNums) {
                    if (num == arr[i][j]) {
                        return false;
                    }
                }
                seenNums.add(arr[i][j]);
            }
        }
        int totalSum = 0;
        //Find sum value of Square
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[0][i];
        }

        //Check Rows
        for (int i = 0; i < arr.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < arr.length; j++) {
                rowSum += arr[i][j];
            }
            if (rowSum != totalSum) return false;
        }

        //Check Columns
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
            if (sum != totalSum) return false;
        }

        //Check Diagonals

        int diagonalSum = 0;
        int diagonalSum2 = 0;

        for (int i = 0; i < arr.length; i++) {
            diagonalSum += arr[i][i];
            diagonalSum2 += arr[arr.length - i - 1][arr.length - i - 1];
        }
        if (diagonalSum != totalSum || diagonalSum2 != totalSum) return false;

        return true;
    }


}
