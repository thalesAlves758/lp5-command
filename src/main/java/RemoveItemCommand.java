public class RemoveItemCommand implements Command {
    private Inventory inventory;
    private Item item;

    public RemoveItemCommand(Inventory inventory, Item item) {
        this.inventory = inventory;
        this.item = item;
    }

    public void execute() {
        inventory.removeItem(item);
    }

    public void undo() {
        inventory.addItem(item);
    }
}
