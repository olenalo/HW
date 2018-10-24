/**
 * HW5.1 by OPersian.
 *
 * Cellphone from end user perspective.
 *
 */

public class HW5CellphoneUser {

    // Marketing properties
    private double price; // USD
    private int warrantyMonths;
    private String brand; // Manufacturer's brand
    private String consumerFacingModel; // e.g. Galaxy S7
    private String phoneColor; // e.g. Navy Blue, Space Grey

    // Technical properties
    private double batteryLifeHours;
    private double mainCameraMegaPixelsQuantity; // Responsible for camera quality
    private double frontFacingCameraMegaPixelsQuantity; // Selfie camera
    private double screenDiagonal; // inches
    private int coresQuantity;
    private String corpusMaterial; // e.g. Aluminium, Plastic, Glass, Stainless Steel


    public HW5CellphoneUser(
        double price,
        int warrantyMonths,
        String brand,
        String consumerFacingModel,
        String phoneColor,
        double batteryLifeHours,
        double mainCameraMegaPixelsQuantity,
        double frontFacingCameraMegaPixelsQuantity,
        double screenDiagonal,
        int coresQuantity,
        String corpusMaterial
    ) {
        this.price = price;
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
        this.consumerFacingModel = consumerFacingModel;
        this.phoneColor = phoneColor;
        this.batteryLifeHours = batteryLifeHours;
        this.mainCameraMegaPixelsQuantity = mainCameraMegaPixelsQuantity;
        this.frontFacingCameraMegaPixelsQuantity = frontFacingCameraMegaPixelsQuantity;
        this.screenDiagonal = screenDiagonal;
        this.coresQuantity = coresQuantity;
        this.corpusMaterial = corpusMaterial;
    }

    @Override
    public String toString() {
        return this.brand + " " + this.consumerFacingModel + " " + this.phoneColor;
    }

    public String describeTechnicalCharacteristics() {
        return "Battery Life: " + this.batteryLifeHours+ " hours\n" +
                "Screen Diagonal: " + this.screenDiagonal + " inches\n" +
                "Cores Quantity: " + this.coresQuantity + "\n" +
                "Corpus Material: " + this.corpusMaterial + "\n" +
                "Front Facing Camera Quality: " + this.frontFacingCameraMegaPixelsQuantity + " MP\n" +
                "Main Facing Camera Quality: " + this.mainCameraMegaPixelsQuantity + " MP";
    }

    public void buyPhone() {
        System.out.println("Buying " + this + " for USD " + this.price);
    }

    public void callSomeone() {
        System.out.println("Calling someone from " + this);
    }

    public void takeSelfie() {
        System.out.println("Taking selfie with " + this + " " + this.frontFacingCameraMegaPixelsQuantity + " MP");
    }

    public void takePhoto() {
        System.out.println("Taking photo with " + this + " " + this.mainCameraMegaPixelsQuantity + " MP");
    }

    public void repairPhone() {
        // TODO: calculate the remaining warranty months (datetime, ugh...)
        System.out.println("Repairing the " + this + " having warranty of " + this.warrantyMonths + " months");
    }

    public static void main(String[] args) {
        HW5CellphoneUser cellphone = new HW5CellphoneUser(
            700,
            24,
            "Samsung",
            "Galaxy S7",
            "Space Grey",
            24,
            12,
            5,
            5.1,
            8,
            "Glass"
        );
        System.out.println("Cellphone: " + cellphone);
        System.out.println("-------------------------------------------");
        System.out.println(cellphone.describeTechnicalCharacteristics());
        System.out.println("-------------------------------------------");
        cellphone.buyPhone();
        cellphone.callSomeone();
        cellphone.takeSelfie();
        cellphone.takePhoto();
        cellphone.repairPhone();
    }


}
