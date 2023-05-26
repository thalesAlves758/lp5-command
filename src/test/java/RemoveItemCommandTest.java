import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RemoveItemCommandTest {
    Invoker invoker;
    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        invoker = new Invoker();
    }

    @Test
    void shouldRemoveAnItemFromInvetory() {
        Item item = new Item(1, "Smartphone");

        List<Item> items = new ArrayList<>();
        items.add(item);

        inventory.setItems(items);

        RemoveItemCommand removeItemCommand = new RemoveItemCommand(inventory, item);

        invoker.executeCommand(removeItemCommand);

        assertEquals(0, inventory.getItems().size());
    }

    @Test
    void shouldUndoRemovingAnItemFromInvetory() {
        Item item = new Item(1, "Smartphone");

        List<Item> items = new ArrayList<>();
        items.add(item);

        inventory.setItems(items);

        RemoveItemCommand removeItemCommand = new RemoveItemCommand(inventory, item);

        invoker.executeCommand(removeItemCommand);

        try {
            invoker.undoLastCommand();

            assertEquals(1, inventory.getItems().size());
            assertEquals(item, inventory.getItems().get(0));
        } catch (Exception e) {
            fail();
        }
    }
}
