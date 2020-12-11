/**
 * PACKAGE_NAME
 * Nombre_project: Computer_SImulator
 * ComputerTest
 * Created by: cide
 * Date : 6/12/20
 * Description:
 **/
public class ComputerTest {
    public static void main(String[] args) {
        // El Ordenador
        Computer c1 = new Computer("HP", 4, 100);

        // Se crea el sistema operativo
        Operatingsystem SO = new Operatingsystem("Windows Pro", "10", "x64", false, 20, 2);
        // Creas la aplicacion
        Software s1, s2;
        s1 = new Software("Photoshop", "1.0", 0.5, 1);
        s2 = new Software("OpenOffice", "10", 0.2, 6);
        // Methods
        try {
            c1.installOperatingSystem(SO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (c1.getHardDisk()>s1.getSoftwareSpaceRequirement()&&c1.getRamMemory()>s1.getSoftwareRamMemoryRequirement()){
            c1.getOperatingSystem().installSoftware(s1);
            c1.setHardDisk(c1.getHardDisk()-s1.getSoftwareSpaceRequirement());
            c1.setRamMemory(c1.getRamMemory()-s1.getSoftwareRamMemoryRequirement());
        }else {
            System.out.println("No hay espacio");
        }

        if (c1.getHardDisk()>s2.getSoftwareSpaceRequirement()&&c1.getRamMemory()>s2.getSoftwareRamMemoryRequirement()){
            c1.getOperatingSystem().installSoftware(s2);
            c1.setHardDisk(c1.getHardDisk()-s2.getSoftwareSpaceRequirement());
            c1.setRamMemory(c1.getRamMemory()-s2.getSoftwareRamMemoryRequirement());
        }else {
            System.out.println("No hay espacio");
        }
        System.out.println("Se ha instalado los siguientes programas:" + "\n" + s1.getSoftwareName() + "\n" + s2.getSoftwareName() + "\n");

        System.out.println("formatea.");
        System.out.println(c1.toString() + "\n");

        c1.getOperatingSystem().uninstallSoftware(s1);
        c1.getOperatingSystem().uninstallSoftware(s2);
        c1.setHardDisk(c1.getHardDisk()+s2.getSoftwareSpaceRequirement());
        c1.setRamMemory(c1.getRamMemory()+s2.getSoftwareRamMemoryRequirement());
        c1.setHardDisk(c1.getHardDisk()+s1.getSoftwareSpaceRequirement());
        c1.setRamMemory(c1.getRamMemory()+s1.getSoftwareRamMemoryRequirement());

        c1.format();

        System.out.println("formateado.");
        System.out.println(c1.toString() +"\n");
    }
}
