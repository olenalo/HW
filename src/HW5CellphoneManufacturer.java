/**
 * HW5.1 by OPersian.
 *
 * Cellphone from manufacturer perspective.
 *
 * In this model, we only consider (some) cellphone parts.
 *
 */

public class HW5CellphoneManufacturer {
    private String modelNumber; // e.g. "G-930"
    private String architecture; // e.g "Modular", "Solid"

    // TODO: create a dedicated class for parts (encapsulating model type, price, and manufacturer)
    private String corpusMaterialType; // e.g. Aluminium, Stainless Steel
    private double corpusMaterialPrice; // USD 30-40
    private String corpusMaterialManufacturer; // e.g. cellphone manufacturer themselves

    private String chipsetModel;  // e.g. "Exinos 9595", "Kirin 8810", "Qualcom Snapdragon 870",
    private double chipsetPrice; // USD 100-150
    private String chipsetManufacturer; // e.g. Samsung, Huawei

    private String memoryChipModel;  // e.g. "MC-30"
    private double memoryChipPrice; // USD 30
    private String memoryChipManufacturer; // e.g. Samsung, Hynix

    private String displayType; // e.g. AMOLED, LCD, IPS
    private double displayPrice; // USD 50-100
    private String displayManufacturer; //  e.g. Samsung, Phillips, LG

    private String batteryType; // e.g. Li-ion, Li-pol
    private double batteryPrice; // USD 5-20
    private String batteryManufacturer;  // e.g. Phillips

    private String mainCameraModel;  // e.g. "BC-24"
    private double mainCameraPrice;  // USD 10-50
    private String mainCameraManufacturer;  // e.g. Sony

    private String frontCameraModel;  // e.g. "BC-24"
    private double frontCameraPrice;  // USD 10-30
    private String frontCameraManufacturer; // e.g. Sony

    public HW5CellphoneManufacturer(
        String modelNumber,
        String architecture,
        String corpusMaterialType,
        double corpusMaterialPrice,
        String corpusMaterialManufacturer,
        String chipsetModel,
        double chipsetPrice,
        String chipsetManufacturer,
        String memoryChipModel,
        double memoryChipPrice,
        String memoryChipManufacturer,
        String displayType,
        double displayPrice,
        String displayManufacturer,
        String batteryType,
        double batteryPrice,
        String batteryManufacturer,
        String mainCameraModel,
        double mainCameraPrice,
        String mainCameraManufacturer,
        String frontCameraModel,
        double frontCameraPrice,
        String frontCameraManufacturer
    ) {
        this.modelNumber = modelNumber;
        this.architecture = architecture;
        this.corpusMaterialType = corpusMaterialType;
        this.corpusMaterialPrice = corpusMaterialPrice;
        this.corpusMaterialManufacturer = corpusMaterialManufacturer;
        this.chipsetModel = chipsetModel;
        this.chipsetPrice = chipsetPrice;
        this.chipsetManufacturer = chipsetManufacturer;
        this.memoryChipModel = memoryChipModel;
        this.memoryChipPrice = memoryChipPrice;
        this.memoryChipManufacturer = memoryChipManufacturer;
        this.displayType = displayType;
        this.displayPrice = displayPrice;
        this.displayManufacturer = displayManufacturer;
        this.batteryType = batteryType;
        this.batteryPrice = batteryPrice;
        this.batteryManufacturer = batteryManufacturer;
        this.mainCameraModel = mainCameraModel;
        this.mainCameraPrice = mainCameraPrice;
        this.mainCameraManufacturer = mainCameraManufacturer;
        this.frontCameraModel = frontCameraModel;
        this.frontCameraPrice = frontCameraPrice;
        this.frontCameraManufacturer = frontCameraManufacturer;
    }

    @Override
    public String toString() {
        return this.modelNumber + " " + this.architecture;
    }

    public String describePartsSuppliers() {
        return "Display Manufacturer: " + this.displayManufacturer + "\n" +
                "Battery Manufacturer: " + this.batteryManufacturer + "\n" +
                "Main Camera Manufacturer: " + this.mainCameraManufacturer + "\n" +
                "Front Camera Manufacturer: " + this.frontCameraManufacturer + "\n" +
                "Corpus Material Manufacturer: " + this.corpusMaterialManufacturer + "\n" +
                "Chipset Manufacturer: " + this.chipsetManufacturer + "\n" +
                "Memory Chip Manufacturer: " + this.memoryChipManufacturer + "\n";
    }

    public String describeParts() {
        return "Display Type: " + this.displayType + "\n" +
                "Battery Type: " + this.batteryType + "\n" +
                "Main Camera Model: " + this.mainCameraModel + "\n" +
                "Front Camera Model: " + this.frontCameraModel + "\n" +
                "Corpus Material Type: " + this.corpusMaterialType + "\n" +
                "Chipset Model: " + this.chipsetModel + "\n" +
                "Memory Chip Model: " + this.memoryChipModel + "\n";
    }

    public void assembleCellPhone() {
        System.out.println("Assembling " + this + ": \n\n" + this.describeParts());
    }

    public double definePartsCosts() {
        return this.corpusMaterialPrice + this.chipsetPrice + this.memoryChipPrice + this.displayPrice +
                this.batteryPrice + this.mainCameraPrice + this.frontCameraPrice;
    }

    public static void main(String[] args) {
        HW5CellphoneManufacturer cellphone = new HW5CellphoneManufacturer(
            "G-930",
            "Modular",
            "Aluminium",
            40,
            "Samsung",
            "Exinos 9595",
            100,
            "Samsung",
            "MC-30",
            30,
            "Samsung",
            "AMOLED",
            70,
            "Samsung",
            "Li-ion",
            15,
            "Phillips",
            "BC-24",
            50,
            "Sony",
            "BC-24",
            30,
            "Sony"
        );
        System.out.println("Cellphone: " + cellphone);
        System.out.println("-------------------------------------------");
        System.out.println(cellphone.describePartsSuppliers());
        System.out.println("-------------------------------------------");
        cellphone.assembleCellPhone();
        System.out.println("-------------------------------------------");
        System.out.println("Parts costs are: USD " + cellphone.definePartsCosts());

    }
}
