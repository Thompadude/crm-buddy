package FileManage;


import companies.MyCompany;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveToFile {

    private String filePath;
    private FileOutputStream fileOut;
    private ObjectOutputStream objOut;

    public SaveToFile(MyCompany myCompany, String filePath){

        this.filePath = filePath;

        try{
            fileOut = new FileOutputStream(filePath);
            objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(myCompany);

        }catch(Exception ex){
            System.out.println("Couldn't save to file!");
        }
    }
}
