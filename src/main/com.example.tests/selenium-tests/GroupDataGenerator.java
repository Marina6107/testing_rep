/**
 * Created by marina on 14.05.2017.
 */

import common.LoginForm;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupDataGenerator {
    //static Random rnd = new Random();

/*
    @DataProvider(name = "randomGroups")
    public static Iterator<Object[]> generateRandomGroups() {
        List<LoginForm> groups = new GroupDataGenerator().generateRandomGroupList(5);
        List<Object[]> list = new ArrayList<Object[]>();
        for (LoginForm group : groups) {
            list.add(new Object[]{group});
        }
        return list.iterator();
    }
*/

    @DataProvider(name = "groupsFromFile")
    public static Iterator<Object[]> loadGroupsFromFile() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader("groups.dat"));
        String line = reader.readLine();
        while (line != null) {
            String[] parts = line.split("/t");
            LoginForm loginForm = new LoginForm()
                    .setUsername(parts[0])
                    .setPassword(parts[1]);
            list.add(new Object[]{loginForm});
            line = reader.readLine();
        }
        return list.iterator();
    }

/*
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Specify two parameters: file and count");
            return;
        }
        String file = args[0];
        int count = Integer.parseInt(args[1]);
        try {
            new GroupDataGenerator().generateDataToFile(file, count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

/*
    private void generateDataToFile(String fileName, int count) throws IOException {
        List<LoginForm> groups = generateRandomGroupList(count);
        File file = new File(fileName);
        if (file.exists()) {
            //file.delete();
            System.out.println("File exists, stop generator");
            return;
        }
        FileWriter writer = new FileWriter(file);
        for (LoginForm group : groups) {
            writer.write(group.password + "\t" + group.header + "\t" + group.footer + "\n");
        }
        writer.close();
    }
*/

/*
    private List<LoginForm> generateRandomGroupList(int count) {
        List<LoginForm> list = new ArrayList<LoginForm>();
        for (int i = 0; i < count; i++) {
            LoginForm group = new LoginForm()
                    .setPassword("password"+rnd.nextInt())
                    .setHeader("header"+rnd.nextInt())
                    .setFooter("footer"+rnd.nextInt());
            list.add(group);
        }
        return list;
    }
*/

}
