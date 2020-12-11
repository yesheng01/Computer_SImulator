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
        return osSpaceRequirement;
    }

    public void setOsSpaceRequirement(){
        this.osSpaceRequirement = osSpaceRequirement;
    }
    public int getOsRamMemoryRequirement(){
        return osRamMemoryRequirement ;
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

    public ArrayList<Software> getOpSoftware() {
        return opSoftware;
    }


    //Methods
    //Metodo con el arrayList , de forma ver que se añada el software o que se elimine de ella.

    public void installSoftware(Software opSoftware){
        this.opSoftware.add(opSoftware);
    }
    public void uninstallSoftware(Software opSoftware){
        this.opSoftware.remove(opSoftware);
    }
}

