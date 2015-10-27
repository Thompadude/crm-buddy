package companies;

import java.util.ArrayList;

public class Journal implements java.io.Serializable {

    private ArrayList<String> protocol;

    public Journal(ArrayList<String> protocol) {
        this.protocol = protocol;
    }

    public ArrayList<String> getProtocol() {
        return protocol;
    }

}