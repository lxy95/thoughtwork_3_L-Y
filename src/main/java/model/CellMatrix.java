package model;

public class CellMatrix {
    //矩阵的行数
    private int rowNum;
    //矩阵的列数
    private int colNum;
    //矩阵内容
    private int[][] matrix;

    public CellMatrix(int rowNum, int colNum, int[][] matrix) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.matrix = matrix;
    }

    public void transfromStatus() {
        int[][] newMatrix = new int[rowNum][colNum];
        for (int x = 0; x < rowNum; x++) {
            for (int y = 0; y < colNum; y++) {
                newMatrix[x][y] = 0;
                int nearNum = findLifedNum(x, y);
                if (nearNum == 3) {
                    newMatrix[x][y] = 1;
                }
                else if (nearNum == 2) {
                    newMatrix[x][y] = matrix[x][y];
                }
            }
        }
        this.matrix = newMatrix;
    }

    //x横坐标 y纵坐标
    public int findLifedNum(int x, int y) {
        int num=0;
        //左边
        if(y!=0){
            num+=matrix[x][y-1];
        }
        //左上角
        if(x!=0&&y!=0){
            num+=matrix[x-1][y-1];
        }
        //上边
        if(x!=0){
            num+=matrix[x-1][y];
        }
        //右上
        if(x!=0&&y!=colNum-1){
            num+=matrix[x-1][y+1];
        }
        //右边
        if(y!=colNum-1){
            num+=matrix[x][y+1];
        }
        //右下
        if(x!=rowNum-1&&y!=colNum-1){
            num+=matrix[x+1][y+1];
        }
        //下边
        if(x!=rowNum-1){
            num+=matrix[x+1][y];
        }
        //左下
        if(x!=rowNum-1&&y!=0){
            num+=matrix[x+1][y-1];
        }
        return num;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
