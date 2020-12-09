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
        Computer c1 = new Computer("HP", 4096, 100000);

        // Se crea el sistema operativo
        Operatingsystem SO = new Operatingsystem("windows", "10", "x64", false, 20, 2);
        // Creas la aplicacion
        Software s1, s2;
        s1 = new Software("Photoshop", "1.0", 0.5, 1);
        s2 = new Software("OpenOffice", "10", 0.2, 0.6);
        // Methods
        try {
            c1.installOperatingSystem(SO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("formatea.");
        System.out.println(c1.toString() + "\n");

        c1.formatSystem();

        System.out.println("formateado.");
        System.out.println(c1.toString() + "\n");
        System.out.println("Programas:" + "\n\n" + s1.getSoftwareName() + ":" +  s1.getSoftwareRamMemoryRequirement() + "\n\n" + s2.getSoftwareName() + ":" + s2.getSoftwareRamMemoryRequirement());

    }
}
