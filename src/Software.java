/**
 * PACKAGE_NAME
 * Nombre_project: Computer_SImulator
 * Software
 * Created by: cide
 * Date : 6/12/20
 * Description:
 **/
public class Software {
    private String softwareName;
    private String softwareVersion;
    private double softwareSpaceRequirement ;
    private double softwareRamMemoryRequirement;
//Constructor
    public Software (String softwareName , String softwareVersion , double  softwareRamMemoryRequirement , double  softwareSpaceRequirement){
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
        this.softwareRamMemoryRequirement = softwareRamMemoryRequirement;
        this.softwareSpaceRequirement = softwareSpaceRequirement;
    }
    // get y setters
    public String getSoftwareName() {
        return this.softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public int getSoftwareSpaceRequirement() {
        return (int) softwareSpaceRequirement;
    }
    public void setSoftwareSpaceRequirement(double softwareSpaceRequirement) {
        this.softwareSpaceRequirement = softwareSpaceRequirement;
    }
    public int getSoftwareRamMemoryRequirement() {
        return (int) softwareRamMemoryRequirement ;
    }
    public void setSoftwareRamMemoryRequirement(double softwareRamMemoryRequirement) {
        this.softwareRamMemoryRequirement = softwareRamMemoryRequirement;
    }


}
