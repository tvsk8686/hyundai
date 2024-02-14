@Controller
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "index";
    }

    @GetMapping("/vehicle/{id}")
    public String vehicle(@PathVariable("id") Long id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicle";
    }
}