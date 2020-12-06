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
        // Computer
        Computer c1 = new Computer("HP", 4096, 100000);

        // Windows
        Operatingsystem windows = new Operatingsystem("windows", "10", "x64", false, 20, 2);
        // Applications
        Software s1, s2;
        s1 = new Software("Word", "1.0", 0.5f, 1);
        s2 = new Software("OpenOffice", "10", 0.2f, 0.6f);

        // Install Operative System in Computer.
        try {
            c1.installOperatingSystem(windows);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Install Applications in Operative System.
        try {
            windows.installApplication(s1);
            windows.installApplication(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            windows.uninstallApplication(windows.getOsSoftware().get(windows.getOsSoftware().indexOf(s2)));
        } catch (Exception e) {
            e.getMessage();
        }

        // Open or close applications
        try {
            windows.openApplication(windows.getOsSoftware().get(windows.getOsSoftware().indexOf(s1)));
            windows.openApplication(windows.getOsSoftware().get(windows.getOsSoftware().indexOf(s2)));
        } catch (Exception e) {
            e.getMessage();
        }

        // Before formatting.
        System.out.println("Before formatting.");
        System.out.println(c1.toString() + "\n\n");

        c1.formatSystem();

        // After formatting.
        System.out.println("After formatting.");
        System.out.println(c1.toString() + "\n\n");
        System.out.println("Programas:" + "\n\n" + s1.getSoftwareName() + "\n\n" + s2.getSoftwareName());

    }
}
