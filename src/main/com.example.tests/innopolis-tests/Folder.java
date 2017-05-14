import java.io.File;
import java.util.ArrayList;

/**
 * Created by marina on 05.05.2017.
 */
public class Folder {
    private String directory;
    Folder(String directory) {
        this.directory = directory;
    }

    //метод получения вложенных каталогов и файлов
    protected Folder[] getSubfolders(File dir) throws MessageException {
        // определяем объект для каталога
        File[] fileArray= dir.listFiles();
        ArrayList<Folder> folderArrayList = new ArrayList<Folder>();
        Folder[] folders;

        // если объект представляет каталог
        if(dir.isDirectory())
        {
            // получаем все вложенные объекты в каталоге
            for(File item : fileArray){
                if(item.isDirectory()){
                    folderArrayList.add(new Folder(item.getName()));
                    getSubfolders(item);
                }
            }
        }
        return folderArrayList.toArray(new Folder[folderArrayList.size()]);
    }
    protected File[] getFiles() throws MessageException {
        File file = new File(directory);
        File []fList = file.listFiles();
        return fList;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

}
