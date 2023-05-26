import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddItemCommandTest {
    Invoker invoker;
    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        invoker = new Invoker();
    }

    @Test
    void shouldAddAnItemIntoInvetory() {
        Item item = new Item(1, "Smartphone");
        AddItemCommand addItemCommand = new AddItemCommand(inventory, item);

        invoker.executeCommand(addItemCommand);

        assertEquals(1, inventory.getItems().size());
        assertEquals(item, inventory.getItems().get(0));
    }

    @Test
    void shouldAddAndRemoveAnItemIntoInvetory() {
        Item item = new Item(1, "Smartphone");
        AddItemCommand addItemCommand = new AddItemCommand(inventory, item);

        invoker.executeCommand(addItemCommand);

        try {
            invoker.undoLastCommand();

            assertEquals(0, inventory.getItems().size());
        } catch (Exception e) {
            fail();
        }
    }
}
