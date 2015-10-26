package FileManage;


import companies.MyCompany;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveToFile {

    private String filePath;
    private FileOutputStream fileout;
    private ObjectOutputStream objout;

    public SaveToFile(MyCompany myCompany, String filePath){

        this.filePath = filePath;

        //Denna �r just nu satt till den h�r datorns location och skall �ndras (kanske universiell metod)


        try{
            fileout = new FileOutputStream(filePath);
            objout = new ObjectOutputStream(fileout);

            objout.writeObject(myCompany);

        }catch(Exception ex){

            System.out.println(ex);
        }


    }
}
