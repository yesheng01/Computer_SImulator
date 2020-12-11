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
        Computer c1 = new Computer("HP", 4.0, 100);

        // Se crea el sistema operativo
        Operatingsystem SO = new Operatingsystem("Windows Pro", "10", "x64", false, 20, 2);
        // Creas la aplicacion
        Software s1, s2;
        s1 = new Software("Photoshop", "1.0", 1, 1);
        s2 = new Software("OpenOffice", "10", 1, 6);
        // Methods
        //Instalar el sistema operativo
        try {
            c1.installOperatingSystem(SO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Instalamos el Software 1 al ordenador creada
        if (c1.getHardDisk()>s1.getSoftwareSpaceRequirement()&&c1.getRamMemory()>s1.getSoftwareRamMemoryRequirement()){
            c1.getOperatingSystem().installSoftware(s1);
            c1.setHardDisk(c1.getHardDisk()-s1.getSoftwareSpaceRequirement());
            c1.setRamMemory(c1.getRamMemory()-s1.getSoftwareRamMemoryRequirement());
        }else {
            System.out.println("No hay espacio");
        }
        //Instalamos el Software 2 al ordenador creada
        if (c1.getHardDisk()>=s2.getSoftwareSpaceRequirement()&&c1.getRamMemory()>=s2.getSoftwareRamMemoryRequirement()){
            c1.getOperatingSystem().installSoftware(s2);
            c1.setHardDisk(c1.getHardDisk()-s2.getSoftwareSpaceRequirement());
            c1.setRamMemory(c1.getRamMemory()-s2.getSoftwareRamMemoryRequirement());
        }else {
            System.out.println("No hay espacio");
        }

        //Enseñamos los programas que hemos creado
        System.out.println("Se ha instalado los siguientes programas:" + "\n" + s1.getSoftwareName() + "\n" + s2.getSoftwareName() + "\n");

        //Se enseña con los metodos dadas sin formatear
        System.out.println("formatea.");

        //Se muestra el ordenador
        System.out.println(c1.toString() + "\n");
        // Desinstalamos el software
        c1.getOperatingSystem().uninstallSoftware(s1);
        c1.getOperatingSystem().uninstallSoftware(s2);
        c1.setHardDisk(c1.getHardDisk()+s2.getSoftwareSpaceRequirement());
        c1.setRamMemory(c1.getRamMemory()+s2.getSoftwareRamMemoryRequirement());
        c1.setHardDisk(c1.getHardDisk()+s1.getSoftwareSpaceRequirement());
        c1.setRamMemory(c1.getRamMemory()+s1.getSoftwareRamMemoryRequirement());
        //Formateamos
        c1.formatSystem();
        //Muestra lo formateado
        System.out.println("formateado.");
        System.out.println(c1.toString() +"\n");
    }
}
