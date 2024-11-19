import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    /**
     * 测试目的：
     * 验证相等版本号（不同格式）的比较结果，确保忽略前导零。
     * 测试用例：
     * - "1.01" 与 "1.001"
     * - "1.0" 与 "1.0.0"
     */
    @Test
    void testEqualVersions() {
        Solution solution = new Solution();
        assertEquals(0, solution.compareVersion("1.01", "1.001"), "Test Case 1 Failed");
        assertEquals(0, solution.compareVersion("1.0", "1.0.0"), "Test Case 2 Failed");
        assertEquals(0, solution.compareVersion("0", "0.0.0"), "Test Case 3 Failed");
    }

    /**
     * 测试目的：
     * 验证当 version1 > version2 时的比较结果。
     * 测试用例：
     * - "1.2.3" 与 "1.2.2"
     * - "2.0" 与 "1.9.9"
     */
    @Test
    void testVersion1Greater() {
        Solution solution = new Solution();
        assertEquals(1, solution.compareVersion("1.2.3", "1.2.2"), "Test Case 4 Failed");
        assertEquals(1, solution.compareVersion("2.0", "1.9.9"), "Test Case 5 Failed");
        assertEquals(1, solution.compareVersion("1.0.1", "1"), "Test Case 6 Failed");
    }

    /**
     * 测试目的：
     * 验证当 version1 < version2 时的比较结果。
     * 测试用例：
     * - "0.1" 与 "1.1"
     * - "1.0.0" 与 "1.0.1"
     */
    @Test
    void testVersion1Smaller() {
        Solution solution = new Solution();
        assertEquals(-1, solution.compareVersion("0.1", "1.1"), "Test Case 7 Failed");
        assertEquals(-1, solution.compareVersion("1.0.0", "1.0.1"), "Test Case 8 Failed");
        assertEquals(-1, solution.compareVersion("1.0", "1.0.1.1"), "Test Case 9 Failed");
    }

    /**
     * 测试目的：
     * 验证边界情况，包括空字符串、null 和无效输入的处理。
     * 测试用例：
     * - "" 与 "1.0"
     * - null 与 "1.0"
     * - 非数字版本号 "a.b" 与 "1.0"
     */
    @Test
    void testInvalidInput() {
        Solution solution = new Solution();
        // 空字符串
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("", "1.0"), "Test Case 10 Failed");
        // null 值
        assertThrows(NullPointerException.class, () -> solution.compareVersion(null, "1.0"), "Test Case 11 Failed");
        // 非数字字符
        assertThrows(NumberFormatException.class, () -> solution.compareVersion("a.b", "1.0"), "Test Case 12 Failed");
    }

    /**
     * 测试目的：
     * 验证处理极大值版本号的能力。
     * 测试用例：
     * - "2147483647.0.0" 与 "2147483646.999.999"
     */
    @Test
    void testLargeNumbers() {
        Solution solution = new Solution();
        assertEquals(1, solution.compareVersion("2147483647.0.0", "2147483646.999.999"), "Test Case 13 Failed");
        assertEquals(-1, solution.compareVersion("1.0.0", "2147483647.0.0"), "Test Case 14 Failed");
    }
}
