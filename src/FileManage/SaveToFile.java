package FileManage;


import companies.MyCompany;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveToFile {

    private String filePath;
    private FileOutputStream fileout;
    private ObjectOutputStream objout;

    public SaveToFile(MyCompany mycompany, String filePath){

        this.filePath = filePath;

        //Denna är just nu satt till den här datorns location och skall ändras (kanske universiell metod)
        filePath = "C:/mycompany/mycompany.dat";


        try{
            fileout = new FileOutputStream(filePath);
            objout = new ObjectOutputStream(fileout);

            objout.writeObject(mycompany);

        }catch(Exception ex){

            System.out.println(ex);
        }


    }
}
