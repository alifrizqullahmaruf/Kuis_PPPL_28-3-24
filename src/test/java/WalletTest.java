import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    // Objek Wallet yang akan diuji
    private Wallet wallet;

    // Metode ini akan dijalankan sebelum semua pengujian dimulai
    @BeforeAll
    static void setUpAll() {
        System.out.println("Before all tests");
    }

    // Metode ini akan dijalankan sebelum setiap pengujian dimulai
    @BeforeEach
    void setUp() {
        wallet = new Wallet(100.0, "USD"); // Set saldo awal $100 dan mata uang USD
        System.out.println("Before each test");
    }

    // Test untuk metode getBalance
    @Test
    @DisplayName("Test getBalance method")
    void testGetBalance() {
        assertEquals(100.0, wallet.getBalance());
    }

    // Test untuk metode getCurrency
    @Test
    @DisplayName("Test getCurrency method")
    void testGetCurrency() {
        assertEquals("USD", wallet.getCurrency());
    }

    // Test untuk metode depositAmount
    @Test
    @DisplayName("Test depositAmount method with positive amount")
    void testDepositAmountPositive() {
        wallet.depositAmount(50.0);
        assertEquals(150.0, wallet.getBalance());
    }

    @Test
    @DisplayName("Test depositAmount method with negative amount")
    void testDepositAmountNegative() {
        assertThrows(IllegalArgumentException.class, () -> wallet.depositAmount(-50.0));
    }

    // Test untuk metode withdrawAmount
    @Test
    @DisplayName("Test withdrawAmount method with sufficient balance")
    void testWithdrawAmountSufficientBalance() {
        assertTrue(wallet.withdrawAmount(50.0));
        assertEquals(50.0, wallet.getBalance());
    }

    @Test
    @DisplayName("Test withdrawAmount method with insufficient balance")
    void testWithdrawAmountInsufficientBalance() {
        assertFalse(wallet.withdrawAmount(150.0));
        assertEquals(100.0, wallet.getBalance()); // Saldo tidak berubah karena penarikan gagal
    }

    @Test
    @DisplayName("Test withdrawAmount method with negative amount")
    void testWithdrawAmountNegative() {
        assertThrows(IllegalArgumentException.class, () -> wallet.withdrawAmount(-50.0));
    }

    // Test untuk metode transferFunds
    @Test
    @DisplayName("Test transferFunds method with sufficient balance and same currency")
    void testTransferFundsSufficientBalanceSameCurrency() {
        Wallet recipient = new Wallet(0.0, "USD");
        wallet.transferFunds(recipient, 50.0);
        assertEquals(50.0, wallet.getBalance());
        assertEquals(50.0, recipient.getBalance());
    }

    @Test
    @DisplayName("Test transferFunds method with insufficient balance")
    void testTransferFundsInsufficientBalance() {
        Wallet recipient = new Wallet(0.0, "USD");
        assertThrows(IllegalArgumentException.class, () -> wallet.transferFunds(recipient, 150.0));
    }

    @Test
    @DisplayName("Test transferFunds method with different currencies")
    void testTransferFundsDifferentCurrencies() {
        Wallet recipient = new Wallet(0.0, "EUR");
        assertThrows(IllegalArgumentException.class, () -> wallet.transferFunds(recipient, 50.0));
    }

    // Metode ini akan dijalankan setelah setiap pengujian selesai
    @AfterEach
    void tearDown() {
        wallet = null;
        System.out.println("After each test");
    }

    // Metode ini akan dijalankan setelah semua pengujian selesai
    @AfterAll
    static void tearDownAll() {
        System.out.println("After all tests");
    }
}
