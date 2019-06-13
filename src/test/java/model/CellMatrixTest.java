package model;

import model.CellMatrix;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import util.Util;

import static org.junit.Assert.assertEquals;

/** 
* CellMatrix Tester. 
* 
* @author <Authors name> 
* @since <pre>Jun 12, 2019</pre> 
* @version 1.0 
*/ 
public class CellMatrixTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: transfromStates() 
* 
*/ 
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
