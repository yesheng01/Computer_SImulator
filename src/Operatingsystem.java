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
    private ArrayList <Software> osSoftware;
    private Computer osComputer;

    public Operatingsystem(String osName, String osVersion, String osArchitecture, boolean osOnlyCommand, int osSpaceRequirement, int osRamMemoryRequirement) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.osArchitecture = osArchitecture;
        this.osOnlyCommand = osOnlyCommand;
        this.osRamMemoryRequirement = osRamMemoryRequirement;
        this.osSpaceRequirement = osSpaceRequirement;
        osSoftware = new ArrayList<Software>();

    }
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
        return osRamMemoryRequirement * 1024;
    }
    public void setOsRamMemoryRequirement(){
        this.osRamMemoryRequirement = osRamMemoryRequirement;
    }
    public void setComputer(Computer computer){
        this.osComputer = computer;
    }

    public ArrayList<Software> getOsSoftware() {
        return osSoftware;
    }


    private boolean checkDiskSpace(int spaceToBeSet){
        if(spaceToBeSet < this.osComputer.getMaxHardDisk() && (this.osComputer.getCurrentHardDisk() + spaceToBeSet) <= this.osComputer.getMaxHardDisk()){
            return true;
        } else {
            return false;
        }
    }

    private boolean checkRamSpace(int spaceToBeSet){
        if(spaceToBeSet < this.osComputer.getMaxRamMemory() && (this.osComputer.getCurrentRamMemory() + spaceToBeSet) <= this.osComputer.getMaxRamMemory()){
            return true;
        } else {
            return false;
        }
    }

    public void installApplication(Software app) throws Exception {
        if(this.osSoftware.contains(app)){
            throw new Exception("App already exists.");
        } else if(checkDiskSpace(app.getSoftwareSpaceRequirement())){
            this.osComputer.updateDriveSpace(app.getSoftwareSpaceRequirement(),"-");
            this.osSoftware.add(app);
        } else {
            throw new Exception("Error.");
        }
    }

    // Method for uninstalling application, update computer requirements and software list.
    public void uninstallApplication(Software app) throws Exception {
        if(this.osSoftware.contains(app)){
            if(app.isOpen()){
                this.closeApplication(app);
            }
            this.osComputer.updateDriveSpace(app.getSoftwareSpaceRequirement(), "+");
            this.osSoftware.remove(app);
        } else {
            throw new Exception("Software isn't installed.");
        }
    }

    // Method for opening an application and update the ram space.
    public void openApplication(Software app) throws Exception {
        if(checkRamSpace(app.getSoftwareRamMemoryRequirement())){
            try {
                app.openApp();
            } catch (Exception e){
                e.getMessage();
            }
            this.osComputer.updateRamSpace(app.getSoftwareRamMemoryRequirement(),"-");
        } else {
            throw new Exception("RAM requirement not satisfied.");
        }
    }

    // Method for closing an application and update the ram space.
    public void closeApplication(Software app){
        try {
            app.closeApp();
        } catch (Exception e){
            e.getMessage();
        }
        this.osComputer.updateRamSpace(app.getSoftwareRamMemoryRequirement(),"+");
    }



}

