package FileManage;

import companies.MyCompany;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ReadFromFile {

    private String filePath;
    private FileInputStream fileIn;
    private ObjectInputStream objIn;


    public ReadFromFile(String filePath){

        this.filePath = filePath;
        //Denna är just nu satt till den här datorns location och skall ändras (kanske universiell metod)

    }

    public MyCompany readCompany(){

        companies.MyCompany mycompany = new MyCompany(null, null);

        try{
            fileIn = new FileInputStream(filePath);
            objIn = new ObjectInputStream(fileIn);

            mycompany = (MyCompany)objIn.readObject();

        }catch(Exception e){
            System.out.println(e);
            return null;
        }

        return mycompany;
    }
}
