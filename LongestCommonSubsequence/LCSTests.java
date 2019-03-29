package lcs;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashSet;
import java.util.Arrays;

public class LCSTests {
    
    // Bottom-up LCS Tests
    // -----------------------------------------------
    @Test
    public void BULCSTest_t0() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                ""
            )),
            LCS.bottomUpLCS("", "")
        );
        // LCS.memoCheck can either be the 1 element matrix
        // or null -- up to you, I won't check for cases with
        // empty-String arguments
    }
    
    @Test
    
    public void BULCSTest_t1() {
        // First assertion: correctness test for set with LCS
        assertEquals(
            new HashSet<>(Arrays.asList(
                ""
            )),
            LCS.bottomUpLCS("A", "B")
        );
        // Second assertion: proper format / solution of memo table
        assertArrayEquals(
            new int[][] {
                {0, 0},
                {0, 0}
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void BULCSTest_t2() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "A"
            )),
            LCS.bottomUpLCS("A", "A")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0},
                {0, 1}
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void BULCSTest_t3() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "ABC"
            )),
            LCS.bottomUpLCS("ABC", "ABC")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 2, 2},
                {0, 1, 2, 3}
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void BULCSTest_t4() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "AA", "BA"
            )),
            LCS.bottomUpLCS("ABA", "BAA")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 2, 2}
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void BULCSTest_t5() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "TGACA"
            )),
            LCS.bottomUpLCS("TGATCA", "GTGACAT")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 2, 2, 2, 2, 2},
                {0, 1, 1, 2, 3, 3, 3, 3},
                {0, 1, 2, 2, 3, 3, 3, 4},
                {0, 1, 2, 2, 3, 4, 4, 4},
                {0, 1, 2, 2, 3, 4, 5, 5}
                
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void BULCSTest_t6() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "ACA", "ACD", "AAD"
            )),
            LCS.bottomUpLCS("ACAD", "ABACDA")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 2, 2, 2},
                {0, 1, 1, 2, 2, 2, 3},
                {0, 1, 1, 2, 2, 3, 3},

                
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void BULCSTest_t7() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                ""
            )),
           // LCS.topDownLCS("ABCDEFGHIJKL12345!", "MNOPQRSTUVWXYZ6789")
            LCS.bottomUpLCS("ABCDEFGHIJ", "MNOPQRSTUVWXYZ6789")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                //runs in 5.5 seconds for 10 x 18
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

                
            },
            LCS.memoCheck
        );
    }
    
    
    // Top-Down LCS Tests
    // -----------------------------------------------
    @Test
    public void TDLCSTest_t0() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                ""
            )),
            LCS.topDownLCS("", "")
        );
        // LCS.memoCheck can either be the 1 element matrix
        // or null -- up to you, I won't check for cases with
        // empty-String arguments
    }
    
    @Test
    public void TDLCSTest_t1() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                ""
            )),
            LCS.topDownLCS("A", "B")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0},
                {0, 0}
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void TDLCSTest_t2() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "A"
            )),
            LCS.topDownLCS("A", "A")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0},
                {0, 1}
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void TDLCSTest_t3() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "ABC"
            )),
            LCS.topDownLCS("ABC", "ABC")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 3}
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void TDLCSTest_t4() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "AA", "BA"
            )),
            LCS.topDownLCS("ABA", "BAA")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 2}
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void TDLCSTest_t5() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "TGACA"
            )),
            LCS.topDownLCS("TGATCA", "GTGACAT")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 2, 2, 2, 0, 0},
                {0, 1, 1, 2, 3, 3, 3, 0},
                {0, 0, 2, 2, 3, 3, 3, 4},
                {0, 0, 0, 0, 0, 4, 4, 4},
                {0, 0, 0, 0, 0, 0, 5, 5}
                
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void TDLCSTest_t6() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                "ACA", "ACD", "AAD"
            )),
            LCS.topDownLCS("ACAD", "ABACDA")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 0, 2, 2, 0},
                {0, 0, 0, 2, 2, 0, 3},
                {0, 0, 0, 0, 0, 3, 3},

                
            },
            LCS.memoCheck
        );
    }
    
    @Test
    public void TDLCSTest_t7() {
        assertEquals(
            new HashSet<>(Arrays.asList(
                ""
            )),
           // LCS.topDownLCS("ABCDEFGHIJKL12345!", "MNOPQRSTUVWXYZ6789")
            LCS.topDownLCS("ABCDEFGHIJ", "MNOPQRSTUVWXYZ6789")
        );
        assertArrayEquals(
            new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                //runs in 5.5 seconds for 10 x 18
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

                
            },
            LCS.memoCheck
        );
    }
}
