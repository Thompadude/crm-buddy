package FileManage;

import companies.MyCompany;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ReadFromFile {

    private String currentFilePath;
    private FileInputStream filein;
    private ObjectInputStream objin;


    public ReadFromFile(String filePath){

        this.currentFilePath = filePath;
        //Denna �r just nu satt till den h�r datorns location och skall �ndras (kanske universiell metod)
        filePath = "C:/mycompany/mycompany.dat";

    }

    public MyCompany readCompany(){

        companies.MyCompany mycompany = new MyCompany(null, null);

        try{
            filein = new FileInputStream(currentFilePath);
            objin = new ObjectInputStream(filein);

            mycompany = (MyCompany)objin.readObject();

        }catch(Exception e){
            System.out.println(e);
            return null;
        }

        return mycompany;
    }
}
