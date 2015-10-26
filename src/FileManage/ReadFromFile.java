package FileManage;

import companies.MyCompany;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadFromFile {

    private String filePath;
    private FileInputStream fileIn;
    private ObjectInputStream objIn;

    public ReadFromFile(String filePath) {
        this.filePath = filePath;
    }

    public MyCompany readCompany(MyCompany myCompany) {

        try {
            fileIn = new FileInputStream(filePath);
            objIn = new ObjectInputStream(fileIn);

            myCompany = (MyCompany) objIn.readObject();

        } catch (Exception e) {
            System.out.println("Couldn't load any file.");
            myCompany = null;
        }
        return myCompany;
    }
}
