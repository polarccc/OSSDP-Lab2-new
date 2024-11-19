import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
//import Solution15;

class L2022111654_15_Test {
    @Test
    void testCompareVersion() {
        Solution15 solution = new Solution15();

        // 示例测试用例
        assertEquals(0, solution.compareVersion("1.01", "1.001"));
        assertEquals(0, solution.compareVersion("1.0", "1.0.0"));
        assertEquals(-1, solution.compareVersion("0.1", "1.1"));

        // 添加新的测试用例
        assertEquals(1, solution.compareVersion("1.2.3", "1.2.2"));
        assertEquals(-1, solution.compareVersion("1.0.0", "1.0.1"));
    }
}
