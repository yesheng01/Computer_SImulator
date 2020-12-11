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
    private double ramMemory;
    private int HardDisk;
    private Operatingsystem operatingSystem;
//constructor
    public Computer(String name, double ramMemory, int HardDisk) {
        this.name = name;
        this.ramMemory = ramMemory;
        this.HardDisk = HardDisk;
    }

//gets

    public Operatingsystem getOperatingSystem() {
        return operatingSystem;
    }

    public String getName() {
        return name;
    }

    public double getRamMemory() {
        return ramMemory;
    }

    public int getHardDisk() {
        return HardDisk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRamMemory(double ramMemory) {
        this.ramMemory = ramMemory;
    }

    public void setHardDisk(int hardDisk) {
        this.HardDisk = hardDisk;
    }

    public void setOperatingSystem(Operatingsystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

//methods
    public void installOperatingSystem(Operatingsystem os) throws Exception {
        if (this.operatingSystem == null && this.HardDisk >= os.getOsSpaceRequirement()) {
            os.setComputer(this);
            this.operatingSystem = os;
            updateDriveSpace(os.getOsSpaceRequirement(), "-");
            updateRamSpace(os.getOsRamMemoryRequirement(), "-");
        } else {
            throw new Exception("Sistema Operativo  existe.");
        }
    }

    public void updateDriveSpace(int spaceToUpdate, String operativo) {
        switch (operativo) {
            case "+" -> {
                this.HardDisk += spaceToUpdate;
            }
            case "-" -> {
                this.HardDisk -= spaceToUpdate;
            }
        }
    }
    public void updateRamSpace(int spaceToUpdate, String operativo) {
        switch (operativo) {
            case "+" -> {
                this.ramMemory += spaceToUpdate;
            }
            case "-" -> {
                this.ramMemory -= spaceToUpdate;
            }
        }
    }

//Muestra los atributos seleccionados
    public String toString() {
        return "Ordenador:" + "Nombre de ordenador='" + name + '\'' + ", ramMemoryLibre=" + ramMemory + ", hardDiskLibre=" + HardDisk + ", operativeSystem=" + operatingSystem;
    }
//Metodo para formatear
    public void formatSystem(){
    this.HardDisk = HardDisk+operatingSystem.getOsSpaceRequirement();
    this.ramMemory = ramMemory+operatingSystem.getOsRamMemoryRequirement();
    this.operatingSystem=null;
}
}

