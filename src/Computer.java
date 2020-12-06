/**
 * PACKAGE_NAME
 * Nombre_project: Computer_SImulator
 * Computer
 * Created by: cide
 * Date : 6/12/20
 * Description:
 **/
public class Computer {
    private String name;
    private int ramMemory;
    private int HardDisk;
    private int maxRamMemory;
    private int maxHardDisk;
    private Operatingsystem operatingSystem;

    public Computer(String name, int ramMemory, int HardDisk) {
        this.name = name;
        this.maxRamMemory = ramMemory;
        this.ramMemory = maxRamMemory;
        this.maxHardDisk = HardDisk;
        this.HardDisk = maxHardDisk;
    }


    public Operatingsystem getOperatingSystem() {
        return this.operatingSystem;
    }

    public int getCurrentRamMemory() {
        return ramMemory;
    }

    public int getCurrentHardDisk() {
        return HardDisk;
    }

    public int getMaxRamMemory() {
        return maxRamMemory;
    }

    public int getMaxHardDisk() {
        return maxHardDisk;
    }

    public void installOperatingSystem(Operatingsystem os) throws Exception {
        if (this.operatingSystem == null && this.HardDisk >= os.getOsSpaceRequirement()) {
            // Assign physic computer to an operative system.
            os.setComputer(this);
            // Assign the operative system in the
            this.operatingSystem = os;
            // Update the drive space in the computer.
            updateDriveSpace(os.getOsSpaceRequirement(), "-");
        } else {
            // User cannot install more than one operative system in the computer.(Rule)
            throw new Exception("Existing operating system.");
        }
    }

    public void updateDriveSpace(int spaceToUpdate, String op) {
        switch (op) {
            case "+" -> {
                this.HardDisk += spaceToUpdate;
            }
            case "-" -> {
                this.HardDisk -= spaceToUpdate;
            }
        }
    }

    public void updateRamSpace(int spaceToUpdate, String op) {
        switch (op) {
            case "+" -> {
                this.ramMemory += spaceToUpdate;
            }
            case "-" -> {
                this.ramMemory -= spaceToUpdate;
            }
        }
    }

    public void formatSystem() {
        this.operatingSystem = null;
        this.HardDisk = this.maxHardDisk;
        this.ramMemory = this.maxRamMemory;
    }

    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", maxRamMemory=" + maxRamMemory +
                ", maxHardDisk=" + maxHardDisk +
                ", Free ramMemory=" + ramMemory +
                ", Free hardDisk=" + HardDisk +
                ", operativeSystem=" + operatingSystem +
                '}';
    }
}

