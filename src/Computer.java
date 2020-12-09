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
//constructor
    public Computer(String name, int ramMemory, int HardDisk) {
        this.name = name;
        this.maxRamMemory = ramMemory;
        this.ramMemory = maxRamMemory;
        this.maxHardDisk = HardDisk;
        this.HardDisk = maxHardDisk;
    }

//gets

    public Operatingsystem getOperatingSystem() {
        return this.operatingSystem;
    }

    public int getRamMemoryActual() {
        return ramMemory;
    }

    public int getHardDiskActual() {
        return HardDisk;
    }

    public int getMaxRamMemory() {
        return maxRamMemory;
    }

    public int getMaxHardDisk() {
        return maxHardDisk;
    }
//methods
    public void installOperatingSystem(Operatingsystem os) throws Exception {
        if (this.operatingSystem == null && this.HardDisk >= os.getOsSpaceRequirement()) {
            os.setComputer(this);
            this.operatingSystem = os;
            updateDriveSpace(os.getOsSpaceRequirement(), "-");
        } else {
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

//Muestra los atributos seleccionados
    public String toString() {
        return "Ordenador:" + "Nombre de ordenador='" + name + '\'' + ", maxRamMemory=" + maxRamMemory + ", maxHardDisk=" + maxHardDisk + ", ramMemoryLibre=" + ramMemory + ", hardDiskLibre=" + HardDisk + ", operativeSystem=" + operatingSystem;
    }
//Metodo para formatear
    public void formatSystem() {
        this.HardDisk = this.maxHardDisk;
        this.ramMemory = this.maxRamMemory;
        this.operatingSystem = null;
    }

}

