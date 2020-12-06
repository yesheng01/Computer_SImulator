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
    private float softwareSpaceRequirement ;
    private float softwareRamMemoryRequirement;
    private boolean Open = false;
//Constructor
    public Software (String softwareName , String softwareVersion , float softwareRamMemoryRequirement , float softwareSpaceRequirement){
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
        return (int) softwareSpaceRequirement * 1000 ;
    }

    public int getSoftwareRamMemoryRequirement() {
        return (int) softwareRamMemoryRequirement * 1024;
    }
    //Se abre el app
    public void openApp() throws Exception {
        if(this.Open){
            throw new Exception("App is already open.");
        } else{
            this.Open = true;
        }
    }
    //Se cierra el App
    public void closeApp() throws Exception {
        if(!this.Open){
            throw new Exception("App is already open.");
        } else{
            this.Open = false;
        }
    }

    public boolean isOpen(){
        return this.Open;
    }


}
