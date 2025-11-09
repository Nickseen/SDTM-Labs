package domain.models;

import java.util.List;
import java.util.Arrays;

public enum BodyKitModel {
    ABT_SPORTSLINE("ABT Sportsline", Arrays.asList(
        "Sport Spoiler", 
        "Side Skirts", 
        "Carbon Diffuser"
    )),
    
    M_PERFORMANCE("M-Performance", Arrays.asList(
        "Carbon Fiber Hood", 
        "Racing Spoiler", 
        "M Side Skirts"
    )),
    
    AMG_LINE("AMG Line", Arrays.asList(
        "AMG Spoiler", 
        "AMG Side Skirts", 
        "Chrome Elements"
    )),
    
    RS_PACKAGE("RS Package", Arrays.asList(
        "RS Front Bumper", 
        "RS Side Blades", 
        "RS Rear Spoiler"
    ));

    private final String displayName;
    private final List<String> kits;

    BodyKitModel(String displayName, List<String> kits) {
        this.displayName = displayName;
        this.kits = kits;
    }

    public void applyTo(CustomCar car) {
        for (String kit : kits) {
            car.addBodyKit(kit);
        }
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return displayName + " (" + String.join(", ", kits) + ")";
    }

    public static BodyKitModel fromChoice(int choice) {
        if (choice < 1 || choice > values().length) {
            return null;
        }
        return values()[choice - 1];
    }
}
