package domain.command;

import domain.models.CustomCar;

public class AddBodyKitCommand implements Command {
    private final CustomCar car;
    private final String kit;

    public AddBodyKitCommand(CustomCar car, String kit) {
        this.car = car;
        this.kit = kit;
    }

    @Override
    public void execute() {
        car.addBodyKit(kit);
        System.out.println("Added body kit: " + kit);
    }

    @Override
    public void undo() {
        // remove last occurrence of kit
        car.getBodyKits().remove(kit);
        System.out.println("Undid body kit: " + kit);
    }
}
