package domain.command;

public class SetBodyTypeCommand implements Command {
    private String[] currentBodyType;
    private String newBodyType;
    private String previousBodyType;

    public SetBodyTypeCommand(String[] currentBodyType, String newBodyType) {
        this.currentBodyType = currentBodyType;
        this.newBodyType = newBodyType;
    }

    @Override
    public void execute() {
        previousBodyType = currentBodyType[0];
        currentBodyType[0] = newBodyType;
        System.out.println("✓ Body Type set to: " + newBodyType);
    }

    @Override
    public void undo() {
        currentBodyType[0] = previousBodyType;
        String type = (previousBodyType != null) ? previousBodyType : "None";
        System.out.println("↶ Undid body type choice. Current: " + type);
    }
}
