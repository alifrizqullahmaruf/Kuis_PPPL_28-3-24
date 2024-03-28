import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    // Objek StringUtils yang akan diuji
    private StringUtils stringUtils;

    // Metode ini akan dijalankan sebelum semua pengujian dimulai
    @BeforeAll
    static void setUpAll() {
        System.out.println("Before all tests");
    }

    // Metode ini akan dijalankan sebelum setiap pengujian dimulai
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
        System.out.println("Before each test");
    }

    // Test untuk metode reverseString
    @Test
    @DisplayName("Test reverseString method with non-null input")
    void testReverseStringNonNullInput() {
        String input = "Alipp";
        String reversed = stringUtils.reverseString(input);
        assertEquals("ppilA", reversed);
    }

    @Test
    @DisplayName("Test reverseString method with null input")
    void testReverseStringNullInput() {
        assertNull(stringUtils.reverseString(null));
    }

    // Test untuk metode isPalindrome
    @Test
    @DisplayName("Test isPalindrome method with palindrome input")
    void testIsPalindromePalindromeInput() {
        String input = "radar";
        assertTrue(stringUtils.isPalindrome(input));
    }

    @Test
    @DisplayName("Test isPalindrome method with non-palindrome input")
    void testIsPalindromeNonPalindromeInput() {
        String input = "hello";
        assertFalse(stringUtils.isPalindrome(input));
    }

    @Test
    @DisplayName("Test isPalindrome method with null input")
    void testIsPalindromeNullInput() {
        assertFalse(stringUtils.isPalindrome(null));
    }

    // Test untuk metode countVowels
    @Test
    @DisplayName("Test countVowels method with vowels in input")
    void testCountVowelsWithVowels() {
        String input = "Hello";
        assertEquals(2, stringUtils.countVowels(input));
    }

    @Test
    @DisplayName("Test countVowels method with no vowels in input")
    void testCountVowelsWithNoVowels() {
        String input = "xyz";
        assertEquals(0, stringUtils.countVowels(input));
    }

    @Test
    @DisplayName("Test countVowels method with null input")
    void testCountVowelsNullInput() {
        assertEquals(0, stringUtils.countVowels(null));
    }

    // Metode ini akan dijalankan setelah setiap pengujian selesai
    @AfterEach
    void tearDown() {
        stringUtils = null;
        System.out.println("After each test");
    }

    // Metode ini akan dijalankan setelah semua pengujian selesai
    @AfterAll
    static void tearDownAll() {
        System.out.println("After all tests");
    }
}
