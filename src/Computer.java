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

    //Este metodo lo utilizamos para instalar el sistema operativo , por lo que le permite añadir el OS al sistema operativo.
    //Utilizamos throws Exception para si tiene un sistema operativo lanza el exception , como lo vemos en el test y se instala,
    public void installOperatingSystem(Operatingsystem operatingSystem) throws Exception {
        if (this.operatingSystem == null && this.HardDisk >= operatingSystem.getOsSpaceRequirement()) {
            operatingSystem.setComputer(this);
            this.operatingSystem = operatingSystem;
            updateDriveSpace(operatingSystem.getOsSpaceRequirement(), "-");
            updateRamSpace(operatingSystem.getOsRamMemoryRequirement(), "-");
        } else {
            throw new Exception("Sistema Operativo  existe.");
        }
    }
//Metodo para actualizar el espacio del sistema
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
    //Actualiza la Ram
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

