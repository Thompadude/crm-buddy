package companies;

import java.util.ArrayList;

public class Journal {

    private ArrayList<String> protocol;

    public Journal(ArrayList<String> protocol) {
        this.protocol = protocol;
    }

    public ArrayList<String> getProtocol() {
        return protocol;
    }

}
