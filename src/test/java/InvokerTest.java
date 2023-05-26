import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvokerTest {
    @Test
    void shouldExecuteACommand() {
        Inventory inventory = new Inventory();
        Invoker invoker = new Invoker();

        Item item = new Item(1, "Smartphone");

        AddItemCommand addItemCommand = new AddItemCommand(inventory, item);

        invoker.executeCommand(addItemCommand);

        assertEquals(1, invoker.getExecutedCommands().size());
        assertEquals(addItemCommand, invoker.getExecutedCommands().get(0));
    }

    @Test
    void shouldUndoLastExecutedCommand() {
        Inventory inventory = new Inventory();
        Invoker invoker = new Invoker();

        Item item = new Item(1, "Smartphone");

        AddItemCommand addItemCommand = new AddItemCommand(inventory, item);

        invoker.executeCommand(addItemCommand);

        try {
            invoker.undoLastCommand();

            assertEquals(0, invoker.getExecutedCommands().size());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldNotUndoLastExecutedCommand() {
        Invoker invoker = new Invoker();

        try {
            invoker.undoLastCommand();
            fail();
        } catch (Exception e) {
            assertEquals("No executed command was found", e.getMessage());
        }
    }
}
