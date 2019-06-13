package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellMatrixTest { 

@Test
public void testTransfromStates() throws Exception { 
//TODO: Test goes here...
    int[][] a = {{1,0,1},{0,1,0},{1,1,1}};
    int[][] b = {{0,1,0},{0,0,0},{1,1,1}};
    CellMatrix cellMatrix = new CellMatrix(3,3,a);
    cellMatrix.transfromStatus();
    assertEquals(b, cellMatrix.getMatrix());
} 

/** 
* 
* Method: findLifedNum(int x, int y) 
* 
*/ 
@Test
public void testFindLifedNum() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getRowNum() 
* 
*/ 
@Test
public void testGetRowNum() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setRowNum(int rowNum) 
* 
*/ 
@Test
public void testSetRowNum() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getColNum() 
* 
*/ 
@Test
public void testGetColNum() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setColNum(int colNum) 
* 
*/ 
@Test
public void testSetColNum() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getMatrix() 
* 
*/ 
@Test
public void testGetMatrix() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setMatrix(int[][] matrix) 
* 
*/ 
@Test
public void testSetMatrix() throws Exception { 
//TODO: Test goes here... 
} 


} 
