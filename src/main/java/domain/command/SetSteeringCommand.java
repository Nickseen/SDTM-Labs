package domain.command;

public class SetSteeringCommand implements Command {
    private String[] currentSteering;
    private String newSteering;
    private String previousSteering;

    public SetSteeringCommand(String[] currentSteering, String newSteering) {
        this.currentSteering = currentSteering;
        this.newSteering = newSteering;
    }

    @Override
    public void execute() {
        previousSteering = currentSteering[0];
        currentSteering[0] = newSteering;
        System.out.println("✓ Steering Wheel Position set to: " + newSteering);
    }

    @Override
    public void undo() {
        currentSteering[0] = previousSteering;
        String type = (previousSteering != null) ? previousSteering : "None";
        System.out.println("↶ Undid steering choice. Current: " + type);
    }
}
