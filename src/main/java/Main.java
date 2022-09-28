import models.Building;
import services.BuildingFactory;
import services.LiftService;

public class Main {
    public static void main(String[] args) {
        Building building = BuildingFactory.build();
        LiftService.run(building);
    }
}
