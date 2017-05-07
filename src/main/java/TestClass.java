import java.io.File;

/**
 * Created by marina on 05.05.2017.
 */
//Напишите программу, которая ищет файл с заданным именем в указанном каталоге и всех вложенных подпапках
public class TestClass {
    public static void main(String [] args) throws MessageException {
        Folder folder = new Folder("C:\\DirA");
        File file = find(folder, "2.txt");
        System.out.println("Название файла: " + file.getName() + " /n Название дирректории" + file.getAbsolutePath());
    }

    private static File find(Folder folder, String name) throws MessageException {
        Folder[] subfolders = folder.getSubfolders(new File(folder.getDirectory()));
        File[] files = folder.getFiles();
        File res;
        for (File file:files) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (name.equals(fileName)) {
                    return file;
                }
            }
        }

        if (subfolders != null) {
            for (Folder folderItem:subfolders) {
                String pathDirectory = folder.getDirectory() + "\\" + folderItem.getDirectory();
                folderItem.setDirectory(pathDirectory);
                File file = find(folderItem, name);
                if (file!=null) return file;
            }
        }
        return null;

    }
}
