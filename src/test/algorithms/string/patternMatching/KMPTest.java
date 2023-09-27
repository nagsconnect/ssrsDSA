package algorithms.string.patternMatching;

import com.penjarla.dsa.string.patternMatching.KMP;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class KMPTest {
    private KMP kmp;

    @BeforeClass
    public void init() {
        kmp = new KMP();
    }

    @Test
    public void testSampleKMP() {
        String s = "abcdabcxabcdabcy";
        String p = "abcdabcy";
        Assert.assertEquals(Arrays.asList(8), kmp.searchPattern(s, p));
    }

    @Test
    public void testMultipleSampleKMP() {
        String s = "abcdabcxabcdabcyabcdabcxabcdabcy";
        String p = "abcdabcy";
        Assert.assertEquals(Arrays.asList(8, 24), kmp.searchPattern(s, p));
    }

    @Test
    public void testLongSearchStringKMP() {
        String s = "abcxyabcdaxabcdabcaabcxyabcdaxabcdabcxabcxyabcdaxabcdabcyabcxyabcdaxabcdabcz";
        String p = "abcdabca";
        Assert.assertEquals(Arrays.asList(11), kmp.searchPattern(s, p));
    }
}
