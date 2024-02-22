import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalletTest {

    // Ngetes apakah jika ownernya diganti apakah keganti ke yang terbaru
    @Test
    void testSetOwner(){
        String oldOwner = "Praneta";
        String newOwner = "Nata";
        Wallet myWallet = new Wallet(oldOwner);
        myWallet.setOwner(newOwner);
        Assertions.assertNotEquals(oldOwner, myWallet.getOwner());
    }

    // Ngetes Jika ditambah card apakah nambah atau tidak
    @Test
    void testAddCard(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCard("KTP");
        myWallet.addCard("SIM");
        myWallet.addCard("Alfamidi");
        myWallet.addCard("Mirota");
        Assertions.assertEquals(4, myWallet.getCards().size());
    }

    // Ngetes kalo ditambah card 3, terus diambil card yang sebelumnya tidak ditambahkan apakah berkurang atau tidak
    @Test
    void testTakeCartInvalid(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCard("SIM");
        myWallet.addCard("Alfamidi");
        myWallet.addCard("Mirota");
        myWallet.takeCard("KTP");
        Assertions.assertEquals(3, myWallet.getCards().size());
    }

    // Ngetes Kalo ditambah card 3, terus diambil card yang sebelumnya ditambahkan
    @Test
    void testTakeCartValid(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCard("SIM");
        myWallet.addCard("Alfamidi");
        myWallet.addCard("Mirota");
        myWallet.takeCard("SIM");
        Assertions.assertEquals(2, myWallet.getCards().size());
    }

    // Ngetes dapetin card setelah ditambahkan
    @Test
    void testGetCart(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCard("KTP");
        myWallet.addCard("SIM");
        myWallet.addCard("Mirota");
        Assertions.assertEquals(3, myWallet.getCards().size());
    }

    // Tes nambah uang kertas
    @Test
    void testAddMoney(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addMoney(20000);
        myWallet.addMoney(20000);
        Assertions.assertEquals(2, myWallet.getMoneys().get(20000));
    }

    // Tes kalo uang kertasnya tidak valid
    @Test
    void testAddMoneyInvalid(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addMoney(40000);
        Assertions.assertNull(myWallet.getMoneys().get(40000));
    }

    // Tes Kalo uang kertasnya valid
    @Test
    void testAddMoneyValid(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addMoney(10000);
        Assertions.assertNotNull(myWallet.getMoneys().get(10000));
    }

    // Test nambah koin yang sama
    @Test
    void testAddCoin(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCoin(500);
        myWallet.addCoin(500);
        Assertions.assertEquals(2, myWallet.getCoins().get(500));
    }

    // Test kalo koinnya tidak valid
    @Test
    void testAddCoinInvalid(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCoin(600);
        Assertions.assertNull(myWallet.getCoins().get(600));
    }

    // Test kalo koinnya valid
    @Test
    void testAddCoinValid(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCoin(500);
        Assertions.assertNotNull(myWallet.getCoins().get(500));
    }

    // Test mengambil uang kertas
    @Test
    void testTakeMoneys(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addMoney(50000);
        myWallet.addMoney(20000);
        myWallet.takeMoneys(20000);
        Assertions.assertEquals(0, myWallet.getMoneys().get(20000));
    }

    // Test mengambil koin
    @Test
    void testTakeCoins(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCoin(500);
        myWallet.takeCoins(500);
        Assertions.assertEquals(0, myWallet.getCoins().get(500));
    }

    // Test mengalkulasi jumlah uang kertas
    @Test
    void testCalculateMoneys(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addMoney(5000);
        myWallet.addMoney(20000);
        Assertions.assertEquals(25000, myWallet.calculateMoneys());
    }

    // Test mengalkulasi jumlah koin
    @Test
    void testCalculateCoins(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addCoin(500);
        myWallet.addCoin(1000);
        Assertions.assertEquals(1500, myWallet.calculateCoins());
    }

    // Test jumlah semua uang jika ditambah dan diambil
    @Test
    void testGetMoneyAvailable(){
        Wallet myWallet = new Wallet("Praneta");
        myWallet.addMoney(20000);
        myWallet.addCoin(500);
        myWallet.addMoney(50000);
        myWallet.addCoin(1000);
        myWallet.takeMoneys(10000);
        myWallet.takeCoins(1000);
        myWallet.takeCoins(500);
        Assertions.assertEquals(60000, myWallet.getMoneyAvailable());
    }
}
