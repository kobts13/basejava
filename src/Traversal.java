import java.io.File;

public class Traversal {
    public static void main(String[] args) {
        File project = new File(".");
        bypass(project);
    }

    private static void bypass(File file) {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    System.out.println(f.getName());
                    bypass(f);
                }
            }
        }
    }
}
