package util;
import model.CellMatrix;
import java.io.*;

public class Util {
    /**
     * 函数功能：读入二维数组数据
     * 输入：文件路径，String
     * 输出：二维数组
     */
    public static CellMatrix initMatrixFromFile(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line = reader.readLine();
            String[] array = line.split(" ");
            int rowNum = Integer.parseInt(array[0]);
            int colNum = Integer.parseInt(array[1]);
            int[][] matrix = new int[rowNum][colNum];
            for (int i = 0; i < rowNum; i++) {
                line = reader.readLine();
                array = line.split(" ");
                for (int j = 0; j < array.length; j++) {
                    matrix[i][j] = Integer.parseInt(array[j]);
                }
            }
            CellMatrix cellMatrix = new CellMatrix(rowNum,colNum,matrix);
            System.out.println(cellMatrix);
            return cellMatrix;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
