/**
 * PACKAGE_NAME
 * Nombre_project: Computer_SImulator
 * Operatingsystem
 * Created by: cide
 * Date : 6/12/20
 * Description:
 **/
import java.util.ArrayList;
import java.util.Scanner;
public class Operatingsystem {
    private String osName;
    private String osVersion;
    private String osArchitecture;
    private boolean osOnlyCommand;
    private int osSpaceRequirement;
    private int osRamMemoryRequirement;
    private ArrayList <Software> opSoftware;
    private Computer osComputer;


    //Constructor
    public Operatingsystem(String osName, String osVersion, String osArchitecture, boolean osOnlyCommand, int osSpaceRequirement, int osRamMemoryRequirement) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.osArchitecture = osArchitecture;
        this.osOnlyCommand = osOnlyCommand;
        this.osRamMemoryRequirement = osRamMemoryRequirement;
        this.osSpaceRequirement = osSpaceRequirement;
        this.opSoftware = new ArrayList<Software>();
    }
    //Gets and setters
    public String getOsName(){
        return this.osName;
    }
    public  void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion){
        this.osVersion = osVersion;
    }

    public String getOsArchitecture(){
        return osArchitecture;
    }

    public void setOsArchitecture(String osArchitecture){
        this.osArchitecture = osArchitecture;
    }

    public boolean isOsOnlyCommand(){
        return osOnlyCommand;
    }
    public void setOsOnlyCommand(boolean osOnlyCommand){
        this.osOnlyCommand = osOnlyCommand;
    }

    public int getOsSpaceRequirement(){
        return osSpaceRequirement * 1000;
    }

    public void setOsSpaceRequirement(){
        this.osSpaceRequirement = osSpaceRequirement;
    }
    public int getOsRamMemoryRequirement(){
        return osRamMemoryRequirement * 1000;
    }
    public void setOsRamMemoryRequirement(){
        this.osRamMemoryRequirement = osRamMemoryRequirement;
    }

    public Computer getOsComputer() {
        return osComputer;
    }

    public void setComputer(Computer computer){
        this.osComputer = computer;
    }

    public ArrayList<Software> getOsSoftware() {
        return opSoftware;
    }


    //Methods

    private boolean MiraRamSpace(int Espacio){
        if(Espacio < this.osComputer.getMaxRamMemory() && (this.osComputer.getRamMemoryActual() + Espacio) <= this.osComputer.getMaxRamMemory()){
            return true;
        } else {
            return false;
        }
    }

    private boolean MiraDiskSpace(int Espacio){
        if(Espacio < this.osComputer.getMaxHardDisk() && (this.osComputer.getHardDiskActual() + Espacio) <= this.osComputer.getMaxHardDisk()){
            return true;
        } else {
            return false;
        }
    }

    public void installApplication(Software aplicacion) throws Exception {
        if(this.opSoftware.contains(aplicacion)){
            throw new Exception("Existe");
        } else if(MiraDiskSpace(aplicacion.getSoftwareSpaceRequirement())){
            this.osComputer.updateDriveSpace(aplicacion.getSoftwareSpaceRequirement(),"-");
            this.opSoftware.add(aplicacion);
        } else {
            throw new Exception("Nada");
        }
    }

    public void uninstallApplication(Software aplicacion) throws Exception {
        if(this.opSoftware.contains(aplicacion)){
            this.osComputer.updateDriveSpace(aplicacion.getSoftwareSpaceRequirement(), "+");
            this.opSoftware.remove(aplicacion);
        } else {
            throw new Exception("No es instalado");
        }
    }


}

