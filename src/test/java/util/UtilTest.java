package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UtilTest { 

@Test
public void testInitMatrixFromFile() throws Exception { 
//TODO: Test goes here...
    int[][] a = {{1,0,1},{0,1,0},{1,1,1}};
    String dir = "/mnt/hgfs/Share_Ubuntu/tw/gol/";
    assertEquals(a, new Util().initMatrixFromFile(dir+"configs/case_0").getMatrix());
} 


} 
