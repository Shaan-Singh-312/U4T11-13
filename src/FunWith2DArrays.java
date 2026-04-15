public class FunWith2DArrays {
    public static int totalElements(int[][] arr){
        return arr.length * arr[0].length;
    }

    public static void fourCorners(String[][] arr){
        System.out.println(arr[0][0]);
        System.out.println(arr[0][arr[0].length -1]);
        System.out.println(arr[arr.length -1][0]);
        System.out.println(arr[arr.length -1][arr[arr.length -1].length -1]);
    }

    public static void swapFrontAndBackRows(String[][] arr){
        String[] temp = arr[0];
        arr[0] = arr[arr.length -1];
        arr[arr.length -1] = temp;
    }
}
