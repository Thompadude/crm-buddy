package companies;

import java.util.ArrayList;

public class Journal {

    private String topic;
    private ArrayList<String> protocol;

    public Journal(String topic, ArrayList<String> protocol) {
        this.topic = topic;
        this.protocol = protocol;
    }

    public String getTopic() {
        return topic;
    }

    public ArrayList<String> getProtocol() {
        return protocol;
    }

}
