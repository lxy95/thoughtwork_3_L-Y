package util;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* Util Tester. 
* 
* @author <Authors name> 
* @since <pre>Jun 12, 2019</pre> 
* @version 1.0 
*/ 
public class UtilTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: initMatrixFromFile(String path) 
* 
*/ 
@Test
public void testInitMatrixFromFile() throws Exception { 
//TODO: Test goes here...
    int[][] a = {{1,0,1},{0,1,0},{1,1,1}};
    String dir = "/mnt/hgfs/Share_Ubuntu/tw/gol/";
    assertEquals(a, new Util().initMatrixFromFile(dir+"configs/case_0").getMatrix());
} 


} 
