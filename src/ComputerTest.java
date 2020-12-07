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
        Computer c1 = new Computer("HP", 4096, 1000000);

        // Se crea el sistema operativo
        Operatingsystem SO = new Operatingsystem("windows", "10", "x64", false, 20, 2);
        // Creas la aplicacion
        Software s1, s2;
        s1 = new Software("Photoshop", "1.0", 0.5f, 1);
        s2 = new Software("OpenOffice", "10", 0.2f, 0.6f);
        // Methods
        try {
            c1.installOperatingSystem(SO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            SO.installApplication(s1);
            SO.installApplication(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            SO.uninstallApplication(SO.getOsSoftware().get(SO.getOsSoftware().indexOf(s2)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            SO.openApplication(SO.getOsSoftware().get(SO.getOsSoftware().indexOf(s1)));
            SO.openApplication(SO.getOsSoftware().get(SO.getOsSoftware().indexOf(s2)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("formatea.");
        System.out.println(c1.toString() + "\n");

        c1.formatSystem();

        System.out.println("formateado.");
        System.out.println(c1.toString() + "\n");
        System.out.println("Programas:" + "\n\n" + s1.getSoftwareName() + "\n\n" + s2.getSoftwareName());

    }
}
