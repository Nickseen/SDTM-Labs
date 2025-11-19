package domain.command;

import domain.models.Engine;

public class ChooseEngineCommand implements Command {
    private Engine[] currentEngine;
    private Engine newEngine;
    private Engine previousEngine;

    public ChooseEngineCommand(Engine[] currentEngine, Engine newEngine) {
        this.currentEngine = currentEngine;
        this.newEngine = newEngine;
    }

    @Override
    public void execute() {
        previousEngine = currentEngine[0];
        currentEngine[0] = newEngine;
        System.out.println("✓ Engine set to: " + newEngine.getType());
    }

    @Override
    public void undo() {
        currentEngine[0] = previousEngine;
        String type = (previousEngine != null) ? previousEngine.getType() : "None";
        System.out.println("↶ Undid engine choice. Current: " + type);
    }
}
