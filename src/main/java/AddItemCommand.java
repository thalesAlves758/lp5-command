public class AddItemCommand implements Command {
    private Inventory inventory;
    private Item item;

    public AddItemCommand(Inventory inventory, Item item) {
        this.inventory = inventory;
        this.item = item;
    }

    public void execute() {
        inventory.addItem(item);
    }

    public void undo() {
        inventory.removeItem(item);
    }
}
