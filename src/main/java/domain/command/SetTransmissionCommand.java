package domain.command;

public class SetTransmissionCommand implements Command {
    private String[] currentTransmission;
    private String newTransmission;
    private String previousTransmission;

    public SetTransmissionCommand(String[] currentTransmission, String newTransmission) {
        this.currentTransmission = currentTransmission;
        this.newTransmission = newTransmission;
    }

    @Override
    public void execute() {
        previousTransmission = currentTransmission[0];
        currentTransmission[0] = newTransmission;
        System.out.println("✓ Transmission set to: " + newTransmission);
    }

    @Override
    public void undo() {
        currentTransmission[0] = previousTransmission;
        String type = (previousTransmission != null) ? previousTransmission : "None";
        System.out.println("↶ Undid transmission choice. Current: " + type);
    }
}
